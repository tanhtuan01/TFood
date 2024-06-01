package com.tfood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfood.dao.OrderDetailDao;
import com.tfood.entity.OrderDetail;
import com.tfood.model.OrderDetailDTO;
import com.tfood.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	
	@Autowired
	OrderDetailDao orderDetailDao;
	
	@Override
	public void addToCheckOut(OrderDetailDTO orderDetailDTO) {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrders_id(orderDetailDTO.getOrders_id());
		orderDetail.setAddress(orderDetailDTO.getAddress());
		orderDetail.setName(orderDetailDTO.getName());
		orderDetail.setPhone_number(orderDetailDTO.getPhone_number());
		orderDetail.setEmail(orderDetailDTO.getEmail());
		orderDetail.setQuantity(orderDetailDTO.getQuantity());
		orderDetail.setPrice(orderDetailDTO.getPrice());
		orderDetail.setUser_id(orderDetailDTO.getUser_id());
		orderDetail.setPayment(orderDetailDTO.getPayment());
		orderDetailDao.addToCheckOut(orderDetail);
		
	}

	@Override
	public int checkInOrderDetail(int id_orders) {
		// TODO Auto-generated method stub
		return orderDetailDao.checkInOrderDetail(id_orders);
	}

	@Override
	public List<OrderDetailDTO> list(int user) {
		  List<OrderDetailDTO> listCateDTO = new ArrayList<OrderDetailDTO>();
	        List<OrderDetail> listCategory = orderDetailDao.list(user);
	        for (OrderDetail category : listCategory) {
	            OrderDetailDTO categoryDTO = new OrderDetailDTO();
	            categoryDTO.setName(category.getName());
	            categoryDTO.setAddress(category.getAddress());
	            categoryDTO.setUser_id(category.getUser_id());
	            categoryDTO.setQuantity(category.getQuantity());
	            categoryDTO.setPrice(category.getPrice());
	            categoryDTO.setPhone_number(category.getPhone_number());
	            categoryDTO.setOrders_id(category.getOrders_id());
	            listCateDTO.add(categoryDTO);
	        }
	        return listCateDTO;
	}

	@Override
	public boolean deleteItemOrderDetail(int cartid, int userid) {
		// TODO Auto-generated method stub
		return orderDetailDao.deleteItemOrderDetail(cartid, userid);
	}

	@Override
	public int countQuantity(int user) {
		// TODO Auto-generated method stub
		return orderDetailDao.countQuantity(user);
	}

	@Override
	public int totalPrice(int user) {
		// TODO Auto-generated method stub
		return orderDetailDao.totalPrice(user);
	}

	@Override
	public void updatePayment(OrderDetailDTO orderDetailDTO) {
		// TODO Auto-generated method stub
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setUser_id(orderDetailDTO.getUser_id());
		orderDetail.setPayment(orderDetailDTO.getPayment());
		orderDetail.setAddress(orderDetailDTO.getAddress());
		orderDetail.setCode(orderDetailDTO.getCode());
		orderDetailDao.updatePayment(orderDetail);
		
	}

	@Override
	public List<OrderDetailDTO> getAll() {

		
		List<OrderDetailDTO> listOrderDetailDTOs = new ArrayList<OrderDetailDTO>();
		List<OrderDetail> listOderDetails = orderDetailDao.getAll();
		for(OrderDetail orderDetail : listOderDetails) {
			OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
		
			orderDetailDTO.setId(orderDetail.getId());
			orderDetailDTO.setFood_name(orderDetail.getFood_name());
			orderDetailDTO.setQuantity(orderDetail.getQuantity());
			orderDetailDTO.setPrice(orderDetail.getPrice());
			orderDetailDTO.setCreated_at(orderDetail.getCreated_at());
			listOrderDetailDTOs.add(orderDetailDTO);
		}
		
		return listOrderDetailDTOs;
	}

	@Override
	public void confirmOrder(OrderDetailDTO orderDetailDTO) {
		// TODO Auto-generated method stub
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setId(orderDetailDTO.getId());
		orderDetail.setStatus(orderDetailDTO.getStatus());
		orderDetailDao.confirmOrder(orderDetail);
	}

	@Override
	public List<OrderDetailDTO> waitForShip() {
		 List<OrderDetailDTO> listCateDTO = new ArrayList<OrderDetailDTO>();
	        List<OrderDetail> listCategory = orderDetailDao.waitForShip();
	        for (OrderDetail category : listCategory) {
	            OrderDetailDTO categoryDTO = new OrderDetailDTO();
	            categoryDTO.setName(category.getName());
	            categoryDTO.setAddress(category.getAddress());
	            categoryDTO.setUser_id(category.getUser_id());
	            categoryDTO.setQuantity(category.getQuantity());
	            categoryDTO.setPrice(category.getPrice());
	            categoryDTO.setPhone_number(category.getPhone_number());
	            categoryDTO.setOrders_id(category.getOrders_id());
	            categoryDTO.setStatus(category.getStatus());
	            categoryDTO.setId(category.getId());
	            categoryDTO.setFood_name(category.getFood_name());
	            categoryDTO.setFood_id(category.getFood_id());
	            categoryDTO.setFood_cate_id(category.getFood_cate_id());
	            listCateDTO.add(categoryDTO);
	        }
	        return listCateDTO;
	}

	@Override
	public int countOrderSucess() {
		// TODO Auto-generated method stub
		return orderDetailDao.countOrderSucess();
	}

	@Override
	public List<OrderDetailDTO> orderSuccess(int id) {
		List<OrderDetailDTO> listOrderDetailDTOs = new ArrayList<OrderDetailDTO>();
		List<OrderDetail> listOderDetails = orderDetailDao.orderSuccess(id);
		for(OrderDetail orderDetail : listOderDetails) {
			OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
		
			orderDetailDTO.setId(orderDetail.getId());
			orderDetailDTO.setFood_name(orderDetail.getFood_name());
			orderDetailDTO.setQuantity(orderDetail.getQuantity());
			orderDetailDTO.setPrice(orderDetail.getPrice());
			orderDetailDTO.setAvatar(orderDetail.getAvatar());
			listOrderDetailDTOs.add(orderDetailDTO);
		}
		
		return listOrderDetailDTOs;
	}

	@Override
	public List<OrderDetailDTO> waitForShipByCode() {
		 List<OrderDetailDTO> listCateDTO = new ArrayList<OrderDetailDTO>();
	        List<OrderDetail> listCategory = orderDetailDao.waitForShipByCode();
	        for (OrderDetail category : listCategory) {
	            OrderDetailDTO categoryDTO = new OrderDetailDTO();
	            categoryDTO.setName(category.getName());
	            categoryDTO.setAddress(category.getAddress());
	            categoryDTO.setQuantity(category.getQuantity());
	            categoryDTO.setPrice(category.getPrice());
	            categoryDTO.setPhone_number(category.getPhone_number());
	            categoryDTO.setId(category.getId());;
	            listCateDTO.add(categoryDTO);
	        }
	        return listCateDTO;
	}
	
	
	
}
