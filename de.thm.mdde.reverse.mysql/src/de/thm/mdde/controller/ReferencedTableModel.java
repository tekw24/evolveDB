package de.thm.mdde.controller;

import de.thm.evolvedb.mdde.ForeignKey;

public class ReferencedTableModel {
	
	private ForeignKey foreignKey;
	private String referencedTableName;
	private String referencedColumnName;
	
	
	public ReferencedTableModel(ForeignKey foreignKey, String referencedTableName, String referencedColumnName) {
		super();
		this.foreignKey = foreignKey;
		this.referencedTableName = referencedTableName;
		this.referencedColumnName = referencedColumnName;
	}


	public ForeignKey getForeignKey() {
		return foreignKey;
	}


	public void setForeignKey(ForeignKey foreignKey) {
		this.foreignKey = foreignKey;
	}


	public String getReferencedTableName() {
		return referencedTableName;
	}


	public void setReferencedTableName(String referencedTableName) {
		this.referencedTableName = referencedTableName;
	}


	public String getReferencedColumnName() {
		return referencedColumnName;
	}


	public void setReferencedColumnName(String referencedColumnName) {
		this.referencedColumnName = referencedColumnName;
	}
	
	
	
	

}
