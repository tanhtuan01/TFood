package com.tfood.dao;

import java.util.List;

import com.tfood.entity.Cart;

public interface CartDao {
	
	void addtoCart(Cart cart);
	
	List<Cart> getAllByUser(int user);
//	
//	boolean deleteCartItem(int cartid, int userid);
//	
//	int countCart(int id);
//	
//	int checkQuantity(int id_user, int id_food);
//	
//	boolean updateCart(Cart cart);
//	
//	boolean updateQuantity(Cart cart);

	int checkExistsFood(int user, int food);
	
	int getQuantifyOfFood(int user, int food);
	
	boolean updateCart(Cart cart);
	
	int createSessionCart(int user);
	
	boolean lowQuantity(int cart);
	
	boolean upQuantity(int cart);
	
	int getQuantityInCart(int cart);
	
	boolean deleteItems(int cart);
	
	int totalQuantity(int user);
	
	int totalPrice(int user);
	
	boolean delete(int user);
	
	List<Cart> getAllByOrderCode(String orderCode);
	
}
