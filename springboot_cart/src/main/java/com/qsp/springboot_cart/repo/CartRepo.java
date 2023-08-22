package com.qsp.springboot_cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_cart.dto.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>  {

}
