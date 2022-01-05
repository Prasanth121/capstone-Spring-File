package com.project.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.LoginUser;

@Repository
public interface LoginUserRepository extends CrudRepository<LoginUser, String> {

}
