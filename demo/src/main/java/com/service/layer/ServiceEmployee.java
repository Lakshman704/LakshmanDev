package com.service.layer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Employee;
import com.example.demo.TestHibernate;

@org.springframework.stereotype.Service
public class ServiceEmployee {
	@Autowired
	public TestHibernate testHibernate;
	
	public List<Employee> getEmployeeDetails(String empName) {
		List<Employee> empList=testHibernate.findByName(empName);
		return empList;
		
	}
	
	
}
