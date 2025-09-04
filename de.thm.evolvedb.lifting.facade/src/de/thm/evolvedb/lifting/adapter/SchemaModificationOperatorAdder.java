package de.thm.evolvedb.lifting.adapter;

import de.thm.evolvedb.migration.Migration;
import de.thm.evolvedb.migration.MigrationFactory;
import de.thm.evolvedb.migration.NotAutomaticallyResolvable;
import de.thm.evolvedb.migration.NotAutomaticallyResolvableOperatorType;
import de.thm.evolvedb.migration.PartiallyResolvable;
import de.thm.evolvedb.migration.PartiallyResolvableOperatorType;
import de.thm.evolvedb.migration.ProcessStatus;
import de.thm.evolvedb.migration.ResolvableOperator;
import de.thm.evolvedb.migration.ResolvableOperatorType;
import de.thm.evolvedb.migration.SchemaModificationOperator;

import java.util.*;

import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricDifference;

/**
 * Fügt für ein gegebenes Symmetric.SemanticChangeSet den passenden
 * SchemaModificationOperator in eine bestehende Migration ein.
 */
public final class SchemaModificationOperatorAdder {

    private SchemaModificationOperatorAdder() {}

    // ---- Klassifikation gemäß deinen ATL-Listen ----
    private static final Set<String> RESOLVABLE_RULES = new HashSet<>(Arrays.asList(
        "CREATE_Database_Schema",
        "CREATE_Column_IN_Table_(columns)",
        "CREATE_ForeignKey_IN_Table_(columns)",
        "SET_ATTRIBUTE_NamedElement_Name",
        "SET_ATTRIBUTE_Column_DefaultValue",
        "SET_ATTRIBUTE_Column_AutoIncrement",
        "CREATE_Table_IN_Database_Schema_(entites)",
        "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_SET_NULL_TO_RESTRICT",
        "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_SET_NULL_TO_NO_ACTION",
        "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_SET_NULL_TO_CASCADE",
        "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_RESTRICT_TO_SET_NULL",
        "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_RESTRICT_TO_NO_ACTION",
        "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_RESTRICT_TO_CASCADE",
        "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_NO_ACTION_TO_SET_NULL",
        "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_NO_ACTION_TO_RESTRICT",
        "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_NO_ACTION_TO_CASCADE",
        "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_CASCADE_TO_SET_NULL",
        "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_CASCADE_TO_RESTRICT",
        "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_CASCADE_TO_NO_ACTION",
        "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_SET_NULL_TO_RESTRICT",
        "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_SET_NULL_TO_NO_ACTION",
        "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_SET_NULL_TO_CASCADE",
        "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_RESTRICT_TO_SET_NULL",
        "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_RESTRICT_TO_NO_ACTION",
        "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_RESTRICT_TO_CASCADE",
        "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_NO_ACTION_TO_SET_NULL",
        "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_NO_ACTION_TO_RESTRICT",
        "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_NO_ACTION_TO_CASCADE",
        "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_CASCADE_TO_SET_NULL",
        "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_CASCADE_TO_RESTRICT",
        "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_CASCADE_TO_NO_ACTION",
        "SET_ATTRIBUTE_ForeignKey_ConstraintName",
        "CREATE_Index_IN_Table_(constraints)",
        "DELETE_Index_IN_Table_(constraints)",
        "DELETE_UniqueConstraint_IN_Table_(constraints)",
        "REMOVE_Column_(constraints)_TGT_ColumnConstraint",
        "SET_REFERENCE_ColumnConstraint_(column)_TGT_Column",
        "CREATE_ColumnConstraint_IN_Constraint_(columns)",
        "DELETE_ColumnConstraint_IN_Constraint_(columns)",
        "ADD_Column_(constraints)_TGT_ColumnConstraint",
        "SET_ATTRIBUTE_ColumnConstraint_Name"
    ));

    private static final Set<String> PARTIALLY_RESOLVABLE_RULES = new HashSet<>(Arrays.asList(
        "DELETE_Column_IN_Table_(columns)",
        "DELETE_ForeignKey_IN_Table_(columns)",
        "DELETE_PrimaryKey_IN_Table_(columns)",
        "DELETE_Table_IN_Database_Schema_(entites)",
        "SET_ATTRIBUTE_Column_NotNull",
        "SET_ATTRIBUTE_Column_Size",
        "SET_REFERENCE_ForeignKey_(referencedTable)_TGT_Table",
        "SET_ATTRIBUTE_Column_Unique",
        "SET_ATTRIBUTE_Column_Type",
        "CHANGE_1N_INTO_NM",
        "CHANGE_1N_INTO_NM_PRESERVE",
        "CHANGE_1N_INTO_NM_MOVE",
        "CHANGE_NM_INTO_1N",
        "CHANGE_NM_INTO_1N_PRESERVE",
        "SET_ATTRIBUTE_Column_Size_and_Type",
        "CREATE_PrimaryKey_IN_Table_(columns)",
        "CREATE_UniqueConstraint_IN_Table_(constraints)"
    ));

    private static final Set<String> NOT_AUTO_RULES = new HashSet<>(Arrays.asList(
        "MOVE_PrimaryKey_FROM_Table_(columns)_TO_Table_(columns)",
        "MOVE_ForeignKey_FROM_Table_(columns)_TO_Table_(columns)",
        "DELETE_PrimaryKey_IN_Table_(columns)",
        "JOIN_tables",
        "MOVE_Column_FROM_Table_(columns)_TO_Table_(columns)" // in Map vorhanden
    ));

    // ---- Mapping editRName -> Enumtyp (wie in deinen Maps) ----
    private static final Map<String, ResolvableOperatorType> RESOLVABLE_ENUM = new HashMap<>();
    private static final Map<String, PartiallyResolvableOperatorType> PARTIAL_ENUM = new HashMap<>();
    private static final Map<String, NotAutomaticallyResolvableOperatorType> NOT_AUTO_ENUM = new HashMap<>();

    static {
        // Resolvable
        RESOLVABLE_ENUM.put("CREATE_Table_IN_Database_Schema_(entites)", ResolvableOperatorType.CREATE_TABLE);
        RESOLVABLE_ENUM.put("SET_ATTRIBUTE_NamedElement_Name", ResolvableOperatorType.RENAME_TABLE);
        RESOLVABLE_ENUM.put("SET_ATTRIBUTE_ColumnConstraint_Name", ResolvableOperatorType.RENAME_TABLE);
        RESOLVABLE_ENUM.put("CREATE_Column_IN_Table_(columns)", ResolvableOperatorType.CREATE_COLUMN);
        RESOLVABLE_ENUM.put("CREATE_ForeignKey_IN_Table_(columns)", ResolvableOperatorType.CREATE_FOREIGN_KEY);
        RESOLVABLE_ENUM.put("SET_ATTRIBUTE_Column_DefaultValue", ResolvableOperatorType.SET_COLUMN_DEFAULT_VALUE);
        RESOLVABLE_ENUM.put("SET_ATTRIBUTE_Column_AutoIncrement", ResolvableOperatorType.SET_COLUMN_AUTO_INCREMENT);

        // alle OnUpdate/OnDelete-Änderungen → CHANGE_REFERENTIAL_ACTION
        String[] refRules = {
            "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_SET_NULL_TO_RESTRICT",
            "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_SET_NULL_TO_NO_ACTION",
            "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_SET_NULL_TO_CASCADE",
            "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_RESTRICT_TO_SET_NULL",
            "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_RESTRICT_TO_NO_ACTION",
            "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_RESTRICT_TO_CASCADE",
            "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_NO_ACTION_TO_SET_NULL",
            "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_NO_ACTION_TO_RESTRICT",
            "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_NO_ACTION_TO_CASCADE",
            "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_CASCADE_TO_SET_NULL",
            "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_CASCADE_TO_RESTRICT",
            "CHANGE_LITERAL_ForeignKey_OnUpdate_FROM_CASCADE_TO_NO_ACTION",
            "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_SET_NULL_TO_RESTRICT",
            "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_SET_NULL_TO_NO_ACTION",
            "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_SET_NULL_TO_CASCADE",
            "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_RESTRICT_TO_SET_NULL",
            "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_RESTRICT_TO_NO_ACTION",
            "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_RESTRICT_TO_CASCADE",
            "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_NO_ACTION_TO_SET_NULL",
            "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_NO_ACTION_TO_RESTRICT",
            "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_NO_ACTION_TO_CASCADE",
            "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_CASCADE_TO_SET_NULL",
            "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_CASCADE_TO_RESTRICT",
            "CHANGE_LITERAL_ForeignKey_OnDelete_FROM_CASCADE_TO_NO_ACTION"
        };
        for (String r : refRules) {
            RESOLVABLE_ENUM.put(r, ResolvableOperatorType.CHANGE_REFERENTIAL_ACTION);
        }

        RESOLVABLE_ENUM.put("SET_ATTRIBUTE_ForeignKey_ConstraintName", ResolvableOperatorType.SET_ATTRIBUTE_FOREIGNKEY_CONSTRAINT_NAME);
        RESOLVABLE_ENUM.put("CREATE_Index_IN_Table_(constraints)", ResolvableOperatorType.CREATE_INDEX_IN_TABLE);
        RESOLVABLE_ENUM.put("REMOVE_Column_(constraints)_TGT_ColumnConstraint", ResolvableOperatorType.REMOVE_CONSTRAINT);
        RESOLVABLE_ENUM.put("DELETE_Index_IN_Table_(constraints)", ResolvableOperatorType.REMOVE_CONSTRAINT);
        RESOLVABLE_ENUM.put("DELETE_UniqueConstraint_IN_Table_(constraints)", ResolvableOperatorType.REMOVE_CONSTRAINT);
        RESOLVABLE_ENUM.put("SET_REFERENCE_ColumnConstraint_(column)_TGT_Column", ResolvableOperatorType.ADD_COLUMN_TO_INDEX);
        RESOLVABLE_ENUM.put("CREATE_ColumnConstraint_IN_Constraint_(columns)", ResolvableOperatorType.ADD_COLUMN_TO_INDEX);
        RESOLVABLE_ENUM.put("DELETE_ColumnConstraint_IN_Constraint_(columns)", ResolvableOperatorType.REMOVE_CONSTRAINT);
        RESOLVABLE_ENUM.put("ADD_Column_(constraints)_TGT_ColumnConstraint", ResolvableOperatorType.ADD_COLUMN_TO_INDEX);

        // Partially resolvable
        PARTIAL_ENUM.put("DELETE_Column_IN_Table_(columns)", PartiallyResolvableOperatorType.DELETE_COLUMN);
        PARTIAL_ENUM.put("DELETE_ForeignKey_IN_Table_(columns)", PartiallyResolvableOperatorType.DELETE_FOREIGN_KEY);
        PARTIAL_ENUM.put("DELETE_PrimaryKey_IN_Table_(columns)", PartiallyResolvableOperatorType.DELETE_PRIMARY_KEY);
        PARTIAL_ENUM.put("DELETE_Table_IN_Database_Schema_(entites)", PartiallyResolvableOperatorType.DELETE_TABLE);
        PARTIAL_ENUM.put("SET_ATTRIBUTE_Column_NotNull", PartiallyResolvableOperatorType.SET_COLUMN_NOT_NULL);
        PARTIAL_ENUM.put("SET_ATTRIBUTE_Column_Size", PartiallyResolvableOperatorType.SET_COLUMN_SIZE);
        PARTIAL_ENUM.put("SET_ATTRIBUTE_Column_Type", PartiallyResolvableOperatorType.SET_COLUMN_TYPE);
        PARTIAL_ENUM.put("SET_ATTRIBUTE_Column_Size_and_Type", PartiallyResolvableOperatorType.SET_COLUMN_TYPE_AND_SIZE);
        PARTIAL_ENUM.put("CREATE_UniqueConstraint_IN_Table_(constraints)", PartiallyResolvableOperatorType.CREATE_UNIQUE_CONSTRAINT);
        PARTIAL_ENUM.put("CREATE_PrimaryKey_IN_Table_(columns)", PartiallyResolvableOperatorType.CREATE_PRIMARY_KEY);
        PARTIAL_ENUM.put("SET_REFERENCE_ForeignKey_(referencedTable)_TGT_Table", PartiallyResolvableOperatorType.SET_FOREIGNKEYS_TARGET_TABLE);
        PARTIAL_ENUM.put("CHANGE_1N_INTO_NM", PartiallyResolvableOperatorType.CHANGE_1N_INTO_NM);
        PARTIAL_ENUM.put("CHANGE_1N_INTO_NM_MOVE", PartiallyResolvableOperatorType.CHANGE_1N_INTO_NM_MOVE);
        PARTIAL_ENUM.put("CHANGE_1N_INTO_NM_PRESERVE", PartiallyResolvableOperatorType.CHANGE_1N_INTO_NM_PRESERVE);
        PARTIAL_ENUM.put("CHANGE_NM_INTO_1N", PartiallyResolvableOperatorType.CHANGE_NM_INTO_1N);
        PARTIAL_ENUM.put("CHANGE_NM_INTO_1N_PRESERVE", PartiallyResolvableOperatorType.CHANGE_NM_INTO_1N_PRESERVE);

        // Not automatically resolvable
        NOT_AUTO_ENUM.put("MOVE_PrimaryKey_FROM_Table_(columns)_TO_Table_(columns)", NotAutomaticallyResolvableOperatorType.MOVE_PRIMARY_KEY);
        NOT_AUTO_ENUM.put("MOVE_ForeignKey_FROM_Table_(columns)_TO_Table_(columns)", NotAutomaticallyResolvableOperatorType.MOVE_FOREIGN_KEY);
        NOT_AUTO_ENUM.put("MOVE_Column_FROM_Table_(columns)_TO_Table_(columns)", NotAutomaticallyResolvableOperatorType.MOVE_COLUMN);
        NOT_AUTO_ENUM.put("JOIN_tables", NotAutomaticallyResolvableOperatorType.JOIN_TABLE);
        // (DELETE_PrimaryKey_IN_Table_(columns) ist in deiner Liste als "notAutomaticallyResolvableRules",
        //  aber in PARTIAL_ENUM als DELETE_PRIMARY_KEY gemappt – ich folge hier dem Mapping und
        //  klassifiziere es über PARTIALLY_RESOLVABLE_RULES.)
    }

    public enum Category { RESOLVABLE, PARTIAL, NOT_AUTO, UNKNOWN }

    /**
     * Erzeugt und hängt einen passenden SMO an die Migration.
     * @param scs       das SemanticChangeSet
     * @param migration Ziel-Migration (wird modifiziert)
     * @param symmetric optional: gesamte SymmetricDifference (für Abhängigkeitslogik „neue Tabelle“)
     * @return der erzeugte Operator (Basistyp)
     */
    public static SchemaModificationOperator addOperatorFor(
            SemanticChangeSet scs,
            Migration migration,
            SymmetricDifference symmetric // nullable
    ) {
        String editRName = scs.getEditRName(); // FIXME: Getter-Name ggf. anpassen
        Category cat = classify(editRName);

        switch (cat) {
            case RESOLVABLE:
                return buildResolvable(scs, migration, symmetric);
            case PARTIAL:
                return buildPartiallyResolvable(scs, migration);
            case NOT_AUTO:
                return buildNotAutomaticallyResolvable(scs, migration);
            case UNKNOWN:
            default:
                // Fallback: konservativ als NotAutomaticallyResolvable anlegen
                return buildNotAutomaticallyResolvable(scs, migration);
        }
    }

    private static Category classify(String editRName) {
        if (RESOLVABLE_RULES.contains(editRName)) return Category.RESOLVABLE;
        if (PARTIALLY_RESOLVABLE_RULES.contains(editRName)) return Category.PARTIAL;
        if (NOT_AUTO_RULES.contains(editRName)) return Category.NOT_AUTO;
        return Category.UNKNOWN;
    }

    // ---- Builder für die drei Kategorien ----

    private static SchemaModificationOperator buildResolvable(
            SemanticChangeSet scs,
            Migration migration,
            SymmetricDifference symmetric
    ) {
        // Spezialfall „Neue Tabelle“ – aktuell wie in deinem ATL-Helper neutral behandelt.
        if (isNewTable(scs)) {
            // Wenn du die Abhängigkeits-Sammlung wie in SemanticChangeSet2newTableSMO willst,
            // nutze die folgende Variante und gib einen konkreten Tabellennamen an.
            // return buildNewTableResolvable(scs, migration, symmetric, "verkehrsweg_grundstueck");
        }

        ResolvableOperator op = MigrationFactory.eINSTANCE.createResolvableOperator();
        op.setDescription(safeString(scs.getDescription()));
        op.setProcessStatus(ProcessStatus.UNRESOLVED);
        ResolvableOperatorType type = RESOLVABLE_ENUM.getOrDefault(scs.getEditRName(), ResolvableOperatorType.CREATE_TABLE);
        op.setDisplayName(type);

        // Link zum ChangeSet
        op.getSemanticChangeSets().add(scs);

        // In Migration einhängen
        migration.getSchemaModificationOperators().add(op);
        return op;
    }

    // Optionaler Spezialfall (analog deiner auskommentierten Regel)
    @SuppressWarnings("unused")
    private static SchemaModificationOperator buildNewTableResolvable(
            SemanticChangeSet scs,
            Migration migration,
            SymmetricDifference symmetric,
            String tableName // z.B. "verkehrsweg_grundstueck"
    ) {
        ResolvableOperator op = MigrationFactory.eINSTANCE.createResolvableOperator();
        op.setDescription(safeString(scs.getDescription()));
        op.setProcessStatus(ProcessStatus.UNRESOLVED);
        ResolvableOperatorType type = RESOLVABLE_ENUM.getOrDefault(scs.getEditRName(), ResolvableOperatorType.CREATE_TABLE);
        op.setDisplayName(type);

        if (symmetric != null) {
            // füge alle ChangeSets hinzu, die „von neuer Tabelle abhängig“ sind
            for (SemanticChangeSet other : symmetric.getChangeSets()) {
                if (dependsOnNewTable(other, tableName)) {
                    op.getSemanticChangeSets().add(other);
                }
            }
        } else {
            // minimal: zumindest das aktuelle Set
            op.getSemanticChangeSets().add(scs);
        }

        migration.getSchemaModificationOperators().add(op);
        return op;
    }

    private static SchemaModificationOperator buildPartiallyResolvable(
            SemanticChangeSet scs,
            Migration migration
    ) {
        PartiallyResolvable op = MigrationFactory.eINSTANCE.createPartiallyResolvable();
        op.setDescription(safeString(scs.getDescription()));
        op.setProcessStatus(ProcessStatus.UNRESOLVED);
        PartiallyResolvableOperatorType type =
                PARTIAL_ENUM.getOrDefault(scs.getEditRName(), PartiallyResolvableOperatorType.DELETE_COLUMN);
        op.setDisplayName(type);
        op.getSemanticChangeSets().add(scs);
        migration.getSchemaModificationOperators().add(op);
        return op;
    }

    private static SchemaModificationOperator buildNotAutomaticallyResolvable(
            SemanticChangeSet scs,
            Migration migration
    ) {
        NotAutomaticallyResolvable op = MigrationFactory.eINSTANCE.createNotAutomaticallyResolvable();
        op.setDescription(safeString(scs.getDescription()));
        op.setProcessStatus(ProcessStatus.UNRESOLVED);
        NotAutomaticallyResolvableOperatorType type =
                NOT_AUTO_ENUM.getOrDefault(scs.getEditRName(), NotAutomaticallyResolvableOperatorType.JOIN_TABLE);
        op.setDisplayName(type);
        op.getSemanticChangeSets().add(scs);
        migration.getSchemaModificationOperators().add(op);
        return op;
    }

    // ---- Hilfslogik analog deinen ATL-Helpern ----

    private static boolean isNewTable(SemanticChangeSet scs) {
        return "CREATE_Table_IN_Database_Schema_(entites)".equals(scs.getEditRName());
    }

    /**
     * Näherung der ATL-Abfrage dependsOnNewTable(tableName).
     * Passe diese Methode an deine Symmetric-Klassenstruktur an.
     */
    private static boolean dependsOnNewTable(SemanticChangeSet scs, String tableName) {
        // TODO/Beispiel: prüfe, ob ein AddObject mit einem EObjectSet zur gesuchten Tabelle gehört.
        // Ohne konkrete Klassen für Change-Typen implementieren wir eine konservative False-Default-Variante.
        // Du kannst hier deine echte Logik einbauen (z.B. über instanceof AddObject und Inspect der referenzierten Objekte).
        return false;
    }

    private static String safeString(Object o) {
        return o == null ? "" : String.valueOf(o);
    }
}

