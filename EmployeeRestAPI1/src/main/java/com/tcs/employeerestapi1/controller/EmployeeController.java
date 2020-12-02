package com.tcs.employeerestapi1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.employeerestapi1.exception.ResourceNotFoundException;
import com.tcs.employeerestapi1.model.Employee;
import com.tcs.employeerestapi1.service.EmployeeServices;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
@Autowired
	EmployeeServices employeeServices;
	

	@GetMapping
	public List<Employee> getEmployees() {
	
		return employeeServices.getEmployees().get();
		
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> findById(@PathVariable("id") int Id) throws ResourceNotFoundException {
		Employee employee = employeeServices.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Employee not found"));
		
		return ResponseEntity.ok().body(employee);
	}

/**

	@PostMapping
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee,UriComponentsBuilder uriComponentsBuilder,HttpServletRequest request) {
	
	Employee employee2 = employeeServices.addEmployee(employee);
		UriComponents uriComponents = uriComponentsBuilder
				.path(request.getRequestURI()+"/{id}")
				.buildAndExpand(employee2.findById());
		
		
	  return 	 ResponseEntity.created(uriComponents.toUri()).body(employee2);
	}
	
	
**/
	@DeleteMapping("/{id}")

	public Map<String, Boolean> deleteProductById(@PathVariable int id) throws ResourceNotFoundException { 
		Employee employee = employeeServices.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
		
		employeeServices.deleteEmployee(id);
		HashMap<String, Boolean> hashMap = new HashMap<>();
		hashMap.put("deleted", Boolean.TRUE);
		
		return hashMap;
	}
	





@PutMapping("/{id}")

public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id,
		@Valid @RequestBody Employee employee ) throws ResourceNotFoundException {
	Employee employee2 = employeeServices.findById(id)
			.orElseThrow(()-> new ResourceNotFoundException("Product not found"));
	employee.setId(id);
	Employee employee3 =employeeServices.addEmployee(employee);
	
	return ResponseEntity.ok(employee3);
}
}
