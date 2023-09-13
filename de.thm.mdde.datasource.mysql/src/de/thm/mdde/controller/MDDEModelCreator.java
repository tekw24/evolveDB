/*
 * EvolveDB - Model Driven Schema Evolution
 * Copyright Technische Hochschule Mittelhessen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.thm.mdde.controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.thm.de.util.DataTypeUtil;
import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.ColumnConstraint;
import de.thm.evolvedb.mdde.Constraint;
import de.thm.evolvedb.mdde.Database_Schema;
import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.Index;
import de.thm.evolvedb.mdde.IndexType;
import de.thm.evolvedb.mdde.MddeFactory;
import de.thm.evolvedb.mdde.MddePackage;
import de.thm.evolvedb.mdde.PrimaryKey;
import de.thm.evolvedb.mdde.Referential_Action;
import de.thm.evolvedb.mdde.SortSequence;
import de.thm.evolvedb.mdde.Table;
import de.thm.evolvedb.mdde.UniqueConstraint;

public class MDDEModelCreator {

	protected MddePackage mddePackage = MddePackage.eINSTANCE;
	protected MddeFactory mddeFactory = mddePackage.getMddeFactory();

	public EObject create(DatabaseMetaData dmd, String schema) {

		Database_Schema root = (Database_Schema) createInitialModel();
		root.setName(schema);

		try {

			String productName = dmd.getDatabaseProductName();
			String productVersion = dmd.getDatabaseProductVersion();
			root.setLocation(productName != null ? productName : "");
			root.setVersion(productVersion != null ? productVersion : "");

			String[] types = { "TABLE" };
			// TABLe_CAT --> Schema
			ResultSet rs = dmd.getTables(schema, null, "%", types);
			Map<String, Table> entityMap = new TreeMap<String, Table>();
			Map<String, ArrayList<ForeignKey>> foreignKeyMap = new TreeMap<>();
			Map<String, ArrayList<ReferencedTableModel>> foreignKeyReferenceMap = new TreeMap<>();
			Map<String, String> index = new TreeMap<>();

			List<ReferencedTableModel> referencedTableModels = new ArrayList<ReferencedTableModel>();

			while (rs.next()) {
				String tableName = rs.getString("TABLE_NAME");
				System.out.print(rs.getString("TABLE_NAME") + "--> ");
				System.out.println(rs.getString("TABLE_CAT"));

				Table table = (Table) mddeFactory.create(mddePackage.getTable());
				table.setName(tableName);
				table.setSchema(root);
				root.getEntites().add(table);

				ResultSet rsAttributes = dmd.getColumns(schema, null, tableName, "%");
				ResultSet primaryKeys = dmd.getPrimaryKeys(schema, null, tableName);
				ResultSet foreignKeys = dmd.getImportedKeys(schema, null, tableName);
				ResultSet indices = dmd.getIndexInfo(schema, null, tableName, true, false);

				ResultSet indexConstraints = dmd.getIndexInfo(schema, null, tableName, false, false);

				Map<String, List<String>> uniqueIndex = new TreeMap<String, List<String>>();
				Map<String, List<IndexInfo>> columnindex = new TreeMap<String, List<IndexInfo>>();

				while (indices.next()) {
					System.out.println(indices.getString("COLUMN_NAME"));
					System.out.println(indices.getString("INDEX_NAME"));
					System.out.println(indices.getString("TABLE_NAME"));

					if (indices.getString("INDEX_NAME").equals("PRIMARY")) {
						continue;
					}

					System.out.println(indices.getShort("TYPE"));
					System.out.println(indices.getString("ASC_OR_DESC"));
					System.out.println(indices.getString("INDEX_QUALIFIER"));

					Long qualifier = indices.getLong("CARDINALITY");
					if (qualifier != null && qualifier > 0)
						System.out.println("Stop");

					Long pages = indices.getLong("PAGES");
					if (pages != null && qualifier > 0)
						System.out.println("Stop");

					System.out.println("tableIndexStatistic " + DatabaseMetaData.tableIndexStatistic);
					System.out.println("tableIndexClustered  " + DatabaseMetaData.tableIndexClustered);
					System.out.println("tableIndexHashed  " + DatabaseMetaData.tableIndexHashed);
					System.out.println("tableIndexOther " + DatabaseMetaData.tableIndexOther);

					if (indices.getShort("TYPE") == DatabaseMetaData.tableIndexOther) {
						String name = indices.getString("INDEX_NAME");
						index.put(indices.getString("COLUMN_NAME"), indices.getString("INDEX_NAME"));

						if (uniqueIndex.containsKey(name))
							uniqueIndex.get(name).add(indices.getString("COLUMN_NAME"));
						else {
							ArrayList<String> columns = new ArrayList<>();
							columns.add(indices.getString("COLUMN_NAME"));
							uniqueIndex.put(name, columns);
						}
					}

				}

				while (indexConstraints.next()) {
					System.out.println(indexConstraints.getString("COLUMN_NAME"));
					System.out.println(indexConstraints.getString("INDEX_NAME"));
					System.out.println(indexConstraints.getString("TABLE_NAME"));
					System.out.println(indexConstraints.getShort("TYPE"));
					System.out.println(indexConstraints.getString("ASC_OR_DESC"));
					System.out.println(indexConstraints.getString("INDEX_QUALIFIER"));

					System.out.println("tableIndexStatistic " + DatabaseMetaData.tableIndexStatistic);
					System.out.println("tableIndexClustered  " + DatabaseMetaData.tableIndexClustered);
					System.out.println("tableIndexHashed  " + DatabaseMetaData.tableIndexHashed);
					System.out.println("tableIndexOther " + DatabaseMetaData.tableIndexOther);

					System.out.println(indexConstraints.getString("FILTER_CONDITION"));
					System.out.println(indexConstraints.getShort("ORDINAL_POSITION"));

					String name = indexConstraints.getString("INDEX_NAME");
					// The method returns all Index Constraints whether unique or not

					if (uniqueIndex.containsKey(name) || name.equals("PRIMARY"))
						continue;

					String asc_or_desc = indexConstraints.getString("ASC_OR_DESC");

					SortSequence sortSequence = null;
					if (asc_or_desc != null) {

						switch (asc_or_desc) {
						case "A":
							sortSequence = SortSequence.ASCENDING;
							break;
						case "D":
							sortSequence = SortSequence.DESCENDING;
							break;

						default:
							sortSequence = SortSequence.ASCENDING;
							break;
						}

					}

					Long qualifier = indexConstraints.getLong("CARDINALITY");
					if (qualifier != null && qualifier > 0)
						System.out.println("Stop");

					Long pages = indexConstraints.getLong("PAGES");
					if (pages != null && qualifier > 0)
						System.out.println("Stop");

					IndexInfo indexInfo = new IndexInfo(indexConstraints.getString("COLUMN_NAME"), 0L, sortSequence);

					if (columnindex.containsKey(name)) {

						columnindex.get(name).add(indexInfo);
					} else {
						ArrayList<IndexInfo> columns = new ArrayList<>();
						columns.add(indexInfo);
						columnindex.put(name, columns);
					}

				}

				// get index subparts
				if (columnindex.size() > 0) {
					Connection con = dmd.getConnection();
					Statement stm = con.createStatement();

					String query = "SHOW INDEXES FROM " + tableName;
					ResultSet set = stm.executeQuery(query);
					

					while (set.next()) {
						System.out.println("SubPart " + set.getString("Key_name"));
						System.out.println("SubPart " + set.getString("Column_name"));
						System.out.println("SubPart " + set.getLong("Sub_part"));
						
						if(set.getString("Column_name").equals("si_title"))
							System.out.println("Stop");
						
						Long subPart = set.getLong("Sub_part");

						if (subPart != null && subPart > 0) {
							String columnName = set.getString("Column_name");
							String keyString = set.getString("Key_name");
							List<IndexInfo> indexInfos = columnindex.get(keyString);
							if (indexInfos == null)
								continue;
							for (IndexInfo i : indexInfos) {
								if (i.getColumnName().equals(columnName)) {
									i.setLength(subPart);
								}
							}
						}
						String indexType = set.getString("Index_type");
						if(indexType != null) {
							String columnName = set.getString("Column_name");
							String keyString = set.getString("Key_name");
							List<IndexInfo> indexInfos = columnindex.get(keyString);
							if (indexInfos == null)
								continue;
							for (IndexInfo i : indexInfos) {
								if (i.getColumnName().equals(columnName)) {
									i.setType(indexType);
								}
							}
						}

					}
				}

				Map<String, Column> attributeMap = new TreeMap<String, Column>();

				List<String> primaryKeyNames = new ArrayList<String>();
				while (primaryKeys.next()) {
					primaryKeyNames.add(primaryKeys.getString("COLUMN_NAME"));
				}

				while (foreignKeys.next()) {
					ForeignKey foreignKey = (ForeignKey) mddeFactory.create(mddePackage.getForeignKey());
					foreignKey.setName(foreignKeys.getString("FKCOLUMN_NAME"));
					foreignKey.setAutoIncrement(false);
					foreignKey.setPrimaryForeignKey(false);

					String constraint_name = foreignKeys.getString("FK_NAME");
					foreignKey.setConstraintName(constraint_name);
					Short updateRule = foreignKeys.getShort("UPDATE_RULE");
					Short deleteRule = foreignKeys.getShort("DELETE_RULE");

					foreignKey.setOnUpdate(Referential_Action.get(updateRule));
					foreignKey.setOnDelete(Referential_Action.get(deleteRule));

					String pkTableName = foreignKeys.getString("PKTABLE_NAME");
					String pkColumnName = foreignKeys.getString("PKCOLUMN_NAME");

					// The table might not have been created yet.
					if (foreignKeyMap.containsKey(pkTableName))
						foreignKeyMap.get(pkTableName).add(foreignKey);
					else {
						ArrayList<ForeignKey> list = new ArrayList<ForeignKey>();
						list.add(foreignKey);
						foreignKeyMap.put(pkTableName, list);
					}

					String pk_table = foreignKeys.getString("PKTABLE_NAME");
					String pk_column = foreignKeys.getString("PKCOLUMN_NAME");
					// System.out.println(" "+column_name+" reference to "+
					// pk_table+"("+constraint_name+")");

					referencedTableModels.add(new ReferencedTableModel(foreignKey, pk_table, pk_column));
					attributeMap.put(foreignKeys.getString("FKCOLUMN_NAME"), foreignKey);

					// The table might not have been created yet.
					if (foreignKeyReferenceMap.containsKey(pk_table))
						foreignKeyReferenceMap.get(pk_table)
								.add(new ReferencedTableModel(foreignKey, pk_table, pk_column));
					else {
						ArrayList<ReferencedTableModel> list = new ArrayList<ReferencedTableModel>();
						list.add(new ReferencedTableModel(foreignKey, pk_table, pk_column));
						foreignKeyReferenceMap.put(pk_table, list);
					}

				}

				while (rsAttributes.next()) {
//					System.out.print(rsAttributes.getString("COLUMN_NAME") + " : ");
//					System.out.println(rsAttributes.getString("TYPE_NAME"));

//					ResultSetMetaData rsmd = rs.getMetaData();
//					int nullable = rsmd.isNullable(rs.findColumn(rsAttributes.getString("COLUMN_NAME")));

					if (!attributeMap.containsKey(rsAttributes.getString("COLUMN_NAME"))) {
						Column attribute;

						if (primaryKeyNames.contains(rsAttributes.getString("COLUMN_NAME")))
							attribute = (PrimaryKey) mddeFactory.create(mddePackage.getPrimaryKey());
						else
							attribute = (Column) mddeFactory.create(mddePackage.getColumn());
						attribute.setName(rsAttributes.getString("COLUMN_NAME"));
						attribute.setType(DataTypeUtil.findDataTypeByLiteral(rsAttributes.getString("TYPE_NAME")));
						setColumnSize(attribute, rsAttributes);
						String defaultValue = rsAttributes.getString("COLUMN_DEF");
						if (defaultValue != null && defaultValue.isEmpty())
							attribute.setDefaultValue("''");
						else
							attribute.setDefaultValue(rsAttributes.getString("COLUMN_DEF"));
						// Method returns YES or NO
						attribute.setAutoIncrement(rsAttributes.getString("IS_AUTOINCREMENT").equals("YES"));
						// attribute.setPrimaryKey(false);
						// attribute.setNotNull(nullable == ResultSetMetaData.columnNoNulls);
						attribute.setNotNull(!rsAttributes.getString("IS_NULLABLE").equals("YES"));
						attributeMap.put(rsAttributes.getString("COLUMN_NAME"), attribute);
						// Check if the column has the uniqe flag
//						if (index.containsKey(attribute.getName())) {
//							attribute.setUnique(true);
//							attribute.setUniqueConstraintName(index.get(attribute.getName()));
//						}

					} else {
						ForeignKey key = (ForeignKey) attributeMap.get(rsAttributes.getString("COLUMN_NAME"));
						key.setType(DataTypeUtil.findDataTypeByLiteral(rsAttributes.getString("TYPE_NAME")));
						setColumnSize(key, rsAttributes);
						key.setAutoIncrement(rsAttributes.getString("IS_AUTOINCREMENT").equals("YES"));
						key.setNotNull(!rsAttributes.getString("IS_NULLABLE").equals("YES"));

						// Check if the column has the uniqe flag
//						if (index.containsKey(key.getName())) {
//							key.setUnique(true);
//							key.setUniqueConstraintName(index.get(key.getName()));
//						}

					}

				}

				// Add Unique Constraints
				for (Entry<String, List<String>> entry : uniqueIndex.entrySet()) {
					UniqueConstraint unique = (UniqueConstraint) mddeFactory.create(mddePackage.getUniqueConstraint());
					unique.setName(entry.getKey());
					table.getConstraints().add(unique);
					unique.setTable(table);

					for (String name : entry.getValue()) {
						Column column = attributeMap.get(name);
						ColumnConstraint columnConstraint = (ColumnConstraint) mddeFactory
								.create(mddePackage.getColumnConstraint());
						unique.getColumns().add(columnConstraint);
						column.getConstraints().add(columnConstraint);
						columnConstraint.setColumn(column);
						columnConstraint.setConstraint(unique);
					}
				}

				// Add index constraints
				for (Entry<String, List<IndexInfo>> entry : columnindex.entrySet()) {
					Index indexconstraint = (Index) mddeFactory.create(mddePackage.getIndex());
					indexconstraint.setName(entry.getKey());
					table.getConstraints().add(indexconstraint);
					indexconstraint.setTable(table);
					
					String indexType = "";
					for (IndexInfo indexInfo : entry.getValue()) {
						Column column = attributeMap.get(indexInfo.getColumnName());
						ColumnConstraint columnConstraint = (ColumnConstraint) mddeFactory
								.create(mddePackage.getColumnConstraint());
						columnConstraint.setLength(indexInfo.getLength());
						indexconstraint.getColumns().add(columnConstraint);
						column.getConstraints().add(columnConstraint);
						columnConstraint.setColumn(column);
						columnConstraint.setConstraint(indexconstraint);
						indexType = indexInfo.getType();
						
						
						
					}
					if(indexType.equals("FULLTEXT")) {
						System.out.println();
					}
					switch (indexType) {
					case "FULLTEXT":
						indexconstraint.setType(IndexType.FULLTEXT);
						break;
					case "SPATIAL":
						indexconstraint.setType(IndexType.SPATIAL);
						break;
					default:
						indexconstraint.setType(IndexType.INDEX);
						break;
					}
					
				}

				for (String name : primaryKeyNames) {
					Column column = attributeMap.get(name);
					if (column != null) {
						if (column instanceof PrimaryKey)
							((PrimaryKey) column).setPrimaryKey(true);
						else if (column instanceof ForeignKey) {
							((ForeignKey) column).setPrimaryForeignKey(true);
						}
					}

				}

				primaryKeys.close();
				rsAttributes.close();
				foreignKeys.close();

				for (Map.Entry<String, Column> mapEntry : attributeMap.entrySet()) {
					mapEntry.getValue().setTable(table);
					table.getColumns().add(mapEntry.getValue());
				}

				entityMap.put(tableName, table);

			}

			for (Entry<String, ArrayList<ForeignKey>> entry : foreignKeyMap.entrySet()) {
				Table entity = entityMap.get(entry.getKey());

				for (ReferencedTableModel model : foreignKeyReferenceMap.get(entity.getName())) {
					ForeignKey foreignKey = model.getForeignKey();
					foreignKey.setReferencedTable(entity);
					foreignKey.setReferencedKeyColumn(entity.getPrimaryKeyByName(model.getReferencedColumnName()));
				}

//				for(ForeignKey key : entry.getValue()) {
//					key.setReferencedTable(entity);
//					key.setReferencedKeyColumn(entity.getPrimaryKeyByName(pkColumn));
//				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return root;
	}

	/**
	 * Create a new model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EObject createInitialModel() {
		EClass eClass = mddePackage.getDatabase_Schema();
		EObject rootObject = mddeFactory.create(eClass);
		return rootObject;
	}

	private void setColumnSize(Column column, ResultSet rsAttributes) throws SQLException {
		if (DataTypeUtil.textTypes.contains(column.getType()))
			column.setSize(String.valueOf(rsAttributes.getInt("COLUMN_SIZE")));
		else if (DataTypeUtil.decimalTypes.contains(column.getType())) {
			String size = String.valueOf(rsAttributes.getInt("COLUMN_SIZE"));
			int fd = rsAttributes.getInt("DECIMAL_DIGITS");
			column.setSize(size + "." + fd);
		} else if (DataTypeUtil.dateTypesWithFraction.contains(column.getType())) {
			int size = rsAttributes.getInt("COLUMN_SIZE");
			if (size > 19)
				// No fractional digits
				// 19 column size + one character for the dot
				column.setSize(String.valueOf(size - 20));
			else {
				// No fractional digits
				column.setSize(String.valueOf(0));
			}
		} else if (!DataTypeUtil.typesWithoutSize.contains(column.getType())) {
			column.setSize(String.valueOf(rsAttributes.getInt("COLUMN_SIZE")));
		}
	}

	private class IndexInfo {
		String columnName;
		Long length;
		SortSequence sortSequence;
		String type;

		/**
		 * @param columnName
		 * @param sortSequence
		 */
		public IndexInfo(String columnName, SortSequence sortSequence, String type) {
			super();
			this.columnName = columnName;
			this.sortSequence = sortSequence;
			this.type = type;
		}

		/**
		 * @param columnName
		 * @param length
		 * @param sortSequence
		 */
		public IndexInfo(String columnName, Long length, SortSequence sortSequence, String type) {
			super();
			this.columnName = columnName;
			this.length = length;
			this.sortSequence = sortSequence;
			this.type = type;
		}
		
		

		/**
		 * @param columnName
		 * @param sortSequence
		 */
		public IndexInfo(String columnName,Long length, SortSequence sortSequence) {
			super();
			this.columnName = columnName;
			this.sortSequence = sortSequence;
			this.length = length;
		}

		public String getColumnName() {
			return columnName;
		}

		public void setColumnName(String columnName) {
			this.columnName = columnName;
		}

		public Long getLength() {
			return length;
		}

		public void setLength(Long length) {
			this.length = length;
		}

		public SortSequence getSortSequence() {
			return sortSequence;
		}

		public void setSortSequence(SortSequence sortSequence) {
			this.sortSequence = sortSequence;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
		

	}

}
