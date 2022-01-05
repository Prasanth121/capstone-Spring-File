package com.project.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Property;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Integer>{
	List<Property> findAll();
	
	Property findById(int property_id);
	
	List<Property> findByLocation(String location);
	
}
