package com.vjj.springbootbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.vjj.springbootbackend.exception.ResourceNotFoundException;
import com.vjj.springbootbackend.model.Employee;
import com.vjj.springbootbackend.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee storeEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
		
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findByActive(true);
		//return null;
	}

	@Override
	public  Employee updateEmployee(Long id, Employee employeeDetails) {
		Employee employee=employeeRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee not exist with id :"+id));
					
					
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setMiddleName(employeeDetails.getMiddleName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setMobileNo(employeeDetails.getMobileNo());
		employee.setAddress(employeeDetails.getAddress());
		employee.setActive(employeeDetails.getActive());
		
		Employee updatedEmployee=employeeRepository.save(employee);
		return updatedEmployee;
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		Employee employee=employeeRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee not exist with id :"+id));
		employeeRepository.delete(employee);
		
	}
	
	
	public Employee markInactive(Long id)
	{
		Employee employee=employeeRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee not exist with id :"+id));
					
					
		employee.setActive(Boolean.FALSE);
		
		Employee updatedEmployee=employeeRepository.save(employee);
		return updatedEmployee;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Employee employee=employeeRepository.findByIdAndActive(id,true).orElseThrow(
				()-> new ResourceNotFoundException("Employee not exist with id :"+id));
					//return ResponseEntity.ok(employee);
		return employee;
	}
	
	
	
}
