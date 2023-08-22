package com.qsp.springboot_employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.springboot_employee.dao.EmployeeDao;
import com.qsp.springboot_employee.dto.Employee;
import com.qsp.springboot_employee.exception.DataNotFoundException;
import com.qsp.springboot_employee.exception.EmailNotFoundException;
import com.qsp.springboot_employee.exception.IdNotFoundException;
import com.qsp.springboot_employee.util.ResponseStructure;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;
	ResponseStructure<Employee> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Employee> > saveEmployee(Employee employee) {
		double salary = employee.getSalary();
		if (salary <= 10000) {
			employee.setGrade('A');

		} else if (salary > 10000 && salary <= 20000) {
			employee.setGrade('B');

		} else if (salary > 20000 && salary <= 40000) {
			employee.setGrade('C');
		} else {
			employee.setGrade('D');
		}
		structure.setMessage("Save Succfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveEmployee(employee));
		return new ResponseEntity<>(structure,HttpStatus.CREATED);

	}
	// To find Employee by ID

	public ResponseEntity<ResponseStructure<Employee>> findEmployee(int id) {
		Employee employee = dao.findEmployee(id);
		if (employee != null) {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee); 
			return new ResponseEntity<>(structure,HttpStatus.FOUND);

		} else {
			throw new IdNotFoundException("Employee Id Not Found");
		}

	}

	// To find All Employee

	public ResponseEntity<ResponseStructure<List<Employee>>> findall() {
		List<Employee> list=dao.findall();
		ResponseStructure<List<Employee>> structure= new ResponseStructure<>();
		if (list!=null) {
		    structure.setMessage("Found Succefully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.findall());
			return new ResponseEntity<>(structure,HttpStatus.FOUND);
		}
		
	
		
		else  {
			throw new DataNotFoundException("Employee Data Not Found");
			
			
		}
		
		

	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int id) {
		Employee employee = dao.deleteEmployee(id);
		if (employee!=null) {
			structure.setMessage("Delete successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee);
			return new ResponseEntity<>(structure, HttpStatus.FOUND);

		}else {
			throw new IdNotFoundException("Employee Id Not Found");
			
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateAllData(int id, Employee employee) {

		double salary = employee.getSalary();
		if (salary <= 10000) {
			employee.setGrade('A');

		} else if (salary > 10000 && salary <= 20000) {
			employee.setGrade('B');

		} else if (salary > 20000 && salary <= 40000) {
			employee.setGrade('C');   
		} else {
			employee.setGrade('D');

		}
		Employee employee2 = dao.updateAlldata(id, employee);
		if (employee2 != null) {   
			structure.setMessage("update Succfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(employee);
			return new ResponseEntity<>(structure,HttpStatus.CREATED);

		}else {
			throw new IdNotFoundException("Employee Id Not Found");//Static bonding
			
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updatePhone(int id, long phone) {
		Employee employee = dao.findEmployee(id);
		if (employee != null) {
			employee.setPhone(phone);
			structure.setMessage(" Update");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.updateAlldata(id, employee));
			return new ResponseEntity<>(structure,HttpStatus.CREATED);
			

		}
		throw new IdNotFoundException("Employee Id Not Found");

	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmail(int id, String email) {
		Employee employee = dao.findEmployee(id);
		if (employee != null) {
			employee.setEmail(email);
			structure.setMessage(" Update");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.updateAlldata(id, employee));
			return new ResponseEntity<>(structure,HttpStatus.CREATED);
			

		}
		throw new IdNotFoundException("Employee Id Not Found");

	}

	public ResponseEntity<ResponseStructure<Employee>> updateSalary(int id, double salary) {
		Employee employee = dao.findEmployee(id);
		employee.setSalary(salary);
		Employee employee2= dao.saveEmployee(employee);
		if (employee2!=null) {
			structure.setMessage("update salary Succfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(employee);
			return new ResponseEntity<>(structure, HttpStatus.CREATED);
			
		}else {
			throw new IdNotFoundException("Employee Id Not Found");
		}
		
	}
	// To find Employee by email

	public ResponseEntity<ResponseStructure<Employee>> findByEmail(String email) {
		Employee employee= dao.findByEmail(email);
		if (employee!=null) {
			structure.setMessage("Find By Email Succfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee);
			return new ResponseEntity<>(structure,HttpStatus.FOUND);
			
		}else {
			throw new EmailNotFoundException("Employee Email Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> findByPhone(long phone) {
		Employee employee=dao.findByPhone(phone);
		if (employee!=null) {
			structure.setMessage("Find by Phone Succfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee);
			return new ResponseEntity<>(structure,HttpStatus.FOUND);
			
		}else {
			throw new DataNotFoundException("Phone Not Found");
		}
	}

	
	
	public ResponseEntity<ResponseStructure<List<Employee>>> findBySalaryGreaterThan(double salary) {
		List<Employee>list= dao.findBySalary(salary);
		ResponseStructure<List<Employee>> structure=new ResponseStructure<>();
		
		if (list!=null) {
			structure.setMessage("salary greater than and equal");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.findBySalary(salary));
			return new ResponseEntity<>(structure,HttpStatus.FOUND);
			
		}else {
			throw new DataNotFoundException("Salary Not Found");
		}
	}

}
