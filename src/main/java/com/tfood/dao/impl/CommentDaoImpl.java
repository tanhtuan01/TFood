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

import com.tfood.dao.CommentDao;
import com.tfood.entity.Category;
import com.tfood.entity.Comment;
import com.tfood.entity.Food;

@Repository
public class CommentDaoImpl implements CommentDao{
	
	@Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public int countComment(int id) {
		String sql = "SELECT count(id) as cid FROM tb_comment where id_food  = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int id = 0;
                while (resultSet.next()) {
                    id =  resultSet.getInt("cid");
                }
       
                return id;
            }
        }, id);
	}

	@Override
	public float avgcommnet(int id) {
		String sql = "SELECT AVG(score) as cid FROM tb_comment WHERE id_food = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Float>() {
            @Override
            public Float extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                float id = 0;
                while (resultSet.next()) {
                    id =  resultSet.getFloat("cid");
                }
       
                return id;
            }
        }, id);
	}

	@Override
	public int countScore1(int id) {
		String sql = "SELECT count(id) as cid FROM tb_comment where score = 1 and id_food  = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int id = 0;
                while (resultSet.next()) {
                    id =  resultSet.getInt("cid");
                }
       
                return id;
            }
        }, id);
	}

	@Override
	public int countScore2(int id) {
		String sql = "SELECT count(id) as cid FROM tb_comment where score = 2 and id_food  = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int id = 0;
                while (resultSet.next()) {
                    id =  resultSet.getInt("cid");
                }
       
                return id;
            }
        }, id);
	}

	@Override
	public int countScore3(int id) {
		String sql = "SELECT count(id) as cid FROM tb_comment where score = 3 and id_food  = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int id = 0;
                while (resultSet.next()) {
                    id =  resultSet.getInt("cid");
                }
       
                return id;
            }
        }, id);
	}

	@Override
	public int countScore4(int id) {
		String sql = "SELECT count(id) as cid FROM tb_comment where score = 4 and id_food  = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int id = 0;
                while (resultSet.next()) {
                    id =  resultSet.getInt("cid");
                }
       
                return id;
            }
        }, id);
	}

	@Override
	public int countScore5(int id) {
		String sql = "SELECT count(id) as cid FROM tb_comment where score = 5 and id_food  = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int id = 0;
                while (resultSet.next()) {
                    id =  resultSet.getInt("cid");
                }
       
                return id;
            }
        }, id);
	}

	@Override
	public void addNewComment(int user, int food) {
		String sql = "INSERT into t_comment(userId,foodId) VALUES (?,?)";
		jdbcTemplate.update(sql, user,food);
	}

	@Override
	public int checkBought(int user, int food) {
		String sql = "SELECT id from t_comment WHERE userId = ? and foodId = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int id = 0;
                while (resultSet.next()) {
                    id =  resultSet.getInt("id");
                }
                return id;
            }
        }, user, food);
	}

	@Override
	public int checkExistsComment(int user, int food) {
		String sql = "SELECT diemDanhGia from t_comment WHERE userId = ? and foodId = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int diemDanhGia = 0;
                while (resultSet.next()) {
                	diemDanhGia =  resultSet.getInt("diemDanhGia");
                }
                return diemDanhGia;
            }
        }, user, food);
	}

	@Override
	public boolean updateComment(String content, int score, int user, int food) {
		String sql = "UPDATE t_comment set noiDungDanhGia = ?, diemDanhGia = ?, thoiGianDanhGia = now() where userId = ? and foodId = ? and diemDanhGia = 0 LIMIT 1";
		return (jdbcTemplate.update(sql,content,score,user,food) > 0);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<Comment> getAllByFood(int food) {
		String sql = "SELECT tu.tenNguoiDung,tu.avatar, tc.id,tc.userId,tc.foodId,tc.noiDungDanhGia,tc.thoiGianDanhGia,tc.thoiGianDanhGia ,tc.diemDanhGia FROM t_comment tc inner join t_users tu on tc.userId = tu.id WHERE foodId = ? and diemDanhGia > 0";
		 List<Comment> listCategory = jdbcTemplate.query(sql, new Object[]{food}, new RowMapper<Comment>() {
	                @Override
	                public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
	                	Comment cate = new Comment();
	                    cate.setId(rs.getInt("id"));
	                    cate.setContent(rs.getString("noiDungDanhGia"));
	                    cate.setScore(rs.getInt("diemDanhGia"));
	                    cate.setFood(rs.getInt("foodId"));
	                    cate.setUser(rs.getInt("userId"));
	                    cate.setDate(rs.getString("thoiGianDanhGia"));
	                    cate.setImg(rs.getString("avatar"));
	                    cate.setName(rs.getString("tenNguoiDung"));
	                    return cate;
	                }
	            });
		return listCategory;

	}

	@Override
	public double avgScore(int food) {
		String sql = "SELECT AVG(diemDanhGia) as avgScore FROM t_comment WHERE foodId = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Double>() {
            @Override
            public Double extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                double avgScore = 0;
                while (resultSet.next()) {
                	avgScore =  resultSet.getDouble("avgScore");
                }
                return avgScore;
            }
        }, food);
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public List<Comment> getTop3Comment() {
		String sql = "SELECT DISTINCT(tu.tenNguoiDung),tu.avatar,tc.noiDungDanhGia,tc.thoiGianDanhGia FROM t_comment tc INNER JOIN t_users tu on tc.userId = tu.id WHERE tc.diemDanhGia = 10 order by rand() desc limit 3";
		List<Comment> list = null;
		try {
			list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Comment>() {

				@Override
				public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
					Comment comment = new Comment();
					comment.setName(rs.getString("tenNguoiDung"));
					comment.setImg(rs.getString("avatar"));
					comment.setContent(rs.getString("noiDungDanhGia"));
					comment.setDate(rs.getString("thoiGianDanhGia"));
					return comment;
				}
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

//	@Override
//	public List<Comment> getAllByFoodAnyPerson(int food) {
//		String sql = "SELECT tu.tenNguoiDung,tu.avatar, tc.id,tc.userId,tc.foodId,tc.noiDungDanhGia,tc.thoiGianDanhGia,tc.thoiGianDanhGia ,tc.diemDanhGia FROM t_comment tc inner join t_users tu on tc.userId = tu.id WHERE foodId = ? ";
//		 @SuppressWarnings("deprecation")
//		List<Comment> listCategory = jdbcTemplate.query(sql, new Object[]{food}, new RowMapper<Comment>() {
//	                @Override
//	                public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
//	                	Comment cate = new Comment();
//	                    cate.setId(rs.getInt("id"));
//	                    cate.setContent(rs.getString("noiDungDanhGia"));
//	                    cate.setScore(rs.getInt("diemDanhGia"));
//	                    cate.setFood(rs.getInt("foodId"));
//	                    cate.setUser(rs.getInt("userId"));
//	                    cate.setDate(rs.getString("thoiGianDanhGia"));
//	                    cate.setImg(rs.getString("avatar"));
//	                    cate.setName(rs.getString("tenNguoiDung"));
//	                    return cate;
//	                }
//	            });
//		return listCategory;
//	}

	@Override
	public int countCommentNotNull(int food) {
		String sql = "SELECT COUNT(*) as sl FROM t_comment WHERE id = ? and diemDanhGia > 0";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				int sl = 0;
				while (rs.next()) {
					sl = rs.getInt("sl");
				}
				return sl;
			}
			
		}, food);
	}
	
}
