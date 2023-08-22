package com.qsp.springboot_employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_employee.dao.EmployeeDao;
import com.qsp.springboot_employee.dto.Employee;
import com.qsp.springboot_employee.service.EmployeeService;
import com.qsp.springboot_employee.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	
	
//	@Autowired
//	private EmployeeDao dao;

	@ApiOperation(value = "save Empployee", notes = "This Api is used to save the Employee")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "saved Successfully") })
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@Valid @RequestBody Employee employee) {
//		return dao.saveEmployee(employee);
		return employeeService.saveEmployee(employee);
	}

	// To find Employee by ID"
	@ApiOperation(value = "find Employee by ID", notes = "this APi  is used to fetch the employee data based on Primery Key")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Find by ID Successfully") })
	           @ApiResponse(code =404,message =  "Data Not Found") 
	@GetMapping("/find")
	public ResponseEntity<ResponseStructure<Employee>> findEmployee(@Valid @RequestParam int id) {
//		return dao.findEmployee(id);
		return employeeService.findEmployee(id);
	}

	// To find All Employee
	@GetMapping("/findall")
	public ResponseEntity<ResponseStructure<List<Employee>>> findall() {
//	return	dao.findall();
		return employeeService.findall();

	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@Valid @RequestParam int id) {
//		return dao.deleteEmployee(id);
		return employeeService.deleteEmployee(id);

	}

	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Employee>> updateAllData(@Valid @RequestParam int id,
			@RequestBody Employee employee) {
//	return	dao.updateAlldata(id,employee);
		return employeeService.updateAllData(id, employee);

	}

	@PatchMapping("/updatephone")
	public ResponseEntity<ResponseStructure<Employee>> updatePhone(@Valid @RequestParam int id,
			@RequestParam long phone) {
		return employeeService.updatePhone(id, phone);

	}

	@PatchMapping("/updateemail")
	public ResponseEntity<ResponseStructure<Employee>> updateEmail4(@Valid @RequestParam int id,
			@RequestParam String email) {
		return employeeService.updateEmail(id, email);

	}

	@PatchMapping("/updatesalary")
	public ResponseEntity<ResponseStructure<Employee>> updatePhone(@Valid @RequestParam int id,
			@RequestParam double salary) {
		return employeeService.updateSalary(id, salary);

	}

	@GetMapping("/findbyemail")
	public ResponseEntity<ResponseStructure<Employee>> findEmployee(@Valid @RequestParam String email) {
		return employeeService.findByEmail(email);
	}

	@GetMapping("/findbyphone")
	public ResponseEntity<ResponseStructure<Employee>> findByPhone(@Valid @RequestParam long phone) {
		return employeeService.findByPhone(phone);
	}

	@GetMapping("/salarygreaterthan")
	public ResponseEntity<ResponseStructure<List<Employee>>> findBySalaryGreaterThan(
			@Valid @RequestParam double salary) {
		return employeeService.findBySalaryGreaterThan(salary);
	}

}
