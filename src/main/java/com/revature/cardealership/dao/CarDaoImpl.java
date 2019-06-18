package com.revature.cardealership.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.cardealership.TotalCars;
import com.revature.cardealership.log.LoggingUtil;
import com.rrevature.cardealership.util.ConnectionFactory;

public class CarDaoImpl implements CarDao {
	private static Connection conn = ConnectionFactory.getConnection();
	public static ArrayList<TotalCars> carList = new ArrayList<TotalCars>();
	@Override
	public void createCar(TotalCars c) {
		try {
			conn.setAutoCommit(false);
			String query = "Insert into Cars(VIN, Make, Model, Year, Mileage, Price) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getVIN());
			pstmt.setString(2, c.getMake());
			pstmt.setString(3, c.getModel());
			pstmt.setInt(4, c.getYear());
			pstmt.setDouble(5, c.getMileage());
			pstmt.setDouble(6,  c.getPrice());
			Savepoint sp = conn.setSavepoint("Before Creating Car");
			boolean check = pstmt.execute();
			if (check) {
				conn.rollback(sp);
				LoggingUtil.error("Car was not added.Repeat");
			}
			conn.commit();
			conn.setAutoCommit(true);
			LoggingUtil.info("Creating Car was successful");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

}

	@Override
	public void updateCar(TotalCars c) {
		try {
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);  //needs to be done to run transactions
			Savepoint sp = conn.setSavepoint("Before Update");
			String query = "update Cars set price = '" + c.getPrice() + "' where VIN = '" + c.getVIN() + "'";
			//String query2 = "update Cars set Make = '" + c.getMake() + "' where VIN = '" + c.getVIN() + "'";
			
			int numberOfRows = stmt.executeUpdate(query);
			
			if (numberOfRows > 1) {
				conn.rollback(sp);
				System.out.println("Too many rows affected");
			}
			
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCar(String c) {

		String sql = "DELETE FROM Cars WHERE VIN = ?" + c;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				stmt.executeQuery(sql);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public TotalCars getCarById(Integer id) {
		TotalCars ret = null;
		String sql = "select * from Cars where VIN =" + id;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				ret = new TotalCars();
				ret.setVIN(rs.getString(1));
				ret.setMake(rs.getString(2));
				ret.setModel(rs.getString(3));
				ret.setYear(rs.getInt(4));
				ret.setMileage(rs.getDouble(5));
				ret.setPrice(rs.getDouble(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public TotalCars getCarByCarname(String Carname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TotalCars> getAllCars() {
		ArrayList<TotalCars> carList = new ArrayList<TotalCars>();
		
		String sql = "select * from Cars";
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				carList.add(new TotalCars (rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getDouble(6)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return carList;
	}

	@Override
	public void preparedUpdateCar(TotalCars c) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = conn.prepareStatement("update user_table set password = ? where username = ?");
			pstmt.setString(1, c.getVIN());
			pstmt.setString(2, c.getMake());
			pstmt.setString(3, c.getModel());
			pstmt.setInt(4, c.getYear());
			pstmt.setDouble(5, c.getMileage());
			pstmt.setDouble(6, c.getPrice());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
