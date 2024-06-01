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

import com.tfood.dao.CartSubFoodDao;
import com.tfood.entity.CartSub;

@Repository
public class CartSubFoodDaoImpl implements CartSubFoodDao{

	@Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public void addToCartSub(CartSub cartSub) {
		String sqlString= "INSERT INTO t_cart_sub_food(userId,foodId,soLuong,gia,tongTien,thoiGianTao) VALUES (?,?,?,?,?,now())";
		System.out.println(jdbcTemplate.update(sqlString,cartSub.getUser(),cartSub.getFood(),cartSub.getSoLuong(),cartSub.getGia(),cartSub.getTongTien()));
	}

	@Override
	public int checkExistsSubFood(int user, int food) {
		String sql = "select id from t_cart_sub_food where userId = ? and foodId = ? ";
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
		String sql = "select soLuong from t_cart_sub_food where userId = ? and foodId = ? ";
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
	public boolean updateCart(CartSub cartSub) {
		String sql_update = "UPDATE t_cart_sub_food set userId = ?, foodId = ?, soLuong = ?, gia = ?,tongTien = ?, thoiGianCapNhat = now() WHERE userId = ? and foodId = ?";
        return (jdbcTemplate.update(sql_update, 
        		cartSub.getUser(),cartSub.getFood(),cartSub.getSoLuong(),cartSub.getGia(),cartSub.getTongTien(),
        		cartSub.getUser(),cartSub.getFood()) > 0);
	}

	@Override
	public int createSessionSubCart(int user) {
		String sql = "select sum(SoLuong) as soluong from t_cart_sub_food WHERE userId = ? ";
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
	
	@SuppressWarnings("deprecation")
	@Override
	public List<CartSub> getAllByUser(int user) {
		String sql = "select tcf.id,tcf.userId,tcf.foodId,tcf.soLuong,tcf.gia,tcf.tongTien,tcf.thoiGianTao,tcf.thoiGianCapNhat,tf.hinhAnh,tf.tenMon from t_cart_sub_food tcf INNER JOIN t_sub_food tf on tcf.foodId = tf.id WHERE userId = ?";
      List<CartSub> listCart = null;
      try {
      	listCart = jdbcTemplate.query(sql, new Object[]{user}, new RowMapper<CartSub>() {
              @Override
              public CartSub mapRow(ResultSet rs, int rowNum) throws SQLException {
                  // TODO Auto-generated method stub
            	  CartSub cart = new CartSub();
              	cart.setId(rs.getInt("id"));
              	cart.setThoiGianTao(rs.getString("thoiGianTao"));
              	cart.setThoiGianCapNhat(rs.getString("thoiGianCapNhat"));
              	cart.setFood(rs.getInt("foodId"));
              	cart.setUser(rs.getInt("userId"));
              	cart.setSoLuong(rs.getInt("soLuong"));
              	cart.setGia(rs.getInt("gia"));
              	cart.setTongTien(rs.getInt("tongTien"));
              	cart.setImg(rs.getString("hinhAnh"));
              	cart.setTenMon(rs.getString("tenMon"));
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
	
	@Override
	public boolean lowQuantity(int cart) {
		String sql = "UPDATE t_cart_sub_food set soLuong = soLuong - 1, tongTien = tongTien - gia where id = ?";
		return (jdbcTemplate.update(sql,cart) > 0);
	}

	@Override
	public boolean upQuantity(int cart) {
		String sql = "UPDATE t_cart_sub_food set soLuong = soLuong + 1, tongTien = tongTien + gia where id = ?";
		return (jdbcTemplate.update(sql,cart) > 0);
	}
	
	@Override
	public int getQuantityInCart(int cart) {
		String sql = "select soLuong from t_cart_sub_food where id = ?";
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
	public int totalQuantity(int user) {
		String sql = "SELECT sum(soLuong) as soLuong from t_cart_sub_food GROUP by(userId) HAVING userId = ?";
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
	public boolean deleteItems(int cart) {
		String sql = "delete from t_cart_sub_food where id = ?";
		return (jdbcTemplate.update(sql,cart) > 0);
	}
	
	@Override
	public int totalPrice(int user) {
		String sql = "SELECT SUM(tongTien) as tongTien FROM t_cart_sub_food tcf  WHERE userId = ?";
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
		String sql = "delete from t_cart_sub_food where userId = ?";
		return (jdbcTemplate.update(sql,user) > 0);
	}
	
}
