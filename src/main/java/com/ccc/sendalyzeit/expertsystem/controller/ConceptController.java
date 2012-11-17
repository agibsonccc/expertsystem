package com.ccc.sendalyzeit.expertsystem.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccc.sendalyzeit.expertsystem.model.Concept;
import com.ccc.sendalyzeit.expertsystem.service.api.ConceptRepository;

@Controller
@RequestMapping("/concept")
public class ConceptController {
	@Inject
	private ConceptRepository conceptRepository;
	@ExceptionHandler(Exception.class)
	public @ResponseBody Map<String,String> exception(Exception e) {
		return Collections.singletonMap("status","internal error occurred");
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public @ResponseBody Concept byId(@PathVariable("id") long id) {
		return conceptRepository.findById(id);
	}
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Collection<Concept> concepts() {
		return conceptRepository.concepts();
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public @ResponseBody Map<String,String> delete(@PathVariable("id") long id ) {
		conceptRepository.deleteEntity(id);
		return Collections.singletonMap("status","deleted");
	}
	
}
