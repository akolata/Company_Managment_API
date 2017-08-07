package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.model.Employee;

public interface EmployeeRepository
extends JpaRepository<Employee,Long>{

}
