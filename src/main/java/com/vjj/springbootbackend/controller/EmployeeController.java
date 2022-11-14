package com.vjj.springbootbackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vjj.springbootbackend.exception.ResourceNotFoundException;
import com.vjj.springbootbackend.model.Address;
import com.vjj.springbootbackend.model.Employee;
import com.vjj.springbootbackend.repository.EmployeeRepository;
import com.vjj.springbootbackend.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String home()
	{
		return "WELCOME";
	}
	
	@GetMapping("/admin")
	public String adminHome()
	{
		return "WELCOME TO ADMIN PAGE";
	}
	
	
	//get all employees
	@GetMapping("/employees")
	public List<Employee> getallEmployees()
	{
		return employeeService.getEmployees();
	}
	
	//Create employee
	//@Transactional(dontRollbackOn=NumberFormatException.class)
	@Transactional
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		employee.setActive(true);
		//employee.setAddress(null);
		
		Employee e= employeeService.storeEmployee(employee);
		/*
		 * int a=0; if(a==0) throw new NumberFormatException();
		 */
		
		return e;
	}
	
	//Get employee by ID api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id)
	{
	
		return ResponseEntity.ok(employeeService.getEmployeeById(id));	
	}
	
	//Update the employee REST API
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails)
	{
		Employee updatedEmployee=employeeService.markInactive(id);
		return ResponseEntity.ok(updatedEmployee);		
	}
	
	@PutMapping("/employees/mark-inactive/{id}")
	public ResponseEntity<Employee> markInactive(@PathVariable Long id)
	{
		Employee updatedEmployee=employeeService.markInactive(id);
		return ResponseEntity.ok(updatedEmployee);
		
	}
	//delete employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id)
	{
		/*Employee employee=employeeRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Emplyee not exist with id :"+id));
	    employeeRepository.delete(employee);*/
		employeeService.deleteEmployee(id);
	    Map<String, Boolean> response=new HashMap<>();
	    response.put("Deleted", Boolean.TRUE);
	    return ResponseEntity.ok(response) ;
	    
	}
	
	
	@PostMapping("/test")
	void func()
	{
		TestController x=new TestController();
		x.insert();
}

	

}
