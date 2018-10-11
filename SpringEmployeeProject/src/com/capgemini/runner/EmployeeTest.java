package com.capgemini.runner;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.dal.EmployeeDAO;
import com.capgemini.pojo.Address;
import com.capgemini.pojo.EmployeeData;

public class EmployeeTest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Context.xml");
		EmployeeDAO ed = (EmployeeDAO) applicationContext.getBean("employeeDAO");
		
		/*ed.insertEmployee(new EmployeeData("e104", "Raj", "HR", 70000, 500, "9876453210", new Address("Mumbai", "Marashtra", "400015")));
		ed.insertEmployee(new EmployeeData("e105", "Gita", "HR", 85000, 500, "9876578910", new Address("Bangalore", "Karnataka", "560015")));
		ed.insertEmployee(new EmployeeData("e106", "Dinesh", "HR", 65000, 550, "9147895610", new Address("Kolkata", "WB", "700015")));*/
		
		ArrayList<EmployeeData> list  = ed.getAllEmployee();
		System.out.println(list);
		
		EmployeeData employeeData = ed.getEmployeeById("e101");
		System.out.println(employeeData);
		
		double maxSalary = ed.highestSalaryByDepartment("IT");
		System.out.println(maxSalary);
		
		ed.updateCommission("e101", 600);
		employeeData = ed.getEmployeeById("e101");
		System.out.println(employeeData);
		
		ed.removeEmployeeById("e106");
		list  = ed.getAllEmployee();
		System.out.println(list);
		
		ed.updateEmployeeDetais("e101", "Gublu", "Bangalore", "Karnataka", "1234567890", "560066");
		employeeData = ed.getEmployeeById("e101");
		System.out.println(employeeData);
		
		
	}

}
