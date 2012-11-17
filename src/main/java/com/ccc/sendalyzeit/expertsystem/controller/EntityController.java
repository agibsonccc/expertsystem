package com.ccc.sendalyzeit.expertsystem.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccc.sendalyzeit.expertsystem.model.Entity;
import com.ccc.sendalyzeit.expertsystem.service.api.EntityRepository;

@RequestMapping("/entity")
@Controller
public class EntityController {
	@Inject
	private EntityRepository entityRepo;

	@ExceptionHandler(Exception.class)
	public @ResponseBody Map<String,String> exception(Exception e) {
		return Collections.singletonMap("status","internal error occurred");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Entity getById(@PathVariable("id") long id) {
		return entityRepo.findById(id);
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody Map<String,String> delete(@PathVariable("id") long id) {
		entityRepo.deleteEntity(id);
		return Collections.singletonMap("status","deleted");
	}
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Entity> entities() {
		return entityRepo.entities();
	}
	
	
}
