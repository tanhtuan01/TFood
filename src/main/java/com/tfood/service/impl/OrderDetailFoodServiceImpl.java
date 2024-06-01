package com.tfood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfood.dao.OrderDetailFoodDao;
import com.tfood.entity.OrderDetailFood;
import com.tfood.model.OrderDetailFoodDTO;
import com.tfood.service.OrderDetailFoodService;

@Service
public class OrderDetailFoodServiceImpl implements OrderDetailFoodService{

	@Autowired
	OrderDetailFoodDao orderDetailFoodDao;

	@Override
	public void add(OrderDetailFoodDTO orderDetailFoodDTO) {
		// TODO Auto-generated method stub
		OrderDetailFood orderDetailFood = new OrderDetailFood();
		orderDetailFood.setFood(orderDetailFoodDTO.getFood());
		orderDetailFood.setUser(orderDetailFoodDTO.getUser());
		orderDetailFood.setQuantity(orderDetailFoodDTO.getQuantity());
		orderDetailFood.setTotalprice(orderDetailFoodDTO.getTotalprice());
		orderDetailFood.setOrderCode(orderDetailFoodDTO.getOrderCode());
		orderDetailFoodDao.add(orderDetailFood);
	}

	@Override
	public List<OrderDetailFoodDTO> getAll(String orderCode) {
		List<OrderDetailFood> list = orderDetailFoodDao.getAll(orderCode);
		List<OrderDetailFoodDTO> list2 = new ArrayList<OrderDetailFoodDTO>();
		for(OrderDetailFood orderDetailFood : list) {
			OrderDetailFoodDTO orderDetailFoodDTO = new OrderDetailFoodDTO();
			orderDetailFoodDTO.setQuantity(orderDetailFood.getQuantity());
			orderDetailFoodDTO.setFoodName(orderDetailFood.getFoodName());
			orderDetailFoodDTO.setImg(orderDetailFood.getImg());
			orderDetailFoodDTO.setTotalprice(orderDetailFood.getTotalprice());
			list2.add(orderDetailFoodDTO);
		}
		return list2;
	}

//	@Override
//	public List<OrderDetailFoodDTO> getByMyOrderCode(String orderCode) {
//		List<OrderDetailFood> list = orderDetailFoodDao.getByMyOrderCode(orderCode);
//		List<OrderDetailFoodDTO> list2 = new ArrayList<OrderDetailFoodDTO>();
//		for(OrderDetailFood orderDetailFood : list) {
//			OrderDetailFoodDTO orderDetailFoodDTO = new OrderDetailFoodDTO();
//			orderDetailFoodDTO.setQuantity(orderDetailFood.getQuantity());
//			orderDetailFoodDTO.setFoodName(orderDetailFood.getFoodName());
//			orderDetailFoodDTO.setImg(orderDetailFood.getImg());
//			orderDetailFoodDTO.setTotalprice(orderDetailFood.getTotalprice());
//			list2.add(orderDetailFoodDTO);
//		}
//		return list2;
//	}
	
}
