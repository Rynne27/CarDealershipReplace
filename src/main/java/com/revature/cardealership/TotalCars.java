package com.revature.cardealership;

import java.io.*;
public class TotalCars implements Serializable {
	
	private static final long serialVersionUID = 1L;
		String VIN;
	    String make;
	    String model;
	    int year;
	    double mileage;
	    double price;
	    
	    public TotalCars() {};   // default constructor

		public TotalCars(String VIN, String make, String model, int year, double d, double e) {
	        this.VIN = VIN;
	        this.make = make;
	        this.model = model;
	        this.year = year;
	        this.mileage = d;
	        this.price = e;
	    }
	    public boolean addNewCar(String VIN, String make, String model, int year, double mileage, double price) {
	        this.VIN = VIN;
	        this.make = make;
	        this.model = model;
	        this.year = year;
	        this.mileage = mileage;
	        this.price = price;
	        return true;
	    }

	    public String getVIN() {
	        return VIN;
	    }

	    public String getMake() {
	        return make;
	    }

	    public String getModel() {
	        return model;
	    }

	    public int getYear() {
	        return year;
	    }

	    public double getMileage() {
	        return mileage;
	    }

	    public double getPrice() {
	        return price;
	    }
	    public void setVIN(String VIN) {
			this.VIN = VIN;
		}
		public void setMake(String make) {
			this.make = make;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public void setMileage(double mileage) {
			this.mileage = mileage;
		}
		public void setPrice(double price) {
			this.price = price;
		}

}
