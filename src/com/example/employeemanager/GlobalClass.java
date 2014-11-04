package com.example.employeemanager;

import android.app.Application;

public class GlobalClass extends Application {
	private String name;
	private String email;
	private int position;

	public String getName() {
		return name;
	}

	public void setName(String aName) {
		name = aName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String aEmail) {
		email = aEmail;
	}
	
	public String getEmpcode() {
		return email;
	}

	public void setEmpCode(String aEmail) {
		email = aEmail;
	}
	public int getPosition() {
		return position;
	}

	public void setPosition(int aPosition) {
		position =aPosition;
	}
	
	
	
	
}
