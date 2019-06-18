package com.revature.cardealership.dao;

import java.util.ArrayList;

import com.revature.cardealership.TotalCars;

public interface CarDao {
	
	public void createCar(TotalCars c);
	
	public void updateCar(TotalCars c);
	
	public void deleteCar(String c);
	
	public TotalCars getCarById(Integer id);
	
	public TotalCars getCarByCarname(String Carname);
	
	public ArrayList<TotalCars> getAllCars();

	void preparedUpdateCar(TotalCars c);

}
