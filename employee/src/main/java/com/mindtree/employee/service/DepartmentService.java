package com.mindtree.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.employee.dto.DepartmentDto;
import com.mindtree.employee.dto.EmployeeDto;
import com.mindtree.employee.entity.Department;
import com.mindtree.employee.exceptions.ControllerException;

@Service
public interface DepartmentService {

	public void setDepartmentWithEmployeeDetails(DepartmentDto departmentsDto, EmployeeDto employeeDto);

	public List<DepartmentDto> getAllTheDepartmentBySalary() throws ControllerException;

}
