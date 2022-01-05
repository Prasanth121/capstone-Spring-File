package com.project.entity;



public class BookPropertyData {
	
	private String date_from;
	private String due_date;
	private int no_of_nights;
	private int no_of_rooms;
	private int subtotal;
	private int tax;
	private int total;
	
	public BookPropertyData() {
		
	}

	public BookPropertyData(String date_from, String due_date, int no_of_nights, int no_of_rooms, int subtotal, int tax,
			int total) {
		super();
		this.date_from = date_from;
		this.due_date = due_date;
		this.no_of_nights = no_of_nights;
		this.no_of_rooms = no_of_rooms;
		this.subtotal = subtotal;
		this.tax = tax;
		this.total = total;
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

	@Override
	public String toString() {
		return "BookPropertyData [date_from=" + date_from + ", due_date=" + due_date + ", no_of_nights=" + no_of_nights
				+ ", no_of_rooms=" + no_of_rooms + ", subtotal=" + subtotal + ", tax=" + tax + ", total=" + total + "]";
	}
	
	
	
}
