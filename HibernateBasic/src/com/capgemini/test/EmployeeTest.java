package com.capgemini.test;   
public class EmployeeTest {  
  
    public static void main( String[] args )  
    {  
        EmployeeDAO employeeDAO = new EmployeeDAO();
        
    	Employee e=new Employee();    
        e.setEmpID("e101");    
        e.setEmpName("Gaurav");    
        e.setEmpSalary(5000); 
        employeeDAO.inbuitInsert(e);
        
        e=new Employee();    
        e.setEmpID("e102");    
        e.setEmpName("Mahesh");    
        e.setEmpSalary(10000); 
        employeeDAO.sqlInsert(e);

        employeeDAO.sqlSelct();
        
        employeeDAO.sqlNameUpdate("Ram", "e101");
        employeeDAO.hqlNameUpdate("Sam", "e102");
        
        employeeDAO.hqlSelct();
        
        employeeDAO.sqlDelete("e101");
        
        employeeDAO.criteriaSelect();
        
    }  
}  