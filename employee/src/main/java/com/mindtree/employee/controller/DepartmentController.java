package com.mindtree.employee.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.employee.dto.DepartmentDto;
import com.mindtree.employee.dto.EmployeeDto;
import com.mindtree.employee.entity.Department;
import com.mindtree.employee.entity.Employee;
import com.mindtree.employee.exceptions.ControllerException;
import com.mindtree.employee.service.DepartmentService;

@Controller
//@RequestMapping("/department")
public class DepartmentController {
	
	
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping("/")
	public String index(Model model) {	
		return "menu";
	}
	
	@RequestMapping("/insertdepartment")
	public String addDep(Model model) {	
		return "insertdepartment";
	}
	@RequestMapping("/getdepartment")
	public String getDep(Model model) {	
		return "getdepartment";
	}
	DepartmentDto department;
	@PostMapping("/addDepartment")
	public String setDepartment(@ModelAttribute DepartmentDto departmentsDto ) {
		//String status=departmentService.setDepartmentWithEmployeeDetails(departmentsDto);
		//System.out.println(departmentsDto);
		department=new DepartmentDto(departmentsDto.getDepartmentName());
		return "insertemployee";
	}
	@PostMapping("/addEmployees")
	public String setDepartmentWithEmployees(@ModelAttribute EmployeeDto employeeDto ) {
		departmentService.setDepartmentWithEmployeeDetails(department,employeeDto);
		//System.out.println(departmentsDto);
		return "menu";
	}
	
	@GetMapping("/get/detartment")
	public ResponseEntity<Map<String, Object>> 
	getDepartmentByEmployeesSalary() throws ControllerException
	{
		List<DepartmentDto>departmentsDto=departmentService.getAllTheDepartmentBySalary();
		Map<String, Object> success = new HashMap<String, Object>();
		
		success.put("Status",HttpStatus.OK);
		success.put("TimeStamp",new Date());
		success.put("Body",departmentsDto);
		//error.put("Body",dto,list,);
		
		//error.put("Application_Name",appliactionName);
		return new ResponseEntity<Map<String,Object>>(success,HttpStatus.OK);
	}
	@GetMapping("/getdepartment")
	public String getNames(Model model) throws ControllerException {
		List<DepartmentDto> departmentsDto =departmentService.getAllTheDepartmentBySalary(); ;
		model.addAttribute("departments", departmentsDto);
		for (DepartmentDto departmentDto : departmentsDto) {
			model.addAttribute("employees", departmentDto.getEmployeesDto());	
		}
		return "display";
	}
	

}
