USE media_wiki_1_40_0;

-- Remove constraint el_to from el_from 
ALTER TABLE externallinks DROP INDEX `el_from`,
ADD INDEX el_from ( el_from)
;


-- Add the new column el_to_path in Table externallinks
ALTER TABLE `externallinks` 
ADD COLUMN `el_to_path` BLOB(65535)   
 ;
-- Add the new column el_to_domain_index in Table externallinks
ALTER TABLE `externallinks` 
ADD COLUMN `el_to_domain_index` VARBINARY(255) NOT NULL  
DEFAULT '' ;
-- Add the new index el_to_domain_index_to_path in Table externallinks
ALTER TABLE `externallinks` 
ADD INDEX el_to_domain_index_to_path ( el_to_domain_index, el_to_path(60))
 ;
-- If executing the script fails, we suggest a rollback.
