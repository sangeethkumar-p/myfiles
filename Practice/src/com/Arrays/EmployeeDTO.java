package com.Arrays;

/**
 * @author Sangeethkumar
 *
 */

public class EmployeeDTO {
	private int EmployeeId;
	private String first_name;
	private String last_name;
	private double Salary;
	private String Department;
    
	public int getEmployeeId() {
		return EmployeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	
	

}
