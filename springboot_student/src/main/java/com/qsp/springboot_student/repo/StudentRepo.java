package com.qsp.springboot_student.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.qsp.springboot_student.dto.Student;
public interface StudentRepo extends JpaRepository<Student, Integer> {
	Student findByEmail(String email);
	
	@Query("SELECT s FROM Student s WHERE s.phone=?1")
	Student studByPhone(long phone);
	
	@Query("SELECT s FROM Student s WHERE s.percentage>=?1")
	List<Student> findPercentageGreaterThan(double percentage);
	
	@Query("SELECT s FROM Student s WHERE s.percentage<=?1")
	List<Student> findPercentageSmallerThan(double percentage);
	
	
}


