package com.database.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Emp { 

	
	private int id;
	
	@Size(min=1, message="First Name is Required")
	private String firstName;
	
	@Size(min=1, message="Last Name is Required")	
	private String lastName;
	
	@Min(value=1000, message="Minmum Salary is Rs.1000")
	@Max(value=1000000000, message="Maximum Salary is Rs.1000000000")
	private float salary;
	
	@Size(min=1, message="Department Name is Required")
	private String department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}


}  