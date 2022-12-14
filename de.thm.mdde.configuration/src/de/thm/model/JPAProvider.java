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
package de.thm.model;

public enum JPAProvider {
	
	HIBERNATE_5_4_0("Hibernate", "5.4.0"), HIBERNATE_6_0("Hibernate", "6.0"), ECLISPELINK_3_0("Eclipselink", "3.0"), ECLIPSELINK_2_7("Eclipselink", "2.7");
	
	public String name;
	public String version;
	
	private JPAProvider(String name, String version) {
		this.name = name;
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}
	
	public static JPAProvider getProvider(String value, String version) {
        for(JPAProvider v : values())
            if(v.getName().equalsIgnoreCase(value) && v.getVersion().equalsIgnoreCase(version)) return v;
        throw new IllegalArgumentException("Selected Jpa Provider is not supported!");
    }
	
	

}
