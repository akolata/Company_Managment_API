package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.repository.DepartmentRepository;
import com.company.repository.EmployeeRepository;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private static final String PAGE_NAME = "employee";
	
	EmployeeRepository employeeRepository;
	DepartmentRepository departmentRepository;
	
	
	@Autowired
	public EmployeeController(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}

	@GetMapping
	public String displayEmployeePage(Model model){
		model.addAttribute("employees",employeeRepository.findAll());
		model.addAttribute("departments",departmentRepository.findAll());
		
		return PAGE_NAME;
	}
}
