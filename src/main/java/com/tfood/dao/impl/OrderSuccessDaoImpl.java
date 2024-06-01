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

import com.tfood.dao.OrderSuccessDao;
import com.tfood.entity.OrderSuccess;

@Repository
public class OrderSuccessDaoImpl implements OrderSuccessDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void add(OrderSuccess orderSuccess) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO t_order_success(userId,tongTienSP,phiShip,tongTien,orderCode,note,status,address,districtValue,wardValue,thoiGianTao) VALUES (?,?,?,?,?,?,0,?,?,?,now())";
		jdbcTemplate.update(sql, orderSuccess.getUser(),orderSuccess.getTotalPriceFood(),orderSuccess.getPriceShip(),
				orderSuccess.getTotalPrice(),orderSuccess.getOrderCode(),orderSuccess.getNote(),
				orderSuccess.getAddress(),orderSuccess.getDistrictValue(),orderSuccess.getWardValue());
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<OrderSuccess> getAll() {
		String sql = "SELECT tos.id,tu.tenNguoiDung,tu.soDienThoai,tos.address,tw.wardName,td.districtName,tos.tongTienSP,tos.phiShip,tos.tongTien,tos.note,tos.status,tos.orderCode,tos.thoiGianTao\r\n"
				+ "	from t_order_success tos \r\n"
				+ "	inner join t_users tu \r\n"
				+ "	on tos.userId = tu.id\r\n"
				+ "	inner join t_ward tw\r\n"
				+ "	on tos.wardValue = tw.wardValue\r\n"
				+ "	inner join t_district td\r\n"
				+ "	on tos.districtValue = td.districtValue\r\n"
				+ "	where tos.wardValue = tw.wardValue and tos.districtValue = tw.districtValue order by (tos.thoiGianTao) desc ";
		@SuppressWarnings("deprecation")
		List<OrderSuccess> listOrderSuccess = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<OrderSuccess>() {
			@Override
		public OrderSuccess mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderSuccess orderSuccess = new OrderSuccess();
				orderSuccess.setId(rs.getInt("id"));
				orderSuccess.setAddress(rs.getString("address"));
				orderSuccess.setWardName(rs.getString("wardName"));
				orderSuccess.setDistrictName(rs.getString("districtName"));
				orderSuccess.setTotalPriceFood(rs.getInt("tongTienSP"));
				orderSuccess.setTotalPrice(rs.getInt("tongTien"));
				orderSuccess.setPriceShip(rs.getInt("phiShip"));
				orderSuccess.setNote(rs.getString("note"));
				orderSuccess.setOrderCode(rs.getString("orderCode"));
				orderSuccess.setDate(rs.getString("thoiGianTao"));
				orderSuccess.setStatus(rs.getInt("status"));
				orderSuccess.setUserName(rs.getString("tenNguoiDung"));
				orderSuccess.setPhone(rs.getString("soDienThoai"));
			return orderSuccess;
		}});
		return listOrderSuccess;
	}

	@Override
	public int checkOrderCodeExists(String orderCode) {
		 String sql_login = "SELECT id from t_order_success WHERE orderCode = ?";
	        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
	            @Override
	            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
	                int id = -1;
	                while (resultSet.next()) {
	                    id =  resultSet.getInt("id");
	                }
	                return id;
	            }
        }, orderCode);
	}

	@Override
	public boolean confirmOrder(String orderCode) {
		String sql_update = "UPDATE t_order_success set status = 1 WHERE orderCode = ?";
        return (jdbcTemplate.update(sql_update, orderCode) > 0);
	}

	@Override
	public String getNote(String orderCode) {
		String sql = "SELECT note from t_order_success WHERE orderCode = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                String note = "";
                while (resultSet.next()) {
                	note =  resultSet.getString("note");
                }
                return note;
            }
        }, orderCode);
	}

	@Override
	public int checkStatus(String orderCode) {
		String sql_login = "SELECT status from t_order_success WHERE orderCode = ?";
        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int id = -1;
                while (resultSet.next()) {
                    id =  resultSet.getInt("status");
                }
                return id;
            }
        }, orderCode);
	}

	@Override
	public boolean cancelOrder(String orderCode) {
		String sql_update = "UPDATE t_order_success set status = 4 WHERE orderCode = ?";
        return (jdbcTemplate.update(sql_update, orderCode) > 0);
	}

	@Override
	public int revenue() {
		String sql = "SELECT sum(tongTienSP) as tongtien from t_order_success WHERE status = 3";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
			@Override
			public Integer extractData(ResultSet resultSet) throws SQLException,DataAccessException {
				int tongtien = 0;
				 while (resultSet.next()) {
					 tongtien =  resultSet.getInt("tongtien");
	                }
                return tongtien;
			}
		});
	}

	@Override
	public int revenueToDay(int day, int month, int year) {
		String sql = "SELECT sum(tongTienSP)as tongtien from t_order_success\r\n"
				+ "where  day(thoiGianCapNhat) = ? and month(thoiGianCapNhat) = ? and year(thoiGianCapNhat) = ?"
				+ " and status = 3";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int id =0;
                while (resultSet.next()) {
                    id =  resultSet.getInt("tongtien");
                }
                return id;
            }
    }, day,month,year);
	}

	@Override
	public List<OrderSuccess> getMyOrderSuccess(int user) {
		String sql = "SELECT id, userId, orderCode, tongTienSP,status, thoiGianTao\r\n"
				+ "FROM t_order_success tos\r\n"
				+ "WHERE userId = ? and status = 3";
		@SuppressWarnings("deprecation")
		List<OrderSuccess> listOrderSuccess = jdbcTemplate.query(sql, new Object[] {user}, new RowMapper<OrderSuccess>() {
			@Override
		public OrderSuccess mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderSuccess orderSuccess = new OrderSuccess();
				orderSuccess.setId(rs.getInt("id"));
				orderSuccess.setOrderCode(rs.getString("orderCode"));
				orderSuccess.setTotalPrice(rs.getInt("tongTienSP"));
				orderSuccess.setStatus(rs.getInt("status"));
				orderSuccess.setDate(rs.getString("thoiGianTao"));
				orderSuccess.setUser(rs.getInt("userId"));
				return orderSuccess;
		}});
		return listOrderSuccess;
	}

	@Override
	public int getPriceShip(String orderCode) {
		String sql_login = "SELECT phiShip from t_order_success WHERE orderCode  = ?";
        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int phiShip = 0;
                while (resultSet.next()) {
                	phiShip =  resultSet.getInt("phiShip");
                }
                return phiShip;
            }
        }, orderCode);
	}

	@Override
	public int getTotalPriceFood(String orderCode) {
		String sql_login = "SELECT tongTienSP FROM t_order_success WHERE orderCode =  ?";
        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int tongTienSP = 0;
                while (resultSet.next()) {
                	tongTienSP =  resultSet.getInt("tongTienSP");
                }
                return tongTienSP;
            }
        }, orderCode);
	}

	@Override
	public int getTotalPrice(String orderCode) {
		String sql_login = "SELECT tongTien FROM t_order_success WHERE orderCode =  ?";
        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int tongTien = 0;
                while (resultSet.next()) {
                	tongTien =  resultSet.getInt("tongTien");
                }
                return tongTien;
            }
        }, orderCode);
	}

	@Override
	public String getOrderDate(String orderCode) {
		String sql = "SELECT thoiGianTao FROM t_order_success WHERE orderCode = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                String thoiGianTao = "";
                while (resultSet.next()) {
                	thoiGianTao =  resultSet.getString("thoiGianTao");
                }
                return thoiGianTao;
            }
        }, orderCode);
	}

	@Override
	public int getStatus(String orderCode) {
		String sql_login = "SELECT status FROM t_order_success WHERE orderCode =  ?";
        return jdbcTemplate.query(sql_login, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int status = 0;
                while (resultSet.next()) {
                	status =  resultSet.getInt("status");
                }
                return status;
            }
        }, orderCode);
	}

	@Override
	public boolean orderSuccess(String orderCode) {
		String sql_update = "UPDATE t_order_success set status = 3, thoiGianCapNhat = now() WHERE orderCode = ?";
        return (jdbcTemplate.update(sql_update, orderCode) > 0);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<OrderSuccess> getAllMyOrder(int user) {
		String sql = "SELECT id, userId, orderCode, tongTienSP,status, thoiGianTao\r\n"
				+ "FROM t_order_success tos\r\n"
				+ "WHERE userId = ? ";
		List<OrderSuccess> list = null;
		try {
			list = jdbcTemplate.query(sql, new Object[] {user}, new RowMapper<OrderSuccess>() {

				@Override
				public OrderSuccess mapRow(ResultSet rs, int rowNum) throws SQLException {
					OrderSuccess orderSuccess = new OrderSuccess();
					orderSuccess.setId(rs.getInt("id"));
					orderSuccess.setOrderCode(rs.getString("orderCode"));
					orderSuccess.setTotalPrice(rs.getInt("tongTienSP"));
					orderSuccess.setStatus(rs.getInt("status"));
					orderSuccess.setDate(rs.getString("thoiGianTao"));
					orderSuccess.setUser(rs.getInt("userId"));
					return orderSuccess;
				}
				
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<OrderSuccess> getMyOrderCancel(int user) {
		String sql = "SELECT id, userId, orderCode, tongTienSP,status, thoiGianTao\r\n"
				+ "FROM t_order_success tos\r\n"
				+ "WHERE userId = ? and status = 4";
		List<OrderSuccess> list = jdbcTemplate.query(sql, new Object[] {user}, new RowMapper<OrderSuccess>() {

			@Override
			public OrderSuccess mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderSuccess orderSuccess = new OrderSuccess();
				orderSuccess.setId(rs.getInt("id"));
				orderSuccess.setOrderCode(rs.getString("orderCode"));
				orderSuccess.setTotalPrice(rs.getInt("tongTienSP"));
				orderSuccess.setStatus(rs.getInt("status"));
				orderSuccess.setDate(rs.getString("thoiGianTao"));
				orderSuccess.setUser(rs.getInt("userId"));
				return orderSuccess;
			}
			
		});
		return list;
	}

	@Override
	public int quantityOfSuccessOrder() {
		String sql = "SELECT COUNT(*) as gd FROM t_order_success WHERE status = 3";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				int gd = 0;
				while(rs.next()) {
					gd = rs.getInt("gd");
				}
				return gd;
			}
			
		});
	}
	
	@Override
	public int quantityOfCancelOrder() {
		String sql = "SELECT COUNT(*) as gd FROM t_order_success WHERE status = 4";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				int gd = 0;
				while(rs.next()) {
					gd = rs.getInt("gd");
				}
				return gd;
			}
			
		});
	}
	
	@Override
	public int quantityOfOrder() {
		String sql = "SELECT COUNT(*) as gd FROM t_order_success";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				int gd = 0;
				while(rs.next()) {
					gd = rs.getInt("gd");
				}
				return gd;
			}
			
		});
	}
	
	@Override
	public int quantityOfAnotherOrder() {
		String sql = "SELECT COUNT(*) as gd FROM t_order_success where status not in(3,4)";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				int gd = 0;
				while(rs.next()) {
					gd = rs.getInt("gd");
				}
				return gd;
			}
			
		});
	}
	
}
