package com.company.dto;

import java.util.List;

public class AddAllEmployeesRequest {

	private List<AddEmployeeRequest> employees;

	public List<AddEmployeeRequest> getEmployees() {
		return employees;
	}

	public void setEmployees(List<AddEmployeeRequest> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "AddManyEmployeesRequest [employees=" + employees + "]";
	}
	
}
