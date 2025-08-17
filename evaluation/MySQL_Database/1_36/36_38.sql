USE media_wiki_1_38_7;

-- Remove constraint rev_page_id 
ALTER TABLE revision DROP INDEX `rev_page_id`;

-- Create Table `linktarget`
CREATE TABLE IF NOT EXISTS `linktarget`(
`lt_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT
,`lt_namespace` INT (10) NOT NULL,  
`lt_title` VARBINARY (255) NOT NULL  
,
PRIMARY KEY (`lt_id` )

,
UNIQUE KEY lt_namespace_title ( lt_namespace, lt_title)
);
-- Add the new column flags in Table objectcache
ALTER TABLE `objectcache` 
ADD COLUMN `flags` INT UNSIGNED   
 ;
-- Add the new column tl_target_id in Table templatelinks
ALTER TABLE `templatelinks` 
ADD COLUMN `tl_target_id` BIGINT UNSIGNED   
 ;
-- Add the new column modtoken in Table objectcache
ALTER TABLE `objectcache` 
ADD COLUMN `modtoken` VARCHAR(17) NOT NULL  
DEFAULT '00000000000000000' ;
-- Change constraint name of page_timestamp 
ALTER TABLE revision DROP INDEX `page_timestamp`;
ALTER TABLE revision ADD 
INDEX rev_page_timestamp ( 
rev_page, rev_timestamp  );

-- Change constraint name of change_tag_tag_id_id 
ALTER TABLE change_tag DROP INDEX `change_tag_tag_id_id`;
ALTER TABLE change_tag ADD 
INDEX ct_tag_id_id ( 
ct_tag_id, ct_rc_id, ct_rev_id, ct_log_id  );

-- Change constraint name of change_tag_log_tag_id 
ALTER TABLE change_tag DROP INDEX `change_tag_log_tag_id`;
ALTER TABLE change_tag ADD 
UNIQUE INDEX ct_log_tag_id ( 
ct_log_id, ct_tag_id  );

-- Change constraint name of change_tag_rev_tag_id 
ALTER TABLE change_tag DROP INDEX `change_tag_rev_tag_id`;
ALTER TABLE change_tag ADD 
UNIQUE INDEX ct_rev_tag_id ( 
ct_rev_id, ct_tag_id  );

-- Change constraint name of name_title 
ALTER TABLE page DROP INDEX `name_title`;
ALTER TABLE page ADD 
UNIQUE INDEX page_name_title ( 
page_namespace, page_title  );

-- Add the new index oi_timestamp in Table oldimage
ALTER TABLE `oldimage` 
ADD INDEX oi_timestamp ( oi_timestamp)
 ;
-- Add the new index tl_target_id in Table templatelinks
ALTER TABLE `templatelinks` 
ADD INDEX tl_target_id ( tl_target_id, tl_from)
 ;
-- Change default value of rev_timestamp 
ALTER TABLE `revision` CHANGE COLUMN `rev_timestamp` `rev_timestamp` BINARY(14) NOT NULL  ;
-- Change constraint name of change_tag_rc_tag_id 
ALTER TABLE change_tag DROP INDEX `change_tag_rc_tag_id`;
ALTER TABLE change_tag ADD 
UNIQUE INDEX ct_rc_tag_id ( 
ct_rc_id, ct_tag_id  );

-- Add the new index tl_backlinks_namespace_target_id in Table templatelinks
ALTER TABLE `templatelinks` 
ADD INDEX tl_backlinks_namespace_target_id ( tl_from_namespace, tl_target_id, tl_from)
 ;
-- Change column type of pp_page 
ALTER TABLE `page_props` CHANGE COLUMN `pp_page` `pp_page` INT UNSIGNED NOT NULL  ;
-- Change column type of pr_page 
ALTER TABLE `page_restrictions` CHANGE COLUMN `pr_page` `pr_page` INT UNSIGNED NOT NULL  ;
-- Change column type of fa_id 
ALTER TABLE `filearchive` CHANGE COLUMN `fa_id` `fa_id` INT UNSIGNED NOT NULL  ;
-- Change column type of ir_value 
ALTER TABLE `ipblocks_restrictions` CHANGE COLUMN `ir_value` `ir_value` INT UNSIGNED NOT NULL  ;
-- Drop column in page_restrictions			
ALTER TABLE `page_restrictions` 
DROP COLUMN `pr_user`;
-- If executing the script fails, we suggest a rollback.
