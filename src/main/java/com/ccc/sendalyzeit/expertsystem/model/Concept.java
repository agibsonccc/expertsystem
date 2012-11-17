package com.ccc.sendalyzeit.expertsystem.model;

import java.io.Serializable;

public class Concept implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7354330136901440154L;

	private long id;
	
	private String name;
	
	private Entity first;
	
	private Entity second;

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

	public Entity getFirst() {
		return first;
	}

	public void setFirst(Entity first) {
		this.first = first;
	}

	public Entity getSecond() {
		return second;
	}

	public void setSecond(Entity second) {
		this.second = second;
	}
	
	
	
}
