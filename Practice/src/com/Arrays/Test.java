package com.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      EmployeeServices util=new EmployeeServices();
      EmployeeDTO arr[]=util.getUserDetails();
      util.getEmployeeDetails(arr);
	}

}
