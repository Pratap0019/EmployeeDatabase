package com.bhanu.api.dao;

import java.util.List;

import com.bhanu.api.bean.Employees;

public interface EmployeeDao {
	
	Employees getEmployeeDetails(String emp_id);
	
	int createNewEmployee(Employees emp);
	
	List <Employees>  getAllEmployee();
	
	int deleteEmployee(Employees emp);
}
