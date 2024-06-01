package com.tfood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfood.dao.OrderDetailSubFoodDao;
import com.tfood.entity.OrderDetailSubFood;
import com.tfood.model.OrderDetailSubFoodDTO;
import com.tfood.service.OrderDetailSubFoodService;

@Service
public class OrderDetailSubFoodServiceImpl implements OrderDetailSubFoodService{

	@Autowired
	OrderDetailSubFoodDao orderDetailSubFoodDao;

	@Override
	public void add(OrderDetailSubFoodDTO orderDetailSubFoodDTO) {
		// TODO Auto-generated method stub
		OrderDetailSubFood orderDetailSubFood = new OrderDetailSubFood();
		orderDetailSubFood.setFood(orderDetailSubFoodDTO.getFood());
		orderDetailSubFood.setUser(orderDetailSubFoodDTO.getUser());
		orderDetailSubFood.setQuantity(orderDetailSubFoodDTO.getQuantity());
		orderDetailSubFood.setTotalprice(orderDetailSubFoodDTO.getTotalprice());
		orderDetailSubFood.setOrderCode(orderDetailSubFoodDTO.getOrderCode());
		orderDetailSubFoodDao.add(orderDetailSubFood);
	}

	@Override
	public List<OrderDetailSubFoodDTO> getAll(String orderCode) {
		List<OrderDetailSubFood> list = orderDetailSubFoodDao.getAll(orderCode);
		List<OrderDetailSubFoodDTO> list2 = new ArrayList<OrderDetailSubFoodDTO>();
		for(OrderDetailSubFood orderDetailFood : list) {
			OrderDetailSubFoodDTO orderDetailFoodDTO = new OrderDetailSubFoodDTO();
			orderDetailFoodDTO.setQuantity(orderDetailFood.getQuantity());
			orderDetailFoodDTO.setFoodName(orderDetailFood.getFoodName());
			orderDetailFoodDTO.setImg(orderDetailFood.getImg());
			orderDetailFoodDTO.setTotalprice(orderDetailFood.getTotalprice());
			list2.add(orderDetailFoodDTO);
		}
		return list2;
	}

//	@Override
//	public List<OrderDetailSubFoodDTO> getByMyOrderCode(String orderCode) {
//		List<OrderDetailSubFood> list = orderDetailSubFoodDao.getByMyOrderCode(orderCode);
//		List<OrderDetailSubFoodDTO> list2 = new ArrayList<OrderDetailSubFoodDTO>();
//		for(OrderDetailSubFood orderDetailFood : list) {
//			OrderDetailSubFoodDTO orderDetailFoodDTO = new OrderDetailSubFoodDTO();
//			orderDetailFoodDTO.setQuantity(orderDetailFood.getQuantity());
//			orderDetailFoodDTO.setFoodName(orderDetailFood.getFoodName());
//			orderDetailFoodDTO.setImg(orderDetailFood.getImg());
//			orderDetailFoodDTO.setTotalprice(orderDetailFood.getTotalprice());
//			list2.add(orderDetailFoodDTO);
//		}
//		return list2;
//	}
	
}
