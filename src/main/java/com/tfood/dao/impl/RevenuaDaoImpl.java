package com.tfood.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.tfood.dao.RevenuaDao;
import com.tfood.entity.Revenua;

@Repository
public class RevenuaDaoImpl implements RevenuaDao {
	@Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public void addPrice(Revenua revenua) {
		// TODO Auto-generated method stub
		 String sql = "insert into tb_revenue(id_orders_detail, price) values(?, ?)";
        System.out.println(jdbcTemplate.update(sql,revenua.getOrder_detail_id(),revenua.getPrice()));
	}

	@Override
	public int price() {
		 String sql_login = "SELECT sum(price) as price FROM tb_revenue";
	        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
	            @Override
	            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
	                int id= 0;
	                while (resultSet.next()) {
	                	id =  resultSet.getInt("price");
	                }
	                return id;
	            }
	        });
	}
	 
}
