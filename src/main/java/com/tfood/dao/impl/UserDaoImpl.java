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

import com.tfood.dao.UserDao;
import com.tfood.entity.Shipper;
import com.tfood.entity.User;



@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
//	@SuppressWarnings("deprecation")
//	@Override
//	public List<User> getAll() {
//		String sql = "select * from tb_users";
//		@SuppressWarnings("deprecation")
//		List<User> listUser = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<User>() {
//			@Override
//		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//			User user = new User();
//			user.setId(rs.getInt("id"));
//			user.setU_name(rs.getString("user_name"));
//			user.setU_username(rs.getString("user_username"));
//			user.setU_passwords(rs.getString("user_passwords"));
//			user.setU_images(rs.getString("user_images"));
//			user.setU_address(rs.getString("user_address"));
//			user.setU_level(rs.getInt("user_level"));
//			user.setCreated_at(rs.getString("created_at"));
//			user.setUpdated_at(rs.getString("updated_at"));
//			user.setCreated_by(rs.getInt("created_by"));
//			user.setUpdated_by(rs.getInt("updated_by"));
//			user.setU_status(rs.getInt("user_status"));
//			return user;
//		}});
//		return listUser;
//	}
//	
//	@Override
//	public boolean Login(String username, String passwords) {
//		String sql_login = "Select count(id) as c_user from tb_users where user_username = ? and user_passwords = ?";
//		return (jdbcTemplate.update(sql_login, username, passwords) > 0);
//
//	}
//	
//
	@Override
    public int login(String phone, String password) {
        String sql_login = "Select id from t_users where soDienThoai = ? and matKhau = ? and trangThai = 1";
        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int id = -1;
                while (resultSet.next()) {
                    id =  resultSet.getInt("id");
                }
                return id;
            }
        }, phone, password);
    }

	@Override
	public void addUser(User user) {
		String sqlString = "INSERT INTO t_users(tenNguoiDung,soDienThoai,matKhau,avatar,trangThai,thoiGianTao) VALUES (?,?,?,?,1,now())";
		System.out.println(jdbcTemplate.update(sqlString,
				user.getTenNguoiDung(),user.getSoDienThoai(),user.getMatKhau(),user.getAvatar()));
		System.out.println("=>Add User: OK");
	}
//
//	@Override
//	public int getIdUser(String username, String password) {
//		 String sql_login = "Select id from tb_users where user_username = ? and user_passwords = ?";
//	        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
//	            @Override
//	            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//	                int id = -1;
//	                while (resultSet.next()) {
//	                    id =  resultSet.getInt("id");
//	                }
//	                System.out.println("user_id : " + id);
//	                return id;
//	            }
//	        },username,password);
//	
//	}
//
//	@Override
//	public String getNameUser(int id) {
//		 String sql_login = "SELECT user_name FROM tb_users where id = ?";
//	        return jdbcTemplate.query(sql_login, new ResultSetExtractor<String>() {
//	            @Override
//	            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//	                String nameString = "";
//	                while (resultSet.next()) {
//	                    nameString =  resultSet.getString("user_name");
//	                }
//	               
//	                return nameString;
//	            }
//	        },id);
//	}
//
//	@Override
//	public String getEmailUser(int id) {
//		String sql_login = "SELECT user_email FROM tb_users where id = ?";
//        return jdbcTemplate.query(sql_login, new ResultSetExtractor<String>() {
//            @Override
//            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                String nameString = "";
//                while (resultSet.next()) {
//                    nameString =  resultSet.getString("user_email");
//                }
//               
//                return nameString;
//            }
//        },id);
//	}
//
//	@Override
//	public String getAddress(int id) {
//		String sql_login = "SELECT user_address FROM tb_users where id = ?";
//        return jdbcTemplate.query(sql_login, new ResultSetExtractor<String>() {
//            @Override
//            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                String nameString = "";
//                while (resultSet.next()) {
//                    nameString =  resultSet.getString("user_address");
//                }
//               
//                return nameString;
//            }
//        },id);
//	}
//
//	@Override
//	public String getPhoneNumber(int id) {
//		String sql_login = "SELECT user_username FROM tb_users where id = ?";
//        return jdbcTemplate.query(sql_login, new ResultSetExtractor<String>() {
//            @Override
//            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                String nameString = "";
//                while (resultSet.next()) {
//                    nameString =  resultSet.getString("user_username");
//                }
//               
//                return nameString;
//            }
//        },id);
//	}
//
	@Override
	public int checkPhoneExists(String phone) {
		 String sql_login = "SELECT id FROM t_users WHERE soDienThoai = ?";
			return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
			    @Override
			    public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			        int id = -1;
			        while (resultSet.next()) {
			            id =  resultSet.getInt("id");
			        }
			        return id;
			    }
			},phone);
	}
//
//	@SuppressWarnings("deprecation")
//	@Override
//	public List<User> getInfo(int user) {
//		String sql = "select * from tb_users where id = '"+user+"'";
//		@SuppressWarnings("deprecation")
//		List<User> listUser = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<User>() {
//			@Override
//		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//			User user = new User();
//			user.setId(rs.getInt("id"));
//			user.setU_name(rs.getString("user_name"));
//			user.setU_username(rs.getString("user_username"));
//			user.setU_passwords(rs.getString("user_passwords"));
//			user.setU_images(rs.getString("user_images"));
//			user.setU_address(rs.getString("user_address"));
//			user.setU_level(rs.getInt("user_level"));
//			user.setCreated_at(rs.getString("created_at"));
//			user.setUpdated_at(rs.getString("updated_at"));
//			user.setCreated_by(rs.getInt("created_by"));
//			user.setUpdated_by(rs.getInt("updated_by"));
//			
//			return user;
//		}});
//		return listUser;
//	}
//
//	@Override
//	public void updateUser(User user) {
//		// TODO Auto-generated method stub
//		String sqlString = "update tb_users set user_name = ?, user_email =?, user_address =? where id = ?";
//		System.out.println(jdbcTemplate.update(sqlString,user.getU_name(),user.getEmail(),user.getU_address(),user.getId()));
//	}

	@Override
	public String getNameOfUser(int user) {
		String sql = "SELECT tenNguoiDung FROM t_users WHERE id = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                String name = "";
                while (resultSet.next()) {
                	name =  resultSet.getString("tenNguoiDung");
                }
                return name;
            }
        },user);
	}

	@Override
	public String getPhoneNumberOfUser(int user) {
		String sql = "SELECT soDienThoai FROM t_users WHERE id = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                String soDienThoai = "";
                while (resultSet.next()) {
                	soDienThoai =  resultSet.getString("soDienThoai");
                }
                return soDienThoai;
            }
        },user);
	}

	@Override
	public String getEmailOfUser(int user) {
		String sql = "SELECT email FROM t_users WHERE id = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                String email = null;
                while (resultSet.next()) {
                	email =  resultSet.getString("email");
                }
                return email;
            }
        },user);
	}

	@Override
	public String getPasswordsOfUser(int user) {
		String sql = "SELECT matKhau FROM t_users WHERE id = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                String matKhau = "";
                while (resultSet.next()) {
                	matKhau =  resultSet.getString("matKhau");
                }
                return matKhau;
            }
        },user);
	}

	@Override
	public String getImagesOfUser(int user) {
		String sql = "SELECT avatar FROM t_users WHERE id = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                String avatar = "";
                while (resultSet.next()) {
                	avatar =  resultSet.getString("avatar");
                }
                return avatar;
            }
        },user);
	}

	@Override
	public int checkAnotherPhone(String phone, int user) {
		String sql = "SELECT id FROM t_users where soDienThoai = ? and id != ?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
		    @Override
		    public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		        int id = -1;
		        while (resultSet.next()) {
		            id =  resultSet.getInt("id");
		        }
		        return id;
		    }
		},phone, user);
	}

	@Override
	public boolean updateInfoOfUser(User user) {
		String sql = "UPDATE t_users set tenNguoiDung = ?, soDienThoai = ?, matKhau = ?, email = ?, avatar = ? , thoiGianCapNhat = now() where id = ? ";
		return (jdbcTemplate.update(sql,user.getTenNguoiDung(),user.getSoDienThoai(),user.getMatKhau(),user.getEmail(),user.getAvatar(),user.getId()) > 0);
	}

	@Override
	public int checkLoginShipper(String phone, String passwords) {
		 String sql_login = "Select id from t_shipper where soDienThoai = ? and matKhau = ?";
	        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
	            @Override
	            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
	                int id = -1;
	                while (resultSet.next()) {
	                    id =  resultSet.getInt("id");
	                }
	                return id;
	            }
	        }, phone, passwords);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Shipper> getAll() {
		String sql = "select * from t_shipper";
		@SuppressWarnings("deprecation")
		List<Shipper> listUser = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Shipper>() {
			@Override
		public Shipper mapRow(ResultSet rs, int rowNum) throws SQLException {
			Shipper user = new Shipper();
			user.setId(rs.getInt("id"));
			user.setAvatar(rs.getString("avatar"));
			user.setTen(rs.getString("ten"));
			user.setSoDienThoai(rs.getString("soDienThoai"));
			user.setMatKhau(rs.getString("matKhau"));
			user.setDanhGia(rs.getDouble("danhGia"));
			user.setThoiGianTao(rs.getString("thoiGianTao"));
			user.setThoiGianCapNhat(rs.getString("thoiGianCapNhat"));
			return user;
		}});
		return listUser;
	}

	@Override
	public String getAvatar(int user) {
		String sql = "SELECT avatar FROM t_users WHERE id = ?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				String avt = "";
				while (rs.next()) {
					avt = rs.getString("avatar");
				}
				return avt;
			}
			
		}, user);
	}


}
