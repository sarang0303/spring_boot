package com.qsp.springboot_student.controller;

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
import com.qsp.springboot_student.dto.Student;
import com.qsp.springboot_student.service.StudentService;
import com.qsp.springboot_student.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	// save Student
	@ApiOperation(value = "save Empployee", notes = "This Api is used to save the Employee")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "saved Successfully") })
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Student>> save(@Valid @RequestBody Student student) {
//	return dao.saveStudent(student)
		return studentService.save(student);
	}

	// To find by ID
	@ApiOperation(value = "find Employee by ID", notes = "this APi  is used to fetch the employee data based on Primery Key")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Find by ID Successfully") })
	           @ApiResponse(code =404,message =  "Data Not Found")
	@GetMapping("/find")
	public ResponseEntity<ResponseStructure<Student>> findStudent(@Valid @RequestParam int id) {

		return studentService.findStudent(id);
	}

	// To find All
	@GetMapping("/findall")
	public ResponseEntity<ResponseStructure<List<Student>>> findall() {

		return studentService.findall();

	}
	
    // To delete 
	@DeleteMapping("/delete")
	public ResponseStructure<Student> deleteStudent(@Valid @RequestParam int id) {

		return studentService.deleteStudent(id);

	}
  //  To Update
	@PutMapping("/update")
	public ResponseStructure<Student> updateAllData(@Valid @RequestParam int id, @RequestBody Student student) {

		return studentService.updateAllData(id, student);

	}
//  To Update Phone
	@PatchMapping("/updatephone")
	public ResponseEntity<ResponseStructure<Student>> updatePhone(@Valid @RequestParam int id, @RequestParam long phone) {
		return studentService.updatePhone(id, phone);

	}
//  To Update Email
	@PatchMapping("/updateemail")
	public ResponseEntity<ResponseStructure<Student>> updateEmail4(@Valid @RequestParam int id, @RequestParam String email) {
		return studentService.updateEmail(id, email);

	}
//  To Update Percentage
	@PatchMapping("/updatepercentage")
	public ResponseEntity<ResponseStructure<Student>> updatePhone(@Valid @RequestParam int id, @RequestParam double percentage) {
		return studentService.updatePercentage(id, percentage);

	}
//  Find By Email
	@GetMapping("/findbyemail")
	public ResponseEntity<ResponseStructure<Student>> findstudent(@Valid @RequestParam String email) {
		return studentService.findByEmail(email);
	}
//  Find by Phone
	@GetMapping("/findbyphone")
	public ResponseEntity<ResponseStructure<Student>> findByPhone(@Valid @RequestParam long phone) {
		return studentService.findByPhone(phone);
	}
//  Find By Percentage Greater Than
	@GetMapping("/percentagegreaterthan")
	public ResponseEntity<ResponseStructure<List<Student>>> findByPercentageGreaterThan(@Valid @RequestParam double percentage) {
		return studentService.findBypercentageGreaterThan(percentage);
	}
//  Find By Percentage Greater Than
	@GetMapping("/percentagesmallerthan")
	public ResponseEntity<ResponseStructure<List<Student>>> findByPercentageSmallerThan(@Valid @RequestParam double percentage){
		return studentService.findBypercentageGreaterThan(percentage);
	}

}
