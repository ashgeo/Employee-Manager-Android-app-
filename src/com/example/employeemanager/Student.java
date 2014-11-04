package com.example.employeemanager;

import android.app.Application;

public class Student  {
	private String name;
	private String age;
	private String address;

	public Student(String name, String age, String address) 
	
	{
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}