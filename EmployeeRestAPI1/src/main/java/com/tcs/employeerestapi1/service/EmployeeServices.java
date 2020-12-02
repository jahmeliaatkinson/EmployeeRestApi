package com.tcs.employeerestapi1.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employeerestapi1.model.Employee;







public interface EmployeeServices {

	public Employee addEmployee(Employee employee);
	   public String updateEmployee(Employee employee);
	   public String deleteEmployee(int id);
	   public Optional<Employee>findById(int id);
	   public Optional<List<Employee>> getEmployees();
	   public Optional<List<Employee>> findByOrganizationId(int id);

	
	   
	
}

