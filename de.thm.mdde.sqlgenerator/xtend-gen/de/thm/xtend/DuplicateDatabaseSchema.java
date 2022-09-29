package de.thm.xtend;

import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.Database_Schema;
import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.PrimaryKey;
import de.thm.evolvedb.mdde.Table;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class DuplicateDatabaseSchema {
  public String duplicateDatabaseSchema(final Database_Schema schema) {
    String content = this.createHeader(schema.getName());
    EList<Table> _entites = schema.getEntites();
    for (final Table table : _entites) {
      String _content = content;
      String _createTable = this.createTable(table);
      content = (_content + _createTable);
    }
    return content;
  }

  public String createTable(final Table table) {
    String _xblockexpression = null;
    {
      final Function1<Column, Boolean> _function = (Column it) -> {
        return Boolean.valueOf((it instanceof PrimaryKey));
      };
      Column _findFirst = IterableExtensions.<Column>findFirst(table.getColumns(), _function);
      PrimaryKey primaryKey = ((PrimaryKey) _findFirst);
      final Function1<Column, Boolean> _function_1 = (Column it) -> {
        return Boolean.valueOf((it instanceof ForeignKey));
      };
      final Function1<Column, ForeignKey> _function_2 = (Column it) -> {
        return ((ForeignKey) it);
      };
      List<ForeignKey> foreignKeys = IterableExtensions.<ForeignKey>toList(IterableExtensions.<Column, ForeignKey>map(IterableExtensions.<Column>filter(table.getColumns(), _function_1), _function_2));
      final Function1<Column, Boolean> _function_3 = (Column it) -> {
        return Boolean.valueOf((it instanceof Column));
      };
      List<Column> columns = IterableExtensions.<Column>toList(IterableExtensions.<Column>filter(table.getColumns(), _function_3));
      columns.remove(primaryKey);
      columns.removeAll(foreignKeys);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-- Create Table �table.name�");
      _builder.newLine();
      _builder.append("DROP TABLE IF EXISTS `�table.name�`;");
      _builder.newLine();
      _builder.append("/*!40101 SET @saved_cs_client     = @@character_set_client */;");
      _builder.newLine();
      _builder.append("CREATE TABLE IF NOT EXISTS �table.name�  (");
      _builder.newLine();
      _builder.append("�IF primaryKey !== null� ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("`DB_ID` bigint(�primaryKey.size�) NOT NULL AUTO_INCREMENT, ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("PRIMARY KEY (`DB_ID`)�IF foreignKeys.size > 0�,�ENDIF�");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�FOR ForeignKey e : foreignKeys SEPARATOR \',\'�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF e.referencedTable !== null�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�e.name.toUpperCase� BIGINT�IF !e.type.equals(DataType.DATETIME)�(�e.size�)�ENDIF� �IF e.notNull�NOT NULL�ENDIF�,");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("FOREIGN KEY (�e.name.toUpperCase�) REFERENCES �e.referencedTable.name�(DB_ID)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("�FOR Column e : columns BEFORE \',\' SEPARATOR \',\'�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("`�e.name�` �e.type��IF !e.type.equals(DataType.DATETIME)�(�e.size�)�ENDIF� �e.notNull !== null && e.notNull ? \"NOT NULL\" : \"\"� �e.autoIncrement !== null && e.autoIncrement ? \"AUTO_INCREMENT\" : \"\"�");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.append(")ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;");
      _builder.newLine();
      _builder.append("/*!40101 SET character_set_client = @saved_cs_client */;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("--");
      _builder.newLine();
      _builder.append("-- Dumping data for table `�table.name�`");
      _builder.newLine();
      _builder.append("--");
      _builder.newLine();
      _builder.newLine();
      _builder.append("LOCK TABLES `�table.name�` WRITE, �table.schema.name�.`�table.name�` WRITE;");
      _builder.newLine();
      _builder.append("/*!40000 ALTER TABLE `�table.name�` DISABLE KEYS */;");
      _builder.newLine();
      _builder.append("INSERT INTO `�table.name.toLowerCase�`(�FOR Column e : table.columns SEPARATOR \',\'��e.name��ENDFOR�) SELECT �FOR Column e : table.columns SEPARATOR \',\'��e.name��ENDFOR� FROM �table.schema.name�.�table.name.toLowerCase�;");
      _builder.newLine();
      _builder.append("/*!40000 ALTER TABLE `�table.name�` ENABLE KEYS */;");
      _builder.newLine();
      _builder.append("UNLOCK TABLES;");
      _builder.newLine();
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }

  public String createHeader(final String schemaName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CREATE DATABASE  IF NOT EXISTS `�schemaName�` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;");
    _builder.newLine();
    _builder.append("USE `marburg_2020`;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;");
    _builder.newLine();
    _builder.append("/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;");
    _builder.newLine();
    _builder.append("/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("SET NAMES utf8 ;");
    _builder.newLine();
    _builder.append("/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;");
    _builder.newLine();
    _builder.append("/*!40103 SET TIME_ZONE=\'+00:00\' */;");
    _builder.newLine();
    _builder.append("/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;");
    _builder.newLine();
    _builder.append("/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;");
    _builder.newLine();
    _builder.append("/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE=\'NO_AUTO_VALUE_ON_ZERO\' */;");
    _builder.newLine();
    _builder.append("/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;");
    _builder.newLine();
    return _builder.toString();
  }
}
