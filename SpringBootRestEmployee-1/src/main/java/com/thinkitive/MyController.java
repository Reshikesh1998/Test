package com.thinkitive;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	EmployeeCRUD o= new EmployeeCRUD();

	@RequestMapping("/")
	public String hello() 
	{
		return "Hello World";
		
	}

	
	@GetMapping("/single")
	public Employee getOne(@RequestBody Employee e) 
	{
		Employee em = o.getEmployee(e);
		return e;
	}
	
	@GetMapping("/all")
	public List<Employee> getAll() 
	{ 		
		return(o.DisplayAll());
	}
	
	@PostMapping("/insert")
	public String addemployee(@RequestBody Employee e) 
	{
		System.out.println(e);
		return (o.createEmployee(e));
		
	}
	
	@PutMapping("/update")
	public String updateemployee(@RequestBody Employee e) 
	{
		System.out.println(e);
		return (o.updateEmployee(e));
		
	}
	@DeleteMapping("/del")
	public String deleteemployee(@RequestBody Employee e) 
	{
		System.out.println(e);
		String s=o.deleteEmployee(e);
		return (s);
		
	}
}
