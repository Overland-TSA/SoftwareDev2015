package org.overland_tsa.overlandapp;

public class Staff {
	
	// attributes
	private String name;
	private String email;
	private String phone;
	private String department;
	
	// Staff constructor
	public Staff(String name, String email, String phone, String department) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.department = department;
	}
	
	// toString method
	public String toString() {
		return this.name + " - " + this.department;
	}
	
	// getter methods
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getDepartment() {
		return department;
	}
	
}
