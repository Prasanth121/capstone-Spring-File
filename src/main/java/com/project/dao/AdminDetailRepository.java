package com.project.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.AdminDetail;

@Repository
public interface AdminDetailRepository extends CrudRepository<AdminDetail, Integer> {

}
