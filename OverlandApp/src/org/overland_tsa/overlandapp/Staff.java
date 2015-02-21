package org.overland_tsa.overlandapp;

import java.util.UUID;

public class Staff {
	
	// attributes
	private UUID mId;
	private String name;
	private String email;
	private String phone;
	private String department;
	
	// Staff constructor
	public Staff(String name, String email, String phone, String department) {
		this.mId = UUID.randomUUID();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.department = department;
	}
	
	//Get ID
	public UUID getId() {
		return mId;
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
