package com.bjit.training.model;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	private int id;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Size(max = 20, min = 3, message = "Name entered is invalid. It must be between {2} and {1} characters.")
	private String name;

	@Email(message = "Invalid email! Please enter valid email.")
	private String email;

//	@NotEmpty(message = "Select gender.")
	private int gender;
	
	@NotEmpty(message = "Give address.")
	private String address;
	

//	@NotEmpty(message = "Give role.")
	private int role;
	
	
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	private String password;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
//	@Size(max = 20, min = 3, message = "Password length should be between 3-20")
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	@NotEmpty(message = "Select at least one language.")
//	private List<String> languages;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
//
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}


}