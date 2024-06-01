package com.tfood.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.tfood.dao.AddressDao;

@Repository
public class AddressDaoImpl implements AddressDao{

	@Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public double getDistance(String districtValue, String wardValue) {
		String sql = "select distance from t_ward where districtValue = ? and wardValue = ? ";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Double>() {
            @Override
            public Double extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                double distance = 0;
                while (resultSet.next()) {
                	distance =  resultSet.getInt("distance");
                }
       
                return distance;
            }
        }, districtValue,wardValue);
	}

	@Override
	public String getDistrictName(String districtValue) {
		String sql = "select districtName from t_district WHERE districtValue = ? ";
        return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                String distance = "";
                while (resultSet.next()) {
                	distance =  resultSet.getString("districtName");
                }
       
                return distance;
            }
        }, districtValue);
	}

	@Override
	public String getWardName(String districtValue, String wardValue) {
		String sql = "select wardName from t_ward WHERE  districtValue = ? and wardValue = ? ";
        return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                String wardName = "";
                while (resultSet.next()) {
                	wardName =  resultSet.getString("wardName");
                }
       
                return wardName;
            }
        },districtValue, wardValue);
	}

	@Override
	public String getDistrictValue(String orderCode) {
		String sql = "SELECT districtValue FROM t_order_success WHERE orderCode =  ? ";
        return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                String districtValue = "";
                while (resultSet.next()) {
                	districtValue =  resultSet.getString("districtValue");
                }
       
                return districtValue;
            }
        },orderCode);
	}

	@Override
	public String getWardValue(String orderCode) {
		String sql = "SELECT wardValue FROM t_order_success WHERE orderCode =  ? ";
        return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                String wardValue = "";
                while (resultSet.next()) {
                	wardValue =  resultSet.getString("wardValue");
                }
       
                return wardValue;
            }
        },orderCode);
	}

	@Override
	public String getAddress(String orderCode) {
		String sql = "SELECT address FROM t_order_success WHERE orderCode =  ? ";
        return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                String address = "";
                while (resultSet.next()) {
                	address =  resultSet.getString("address");
                }
       
                return address;
            }
        },orderCode);
	}
	
	
	
}
