package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserDetailRepository;
import com.project.entity.UserDetail;

@Service
public class UserDetailService {
	
	@Autowired
	private UserDetailRepository userDetailRepository;
	
	public boolean insertUser(UserDetail userDetail) {
		if(!this.userDetailRepository.existsById(userDetail.getUserId())) {
			this.userDetailRepository.save(userDetail);
			return true;
		}
		return false;
	}

	public UserDetail getFindByEmail(String email) {
		return userDetailRepository.findByEmail(email);
	}
}
