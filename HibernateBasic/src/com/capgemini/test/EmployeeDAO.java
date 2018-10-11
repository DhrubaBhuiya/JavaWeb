package com.capgemini.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("deprecation")
public class EmployeeDAO {
	StandardServiceRegistry ssr;  
    Metadata meta;  
    SessionFactory factory;
    
    public EmployeeDAO() {
    	ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	meta = new MetadataSources(ssr).getMetadataBuilder().build();  
    	factory = meta.getSessionFactoryBuilder().build();
	}
    
    public void inbuitInsert(Employee e){
    	Session session = factory.openSession();  
    	Transaction t = session.beginTransaction();  
    	session.save(e);  
    	t.commit();  
    	System.out.println("successfully saved");  
    	session.close();
    }
    
    public void sqlInsert(Employee e){
    	Session session = factory.openSession();
    	Transaction t = session.beginTransaction();  
        @SuppressWarnings("rawtypes")
		Query query =session.createNativeQuery("INSERT INTO emp1000 VALUES(?,?,?)");
        query.setParameter(1, e.getEmpID());
	    query.setParameter(2, e.getEmpName());
	    query.setParameter(3, e.getEmpSalary());
	    query.executeUpdate();
	    t.commit(); 
	    System.out.println("successfully saved"); 
	    session.close();
    }
    
    @SuppressWarnings("unchecked")
	public void hqlSelct(){
    	Session session = factory.openSession();
    	Transaction t = session.beginTransaction();  
        List<Employee> list = session.createQuery("From Employee").list();  
        System.out.println(list);
        t.commit();   
	    session.close();
    }
    
    @SuppressWarnings("rawtypes")
	public void sqlSelct(){
    	Session session = factory.openSession();
    	Transaction t = session.beginTransaction(); 
        SQLQuery query1 =session.createSQLQuery("select * from emp1000");
        query1.addEntity(Employee.class);
        List list1=query1.list();
        Iterator itr=list1.iterator();
        while(itr.hasNext()){
     	   Employee e=(Employee) itr.next();
     	   System.out.println(e.getEmpID());
     	   System.out.println(e.getEmpName());
     	   System.out.println(e.getEmpSalary());
        }
        t.commit();
        session.close();
    }
    
    @SuppressWarnings("rawtypes")
	public void criteriaSelect(){
    	Session session = factory.openSession();
    	Transaction t = session.beginTransaction(); 
        Criteria cr = session.createCriteria(Employee.class);
        List results = cr.list();
        System.out.println(results);
        t.commit();
	    session.close();
    }
    
    @SuppressWarnings("rawtypes")
	public void hqlNameUpdate(String empName, String empID){
    	Session session = factory.openSession();
    	Transaction t = session.beginTransaction(); 
    	Query query=session.createQuery("update Employee set empName=:n where empID=:i");  
    	query.setParameter("n",empName);  
    	query.setParameter("i",empID);  
    	query.executeUpdate();  
    	t.commit(); 
    	session.close();
    }
    
    @SuppressWarnings("rawtypes")
	public void sqlNameUpdate(String empName, String empID){
    	Session session = factory.openSession();
    	Transaction t = session.beginTransaction();
		String sql = "UPDATE emp1000 set empName = '"+empName+"' WHERE empID = '"+empID+"'";		 
		Query query = session.createNativeQuery(sql);
		query.executeUpdate();
        t.commit(); 
    	session.close();
    }
    
    @SuppressWarnings("rawtypes")
	public void sqlDelete(String empID){
    	Session session = factory.openSession();
    	Transaction t = session.beginTransaction(); 
        String sql = "delete from  emp1000 WHERE empId = '"+empID+"'";
        Query query = session.createNativeQuery(sql);
        query.executeUpdate();
        t.commit();  
    	session.close();
    }
    
    @SuppressWarnings("rawtypes")
	public void hqlDelete(String empID){
    	Session session = factory.openSession();
    	Transaction t = session.beginTransaction();  
        Query query=session.createQuery("delete from Employee where id='"+empID+"'");  
        query.executeUpdate();  
        t.commit();  
    	session.close();
    }
    
    public void criteriaDelete(String empID){
    	Session session = factory.openSession();
    	Transaction t = session.beginTransaction();  
    	Employee emp = (Employee ) session.createCriteria(Employee.class).add(Restrictions.eq("id", "empID")).uniqueResult();
    	session.delete(emp);
        t.commit();  
    	session.close();
    }
    
    protected void finalize(){
    	factory.close();
    }
    
       
}
