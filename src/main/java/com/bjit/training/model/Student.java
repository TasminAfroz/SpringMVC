package com.bjit.training.model;



public class Student {
	
	private Integer id;
	
	//@Digits(fraction = 0, integer = 2, message = "{student.age.number}")
	private Integer age;
	
	//@Size(max = 20, min = 3, message = "{student.name.empty}")
	private String name;
	
	//@Pattern(regexp=".+@.+\\.[a-z]+",  message = "{student.email.invalid}")
	private String email;
	
	private String password;

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}