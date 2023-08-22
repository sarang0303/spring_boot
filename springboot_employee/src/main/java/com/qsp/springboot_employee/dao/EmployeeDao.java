package com.qsp.springboot_employee.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.springboot_employee.dto.Employee;
import com.qsp.springboot_employee.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepo repo;

	   //To insert the data
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}

	//To find Employee by ID
	public Employee findEmployee(int id) {
//		return repo.findById(id).get();
		
		
		// To Avoid NoSUCHWLEMENTEXECEPTION
		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();

		} else {
			
			return null;
		}
	}
	//To find All Employee
	public List<Employee> findall() {
		return repo.findAll();
		
	}
	
	//To delete Employee
	
	public Employee deleteEmployee(int id) {
		Optional<Employee> optional=repo.findById(id);
		if (optional.isEmpty()) {
			return null;
			
		}else {
			
			repo.deleteById(id);
			return optional.get();
		}
		
	}
	
	//To update data
	
	public Employee updateAlldata(int id,Employee employee) {
		Optional<Employee> optional=repo.findById(id);
		if (optional.isPresent()) {
			employee.setId(id);
			return repo.save(employee);
			
		} else {
			return null;

		}
		
	}

	public Employee findByEmail(String email) {
		
		return repo.findByEmail(email);
	}
	
	public Employee findByPhone(long phone) {
		return repo.empByPhone(phone);
	}
	
	public List<Employee> findBySalary(double salary) {
		return repo.findBySalaryGreaterThan(salary);
	}
	


  
}
