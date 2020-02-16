package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Controller
@EnableAutoConfiguration
@ComponentScan("com.test.aop")
@ComponentScan("com.example.demo")
@ComponentScan("com.test.rest")
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 @Autowired
	TestHibernate hib;
	@Autowired
	EmployeeRepository repository;
	@Autowired
	TestAutoWire autowire;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		 Optional<Employee> emp = repository.findById(1);
				 
	        logger.info("Employee id 2 -> {}", emp.get());
	        autowire.m2();
	       List<Employee> employeeList= hib.findByName("lucky");
	       for(Employee em:employeeList) {
	    	   String employeeName=em.getAddress();
	    	   logger.info("Employee Address:"+employeeName);
	       }
	}
	
	

	
	

}

