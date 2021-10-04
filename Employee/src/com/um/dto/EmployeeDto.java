package com.um.dto;
import java.math.*;

public class EmployeeDto {
	private String employeeId;
	private String department;
	private BigDecimal basicPay;
	private BigDecimal hra;
	private BigDecimal totalSalary;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public BigDecimal getBasicPay() {
		return basicPay;
	}
	public void setBasicPay(BigDecimal basicPay) {
		this.basicPay = basicPay;
	}
	public BigDecimal getHra() {
		return hra;
	}
	public void setHra(BigDecimal hra) {
		this.hra = hra;
	}
	public BigDecimal getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(BigDecimal totalSalary) {
		this.totalSalary = totalSalary;
	}
}
