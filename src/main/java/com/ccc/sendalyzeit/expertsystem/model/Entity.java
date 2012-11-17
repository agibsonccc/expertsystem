package com.ccc.sendalyzeit.expertsystem.model;

import java.io.Serializable;

public class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6491283819609612445L;
	
	private long id;
	
	private String name;
	
	private String type;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
