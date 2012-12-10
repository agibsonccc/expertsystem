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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccc.relationextraction.semantic.SemanticObservationService;
import com.ccc.sendalyzeit.expertsystem.model.Concept;
import com.ccc.sendalyzeit.expertsystem.model.SemanticEntity;
import com.ccc.sendalyzeit.expertsystem.service.api.AnalyticsService;

@Controller
@RequestMapping("/observe")
public class ObservationController {
	@Inject
	private AnalyticsService analyticsService;
	@Inject
	private SemanticObservationService semanticService;
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Map<String, Collection<? extends Object>> map(@RequestBody Map<String,String> body) throws  Exception {
		Map<String,Collection<? extends Object>> map = new HashMap<String,Collection<? extends Object>>();
		map.put("concepts",concepts(body));
		map.put("entities",entities(body));
		return map;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/entities")
	public @ResponseBody Collection<SemanticEntity> entities(@RequestBody Map<String,String> map) throws AnalysisEngineProcessException, ResourceInitializationException, CollectionException, IOException, Exception {
		String text=map.get("text");
		return analyticsService.observeEntities(text);
	}
	@RequestMapping(method=RequestMethod.POST,value="/concepts")
	public @ResponseBody Collection<Concept> concepts(@RequestBody Map<String,String> body) throws AnalysisEngineProcessException, ResourceInitializationException, CollectionException, IOException, Exception {
		String text=body.get("text");
		return analyticsService.observeConcepts(text);
	}
	@RequestMapping(method=RequestMethod.POST,value="/synset")
	public @ResponseBody Map<String,? extends Object> synsets(@RequestBody Map<String,String> map) throws Exception {
		String text=map.get("text");
		return semanticService.synset(text);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/textinfo")
	public @ResponseBody Map<String,? extends Object> textInfo(@RequestBody Map<String,String> map) throws Exception {
		String text=map.get("text");
		return semanticService.textinfo(text);
	}
	
	
}
