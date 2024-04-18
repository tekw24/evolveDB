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
-- Add the new column modtoken in Table objectcache
ALTER TABLE `objectcache` 
ADD COLUMN `modtoken` VARCHAR(17) NOT NULL  
DEFAULT '00000000000000000' ;
-- Add the new column tl_target_id in Table templatelinks
ALTER TABLE `templatelinks` 
ADD COLUMN `tl_target_id` BIGINT UNSIGNED   
 ;
-- Change column type of job_timestamp 
ALTER TABLE `job` CHANGE COLUMN `job_timestamp` `job_timestamp` BINARY(14) NULL  ;
-- Change column type of qcc_titletwo 
ALTER TABLE `querycachetwo` CHANGE COLUMN `qcc_titletwo` `qcc_titletwo` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of img_name 
ALTER TABLE `image` CHANGE COLUMN `img_name` `img_name` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of fa_archive_name 
ALTER TABLE `filearchive` CHANGE COLUMN `fa_archive_name` `fa_archive_name` VARBINARY(255) NULL DEFAULT '' ;
-- Change column type of us_timestamp 
ALTER TABLE `uploadstash` CHANGE COLUMN `us_timestamp` `us_timestamp` BINARY(14) NOT NULL  ;
-- Change column type of oi_name 
ALTER TABLE `oldimage` CHANGE COLUMN `oi_name` `oi_name` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of ct_rc_id 
ALTER TABLE `change_tag` CHANGE COLUMN `ct_rc_id` `ct_rc_id` INT UNSIGNED NULL  ;
-- Change column type of user_last_timestamp 
ALTER TABLE `user_newtalk` CHANGE COLUMN `user_last_timestamp` `user_last_timestamp` BINARY(14) NULL  ;
-- Change column type of job_token_timestamp 
ALTER TABLE `job` CHANGE COLUMN `job_token_timestamp` `job_token_timestamp` BINARY(14) NULL  ;
-- Change column type of exptime 
ALTER TABLE `objectcache` CHANGE COLUMN `exptime` `exptime` BINARY(14) NULL  ;
-- Change column type of oi_archive_name 
ALTER TABLE `oldimage` CHANGE COLUMN `oi_archive_name` `oi_archive_name` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of cl_to 
ALTER TABLE `categorylinks` CHANGE COLUMN `cl_to` `cl_to` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of fa_name 
ALTER TABLE `filearchive` CHANGE COLUMN `fa_name` `fa_name` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of cl_sortkey_prefix 
ALTER TABLE `categorylinks` CHANGE COLUMN `cl_sortkey_prefix` `cl_sortkey_prefix` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of qc_title 
ALTER TABLE `querycache` CHANGE COLUMN `qc_title` `qc_title` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of pt_title 
ALTER TABLE `protected_titles` CHANGE COLUMN `pt_title` `pt_title` VARBINARY(255) NOT NULL  ;
-- Change column type of fa_id 
ALTER TABLE `filearchive` CHANGE COLUMN `fa_id` `fa_id` INT UNSIGNED NOT NULL  ;
-- Change column type of rc_timestamp 
ALTER TABLE `recentchanges` CHANGE COLUMN `rc_timestamp` `rc_timestamp` BINARY(14) NOT NULL  ;
-- Change column type of user_real_name 
ALTER TABLE `user` CHANGE COLUMN `user_real_name` `user_real_name` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of rd_title 
ALTER TABLE `redirect` CHANGE COLUMN `rd_title` `rd_title` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of img_timestamp 
ALTER TABLE `image` CHANGE COLUMN `img_timestamp` `img_timestamp` BINARY(14) NOT NULL  ;
-- Change column type of log_title 
ALTER TABLE `logging` CHANGE COLUMN `log_title` `log_title` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of iwl_title 
ALTER TABLE `iwlinks` CHANGE COLUMN `iwl_title` `iwl_title` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of rc_title 
ALTER TABLE `recentchanges` CHANGE COLUMN `rc_title` `rc_title` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of model_id 
ALTER TABLE `content_models` CHANGE COLUMN `model_id` `model_id` INT(10) NOT NULL  ;
-- Change column type of wl_notificationtimestamp 
ALTER TABLE `watchlist` CHANGE COLUMN `wl_notificationtimestamp` `wl_notificationtimestamp` BINARY(14) NULL  ;
-- Change column type of pr_page 
ALTER TABLE `page_restrictions` CHANGE COLUMN `pr_page` `pr_page` INT UNSIGNED NOT NULL  ;
-- Change column type of wl_title 
ALTER TABLE `watchlist` CHANGE COLUMN `wl_title` `wl_title` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of ir_value 
ALTER TABLE `ipblocks_restrictions` CHANGE COLUMN `ir_value` `ir_value` INT UNSIGNED NOT NULL  ;
-- Change column type of ir_type 
ALTER TABLE `ipblocks_restrictions` CHANGE COLUMN `ir_type` `ir_type` TINYINT(3) NOT NULL  ;
-- Change column type of job_title 
ALTER TABLE `job` CHANGE COLUMN `job_title` `job_title` VARBINARY(255) NOT NULL  ;
-- Change column type of pl_title 
ALTER TABLE `pagelinks` CHANGE COLUMN `pl_title` `pl_title` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of rd_fragment 
ALTER TABLE `redirect` CHANGE COLUMN `rd_fragment` `rd_fragment` VARBINARY(255) NULL  ;
-- Change column type of pp_page 
ALTER TABLE `page_props` CHANGE COLUMN `pp_page` `pp_page` INT UNSIGNED NOT NULL  ;
-- Change column type of rc_id 
ALTER TABLE `recentchanges` CHANGE COLUMN `rc_id` `rc_id` INT UNSIGNED NOT NULL  ;
-- Change column type of cat_title 
ALTER TABLE `category` CHANGE COLUMN `cat_title` `cat_title` VARBINARY(255) NOT NULL  ;
-- Change column type of ll_title 
ALTER TABLE `langlinks` CHANGE COLUMN `ll_title` `ll_title` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of user_name 
ALTER TABLE `user` CHANGE COLUMN `user_name` `user_name` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of role_id 
ALTER TABLE `slot_roles` CHANGE COLUMN `role_id` `role_id` INT(10) NOT NULL  ;
-- Change column type of tl_title 
ALTER TABLE `templatelinks` CHANGE COLUMN `tl_title` `tl_title` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of qcc_title 
ALTER TABLE `querycachetwo` CHANGE COLUMN `qcc_title` `qcc_title` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of rc_source 
ALTER TABLE `recentchanges` CHANGE COLUMN `rc_source` `rc_source` VARBINARY(16) NOT NULL DEFAULT '' ;
-- Change column type of ar_title 
ALTER TABLE `archive` CHANGE COLUMN `ar_title` `ar_title` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Change column type of page_title 
ALTER TABLE `page` CHANGE COLUMN `page_title` `page_title` VARBINARY(255) NOT NULL  ;
-- Change column type of il_to 
ALTER TABLE `imagelinks` CHANGE COLUMN `il_to` `il_to` VARBINARY(255) NOT NULL DEFAULT '' ;
-- Drop column in page_restrictions			
ALTER TABLE `page_restrictions` 
DROP COLUMN `pr_user`;
-- Change column size of exptime 
ALTER TABLE `objectcache` CHANGE COLUMN `exptime` `exptime` BINARY(14) NOT NULL  ;
-- Change column not null of exptime 
ALTER TABLE `objectcache` CHANGE COLUMN `exptime` `exptime` BINARY(14) NOT NULL  ;
-- Change constraint name of sites_global_key 
ALTER TABLE sites DROP INDEX `sites_global_key`;
ALTER TABLE sites ADD 
UNIQUE INDEX site_global_key ( 
site_global_key  );

-- Change default value of user_touched 
ALTER TABLE `user` CHANGE COLUMN `user_touched` `user_touched` BINARY(14) NOT NULL  ;
-- Add the new index tl_target_id in Table templatelinks
ALTER TABLE `templatelinks` 
ADD INDEX tl_target_id ( tl_target_id, tl_from)
 ;
-- Change constraint name of change_tag_rc_tag_id 
ALTER TABLE change_tag DROP INDEX `change_tag_rc_tag_id`;
ALTER TABLE change_tag ADD 
UNIQUE INDEX ct_rc_tag_id ( 
ct_rc_id, ct_tag_id  );

-- Add the new index tl_backlinks_namespace_target_id in Table templatelinks
ALTER TABLE `templatelinks` 
ADD INDEX tl_backlinks_namespace_target_id ( tl_from_namespace, tl_target_id, tl_from)
 ;
-- Change default value of rev_timestamp 
ALTER TABLE `revision` CHANGE COLUMN `rev_timestamp` `rev_timestamp` BINARY(14) NOT NULL  ;
-- Change default value of ipc_rev_timestamp 
ALTER TABLE `ip_changes` CHANGE COLUMN `ipc_rev_timestamp` `ipc_rev_timestamp` BINARY(14) NOT NULL  ;
-- Change constraint name of sites_language 
ALTER TABLE sites DROP INDEX `sites_language`;
ALTER TABLE sites ADD 
INDEX site_language ( 
site_language  );

-- Change constraint name of namespace_title 
ALTER TABLE watchlist DROP INDEX `namespace_title`;
ALTER TABLE watchlist ADD 
INDEX wl_namespace_title ( 
wl_namespace, wl_title  );

-- Change default value of revactor_timestamp 
ALTER TABLE `revision_actor_temp` CHANGE COLUMN `revactor_timestamp` `revactor_timestamp` BINARY(14) NOT NULL  ;
-- Change constraint name of actor_time 
ALTER TABLE logging DROP INDEX `actor_time`;
ALTER TABLE logging ADD 
INDEX log_actor_time ( 
log_actor, log_timestamp  );

-- Change constraint name of name_title 
ALTER TABLE page DROP INDEX `name_title`;
ALTER TABLE page ADD 
UNIQUE INDEX page_name_title ( 
page_namespace, page_title  );

-- Change constraint name of page_timestamp 
ALTER TABLE revision DROP INDEX `page_timestamp`;
ALTER TABLE revision ADD 
INDEX rev_page_timestamp ( 
rev_page, rev_timestamp  );

-- Change constraint name of site_ids_key 
ALTER TABLE site_identifiers DROP INDEX `site_ids_key`;
ALTER TABLE site_identifiers ADD 
INDEX si_key ( 
si_key  );

-- Change constraint name of sites_group 
ALTER TABLE sites DROP INDEX `sites_group`;
ALTER TABLE sites ADD 
INDEX site_group ( 
site_group  );

-- Change constraint name of type_time 
ALTER TABLE logging DROP INDEX `type_time`;
ALTER TABLE logging ADD 
INDEX log_type_time ( 
log_type, log_timestamp  );

-- Change default value of ipb_timestamp 
ALTER TABLE `ipblocks` CHANGE COLUMN `ipb_timestamp` `ipb_timestamp` BINARY(14) NOT NULL  ;
-- Change default value of pt_expiry 
ALTER TABLE `protected_titles` CHANGE COLUMN `pt_expiry` `pt_expiry` VARBINARY(14) NOT NULL  ;
-- Change constraint name of site_ids_site 
ALTER TABLE site_identifiers DROP INDEX `site_ids_site`;
ALTER TABLE site_identifiers ADD 
INDEX si_site ( 
si_site  );

-- Change default value of img_timestamp 
ALTER TABLE `image` CHANGE COLUMN `img_timestamp` `img_timestamp` BINARY(14) NOT NULL  ;
-- Change default value of fa_deleted_timestamp 
ALTER TABLE `filearchive` CHANGE COLUMN `fa_deleted_timestamp` `fa_deleted_timestamp` BINARY(14) NULL  ;
-- Change default value of fa_timestamp 
ALTER TABLE `filearchive` CHANGE COLUMN `fa_timestamp` `fa_timestamp` BINARY(14) NULL  ;
-- Change constraint name of sites_forward 
ALTER TABLE sites DROP INDEX `sites_forward`;
ALTER TABLE sites ADD 
INDEX site_forward ( 
site_forward  );

-- Change default value of ar_timestamp 
ALTER TABLE `archive` CHANGE COLUMN `ar_timestamp` `ar_timestamp` BINARY(14) NOT NULL  ;
-- Change constraint name of times 
ALTER TABLE logging DROP INDEX `times`;
ALTER TABLE logging ADD 
INDEX log_times ( 
log_timestamp  );

-- Change default value of ipb_expiry 
ALTER TABLE `ipblocks` CHANGE COLUMN `ipb_expiry` `ipb_expiry` VARBINARY(14) NOT NULL  ;
-- Change default value of oi_timestamp 
ALTER TABLE `oldimage` CHANGE COLUMN `oi_timestamp` `oi_timestamp` BINARY(14) NOT NULL  ;
-- Change default value of page_touched 
ALTER TABLE `page` CHANGE COLUMN `page_touched` `page_touched` BINARY(14) NOT NULL  ;
-- Change constraint name of user_properties_property 
ALTER TABLE user_properties DROP INDEX `user_properties_property`;
ALTER TABLE user_properties ADD 
INDEX up_property ( 
up_property  );

-- Change constraint name of sites_domain 
ALTER TABLE sites DROP INDEX `sites_domain`;
ALTER TABLE sites ADD 
INDEX site_domain ( 
site_domain  );

-- Add the new index oi_timestamp in Table oldimage
ALTER TABLE `oldimage` 
ADD INDEX oi_timestamp ( oi_timestamp)
 ;
-- Change default value of rc_timestamp 
ALTER TABLE `recentchanges` CHANGE COLUMN `rc_timestamp` `rc_timestamp` BINARY(14) NOT NULL  ;
-- Change constraint name of change_tag_log_tag_id 
ALTER TABLE change_tag DROP INDEX `change_tag_log_tag_id`;
ALTER TABLE change_tag ADD 
UNIQUE INDEX ct_log_tag_id ( 
ct_log_id, ct_tag_id  );

-- Change constraint name of change_tag_tag_id_id 
ALTER TABLE change_tag DROP INDEX `change_tag_tag_id_id`;
ALTER TABLE change_tag ADD 
INDEX ct_tag_id_id ( 
ct_tag_id, ct_rc_id, ct_rev_id, ct_log_id  );

-- Change constraint name of sites_protocol 
ALTER TABLE sites DROP INDEX `sites_protocol`;
ALTER TABLE sites ADD 
INDEX site_protocol ( 
site_protocol  );

-- Change constraint name of page_time 
ALTER TABLE logging DROP INDEX `page_time`;
ALTER TABLE logging ADD 
INDEX log_page_time ( 
log_namespace, log_title, log_timestamp  );

-- Change constraint name of sites_type 
ALTER TABLE sites DROP INDEX `sites_type`;
ALTER TABLE sites ADD 
INDEX site_type ( 
site_type  );

-- Change constraint name of name_title_timestamp 
ALTER TABLE archive DROP INDEX `name_title_timestamp`;
ALTER TABLE archive ADD 
INDEX ar_name_title_timestamp ( 
ar_namespace, ar_title, ar_timestamp  );

-- Change constraint name of new_name_timestamp 
ALTER TABLE recentchanges DROP INDEX `new_name_timestamp`;
ALTER TABLE recentchanges ADD 
INDEX rc_new_name_timestamp ( 
rc_new, rc_namespace, rc_timestamp  );

-- Change constraint name of sites_source 
ALTER TABLE sites DROP INDEX `sites_source`;
ALTER TABLE sites ADD 
INDEX site_source ( 
site_source  );

-- Change constraint name of change_tag_rev_tag_id 
ALTER TABLE change_tag DROP INDEX `change_tag_rev_tag_id`;
ALTER TABLE change_tag ADD 
UNIQUE INDEX ct_rev_tag_id ( 
ct_rev_id, ct_tag_id  );

-- If executing the script fails, we suggest a rollback.
