package com.project.studentsApp.models;

public class Student{
	private String firstName;
	private String lastName;
	private int stack;

	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	public String getLastName(){
		return lastName;
	}

	public void setStack(int stack){
		this.stack = stack;
	}
	public int getStack(){
		return stack;
	}

	public Student(){}

	public Student(String firstName){
		this.firstName = firstName;
	}

	public Student(String firstName,String lastName,int stack){
		this.firstName = firstName;
		this.lastName = lastName;
		this.stack = stack;
	}
}
