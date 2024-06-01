package com.tfood.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tfood.dao.OrderDetailDao;
import com.tfood.entity.OrderDetail;

@Repository
public class OrderDetailDaoImpl implements OrderDetailDao {
	 @Autowired
    JdbcTemplate jdbcTemplate;
	 
	@Override
	public void addToCheckOut(OrderDetail orderDetail) {
	 String sql = "INSERT INTO tb_orders_detail(tod_user_id,tod_orders_id, tod_user_name,tod_phone_number,tod_user_email,tod_address, tod_quantity, tod_price, created_at, updated_at, tod_payment) values(?,?,?,?,?,?,?,?,now(),now(),?)";
	 System.out.println(jdbcTemplate.update(sql,orderDetail.getUser_id(),orderDetail.getOrders_id(),orderDetail.getName(),orderDetail.getPhone_number(),orderDetail.getEmail(),orderDetail.getAddress(),orderDetail.getQuantity(),orderDetail.getPrice(), orderDetail.getPayment()));
			
	}
	@Override
	public int checkInOrderDetail(int id_orders) {
		String sql_login = "SELECT tod_orders_id FROM tb_orders_detail WHERE tod_payment=3 and tod_orders_id = ?";
        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int id = -1;
                while (resultSet.next()) {
                    id =  resultSet.getInt("tod_orders_id");
                }
                return id;
            }
        },id_orders);

	}
	
	
	@SuppressWarnings("deprecation")
    @Override
    public List<OrderDetail> list(int user) {
        // Kết nối đến csdl và return về list cate
        String sql = "select * from tb_orders_detail where tod_status = 1 and tod_payment=3 and tod_user_id = " +user;
        List<OrderDetail> listOrderDetails = null;
        try {
        	listOrderDetails = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<OrderDetail>() {
                @Override
                public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
                    // TODO Auto-generated method stub
                    
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setAddress(rs.getString("tod_address"));
                    orderDetail.setName(rs.getString("tod_user_name"));
                    orderDetail.setPhone_number(rs.getString("tod_phone_number"));
                    orderDetail.setOrders_id(rs.getInt("tod_orders_id"));
                    orderDetail.setQuantity(rs.getInt("tod_quantity"));
                    orderDetail.setPrice(rs.getInt("tod_price"));
                    orderDetail.setUser_id(rs.getInt("tod_user_id"));
                    return orderDetail;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            return listOrderDetails;
            // TODO: handle exception
        }
        return listOrderDetails;
    }
	@Override
	public boolean deleteItemOrderDetail(int cartid,int userid) {
		  String sql_del = "delete from tb_orders_detail where tod_orders_id = ? and tod_user_id = ? and tod_status = 1";
        return (jdbcTemplate.update(sql_del, cartid, userid) > 0);
	}
	@Override
	public int countQuantity(int user) {
		 String sql_login = "SELECT SUM(tod_quantity) as quantity FROM tb_orders_detail WHERE tod_status = 1 and tod_payment=3 AND tod_user_id = ?";
	        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
	            @Override
	            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
	                int id= 0;
	                while (resultSet.next()) {
	                	id =  resultSet.getInt("quantity");
	                }
	          
	                return id;
	            }
	        }, user);
	}
	@Override
	public int totalPrice(int user) {
		 String sql_login = "SELECT SUM(tod_price) as price FROM tb_orders_detail WHERE tod_status = 1 AND tod_user_id = ?";
	        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
	            @Override
	            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
	                int id= 0;
	                while (resultSet.next()) {
	                	id =  resultSet.getInt("price");
	                }
	          
	                return id;
	            }
	        }, user);
	}
	@Override
	public void updatePayment(OrderDetail orderDetail) {
		String sqlString = "update tb_orders_detail set tod_payment = ?,tod_address = ?, tod_code = ? where tod_user_id = ? and tod_payment = 3";
		System.out.println(jdbcTemplate.update(sqlString,orderDetail.getPayment(),orderDetail.getAddress(),orderDetail.getCode(), orderDetail.getUser_id()));
	
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<OrderDetail> getAll() {
		 String sql = "select tod.id,tfl.food_name,tod.tod_quantity,tod.tod_price,tod.created_at from tb_orders_detail tod JOIN tb_orders tos on tod.tod_orders_id = tos.id JOIN tb_foodlist tfl ON tos.orders_food_id = tfl.id where tod.tod_payment!= 3 and tod_status = 1";
	        List<OrderDetail> listOderDetails = null;
	        try {
	        	listOderDetails = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<OrderDetail>() {
	                @Override
	                public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
	                    // TODO Auto-generated method stub
	                	OrderDetail orderDetail = new OrderDetail();  
	                	orderDetail.setId(rs.getInt("id"));
	                	orderDetail.setFood_name(rs.getString("food_name"));
	                	orderDetail.setQuantity(rs.getInt("tod_quantity"));
	                	orderDetail.setPrice(rs.getInt("tod_price"));
	                	orderDetail.setCreated_at(rs.getString("created_at"));
	                    return orderDetail;
	                }
	            });

	        } catch (Exception e) {
	            e.printStackTrace();
	            return listOderDetails;
	            // TODO: handle exception
	        }
	        return listOderDetails;
	}
	
	
	@Override
	public void confirmOrder(OrderDetail orderDetail) {
		String sqlString = "update tb_orders_detail set tod_status = ? where id = ?";
		System.out.println(jdbcTemplate.update(sqlString,orderDetail.getStatus(),orderDetail.getId()));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<OrderDetail> waitForShip() {
		 String sql = "select tfl.food_cate_id,tfl.id as food_id,tfl.food_name,tod.id, tod.tod_orders_id, tod.tod_user_id, tod.tod_quantity, tod.tod_price, tod.tod_user_name, tod.tod_address, tod.tod_phone_number, tod.tod_status from tb_orders_detail tod  JOIN tb_orders tos ON tod.tod_orders_id = tos.id JOIN tb_foodlist tfl on tos.orders_food_id = tfl.id where tod.tod_status != 1";
	        List<OrderDetail> listOderDetails = null;
	        try {
	        	listOderDetails = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<OrderDetail>() {
	                @Override
	                public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
	                    // TODO Auto-generated method stub
	                	 OrderDetail orderDetail = new OrderDetail();
	                     orderDetail.setAddress(rs.getString("tod_address"));
	                     orderDetail.setName(rs.getString("tod_user_name"));
	                     orderDetail.setPhone_number(rs.getString("tod_phone_number"));
	                     orderDetail.setOrders_id(rs.getInt("tod_orders_id"));
	                     orderDetail.setQuantity(rs.getInt("tod_quantity"));
	                     orderDetail.setPrice(rs.getInt("tod_price"));
	                     orderDetail.setUser_id(rs.getInt("tod_user_id"));
	                     orderDetail.setStatus(rs.getInt("tod_status"));
	                     orderDetail.setId(rs.getInt("id"));
	                     orderDetail.setFood_name(rs.getString("food_name"));
	                     orderDetail.setFood_id(rs.getInt("food_id"));
	                     orderDetail.setFood_cate_id(rs.getInt("food_cate_id"));
	                     return orderDetail;
	                }
	            });

	        } catch (Exception e) {
	            e.printStackTrace();
	            return listOderDetails;
	            // TODO: handle exception
	        }
	        return listOderDetails;
	}
	
	
	@Override
	public int countOrderSucess() {
		 String sql_login = "SELECT COUNT(tod_status) as sl FROM tb_orders_detail where tod_status = 4";
	        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
	            @Override
	            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
	                int id= 0;
	                while (resultSet.next()) {
	                	id =  resultSet.getInt("sl");
	                }
	          
	                return id;
	            }
	        });
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<OrderDetail> orderSuccess(int id) {
		 String sql = "SELECT tfl.id,tfl.food_name,tfl.food_images,tod.tod_quantity, tod.tod_price FROM tb_orders_detail tod JOIN tb_orders tos ON tod.tod_orders_id = tos.id JOIN tb_foodlist tfl on tos.orders_food_id = tfl.id WHERE tod_status = 4 and tod_user_id =  "+id;
	        List<OrderDetail> listOderDetails = null;
	        try {
	        	listOderDetails = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<OrderDetail>() {
	                @Override
	                public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
	                    // TODO Auto-generated method stub
	                	 OrderDetail orderDetail = new OrderDetail();
	                	 
	                     orderDetail.setQuantity(rs.getInt("tod_quantity"));
	                     orderDetail.setPrice(rs.getInt("tod_price"));     
	                     orderDetail.setId(rs.getInt("id"));
	                     orderDetail.setFood_name(rs.getString("food_name"));
	                     orderDetail.setAvatar(rs.getString("food_images"));
	                     return orderDetail;
	                }
	            });

	        } catch (Exception e) {
	            e.printStackTrace();
	            return listOderDetails;
	            // TODO: handle exception
	        }
	        return listOderDetails;
	}
	@SuppressWarnings("deprecation")
	@Override
	public List<OrderDetail> waitForShipByCode() {
		 String sql = "SELECT tod_user_name, tod_address,tod_phone_number, sum(tod_quantity) as soLuong, sum(tod_price) as gia FROM tb_orders_detail WHERE tod_payment !=1 GROUP BY(tod_code)";
	        List<OrderDetail> listOderDetails = null;
	        try {
	        	listOderDetails = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<OrderDetail>() {
	                @Override
	                public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
	                    // TODO Auto-generated method stub
	                	 OrderDetail orderDetail = new OrderDetail();
	                     orderDetail.setAddress(rs.getString("tod_address"));
	                     orderDetail.setName(rs.getString("tod_user_name"));
	                     orderDetail.setPhone_number(rs.getString("tod_phone_number"));
	                     orderDetail.setQuantity(rs.getInt("soLuong"));
	                     orderDetail.setPrice(rs.getInt("gia"));
	                     orderDetail.setId(rs.getInt("id"));
	                     return orderDetail;
	                }
	            });

	        } catch (Exception e) {
	            e.printStackTrace();
	            return listOderDetails;
	            // TODO: handle exception
	        }
	        return listOderDetails;
	}
}
