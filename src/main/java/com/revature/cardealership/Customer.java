package com.revature.cardealership;

import java.util.ArrayList;
//import java.io.Serializable;
import java.util.Scanner;

import com.revature.cardealership.dao.CarDaoImpl;
import com.revature.cardealership.dao.CustomerDao;
import com.revature.cardealership.dao.CustomerDaoImplm;
import com.revature.cardealership.dao.OfferDao1;
import com.revature.cardealership.dao.OfferDaoImpl1;
import com.revature.cardealership.log.LoggingUtil;

public class Customer extends CarLot {
	
	String name;
	String password;
	private static Scanner sc2, sc3;
	public String input1, input2, input3;
	public static Customer t = new Customer();
	private int id;
	private static CarDaoImpl cdi = new CarDaoImpl();
	private static OfferDao1 od1 = new OfferDaoImpl1();
	private static CustomerDaoImplm cust = new CustomerDaoImplm();


	
	public Customer(String name, String password) {
		super();
		this.name = name;
		this.password = password;
		customers.add(this);
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int int1, String string, String string2) {
		// TODO Auto-generated constructor stub
		this.id = int1;
		this.name = string;
		this.password = string2;
		
	}




	@Override
	public String toString() {
		return "Customer [name=" + name + ", password=" + password + ", id=" + id + "]";
	}




	public static ArrayList<Customer> customers = new ArrayList<>();
	
	public static void CustomerRegister() {
		boolean input = true;
		do {
			sc3 = new Scanner(System.in);
			String tChoice = new String();

			System.out.println("Do you want to Log In or Register");
			LoggingUtil.info("Customer chooses to log in or register");
			
			tChoice = sc3.nextLine();

			if (tChoice.compareToIgnoreCase("Register") == 0) {
				Scanner scanner = new Scanner(System.in);
				 System.out.println("Name: ");
				 t.input1 = scanner.nextLine();
				 System.out.println("Username: ");
				 t.input2 = scanner.nextLine();
				 System.out.println("Password: ");
				 t.input3 = scanner.nextLine();
				 System.out.println("Thank you. You can now log in");
				 LoggingUtil.info("Customer can now log in after registration");
				 CustomerDao newCustomer = new CustomerDaoImplm();
				 newCustomer.createCustomer(t);
				 CustomerLogIn();
			} else if (tChoice.compareToIgnoreCase("Log In") == 0) {
				CustomerLogIn();
			} else if ((tChoice != "Log In") && (tChoice != "Register")) {
				System.out.println("Please repeat choice");
				LoggingUtil.info("Error choosing. Customer has to repeat choice");
			}
	} while (input == false);
	}
	
	public static void CustomerLogIn() {

			sc2 = new Scanner(System.in);
			String userN, passW;

			userN = "Asgardian";
			passW = "Ragnarok";
			
			System.out.println("Username: ");
			String inputUsername = sc2.next();

			System.out.println("Password: ");
			String inputPassword = sc2.next();

			if (userN.equals(inputUsername) && (passW.equals(inputPassword))) {
				System.out.println("Welcome! You are logged In");
				LoggingUtil.info("Customer is now logged in");
				displayCMenu();
			}
			else { 
				System.out.println("Incorrect. Try Again!");
				LoggingUtil.info("Customer has to repeat log in process");
			}
				displayCMenu();
	}

	public static void displayCMenu() {
		System.out.println("Choose Options. Press 0 for menu");
		System.out.println("1. List all cars");
		System.out.println("2. Make an offer for a car");
		System.out.println("3. View your cars");
		System.out.println("4. View remaining payments");
		System.out.println("5. Go back to main menu");

		int menu1 = 0;

		do {
			System.out.println("What do you want to do? (press 0 to see the menu)");
			menu1 = sc2.nextInt();
			while(menu1 < 0 || menu1 > 6) {
				System.out.println("Please enter a correct menu option");
				menu1 = sc2.nextInt();
			}
			doChoices(menu1);
		} while (menu1 !=6);
	}
		
		public static void doChoices(int menu2) {
			switch(menu2) {
			case 0: 
				System.out.println("Main Menu: ");
				displayCMenu();
				break;
			case 1:
				System.out.println("List all cars");
				displayCars(cars);
				break;
			case 2:
				System.out.println("Make an offer for a car");
				makeOffer(cars);
				break;
			case 3:
				System.out.println("View your cars");
				//newCars(cars);
				break;
			case 4:
				System.out.println("View remaining payments");
				//removeCar(cars);
				break;
			case 5:
				System.out.println("Go back to main menu");
				System.out.println("Press 0 for menu");
				break;
			default:
				break;
			}
		}
			
		
		public static void makeOffer(ArrayList<TotalCars> offers) {
				
				int carPos, carPos1;
				String VIN;
				String make, model;
			        int originalPrice = 0;
			        int offeredPrice = 0;
				if(cdi.carList.size()>0) {
				System.out.println("Choose the car you want");
				displayCars(cars);
				
				do {
					System.out.println("Car #: ");
					if (!carlot.hasNextInt())
					{
						System.out.println("Invalid input");
						carlot.nextLine();
					}
					carPos = carlot.nextInt();
					
					} while (carPos < 1 || carPos > cdi.carList.size());
					System.out.println("Input price: ");
					Scanner inpt = new Scanner(System.in);
					carPos1 = inpt.nextInt();
					int pending = 1;
					//code or call to add price to employee and to system
					//offers.add(new AllOffers(VIN,make,model,originalPrice, offeredPrice));
					//offers.add(new )
					od1.insertOffer(new AllOffers(cust.CustomerList.get(1).id, cdi.carList.get(carPos-1).getVIN(), carPos1, pending));
					System.out.println("Thank you!");
					LoggingUtil.info("Customer has successfully made an offer");
				}else {
					System.out.println("Empty ");
					}
			}
			
			public static void viewOffers() {
				//view your cars
				
			}
			
			public static void viewPayments() {
				//view remaining payments
				
			}
				

		//	public static void displayCars(ArrayList<TotalCars> cars) {
				
			//}
			}
