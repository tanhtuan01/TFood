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

import com.tfood.dao.FoodDao;
import com.tfood.entity.Food;

@Repository
public class FoodDaoImpl implements FoodDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	 
	@SuppressWarnings("deprecation")
	@Override
	public List<Food> getAll() {
	    // Kết nối đến csdl và return về list cate
	    String sql = "select * from t_food order by id desc";
	    List<Food> listFood = null;
	    try {
	    	listFood = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Food>() {
	            @Override
	            public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	
	            	Food food = new Food();
	            	food.setId(rs.getInt("id"));
	            	food.setCategory(rs.getInt("category"));
	            	food.setTitle(rs.getString("title"));
	            	food.setTenMon(rs.getString("tenMon"));
	            	food.setGia(rs.getInt("gia"));
	            	food.setGiamGia(rs.getInt("giamGia"));
	            	food.setGiaMoi(rs.getInt("giaMoi"));
	            	food.setMoTa(rs.getString("moTa"));
	            	food.setDaBan(rs.getInt("daBan"));
	            	food.setImg(rs.getString("img"));
	            	food.setThoiGianTao(rs.getString("thoiGianTao"));
	            	food.setThoiGianCapNhat(rs.getString("thoiGianCapNhat"));
	            	food.setTrangThai(rs.getInt("trangThai"));
	            	return food;
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
	public void addFood(Food food) {
		 String sql = "INSERT INTO t_food(category,tenMon,title,gia,giamGia,giaMoi,trangThai,img,moTa,daBan,thoiGianTao)VALUES(?,?,?,?,?,?,?,?,?,?,now())";
	     System.out.println(jdbcTemplate.update(sql,
	    		 food.getCategory(),
	    		 food.getTenMon(),
	    		 food.getTitle(),
	    		 food.getGia(),
	    		 food.getGiamGia(),
	    		 food.getGiaMoi(),
	    		 food.getTrangThai(),
	    		 food.getImg(),
	    		 food.getMoTa(),
	    		 food.getDaBan()));
//	     System.out.println(food);
	}
//	
	@Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        String sql_del = "delete from t_food where id = ?";
        return (jdbcTemplate.update(sql_del, id) > 0);
    }
//
//	 @SuppressWarnings("deprecation")
//	 @Override
//	 public List<Food> getAllbyCategory(int id) {
//		        String sql = "select * from tb_foodlist where food_cate_id = '"+id+"'";
//		        List<Food> listFood = null;
//		        try {
//		        	listFood = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Food>() {
//		                @Override
//		                public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
//		                	
//		                	Food food = new Food();
//		                	food.setId(rs.getInt("id"));
//		                	food.setName(rs.getString("food_name"));
//		                	food.setAvatar(rs.getString("food_images"));
//		                	food.setCateId(rs.getInt("food_cate_id"));
//		                	food.setPrice(rs.getInt("food_price"));
//		                	food.setStatus(rs.getInt("food_status"));
//		                	food.setDiscount(rs.getInt("food_discount"));
//		                	food.setNew_price(rs.getInt("food_new_price"));
//		                	food.setSold(rs.getInt("food_sold"));
//		                	food.setDescription(rs.getString("food_description"));
//		                	return food;
//		                }
//		            });
//	
//		        } catch (Exception e) {
//		            e.printStackTrace();
//		            return listFood;
//		            // TODO: handle exception
//		        }
//		        return listFood;
//		    }
//
	@Override
	public void updateFood(Food food) {	
		String sqlString = "UPDATE t_food SET category = ?, tenMon = ?, title = ?, gia = ?, giamGia = ?, giaMoi = ?, img = ? , moTa = ?,trangThai = ?, thoiGianCapNhat= now() where id = ?";;
		System.out.println(jdbcTemplate.update(sqlString, 
				food.getCategory(),
				food.getTenMon(),
				food.getTitle(),
				food.getGia(),
				food.getGiamGia(),
				food.getGiaMoi(),
				food.getImg(),
				food.getMoTa(),
				food.getTrangThai(),
				food.getId()
				));
		System.out.println("Cap nhat thanh cong ");
	}
//
//
//	@SuppressWarnings("deprecation")
//	 @Override
//	 public List<Food> getFoodbyId(int id) {
//		        String sql = "select * from tb_foodlist where id = '"+id+"'";
//		        List<Food> listFood = null;
//		        try {
//		        	listFood = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Food>() {
//		                @Override
//		                public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
//		                	
//		                	Food food = new Food();
//		                	food.setId(rs.getInt("id"));
//		                	food.setName(rs.getString("food_name"));
//		                	food.setAvatar(rs.getString("food_images"));
//		                	food.setCateId(rs.getInt("food_cate_id"));
//		                	food.setPrice(rs.getInt("food_price"));
//		                	food.setStatus(rs.getInt("food_status"));
//		                	food.setSold(rs.getInt("food_sold"));
//		                	food.setDescription(rs.getString("food_description"));
//		                	return food;
//		                }
//		            });
//	
//		        } catch (Exception e) {
//		            e.printStackTrace();
//		            return listFood;
//		            // TODO: handle exception
//		        }
//		        return listFood;
//		    }
//
//
//	 
//	@Override
//    public int CheckFoodId(int id) {
//        String checkid = "Select id from tb_foodlist where id = ?";
//        return jdbcTemplate.query(checkid, new ResultSetExtractor<Integer>() {
//            @Override
//            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                int id = 0;
//                while (resultSet.next()) {
//                    id =  resultSet.getInt("id");
//                }
//                System.out.println("food id : " + id);
//                return id;
//            }
//        }, id);
//    }
//
//
//
//	@Override
//	public int CheckCateId(int id) {
//		 String checkid = "Select id from tb_foodlist where food_cate_id = ?";
//	        return jdbcTemplate.query(checkid, new ResultSetExtractor<Integer>() {
//	            @Override
//	            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//	                int id = 0;
//	                while (resultSet.next()) {
//	                    id =  resultSet.getInt("id");
//	                }
//	                System.out.println("cate id : " + id);
//	                return id;
//	            }
//	        }, id);
//	}
//
//	@Override
//	public int CheckFoodIdAndCateId(int id1, int id2) {
//		String checkid = "Select count(id) as cid from tb_foodlist where id= ? and food_cate_id = ?";
//        return jdbcTemplate.query(checkid, new ResultSetExtractor<Integer>() {
//            @Override
//            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                int id = 0;
//                while (resultSet.next()) {
//                    id =  resultSet.getInt("cid");
//                }
//                System.out.println("cate id : " + id);
//                return id;
//            }
//        }, id1, id2);
//	}
//
//
//	@SuppressWarnings("deprecation")
//	   @Override
//	    public List<Food> getTopSold() {
//	        // Kết nối đến csdl và return về list cate
//	        String sql = "SELECT * FROM tb_foodlist  ORDER BY(food_sold) DESC LIMIT 10";
//	        List<Food> listFood = null;
//	        try {
//	        	listFood = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Food>() {
//	                @Override
//	                public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
//	                	
//	                	Food food = new Food();
//	                	food.setId(rs.getInt("id"));
//	                	food.setName(rs.getString("food_name"));
//	                	food.setAvatar(rs.getString("food_images"));
//	                	food.setCateId(rs.getInt("food_cate_id"));
//	                	food.setPrice(rs.getInt("food_price"));
//	                	food.setStatus(rs.getInt("food_status"));
//	                	food.setSold(rs.getInt("food_sold"));
//	                	food.setDescription(rs.getString("food_description"));
//	                	return food;
//	                }
//	            });
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return listFood;
//	            // TODO: handle exception
//	        }
//	        return listFood;
//	    }
//
	@Override
	public int getPriceFood(int id) {
		String sql = "SELECT gia from t_food where id = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int id = 0;
                while (resultSet.next()) {
                    id =  resultSet.getInt("gia");
                }
       
                return id;
            }
        }, id);
	}
//
//	@SuppressWarnings("deprecation")
//	@Override
//	public List<Food> getFood9Deal(int id) {
//		   String sql = "SELECT * FROM tb_foodlist  where food_status = 1 and food_cate_id = '"+id+"' limit 9";
//	        List<Food> listFood = null;
//	        try {
//	        	listFood = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Food>() {
//	                @Override
//	                public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
//	                	
//	                	Food food = new Food();
//	                	food.setId(rs.getInt("id"));
//	                	food.setName(rs.getString("food_name"));
//	                	food.setAvatar(rs.getString("food_images"));
//	                	food.setCateId(rs.getInt("food_cate_id"));
//	                	food.setPrice(rs.getInt("food_price"));
//	                	food.setStatus(rs.getInt("food_status"));
//	                	food.setDiscount(rs.getInt("food_discount"));
//	                	food.setNew_price(rs.getInt("food_new_price"));
//	                	food.setSold(rs.getInt("food_sold"));
//	                	food.setDescription(rs.getString("food_description"));
//	                	return food;
//	                }
//	            });
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return listFood;
//	            // TODO: handle exception
//	        }
//	        return listFood;
//	}
//	
//	
//	@SuppressWarnings("deprecation")
//	@Override
//	public List<Food> getFood9NoDeal(int id) {
//		   String sql = "SELECT * FROM tb_foodlist  where food_status = 0 and food_cate_id = '"+id+"' limit 9";
//	        List<Food> listFood = null;
//	        try {
//	        	listFood = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Food>() {
//	                @Override
//	                public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
//	                	
//	                	Food food = new Food();
//	                	food.setId(rs.getInt("id"));
//	                	food.setName(rs.getString("food_name"));
//	                	food.setAvatar(rs.getString("food_images"));
//	                	food.setCateId(rs.getInt("food_cate_id"));
//	                	food.setPrice(rs.getInt("food_price"));
//	                	food.setStatus(rs.getInt("food_status"));
//	                	food.setDiscount(rs.getInt("food_discount"));
//	                	food.setNew_price(rs.getInt("food_new_price"));
//	                	food.setSold(rs.getInt("food_sold"));
//	                	food.setDescription(rs.getString("food_description"));
//	                	return food;
//	                }
//	            });
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return listFood;
//	            // TODO: handle exception
//	        }
//	        return listFood;
//	}
//	
//	@SuppressWarnings("deprecation")
//	@Override
//	public List<Food> getFoodDealByCategory(int id) {
//		  String sql = "select * from tb_foodlist where food_status = 1 and food_cate_id = '" +id+ "'";
//	        List<Food> listFood = null;
//	        try {
//	        	listFood = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Food>() {
//	                @Override
//	                public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
//	                	
//	                	Food food = new Food();
//	                	food.setId(rs.getInt("id"));
//	                	food.setName(rs.getString("food_name"));
//	                	food.setAvatar(rs.getString("food_images"));
//	                	food.setCateId(rs.getInt("food_cate_id"));
//	                	food.setPrice(rs.getInt("food_price"));
//	                	food.setStatus(rs.getInt("food_status"));
//	                	food.setDiscount(rs.getInt("food_discount"));
//	                	food.setNew_price(rs.getInt("food_new_price"));
//	                	food.setSold(rs.getInt("food_sold"));
//	                	food.setDescription(rs.getString("food_description"));
//	                	return food;
//	                }
//	            });
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return listFood;
//	            // TODO: handle exception
//	        }
//	        return listFood;
//	    }
//	
//	
//	@SuppressWarnings("deprecation")
//	@Override
//	public List<Food> getFoodNoDealByCategory(int id) {
//		  String sql = "select * from tb_foodlist where food_status = 0 and food_cate_id = '" +id+ "'";
//	        List<Food> listFood = null;
//	        try {
//	        	listFood = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Food>() {
//	                @Override
//	                public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
//	                	
//	                	Food food = new Food();
//	                	food.setId(rs.getInt("id"));
//	                	food.setName(rs.getString("food_name"));
//	                	food.setAvatar(rs.getString("food_images"));
//	                	food.setCateId(rs.getInt("food_cate_id"));
//	                	food.setPrice(rs.getInt("food_price"));
//	                	food.setStatus(rs.getInt("food_status"));
//	                	food.setDiscount(rs.getInt("food_discount"));
//	                	food.setNew_price(rs.getInt("food_new_price"));
//	                	food.setSold(rs.getInt("food_sold"));
//	                	food.setDescription(rs.getString("food_description"));
//	                	return food;
//	                }
//	            });
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return listFood;
//	            // TODO: handle exception
//	        }
//	        return listFood;
//	    }
//
//	@Override
//	public int checkFoodInOrder(int id_food, int id_user) {
//		String sql = "SELECT orders_food_id FROM tb_orders where orders_food_id = ? and orders_user_id = ?";
//        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
//            @Override
//            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                int id = 0;
//                while (resultSet.next()) {
//                    id =  resultSet.getInt("orders_food_id");
//                }
//       
//                return id;
//            }
//        }, id_food, id_user);
//	}
//
	@SuppressWarnings("deprecation")
	@Override
	public List<Food> getByName(String food) {
		  String sql = "select * from t_food where tenMon like '%" +food+ "%' or title like'%" +food+ "%'";
	        List<Food> listFood = null;
	        try {
	        	listFood = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Food>() {
	                @Override
	                public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
	                	
	                	Food food = new Food();
	                	food.setId(rs.getInt("id"));
	                	food.setCategory(rs.getInt("category"));
	                	food.setGia(rs.getInt("gia"));
	                	food.setGiamGia(rs.getInt("giamGia"));
	                	food.setGiaMoi(rs.getInt("giaMoi"));
	                	food.setImg(rs.getString("img"));
	                	food.setMoTa(rs.getString("moTa"));
	                	food.setTitle(rs.getString("title"));
	                	food.setThoiGianTao(rs.getString("thoiGianTao"));
	                	food.setTenMon(rs.getString("tenMon"));
	                	
	                	return food;
	                }
	            });

	        } catch (Exception e) {
	            e.printStackTrace();
	            return listFood;
	            // TODO: handle exception
	        }
	        return listFood;
	}
//
//	@Override
//	public String getNameFood(int id) {
//		String sql = "SELECT food_name FROM tb_foodlist where id = ?";
//        return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
//            @Override
//            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                String id = "";
//                while (resultSet.next()) {
//                    id =  resultSet.getString("food_name");
//                }
//       
//                return id;
//            }
//        }, id);
//	}
//
//	@Override
//	public int getNewPrice(int id) {
//		String sql = "SELECT food_new_price FROM tb_foodlist where id = ?";
//        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
//            @Override
//            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                int id = 0;
//                while (resultSet.next()) {
//                    id =  resultSet.getInt("food_new_price");
//                }
//       
//                return id;
//            }
//        }, id);
//	}
//
//	@Override
//	public String getAvatar(int id) {
//		String sql = "SELECT food_images FROM tb_foodlist where id = ?";
//        return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
//            @Override
//            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                String id = "";
//                while (resultSet.next()) {
//                    id =  resultSet.getString("food_images");
//                }
//       
//                return id;
//            }
//        }, id);
//	}
//
//	@Override
//	public String getDescription(int id) {
//		String sql = "SELECT food_description FROM tb_foodlist where id = ?";
//        return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
//            @Override
//            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                String id = "";
//                while (resultSet.next()) {
//                    id =  resultSet.getString("food_description");
//                }
//       
//                return id;
//            }
//        }, id);
//	}
//
//	@SuppressWarnings("deprecation")
//	@Override
//	public List<Food> getTopSoldbyCate(int id) {
//		 String sql = "SELECT * FROM tb_foodlist where food_cate_id = '"+id+"' ORDER BY(food_sold) DESC LIMIT 10 ";
//	        List<Food> listFood = null;
//	        try {
//	        	listFood = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Food>() {
//	                @Override
//	                public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
//	                	
//	                	Food food = new Food();
//	                	food.setId(rs.getInt("id"));
//	                	food.setName(rs.getString("food_name"));
//	                	food.setAvatar(rs.getString("food_images"));
//	                	food.setCateId(rs.getInt("food_cate_id"));
//	                	food.setPrice(rs.getInt("food_price"));
//	                	food.setStatus(rs.getInt("food_status"));
//	                	food.setSold(rs.getInt("food_sold"));
//	                	food.setDescription(rs.getString("food_description"));
//	                	return food;
//	                }
//	            });
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return listFood;
//	            // TODO: handle exception
//	        }
//	        return listFood;
//	}
//
//	@Override
//	public void updateSold(Food food) {
//		String sqlString = "update tb_foodlist set food_sold = food_sold + '?' where id = ?";
//		System.out.println(sqlString);
//		System.out.println(jdbcTemplate.update(sqlString, food.getSold(), food.getId()));
//		System.out.println("Cap nhat thanh cong so luong ban");
//		
//	}
	 
	@SuppressWarnings("deprecation")
	@Override
	public List<Food> getDealFood() {
		String sql = "select * from t_food where trangThai = 1  order BY giamGia desc";
        List<Food> listFood = null;
        try {
        	listFood = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Food>() {
                @Override
                public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
                	
                	Food food = new Food();
                	food.setId(rs.getInt("id"));
                	food.setCategory(rs.getInt("category"));
                	food.setTitle(rs.getString("title"));
                	food.setTenMon(rs.getString("tenMon"));
                	food.setGia(rs.getInt("gia"));
                	food.setGiamGia(rs.getInt("giamGia"));
                	food.setGiaMoi(rs.getInt("giaMoi"));
                	food.setMoTa(rs.getString("moTa"));
                	food.setDaBan(rs.getInt("daBan"));
                	food.setImg(rs.getString("img"));
                	food.setThoiGianTao(rs.getString("thoiGianTao"));
                	food.setThoiGianCapNhat(rs.getString("thoiGianCapNhat"));
                	food.setTrangThai(rs.getInt("trangThai"));
                	return food;
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
	public List<Food> getFoodByTitleOfCategory(String title) {
		String sql = "SELECT * from t_food tf join t_category tc on tf.category = tc.id WHERE tc.title = ?  order by giamGia desc";
        List<Food> listFood = null;
        try {
        	listFood = jdbcTemplate.query(sql, new Object[]{title}, new RowMapper<Food>() {
                @Override
                public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
                	
                	Food food = new Food();
                	food.setId(rs.getInt("id"));
                	food.setCategory(rs.getInt("category"));
                	food.setTitle(rs.getString("title"));
                	food.setTenMon(rs.getString("tenMon"));
                	food.setGia(rs.getInt("gia"));
                	food.setGiamGia(rs.getInt("giamGia"));
                	food.setGiaMoi(rs.getInt("giaMoi"));
                	food.setMoTa(rs.getString("moTa"));
                	food.setDaBan(rs.getInt("daBan"));
                	food.setImg(rs.getString("img"));
                	food.setThoiGianTao(rs.getString("thoiGianTao"));
                	food.setThoiGianCapNhat(rs.getString("thoiGianCapNhat"));
                	food.setTrangThai(rs.getInt("trangThai"));
                	return food;
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
	public String getTitle(int id) {
		String sql_login = "Select title from t_food where id = ?";
	      return jdbcTemplate.query(sql_login, new ResultSetExtractor<String>() {
	          @Override
	          public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
	              String title = "";
	              while (resultSet.next()) {
	                  title =  resultSet.getString("title");
	              }
	              return title;
	          }
	      }, id);
	}
	@Override
	public int checkDiscount(int id) {
		String sql_login = "Select trangThai from t_food where id = ?";
	      return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
	          @Override
	          public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
	              int discount = 0;
	              while (resultSet.next()) {
	            	  discount =  resultSet.getInt("trangThai");
	              }
	              return discount;
	          }
	      }, id);
	}
//	int 1id, int 2category, String 3tenMon, String 4title, int 5gia, int 6giamGia, int 7giaMoi, 
	//String 8img,
//	String 9moTa, int 10daBan, String 11thoiGianTao, String 12thoiGianCapNhat, int 13trangThai
	@SuppressWarnings("deprecation")
	@Override
	public List<Food> getFoodById(int id) {
		String sql = "select * from t_food where id = " + id + " limit 1";
        List<Food> listFood = null;
        try {
        	listFood = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Food>() {
                @Override
                public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
                	
                	Food food = new Food();
                	food.setId(rs.getInt("id"));
                	food.setCategory(rs.getInt("category"));
                	food.setTitle(rs.getString("title"));
                	food.setTenMon(rs.getString("tenMon"));
                	food.setGia(rs.getInt("gia"));
                	food.setGiamGia(rs.getInt("giamGia"));
                	food.setGiaMoi(rs.getInt("giaMoi"));
                	food.setMoTa(rs.getString("moTa"));
                	food.setDaBan(rs.getInt("daBan"));
                	food.setImg(rs.getString("img"));
                	food.setThoiGianTao(rs.getString("thoiGianTao"));
                	food.setThoiGianCapNhat(rs.getString("thoiGianCapNhat"));
                	food.setTrangThai(rs.getInt("trangThai"));
                	return food;
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
	public int getCategory(int id) {
		String sql_login = "SELECT category FROM t_food where id = ?";
	      return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
	          @Override
	          public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
	              int category = 0;
	              while (resultSet.next()) {
	            	  category =  resultSet.getInt("category");
	              }
	              return category;
	          }
	      }, id);
	}
	@Override
	public int checkFoodExists(int id) {
		String sql_login = "SELECT id FROM t_food where id = ?";
	      return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
	          @Override
	          public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
	              int food = -1;
	              while (resultSet.next()) {
	            	  food =  resultSet.getInt("id");
	              }
	              return food;
	          }
	      }, id);
	}
	
	@Override
	public void updateSold(int food, int quantity) {
		String sqlString = "UPDATE t_food set daBan = daBan + ? WHERE id = ?";
		System.out.println(jdbcTemplate.update(sqlString, quantity, food));
	}
	 
	@SuppressWarnings("deprecation")
	@Override
	public List<Food> getTop5Sold() {
	    // Kết nối đến csdl và return về list cate
	    String sql = "SELECT * FROM t_food order by(daBan) desc limit 10";
	    List<Food> listFood = null;
	    try {
	    	listFood = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Food>() {
	            @Override
	            public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	
	            	Food food = new Food();
	            	food.setId(rs.getInt("id"));
	            	food.setCategory(rs.getInt("category"));
	            	food.setTitle(rs.getString("title"));
	            	food.setTenMon(rs.getString("tenMon"));
	            	food.setGia(rs.getInt("gia"));
	            	food.setGiamGia(rs.getInt("giamGia"));
	            	food.setGiaMoi(rs.getInt("giaMoi"));
	            	food.setMoTa(rs.getString("moTa"));
	            	food.setDaBan(rs.getInt("daBan"));
	            	food.setImg(rs.getString("img"));
	            	food.setThoiGianTao(rs.getString("thoiGianTao"));
	            	food.setThoiGianCapNhat(rs.getString("thoiGianCapNhat"));
	            	food.setTrangThai(rs.getInt("trangThai"));
	            	return food;
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
	public List<Food> getAnotherFoodByCategory(int category, int food) {
		String sql = "SELECT * FROM t_food WHERE category = ? and id != ?";
		List<Food> list = null;
		try {
			list = jdbcTemplate.query(sql, new Object[] {category,food}, new RowMapper<Food>() {

				@Override
				public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
					Food food = new Food();
					food.setCategory(rs.getInt("category"));
					food.setId(rs.getInt("id"));
					food.setTenMon(rs.getString("tenMon"));
					food.setTitle(rs.getString("title"));
					food.setGia(rs.getInt("gia"));
					food.setGiamGia(rs.getInt("giamGia"));
					food.setGiaMoi(rs.getInt("giaMoi"));
					food.setTrangThai(rs.getInt("trangThai"));
					food.setImg(rs.getString("img"));
					food.setThoiGianTao(rs.getString("thoiGianTao"));
	            	food.setThoiGianCapNhat(rs.getString("thoiGianCapNhat"));
	            	food.setMoTa(rs.getString("moTa"));
	            	food.setDaBan(rs.getInt("daBan"));
					return food;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Food> searchByName(String name) {
		String sql = "select * from t_food where tenMon like ? ";
		List<Food> list = null;
		try {
			list = jdbcTemplate.query(sql, new Object[] {"%"+name+"%"}, new RowMapper<Food>() {

				@Override
				public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
					Food food = new Food();
					food.setId(rs.getInt("id"));
					food.setCategory(rs.getInt("category"));
					food.setTenMon(rs.getString("tenMon"));
					food.setTitle(rs.getString("title"));
					food.setGia(rs.getInt("gia"));
					food.setGiamGia(rs.getInt("giamGia"));
					food.setGiaMoi(rs.getInt("giaMoi"));
					food.setTrangThai(rs.getInt("trangThai"));
					food.setImg(rs.getString("img"));
					food.setMoTa(rs.getString("moTa"));
					food.setDaBan(rs.getInt("daBan"));
					food.setThoiGianTao(rs.getString("thoiGianTao"));
					food.setThoiGianCapNhat(rs.getString("thoiGianCapNhat"));
					return food;
				}
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int foodQuantity() {
		String sql = "select count(*) as sl from t_food";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				int sl = 0;
				while (rs.next()) {
					sl = rs.getInt("sl");
				}
				return sl;
			}
			
		});
	}
	
	@Override
	public void updateLowSold(int food, int quantity) {
		String sqlString = "UPDATE t_food set daBan = daBan - ? WHERE id = ?";
		System.out.println(jdbcTemplate.update(sqlString, quantity, food));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<Food> getAllByCategory(int id) {
	    // Kết nối đến csdl và return về list cate
	    String sql = "select * from t_food where category = ? order by thoiGianTao desc";
	    List<Food> listFood = null;
	    try {
	    	listFood = jdbcTemplate.query(sql, new Object[]{id}, new RowMapper<Food>() {
	            @Override
	            public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	
	            	Food food = new Food();
	            	food.setId(rs.getInt("id"));
	            	food.setCategory(rs.getInt("category"));
	            	food.setTitle(rs.getString("title"));
	            	food.setTenMon(rs.getString("tenMon"));
	            	food.setGia(rs.getInt("gia"));
	            	food.setGiamGia(rs.getInt("giamGia"));
	            	food.setGiaMoi(rs.getInt("giaMoi"));
	            	food.setMoTa(rs.getString("moTa"));
	            	food.setDaBan(rs.getInt("daBan"));
	            	food.setImg(rs.getString("img"));
	            	food.setThoiGianTao(rs.getString("thoiGianTao"));
	            	food.setThoiGianCapNhat(rs.getString("thoiGianCapNhat"));
	            	food.setTrangThai(rs.getInt("trangThai"));
	            	return food;
	            }
	        });
	
	    } catch (Exception e) {
	        e.printStackTrace();
	        return listFood;
	        // TODO: handle exception
	    }
	    return listFood;
	}
}
