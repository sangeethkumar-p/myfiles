package com.CodeLikeMe;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of employees => ");
		int number=sc.nextInt();
	
		//user input for number of objects needs to be created...
		Employee[] employee=new Employee[number];
		
		//using arrayList for creating multiple objects...
		ArrayList<Employee>object=new ArrayList<Employee>();
		
		for(int i=0;i<employee.length;i++) {
			object.add(new Employee());
			employee[i]=object.get(i);
			
			System.out.println("Details of the employee       ==> "+(i+1));
			System.out.print("Enter Employee Id               ==> ");
			employee[i].setId(sc.nextInt());
			System.out.print("Enter Employee Name             ==> ");
			employee[i].setName(sc.next());
			System.out.print("Enter Employee Salary           ==> ");
			employee[i].setSalary(sc.nextDouble());
			System.out.print("Enter Employee Department       ==> ");
			employee[i].setDesignation(sc.next());
			System.out.println("<===========================================================================>");
		}
		getDetails(employee);
	}
	public static void getDetails(Employee[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.println("<== Employee "+(i+1)+   "==>");
			System.out.println("Employee Id          ==> "+arr[i].getId());
			System.out.println("Employee Name        ==> "+arr[i].getName());
			System.out.println("Employee Salary      ==> "+arr[i].getSalary());
			System.out.println("Employee Designation ==> "+arr[i].getDesignation());
			System.out.println("<======================================================================>");
			

			
		}
	}
}
