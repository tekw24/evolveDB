package de.thm.model;

public class ReverseDatabaseModel {
	
	private String host;
	private String user;
	private String schema;
	private String port;
	
	private JPAProvider jpaProvider;
	
	
	
	public ReverseDatabaseModel() {
		super();
	}
	
	public ReverseDatabaseModel(String host, String user, String schema, String port) {
		super();
		this.host = host;
		this.user = user;
		this.schema = schema;
		this.port = port;
	}
	
	public ReverseDatabaseModel(String host, String user, String schema, String port, JPAProvider jpaProvider) {
		super();
		this.host = host;
		this.user = user;
		this.schema = schema;
		this.port = port;
		this.jpaProvider = jpaProvider;
	}
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public JPAProvider getJpaProvider() {
		return jpaProvider;
	}
	public void setJpaProvider(JPAProvider jpaProvider) {
		this.jpaProvider = jpaProvider;
	}
	
	
	
	
	

}
