package com.tfood.dao;

import java.util.List;

import com.tfood.entity.SubFood;

public interface SubFoodDao {

	void addSubFood(SubFood subFood);

	List<SubFood> getAll();
	
	boolean deleteSubFood(int id);
	
	void updateSubFood(SubFood subFood);
	
	List<SubFood> getByName(String name);
	
	List<SubFood> getAllByCategory(int id);
	
	int subFoodQuantity();
	
}
