package com.tfood.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tfood.dao.OrderDetailSubFoodDao;
import com.tfood.entity.OrderDetailFood;
import com.tfood.entity.OrderDetailSubFood;

@Repository
public class OrderDetailSubFoodDaoImpl implements OrderDetailSubFoodDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void add(OrderDetailSubFood orderDetailSubFood) {
		String sql = "insert into t_orderdetail_sub_food(userId,foodId,soLuong,tongTien,thoiGianTao,maDonHang) VALUES (?,?,?,?,now(),?)";
		jdbcTemplate.update(sql,orderDetailSubFood.getUser(),orderDetailSubFood.getFood(),orderDetailSubFood.getQuantity(),orderDetailSubFood.getTotalprice(),orderDetailSubFood.getOrderCode());
	}

	@Override
	public List<OrderDetailSubFood> getAll(String orderCode) {
		String sql = "select tf.tenMon,tof.soLuong,tf.hinhAnh,tof.tongTien from t_orderdetail_sub_food tof\r\n"
				+ "inner join t_sub_food tf\r\n"
				+ "on tof.foodId = tf.id\r\n"
				+ "where maDonHang = '" + orderCode +"'";		@SuppressWarnings("deprecation")
		List<OrderDetailSubFood> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<OrderDetailSubFood>() {
			@Override
			public OrderDetailSubFood mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderDetailSubFood orderDetailFood = new OrderDetailSubFood();
				orderDetailFood.setQuantity(rs.getInt("soLuong"));
				orderDetailFood.setFoodName(rs.getString("tenMon"));
				orderDetailFood.setImg(rs.getString("hinhAnh"));
				orderDetailFood.setTotalprice(rs.getInt("tongTien"));
				return orderDetailFood;
			}});
		
		return list;
	}

//	@Override
//	public List<OrderDetailSubFood> getByMyOrderCode(String orderCode) {
//		String sql = "SELECT tof.soLuong,tf.tenMon, tof.tongTien, tf.hinhAnh\r\n"
//				+ "FROM t_orderdetail_sub_food tof \r\n"
//				+ "INNER JOIN t_sub_food tf\r\n"
//				+ "on tof.foodId = tf.id\r\n"
//				+ "WHERE tof.maDonHang = '"+orderCode+"'";		
//		@SuppressWarnings("deprecation")
//		List<OrderDetailSubFood> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<OrderDetailSubFood>() {
//			@Override
//			public OrderDetailSubFood mapRow(ResultSet rs, int rowNum) throws SQLException {
//				OrderDetailSubFood orderDetailFood = new OrderDetailSubFood();
//				orderDetailFood.setQuantity(rs.getInt("soLuong"));
//				orderDetailFood.setFoodName(rs.getString("tenMon"));
//				orderDetailFood.setImg(rs.getString("hinhAnh"));
//				orderDetailFood.setTotalprice(rs.getInt("tongTien"));
//				return orderDetailFood;
//			}});
//		
//		return list;
//	}
	
	
	
}
