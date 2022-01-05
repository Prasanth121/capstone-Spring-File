package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.LoginUserRepository;
import com.project.entity.LoginUser;

@Service
public class LoginUserService {
	
	@Autowired
	private LoginUserRepository loginUserRepository;
	
	public boolean insertUser(LoginUser loginUser) {
		if(!this.loginUserRepository.existsById(loginUser.getEmail())) {
			this.loginUserRepository.save(loginUser);
			return true;
		}
		return false;
	}
	
	public boolean insertAdmin(LoginUser loginAdmin) {
		if(!this.loginUserRepository.existsById(loginAdmin.getEmail())) {
			this.loginUserRepository.save(loginAdmin);
			return true;
		}
		return false;
	}
	
}
