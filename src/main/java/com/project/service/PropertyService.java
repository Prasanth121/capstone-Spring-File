package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.BookedDataProperty;
import com.project.dao.BookedPropertyRepository;
import com.project.dao.PropertyRepository;
import com.project.entity.BookedProperty;
import com.project.entity.Property;
import com.project.entity.UserDetail;

@Service
public class PropertyService {
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private BookedPropertyRepository bookedPropertyRepository;
	
	@Autowired
	private BookedDataProperty bookedDataProperty;
	
	public Property getFindById(int id) {
		return propertyRepository.findById(id);
	}
	
	public List<Property> getFindByLocation(String loc) {
		return propertyRepository.findByLocation(loc);
	}
	
	public List<Property> getFindByType(String type) {
		List<Property> list=propertyRepository.findAll();
		List<Property> searched= new ArrayList<>();
		for(Property lists: list) {
			if(lists.getProperty_type().equals(type)) {
				searched.add(lists);
			}
		}
		return searched;
	}
	
	public boolean insertBookedProperty(BookedProperty bookedProperty) {
		if(this.bookedPropertyRepository.save(bookedProperty) != null) {
			return true;
		}
		return false;
	}
	
	public BookedProperty getFindByBookedId(int id) {
		return bookedPropertyRepository.findById(id);
	}
	
	public Property getToAddPropertyData(Property property) {
		return propertyRepository.save(property);
	}
	
	public boolean updateProperty(Property property) {
		if (this.propertyRepository.existsById(property.getProperty_id())) {
			this.propertyRepository.save(property);
			return true;
		}
		return false;
	}
	
	public List<BookedProperty> getpropertyStatusPendingAll() {
		List<BookedProperty> list=bookedDataProperty.findAll();
		System.out.println(list);
		List<BookedProperty> searched= new ArrayList<>();
		for(BookedProperty lists: list) {
			if(lists.getStatus().equals("Pending")) {
				searched.add(lists);
			}
		}
		System.out.println(searched);
		return searched;
	}
	
	public boolean getPropertyStatusApproval(int id) {
		BookedProperty booked_property=bookedPropertyRepository.findById(id);
		booked_property.setStatus("Approved");
		bookedPropertyRepository.save(booked_property);
		System.out.println(booked_property);
		return true;
	}
}
