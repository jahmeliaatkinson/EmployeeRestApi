package com.tcs.employeerestapi1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.employeerestapi1.model.Employee;
import com.tcs.employeerestapi1.repository.EmployeeRepository;



@Service("employeeServices")

public class EmployeeServiceImpl implements EmployeeServices {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public Employee addEmployee(Employee employee) {
		Employee employee2 = null;
		try {
			employee2 = employeeRepository.save(employee);
			return employee2;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
   @Override
	public String updateEmployee(Employee employee) {
		return null;
	}

   @Override
	public String deleteEmployee(int id) {
		return null;
	}
	
   @Override
   public Optional<Employee> findById(int id) {
	   return null;
   }
		
			
	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Employee>> findByOrganizationId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
