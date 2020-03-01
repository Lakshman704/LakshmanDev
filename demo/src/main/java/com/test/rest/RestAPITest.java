package com.test.rest;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Employee;
import com.service.layer.ServiceEmployee;

@RestController
public class RestAPITest {
	@Autowired
	EmployeeRest employeeTest;
	
	@Autowired
	EmployeeRest employeeTest1;
	
	@Autowired
	ServiceEmployee serviceEmp;
	
	@RequestMapping(value = "/rest/Test/",method = RequestMethod.GET,produces = "application/json",consumes = "*/*")
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
	@RequestMapping(value = "/rest/Tests/",method = RequestMethod.GET,produces = "application/json",consumes = "*/*")
public EmployeeRest restSingle() {
		
		//List<EmployeeRest> restList=new ArrayList<EmployeeRest>();
		employeeTest.setEmpId(10);
		employeeTest.setEmpName("Lucky");
		employeeTest.setAddress("Hyderabad");
		
		
		
		
		
		return employeeTest;
		
		
	}
	
	@RequestMapping(path = "/rest/getdb/{empName}",method = RequestMethod.GET,produces = "application/json",consumes = "*/*")
	public List<EmployeeRest> restSinglefromdb(@PathVariable("empName") String empName) {
		
		List<EmployeeRest> restList=new ArrayList<EmployeeRest>();
		System.out.println("employeeName:"+empName);
		 List<Employee> empList=serviceEmp.getEmployeeDetails(empName);
			
		 empList.forEach(emp->{
			 EmployeeRest rest=new EmployeeRest();
			 rest.setEmpName(emp.getEmpName());
			 rest.setEmpId(emp.getEmpId());
			 rest.setAddress(emp.getAddress());
			 restList.add(rest);
			 
		 }
		 );
			return restList;
			
			
			
		}
}
