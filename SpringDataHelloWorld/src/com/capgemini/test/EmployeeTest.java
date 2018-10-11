package com.capgemini.test;

public class EmployeeTest {

	public static void main(String[] args) {
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee employee = new Employee( ); 
		employee.setEmpID( "1201" );
		employee.setEmpName( "Gopal" );
		employee.setEmpSalary( 40000 );
		
		employeeDAO.createEmployee(employee);
	}
}
