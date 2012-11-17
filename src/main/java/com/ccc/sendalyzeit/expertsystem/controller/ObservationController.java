package com.ccc.sendalyzeit.expertsystem.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.resource.ResourceInitializationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccc.sendalyzeit.expertsystem.model.Concept;
import com.ccc.sendalyzeit.expertsystem.model.Entity;
import com.ccc.sendalyzeit.expertsystem.service.api.AnalyticsService;

@Controller
@RequestMapping("/observe")
public class ObservationController {
	@Inject
	private AnalyticsService analyticsService;
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Map<String, Collection<? extends Object>> map(String text) throws AnalysisEngineProcessException, ResourceInitializationException, CollectionException, IOException, Exception {
		Map<String,Collection<? extends Object>> map = new HashMap<String,Collection<? extends Object>>();
		map.put("concepts",concepts(text));
		map.put("entities",entities(text));
		return map;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/entities")
	public @ResponseBody Collection<Entity> entities(String text) throws AnalysisEngineProcessException, ResourceInitializationException, CollectionException, IOException, Exception {
		return analyticsService.observeEntities(text);
	}
	@RequestMapping(method=RequestMethod.POST,value="/concepts")
	public @ResponseBody Collection<Concept> concepts(String text) throws AnalysisEngineProcessException, ResourceInitializationException, CollectionException, IOException, Exception {
		return analyticsService.observeConcepts(text);
	}
}
