package com.qsp.springboot_cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.qsp.springboot_cart.dto.Items;

public interface ItemRepo extends JpaRepository<Items, Integer>{
}