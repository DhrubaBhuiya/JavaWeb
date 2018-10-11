package com.capgemini.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.capgemini.dal.EmployeeDAO;

@SuppressWarnings("deprecation")
public class EmployeeTest {

	public static void main(String[] args) {
		Resource r=new ClassPathResource("applicationContext.xml");  
	    BeanFactory factory=new XmlBeanFactory(r);  
		EmployeeDAO employeeDAO = (EmployeeDAO)factory.getBean("empdao");
		System.out.println(employeeDAO.getEmployees());
	}

}
