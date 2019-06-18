package com.revature.cardealership;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.cardealership.dao.CarDao;
import com.revature.cardealership.dao.CarDaoImpl;
import com.revature.cardealership.dao.CustomerDao;
import com.revature.cardealership.dao.CustomerDaoImplm;
import com.revature.cardealership.dao.EmployeeDao;
import com.revature.cardealership.dao.EmployeeDaoImplm;
import com.revature.cardealership.log.LoggingUtil;

public class Employee extends CarLot{
	private static CarDao cardao = new CarDaoImpl();
	private static Scanner sc;// = new Scanner(System.in);
	private static CustomerDao newCust = new CustomerDaoImplm();
	private static EmployeeDao newEmp = new EmployeeDaoImplm();
	public String employeeUserN, employeePassW;
	//private static Employee e = new Employee();
	
	public Employee(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public static void EmployeeLogin() {
		sc = new Scanner(System.in);

		String employeeUserN, employeePassW;
		employeeUserN = "Admin";
		employeePassW = "Admin";
		
		System.out.println("Username: ");
		String employeeUsername = sc.next();
		
		System.out.println("Password: ");
		String employeePassword = sc.next();		
		
		if (employeeUserN.equals(employeeUsername) && (employeePassW.equals(employeePassword))) {
			System.out.println("You are logged In");
			LoggingUtil.info("Employee is now logged in");
			displayEMenu();
		} else {
		System.out.println("Incorrect. Try Again!");
		LoggingUtil.info("Employee has to repeat log in process");
		EmployeeLogin();
		}
	}

	public static void displayEMenu() {
		System.out.println("Welcome. Choose Options. Press 0 for menu");
		System.out.println("1. List all cars");
		System.out.println("2. Add a new car to the list");
		System.out.println("3. Remove a car from the list");
		System.out.println("4. Accept/Reject new offers");
		System.out.println("5. View All Customers");
		System.out.println("6. Go back to main menu");	
		
		int menu = 0;
		
		do {
			System.out.println("What do you want to do? (press 0 to see the menu)");
			menu = sc.nextInt();
			while(menu < 0 || menu > 6) {
				System.out.println("Please enter a correct menu option");
				menu = sc.nextInt();
			}
			doChoices(menu);
		} while (menu !=6);
		
	
	
	}
	
	public static void doChoices(int menu) {

		switch(menu) {
		case 0: 
			System.out.println("Main Menu: ");
			displayEMenu();
			break;
		case 1:
			System.out.println("List all cars");
			displayCars(cars);
			break;
		case 2:
			System.out.println("Add a new car to the list");
			newCars(cars);
			break;
		case 3:
			System.out.println("Remove car from the list");
			removeCar(cars);
			break;
		case 4:
			System.out.println("Accept/Reject new offers");
			//offerChoice();
			break;
		case 5:
			System.out.println("View All Customers");
			for (Customer c : newCust.getAllCustomers()) {
				System.out.println(c);
			}
			break;
		case 6:
			System.out.println("Go back to main menu");
			System.out.println("Press 0 for menu");
			break;
		
		}
	}
		
		public static void newCars(ArrayList<TotalCars> cars) {
	        
	        boolean carInput;
	        String VIN, make, model;
	        int mileage = 0, year = 0, price = 0;
	        
	        System.out.println("Enter a new car in format:");
	        System.out.println("VIN MAKE MODEL YEAR MILEAGE PRICE");
	        System.out.println("EX: KRJ0285 Honda Accord 2015 9500 20000");
	        do {
	            carInput = true;
	            VIN = carlot.next();
	            make = carlot.next();
	            model = carlot.next();
	            if(carlot.hasNextInt()) 
	                year = carlot.nextInt();
	            else carInput = false;
	            if(carlot.hasNextInt())
	                mileage = carlot.nextInt();
	            else carInput = false;
	            if(carlot.hasNextInt())
	                price = carlot.nextInt();
	            else carInput = false;
	            if(!carInput)
	            {
	                System.out.println("\nIncorrect Format.");
	            }
	        } while(carInput == false);
	       // cars.add(new TotalCars(VIN,make,model,year,mileage,price));
	        cardao.createCar(new TotalCars(VIN,make,model,year,mileage,price));
	        System.out.println("A new car has been added");
	        LoggingUtil.info("New car added");
	        doChoices(price);
	        
	    }
		
		public static void removeCar(ArrayList<TotalCars> cars)
	    {
	        int carNo;
	        
	        if(cars.size()>0) {
	            System.out.println("Please select the car you want to remove from the list");
	            displayCars(cars);
	            do {
	                System.out.print("Remove car #: ");
	                while(!carlot.hasNextInt())
	                {
	                    System.out.println("Invalid input");
	                    carlot.next();
	                }
	                carNo = carlot.nextInt();

	            } while (carNo < 1 || carNo > cars.size());
	            cars.remove(carNo-1);
	            System.out.println("You have removed a car");
	            LoggingUtil.info("A car has been removed");
	            doChoices(carNo);
	        } else System.out.println("No cars to remove.");
	    }
		
		
		public static void aOffers(ArrayList<AllOffers> offers) {
			Customer.makeOffer(cars);
			System.out.println("Here is a list off all the offers made: ");
			//offeredCars();
		}
			
//			public static void offeredCars(ArrayList<AllOffers> carlist) {
//		        String formatter = "| %-2d | %-6s | %-15s | %-15s | %-5d | %-8d | $%.2f   |%n";
//		        System.out.format("+----+--------+-----------------+-----------------+-------+----------+---------------------+%n");
//		        System.out.printf("| #  | VIN    | Make            | Model           | Year  | Original Pice | New Price      |%n");
//		        System.out.format("+----+--------+-----------------+-----------------+-------+----------+---------------------+%n");
//		        int i = 0;
//		        for (AllOffers car : carlist) {
//		            System.out.format(formatter,++i,car.getVIN(),car.getMake(),car.getModel(),car.getOriginalPrice(),car.getOfferedPrice());
//		        }
//		        System.out.format("+----+--------+-----------------+-----------------+-------+----------+------------+%n");
//		}
//		
//		public static void displayOffers(ArrayList<TotalOffers> offers) {
//	        3`	2qw4567890-
//		
		
//		public void callingMethod(Class neededClass) {
//		    //Cast the class to the class you need
//		    //and call your method in the class
//		    ((ClassBeingCalled)neededClass).methodOfClass();
//		}
//		To call the method, you call it this way:
//
//		callingMethod(ClassBeingCalled.class);
}

