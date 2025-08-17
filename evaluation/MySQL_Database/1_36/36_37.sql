USE media_wiki_1_37_6;

-- Add the new column flags in Table objectcache
ALTER TABLE `objectcache` 
ADD COLUMN `flags` INT UNSIGNED   
 ;
-- Add the new column modtoken in Table objectcache
ALTER TABLE `objectcache` 
ADD COLUMN `modtoken` VARCHAR(17) NOT NULL  
DEFAULT '00000000000000000' ;
-- Add the new index oi_timestamp in Table oldimage
ALTER TABLE `oldimage` 
ADD INDEX oi_timestamp ( oi_timestamp)
 ;
-- Change constraint name of name_title 
ALTER TABLE page DROP INDEX `name_title`;
ALTER TABLE page ADD 
UNIQUE INDEX page_name_title ( 
page_namespace, page_title  );

-- Change constraint name of change_tag_tag_id_id 
ALTER TABLE change_tag DROP INDEX `change_tag_tag_id_id`;
ALTER TABLE change_tag ADD 
INDEX ct_tag_id_id ( 
ct_tag_id, ct_rc_id, ct_rev_id, ct_log_id  );

-- Change constraint name of page_timestamp 
ALTER TABLE revision DROP INDEX `page_timestamp`;
ALTER TABLE revision ADD 
INDEX rev_page_timestamp ( 
rev_page, rev_timestamp  );

-- Change constraint name of change_tag_rev_tag_id 
ALTER TABLE change_tag DROP INDEX `change_tag_rev_tag_id`;
ALTER TABLE change_tag ADD 
UNIQUE INDEX ct_rev_tag_id ( 
ct_rev_id, ct_tag_id  );

-- Change default value of rev_timestamp 
ALTER TABLE `revision` CHANGE COLUMN `rev_timestamp` `rev_timestamp` BINARY(14) NOT NULL  ;
-- Change constraint name of change_tag_rc_tag_id 
ALTER TABLE change_tag DROP INDEX `change_tag_rc_tag_id`;
ALTER TABLE change_tag ADD 
UNIQUE INDEX ct_rc_tag_id ( 
ct_rc_id, ct_tag_id  );

-- Change constraint name of change_tag_log_tag_id 
ALTER TABLE change_tag DROP INDEX `change_tag_log_tag_id`;
ALTER TABLE change_tag ADD 
UNIQUE INDEX ct_log_tag_id ( 
ct_log_id, ct_tag_id  );

-- If executing the script fails, we suggest a rollback.
