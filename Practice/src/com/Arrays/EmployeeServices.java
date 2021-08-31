package com.Arrays;
import java.util.*;

/**
 * @author Sangeethkumar
 *
 */
public class EmployeeServices {
	public EmployeeDTO[] getUserDetails() {
		Scanner sc=EmployeeUtility.getScannerInstance();
		System.out.println("How many employees registered? ");
		int n=sc.nextInt();
		EmployeeDTO arr[]=new EmployeeDTO[n];
		EmployeeDTO dto=null;
		for(int i=0;i<n;i++) {
			dto=new EmployeeDTO();
			System.out.println("Enter Id of the employee : ");
			dto.setEmployeeId(sc.nextInt());
			System.out.println("Enter the first name : ");
			dto.setFirst_name(sc.next());
			System.out.println("Enter the last name  : ");
			dto.setLast_name(sc.next());
			System.out.println("Enter the salary     : ");
			dto.setSalary(sc.nextDouble());
			System.out.println("Enter the department : ");
			dto.setDepartment(sc.next());
			
			arr[i]=dto;
		}
		return arr;
		
	}
	public void getEmployeeDetails(EmployeeDTO arr[]) {
		EmployeeDTO dto=null;
		for(int i=0;i<arr.length;i++) {
			dto=arr[i];
			System.out.println("ID         : "+dto.getEmployeeId());
			System.out.println("first_name : "+dto.getFirst_name());
			System.out.println("last_name  : "+dto.getLast_name());
			System.out.println("salary     : "+dto.getSalary());
			System.out.println("department : "+dto.getDepartment());
			System.out.println("------------------------------------------------");
		}
	}
}
