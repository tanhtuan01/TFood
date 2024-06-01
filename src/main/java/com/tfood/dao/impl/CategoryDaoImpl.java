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

import com.tfood.dao.CategoryDao;
import com.tfood.entity.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @SuppressWarnings("deprecation")
    @Override
    public List<Category> getAll() {
        // Kết nối đến csdl và return về list cate
        String sql = "select * from t_category order by(thuTuHienThi)ASC";
        List<Category> listCategory = null;
        try {
            listCategory = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Category>() {
                @Override
                public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Category cate = new Category();
                    cate.setId(rs.getInt("id"));
                    cate.setTenDanhMuc(rs.getString("tenDanhMuc"));
                    cate.setTitle(rs.getString("title"));
                    cate.setThuTuHienThi(rs.getInt("thuTuHienThi"));
                    cate.setImg(rs.getString("hinhAnh"));
                    cate.setThoiGianTao(rs.getString("thoiGianTao"));
                    cate.setThoiGianCapNhat(rs.getString("thoiGianCapNhat"));
                    return cate;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            return listCategory;
            // TODO: handle exception
        }
        return listCategory;
    }

    @Override
    public void addCategory(Category category) {
        String sql = "insert into t_category(tenDanhMuc,title,thuTuHienThi,hinhAnh,thoiGianTao) values(?, ?,?,?,now())";
        System.out.println(jdbcTemplate.update(sql,category.getTenDanhMuc(),category.getTitle(),category.getThuTuHienThi(),category.getImg()));
    }

    @Override
    public boolean update(Category category) {
        String sql_update = "UPDATE t_category set tenDanhMuc = ?,title = ?, thuTuHienThi = ?, hinhAnh =?,thoiGianCapNhat = now() where id = ?";
        return (jdbcTemplate.update(sql_update, category.getTenDanhMuc(),category.getTitle(),category.getThuTuHienThi(),category.getImg(),category.getId()) > 0);
    }
//
//    @Override
//    public boolean update(int id, String name, String avatar) {
//        // TODO Auto-generated method stub
//        String sql_update = "update tb_category set cate_name = ? cate_images = ? where id = ?";
//        return (jdbcTemplate.update(sql_update, name, avatar, id) > 0);
//    }
//
		@Override
		public boolean delete(int id) {
		    // TODO Auto-generated method stub
		    String sql_del = "delete from t_category where id = ?";
		    return (jdbcTemplate.update(sql_del, id) > 0);
		}
//
//    @Override
//    public List<Category> findByName(String name) {
//        // TODO Auto-generated method stub
//        String sql = "select * from tb_category where cate_name like '%" + name + "%'";
//        @SuppressWarnings("deprecation")
//        List<Category> listCategory = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Category>() {
//            @Override
//            public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
//                // TODO Auto-generated method stub
//                Category cate = new Category();
//                cate.setId(rs.getInt("id"));
//                cate.setName(rs.getString("cate_name"));
//                cate.setAvatar(rs.getString("cate_images"));
//                return cate;
//            }
//        });
//        return listCategory;
//    }
//
//	@Override
//	public void updateCategory(Category category) {
//		String sqlString = "update tb_category set cate_name = ? , cate_images = ? where id = ?";
//		System.out.println(jdbcTemplate.update(sqlString,category.getName(), category.getAvatar(), category.getId()));
//	}
//
//	@Override
//	public String getNameCategory(int id) {
//		 String sql_login = "Select cate_name from tb_category where id = ?";
//	        return jdbcTemplate.query(sql_login, new ResultSetExtractor<String>() {
//	            @Override
//	            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//	                String nameString="";
//	                while (resultSet.next()) {
//	                	nameString =  resultSet.getString("cate_name");
//	                }
//	                System.out.println("cate name: " + nameString);
//	                return nameString;
//	            }
//	        }, id);
//		
//	}
//	
////	 public void addCategory(Category category) {
////
////	        String sql = "insert into tb_category(cateName, cateImages) values(?, ?)";
////	        System.out.println(jdbcTemplate.update(sql,category.getName(), category.getAvatar()));
////	    }
//	
//	@SuppressWarnings("deprecation")
//    @Override
//    public List<Category> get6ItemsMenu() {
//        // Kết nối đến csdl và return về list cate
//        String sql = "select * from tb_category limit 6";
//        List<Category> listCategory = null;
//        try {
//            listCategory = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Category>() {
//                @Override
//                public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
//                    // TODO Auto-generated method stub
//                    Category cate = new Category();
//                    cate.setId(rs.getInt("id"));
//                    cate.setName(rs.getString("cate_name"));
//                    cate.setAvatar(rs.getString("cate_images"));
//                    return cate;
//                }
//            });
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return listCategory;
//            // TODO: handle exception
//        }
//        return listCategory;
//    }
//
//	@Override
//	public int getFirstCategory() {
//		 String sql_login = "SELECT id from tb_category limit 1";
//	        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
//	            @Override
//	            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//	                int id= 0;
//	                while (resultSet.next()) {
//	                	id =  resultSet.getInt("id");
//	                }
//	          
//	                return id;
//	            }
//	        });
//	}
//	
		
		@SuppressWarnings("deprecation")
		@Override
		public List<Category> searchCategory(String name) {
	        String sql = "select * from t_category where tenDanhMuc like '%"+ name +"%' order by(thuTuHienThi)ASC";
	        List<Category> listCategory = null;
	        try {
	            listCategory = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Category>() {
	                @Override
	                public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
	                    // TODO Auto-generated method stub
	                    Category cate = new Category();
	                    cate.setId(rs.getInt("id"));
	                    cate.setTenDanhMuc(rs.getString("tenDanhMuc"));
	                    cate.setTitle(rs.getString("title"));
	                    cate.setThuTuHienThi(rs.getInt("thuTuHienThi"));
	                    cate.setImg(rs.getString("hinhAnh"));
	                    cate.setThoiGianTao(rs.getString("thoiGianTao"));
	                    cate.setThoiGianCapNhat(rs.getString("thoiGianCapNhat"));
	                    return cate;
	                }
	            });

	        } catch (Exception e) {
	            e.printStackTrace();
	            return listCategory;
	            // TODO: handle exception
	        }
	        return listCategory;
		}

		@Override
		public String getTitleWithFoodId(int idFood) {
			String sql_login = "SELECT tc.title from t_category tc join t_food tf on tc.id = tf.category where tf.id = ?";
		      return jdbcTemplate.query(sql_login, new ResultSetExtractor<String>() {
		          @Override
		          public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		              String title = "";
		              while (resultSet.next()) {
		                  title =  resultSet.getString("title");
		              }
		              return title;
		          }
		      }, idFood);
		}

		@Override
		public String getCategoryNameByTitle(String title) {
			String sql = "SELECT tenDanhMuc FROM t_category WHERE title = ?";
		      return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
		          @Override
		          public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		              String tenDanhMuc = "";
		              while (resultSet.next()) {
		            	  tenDanhMuc =  resultSet.getString("tenDanhMuc");
		              }
		              return tenDanhMuc;
		          }
		      }, title);
		}

		@Override
		public int checkExistsCategoryTitle(String title) {
			String sql = "SELECT id FROM t_category WHERE title = ?";
		      return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
		          @Override
		          public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		              int id = 0;
		              while (resultSet.next()) {
		            	  id =  resultSet.getInt("id");
		              }
		              return id;
		          }
		      }, title);
		}
}
