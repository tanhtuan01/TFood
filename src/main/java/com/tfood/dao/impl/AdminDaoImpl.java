package com.tfood.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.tfood.dao.AdminDao;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int checkLogin(String username, String password) {
		String sql_login = "Select id from t_admin where username = ? and passwords = ?";
        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int id = -1;
                while (resultSet.next()) {
                    id =  resultSet.getInt("id");
                }
                return id;
            }
        }, username, password);
	}
	
}
