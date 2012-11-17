package com.ccc.sendalyzeit.expertsystem.service;

import java.util.List;

import javax.inject.Inject;

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
	public Entity findById(long id) {
		return mongoTemplate.findById(id, Entity.class);
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

}
