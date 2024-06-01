package com.tfood.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tfood.dao.OrderDetailFoodDao;
import com.tfood.entity.OrderDetailFood;

@Repository
public class OrderDetailFoodDaoImpl implements OrderDetailFoodDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void add(OrderDetailFood orderDetailFood) {
		String sql = "insert into t_orderdetail_food(userId,foodId,soLuong,tongTien,thoiGianTao,maDonHang) VALUES (?,?,?,?,now(),?)";
		jdbcTemplate.update(sql,orderDetailFood.getUser(),orderDetailFood.getFood(),orderDetailFood.getQuantity(),orderDetailFood.getTotalprice(),orderDetailFood.getOrderCode());
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<OrderDetailFood> getAll(String orderCode) {
		String sql = "select tf.tenMon,tof.soLuong,tf.img,tof.tongTien from t_orderdetail_food tof\r\n"
				+ "inner join t_food tf\r\n"
				+ "on tof.foodId = tf.id\r\n"
				+ "where maDonHang = '" + orderCode +"'";
		@SuppressWarnings("deprecation")
		List<OrderDetailFood> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<OrderDetailFood>() {
			@Override
			public OrderDetailFood mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderDetailFood orderDetailFood = new OrderDetailFood();
				orderDetailFood.setQuantity(rs.getInt("soLuong"));
				orderDetailFood.setFoodName(rs.getString("tenMon"));
				orderDetailFood.setImg(rs.getString("img"));
				orderDetailFood.setTotalprice(rs.getInt("tongTien"));
				return orderDetailFood;
			}});
		
		return list;
		
	}

//	@Override
//	public List<OrderDetailFood> getByMyOrderCode(String orderCode) {
//		String sql = "SELECT tof.soLuong,tf.tenMon, tof.tongTien, tf.img\r\n"
//				+ "FROM t_orderdetail_food tof \r\n"
//				+ "INNER JOIN t_food tf\r\n"
//				+ "on tof.foodId = tf.id\r\n"
//				+ "WHERE tof.maDonHang = '"+orderCode +"'";
//		@SuppressWarnings("deprecation")
//		List<OrderDetailFood> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<OrderDetailFood>() {
//			@Override
//			public OrderDetailFood mapRow(ResultSet rs, int rowNum) throws SQLException {
//				OrderDetailFood orderDetailFood = new OrderDetailFood();
//				orderDetailFood.setQuantity(rs.getInt("soLuong"));
//				orderDetailFood.setFoodName(rs.getString("tenMon"));
//				orderDetailFood.setImg(rs.getString("img"));
//				orderDetailFood.setTotalprice(rs.getInt("tongTien"));
//				return orderDetailFood;
//			}});
//		
//		return list;
//	}
	
	
}
