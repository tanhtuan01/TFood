package com.tfood.service;

import java.util.List;

import com.tfood.model.CartDTO;

public interface CartService {
	
	void addtoCart(CartDTO cartDTO);
	
	List<CartDTO> getAllByUser(int user);
//	
//	boolean deleteCartItem(int cartid, int userid);
//	
//	int countCart(int id);
//	
//	int checkQuantity(int id_user, int id_food);
//	
//	boolean updateCart(CartDTO cartDTO);
//	
//	boolean updateQuantity(CartDTO cartDTO);
	
	int checkExistsFood(int user, int food);
	
	int getQuantifyOfFood(int user, int food);
	
	boolean updateCart(CartDTO cartDTO);
	
	int createSessionCart(int user);
	
	boolean lowQuantity(int cart);
	
	boolean upQuantity(int cart);
	
	int getQuantityInCart(int cart);
	
	boolean deleteItems(int cart);
	
	int totalQuantity(int user);
	
	int totalPrice(int user);
	
	boolean delete(int user);
	
	List<CartDTO> getAllByOrderCode(String orderCode);
}
