package com.example.demo;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
@Repository
public class TestHibernate {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	 
	public Session getSession() {
	   Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
	   return session;
	}
	

	/*
	 * public Session getSession() { Session session=sessionFactory.openSession();
	 * 
	 * return session; }
	 */
	public List<Employee> findByName(String empName) {
		
		Session session=getSession();
		Criteria cr=session.createCriteria(Employee.class);
		cr.add(Restrictions.eq("empName", empName));
		
		List<Employee> employeeList=cr.list();
		
		return employeeList;
		
	}

}
