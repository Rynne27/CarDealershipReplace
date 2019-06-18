package com.revature.cardealership.dao;

import java.util.ArrayList;

import com.revature.cardealership.Employee;

public interface EmployeeDao {
	
	public void createEmployee(Employee m);
	
	public void updateEmployee(Employee m);
	
	public void deleteEmployee(Employee m);
	
	public Employee getEmployeeById(Integer id);
	
	public ArrayList <Employee> getAllEmployees();

	void preparedUpdateEmployee(Employee m);

	

}
