package com.bhanu.api.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.bhanu.api.bean.Employees;
import com.bhanu.api.dao.EmployeeDao;

import jakarta.annotation.PostConstruct;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao{

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public Employees getEmployeeDetails(String emp_id) {

		String sql = "select * from employees where emp_id=?";
		try {
			return getJdbcTemplate().queryForObject(sql, new Object[] {emp_id }, new RowMapper<Employees>(){

				@Override
				public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
					Employees emp = new Employees();
					emp.setEmployee_name(rs.getString(1));
					emp.setEmp_id(rs.getString(2));
					emp.setMobile(rs.getString(3));
					emp.setLocation(rs.getString(4));
					emp.setProject(rs.getString(5));
					return emp;
				}

			});
		}
		catch(Exception e) {
			System.out.println("exception occured while getting data from db");
			Employees emp = new Employees();
			return emp;
		}
	}

	@Override
	public int createNewEmployee(Employees emp) {
		String sql = "insert into employees(employee_name, emp_id, mobile, location, project) values(?, ?, ?, ?, ?)";
		try {
			return getJdbcTemplate().update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, emp.getEmployee_name());
					ps.setString(2, emp.getEmp_id());
					ps.setString(3, emp.getMobile());
					ps.setString(4, emp.getLocation());
					ps.setString(5, emp.getProject());
					return ps;
				}
			});
		}
		catch(Exception e) {
			System.out.println("failed while adding employee in DB");
			return 0;
		}
	}

	@Override
	public List<Employees> getAllEmployee() {

		String sql ="select * from employees";

		return getJdbcTemplate().query(sql,  new RowMapper<Employees>(){
			@Override
			public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {

				Employees emp = new Employees();
				emp.setEmployee_name(rs.getString(1));
				emp.setEmp_id(rs.getString(2));
				emp.setMobile(rs.getString(3));
				emp.setLocation(rs.getString(4));
				emp.setProject(rs.getString(5));	
				return emp;
			}
		});
	}

	@Override
	public int deleteEmployee(Employees emp) {
		String sql = "DELETE FROM employees WHERE emp_id=?";
		return getJdbcTemplate().update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, emp.getEmp_id());
				return ps;
			}
		});
	}

}

