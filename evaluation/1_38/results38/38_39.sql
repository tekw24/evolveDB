UPDATE revision as revision 
set revision.rev_actor = (select revactor_actor from revision_actor_temp where revision.rev_page = revactor_page order by revactor_timestamp limit 1);  

-- Remove constraint tl_namespace 
ALTER TABLE templatelinks DROP INDEX `tl_namespace`;

-- Remove constraint tl_backlinks_namespace 
ALTER TABLE templatelinks DROP INDEX `tl_backlinks_namespace`;

-- Remove constraint page_actor_timestamp 
ALTER TABLE revision_actor_temp DROP INDEX `page_actor_timestamp`;

-- Remove constraint revactor_rev 
ALTER TABLE revision_actor_temp DROP INDEX `revactor_rev`;

-- Remove constraint actor_timestamp 
ALTER TABLE revision_actor_temp DROP INDEX `actor_timestamp`;

-- Create Table `user_autocreate_serial`
CREATE TABLE IF NOT EXISTS `user_autocreate_serial`(
`uas_shard` INT UNSIGNED NOT NULL 
,`uas_value` INT UNSIGNED  NOT NULL  
,
PRIMARY KEY (`uas_shard` )

);
-- Change column type of ipb_parent_block_id 
ALTER TABLE `ipblocks` CHANGE COLUMN `ipb_parent_block_id` `ipb_parent_block_id` INT UNSIGNED NULL  ;
-- Change column type of ipb_id 
ALTER TABLE `ipblocks` CHANGE COLUMN `ipb_id` `ipb_id` INT UNSIGNED NOT NULL  ;
-- Change column type of user_editcount 
ALTER TABLE `user` CHANGE COLUMN `user_editcount` `user_editcount` INT UNSIGNED NULL  ;
-- Change column type of ir_ipb_id 
ALTER TABLE `ipblocks_restrictions` CHANGE COLUMN `ir_ipb_id` `ir_ipb_id` INT UNSIGNED NOT NULL  ;
-- Drop column in page			
ALTER TABLE `page` 
DROP COLUMN `page_restrictions`;
-- Drop primary key in templatelinks	

INSERT into `linktarget` (`lt_title`, `lt_namespace`) 
SELECT distinct tl_title, tl_namespace from templatelinks;

	

UPDATE `templatelinks` 
set `tl_target_id` =
(SELECT `lt_id` from `linktarget` where tl_title = lt_title and tl_namespace = lt_namespace);


-- Change column not null of tl_target_id 
ALTER TABLE `templatelinks` CHANGE COLUMN `tl_target_id` `tl_target_id` BIGINT UNSIGNED NOT NULL  ;

ALTER TABLE `templatelinks` 
DROP COLUMN `tl_namespace`;	

ALTER TABLE `templatelinks`
DROP PRIMARY KEY,
ADD PRIMARY KEY (`tl_from`, `tl_target_id`);



-- Drop table revision_actor_temp		
DROP TABLE `revision_actor_temp`;

-- Drop primary key in templatelinks			
ALTER TABLE `templatelinks` 
DROP COLUMN `tl_title`;	
-- If executing the script fails, we suggest a rollback.