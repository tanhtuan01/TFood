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

import com.tfood.dao.SubFoodDao;
import com.tfood.entity.SubFood;

@Repository
public class SubFoodDaoImpl implements SubFoodDao{

	@Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public void addSubFood(SubFood subFood) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO t_sub_food(category, tenMon,gia,hinhAnh,moTa,thoiGianTao) VALUES (?,?,?,?,?,now())";
	     System.out.println(jdbcTemplate.update(sql,
	    		 subFood.getCategory(), subFood.getTenMon(),subFood.getGia(),subFood.getImg(),subFood.getMoTa()));
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<SubFood> getAll() {
	 String sql = "select * from t_sub_food order by id desc";
	    List<SubFood> listFood = null;
	    try {
	    	listFood = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<SubFood>() {
	            @Override
	            public SubFood mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	
	            	SubFood subFood = new SubFood();
	            	subFood.setId(rs.getInt("id"));
	            	subFood.setCategory(rs.getInt("category"));
	            	subFood.setImg(rs.getString("hinhAnh"));
	            	subFood.setGia(rs.getInt("gia"));
	            	subFood.setMoTa(rs.getString("moTa"));
	            	subFood.setTenMon(rs.getString("tenMon"));
	            	subFood.setThoiGianCapNhat(rs.getString("thoiGianCapNhat"));
	            	subFood.setThoiGianTao(rs.getString("thoiGianTao"));
	            	return subFood;
	            }
	        });
	
	    } catch (Exception e) {
	        e.printStackTrace();
	        return listFood;
	        // TODO: handle exception
	    }
	    return listFood;
	}

	@Override
	public boolean deleteSubFood(int id) {
		String sql_del = "delete from t_sub_food where id = ?";
        return (jdbcTemplate.update(sql_del, id) > 0);
	}

	@Override
	public void updateSubFood(SubFood subFood) {
		String sql = "UPDATE t_sub_food set category=?,tenMon=?,gia=?,hinhAnh=?,moTa=?,thoiGianCapNhat=now() where id=?";
		System.out.println(jdbcTemplate.update(sql,subFood.getCategory(),
				subFood.getTenMon(),subFood.getGia(),subFood.getImg(),subFood.getMoTa(),
				subFood.getId()));
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<SubFood> getByName(String name) {
		String sql = "select * from t_sub_food where tenMon like '%" +name+"%'";
	    List<SubFood> listFood = null;
	    try {
	    	listFood = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<SubFood>() {
	            @Override
	            public SubFood mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	
	            	SubFood subFood = new SubFood();
	            	subFood.setId(rs.getInt("id"));
	            	subFood.setCategory(rs.getInt("category"));
	            	subFood.setImg(rs.getString("hinhAnh"));
	            	subFood.setGia(rs.getInt("gia"));
	            	subFood.setMoTa(rs.getString("moTa"));
	            	subFood.setTenMon(rs.getString("tenMon"));
	            	subFood.setThoiGianCapNhat(rs.getString("thoiGianCapNhat"));
	            	subFood.setThoiGianTao(rs.getString("thoiGianTao"));
	            	return subFood;
	            }
	        });
	
	    } catch (Exception e) {
	        e.printStackTrace();
	        return listFood;
	        // TODO: handle exception
	    }
	    return listFood;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<SubFood> getAllByCategory(int id) {
	 String sql = "select * from t_sub_food where category = " + id;
	    List<SubFood> listFood = null;
	    try {
	    	listFood = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<SubFood>() {
	            @Override
	            public SubFood mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	
	            	SubFood subFood = new SubFood();
	            	subFood.setId(rs.getInt("id"));
	            	subFood.setCategory(rs.getInt("category"));
	            	subFood.setImg(rs.getString("hinhAnh"));
	            	subFood.setGia(rs.getInt("gia"));
	            	subFood.setMoTa(rs.getString("moTa"));
	            	subFood.setTenMon(rs.getString("tenMon"));
	            	subFood.setThoiGianCapNhat(rs.getString("thoiGianCapNhat"));
	            	subFood.setThoiGianTao(rs.getString("thoiGianTao"));
	            	return subFood;
	            }
	        });
	
	    } catch (Exception e) {
	        e.printStackTrace();
	        return listFood;
	        // TODO: handle exception
	    }
	    return listFood;
	}

	@Override
	public int subFoodQuantity() {
		String sql = "select count(*)as sl from t_sub_food";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				int sl = 0;
				while(rs.next()) {
					sl = rs.getInt("sl");
				}
				return sl;
			}
			
		});
	}
}
