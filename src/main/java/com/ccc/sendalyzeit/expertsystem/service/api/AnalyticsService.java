package com.ccc.sendalyzeit.expertsystem.service.api;

import java.io.IOException;
import java.util.Collection;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.resource.ResourceInitializationException;

import com.ccc.sendalyzeit.expertsystem.model.Concept;
import com.ccc.sendalyzeit.expertsystem.model.Entity;

public interface AnalyticsService {
	public Collection<Concept> observeConcepts(String text) throws AnalysisEngineProcessException, ResourceInitializationException, CollectionException, IOException, Exception;
	
	
	
	public Collection<Entity> observeEntities(String text) throws AnalysisEngineProcessException, ResourceInitializationException, CollectionException, IOException, Exception;
	
}
