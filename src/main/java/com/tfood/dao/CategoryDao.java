package com.tfood.dao;

import java.util.List;

import com.tfood.entity.Category;

public interface CategoryDao {
    List<Category> getAll();

    void addCategory(Category category);

    boolean update(Category category);
//
//    boolean update(int id, String name, String avatar);
//
    boolean delete(int id);
    
    List<Category> searchCategory(String name);
//
//    List<Category> findByName(String name);
//    
//    void updateCategory(Category category);
//    
//    String getNameCategory(int id); 
//    
//    List<Category> get6ItemsMenu();
//    
//    int getFirstCategory();
    
    String getTitleWithFoodId(int idFood);
    
    String getCategoryNameByTitle(String title);
    
    int checkExistsCategoryTitle(String title);
}
