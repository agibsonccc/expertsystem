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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concept other = (Concept) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Concept [id=" + id + ", name=" + name + ", first=" + first
				+ ", second=" + second + "]";
	}
	
	
	
}
