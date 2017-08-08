package com.company.service.impl;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dto.AddAllEmployeesRequest;
import com.company.dto.AddEmployeeRequest;
import com.company.entity.Employee;
import com.company.repository.DepartmentRepository;
import com.company.repository.EmployeeRepository;
import com.company.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeRepository employeeRepository;
	DepartmentRepository departmentRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}
	
	@Override
	public Employee addEmployee(AddEmployeeRequest request) {
		Employee emp = new Employee();
		emp.setFirstName(request.getFirstName());
		emp.setLastName(request.getLastName());
		emp.setSalary(request.getSalary());
		emp.setHireDate(LocalDate.now());
		emp.setSuperior(employeeRepository.findOne(request.getSuperiorId()));
		emp.setDepartment(departmentRepository.findOne(request.getDepartmentId()));
		
		return employeeRepository.saveAndFlush(emp);
	}

	@Override
	public List<Employee> addAllEmployees(AddAllEmployeesRequest employees) {
		List<Employee> list = new LinkedList<>();
		
		for(AddEmployeeRequest request : employees.getEmployees()){
			list.add(addEmployee(request));
		}
		
		return list;
	}

}
