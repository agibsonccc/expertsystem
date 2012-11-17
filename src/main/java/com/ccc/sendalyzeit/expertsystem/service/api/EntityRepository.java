package com.ccc.sendalyzeit.expertsystem.service.api;

import java.util.List;

import com.ccc.sendalyzeit.expertsystem.model.Entity;

public interface EntityRepository {
	public void createEntityDb();
	public void addEntity(Entity entity);
	
	public List<Entity> entities();
	
	public Entity findById(long id);
	
	public Entity findByName(String name);
	
	public void deleteEntity(long id);
}
