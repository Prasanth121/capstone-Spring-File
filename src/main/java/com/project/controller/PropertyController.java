package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.RentAPlaceProjectApplication;
import com.project.dao.BookedDataProperty;
import com.project.dao.BookedPropertyRepository;
import com.project.dao.PropertyRepository;
import com.project.entity.BookPropertyData;
import com.project.entity.BookedProperty;
import com.project.entity.Property;
import com.project.entity.UserDetail;
import com.project.service.EmailSenderService;
import com.project.service.PropertyService;
import com.project.service.UserDetailService;

@RestController
@CrossOrigin
public class PropertyController {
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private PropertyService propertyService;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private BookedDataProperty bookedDataProperty;
	
	@Autowired
	private BookedPropertyRepository bookedPropertyRepository;
	
	@GetMapping("/getRooms")
	public List<Property> getAllProperty() {
		//System.out.println(propertyService.getFindById(5));
		return (List<Property>) propertyRepository.findAll();
	}
	
	@GetMapping("/getBookedData")
	public List<BookedProperty> getAllBookedData() {
		//System.out.println(propertyService.getFindById(5));
		return (List<BookedProperty>) bookedDataProperty.findAll();
	}
	
	@PostMapping("/propertyid")
	public Property getPropertyById(@RequestBody int id){
		return propertyService.getFindById(id);
	}
	
	@PostMapping("/prerpertyLocation")
	public List<Property> getPropertyByLocation(@RequestBody String location){	
		return propertyService.getFindByLocation(location);
	}
	
	@PostMapping("/prerpertyType")
	public List<Property> getPropertyByType(@RequestBody String type){	
		return propertyService.getFindByType(type);
	}
	
	@PostMapping("/bookProperty/{email}/{id}")
	public BookedProperty getStoreBookedProperty(@PathVariable int id,@PathVariable String email,@RequestBody BookPropertyData bookPropertyData) {
		System.out.println(id+"---"+email);
		Property property=propertyService.getFindById(id);
		UserDetail userDetail=userDetailService.getFindByEmail(email);
		System.out.println(property);
		System.out.println(userDetail);
		BookedProperty bookedProperty=new BookedProperty();
		bookedProperty.setUser_name(userDetail.getFirstname() +" "+userDetail.getLastname());
		bookedProperty.setUser_email(userDetail.getEmail());
		bookedProperty.setUser_phone(userDetail.getPhone());
		bookedProperty.setRoom_type(property.getProperty_type());
		bookedProperty.setRoom_name(property.getProperty_name());
		bookedProperty.setDate_from(bookPropertyData.getDate_from());
		bookedProperty.setDue_date(bookPropertyData.getDue_date());
		bookedProperty.setNo_of_nights(bookPropertyData.getNo_of_nights());
		bookedProperty.setNo_of_rooms(bookPropertyData.getNo_of_rooms());
		bookedProperty.setSubtotal(bookPropertyData.getSubtotal());
		bookedProperty.setTax(bookPropertyData.getTax());
		bookedProperty.setTotal(bookPropertyData.getTotal());
		bookedProperty.setProperty_address(property.getLocation());
		bookedProperty.setProperty_phone("9345754701");
		bookedProperty.setProperty_email("prasanthhero40@gmail.com");
		bookedProperty.setStatus("Pending");
		propertyService.insertBookedProperty(bookedProperty);
		System.out.println(bookedProperty);
		System.out.println(bookedProperty.getBooked_id());
		return bookedProperty;
	}
	@PostMapping("/addproperty")
	public Property getToAddProperty(@RequestBody Property property) {
		System.out.println("New Property Added");
		return propertyService.getToAddPropertyData(property);
	}
	
	@DeleteMapping("/deleteProperty/{id}")
	public boolean getDetetePropertyById(@PathVariable int id) {
		System.out.println(id);
		if (propertyRepository.findById(id) != null) {
			Property property= propertyRepository.findById(id);
			propertyRepository.delete(property);
			System.out.println("Property deleted");
			return true;
		}
		else {
			return false;
		}
		
	}
	
	@PostMapping("/editProperty")
	public boolean getEditProperty(@RequestBody Property property) {
		if(propertyService.updateProperty(property)) {
			System.out.println("Property Updated");
			System.out.println(property);
			return true;
		}
		else {
			return false;
		}
	}
	
	@GetMapping("/prorpertyStatusPendingAll")
	public List<BookedProperty> getprorpertyStatusPendingAll(){
		return propertyService.getpropertyStatusPendingAll();
	}
	
	@PostMapping("/prorpertyStatusApproval")
	public boolean getProrpertyStatusApproval(@RequestBody int id) {
		BookedProperty booked_data= bookedPropertyRepository.findById(id);
		service.emailForOwnerToUser("prasanth741999@gmail.com", "<html><head></head><body>Hello Sir, Your Property Booking Confirmed</body></html>","Booking Confirmation Approved");
		return propertyService.getPropertyStatusApproval(id);
	}
	
	
	@Autowired
	private EmailSenderService service;

	@EventListener(RentAPlaceProjectApplication.class)
	@PostMapping("/bookedPropertyId")
	public BookedProperty getPropertyByBookedId(@RequestBody int id) throws MessagingException {
		BookedProperty booked_data= bookedPropertyRepository.findById(id);
		service.emailForUsertoOwner(booked_data.getUser_email(),"havenlife3181@gmail.com",
				"New booking Confirmataion\nProperty Name :"+booked_data.getRoom_name()+"\n\nName :"+booked_data.getUser_name()+"\nPhone :"+booked_data.getUser_phone()
				+"\n\n     PRICE     \n--------------------------\nSubtotal :"+booked_data.getSubtotal()+"\nTax     :"+booked_data.getTax()+
				"\n\n--------------------------\n\n TOTAL   :"+booked_data.getTotal()+"\n\n************\n*****************\n**************************",
				"Property Booking Confirmation From "+booked_data.getDate_from()+" - "+booked_data.getDue_date());
		return propertyService.getFindByBookedId(id);
	}
	
	
}
