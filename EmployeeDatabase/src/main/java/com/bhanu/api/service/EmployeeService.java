package com.bhanu.api.service;

import java.util.List;

import com.bhanu.api.bean.Employees;

public interface EmployeeService {

	Employees getEmployeeDetails(String emp_id);
	
	int createNewEmployee(Employees emp);
	
	List <Employees>  getAllEmployee();
	
	int deleteEmployee(Employees emp);
}
