package com.bhanu.domain;

public class EmpDetails {
	
	private String emp_name;
	private String employee_name = "";
	private String emp_id = "";
	private String mobile = "";
	private String location = "";
	
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
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(Object object) {
		this.emp_name = (String) object;
	}

}
