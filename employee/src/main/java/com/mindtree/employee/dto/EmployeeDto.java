package com.mindtree.employee.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class EmployeeDto {
private int employeeId;
	
	private String employeeName;
	private int employeeExperience;
	private double employeeSalary;
	@JsonIgnoreProperties("employeesDto")
	private DepartmentDto departmentDto;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeExperience() {
		return employeeExperience;
	}

	public void setEmployeeExperience(int employeeExperience) {
		this.employeeExperience = employeeExperience;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public DepartmentDto getDepartmentDto() {
		return departmentDto;
	}

	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}

	public EmployeeDto(int employeeId, String employeeName, int employeeExperience, double employeeSalary,			DepartmentDto departmentDto) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeExperience = employeeExperience;
		this.employeeSalary = employeeSalary;
		this.departmentDto = departmentDto;
	}

	public EmployeeDto() {
		super();
	}

	public EmployeeDto(int employeeId, String employeeName, int employeeExperience, double employeeSalary) {
	super();
	this.employeeId = employeeId;
	this.employeeName = employeeName;
	this.employeeExperience = employeeExperience;
	this.employeeSalary = employeeSalary;
}

	@Override
	public String toString() {
		return "EmployeeDto [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeExperience="
				+ employeeExperience + ", employeeSalary=" + employeeSalary +  "]";
	}
	
	
	
}
