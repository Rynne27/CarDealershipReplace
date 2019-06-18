package com.revature.cardealership;

import java.util.Scanner;

public class UserLogin {

	private static Scanner choice;
	//private static Scanner sc;
	//private static Scanner sc2;
private static UserLogin ul;
		
	public static void welcomeMessage() {
		System.out.println("------ Welcome to Windshield Vipers Car Dealers ------");

		System.out.println("Are you a Customer or Employee");
	}
	
 public static void userLogin(){
	 welcomeMessage();
	 ul.callLogin();
	 
	 
	 
//	 boolean exitInput = false;
//		do {
//			choice = new Scanner(System.in);
//			String uChoice = new String();
//			
//			
//			
//			uChoice = choice.nextLine();
//			
//			if (uChoice.compareToIgnoreCase("Employee") == 0) {
//				//call employee login method//
//				Employee.EmployeeLogIn();
//				exitInput = true;
//			} else if (uChoice.compareToIgnoreCase("Customer") == 0) {
//				//call customer login
//			Customer.CustomerRegister();
//			exitInput =  true; }
//			
//			else if ((uChoice != "Employee") && (uChoice != "Customer")) {
//				System.out.println("Please repeat choice");
//			}
//		} while (exitInput == false); 
		
	}

private static void callLogin() {
	Scanner choice = new Scanner(System.in);
	String uChoice = choice.nextLine();
	
	if (uChoice.compareToIgnoreCase("Employee") == 0) {
		Employee.EmployeeLogin();
	} else if (uChoice.compareToIgnoreCase("Customer") == 0) {
		Customer.CustomerRegister();
	}else {
		ul.userLogin();
	}
}
		
}

