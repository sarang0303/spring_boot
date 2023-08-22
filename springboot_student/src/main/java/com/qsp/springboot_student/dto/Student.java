package com.qsp.springboot_student.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



import lombok.Data;
@Entity
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Name  Cant Be Null")
	@NotBlank(message = "Name  Cant Be Blank" )
	private String name;
	
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	@Column(unique = true)
	private long phone;
	
	@NotNull(message = "Name  Cant Be Null")
	@NotBlank(message = "Name  Cant Be Blank" )
	private String address;
	
	@Min(value = 0)
	@Max(value = 500)
	private double marks;
	@Column(unique = true)
	
	@Email(regexp = "[a-z0-9._%+-]+@[a-z]+\\.[in ,com]{2,3}", message = "invalid email")
	private String email;
	
	private double percentage;
	
	private String grade;
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", marks=" + marks
				+ ", email=" + email + ", grade=" + grade + "]";
	}
	
	


}
