package com.ccc.sendalyzeit.expertsystem.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccc.nlp.freya.interfaces.Concept;
import com.ccc.nlp.freya.interfaces.SemanticEntity;
import com.ccc.relationextraction.semantic.SemanticObservationService;
import com.ccc.sendalyzeit.expertsystem.model.TextHolder;
import com.ccc.sendalyzeit.expertsystem.service.api.AnalyticsService;

@Controller
@RequestMapping("/observe")
public class ObservationController {
	@Inject
	private AnalyticsService analyticsService;
	@Inject
	private SemanticObservationService semanticService;
	
	
	
	@RequestMapping(method=RequestMethod.POST,value="/entities",produces={MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public @ResponseBody Collection<SemanticEntity> entitiesForm(@ModelAttribute TextHolder holder,HttpServletResponse resp) throws  Exception {
		String text=holder.getText();
		Assert.hasLength(text,"Text must not be null!");
		return semanticService.getEntities(text);
	}
	@RequestMapping(method=RequestMethod.POST,value="/concepts",produces={MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public @ResponseBody Collection<Concept> conceptsForm(@ModelAttribute TextHolder holder,HttpServletResponse resp) throws Exception {
		String text=holder.getText();
		Assert.hasLength(text,"Text must not be null!");

		return semanticService.getConcepts(text);
	}
	@RequestMapping(method=RequestMethod.POST,value="/synset",produces={MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public @ResponseBody Map<String,? extends Object> synsetsForm(@ModelAttribute TextHolder holder,HttpServletResponse resp) throws Exception {
		String text=holder.getText();
		Assert.hasLength(text,"Text must not be null!");

		return semanticService.synset(text);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/textinfo",produces={MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public @ResponseBody Map<String,? extends Object> textInfoForm(@ModelAttribute TextHolder holder,HttpServletResponse resp) throws Exception {
		String text=holder.getText();
		Assert.hasLength(text,"Text must not be null!");

		return semanticService.textinfo(text);
	}
	
	
	
	
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Map<String, Collection<? extends Object>> map(@ModelAttribute HashMap<String,String> body,HttpServletResponse resp) throws  Exception {
		Map<String,Collection<? extends Object>> map = new HashMap<String,Collection<? extends Object>>();
		map.put("concepts",concepts(body,resp));
		map.put("entities",entities(body,resp));
		return map;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/entities",produces={MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Collection<SemanticEntity> entities(@RequestBody HashMap<String,String> map,HttpServletResponse resp) throws  Exception {
		String text=map.get("text");
		Assert.hasLength(text,"Text must not be null!");

		return semanticService.getEntities(text);
	}
	@RequestMapping(method=RequestMethod.POST,value="/concepts",produces={MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Collection<Concept> concepts(@RequestBody HashMap<String,String> body,HttpServletResponse resp) throws  Exception {
		String text=body.get("text");
		Assert.hasLength(text,"Text must not be null!");

		return semanticService.getConcepts(text);
	}
	@RequestMapping(method=RequestMethod.POST,value="/synset",produces={MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Map<String,? extends Object> synsets(@RequestBody HashMap<String,String> map,HttpServletResponse resp) throws Exception {
		String text=map.get("text");
		Assert.hasLength(text,"Text must not be null!");

		return semanticService.synset(text);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/textinfo",produces={MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Map<String,? extends Object> textInfo(@RequestBody HashMap<String,String> map,HttpServletResponse resp) throws Exception {
		String text=map.get("text");
		Assert.hasLength(text,"Text must not be null!");

		return semanticService.textinfo(text);
	}
	
	
}
