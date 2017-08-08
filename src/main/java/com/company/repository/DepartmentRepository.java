package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.Department;

public interface DepartmentRepository 
extends JpaRepository<Department,Long>{

}
