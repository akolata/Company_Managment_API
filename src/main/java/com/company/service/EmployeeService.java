package com.company.service;

import java.util.List;

import com.company.dto.AddEmployeeRequest;
import com.company.entity.Employee;
import com.company.dto.AddAllEmployeesRequest;

public interface EmployeeService {
	
	public Employee addEmployee(AddEmployeeRequest employee);
	
	public List<Employee> addAllEmployees(AddAllEmployeesRequest employees);
}
