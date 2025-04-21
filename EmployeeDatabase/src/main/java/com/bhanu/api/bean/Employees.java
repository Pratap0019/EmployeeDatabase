package com.bhanu.api.bean;

public class Employees {
	private String employee_name = "";
	private String emp_id = "";
	private String mobile = "";
	private String location = "";
	private String project = "";
	private String user_id = "";
	private String password = "";
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(Object object) {
		this.employee_name = (String) object;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Object object) {
		this.emp_id = (String) object;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(Object object) {
		this.mobile = (String) object;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(Object object) {
		this.location = (String) object;
	}

}

