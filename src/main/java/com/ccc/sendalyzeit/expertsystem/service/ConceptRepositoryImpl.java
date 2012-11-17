package com.ccc.sendalyzeit.expertsystem.service;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.ccc.sendalyzeit.expertsystem.model.Concept;
import com.ccc.sendalyzeit.expertsystem.model.Entity;
import com.ccc.sendalyzeit.expertsystem.service.api.ConceptRepository;
@Repository("conceptRepo")
public class ConceptRepositoryImpl implements ConceptRepository {

	public Concept findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Concept findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Concept> conceptsForEntity(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Concept> concepts() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteEntity(long id) {
		// TODO Auto-generated method stub
		
	}

}
