package com.tfood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfood.dao.UserDao;
import com.tfood.entity.Shipper;
import com.tfood.entity.User;
import com.tfood.model.ShipperDTO;
import com.tfood.model.UserDTO;
import com.tfood.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;

//	@Override
//	public List<UserDTO> getAll() {
//
//		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
//		List<User> listUser = userDao.getAll();
//		for (User user : listUser) {
//			UserDTO userDTO = new UserDTO();
//			userDTO.setId(user.getId());
//			userDTO.setU_name(user.getU_name());
//			userDTO.setU_username(user.getU_username());
//			userDTO.setU_passwords(user.getU_passwords());
//			userDTO.setU_images(user.getU_images());
//			userDTO.setU_level(user.getU_level());
//			userDTO.setCreated_at(user.getCreated_at());
//			userDTO.setUpdated_at(user.getUpdated_at());
//			userDTO.setCreated_by(user.getCreated_by());
//			userDTO.setUpdated_by(user.getUpdated_by());
//			userDTO.setU_address(user.getU_address());
//			userDTO.setU_status(user.getU_status());
//			listUserDTO.add(userDTO);
//		}		
//		return listUserDTO;
//	}
//	
//
//	@Override
//	public boolean Login(String username, String passwords) {
//		return userDao.Login(username, passwords);
//	}
//
//
	@Override
	public int login(String phone, String password) {
		// TODO Auto-generated method stub
		return userDao.login(phone, password);
	}
//
//
	@Override
	public void addUser(UserDTO userDTO) {
		User user = new User();
		user.setTenNguoiDung(userDTO.getTenNguoiDung());
		//user.setDiaChi(userDTO.getDiaChi());
		user.setMatKhau(userDTO.getMatKhau());
		user.setSoDienThoai(userDTO.getSoDienThoai());
		user.setAvatar(userDTO.getAvatar());
		userDao.addUser(user);
	}
//
//
//	@Override
//	public int getIdUser(String username, String password) {
//		// TODO Auto-generated method stub
//		return userDao.getIdUser(username, password);
//	}
//
//
//	@Override
//	public String getNameUser(int id) {
//		// TODO Auto-generated method stub
//		return userDao.getNameUser(id);
//	}
//
//
//	@Override
//	public String getEmailUser(int id) {
//		// TODO Auto-generated method stub
//		return userDao.getEmailUser(id);
//	}
//
//
//	@Override
//	public String getAddress(int id) {
//		// TODO Auto-generated method stub
//		return userDao.getAddress(id);
//	}
//
//
//	@Override
//	public String getPhoneNumber(int id) {
//		// TODO Auto-generated method stub
//		return userDao.getPhoneNumber(id);
//	}
//
//
	@Override
	public int checkPhoneExists(String phone) {
		return userDao.checkPhoneExists(phone);
	}
//
//
//	@Override
//	public List<UserDTO> getInfo(int user) {
//		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
//		List<User> listUser = userDao.getAll();
//		for (User user1 : listUser) {
//			UserDTO userDTO = new UserDTO();
//			userDTO.setId(user1.getId());
//			userDTO.setU_name(user1.getU_name());
//			userDTO.setU_username(user1.getU_username());
//			userDTO.setU_passwords(user1.getU_passwords());
//			userDTO.setU_images(user1.getU_images());
//			userDTO.setU_level(user1.getU_level());
//			userDTO.setCreated_at(user1.getCreated_at());
//			userDTO.setUpdated_at(user1.getUpdated_at());
//			userDTO.setCreated_by(user1.getCreated_by());
//			userDTO.setUpdated_by(user1.getUpdated_by());
//			userDTO.setU_address(user1.getU_address());
//			listUserDTO.add(userDTO);
//		}		
//		return listUserDTO;
//	}
//
//
//	@Override
//	public void updateUser(UserDTO userDTO) {
//		// TODO Auto-generated method stub
//		User user = new User();
//		user.setEmail(userDTO.getEmail());
//		user.setU_address(userDTO.getU_address());
//		user.setU_name(userDTO.getU_name());
//		user.setId(userDTO.getId());
//		//user.setU_username(userDTO.getU_username());
//		userDao.updateUser(user);
//	}
	@Override
	public String getNameOfUser(int user) {
		// TODO Auto-generated method stub
		return userDao.getNameOfUser(user);
	}
	@Override
	public String getPhoneNumberOfUser(int user) {
		// TODO Auto-generated method stub
		return userDao.getPhoneNumberOfUser(user);
	}
	@Override
	public String getEmailOfUser(int user) {
		// TODO Auto-generated method stub
		return userDao.getEmailOfUser(user);
	}
	@Override
	public String getPasswordsOfUser(int user) {
		// TODO Auto-generated method stub
		return userDao.getPasswordsOfUser(user);
	}
	@Override
	public String getImagesOfUser(int user) {
		// TODO Auto-generated method stub
		return userDao.getImagesOfUser(user);
	}
	@Override
	public int checkAnotherPhone(String phone, int user) {
		// TODO Auto-generated method stub
		return userDao.checkAnotherPhone(phone, user);
	}
	@Override
	public boolean updateInfoOfUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setAvatar(userDTO.getAvatar());
		user.setEmail(userDTO.getEmail());
		user.setMatKhau(userDTO.getMatKhau());
		user.setSoDienThoai(userDTO.getSoDienThoai());
		user.setTenNguoiDung(userDTO.getTenNguoiDung());
		user.setId(userDTO.getId());
		return userDao.updateInfoOfUser(user);
	}
	@Override
	public int checkLoginShipper(String phone, String passwords) {
		// TODO Auto-generated method stub
		return userDao.checkLoginShipper(phone, passwords);
	}
	@Override
	public List<ShipperDTO> getAll() {
		// TODO Auto-generated method stub
		List<Shipper> list = userDao.getAll();
		List<ShipperDTO> list2 = new ArrayList<ShipperDTO>();
		for(Shipper shipper : list) {
			ShipperDTO shipperDTO = new ShipperDTO();
			shipperDTO.setAvatar(shipper.getAvatar());
			shipperDTO.setId(shipper.getId());
			shipperDTO.setTen(shipper.getTen());
			shipperDTO.setSoDienThoai(shipper.getSoDienThoai());
			shipperDTO.setMatKhau(shipper.getMatKhau());
			shipperDTO.setDanhGia(shipper.getDanhGia());
			shipperDTO.setThoiGianTao(shipper.getThoiGianTao());
			shipperDTO.setThoiGianCapNhat(shipper.getThoiGianCapNhat());
			list2.add(shipperDTO);
		}
		return list2;
	}
	@Override
	public String getAvatar(int user) {
		// TODO Auto-generated method stub
		return userDao.getAvatar(user);
	}

}
