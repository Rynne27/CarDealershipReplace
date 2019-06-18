package com.revature.cardealership.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.cardealership.Customer;
import com.revature.cardealership.log.LoggingUtil;
import com.rrevature.cardealership.util.ConnectionFactory;

public class CustomerDaoImplm implements CustomerDao {
	
	private static Connection conn = ConnectionFactory.getConnection();
	public static ArrayList<Customer> CustomerList = new ArrayList<Customer> ();
	@Override
	public void createCustomer(Customer t) {
		// TODO Auto-generated method stub
		try {
			conn.setAutoCommit(false);
			String query = "Insert into Customers_Vipers(Username, password) values (?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, t.input2);
			pstmt.setString(2, t.input3);
			Savepoint sp = conn.setSavepoint("Before Creating Customer");
			boolean check = pstmt.execute();
			if (check) {
				conn.rollback(sp);
				LoggingUtil.error("Customer was not added.Repeat");
			}
			conn.commit();
			conn.setAutoCommit(true);
			LoggingUtil.info("Creating Customer was successful");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCustomer(Customer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(Customer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByCustomername(String Customername) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList <Customer> getAllCustomers() {
		
		
		String sql = "Select * from Customers_Vipers";
		Statement stmt;
		try {
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			CustomerList.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return CustomerList;
		
	}

	@Override
	public void preparedUpdateCustomer(Customer t) {
		// TODO Auto-generated method stub
		
	}

}
