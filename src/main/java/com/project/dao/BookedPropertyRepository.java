package com.project.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.BookedProperty;

@Repository
public interface BookedPropertyRepository extends CrudRepository<BookedProperty, Integer>{

	BookedProperty findById(int booked_id);
}
