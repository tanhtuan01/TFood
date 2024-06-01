package com.tfood.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tfood.dao.AnotherDao;
import com.tfood.entity.AnotherAds;

@Repository
public class AnotherDaoImpl implements AnotherDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@SuppressWarnings("deprecation")
	@Override
	public List<AnotherAds> getRandom() {
		String sql = "SELECT * FROM t_ads ORDER BY RAND() LIMIT 1";
		List<AnotherAds> list = null;
		try {
			list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<AnotherAds>() {

				@Override
				public AnotherAds mapRow(ResultSet rs, int rowNum) throws SQLException {
					AnotherAds ads = new AnotherAds();
					ads.setContent(rs.getString("content"));
					ads.setDate(rs.getString("thoiGianTao"));
					ads.setId(rs.getInt("id"));
					ads.setLink(rs.getString("link"));
					ads.setImg(rs.getString("img"));
					return ads;
				}
				
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<AnotherAds> getAll() {
		String sql = "SELECT * FROM t_ads order by id desc";
		List<AnotherAds> list = null;
		try {
			list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<AnotherAds>() {

				@Override
				public AnotherAds mapRow(ResultSet rs, int rowNum) throws SQLException {
					AnotherAds ads = new AnotherAds();
					ads.setContent(rs.getString("content"));
					ads.setDate(rs.getString("thoiGianTao"));
					ads.setId(rs.getInt("id"));
					ads.setLink(rs.getString("link"));
					ads.setImg(rs.getString("img"));
					return ads;
				}
				
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public void addAds(AnotherAds ads) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO t_ads(link,img,content,thoiGianTao) values (?,?,?,now())";
		jdbcTemplate.update(sql,ads.getLink(),ads.getImg(),ads.getContent());
	}

	@Override
	public boolean deleteAds(int id) {
		String sql = "delete from t_ads where id = ?";
		return jdbcTemplate.update(sql,id) > 0;
	}

	@Override
	public void updateAds(AnotherAds ads) {
		String sql = "update t_ads set link = ?, img = ?, content = ?, thoiGianCapNhat = now() where id = ?";
		jdbcTemplate.update(sql,ads.getLink(),ads.getImg(),ads.getContent(),ads.getId());
	}

	
	
}
