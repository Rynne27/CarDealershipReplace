 package com.revature.cardealership;

import java.io.*;
import java.util.*;

import com.revature.cardealership.log.LoggingUtil;


public class CarLot {
	
	//
	
	static Scanner carlot = new Scanner(System.in);
	public static ArrayList<TotalCars> cars = new ArrayList<>();
	
	//public static ArrayList<AllOffers> offers = new ArrayList<>();	
	public static ArrayList<TotalCars> offers = new ArrayList<>();
	
	public static void initCars() {
		//ArrayList<TotalCars> cars = new ArrayList<>();
		TotalCars newCar = new TotalCars("JSH0529", "Mazda", "3", 2014, 50000, 9000);
		cars.add(newCar);
		cars.add(new TotalCars("AMH0847", "Chevrolet", "Impala", 2008, 70000, 6000));
		cars.add(new TotalCars("AFJ0847", "BWM", "4Series", 2015, 60000, 12500));
		cars.add(new TotalCars("AJN9909", "Ford", "Focus", 2009, 90000, 3000));	
	}
	public static void carList() throws Exception {
		
		int choices = 0;
		//displayMenu();
		
		do {
			choices = carlot.nextInt();
			while (choices < 0 || choices > 5) {
				System.out.println("Please enter valid option");
				choices = carlot.nextInt();				
			}
			Employee.doChoices(choices);
			//doChoices(choices,cars);
			} while (choices != 6);

        FileOutputStream fos = new FileOutputStream("allCars.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (TotalCars car : cars) {
            oos.writeObject(car);
        }
        fos.close(); }
		
		public static void displayCars(ArrayList<TotalCars> cars2) {
	        //String formatter = "| %-2d | %-6s | %-15s | %-15s | %-5d | %-8d | $%.2d   |%n";
	        System.out.println("+----+--------+-----------------+-----------------+-------+----------+------------+%n");
	        System.out.println("| #  | VIN    | Make            | Model           | Year  | Mileage  | Price      |%n");
	        System.out.println("+----+--------+-----------------+-----------------+-------+----------+------------+%n");
	        int i = 0;
	        for (TotalCars car : cars2) {
	             // System.out.format(formatter, ++i, cars2.getVi)
	        	System.out.println(++i +"          " + car.getVIN() + "          "+ car.getMake() + "          " + car.getModel() +"          "+ car.getYear() +"          "+car.getMileage() +"          "+car.getPrice());
	        }
	        System.out.println("+----+--------+-----------------+-----------------+-------+----------+------------+%n");
	        LoggingUtil.info("Cars displayed successfully");
	    }	
	
		
}


