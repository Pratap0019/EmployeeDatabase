package com.bhanu.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bhanu.api.bean.Employees;
import com.bhanu.api.service.EmployeeService;


@Controller()
public class ApiController {

	@Autowired
	EmployeeService empService;

	@GetMapping(value = "/index")
	public String getHomepage() {
		return "index";
	}

	@PostMapping(value = "/employee")
	public String getEmp(ModelMap model, @RequestParam String emp_id) {		
		Employees empl = empService.getEmployeeDetails(emp_id);
		if(empl.getEmployee_name().equals("")) {
			model.put("errorMsg", "!No information available for given Employee ID");
			return "index";	
		}
		else {
			model.addAttribute("empl", empl);
			return "employee";			
		}
	}

	@GetMapping(value = "/registration")
	public String register() {
		return "registration";			
	}

	@PostMapping(value = "/registration")
	public String registerEmployee(ModelMap model, @RequestParam String employee_name, @RequestParam String emp_id, @RequestParam String mobile,
			@RequestParam String location,@RequestParam String project) {
		Employees empl = new Employees();
		empl.setEmployee_name(employee_name);
		empl.setEmp_id(emp_id);
		empl.setMobile(mobile);
		empl.setLocation(location);
		empl.setProject(project);
		int status = empService.createNewEmployee(empl);
		if(status!=1){
			model.put("errorMsg", "Something went wrong! Please check the details provided");
			return "registration";
		}
		else {
			model.put("successMsg", "Successfully registered Employee details");
			return "registration";			
		}		
	}

	@GetMapping(value = "/adminlogin")
	public String getAdminLogin() {
		return "adminlogin";
	}

	@PostMapping(value = "/adminhome")
	public String getAdminHome(ModelMap model, @RequestParam String user_id, @RequestParam String password) {

		if(user_id.equals("bhanu@admin") && password.equals("bhanu@321")){
			return "adminhome";
		}
		else {
			model.put("errorMsg", "!Invalid User ID & Password");
			return "adminlogin";	
		}
	}

	@GetMapping(value = "/getallemployee")
	public String getAllEmployeeList(ModelMap model) {		
		List <Employees> emplist = empService.getAllEmployee();			
		model.put("emplist", emplist);			
		return "getallemployee";
	}

	@GetMapping(value = "/deleteemployee")
	public String deleteEmployee(ModelMap model, @RequestParam String emp_id) {

		Employees em =new Employees();
		em.setEmp_id(emp_id);			
		int status = empService.deleteEmployee(em);
		List <Employees> emplist = empService.getAllEmployee();			
		model.put("emplist", emplist);
		return "getallemployee";
	}
}
