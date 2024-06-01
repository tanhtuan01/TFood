package com.tfood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfood.dao.SubFoodDao;
import com.tfood.entity.SubFood;
import com.tfood.model.SubFoodDTO;
import com.tfood.service.SubFoodService;

@Service
public class SubFoodServiceImpl implements SubFoodService{

	@Autowired
	SubFoodDao subFoodDao;

	@Override
	public void addSubFood(SubFoodDTO subFoodDTO) {
		SubFood subFood = new SubFood();
		subFood.setCategory(subFoodDTO.getCategory());
		subFood.setTenMon(subFoodDTO.getTenMon());
		subFood.setGia(subFoodDTO.getGia());
		subFood.setImg(subFoodDTO.getImg());
		subFood.setMoTa(subFoodDTO.getMoTa());
		subFoodDao.addSubFood(subFood);
	}

	@Override
	public List<SubFoodDTO> getAll() {
		List<SubFoodDTO> listFoodDTO = new ArrayList<SubFoodDTO>();
      List<SubFood> listFood = subFoodDao.getAll();
      for (SubFood food : listFood) {
        SubFoodDTO foodDTO = new SubFoodDTO();
        foodDTO.setId(food.getId());
        foodDTO.setTenMon(food.getTenMon());
        foodDTO.setCategory(food.getCategory());
        foodDTO.setGia(food.getGia());
        foodDTO.setMoTa(food.getMoTa());
        foodDTO.setThoiGianTao(food.getThoiGianTao());
        foodDTO.setThoiGianCapNhat(food.getThoiGianCapNhat());
        foodDTO.setImg(food.getImg());
        listFoodDTO.add(foodDTO);
      }
      return listFoodDTO;
	}

	@Override
	public boolean deleteSubFood(int id) {
		return subFoodDao.deleteSubFood(id);
	}

	@Override
	public void updateSubFood(SubFoodDTO subFoodDTO) {
		SubFood subFood = new SubFood();
		subFood.setCategory(subFoodDTO.getCategory());
		subFood.setId(subFoodDTO.getId());
		subFood.setGia(subFoodDTO.getGia());
		subFood.setImg(subFoodDTO.getImg());
		subFood.setMoTa(subFoodDTO.getMoTa());
		subFood.setTenMon(subFoodDTO.getTenMon());
		subFoodDao.updateSubFood(subFood);
	}

	@Override
	public List<SubFoodDTO> getByName(String name) {
		List<SubFoodDTO> listFoodDTO = new ArrayList<SubFoodDTO>();
		List<SubFood> listFood = subFoodDao.getByName(name);
		for (SubFood food1 : listFood) {
			SubFoodDTO foodDTO = new SubFoodDTO();
			foodDTO.setId(food1.getId());
			foodDTO.setCategory(food1.getCategory());
			foodDTO.setImg(food1.getImg());
			foodDTO.setMoTa(food1.getMoTa());
			foodDTO.setThoiGianTao(food1.getThoiGianTao());
			foodDTO.setGia(food1.getGia());
			foodDTO.setTenMon(food1.getTenMon());
			foodDTO.setThoiGianCapNhat(food1.getThoiGianCapNhat());
			listFoodDTO.add(foodDTO);
		}
		return listFoodDTO;
	}

	@Override
	public List<SubFoodDTO> getAllByCategory(int id) {
		List<SubFoodDTO> listFoodDTO = new ArrayList<SubFoodDTO>();
		List<SubFood> listFood = subFoodDao.getAllByCategory(id);
		for (SubFood food1 : listFood) {
			SubFoodDTO foodDTO = new SubFoodDTO();
			foodDTO.setId(food1.getId());
			foodDTO.setCategory(food1.getCategory());
			foodDTO.setImg(food1.getImg());
			foodDTO.setMoTa(food1.getMoTa());
			foodDTO.setThoiGianTao(food1.getThoiGianTao());
			foodDTO.setGia(food1.getGia());
			foodDTO.setTenMon(food1.getTenMon());
			foodDTO.setThoiGianCapNhat(food1.getThoiGianCapNhat());
			listFoodDTO.add(foodDTO);
		}
		return listFoodDTO;
	}

	@Override
	public int subFoodQuantity() {
		// TODO Auto-generated method stub
		return subFoodDao.subFoodQuantity();
	}

	
	
}
