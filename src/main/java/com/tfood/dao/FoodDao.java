package com.tfood.dao;

import java.util.List;

import com.tfood.entity.Food;

public interface FoodDao {
	List<Food> getAll();
//	
	void addFood(Food food);
//	
	boolean delete(int id);
//
//	List<Food> getAllbyCategory(int id);
//
	void updateFood(Food food);
//	
//	List<Food> getFoodbyId(int id);
//	
//	int CheckFoodId(int id);
//	
//	int CheckCateId(int id);
//	
//	int CheckFoodIdAndCateId(int id1, int id2);
//	
//	List<Food> getTopSold();
//	
	int getPriceFood(int id);
//	
//	List<Food> getFood9Deal(int id);
//	
//	List<Food> getFood9NoDeal(int id);
//	
//	List<Food> getFoodDealByCategory(int id);
//	
//	List<Food> getFoodNoDealByCategory(int id);
//	
//	int checkFoodInOrder(int id_food,int id_user);
//	
	List<Food> getByName(String food);
//	
//	String getNameFood(int id);
//	
//	int getNewPrice(int id);
//	
//	String getAvatar(int id);
//	
//	String getDescription(int id);
//	
//	List<Food> getTopSoldbyCate(int id);
//	
//	void updateSold(Food food);
	
	List<Food> getDealFood();
	
	List<Food> getFoodByTitleOfCategory(String title);
	
	String getTitle(int id);
	
	int checkDiscount(int id);
	
	List<Food> getFoodById(int id);
	
	int getCategory(int id);
	
	int checkFoodExists(int id);
	
	void updateSold(int food, int quantity);
	
	List<Food> getTop5Sold();
	
	List<Food> getAnotherFoodByCategory(int category, int food);
	
	List<Food> searchByName(String name);
	
	int foodQuantity();
	
	void updateLowSold(int food, int quantity);
	
	List<Food> getAllByCategory(int id);
}
