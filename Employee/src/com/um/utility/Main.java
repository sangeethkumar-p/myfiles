package com.um.utility;
import java.util.List;
import java.util.ArrayList;
import com.um.dao.EmployeeService;
import com.um.dto.EmployeeDto;

public class Main {
	public static void main(String args[]){
		EmployeeService dao=new EmployeeService();
		List<EmployeeDto>empList=new ArrayList<>();
		empList=dao.getEmployeeInfo();
		dao.getSalary(empList);
		System.out.println(dao.getTotalSalaryByDepartment(empList));
		dao.getEmployeeDetails();
	}
}
