package com.qsp.springboot_cart.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

//import lombok.Data;
// import lombok.Getter;
// import lombok.Setter;

@Data
@Entity
// @Getter only use to generate getter
// @Setter only use to generate setter

public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	

	@Column(unique = true)
	private String email;

	private double totalprice;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@Autowired

	List<Items> items;

}
