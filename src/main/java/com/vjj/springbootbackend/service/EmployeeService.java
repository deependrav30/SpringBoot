package com.vjj.springbootbackend.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.vjj.springbootbackend.model.Employee;

public interface EmployeeService {
	public Employee storeEmployee(Employee employee);
	public List<Employee> getEmployees();
	public Employee updateEmployee(Long id, Employee employeeDetails);
	public void deleteEmployee(Long id);
	public Employee getEmployeeById(Long id);
	public Employee markInactive(Long id);

}
