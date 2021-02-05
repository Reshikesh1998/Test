package com.thinkitive;

import java.util.List;

public interface EmployeeOperations {
	
	public String createEmployee(Employee e);
	public String updateEmployee(Employee e);
	public String deleteEmployee(Employee e);
	public Employee getEmployee(Employee e);
	public List<Employee> DisplayAll();

}
