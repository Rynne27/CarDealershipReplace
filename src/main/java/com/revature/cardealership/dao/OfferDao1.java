package com.revature.cardealership.dao;

import java.util.ArrayList;

import com.revature.cardealership.AllOffers;

public interface OfferDao1 {

	
//public void createCar(Car c);
	
	//public void updateCustomer(Customer c);
	
	//public void deleteOfferbyCarID(Integer id);
	
//	public Offer getOfferByCustomerId(Integer id);
	
	//public Offer getOfferByCarId(Integer id);
	
	//public Offer getOfferByOfferId(Integer id);
	
//	public Car getUserByUsername(String name);
	
	public ArrayList<AllOffers> getOffersbyCarID(Integer id);
	
	public void insertOffer(AllOffers o);
	
	
	public int getCustomerIDbyofferID(Integer offerChosen);
	
	

}
