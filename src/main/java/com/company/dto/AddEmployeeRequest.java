package com.company.dto;

public class AddEmployeeRequest {

	private String firstName;
	private String lastName;
	private int salary;
	private Long superiorId;
	private Long departmentId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Long getSuperiorId() {
		return superiorId;
	}

	public void setSuperiorId(Long superiorId) {
		this.superiorId = superiorId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "AddEmployeeRequest [firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", superiodId=" + superiorId + ", departmentId=" + departmentId + "]";
	}

}
