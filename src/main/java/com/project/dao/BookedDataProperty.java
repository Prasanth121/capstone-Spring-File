package com.project.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.BookedProperty;

@Repository
public interface BookedDataProperty extends CrudRepository<BookedProperty, Integer>{
	List<BookedProperty> findAll();
}
