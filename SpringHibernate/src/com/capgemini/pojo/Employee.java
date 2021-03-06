package com.capgemini.pojo;

public class Employee {

	private String empID;
	private String empName;
	private double empSalary;
	
	public Employee() {
		
	}

	public Employee(String empID, String empName, double empSalary) {
		this.empID = empID;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName
				+ ", empSalary=" + empSalary + "]";
	}
	
	
}
