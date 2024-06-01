package com.tfood.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.mysql.cj.Query;
import com.tfood.dao.StatisticalDao;
import com.tfood.entity.Statistical;


@Repository
public class StatisticalDaoImpl implements StatisticalDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	
	
}
