package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookedProperty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int booked_id;
	private String user_name;
	private String user_email;
	private String user_phone;
	private String room_type;
	private String room_name;
	private String date_from;
	private String due_date;
	private int no_of_nights;
	private int no_of_rooms;
	private int subtotal;
	private int tax;
	private int total;
	private String property_address;
	private String property_phone;
	private String property_email;
	private String status;
	
	public BookedProperty() {
		
	}

	public BookedProperty(String user_name, String user_email, String user_phone, String room_type, String room_name,
			String date_from, String due_date, int no_of_nights, int no_of_rooms, int subtotal, int tax, int total,
			String property_address, String property_phone, String property_email,String status) {
		super();
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.room_type = room_type;
		this.room_name = room_name;
		this.date_from = date_from;
		this.due_date = due_date;
		this.no_of_nights = no_of_nights;
		this.no_of_rooms = no_of_rooms;
		this.subtotal = subtotal;
		this.tax = tax;
		this.total = total;
		this.property_address = property_address;
		this.property_phone = property_phone;
		this.property_email = property_email;
		this.status=status;
	}

	public int getBooked_id() {
		return booked_id;
	}

	public void setBooked_id(int booked_id) {
		this.booked_id = booked_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getDate_from() {
		return date_from;
	}

	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public int getNo_of_nights() {
		return no_of_nights;
	}

	public void setNo_of_nights(int no_of_nights) {
		this.no_of_nights = no_of_nights;
	}

	public int getNo_of_rooms() {
		return no_of_rooms;
	}

	public void setNo_of_rooms(int no_of_rooms) {
		this.no_of_rooms = no_of_rooms;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getProperty_address() {
		return property_address;
	}

	public void setProperty_address(String property_address) {
		this.property_address = property_address;
	}

	public String getProperty_phone() {
		return property_phone;
	}

	public void setProperty_phone(String property_phone) {
		this.property_phone = property_phone;
	}

	public String getProperty_email() {
		return property_email;
	}

	public void setProperty_email(String property_email) {
		this.property_email = property_email;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookedProperty [booked_id=" + booked_id + ", user_name=" + user_name + ", user_email=" + user_email
				+ ", user_phone=" + user_phone + ", room_type=" + room_type + ", room_name=" + room_name
				+ ", date_from=" + date_from + ", due_date=" + due_date + ", no_of_nights=" + no_of_nights
				+ ", no_of_rooms=" + no_of_rooms + ", subtotal=" + subtotal + ", tax=" + tax + ", total=" + total
				+ ", property_address=" + property_address + ", property_phone=" + property_phone + ", property_email="
				+ property_email + ", status=" + status + "]";
	}

	
	
	
}

