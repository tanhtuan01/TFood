package com.tfood.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfood.dao.StatisticalDao;
import com.tfood.service.StatisticalService;

@Service
public class StatisticalServiceImpl implements StatisticalService{

	@Autowired
	StatisticalDao statisticalDao;
	
}
