package com.tfood.service;

import java.util.List;

import com.tfood.model.CategoryDTO;

public interface CategoryService {
    List<CategoryDTO> getAll();

    boolean update(CategoryDTO categoryDTO);
//
//    boolean update(int id, String name, String avatar);
//
    boolean delete(int id);
//
//    List<CategoryDTO> findByName(String name);

	void addCategory(CategoryDTO categoryDTO);
	
	List<CategoryDTO> searchCategory(String name);
	
//	void updateCategory(CategoryDTO categoryDTO);
//	
//	String getNameCategory(int id); 
//	
//	List<CategoryDTO> get6ItemsMenu();
//	
//   int getFirstCategory();
	
	String getTitleWithFoodId(int idFood);
	
	String getCategoryNameByTitle(String title);
	
	int checkExistsCategoryTitle(String title);
}
