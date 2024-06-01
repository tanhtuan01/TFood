package com.tfood.service;

import java.util.List;

import com.tfood.model.SubFoodDTO;

public interface SubFoodService {

	void addSubFood(SubFoodDTO subFoodDTO);
	
	List<SubFoodDTO> getAll();
	
	boolean deleteSubFood(int id);
	
	void updateSubFood(SubFoodDTO subFoodDTO);
	
	List<SubFoodDTO> getByName(String name);
	
	List<SubFoodDTO> getAllByCategory(int id);
	
	int subFoodQuantity();
}
