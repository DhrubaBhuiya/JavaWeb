package com.capgemini.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("Context.xml");
		Employee employee = (Employee)applicationContext.getBean("Employee");
		System.out.println(employee.getEmpID()+" "+employee.getEmpName()+" "+employee.getEmpSalary());
	}

}
