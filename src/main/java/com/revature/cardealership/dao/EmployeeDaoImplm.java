package com.revature.cardealership.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import com.revature.cardealership.log.LoggingUtil;
import com.rrevature.cardealership.util.ConnectionFactory;
import com.revature.cardealership.Employee;

public class EmployeeDaoImplm implements EmployeeDao {

	private static Connection conn = ConnectionFactory.getConnection();
	//EmployeeDao cd = new EmployeeDaoImplm();
	
	@Override
	public void createEmployee(Employee m) { //employeeUserN, employeePassW
		// TODO Auto-generated method stub
		try {
			conn.setAutoCommit(false);
			String query = "Insert into Employee_Vipers(Username, password) values (?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.employeeUserN);
			pstmt.setString(2, m.employeePassW);
			Savepoint sp = conn.setSavepoint("Before Creating Customer");
			boolean check = pstmt.execute();
			if (check) {
				conn.rollback(sp);
				LoggingUtil.error("Employee was not added.Repeat");
			}
			conn.commit();
			conn.setAutoCommit(true);
			LoggingUtil.info("Creating Employee was successful");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

//	@Override
//	public void deleteEmployee(Employee m) {
//		String sql = "Delete from Employee_Vipers";
//		Statement stmt;
//		try {
//			stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//			}
//		//code here
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "Select employeeid from Employee_Vipers";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList <Employee> getAllEmployees() {
		ArrayList<Employee> EmployeeList = new ArrayList<Employee>();
		String sql = "Select * from Customers_Vipers";
		Statement stmt;
		try {
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			EmployeeList.add(new Employee(rs.getString("username"), rs.getString("password")));
			//getInt(1), rs.getString(2), rs.getString(3)));
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return EmployeeList;
	}
	@Override
	public void preparedUpdateEmployee(Employee m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(Employee m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(Employee m) {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	void preparedUpdateEmployee(Employee m) {
		// TODO Auto-generated method stub}
		
}

