package com.company.service;

import java.util.List;

import com.company.dto.AddEmployeeRequest;
import com.company.dto.AddAllEmployeesRequest;
import com.company.model.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(AddEmployeeRequest employee);
	
	public List<Employee> addAllEmployees(AddAllEmployeesRequest employees);
}
