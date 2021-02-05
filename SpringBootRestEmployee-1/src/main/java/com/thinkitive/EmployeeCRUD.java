package com.thinkitive;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class EmployeeCRUD implements EmployeeOperations{
List<Employee> elist = new ArrayList<>();

Configuration cfg;
Session session;
SessionFactory factory;
Transaction tx;
public EmployeeCRUD() {
	cfg = new Configuration();
	factory = cfg.configure().buildSessionFactory();
	
}

	@Override
	public String createEmployee(Employee e) {
	
		
		session = factory.openSession();
		tx = session.beginTransaction();
		session.save(e);
		tx.commit();
		session.close();
		elist.add(e);
	
		return "Successfully added";
	}

	@Override
	public String updateEmployee(Employee e) {
		for(Employee x: elist) 
		{
			if(x.getId() == e.getId()) 
			{
				x.setEname(e.getEname());
				x.setSalary(e.getSalary());

			}
		}
		
		return "Successfully updated";
	}

	@Override
	public String deleteEmployee(Employee e) {
		
			elist.remove(e);
			
		return "Successfully deleted";
		}

	@Override
	public Employee getEmployee(Employee e) {

		for(Employee x: elist) 
		{
			if(x.getId() == e.getId()) 
			{
				return x;
			}
		}
		return null;
	}

	@Override
	public List<Employee> DisplayAll() {
		
		return elist;
	}

}
