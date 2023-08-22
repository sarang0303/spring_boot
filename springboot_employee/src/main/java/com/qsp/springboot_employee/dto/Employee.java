package com.qsp.springboot_employee.dto;

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
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private int id;

	// validate name
	@NotNull(message = "Name Can't Be Null")
	@NotBlank(message = "Name Can't Be Blank")
	private String name;

//	@Pattern(regexp = "[6-8][0-9]{9}" ,message = "Invalid Number") use for String type of data
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	@Column(unique = true)
	private long phone;

	@NotNull(message = "Address Can't Be Null")
	@NotBlank(message = "Address Can't Be Blank")
	private String address;

	@Min(value = 1)
	private double salary;

//	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.{2,3}", message = "invalid email")
	@Email(regexp = "[a-z0-9]+@[a-z]+\\.[in ,com]{2,3}", message = "invalid email")
	@Column(unique = true)
	private String email;
	
	private char grade;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", salary="
				+ salary + ", email=" + email + ", grade=" + grade + "]";
	}

}
