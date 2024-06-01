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

import com.tfood.dao.CartDao;
import com.tfood.entity.Cart;

@Repository
public class CartDaoImpl implements CartDao{
	@Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public void addtoCart(Cart cart) {
		String sqlString= "INSERT INTO t_cart_food(userId,foodId,soLuong,gia,tongTien,thoiGianTao) VALUES (?,?,?,?,?,now())";
		System.out.println(jdbcTemplate.update(sqlString,cart.getUser(),cart.getFood(),cart.getSoLuong(),cart.getGia(),cart.getTongTien()));
	}

	@Override
	public int checkExistsFood(int user, int food) {
		String sql = "select id from t_cart_food where userId = ? and foodId = ? ";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int id = 0;
                while (resultSet.next()) {
                    id =  resultSet.getInt("id");
                }
       
                return id;
            }
        }, user,food);
	}

	@Override
	public int getQuantifyOfFood(int user, int food) {
		String sql = "select soLuong from t_cart_food where userId = ? and foodId = ? ";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int soLuong = 0;
                while (resultSet.next()) {
                	soLuong =  resultSet.getInt("soLuong");
                }
       
                return soLuong;
            }
        }, user,food);
	}

	@Override
	public boolean updateCart(Cart cart) {
		String sql_update = "UPDATE t_cart_food set userId = ?, foodId = ?, soLuong = ?, gia = ?,tongTien = ?, thoiGianCapNhat = now() WHERE userId = ? and foodId = ?";
        return (jdbcTemplate.update(sql_update, 
        		cart.getUser(),cart.getFood(),cart.getSoLuong(),cart.getGia(),cart.getTongTien(),
        		cart.getUser(),cart.getFood()) > 0);
	}

	@Override
	public int createSessionCart(int user) {
		String sql = "select sum(SoLuong) as soluong from t_cart_food WHERE userId = ? ";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int soLuong = 0;
                while (resultSet.next()) {
                	soLuong =  resultSet.getInt("soluong");
                }
       
                return soLuong;
            }
        }, user);
	}
	
	
//	@SuppressWarnings("deprecation")
//	@Override
//	public List<Cart> getAllByUser(int user) {
//		 String sql = "select * from t_cart_food WHERE userId = " + user;
//		 List<Cart> list = null;	 
//		 try {
//			list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Cart>() {
//				@Override
//				public Cart mapRow(ResultSet rs, int rowNum) throws SQLException{
//					Cart cart = new Cart();
//					cart.setId(rs.getInt(0));
//					return cart;
//				}
//			});
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		 
//		return list;
//	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<Cart> getAllByUser(int user) {
        String sql = "select tcf.id,tcf.userId,tcf.foodId,tcf.soLuong,tcf.gia,tcf.tongTien,tcf.thoiGianTao,tcf.thoiGianCapNhat,tf.img,tf.tenMon,tf.title from t_cart_food tcf INNER JOIN t_food tf on tcf.foodId = tf.id WHERE userId = " + user;
        List<Cart> listCart = null;
        try {
        	listCart = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Cart>() {
                @Override
                public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
                    // TODO Auto-generated method stub
                	Cart cart = new Cart();
                	cart.setId(rs.getInt("id"));
                	cart.setThoiGianTao(rs.getString("thoiGianTao"));
                	cart.setThoiGianCapNhat(rs.getString("thoiGianCapNhat"));
                	cart.setFood(rs.getInt("foodId"));
                	cart.setUser(rs.getInt("userId"));
                	cart.setSoLuong(rs.getInt("soLuong"));
                	cart.setGia(rs.getInt("gia"));
                	cart.setTongTien(rs.getInt("tongTien"));
                	cart.setImg(rs.getString("img"));
                	cart.setTenMon(rs.getString("tenMon"));
                	cart.setTitle(rs.getString("title"));
                    return cart;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            return listCart;
            // TODO: handle exception
        }
        return listCart;
	}
//
//
//	@Override
//	public boolean deleteCartItem(int cartid, int userid) {
//		String sql_del = "delete from tb_orders where id = ? and orders_user_id = ?";
//        return (jdbcTemplate.update(sql_del, cartid, userid) > 0);
//		
//	}
//
//
//	@Override
//	public int countCart(int id) {
//		 String sql_login = "Select count(id) as cid from tb_orders where orders_user_id = ?";
//	        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
//	            @Override
//	            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//	                int id = 0;
//	                while (resultSet.next()) {
//	                    id =  resultSet.getInt("cid");
//	                }
//	    
//	                return id;
//	            }
//	        }, id);
//	}
//
//
//	@Override
//	public int checkQuantity(int id_user, int id_food) {
//		 String sql_login = "SELECT orders_total_quantity FROM tb_orders WHERE orders_user_id = ? and orders_food_id = ?";
//	        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
//	            @Override
//	            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//	                int id = 0;
//	                while (resultSet.next()) {
//	                    id =  resultSet.getInt("orders_total_quantity");
//	                }
//	    
//	                return id;
//	            }
//	        }, id_user, id_food);
//	}
//
//
//	@Override
//	public boolean updateCart(Cart cart) {
//		  String sql_update = "UPDATE tb_orders set orders_total_quantity = ?, orders_total_price = ? WHERE orders_user_id = ? and orders_food_id = ?";
//	        return (jdbcTemplate.update(sql_update, cart.getQuantity(), cart.getPrice(), cart.getUser_id(), cart.getFood_id()) > 0);
//	
//	}
//
//
//	@Override
//	public boolean updateQuantity(Cart cart) {
//		String sql_update = "UPDATE tb_orders set orders_total_quantity = ?, orders_total_price = ? WHERE id = ?";
//        return (jdbcTemplate.update(sql_update, cart.getQuantity(), cart.getPrice(), cart.getId()) > 0);
//	}

	@Override
	public boolean lowQuantity(int cart) {
		String sql = "UPDATE t_cart_food set soLuong = soLuong - 1, tongTien = tongTien - gia where id = ?";
		return (jdbcTemplate.update(sql,cart) > 0);
	}

	@Override
	public boolean upQuantity(int cart) {
		String sql = "UPDATE t_cart_food set soLuong = soLuong + 1, tongTien = tongTien + gia where id = ?";
		return (jdbcTemplate.update(sql,cart) > 0);
	}

	@Override
	public int getQuantityInCart(int cart) {
		String sql = "select soLuong from t_cart_food where id = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int soLuong = 0;
                while (resultSet.next()) {
                	soLuong =  resultSet.getInt("soLuong");
                }
       
                return soLuong;
            }
        }, cart);
	}

	@Override
	public boolean deleteItems(int cart) {
		String sql = "delete from t_cart_food where id = ?";
		return (jdbcTemplate.update(sql,cart) > 0);
	}
	
	@Override
	public int totalQuantity(int user) {
		String sql = "SELECT sum(soLuong) as soLuong from t_cart_food GROUP by(userId) HAVING userId = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int soLuong = 0;
                while (resultSet.next()) {
                	soLuong =  resultSet.getInt("soLuong");
                }
                return soLuong;
            }
        }, user);
	}

	@Override
	public int totalPrice(int user) {
		String sql = "SELECT SUM(tongTien) as tongTien FROM t_cart_food tcf  WHERE userId = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int tongTien = 0;
                while (resultSet.next()) {
                	tongTien =  resultSet.getInt("tongTien");
                }
                return tongTien;
            }
        }, user);
	}

	@Override
	public boolean delete(int user) {
		String sql = "delete from t_cart_food where userId = ?";
		return (jdbcTemplate.update(sql,user) > 0);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Cart> getAllByOrderCode(String orderCode) {
		String sql = "SELECT  tof.foodId, tof.soLuong\r\n"
				+ "from t_order_success tos\r\n"
				+ "INNER JOIN t_orderdetail_food tof\r\n"
				+ "on tos.orderCode = tof.maDonHang\r\n"
				+ "WHERE tos.orderCode = ?";
        List<Cart> listCart = null;
        try {
        	listCart = jdbcTemplate.query(sql, new Object[]{orderCode}, new RowMapper<Cart>() {
                @Override
                public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
                    // TODO Auto-generated method stub
                	Cart cart = new Cart();
                	cart.setFood(rs.getInt("foodId"));
                	cart.setSoLuong(rs.getInt("soLuong"));
                    return cart;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            return listCart;
            // TODO: handle exception
        }
        return listCart;
	}

}
