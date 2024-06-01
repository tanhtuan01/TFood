package com.tfood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfood.dao.CategoryDao;

import com.tfood.entity.Category;

import com.tfood.model.CategoryDTO;
import com.tfood.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<CategoryDTO> getAll() {
        List<CategoryDTO> listCateDTO = new ArrayList<CategoryDTO>();
        List<Category> listCategory = categoryDao.getAll();
        for (Category category : listCategory) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setTenDanhMuc(category.getTenDanhMuc());
            categoryDTO.setId(category.getId());
            categoryDTO.setImg(category.getImg());
            categoryDTO.setThuTuHienThi(category.getThuTuHienThi());
            categoryDTO.setTitle(category.getTitle());
            categoryDTO.setThoiGianTao(category.getThoiGianTao());
            categoryDTO.setThoiGianCapNhat(category.getThoiGianCapNhat());
            listCateDTO.add(categoryDTO);
        }
        return listCateDTO;
    }


	@Override
    public void addCategory(CategoryDTO categoryDTO) {
        // chuyển cate dto từ trình duyệt sang cate entity và gọi hàm addCate của
        // userCate để thêm vào csdl
        Category cate = new Category();
        cate.setImg(categoryDTO.getImg());
        cate.setTenDanhMuc(categoryDTO.getTenDanhMuc());
        cate.setThuTuHienThi(categoryDTO.getThuTuHienThi());
        cate.setTitle(categoryDTO.getTitle());
        categoryDao.addCategory(cate);
    }
    
    @Override
    public boolean update(CategoryDTO categoryDTO) {
        Category cate = new Category();
        cate.setTenDanhMuc(categoryDTO.getTenDanhMuc());
        cate.setId(categoryDTO.getId());
        cate.setTitle(categoryDTO.getTitle());
        cate.setImg(categoryDTO.getImg());
        cate.setThuTuHienThi(categoryDTO.getThuTuHienThi());
        return categoryDao.update(cate);
    }
//
//    @Override
//    public boolean update(int id, String name, String avatar) {
//        // TODO Auto-generated method stub
//        return categoryDao.update(id, name, avatar);
//    }
//
    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return categoryDao.delete(id);
    }
//
//    @Override
//    public List<CategoryDTO> findByName(String name) {
//        List<CategoryDTO> listCateDTO = new ArrayList<CategoryDTO>();
//        List<Category> listCategory = categoryDao.findByName(name);
//        for (Category category : listCategory) {
//            CategoryDTO categoryDTO = new CategoryDTO();
//            categoryDTO.setName(category.getName());
//            categoryDTO.setId(category.getId());
//            categoryDTO.setAvatar(category.getAvatar());
//            listCateDTO.add(categoryDTO);
//        }
//        return listCateDTO;
//    }
//
//
//	@Override
//	public void updateCategory(CategoryDTO categoryDTO) {
//		 Category cate = new Category();
//        cate.setName(categoryDTO.getName());
//        cate.setAvatar(categoryDTO.getAvatar());
//        cate.setId(categoryDTO.getId());
//        categoryDao.updateCategory(cate);
//		
//	}
//
//
//	@Override
//	public String getNameCategory(int id) {
//		// TODO Auto-generated method stub
//		return categoryDao.getNameCategory(id);
//	}
//
//
//	@Override
//    public List<CategoryDTO> get6ItemsMenu() {
//
//        List<CategoryDTO> listCateDTO = new ArrayList<CategoryDTO>();
//        List<Category> listCategory = categoryDao.get6ItemsMenu();
//        for (Category category : listCategory) {
//            CategoryDTO categoryDTO = new CategoryDTO();
//            categoryDTO.setName(category.getName());
//            categoryDTO.setId(category.getId());
//            categoryDTO.setAvatar(category.getAvatar());
//            listCateDTO.add(categoryDTO);
//        }
//        return listCateDTO;
//    }
//
//
//	@Override
//	public int getFirstCategory() {
//		// TODO Auto-generated method stub
//		return categoryDao.getFirstCategory();
//	}


	@Override
	public List<CategoryDTO> searchCategory(String name) {
		List<CategoryDTO> listCateDTO = new ArrayList<CategoryDTO>();
        List<Category> listCategory = categoryDao.searchCategory(name);
        for (Category category : listCategory) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setTenDanhMuc(category.getTenDanhMuc());
            categoryDTO.setId(category.getId());
            categoryDTO.setImg(category.getImg());
            categoryDTO.setThuTuHienThi(category.getThuTuHienThi());
            categoryDTO.setTitle(category.getTitle());
            categoryDTO.setThoiGianTao(category.getThoiGianTao());
            categoryDTO.setThoiGianCapNhat(category.getThoiGianCapNhat());
            listCateDTO.add(categoryDTO);
        }
        return listCateDTO;
	}


	@Override
	public String getTitleWithFoodId(int idFood) {
		return categoryDao.getTitleWithFoodId(idFood);
	}


	@Override
	public String getCategoryNameByTitle(String title) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryNameByTitle(title);
	}


	@Override
	public int checkExistsCategoryTitle(String title) {
		// TODO Auto-generated method stub
		return categoryDao.checkExistsCategoryTitle(title);
	}


}
