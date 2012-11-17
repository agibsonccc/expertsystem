package com.ccc.sendalyzeit.expertsystem.service;

import java.util.Collection;

import javax.inject.Inject;

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

	public Collection<Concept> concepts() {
		return mongoTemplate.findAll(Concept.class);
	}

	public void deleteEntity(long id) {
		mongoTemplate.findAndRemove(Query.query(Criteria.where(String.valueOf(id)	)), Concept.class);
	}

	public void addConcept(Concept concept) {
		mongoTemplate.insert(concept);
	}

}
