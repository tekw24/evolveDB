  
UPDATE revision as revision 
set revision.rev_actor = (select revactor_actor from revision_actor_temp where revision.rev_page = revactor_page order by revactor_timestamp limit 1);  
  
-- Remove constraint revactor_rev 
ALTER TABLE revision_actor_temp DROP INDEX `revactor_rev`;

-- Remove column tl_namespace from Index tl_namespace 
ALTER TABLE templatelinks DROP INDEX `tl_namespace`;

ALTER TABLE `templatelinks` 
ADD INDEX tl_namespace ( tl_title, tl_from)
 ;
-- Remove constraint rev_page_id 
ALTER TABLE revision DROP INDEX `rev_page_id`;

-- Remove constraint tl_title from tl_backlinks_namespace 
ALTER TABLE templatelinks DROP INDEX `tl_backlinks_namespace`,
ADD INDEX tl_backlinks_namespace ( tl_from_namespace, tl_namespace, tl_from)
;


-- Remove column tl_namespace from Index tl_backlinks_namespace 
ALTER TABLE templatelinks DROP INDEX `tl_backlinks_namespace`;

ALTER TABLE `templatelinks` 
ADD INDEX tl_backlinks_namespace ( tl_from_namespace, tl_from)
 ;
-- Remove constraint page_actor_timestamp 
ALTER TABLE revision_actor_temp DROP INDEX `page_actor_timestamp`;

-- Remove constraint actor_timestamp 
ALTER TABLE revision_actor_temp DROP INDEX `actor_timestamp`;

-- Remove constraint tl_title from tl_namespace 
ALTER TABLE templatelinks DROP INDEX `tl_namespace`,
ADD INDEX tl_namespace ( tl_from)
;


-- Create Table `user_autocreate_serial`
CREATE TABLE IF NOT EXISTS `user_autocreate_serial`(
`uas_shard` INT UNSIGNED NOT NULL 
,`uas_value` INT UNSIGNED  NOT NULL  
,
PRIMARY KEY (`uas_shard` )

);
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
-- TODO TEST
INSERT into `linktarget` (`lt_title`, `lt_namespace`) 
SELECT distinct tl_title, tl_namespace from templatelinks;

-- TODO Test

-- Add the new column modtoken in Table objectcache
ALTER TABLE `objectcache` 
ADD COLUMN `modtoken` VARCHAR(17) NOT NULL  
DEFAULT '00000000000000000' ;
-- Add the new column flags in Table objectcache
ALTER TABLE `objectcache` 
ADD COLUMN `flags` INT UNSIGNED   
 ;
-- Change column type of pp_page 
ALTER TABLE `page_props` CHANGE COLUMN `pp_page` `pp_page` INT UNSIGNED NOT NULL  ;
-- Change column type of ir_ipb_id 
ALTER TABLE `ipblocks_restrictions` CHANGE COLUMN `ir_ipb_id` `ir_ipb_id` INT UNSIGNED NOT NULL  ;
-- Change column type of user_editcount 
ALTER TABLE `user` CHANGE COLUMN `user_editcount` `user_editcount` INT UNSIGNED NULL  ;
-- Change column type of ipb_id 
ALTER TABLE `ipblocks` CHANGE COLUMN `ipb_id` `ipb_id` INT UNSIGNED NOT NULL  ;
-- Change column type of ir_value 
ALTER TABLE `ipblocks_restrictions` CHANGE COLUMN `ir_value` `ir_value` INT UNSIGNED NOT NULL  ;
-- Change column type of ipb_parent_block_id 
ALTER TABLE `ipblocks` CHANGE COLUMN `ipb_parent_block_id` `ipb_parent_block_id` INT UNSIGNED NULL  ;
-- Change column type of pr_page 
ALTER TABLE `page_restrictions` CHANGE COLUMN `pr_page` `pr_page` INT UNSIGNED NOT NULL  ;
-- Create primary key in templatelinks 
ALTER TABLE `templatelinks` 
ADD COLUMN `tl_target_id` BIGINT UNSIGNED NOT NULL  ;

-- SET @rank:=0;
-- UPDATE `templatelinks`
-- set `tl_target_id`=@rank:=@rank+1;


UPDATE `templatelinks` 
set `tl_target_id` =
(SELECT `lt_id` from `linktarget` where tl_title = lt_title and tl_namespace = lt_namespace);

ALTER TABLE `templatelinks`
DROP PRIMARY KEY,
ADD PRIMARY KEY (`tl_from`, `tl_target_id`);
-- Change column type of fa_id 
ALTER TABLE `filearchive` CHANGE COLUMN `fa_id` `fa_id` INT UNSIGNED NOT NULL  ;
-- Drop primary key in templatelinks			
ALTER TABLE `templatelinks` 
DROP COLUMN `tl_title`;	
-- Drop column in page			
ALTER TABLE `page` 
DROP COLUMN `page_restrictions`;
-- Drop table revision_actor_temp			
DROP TABLE `revision_actor_temp`;

-- Drop primary key in templatelinks			
ALTER TABLE `templatelinks` 
DROP COLUMN `tl_namespace`;	
-- Drop column in page_restrictions			
ALTER TABLE `page_restrictions` 
DROP COLUMN `pr_user`;
-- Change constraint name of change_tag_rc_tag_id 
ALTER TABLE change_tag DROP INDEX `change_tag_rc_tag_id`;
ALTER TABLE change_tag ADD 
UNIQUE INDEX ct_rc_tag_id ( 
ct_rc_id, ct_tag_id  );

-- Add the new index oi_timestamp in Table oldimage
ALTER TABLE `oldimage` 
ADD INDEX oi_timestamp ( oi_timestamp)
 ;
-- Change constraint name of change_tag_tag_id_id 
ALTER TABLE change_tag DROP INDEX `change_tag_tag_id_id`;
ALTER TABLE change_tag ADD 
INDEX ct_tag_id_id ( 
ct_tag_id, ct_rc_id, ct_rev_id, ct_log_id  );

-- Change constraint name of tl_namespace 
ALTER TABLE templatelinks DROP INDEX `tl_namespace`;
ALTER TABLE templatelinks ADD 
INDEX tl_target_id ( 
tl_target_id, tl_from  );

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

-- Change constraint name of name_title 
ALTER TABLE page DROP INDEX `name_title`;
ALTER TABLE page ADD 
UNIQUE INDEX page_name_title ( 
page_namespace, page_title  );

-- Change default value of rev_timestamp 
ALTER TABLE `revision` CHANGE COLUMN `rev_timestamp` `rev_timestamp` BINARY(14) NOT NULL  ;
-- Change constraint name of change_tag_log_tag_id 
ALTER TABLE change_tag DROP INDEX `change_tag_log_tag_id`;
ALTER TABLE change_tag ADD 
UNIQUE INDEX ct_log_tag_id ( 
ct_log_id, ct_tag_id  );

-- Change constraint name of tl_backlinks_namespace 
ALTER TABLE templatelinks DROP INDEX `tl_backlinks_namespace`;
ALTER TABLE templatelinks ADD 
INDEX tl_backlinks_namespace_target_id ( 
tl_from_namespace, tl_target_id, tl_from  );

-- If executing the script fails, we suggest a rollback.
