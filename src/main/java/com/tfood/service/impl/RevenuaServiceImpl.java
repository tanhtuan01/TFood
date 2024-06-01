package com.tfood.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfood.dao.RevenuaDao;
import com.tfood.entity.Revenua;
import com.tfood.model.RevenuaDTO;
import com.tfood.service.RevenuaService;

@Service
public class RevenuaServiceImpl implements RevenuaService{
@Autowired
RevenuaDao revenuaDao;

	@Override
	public void addPrice(RevenuaDTO revenuaDTO) {
		// TODO Auto-generated method stub
		Revenua revenua = new Revenua();
		revenua.setOrder_detail_id(revenuaDTO.getOrder_detail_id());
		revenua.setPrice(revenuaDTO.getPrice());
		revenuaDao.addPrice(revenua);
	}

	@Override
	public int price() {
		// TODO Auto-generated method stub
		return revenuaDao.price();
	}


}
