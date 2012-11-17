package com.ccc.sendalyzeit.expertsystem.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ccc.sendalyzeit.expertsystem.model.Entity;
import com.ccc.sendalyzeit.expertsystem.service.api.EntityRepository;
@Repository("entityRepo")
public class EntityRepositoryImpl implements EntityRepository {

	public Entity findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	public Entity findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}



	public void deleteEntity(long id) {
		// TODO Auto-generated method stub
		
	}



	public List<Entity> entities() {
		// TODO Auto-generated method stub
		return null;
	}

}
