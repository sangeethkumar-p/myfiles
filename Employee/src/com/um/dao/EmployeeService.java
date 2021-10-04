package com.um.dao;
import com.um.dto.*;
import java.math.*;
import java.util.*;

public class EmployeeService {
	public List<EmployeeDto> getEmployeeInfo(){
		ArrayList<EmployeeDto>empDto=new ArrayList<>(10);
		for(int i=0;i<10;i++){
			empDto.add(new EmployeeDto());
		}
		empDto.get(0).setEmployeeId("USI001");
		empDto.get(0).setDepartment("QC ");
		empDto.get(0).setBasicPay(new BigDecimal(40000.00));
		empDto.get(0).setHra(new BigDecimal(3000.00));

		empDto.get(1).setEmployeeId("USI002");
		empDto.get(1).setDepartment("Dev");
		empDto.get(1).setBasicPay(new BigDecimal(35000.00));
		empDto.get(1).setHra(new BigDecimal(4000.00));

		empDto.get(2).setEmployeeId("USI003");
		empDto.get(2).setDepartment("Dev");
		empDto.get(2).setBasicPay(new BigDecimal(42000.00));
		empDto.get(2).setHra(new BigDecimal(200.00));

		empDto.get(3).setEmployeeId("USI004");
		empDto.get(3).setDepartment("QC ");
		empDto.get(3).setBasicPay(new BigDecimal(4500.00));
		empDto.get(3).setHra(new BigDecimal(350.00));

		empDto.get(4).setEmployeeId("USI005");
		empDto.get(4).setDepartment("Dev");
		empDto.get(4).setBasicPay(new BigDecimal(32000.00));
		empDto.get(4).setHra(new BigDecimal(4000.00));

		empDto.get(5).setEmployeeId("USI006");
		empDto.get(5).setDepartment("QC ");
		empDto.get(5).setBasicPay(new BigDecimal(33000.00));
		empDto.get(5).setHra(new BigDecimal(4000.00));

		empDto.get(6).setEmployeeId("USI007");
		empDto.get(6).setDepartment("QC ");
		empDto.get(6).setBasicPay(new BigDecimal(32000.00));
		empDto.get(6).setHra(new BigDecimal(4000.00));

		empDto.get(7).setEmployeeId("USI008");
		empDto.get(7).setDepartment("QC ");
		empDto.get(7).setBasicPay(new BigDecimal(37000.00));
		empDto.get(7).setHra(new BigDecimal(4000.00));

		empDto.get(8).setEmployeeId("USI009");
		empDto.get(8).setDepartment("Dev");
		empDto.get(8).setBasicPay(new BigDecimal(27000.00));
		empDto.get(8).setHra(new BigDecimal(4000.00));

		empDto.get(9).setEmployeeId("USI010");
		empDto.get(9).setDepartment("QC ");
		empDto.get(9).setBasicPay(new BigDecimal(4000.00));
		empDto.get(9).setHra(new BigDecimal(400.00));

		return empDto;
	}

	public void getSalary(List<EmployeeDto>empList) {
		for(EmployeeDto empDto:empList) {
			empDto.setTotalSalary(empDto.getHra().add(empDto.getBasicPay()));
		}
	}
	public  Map<String,BigDecimal> getTotalSalaryByDepartment(List<EmployeeDto>empList){
		Map<String,BigDecimal>empMap=new HashMap<>();
		System.out.println("Total Salary by Department :");
		for(EmployeeDto empDto:empList) {
			BigDecimal empSalary=empMap.get(empDto.getDepartment());
			if(empDto.getTotalSalary().compareTo(new BigDecimal(5000))>=0) {
				if(empSalary==null) {
					empMap.put(empDto.getDepartment(), empDto.getTotalSalary());
				}else {
					empMap.put(empDto.getDepartment(), empSalary.add(empDto.getTotalSalary()));
				}
			}
		}
		return empMap;
	}
    
	public void getEmployeeDetails(){
		ArrayList<EmployeeDto>empDto=new ArrayList<>(10);
		empDto.addAll(getEmployeeInfo());
		BigDecimal QCSum=BigDecimal.ZERO;
		BigDecimal DevSum=BigDecimal.ZERO;
		System.out.println();
		System.out.println("Employee Details where Salary >= 5000 :");
		for(int i=0;i<10;i++){
			BigDecimal Salary=(empDto.get(i).getBasicPay()).add(empDto.get(i).getHra());
			if(Salary.compareTo(new BigDecimal(5000.00))==1){
				System.out.println("Employee Id :"+empDto.get(i).getEmployeeId());
				System.out.print(empDto.get(i).getDepartment()+" : "+Salary+"\n");
				if(empDto.get(i).getDepartment().equalsIgnoreCase("QC ")){
					QCSum=QCSum.add(Salary);
				}
				if(empDto.get(i).getDepartment().equalsIgnoreCase("Dev")){
					DevSum=DevSum.add(Salary);
				}
				System.out.println();
			}
		}
		System.out.println("QC total Salary  : "+QCSum);
		System.out.println("Dev total Salary : "+DevSum);
	}
}
