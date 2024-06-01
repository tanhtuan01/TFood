package com.tfood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tfood.dao.FoodDao;

import com.tfood.entity.Food;

import com.tfood.model.FoodDTO;
import com.tfood.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService{
	@Autowired
    FoodDao foodDao;

    @Override
    public List<FoodDTO> getAll() {
        // gọi lại getAll từ CategoryDao và chuyển thành category dto, và category dto trả
        // lại cho trình duyệt hiện thị
        List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
        List<Food> listFood = foodDao.getAll();
        for (Food food : listFood) {
          FoodDTO foodDTO = new FoodDTO();
          foodDTO.setId(food.getId());
          foodDTO.setTenMon(food.getTenMon());
          foodDTO.setCategory(food.getCategory());
          foodDTO.setDaBan(food.getDaBan());
          foodDTO.setGia(food.getGia());
          foodDTO.setGiamGia(food.getGiamGia());
          foodDTO.setGiaMoi(food.getGiaMoi());
          foodDTO.setMoTa(food.getMoTa());
          foodDTO.setThoiGianTao(food.getThoiGianTao());
          foodDTO.setThoiGianCapNhat(food.getThoiGianCapNhat());
          foodDTO.setTitle(food.getTitle());
          foodDTO.setImg(food.getImg());
          foodDTO.setTrangThai(food.getTrangThai());
          listFoodDTO.add(foodDTO);
        }
        return listFoodDTO;
    }
//    
//
//	@Override
//    public List<FoodDTO> getAllbyCategory(int id) {
//		 System.out.println("Id: "+id);
//        List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
//        List<Food> listFood = foodDao.getAllbyCategory(id);
//        for (Food food : listFood) {
//          FoodDTO foodDTO = new FoodDTO();
//          foodDTO.setId(food.getId());
//          foodDTO.setName(food.getName());
//          foodDTO.setAvatar(food.getAvatar());
//          foodDTO.setCateId(food.getCateId());
//          foodDTO.setPrice(food.getPrice());
//          foodDTO.setStatus(food.getStatus());
//          foodDTO.setSold(food.getSold());
//          foodDTO.setDiscount(food.getDiscount());
//          foodDTO.setNew_price(food.getNew_price());
//          foodDTO.setDescription(food.getDescription());
//          listFoodDTO.add(foodDTO);
//        }
//        return listFoodDTO;
//    }
//
	@Override
	public void addFood(FoodDTO foodDTO) {
		Food food = new Food();
		food.setCategory(foodDTO.getCategory());
		food.setGia(foodDTO.getGia());
		food.setGiamGia(foodDTO.getGiamGia());
		food.setGiaMoi(foodDTO.getGiaMoi());
		food.setImg(foodDTO.getImg());
		food.setMoTa(foodDTO.getMoTa());
		food.setTenMon(foodDTO.getTenMon());
		food.setTitle(foodDTO.getTitle());
		food.setTrangThai(foodDTO.getTrangThai());
		food.setDaBan(foodDTO.getDaBan());
		foodDao.addFood(food);
	}
//	
	 @Override
	    public boolean delete(int id) {
	        // TODO Auto-generated method stub
        return foodDao.delete(id);
    }
//
//
	@Override
	public void updateFood(FoodDTO foodDTO) {
		// TODO Auto-generated method stub
		Food food = new Food();
		food.setId(foodDTO.getId());
		food.setCategory(foodDTO.getCategory());
		food.setTenMon(foodDTO.getTenMon());
		food.setImg(foodDTO.getImg());
		food.setMoTa(foodDTO.getMoTa());
		food.setTitle(foodDTO.getTitle());
		food.setGia(foodDTO.getGia());
		food.setGiamGia(foodDTO.getGiamGia());
		food.setGiaMoi(foodDTO.getGiaMoi());
		food.setTrangThai(foodDTO.getTrangThai());
		foodDao.updateFood(food);
	}
//
//
//	@Override
//    public List<FoodDTO> getFoodbyId(int id) {
//	
//        List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
//        List<Food> listFood = foodDao.getFoodbyId(id);
//        for (Food food : listFood) {
//          FoodDTO foodDTO = new FoodDTO();
//          foodDTO.setId(food.getId());
//          foodDTO.setName(food.getName());
//          foodDTO.setAvatar(food.getAvatar());
//          foodDTO.setCateId(food.getCateId());
//          foodDTO.setPrice(food.getPrice());
//          foodDTO.setStatus(food.getStatus());
//          food.setDiscount(foodDTO.getDiscount());
//  			food.setNew_price(foodDTO.getNew_price());
//          foodDTO.setSold(food.getSold());
//          foodDTO.setDescription(food.getDescription());
//          listFoodDTO.add(foodDTO);
//        }
//        return listFoodDTO;
//    }
//
//
//	@Override
//	public int CheckFoodId(int id) {
//		// TODO Auto-generated method stub
//		return foodDao.CheckFoodId(id);
//	}
//
//
//	@Override
//	public int CheckCateId(int id) {
//		// TODO Auto-generated method stub
//		return foodDao.CheckCateId(id);
//	}
//
//
//	@Override
//	public int CheckFoodIdAndCateId(int id1, int id2) {
//		// TODO Auto-generated method stub
//		return foodDao.CheckFoodIdAndCateId(id1, id2);
//	}
//
//
//	@Override
//	public List<FoodDTO> getTopSold() {
//		List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
//        List<Food> listFood = foodDao.getTopSold();
//        for (Food food : listFood) {
//          FoodDTO foodDTO = new FoodDTO();
//          foodDTO.setId(food.getId());
//          foodDTO.setName(food.getName());
//          foodDTO.setAvatar(food.getAvatar());
//          foodDTO.setCateId(food.getCateId());
//          foodDTO.setPrice(food.getPrice());
//          foodDTO.setStatus(food.getStatus());
//          foodDTO.setSold(food.getSold());
//          foodDTO.setDescription(food.getDescription());
//          listFoodDTO.add(foodDTO);
//        }
//        return listFoodDTO;
//	}
//
//
	@Override
	public int getPriceFood(int id) {
		// TODO Auto-generated method stub
		return foodDao.getPriceFood(id);
	}
//
//
//	@Override
//	public List<FoodDTO> getFood9Deal(int id) {
//		 List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
//	        List<Food> listFood = foodDao.getFood9Deal(id);
//	        for (Food food : listFood) {
//	          FoodDTO foodDTO = new FoodDTO();
//	          foodDTO.setId(food.getId());
//	          foodDTO.setName(food.getName());
//	          foodDTO.setAvatar(food.getAvatar());
//	          foodDTO.setCateId(food.getCateId());
//	          foodDTO.setPrice(food.getPrice());
//	          foodDTO.setStatus(food.getStatus());
//	          foodDTO.setSold(food.getSold());
//	          foodDTO.setDiscount(food.getDiscount());
//	          foodDTO.setNew_price(food.getNew_price());
//	          foodDTO.setDescription(food.getDescription());
//	          listFoodDTO.add(foodDTO);
//	        }
//	        return listFoodDTO;
//	}
//	
//	@Override
//	public List<FoodDTO> getFood9NoDeal(int id) {
//		 List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
//	        List<Food> listFood = foodDao.getFood9NoDeal(id);
//	        for (Food food : listFood) {
//	          FoodDTO foodDTO = new FoodDTO();
//	          foodDTO.setId(food.getId());
//	          foodDTO.setName(food.getName());
//	          foodDTO.setAvatar(food.getAvatar());
//	          foodDTO.setCateId(food.getCateId());
//	          foodDTO.setPrice(food.getPrice());
//	          foodDTO.setStatus(food.getStatus());
//	          foodDTO.setSold(food.getSold());
//	          foodDTO.setDiscount(food.getDiscount());
//	          foodDTO.setNew_price(food.getNew_price());
//	          foodDTO.setDescription(food.getDescription());
//	          listFoodDTO.add(foodDTO);
//	        }
//	        return listFoodDTO;
//	}
//
//
//	@Override
//	public List<FoodDTO> getFoodDealByCategory(int id) {
//		List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
//        List<Food> listFood = foodDao.getFoodDealByCategory(id);
//        for (Food food : listFood) {
//          FoodDTO foodDTO = new FoodDTO();
//          foodDTO.setId(food.getId());
//          foodDTO.setName(food.getName());
//          foodDTO.setAvatar(food.getAvatar());
//          foodDTO.setCateId(food.getCateId());
//          foodDTO.setPrice(food.getPrice());
//          foodDTO.setStatus(food.getStatus());
//          foodDTO.setSold(food.getSold());
//          foodDTO.setDiscount(food.getDiscount());
//          foodDTO.setNew_price(food.getNew_price());
//          foodDTO.setDescription(food.getDescription());
//          listFoodDTO.add(foodDTO);
//        }
//        return listFoodDTO;
//	}
//
//	@Override
//	public List<FoodDTO> getFoodNoDealByCategory(int id) {
//		List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
//        List<Food> listFood = foodDao.getFoodNoDealByCategory(id);
//        for (Food food : listFood) {
//          FoodDTO foodDTO = new FoodDTO();
//          foodDTO.setId(food.getId());
//          foodDTO.setName(food.getName());
//          foodDTO.setAvatar(food.getAvatar());
//          foodDTO.setCateId(food.getCateId());
//          foodDTO.setPrice(food.getPrice());
//          foodDTO.setStatus(food.getStatus());
//          foodDTO.setSold(food.getSold());
//          foodDTO.setDiscount(food.getDiscount());
//          foodDTO.setNew_price(food.getNew_price());
//          foodDTO.setDescription(food.getDescription());
//          listFoodDTO.add(foodDTO);
//        }
//        return listFoodDTO;
//	}
//
//
//	@Override
//	public int checkFoodInOrder(int id_food, int id_user) {
//		// TODO Auto-generated method stub
//		return foodDao.checkFoodInOrder(id_food, id_user);
//	}
//
//
	@Override
	public List<FoodDTO> getByName(String food) {
		List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
        List<Food> listFood = foodDao.getByName(food);
        for (Food food1 : listFood) {
          FoodDTO foodDTO = new FoodDTO();
          foodDTO.setId(food1.getId());
          foodDTO.setCategory(food1.getCategory());
          foodDTO.setImg(food1.getImg());
          foodDTO.setMoTa(food1.getMoTa());
          foodDTO.setThoiGianTao(food1.getThoiGianTao());
          foodDTO.setTitle(food1.getTitle());
          foodDTO.setGia(food1.getGia());
          foodDTO.setGiamGia(food1.getGiamGia());
          foodDTO.setGiaMoi(food1.getGiaMoi());
          foodDTO.setTenMon(food1.getTenMon());
          listFoodDTO.add(foodDTO);
        }
        return listFoodDTO;
	}
//
//
//	@Override
//	public String getNameFood(int id) {
//		// TODO Auto-generated method stub
//		return foodDao.getNameFood(id);
//	}
//
//
//	@Override
//	public int getNewPrice(int id) {
//		// TODO Auto-generated method stub
//		return foodDao.getNewPrice(id);
//	}
//
//
//	@Override
//	public String getAvatar(int id) {
//		// TODO Auto-generated method stub
//		return foodDao.getAvatar(id);
//	}
//
//
//	@Override
//	public String getDescription(int id) {
//		// TODO Auto-generated method stub
//		return foodDao.getDescription(id);
//	}
//
//
//	@Override
//	public List<FoodDTO> getTopSoldbyCate(int id) {
//		List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
//        List<Food> listFood = foodDao.getTopSoldbyCate(id);
//        for (Food food : listFood) {
//          FoodDTO foodDTO = new FoodDTO();
//          foodDTO.setId(food.getId());
//          foodDTO.setName(food.getName());
//          foodDTO.setAvatar(food.getAvatar());
//          foodDTO.setCateId(food.getCateId());
//          foodDTO.setPrice(food.getPrice());
//          foodDTO.setStatus(food.getStatus());
//          foodDTO.setSold(food.getSold());
//          foodDTO.setDescription(food.getDescription());
//          listFoodDTO.add(foodDTO);
//        }
//        return listFoodDTO;
//	}
//
//
//	@Override
//	public void updateSold(FoodDTO foodDTO) {
//		Food food = new Food();
//		food.setSold(foodDTO.getSold());
//		food.setId(foodDTO.getId());
//		foodDao.updateSold(food);
//	}
	@Override
	public List<FoodDTO> getDealFood() {
		List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
        List<Food> listFood = foodDao.getDealFood();
        for (Food food : listFood) {
          FoodDTO foodDTO = new FoodDTO();
          foodDTO.setId(food.getId());
          foodDTO.setTenMon(food.getTenMon());
          foodDTO.setCategory(food.getCategory());
          foodDTO.setDaBan(food.getDaBan());
          foodDTO.setGia(food.getGia());
          foodDTO.setGiamGia(food.getGiamGia());
          foodDTO.setGiaMoi(food.getGiaMoi());
          foodDTO.setMoTa(food.getMoTa());
          foodDTO.setThoiGianTao(food.getThoiGianTao());
          foodDTO.setThoiGianCapNhat(food.getThoiGianCapNhat());
          foodDTO.setTitle(food.getTitle());
          foodDTO.setImg(food.getImg());
          foodDTO.setTrangThai(food.getTrangThai());
          listFoodDTO.add(foodDTO);
        }
        return listFoodDTO;
	}
	@Override
	public List<FoodDTO> getFoodByTitleOfCategory(String title) {
		List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
        List<Food> listFood = foodDao.getFoodByTitleOfCategory(title);
        for (Food food : listFood) {
          FoodDTO foodDTO = new FoodDTO();
          foodDTO.setId(food.getId());
          foodDTO.setTenMon(food.getTenMon());
          foodDTO.setCategory(food.getCategory());
          foodDTO.setDaBan(food.getDaBan());
          foodDTO.setGia(food.getGia());
          foodDTO.setGiamGia(food.getGiamGia());
          foodDTO.setGiaMoi(food.getGiaMoi());
          foodDTO.setMoTa(food.getMoTa());
          foodDTO.setThoiGianTao(food.getThoiGianTao());
          foodDTO.setThoiGianCapNhat(food.getThoiGianCapNhat());
          foodDTO.setTitle(food.getTitle());
          foodDTO.setImg(food.getImg());
          foodDTO.setTrangThai(food.getTrangThai());
          listFoodDTO.add(foodDTO);
        }
        return listFoodDTO;
	}
	@Override
	public String getTitle(int id) {
		return foodDao.getTitle(id);
	}
	@Override
	public int checkDiscount(int id) {
		return foodDao.checkDiscount(id);
	}
	@Override
	public List<FoodDTO> getFoodById(int id) {
		List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
        List<Food> listFood = foodDao.getFoodById(id);
        for (Food food : listFood) {
          FoodDTO foodDTO = new FoodDTO();
          foodDTO.setId(food.getId());
          foodDTO.setTenMon(food.getTenMon());
          foodDTO.setCategory(food.getCategory());
          foodDTO.setDaBan(food.getDaBan());
          foodDTO.setGia(food.getGia());
          foodDTO.setGiamGia(food.getGiamGia());
          foodDTO.setGiaMoi(food.getGiaMoi());
          foodDTO.setMoTa(food.getMoTa());
          foodDTO.setThoiGianTao(food.getThoiGianTao());
          foodDTO.setThoiGianCapNhat(food.getThoiGianCapNhat());
          foodDTO.setTitle(food.getTitle());
          foodDTO.setImg(food.getImg());
          foodDTO.setTrangThai(food.getTrangThai());
          listFoodDTO.add(foodDTO);
        }
        return listFoodDTO;
	}
	@Override
	public int getCategory(int id) {
		// TODO Auto-generated method stub
		return foodDao.getCategory(id);
	}
	@Override
	public int checkFoodExists(int id) {
		// TODO Auto-generated method stub
		return foodDao.checkFoodExists(id);
	}
	@Override
	public void updateSold(int food, int quantity) {
		// TODO Auto-generated method stub
		foodDao.updateSold(food, quantity);
	}
	@Override
	public List<FoodDTO> getTop5Sold() {
		List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
        List<Food> listFood = foodDao.getTop5Sold();
        for (Food food : listFood) {
          FoodDTO foodDTO = new FoodDTO();
          foodDTO.setId(food.getId());
          foodDTO.setTenMon(food.getTenMon());
          foodDTO.setCategory(food.getCategory());
          foodDTO.setDaBan(food.getDaBan());
          foodDTO.setGia(food.getGia());
          foodDTO.setGiamGia(food.getGiamGia());
          foodDTO.setGiaMoi(food.getGiaMoi());
          foodDTO.setMoTa(food.getMoTa());
          foodDTO.setThoiGianTao(food.getThoiGianTao());
          foodDTO.setThoiGianCapNhat(food.getThoiGianCapNhat());
          foodDTO.setTitle(food.getTitle());
          foodDTO.setImg(food.getImg());
          foodDTO.setTrangThai(food.getTrangThai());
          listFoodDTO.add(foodDTO);
        }
        return listFoodDTO;
	}
	@Override
	public List<FoodDTO> getAnotherFoodByCategory(int category, int food) {
		List<Food> list = foodDao.getAnotherFoodByCategory(category, food);
		List<FoodDTO> list2 = new ArrayList<FoodDTO>();
		for(Food f: list) {
			FoodDTO foodDTO = new FoodDTO();
	          foodDTO.setId(f.getId());
	          foodDTO.setTenMon(f.getTenMon());
	          foodDTO.setCategory(f.getCategory());
	          foodDTO.setDaBan(f.getDaBan());
	          foodDTO.setGia(f.getGia());
	          foodDTO.setGiamGia(f.getGiamGia());
	          foodDTO.setGiaMoi(f.getGiaMoi());
	          foodDTO.setMoTa(f.getMoTa());
	          foodDTO.setThoiGianTao(f.getThoiGianTao());
	          foodDTO.setThoiGianCapNhat(f.getThoiGianCapNhat());
	          foodDTO.setTitle(f.getTitle());
	          foodDTO.setImg(f.getImg());
	          foodDTO.setTrangThai(f.getTrangThai());
	          list2.add(foodDTO);
		}
		return list2;
	}
	@Override
	public List<FoodDTO> searchByName(String name) {
		List<Food> list = foodDao.searchByName(name);
		List<FoodDTO> list2 = new ArrayList<FoodDTO>();
		for(Food food : list) {
			FoodDTO foodDTO = new FoodDTO();
			foodDTO.setId(food.getId());
			foodDTO.setCategory(food.getCategory());
			foodDTO.setTenMon(food.getTenMon());
			foodDTO.setGia(food.getGia());
			foodDTO.setGiamGia(food.getGiamGia());
			foodDTO.setGiaMoi(food.getGiaMoi());
			foodDTO.setTitle(food.getTitle());
			foodDTO.setImg(food.getImg());
			foodDTO.setThoiGianTao(food.getThoiGianTao());
			foodDTO.setThoiGianCapNhat(food.getThoiGianCapNhat());
			foodDTO.setMoTa(food.getMoTa());
			foodDTO.setDaBan(food.getDaBan());
			foodDTO.setTrangThai(food.getTrangThai());
			list2.add(foodDTO);
		}
		return list2;
	}
	@Override
	public int foodQuantity() {
		// TODO Auto-generated method stub
		return foodDao.foodQuantity();
	}
	@Override
	public void updateLowSold(int food, int quantity) {
		// TODO Auto-generated method stub
		foodDao.updateLowSold(food, quantity);
	}

	@Override
    public List<FoodDTO> getAllByCategory(int id) {
        // gọi lại getAll từ CategoryDao và chuyển thành category dto, và category dto trả
        // lại cho trình duyệt hiện thị
        List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
        List<Food> listFood = foodDao.getAllByCategory(id);
        for (Food food : listFood) {
          FoodDTO foodDTO = new FoodDTO();
          foodDTO.setId(food.getId());
          foodDTO.setTenMon(food.getTenMon());
          foodDTO.setCategory(food.getCategory());
          foodDTO.setDaBan(food.getDaBan());
          foodDTO.setGia(food.getGia());
          foodDTO.setGiamGia(food.getGiamGia());
          foodDTO.setGiaMoi(food.getGiaMoi());
          foodDTO.setMoTa(food.getMoTa());
          foodDTO.setThoiGianTao(food.getThoiGianTao());
          foodDTO.setThoiGianCapNhat(food.getThoiGianCapNhat());
          foodDTO.setTitle(food.getTitle());
          foodDTO.setImg(food.getImg());
          foodDTO.setTrangThai(food.getTrangThai());
          listFoodDTO.add(foodDTO);
        }
        return listFoodDTO;
    }
	
}
