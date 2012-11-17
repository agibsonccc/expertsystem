package com.ccc.sendalyzeit.expertsystem.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ccc.sendalyzeit.expertsystem.model.Entity;
import com.ccc.sendalyzeit.expertsystem.service.api.EntityRepository;
@Repository("entityRepo")
public class EntityRepositoryImpl implements EntityRepository {
	@Inject
	private MongoTemplate mongoTemplate;
	
	private static Logger log=LoggerFactory.getLogger(EntityRepositoryImpl.class);
	public Entity findById(long id) {
		return mongoTemplate.findById(id, Entity.class);
	}
	@PostConstruct
	public void init() {
		createEntityDb();
	}

	public Entity findByName(String name) {
		Entity entity= mongoTemplate.findOne(Query.query(Criteria.where(name)), Entity.class);
		return entity;
	}



	public void deleteEntity(long id) {
		mongoTemplate.findAndRemove(Query.query(Criteria.where(String.valueOf(id))),Entity.class);
	}



	public List<Entity> entities() {
		return mongoTemplate.findAll(Entity.class);
	}



	public void addEntity(Entity entity) {
		mongoTemplate.insert(entity);
	}
	public void createEntityDb() {
		if(!mongoTemplate.collectionExists(Entity.class)) {
			mongoTemplate.createCollection(Entity.class);
			log.info("Created entity database");
		}
	}
	public void dropEntityDb() {
		mongoTemplate.dropCollection(Entity.class);
		log.info("Dropped entity db");
	}
	
}
