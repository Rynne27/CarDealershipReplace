package com.revature.cardealership;

import java.util.ArrayList;

import com.revature.cardealership.dao.CarDao;
import com.revature.cardealership.dao.CarDaoImpl;
import com.revature.cardealership.log.LoggingUtil;

//import java.util.Scanner;

public class Driver {

	private static CarDao cardao = new CarDaoImpl();
	public static <TotalOffers> void main(String[] args) throws Exception {
		LoggingUtil.info("Program Started Successfully");
//		ArrayList<TotalCars> cars = new ArrayList<>();
//		TotalCars newCar = new TotalCars("JSH0529", "Mazda", "3", 2014, 50000, 9000);
//		cars.add(newCar);
//		cars.add(new TotalCars("AMH0847", "Chevrolet", "Impala", 2008, 70000, 6000));
//		cars.add(new TotalCars("AFJ0847", "BWM", "4Series", 2015, 60000, 12500));
//		cars.add(new TotalCars("AJN9909", "Ford", "Focus", 2009, 90000, 3000));
//		// public class CarLot1
		// CarLot xyx = new CarLot();
		CarLot.initCars();
		
		
		UserLogin ul = new UserLogin();
		ul.userLogin();
		
		Employee e = new Employee();
		e.EmployeeLogin();
		
		
		
//		String VIN;
//	    String make;
//	    String model;
//	    int year = 0;
//	    double mileage = 0;
//	    double price = 0;
//		TotalCars tc = new TotalCars();
//		tc.addNewCar(VIN, make, model, year, mileage, price);
		 
		  
		  //System.out.println("Do you want to log in or register");
		  //Scanner keyboard = new Scanner(); String answer = keyboard.nextLine(); }
		  //while (String answer = "yes")
		 

		// this is called on an Instance of the class (object)
		
			 
			 
		CarLot.displayCars(cardao.getAllCars());
		// CarLot.displayMenu();;

		ArrayList<AllOffers> offers = new ArrayList<>();


		

		

		

		/*
		 * new Customer(input1, input2) {
		 * 
		 * Customer.customers.add(this); } }
		 */
	
	}
	}
