package com.tfood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfood.dao.OrderSuccessDao;
import com.tfood.entity.OrderSuccess;
import com.tfood.model.OrderSuccessDTO;
import com.tfood.service.OrderSuccessService;

@Service
public class OrderSuccessServiceImpl implements OrderSuccessService{

	@Autowired
	OrderSuccessDao orderSuccessDao;

	@Override
	public void add(OrderSuccessDTO orderSuccessDTO) {
		// TODO Auto-generated method stub
		OrderSuccess orderSuccess = new OrderSuccess();
		orderSuccess.setUser(orderSuccessDTO.getUser());
		orderSuccess.setTotalPriceFood(orderSuccessDTO.getTotalPriceFood());
		orderSuccess.setPriceShip(orderSuccessDTO.getPriceShip());
		orderSuccess.setTotalPrice(orderSuccessDTO.getTotalPrice());
		orderSuccess.setOrderCode(orderSuccessDTO.getOrderCode());
		orderSuccess.setNote(orderSuccessDTO.getNote());
		orderSuccess.setAddress(orderSuccessDTO.getAddress());
		orderSuccess.setDistrictValue(orderSuccessDTO.getDistrictValue());
		orderSuccess.setWardValue(orderSuccessDTO.getWardValue());
		orderSuccessDao.add(orderSuccess);
	}

	@Override
	public List<OrderSuccessDTO> getAll() {
		List<OrderSuccessDTO> listoOrderSuccessDTOs = new ArrayList<OrderSuccessDTO>();
		List<OrderSuccess> listOdOrderSuccesses = orderSuccessDao.getAll();
		for(OrderSuccess orderSuccess : listOdOrderSuccesses) {
			OrderSuccessDTO orderSuccessDTO = new OrderSuccessDTO();
			orderSuccessDTO.setAddress(orderSuccess.getAddress());
			orderSuccessDTO.setDistrictName(orderSuccess.getDistrictName());
			orderSuccessDTO.setWardName(orderSuccess.getWardName());
			orderSuccessDTO.setUserName(orderSuccess.getUserName());
			orderSuccessDTO.setDate(orderSuccess.getDate());
			orderSuccessDTO.setPriceShip(orderSuccess.getPriceShip());
			orderSuccessDTO.setTotalPriceFood(orderSuccess.getTotalPriceFood());
			orderSuccessDTO.setTotalPrice(orderSuccess.getTotalPrice());
			orderSuccessDTO.setId(orderSuccess.getId());
			orderSuccessDTO.setOrderCode(orderSuccess.getOrderCode());
			orderSuccessDTO.setStatus(orderSuccess.getStatus());
			orderSuccessDTO.setPhone(orderSuccess.getPhone());
			listoOrderSuccessDTOs.add(orderSuccessDTO);
		}
		return listoOrderSuccessDTOs;
	}

	@Override
	public int checkOrderCodeExists(String orderCode) {
		// TODO Auto-generated method stub
		return orderSuccessDao.checkOrderCodeExists(orderCode);
	}

	@Override
	public boolean confirmOrder(String orderCode) {
		// TODO Auto-generated method stub
		return orderSuccessDao.confirmOrder(orderCode);
	}

	@Override
	public String getNote(String orderCode) {
		// TODO Auto-generated method stub
		return orderSuccessDao.getNote(orderCode);
	}

	@Override
	public int checkStatus(String orderCode) {
		// TODO Auto-generated method stub
		return orderSuccessDao.checkStatus(orderCode);
	}

	@Override
	public boolean cancelOrder(String orderCode) {
		// TODO Auto-generated method stub
		return orderSuccessDao.cancelOrder(orderCode);
	}

	@Override
	public int revenue() {
		// TODO Auto-generated method stub
		return orderSuccessDao.revenue();
	}

	@Override
	public int revenueToDay(int day, int month, int year) {
		// TODO Auto-generated method stub
		return orderSuccessDao.revenueToDay(day, month, year);
	}

	@Override
	public List<OrderSuccessDTO> getMyOrderSuccess(int user) {
		// TODO Auto-generated method stub
		List<OrderSuccess> list = orderSuccessDao.getMyOrderSuccess(user);
		List<OrderSuccessDTO> list2 = new ArrayList<OrderSuccessDTO>();
		for(OrderSuccess orderSuccess : list) {
			OrderSuccessDTO orderSuccessDTO = new OrderSuccessDTO();
			orderSuccessDTO.setUser(orderSuccess.getUser());
			orderSuccessDTO.setId(orderSuccess.getId());
			orderSuccessDTO.setTotalPrice(orderSuccess.getTotalPrice());
			orderSuccessDTO.setDate(orderSuccess.getDate());
			orderSuccessDTO.setStatus(orderSuccess.getStatus());
			orderSuccessDTO.setOrderCode(orderSuccess.getOrderCode());
			list2.add(orderSuccessDTO);
		}
		return list2;
	}

	@Override
	public int getPriceShip(String orderCode) {
		// TODO Auto-generated method stub
		return orderSuccessDao.getPriceShip(orderCode);
	}

	@Override
	public int getTotalPriceFood(String orderCode) {
		// TODO Auto-generated method stub
		return orderSuccessDao.getTotalPriceFood(orderCode);
	}

	@Override
	public int getTotalPrice(String orderCode) {
		// TODO Auto-generated method stub
		return orderSuccessDao.getTotalPrice(orderCode);
	}

	@Override
	public String getOrderDate(String orderCode) {
		// TODO Auto-generated method stub
		return orderSuccessDao.getOrderDate(orderCode);
	}

	@Override
	public int getStatus(String orderCode) {
		// TODO Auto-generated method stub
		return orderSuccessDao.getStatus(orderCode);
	}

	@Override
	public boolean orderSuccess(String orderCode) {
		// TODO Auto-generated method stub
		return orderSuccessDao.orderSuccess(orderCode);
	}

	@Override
	public List<OrderSuccessDTO> getAllMyOrder(int user) {
		List<OrderSuccess> list = orderSuccessDao.getAllMyOrder(user);
		List<OrderSuccessDTO> list2 = new ArrayList<OrderSuccessDTO>();
		for(OrderSuccess orderSuccess : list) {
			OrderSuccessDTO orderSuccessDTO = new OrderSuccessDTO();
			orderSuccessDTO.setUser(orderSuccess.getUser());
			orderSuccessDTO.setId(orderSuccess.getId());
			orderSuccessDTO.setTotalPrice(orderSuccess.getTotalPrice());
			orderSuccessDTO.setDate(orderSuccess.getDate());
			orderSuccessDTO.setStatus(orderSuccess.getStatus());
			orderSuccessDTO.setOrderCode(orderSuccess.getOrderCode());
			list2.add(orderSuccessDTO);
		}
		return list2;
	}
	
	@Override
	public List<OrderSuccessDTO> getMyOrderCancel(int user) {
		// TODO Auto-generated method stub
		List<OrderSuccess> list = orderSuccessDao.getMyOrderCancel(user);
		List<OrderSuccessDTO> list2 = new ArrayList<OrderSuccessDTO>();
		for(OrderSuccess orderSuccess : list) {
			OrderSuccessDTO orderSuccessDTO = new OrderSuccessDTO();
			orderSuccessDTO.setUser(orderSuccess.getUser());
			orderSuccessDTO.setId(orderSuccess.getId());
			orderSuccessDTO.setTotalPrice(orderSuccess.getTotalPrice());
			orderSuccessDTO.setDate(orderSuccess.getDate());
			orderSuccessDTO.setStatus(orderSuccess.getStatus());
			orderSuccessDTO.setOrderCode(orderSuccess.getOrderCode());
			list2.add(orderSuccessDTO);
		}
		return list2;
	}

	@Override
	public int quantityOfSuccessOrder() {
		// TODO Auto-generated method stub
		return orderSuccessDao.quantityOfSuccessOrder();
	}

	@Override
	public int quantityOfCancelOrder() {
		// TODO Auto-generated method stub
		return orderSuccessDao.quantityOfCancelOrder();
	}
	
	@Override
	public int quantityOfOrder() {
		// TODO Auto-generated method stub
		return orderSuccessDao.quantityOfOrder();
	}

	@Override
	public int quantityOfAnotherOrder() {
		// TODO Auto-generated method stub
		return orderSuccessDao.quantityOfAnotherOrder();
	}
}
