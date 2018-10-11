package com.capgemini.pojo;

public class EmployeeData {
	private String empID;
	private String empName;
	private String department;
	private double salary;
	private double commission;	
	private String phNo;
	private Address address; 
	
	public EmployeeData(String empID, String empName, String department,
			double salary, double commission, String phNo, Address address) {
		this.empID = empID;
		this.empName = empName;
		this.department = department;
		this.salary = salary;
		this.commission = commission;
		this.phNo = phNo;
		this.setAddress(address);
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String toString(){
		return empID+" "+empName+" "+department+" "+salary+" "+commission+" "+phNo+" "+address.toString();
		
	}
	
}
