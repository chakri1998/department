package com.mindtree.employee.serviceimplementation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.mindtree.employee.dto.DepartmentDto;
import com.mindtree.employee.dto.EmployeeDto;
import com.mindtree.employee.entity.Department;
import com.mindtree.employee.entity.Employee;
import com.mindtree.employee.exceptions.ControllerException;
import com.mindtree.employee.repository.DepartmentRepository;
import com.mindtree.employee.repository.EmployeeRepository;
import com.mindtree.employee.service.DepartmentService;

@Service
public class DepartmentServiceImplementation implements DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void setDepartmentWithEmployeeDetails(DepartmentDto departmentsDto, EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		List<EmployeeDto> employees=new ArrayList<EmployeeDto>();
		employees.add(employeeDto);
		employeeDto.setDepartmentDto(departmentsDto);
		departmentsDto.setEmployeesDto(employees);
		//List<Department> departments = new ArrayList<Department>();
		ModelMapper modelMappper = new ModelMapper();
		
		Department department = modelMappper.map(departmentsDto, Department.class);
			//departments.add(department);
		
		
			List<Employee> newEmployee = new ArrayList<Employee>();
			for (Employee employee : department.getEmployees()) {
				department.setEmployees(department.getEmployees());
				double salary = employee.getEmployeeExperience() * 200000;
				employee.setEmployeeSalary(salary);
				employee.setDepartment(department);
				newEmployee.add(employee);
			}
			department.setEmployees(newEmployee);
			departmentRepository.save(department);
			employeeRepository.saveAll(department.getEmployees());
		

	}

	@Override
	public List<DepartmentDto> getAllTheDepartmentBySalary() throws ControllerException {
		// TODO Auto-generated method stub

		double sum = 0;

		List<DepartmentDto> result = new ArrayList<DepartmentDto>();
//		List<DepartmentDto> result1=new ArrayList<DepartmentDto>();
		List<EmployeeDto> listOfEmployeeDto = new ArrayList<EmployeeDto>();
		List<Department> departments = departmentRepository.findAll();
//		List<Employee> employees = new ArrayList<Employee>() ;
				///employeeRepository.findAll();
		
//		ModelMapper modelMapper = new ModelMapper();
		DepartmentDto departmentDto = new DepartmentDto();
		
		for (Department department : departments) {
			sum=0.0;

			for (Employee employee : department.getEmployees())
			{
				sum = sum + employee.getEmployeeSalary();			
			}/////employee:empList
			if(sum>=5000)
			{
				/////converting dep to depDto
				departmentDto = new DepartmentDto();
				//Employee are not getting copied
				BeanUtils.copyProperties(department, departmentDto);
				//converting set of employee to employee dto
				listOfEmployeeDto = new ArrayList<EmployeeDto>();
				for(Employee e:department.getEmployees())
				{
					EmployeeDto employeeDto = new EmployeeDto();
					BeanUtils.copyProperties(e, employeeDto);
					listOfEmployeeDto.add(employeeDto);
					
				}
				///setting employeedto list to deptDto
				departmentDto.setEmployeesDto(listOfEmployeeDto);
				////adding depDto to List of depDtoList
				result.add(departmentDto);
				
				//listOfEmployeeDto.clear();
			}///if sum > 5000000
			
			//System.out.println(departmentDto);
		}/////dep
		if(result.isEmpty()) {
			throw new ControllerException("no department found");
		}

		return result;

	}
}
