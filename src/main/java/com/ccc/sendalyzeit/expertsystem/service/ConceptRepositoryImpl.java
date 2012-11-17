package com.ccc.sendalyzeit.expertsystem.service;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ccc.sendalyzeit.expertsystem.model.Concept;
import com.ccc.sendalyzeit.expertsystem.model.Entity;
import com.ccc.sendalyzeit.expertsystem.service.api.ConceptRepository;

@Repository("conceptRepo")
public class ConceptRepositoryImpl implements ConceptRepository {
	@Inject
	private MongoTemplate mongoTemplate;

	
	private static Logger log=LoggerFactory.getLogger(ConceptRepositoryImpl.class);
	public Concept findById(long id) {
		return mongoTemplate.findById(id, Concept.class);
	}

	public Concept findByName(String name) {
		return mongoTemplate.findOne(Query.query(Criteria.where(name)), Concept.class);
	}

	public Collection<Concept> conceptsForEntity(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@PostConstruct
	public void init() {
		createConceptDb();
	}
	public Collection<Concept> concepts() {
		return mongoTemplate.findAll(Concept.class);
	}

	public void deleteEntity(long id) {
		mongoTemplate.findAndRemove(Query.query(Criteria.where(String.valueOf(id)	)), Concept.class);
	}

	public void addConcept(Concept concept) {
		mongoTemplate.insert(concept);
	}

	public void createConceptDb() {
		if(!mongoTemplate.collectionExists(Concept.class)) {
			mongoTemplate.createCollection(Concept.class);
			log.info("Created concept database");
		}
	}

}
