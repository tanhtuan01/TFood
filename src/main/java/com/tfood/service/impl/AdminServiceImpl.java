package com.tfood.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfood.dao.AdminDao;
import com.tfood.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao adminDao;

	@Override
	public int checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		return adminDao.checkLogin(username, password);
	}
	
	
	
}
