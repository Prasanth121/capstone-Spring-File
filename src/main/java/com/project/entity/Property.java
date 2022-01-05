package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int property_id;
	private String property_name;
	private String property_type;
	private String location;
	private String max_guest;
	private String address;
	private int rooms;
	private double room_size;
	private String property_line_content;
	private String more_info;
	private int beds;
	private int price;
	private float ratings;
	
	public Property() {
		
	}

	public Property(String property_name, String property_type, String location, String max_guest, String address, int rooms,
			double room_size, String property_line_content, String more_info, int beds, int price, float ratings) {
		super();
		this.property_name = property_name;
		this.property_type = property_type;
		this.location = location;
		this.max_guest = max_guest;
		this.address=address;
		this.rooms = rooms;
		this.room_size = room_size;
		this.property_line_content = property_line_content;
		this.more_info = more_info;
		this.beds = beds;
		this.price = price;
		this.ratings = ratings;
	}

	public int getProperty_id() {
		return property_id;
	}

	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}

	public String getProperty_name() {
		return property_name;
	}

	public void setProperty_name(String property_name) {
		this.property_name = property_name;
	}

	public String getProperty_type() {
		return property_type;
	}

	public void setProperty_type(String property_type) {
		this.property_type = property_type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMax_guest() {
		return max_guest;
	}

	public void setMax_guest(String max_guest) {
		this.max_guest = max_guest;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public double getRoom_size() {
		return room_size;
	}

	public void setRoom_size(double room_size) {
		this.room_size = room_size;
	}

	public String getProperty_line_content() {
		return property_line_content;
	}

	public void setProperty_line_content(String property_line_content) {
		this.property_line_content = property_line_content;
	}

	public String getMore_info() {
		return more_info;
	}

	public void setMore_info(String more_info) {
		this.more_info = more_info;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Property [property_id=" + property_id + ", property_name=" + property_name + ", property_type="
				+ property_type + ", location=" + location + ", max_guest=" + max_guest + ", address=" + address
				+ ", rooms=" + rooms + ", room_size=" + room_size + ", property_line_content=" + property_line_content
				+ ", more_info=" + more_info + ", beds=" + beds + ", price=" + price + ", ratings=" + ratings + "]";
	}

	
	
	
	
	
	
	
}
