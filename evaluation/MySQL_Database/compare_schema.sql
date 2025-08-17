-- Compare two MySQL schemas for differences including tables, columns, indexes, constraints, default values, primary keys, foreign keys, auto increment, and not null constraints

-- First, define the two schemas you want to compare
SET @schema1 = 'media_wiki_1_36_4';
SET @schema2 = 'media_wiki_1_39_4';

-- Compare tables
SELECT 
    CONCAT('Table ', t1.table_name, ' exists in ', 
        IF(t2.table_name IS NULL, @schema1, @schema2),
        ' but not in ', 
        IF(t2.table_name IS NULL, @schema2, @schema1)
    ) AS 'Differences'
FROM 
    information_schema.tables t1
    LEFT JOIN information_schema.tables t2 ON t1.table_name = t2.table_name AND t2.table_schema = @schema2
WHERE 
    t1.table_schema = @schema1 AND t2.table_name IS NULL

UNION ALL

SELECT 
    CONCAT('Table ', t2.table_name, ' exists in ', @schema2, ' but not in ', @schema1) AS 'Differences'
FROM 
    information_schema.tables t2
WHERE 
    t2.table_schema = @schema2 AND NOT EXISTS (SELECT 1 FROM information_schema.tables WHERE table_schema = @schema1 AND table_name = t2.table_name);

-- Compare columns
SELECT 
    CONCAT('Column ', c1.column_name, ' in table ', c1.table_name, ' exists in ', 
        IF(c2.column_name IS NULL, @schema1, @schema2),
        ' but not in ', 
        IF(c2.column_name IS NULL, @schema2, @schema1)
    ) AS 'Differences'
FROM 
    information_schema.columns c1
    LEFT JOIN information_schema.columns c2 ON c1.table_name = c2.table_name AND c1.column_name = c2.column_name AND c2.table_schema = @schema2
WHERE 
    c1.table_schema = @schema1 AND c2.column_name IS NULL

UNION ALL

SELECT 
    CONCAT('Column ', c2.column_name, ' in table ', c2.table_name, ' exists in ', @schema2, ' but not in ', @schema1) AS 'Differences'
FROM 
    information_schema.columns c2
WHERE 
    c2.table_schema = @schema2 AND NOT EXISTS (SELECT 1 FROM information_schema.columns WHERE table_schema = @schema1 AND table_name = c2.table_name AND column_name = c2.column_name);

-- Compare indexes
SELECT 
    CONCAT('Index ', i1.index_name, ' on table ', i1.table_name, ' exists in ', 
        IF(i2.index_name IS NULL, @schema1, @schema2),
        ' but not in ', 
        IF(i2.index_name IS NULL, @schema2, @schema1)
    ) AS 'Differences'
FROM 
    information_schema.statistics i1
    LEFT JOIN information_schema.statistics i2 ON i1.table_name = i2.table_name AND i1.index_name = i2.index_name AND i2.table_schema = @schema2
WHERE 
    i1.table_schema = @schema1 AND i2.index_name IS NULL

UNION ALL

SELECT 
    CONCAT('Index ', i2.index_name, ' on table ', i2.table_name, ' exists in ', @schema2, ' but not in ', @schema1) AS 'Differences'
FROM 
    information_schema.statistics i2
WHERE 
    i2.table_schema = @schema2 AND NOT EXISTS (SELECT 1 FROM information_schema.statistics WHERE table_schema = @schema1 AND table_name = i2.table_name AND index_name = i2.index_name);

-- Compare constraints
SELECT 
    CONCAT('Constraint ', c1.constraint_name, ' on table ', c1.table_name, ' exists in ', 
        IF(c2.constraint_name IS NULL, @schema1, @schema2),
        ' but not in ', 
        IF(c2.constraint_name IS NULL, @schema2, @schema1)
    ) AS 'Differences'
FROM 
    information_schema.table_constraints c1
    LEFT JOIN information_schema.table_constraints c2 ON c1.table_name = c2.table_name AND c1.constraint_name = c2.constraint_name AND c2.table_schema = @schema2
WHERE 
    c1.table_schema = @schema1 AND c2.constraint_name IS NULL

UNION ALL

SELECT 
    CONCAT('Constraint ', c2.constraint_name, ' on table ', c2.table_name, ' exists in ', @schema2, ' but not in ', @schema1) AS 'Differences'
FROM 
    information_schema.table_constraints c2
WHERE 
    c2.table_schema = @schema2 AND NOT EXISTS (SELECT 1 FROM information_schema.table_constraints WHERE table_schema = @schema1 AND table_name = c2.table_name AND constraint_name = c2.constraint_name);

-- Compare default values
SELECT 
    CONCAT('Default value for column ', c1.column_name, ' in table ', c1.table_name, ' exists in ', 
        IF(c2.column_name IS NULL, @schema1, @schema2),
        ' but not in ', 
        IF(c2.column_name IS NULL, @schema2, @schema1)
    ) AS 'Differences'
FROM 
    (SELECT table_schema, table_name, column_name, column_default
    FROM information_schema.columns
    WHERE table_schema = @schema1
    UNION
    SELECT table_schema, table_name, column_name, column_default
    FROM information_schema.columns
    WHERE table_schema = @schema2) c1
    LEFT JOIN (SELECT table_schema, table_name, column_name, column_default
    FROM information_schema.columns
    WHERE table_schema IN (@schema1, @schema2)) c2
    ON c1.table_name = c2.table_name AND c1.column_name = c2.column_name
WHERE 
    c1.column_default != c2.column_default OR (c1.column_default IS NOT NULL AND c2.column_default IS NULL) OR (c1.column_default IS NULL AND c2.column_default IS NOT NULL);




-- Compare primary keys
SELECT 
    CONCAT('Primary key constraint ', p1.constraint_name, ' on table ', p1.table_name, ' exists in ', 
        IF(p2.constraint_name IS NULL, @schema1, @schema2),
        ' but not in ', 
        IF(p2.constraint_name IS NULL, @schema2, @schema1)
    ) AS 'Differences'
FROM 
    information_schema.key_column_usage p1
    LEFT JOIN information_schema.key_column_usage p2 ON p1.table_name = p2.table_name AND p1.constraint_name = p2.constraint_name AND p2.table_schema = @schema2
WHERE 
    p1.table_schema = @schema1 AND p2.constraint_name IS NULL

UNION ALL

SELECT 
    CONCAT('Primary key constraint ', p2.constraint_name, ' on table ', p2.table_name, ' exists in ', @schema2, ' but not in ', @schema1) AS 'Differences'
FROM 
    information_schema.key_column_usage p2
WHERE 
    p2.table_schema = @schema2 AND NOT EXISTS (SELECT 1 FROM information_schema.key_column_usage WHERE table_schema = @schema1 AND table_name = p2.table_name AND constraint_name = p2.constraint_name);

-- Compare foreign keys
SELECT 
    CONCAT('Foreign key constraint ', f1.constraint_name, ' on table ', f1.table_name, ' exists in ', 
        IF(f2.constraint_name IS NULL, @schema1, @schema2),
        ' but not in ', 
        IF(f2.constraint_name IS NULL, @schema2, @schema1)
    ) AS 'Differences'
FROM 
    information_schema.key_column_usage f1
    LEFT JOIN information_schema.key_column_usage f2 ON f1.table_name = f2.table_name AND f1.constraint_name = f2.constraint_name AND f2.table_schema = @schema2
WHERE 
    f1.table_schema = @schema1 AND f2.constraint_name IS NULL

UNION ALL

SELECT 
    CONCAT('Foreign key constraint ', f2.constraint_name, ' on table ', f2.table_name, ' exists in ', @schema2, ' but not in ', @schema1) AS 'Differences'
FROM 
    information_schema.key_column_usage f2
WHERE 
    f2.table_schema = @schema2 AND NOT EXISTS (SELECT 1 FROM information_schema.key_column_usage WHERE table_schema = @schema1 AND table_name = f2.table_name AND constraint_name = f2.constraint_name);

-- Compare auto increment properties
SELECT 
    CONCAT('Auto increment property for column ', a1.column_name, ' in table ', a1.table_name, ' exists in ', 
        IF(a2.column_name IS NULL, @schema1, @schema2),
        ' but not in ', 
        IF(a2.column_name IS NULL, @schema2, @schema1)
    ) AS 'Differences'
FROM 
    (SELECT table_schema, table_name, column_name
    FROM information_schema.columns
    WHERE table_schema = @schema1 AND extra LIKE '%auto_increment%'
    UNION
    SELECT table_schema, table_name, column_name
    FROM information_schema.columns
    WHERE table_schema = @schema2 AND extra LIKE '%auto_increment%') a1
    LEFT JOIN (SELECT table_schema, table_name, column_name
    FROM information_schema.columns
    WHERE table_schema IN (@schema1, @schema2) AND extra LIKE '%auto_increment%') a2
    ON a1.table_name = a2.table_name AND a1.column_name = a2.column_name
WHERE 
    a2.column_name IS NULL;

-- Compare not null constraints
SELECT 
    CONCAT('Not null constraint for column ', n1.column_name, ' in table ', n1.table_name, ' exists in ', 
        IF(n2.column_name IS NULL, @schema1, @schema2),
        ' but not in ', 
        IF(n2.column_name IS NULL, @schema2, @schema1)
    ) AS 'Differences'
FROM 
    (SELECT table_schema, table_name, column_name
    FROM information_schema.columns
    WHERE table_schema = @schema1 AND is_nullable = 'NO'
    UNION
    SELECT table_schema, table_name, column_name
    FROM information_schema.columns
    WHERE table_schema = @schema2 AND is_nullable = 'NO') n1
    LEFT JOIN (SELECT table_schema, table_name, column_name
    FROM information_schema.columns
    WHERE table_schema IN (@schema1, @schema2) AND is_nullable = 'NO') n2
    ON n1.table_name = n2.table_name AND n1.column_name = n2.column_name
WHERE 
    n2.column_name IS NULL;
