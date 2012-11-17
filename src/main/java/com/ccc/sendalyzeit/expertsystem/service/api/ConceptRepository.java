package com.ccc.sendalyzeit.expertsystem.service.api;

import java.util.Collection;

import com.ccc.sendalyzeit.expertsystem.model.Concept;
import com.ccc.sendalyzeit.expertsystem.model.Entity;

public interface ConceptRepository {

	
	public void deleteEntity(long id);
	
	public Collection<Concept> concepts();
	
	public Concept findById(long id);
	
	public Concept findByName(String name);
	
	public Collection<Concept> conceptsForEntity(Entity entity);
	
}
