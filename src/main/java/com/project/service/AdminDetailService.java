package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.AdminDetailRepository;
import com.project.entity.AdminDetail;

@Service
public class AdminDetailService {
	
	@Autowired
	private AdminDetailRepository adminDetailRepository;
	
	public List<AdminDetail> getAllAdmin() {
		List<AdminDetail> adminList=new ArrayList<AdminDetail>();
		this.adminDetailRepository.findAll().forEach(admin->adminList.add(admin));
		return adminList;
	}

}
