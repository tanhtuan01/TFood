package com.tfood.service;

import java.util.List;

import com.tfood.model.CartSubDTO;

public interface CartSubFoodService {

	void addToCartSub(CartSubDTO cartSubDTO);
	
	int checkExistsSubFood(int user, int food);
	
	int getQuantifyOfFood(int user, int food);
	
	boolean updateCart(CartSubDTO cartSubDTO);
	
	int createSessionSubCart(int user);
	
	List<CartSubDTO> getAllByUser(int user);
	
	boolean lowQuantity(int cart);
	
	boolean upQuantity(int cart);
	
	int getQuantityInCart(int cart);
	
	int totalQuantity(int user);
	
	boolean deleteItems(int cart);
	
	int totalPrice(int user);
	
	boolean delete(int user);
}
