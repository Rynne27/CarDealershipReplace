package com.revature.cardealership.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.cardealership.AllOffers;
import com.rrevature.cardealership.util.ConnectionFactory;

public class OfferDaoImpl1 implements OfferDao1 {

	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public void insertOffer(AllOffers o) {
		String sql = "insert into offer_dealership(customer_id, vin_No, offer_price, statusid)" + "values(?,?,?,?);";

		PreparedStatement pstmt;
		//int newId = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, o.getCustomer_id());
			pstmt.setString(2, o.getVIN_No());
			pstmt.setInt(3, o.getOffer_price());
			pstmt.setInt(4, o.getStatusid());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}

		
	}

	@Override
	public ArrayList<AllOffers> getOffersbyCarID(Integer id) {
		ArrayList<AllOffers> offers = new ArrayList<AllOffers>();
		String sql = "select * from offer_dealership where carid = " + id;
		Statement stmt;

		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
//				carList.add(new Car(, , rs.getDouble("car_price"),
//						rs.getBoolean("for_sale"), rs.getBoolean("offer_flag")));
				
				offers.add(new AllOffers(rs.getInt("customer_id"), rs.getInt("vin_No"), 
						rs.getDouble("offer_price"), rs.getInt("statusid")));
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return offers;
	}

	@Override
	public int getCustomerIDbyofferID(Integer offerChosen) {
		String sql = "select * from offer_dealership where offerid = " + offerChosen;
		AllOffers ret = null;
		Statement stmt;

		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				
				ret = new AllOffers(rs.getInt("customer_id"),
						rs.getInt("vin_No"), rs.getDouble("offer_price"), rs.getInt("statusid"));

			//	offers.add(new Offer(rs.getInt(1), rs.getInt("customerid"), rs.getInt("carid"), 
			//			rs.getInt("status_id"), rs.getDouble("offer_price")));
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret.getCustomer_id();
	
	}

}
