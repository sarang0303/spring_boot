package com.qsp.springboot_cart.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	
	private double price;
	
	private String brand;
	

	private int quantity;

	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", price=" + price + ", brand=" + brand + ", quantity=" + quantity
				+ "]";
	}
	
	
	

}
