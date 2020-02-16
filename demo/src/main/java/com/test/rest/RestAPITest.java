package com.test.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPITest {
	@Autowired
	EmployeeRest employeeTest;
	
	@Autowired
	EmployeeRest employeeTest1;
	
	
	
	@RequestMapping(value = "/rest/Test/",method = RequestMethod.GET,produces = "*/*",consumes = "*/*")
	public List<EmployeeRest> restTest() {
		
		List<EmployeeRest> restList=new ArrayList<EmployeeRest>();
		employeeTest.setEmpId(10);
		employeeTest.setEmpName("Lucky");
		employeeTest.setAddress("Hyderabad");
		
		
		 employeeTest1.setEmpId(20); 
		 employeeTest1.setEmpName("Lakshman");
		 employeeTest1.setAddress("Chennai");
		 
		
		
		restList.add(employeeTest);
		restList.add(employeeTest1);
		return restList;
		
		
	}
	@RequestMapping(value = "/rest/Tests/",method = RequestMethod.GET,produces = "*/*",consumes = "*/*")
public EmployeeRest restSingle() {
		
		//List<EmployeeRest> restList=new ArrayList<EmployeeRest>();
		employeeTest.setEmpId(10);
		employeeTest.setEmpName("Lucky");
		employeeTest.setAddress("Hyderabad");
		
		
		
		
		
		return employeeTest;
		
		
	}
}
