package com.agon.dto;

public class Employee {

	private int id;
	private String name;
	private String designation;
	private int salary;

	public Employee() {

	}

	public Employee(int id, String name, String designation, int salary) {

		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesigination() {
		return designation;
	}

	public void setDesigination(String desigination) {
		this.designation = desigination;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String toString() {
		return id+" "+name+" "+designation+" "+salary;
	}

}
