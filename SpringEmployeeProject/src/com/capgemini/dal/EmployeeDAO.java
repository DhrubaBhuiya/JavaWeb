package com.capgemini.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import com.capgemini.pojo.Address;
import com.capgemini.pojo.EmployeeData;

public class EmployeeDAO {
	private JdbcTemplate jdbcTemplate;  
	private Connection con;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public void insertEmployee(EmployeeData e){
		try {
			con = jdbcTemplate.getDataSource().getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			String query="insert into employee values('"+e.getEmpID()+"','"+e.getEmpName()+"',"+e.getSalary()+","+e.getCommission()+",'"+e.getDepartment()+"','"+e.getPhNo()+"')";
			Statement stmt  = con.createStatement();
			stmt.executeUpdate(query);
			query="insert into address values('"+e.getEmpID()+"','"+e.getAddress().getCity()+"','"+e.getAddress().getState()+"','"+e.getAddress().getPinCode()+"')";
			stmt.executeUpdate(query);	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public ArrayList<EmployeeData> getAllEmployee(){
		ArrayList<EmployeeData> employeeDatasLst =  new ArrayList<EmployeeData>();
		try {
			con = jdbcTemplate.getDataSource().getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			String query="select * from employee";
			Statement stmt  = con.createStatement();
			ResultSet rs  = stmt.executeQuery(query);
			query="select * from address";
			Statement stmt1  = con.createStatement();	
			ResultSet rs1  = stmt1.executeQuery(query);
			while(rs.next() && rs1.next()){
				employeeDatasLst.add(new EmployeeData(rs.getString(1), rs.getString(2), rs.getString(5), rs.getDouble(3), rs.getDouble(4),rs.getString(6), new Address(rs1.getString(2), rs1.getString(3), rs1.getString(4))));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return employeeDatasLst;
		
	}
	
	public EmployeeData getEmployeeById(String empID){
		EmployeeData employeeData = null;
		try {
			con = jdbcTemplate.getDataSource().getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			String query="select * from employee where empID='"+empID+"'";
			Statement stmt  = con.createStatement();
			ResultSet rs  = stmt.executeQuery(query);
			query="select * from address where empID='"+empID+"'";
			Statement stmt1  = con.createStatement();	
			ResultSet rs1  = stmt1.executeQuery(query);
			while(rs.next() && rs1.next()){
				employeeData = new EmployeeData(rs.getString(1), rs.getString(2), rs.getString(5), rs.getDouble(3), rs.getDouble(4),rs.getString(6), new Address(rs1.getString(2), rs1.getString(3), rs1.getString(4)));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return employeeData;
		
	}
	
	public double highestSalaryByDepartment(String department){
		double maxsalary = 0;
		try {
			con = jdbcTemplate.getDataSource().getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			String query="select maxs from (SELECT department,max(salary) as maxs from employee group by department) as new where department = '"+department+"'";
			Statement stmt  = con.createStatement();
			ResultSet rs  = stmt.executeQuery(query);
			while(rs.next()){
				maxsalary = rs.getDouble(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return maxsalary;
	}
	
	public void updateCommission(String empID, double commission){
		try {
			con = jdbcTemplate.getDataSource().getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			String query="update employee set commission="+commission+" where empID='"+empID+"'";
			Statement stmt  = con.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void removeEmployeeById(String empID){
		try {
			con = jdbcTemplate.getDataSource().getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			String query="delete from employee where empID='"+empID+"'";
			Statement stmt  = con.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void updateEmployeeDetais(String empID,String empName,String city,String state,String phNo,String pinCode){
		try {
			con = jdbcTemplate.getDataSource().getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			String query="update employee set empName='"+empName+"', phNo='"+phNo+"' where empID='"+empID+"'";
			Statement stmt  = con.createStatement();
			stmt.executeUpdate(query);
			query="update address set city='"+city+"', state='"+state+"', pinCode='"+pinCode+"' where empID='"+empID+"'";
			stmt.executeUpdate(query);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
}
