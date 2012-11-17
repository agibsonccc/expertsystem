package com.ccc.sendalyzeit.expertsystem.service.api;

import java.util.Collection;

import com.ccc.sendalyzeit.expertsystem.model.Concept;
import com.ccc.sendalyzeit.expertsystem.model.Entity;

public interface AnalyticsService {
	//INCLUDE DESCRIPTIONS HERE
	public Collection<Concept> observeConcepts(String text);
	
	
	
	public Collection<Entity> observeEntities(String text);
	
}
