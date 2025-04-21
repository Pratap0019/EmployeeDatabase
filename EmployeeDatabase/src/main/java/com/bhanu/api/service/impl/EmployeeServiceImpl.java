package com.bhanu.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhanu.api.bean.Employees;
import com.bhanu.api.dao.EmployeeDao;
import com.bhanu.api.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao empDao;


	@Override
	public Employees getEmployeeDetails(String emp_id) {

		Employees emp = empDao.getEmployeeDetails(emp_id);
		return emp;
	}


	@Override
	public int createNewEmployee(Employees emp) {
		return empDao.createNewEmployee(emp);
	}


	@Override
	public List<Employees> getAllEmployee() {
		return empDao.getAllEmployee();
	}


	@Override
	public int deleteEmployee(Employees emp) {
		return empDao.deleteEmployee(emp);
	}


}
