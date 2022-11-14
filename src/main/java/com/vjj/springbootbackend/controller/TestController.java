package com.vjj.springbootbackend.controller;

import org.springframework.transaction.annotation.Transactional;

import com.vjj.springbootbackend.model.Address;
import com.vjj.springbootbackend.model.Employee;
import com.vjj.springbootbackend.service.EmployeeService;

public class TestController {
	 
EmployeeService employeeService;
	@Transactional
	public Employee insert()
	{
		Employee e=new Employee(14l,"qwertttrRam","Kumar","Verma","12345886"
				,"hghsg@hgej.hfh",new Address(14l,"Premnagar","263152"),true);
		employeeService.storeEmployee(e);
		
		Employee e2=null;
		try {
			
		
		e2=insert2();
		}
		catch(Exception ex)
		{
			System.out.println("catch_first");
		}
		System.out.println("Employee 1"+e);
		System.out.println("Employee 2"+e2);
		return e;
	}

	
	public Employee insert2()
	{
		Employee e=new Employee(15l,"qwertyiophfekfroShyam","Kumar","Verma","9090886"
				,"tert@tyu.in",new Address(15l,"Ramnagar","263153"),true);
		employeeService.storeEmployee(e);
	//	try {
		//if(1==1) {    
//			    throw new RuntimeException ("DummyException: this should cause rollback of second insert only!");
	//	}
		
		return e;
	
}
}	
