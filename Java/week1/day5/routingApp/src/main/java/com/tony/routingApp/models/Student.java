package com.tony.routingApp.models;

public class Student {
	private String firstName;
	private String stack;
	
	public Student(String firstName,String stack) {
		this.firstName=firstName;
		this.stack=stack;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}
	
	
}
