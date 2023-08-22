package com.qsp.springboot_student.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_student.dto.Student;
import com.qsp.springboot_student.repo.StudentRepo;
@Repository
public class StudentDao {
	
	@Autowired
	private StudentRepo repo;

	   //To insert the data
	
	public Student saveStudent(Student student) {
		return repo.save(student);
	}

	//To find Employee by ID
	public Student findStudente(int id) {
//		return repo.findById(id).get();
		
		
		// To Avoid NoSUCHWLEMENTEXECEPTION
		Optional<Student> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();

		} else {
			
			return null;
		}
	}
	//To find All 
	public List<Student> findall() {
		return repo.findAll();
		
	}
	
	//To delete 
	
	public Student deleteStudent(int id) {
		Optional<Student> optional=repo.findById(id);
		if (optional.isEmpty()) {
			return null;
			
		}else {
			
			repo.deleteById(id);
			return optional.get();
		}
		
	}
	
	//To update data
	
	public Student updateAlldata(int id,Student student) {
		Optional<Student> optional=repo.findById(id);
		if (optional.isPresent()) {
			student.setId(id);
			return repo.save(student);
			
		} else {
			return null;

		}
		
	}
	
	// Find By Email 

	public Student findByEmail(String email) {
		
		return repo.findByEmail(email);
	}
	
	public Student findByPhone(long phone) {
		return repo.studByPhone(phone);
	}
	
	public List<Student> findBypercentage(double percentage) {
		return repo.findPercentageGreaterThan(percentage);
	}
	

}

