package de.thm.xtend

import de.thm.evolvedb.mdde.Database_Schema
import de.thm.evolvedb.mdde.Table
import de.thm.evolvedb.mdde.PrimaryKey
import de.thm.evolvedb.mdde.ForeignKey
import java.util.List
import de.thm.evolvedb.mdde.Column
import de.thm.evolvedb.mdde.DataType

class DuplicateDatabaseSchema {

	def String duplicateDatabaseSchema(Database_Schema schema) {

		var content = createHeader(schema.name)
		for(Table table : schema.entites)
			content += table.createTable
		return content

	}

	def String createTable(Table table) {

		var PrimaryKey primaryKey = table.columns.findFirst[it instanceof PrimaryKey] as PrimaryKey
		var List<ForeignKey> foreignKeys = table.columns.filter[it instanceof ForeignKey].map[it as ForeignKey].toList

		var List<Column> columns = table.columns.filter[it instanceof Column].toList
		columns.remove(primaryKey)
		columns.removeAll(foreignKeys)

		'''
			-- Create Table �table.name�
			DROP TABLE IF EXISTS `�table.name�`;
			/*!40101 SET @saved_cs_client     = @@character_set_client */;
			CREATE TABLE IF NOT EXISTS �table.name�  (
			�IF primaryKey !== null� 
				`DB_ID` bigint(�primaryKey.size�) NOT NULL AUTO_INCREMENT, 
				PRIMARY KEY (`DB_ID`)�IF foreignKeys.size > 0�,�ENDIF�
			�ENDIF�
			�FOR ForeignKey e : foreignKeys SEPARATOR ','�
				�IF e.referencedTable !== null�
				�e.name.toUpperCase� BIGINT�IF !e.type.equals(DataType.DATETIME)�(�e.size�)�ENDIF� �IF e.notNull�NOT NULL�ENDIF�,
				FOREIGN KEY (�e.name.toUpperCase�) REFERENCES �e.referencedTable.name�(DB_ID)
				�ENDIF�
			�ENDFOR�
			�FOR Column e : columns BEFORE ',' SEPARATOR ','�
				`�e.name�` �e.type��IF !e.type.equals(DataType.DATETIME)�(�e.size�)�ENDIF� �e.notNull !== null && e.notNull ? "NOT NULL" : ""� �e.autoIncrement !== null && e.autoIncrement ? "AUTO_INCREMENT" : ""�
			�ENDFOR�
			
			)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
			/*!40101 SET character_set_client = @saved_cs_client */;
			
			--
			-- Dumping data for table `�table.name�`
			--
			
			LOCK TABLES `�table.name�` WRITE, �table.schema.name�.`�table.name�` WRITE;
			/*!40000 ALTER TABLE `�table.name�` DISABLE KEYS */;
			INSERT INTO `�table.name.toLowerCase�`(�FOR Column e : table.columns SEPARATOR ','��e.name��ENDFOR�) SELECT �FOR Column e : table.columns SEPARATOR ','��e.name��ENDFOR� FROM �table.schema.name�.�table.name.toLowerCase�;
			/*!40000 ALTER TABLE `�table.name�` ENABLE KEYS */;
			UNLOCK TABLES;
			
		'''

	}

	def String createHeader(String schemaName) {

		'''
			CREATE DATABASE  IF NOT EXISTS `�schemaName�` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
			USE `marburg_2020`;
			
			/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
			/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
			/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
			 SET NAMES utf8 ;
			/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
			/*!40103 SET TIME_ZONE='+00:00' */;
			/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
			/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
			/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
			/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
		'''

	}

}
