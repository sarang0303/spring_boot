package com.qsp.springboot_cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.qsp.springboot_cart.dao.CartDao;
import com.qsp.springboot_cart.dto.Cart;
import com.qsp.springboot_cart.dto.Items;

@Service
public class CartService {
	@Autowired
	private CartDao cartDao;

	public Cart saveCart(Cart cart) {
		List<Items> items = cart.getItems();
		double totalprice = 0;
		for (Items item : items) {
			totalprice += item.getQuantity() + item.getPrice();

		}
		cart.setTotalprice(totalprice);
		return cartDao.saveCart(cart);

	}

	public Cart findById(int id) {
		return cartDao.findById(id);

	}

	public Cart update(int id, Cart cart) {
		Cart dbcart = cartDao.findById(id);
		if (dbcart != null) {
			cart.setId(id);
			List<Items> dbItems = dbcart.getItems();
			List<Items> items = cart.getItems();

			for (int j = 0; j < dbItems.size(); j++) {
				items.get(j).setId(dbItems.get(j).getId());
			}

			cart.setItems(items);

		}
		return saveCart(cart);

	}

	public List<Cart> findAllCart() {
		List<Cart> carts = cartDao.findAllCart();
		if (carts != null) {
			System.out.println(carts);

		} else {
			System.out.println("Id not Found");
		}
		return carts;

	}

	public Cart deleteById(int id) {
		Cart cart = cartDao.deleteById(id);
		if (cart != null) {
			System.out.println(cart);

		} else {
			System.out.println("No Data Present");
		}
		return cart;
	}
   
	
}
