package com.tfood.dao;

import java.util.List;

import com.tfood.entity.CartSub;

public interface CartSubFoodDao {

	void addToCartSub(CartSub cartSub);

	int checkExistsSubFood(int user, int food);
	
	int getQuantifyOfFood(int user, int food);
	
	boolean updateCart(CartSub cartSub);
	
	int createSessionSubCart(int user);
	
	List<CartSub> getAllByUser(int user);
	
	boolean lowQuantity(int cart);
	
	boolean upQuantity(int cart);
	
	int getQuantityInCart(int cart);
	
	int totalQuantity(int user);
	
	boolean deleteItems(int cart);
	
	int totalPrice(int user);
	
	boolean delete(int user);
}
