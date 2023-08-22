package com.qsp.springboot_student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_student.dao.StudentDao;
import com.qsp.springboot_student.dto.Student;
import com.qsp.springboot_student.exception.DataNotFoundException;
import com.qsp.springboot_student.exception.IdNotFoundException;
import com.qsp.springboot_student.util.ResponseStructure;

@Service
public class StudentService {
	@Autowired
	public StudentDao dao;
    ResponseStructure<Student> structure=new ResponseStructure<>();
    
    public ResponseEntity<ResponseStructure<Student>> save(Student student){
    	double marks=student.getMarks();
    	double percentage=(marks/500)*100;
    	
    	student.setPercentage(percentage);
    	
    	      student.getPercentage();
    	if (percentage <=85) {
    		student.setGrade("Distinguished");
			
		}else if (percentage<=60 && percentage>85) {
			student.setGrade("1st class");
			
		}else if (percentage<=50 && percentage>60) {
			student.setGrade("2nd class");
			
		}else if (percentage<=35 && percentage>50) {
			student.setGrade("3rd class");
			
		}
		else if (percentage>35 ) {
			student.setGrade("Fail");
			
		}
    	
    	Student student2=dao.saveStudent(student);
    	if (student2!=null) {
    		structure.setMessage("Save Succfully");
    		structure.setStatus(HttpStatus.CREATED.value());
    		structure.setData(student);
    		
        			
    		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.CREATED) ;
        	
			
		}
    	throw new DataNotFoundException("Data Not Inserted");
    	
    }
 // To find  by ID

 	public ResponseEntity<ResponseStructure<Student>> findStudent(int id) {
 		Student student = dao.findStudente(id);
 		if (student != null) {
 			structure.setMessage("Found Successfully");
 			structure.setStatus(HttpStatus.FOUND.value());
 			structure.setData(student);
 			return new ResponseEntity<>(structure,HttpStatus.FOUND);

 		} else {
 			throw new IdNotFoundException("Id Not Found");
 		}

 	}

 	// To find All 

 	public ResponseEntity<ResponseStructure<List<Student>>> findall() {
 		List<Student> list=dao.findall();
 		ResponseStructure<List<Student>> structure= new ResponseStructure<>();
 		if (list!=null) {
 		    structure.setMessage("Found Succefully");
 			structure.setStatus(HttpStatus.FOUND.value());
 			structure.setData(dao.findall());
 			return new ResponseEntity<>(structure,HttpStatus.FOUND);
 		}
 		
 	
 		
 		else  {
 			 throw new IdNotFoundException("Id Not found");
 			
 			
 		}
 		
 		

 	}

 	public ResponseStructure<Student> deleteStudent(int id) {
 		Student student = dao.deleteStudent(id);
 		if (student!=null) {
 			structure.setMessage("Delete successfully");
 			structure.setStatus(HttpStatus.FOUND.value());
 			structure.setData(student);
 			return structure;

 		}else {
 			 throw new IdNotFoundException("Id Not found");
 			
 		}

 	}

 	public ResponseStructure<Student> updateAllData(int id, Student student) {

 		double percentage = student.getPercentage();
 		if (percentage <=85) {
    		student.setGrade("Distinguished");
			
		}else if (percentage<=60 && percentage>85) {
			student.setGrade("1st class");
			
		}else if (percentage<=50 && percentage>60) {
			student.setGrade("2nd class");
			
		}else if (percentage<=35 && percentage>50) {
			student.setGrade("3rd class");
			
		}
		else if (percentage>35 ) {
			student.setGrade("Fail");
			
		}
 		Student student2= dao.updateAlldata(id, student);
 		if (student2 != null) {
 			structure.setMessage("update Succfully");
 			structure.setStatus(HttpStatus.CREATED.value());
 			structure.setData(student);
 			return structure;

 		}else {
 			 throw new IdNotFoundException("Id Not found");
 		}

 	}

 	public ResponseEntity<ResponseStructure<Student> > updatePhone(int id, long phone) {
 		Student student= dao.findStudente(id);
 		if (student!= null) {
 			student.setPhone(phone);
 			
 			
 			structure.setMessage("update Succfully");
 			structure.setStatus(HttpStatus.CREATED.value());
 			structure.setData(student);
 			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.CREATED);
 			

 		}
 		throw new IdNotFoundException("ID Not Found");

 	}

 	public ResponseEntity<ResponseStructure<Student>> updateEmail(int id, String email) {
 		Student student = dao.findStudente(id);
 		if (student!= null) {
 			student.setEmail(email);
 			structure.setMessage("update Succfully");
 			structure.setStatus(HttpStatus.CREATED.value());
 			structure.setData(student);
 			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.CREATED);

 		}
 		else {
			throw new IdNotFoundException("Id Not Found");
		}

 	}

 	public ResponseEntity<ResponseStructure<Student>> updatePercentage(int id, double percentage) {
 		Student student = dao.findStudente(id);
 		student.setPercentage(percentage);
 		Student student2= dao.saveStudent(student);
 		if (student2!=null) {
 			structure.setMessage("update Percentage Succfully");
 			structure.setStatus(HttpStatus.CREATED.value());
 			structure.setData(student);
 			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.CREATED);
 			
 		}else {
 			throw new IdNotFoundException("Id Not Found");
 			
 		}
 		
 	}
 	// To find Employee by email

 	public ResponseEntity<ResponseStructure<Student>> findByEmail(String email) {
 		Student student= dao.findByEmail(email);
 		if (student!=null) {
 			structure.setMessage("Find By Email Succfully");
 			structure.setStatus(HttpStatus.FOUND.value());
 			structure.setData(student);
 			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);
 			
 		}else {
 			throw new IdNotFoundException("Email Not Found");
 		}
 	}

 	public ResponseEntity<ResponseStructure<Student>> findByPhone(long phone) {
 		Student student=dao.findByPhone(phone);
 		if (student!=null) {
 			structure.setMessage("Find by Phone Succfully");
 			structure.setStatus(HttpStatus.FOUND.value());
 			structure.setData(student);
 			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);
 			
 		}else {
 			throw new IdNotFoundException("Phone Not Found");
 		}
 	}

 	public ResponseEntity<ResponseStructure<List<Student>>> findBypercentageGreaterThan(double percentage) {
 		List<Student>list= dao.findBypercentage(percentage);
 		ResponseStructure<List<Student>> structure=new ResponseStructure<>();
 		
 		if (list!=null) {
 			structure.setMessage("Percentage greater than and equal");
 			structure.setStatus(HttpStatus.FOUND.value());
 			structure.setData(dao.findBypercentage(percentage));
 			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);
 			
 		}else {
 			throw new DataNotFoundException("Data Not Found");
 		}
 	}
 	
 	public ResponseEntity<ResponseStructure<List<Student>>> findBypercentageSmallerThan(double percentage) {
 		List<Student>list= dao.findBypercentage(percentage);
 		ResponseStructure<List<Student>> structure=new ResponseStructure<>();
 		
 		if (list!=null) {
 			structure.setMessage("Percentage smaller than and equal");
 			structure.setStatus(HttpStatus.FOUND.value());
 			structure.setData(dao.findBypercentage(percentage));
 			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);
 			
 		}else {
 			throw new DataNotFoundException("Data Not Found");
 		}
 	}

    

}
