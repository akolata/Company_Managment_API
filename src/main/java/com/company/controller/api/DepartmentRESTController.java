package com.company.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.CustomAPIError;
import com.company.model.Department;
import com.company.repository.DepartmentRepository;

@RestController
@RequestMapping(value = "/api/department")
public class DepartmentRESTController {

	private DepartmentRepository departmentRepository;
	
	@Autowired
	public DepartmentRESTController(DepartmentRepository employeeRepository) {
		this.departmentRepository = employeeRepository;
	}
	
	@GetMapping(value="/all")
	public List<Department> getAllDepartmends(){
		for(Department dept : departmentRepository.findAll()){
			System.out.println(dept);
		}
		return departmentRepository.findAll();
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> addDepartment(@RequestParam(name="name",required = true) String name){
		
		if(name == null || name.trim().equals("")){
			return new ResponseEntity<CustomAPIError>(new CustomAPIError("ERROR", "No departemnt name founded", HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
		}
		
		Department dept = new Department();
		dept.setName(name);
		departmentRepository.saveAndFlush(dept);
		return new ResponseEntity<Department>(dept,HttpStatus.CREATED);
	}
}
