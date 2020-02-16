package com.test.rest;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@Component
@Scope("prototype")
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@XmlRootElement(name = "employee")
@JacksonStdImpl
@XmlType(propOrder={"empId", "empName" , "address" })
public class EmployeeRest {
	
private Integer empId;
	
private String empName;
	
private String address;
public Integer getEmpId() {
	return empId;
}
public void setEmpId(Integer empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
}
