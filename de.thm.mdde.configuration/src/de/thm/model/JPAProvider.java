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
