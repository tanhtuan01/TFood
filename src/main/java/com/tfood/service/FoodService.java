package com.tfood.service;

import java.util.List;

import com.tfood.entity.Food;
import com.tfood.model.FoodDTO;

public interface FoodService {

	List<FoodDTO> getAll();
//
	void addFood(FoodDTO foodDTO);
//
	boolean delete(int id);
//	
//	List<FoodDTO> getAllbyCategory(int id);
//	
	void updateFood(FoodDTO foodDTO);
//	
//	List<FoodDTO> getFoodbyId(int id);
//	
//	int CheckFoodId(int id);
//	
//	int CheckCateId(int id);
//	
//	int CheckFoodIdAndCateId(int id1, int id2);
//	
//	List<FoodDTO> getTopSold();
//	
	int getPriceFood(int id);
//	
//	List<FoodDTO> getFood9Deal(int id);
//	
//	List<FoodDTO> getFood9NoDeal(int id);
//	
//	List<FoodDTO> getFoodDealByCategory(int id);
//	
//	List<FoodDTO> getFoodNoDealByCategory(int id);
//	
//	int checkFoodInOrder(int id_food,int id_user);
//	
	List<FoodDTO> getByName(String food);
//	
//	String getNameFood(int id);
//	
//	int getNewPrice(int id);
//	
//	String getAvatar(int id);
//	
//	String getDescription(int id);
//	
//	List<FoodDTO> getTopSoldbyCate(int id);
//	
//	void updateSold(FoodDTO foodDTO);
	
	List<FoodDTO> getDealFood();
	
	List<FoodDTO> getFoodByTitleOfCategory(String title);
	
	String getTitle(int id);
	
	int checkDiscount(int id);
	
	List<FoodDTO> getFoodById(int id);
	
	int getCategory(int id);
	
	int checkFoodExists(int id);
	
	void updateSold(int food, int quantity);
	
	List<FoodDTO> getTop5Sold();
	
	List<FoodDTO> getAnotherFoodByCategory(int category, int food);
	
	List<FoodDTO> searchByName(String name);
	
	int foodQuantity();
	
	void updateLowSold(int food, int quantity);
	
	List<FoodDTO> getAllByCategory(int id);
}
