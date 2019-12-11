package com.mindtree.employee.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class DepartmentDto 
{
	
	private int departmentId;
	private String departmentName;
	@JsonIgnoreProperties("departmentDto")
	private List<EmployeeDto> employeesDto=new ArrayList<EmployeeDto>();
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<EmployeeDto> getEmployeesDto() {
		return employeesDto;
	}
	public void setEmployeesDto(List<EmployeeDto> employeesDto) {
		this.employeesDto = employeesDto;
	}
	public DepartmentDto(int departmentId, String departmentName, List<EmployeeDto> employeesDto) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.employeesDto = employeesDto;
	}
	
	public DepartmentDto(String departmentName) {
		super();
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "DepartmentDto [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employeesDto="
				+ employeesDto + "]";
	}
	public DepartmentDto() {
		super();
	}
	
		
	
	
		
	}

