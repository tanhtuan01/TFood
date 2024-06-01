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

import com.tfood.dao.SliderDao;
import com.tfood.entity.Slider;

@Repository
public class SliderDaoImpl implements SliderDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("deprecation")
	@Override
	public List<Slider> getAll() {
		String sql = "select * from t_slider ORDER BY stt ,thoiGianCapNhat desc";
		List<Slider> list = null;
		try {
			list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Slider>() {

				@Override
				public Slider mapRow(ResultSet rs, int rowNum) throws SQLException {
					Slider slider = new Slider();
					slider.setId(rs.getInt("id"));
					slider.setDate(rs.getString("thoiGianTao"));
					slider.setImg(rs.getString("img"));
					slider.setNoiDung(rs.getString("noiDung"));
					slider.setStt(rs.getInt("stt"));
					return slider;
				}	
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void addSlider(Slider slider) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO t_slider(stt,noiDung,img,thoiGianTao) VALUES\r\n"
				+ "(?,?,?,now())";
		jdbcTemplate.update(sql,slider.getStt(),slider.getNoiDung(),slider.getImg());
	}
	
	@Override
	public void updateSlider(Slider slider) {
		String sql = "UPDATE t_slider set stt = ?, noiDung =?, img =?, thoiGianCapNhat = now() WHERE id = ?";
		jdbcTemplate.update(sql,slider.getStt(),slider.getNoiDung(),slider.getImg(),slider.getId());
	}
	
	@Override
	public boolean deleteSlider(int id) {
		String sql = "delete from t_slider where id = ?";
		return jdbcTemplate.update(sql,id) > 0;
	}

	@Override
	public int checkSttExists(int stt, int id) {
		String sql = "select stt from t_slider WHERE stt = ? and id != ?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				int stt = 0;
				while(rs.next()) {
					stt = rs.getInt("stt");
				}
				return stt;
			}
			
		},stt, id);
	}
	
	@Override
	public int checkSttExistsBeforeAdd(int stt) {
		String sql = "select stt from t_slider WHERE stt = ?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				int stt = 0;
				while(rs.next()) {
					stt = rs.getInt("stt");
				}
				return stt;
			}
			
		},stt);
	}

}
