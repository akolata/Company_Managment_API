package com.company.controller.api;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.dto.AddEmployeeRequest;
import com.company.dto.AddAllEmployeesRequest;
import com.company.model.CustomAPIError;
import com.company.model.Employee;
import com.company.repository.EmployeeRepository;
import com.company.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeRESTController {

	private EmployeeRepository employeeRepository;
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRESTController(EmployeeRepository employeeRepository,EmployeeService employeeService) {
		this.employeeRepository = employeeRepository;
		this.employeeService = employeeService;
	}
	
	@GetMapping(value="/all")
	public Collection<Employee> getAllEmployees(){
		for(Employee e: employeeRepository.findAll()){
			System.out.println(e);
		}
		return employeeRepository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> showOneEmployee(@PathVariable Long id){
		
		ResponseEntity<Object> response ;
		Employee employee = employeeRepository.findOne(id);
		
		if(employee == null){
			response = new ResponseEntity<>(new CustomAPIError("NOT FOUND", "Employee with id " + id + " not found in db", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
		}else{
			return ResponseEntity.ok().body(employee);
		}
		
		return response;
	} 
	
	@PostMapping(value="/add",headers = {"x-requested-with=XMLHttpRequest","Accept=*/*"})
	public ResponseEntity<?> addEmployee(@RequestBody AddEmployeeRequest employee){
		Employee createdEmployee = employeeService.addEmployee(employee);
		
		return new ResponseEntity<Employee>(createdEmployee,HttpStatus.CREATED);
	}
	
	@PostMapping(value="/addAll")
	public ResponseEntity<List<Employee>> addAllEmployees(@RequestBody AddAllEmployeesRequest request){
		List<Employee> list = employeeService.addAllEmployees(request);
		
		return new ResponseEntity<List<Employee>>(list,HttpStatus.CREATED);
	}
}
