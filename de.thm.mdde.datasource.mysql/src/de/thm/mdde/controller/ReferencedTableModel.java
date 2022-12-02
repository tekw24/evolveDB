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
