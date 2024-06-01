package com.tfood.service;

import java.util.List;

import com.tfood.model.ShipperDTO;
import com.tfood.model.UserDTO;

public interface UserService {

//	List<UserDTO> getAll();
//
//	boolean Login(String username, String passwords);
//
	int login(String phone, String password);
//
	void addUser(UserDTO userDTO);
//	
//	int getIdUser(String username, String password);
//	
//	String getNameUser(int id);
//	
//	String getEmailUser(int id);
//	
//	String getAddress(int id);
//	
//	String getPhoneNumber(int id);
//	
	int checkPhoneExists(String phone);
//	
//	List<UserDTO> getInfo(int user);
//	
//	void updateUser(UserDTO userDTO);
	
	String getNameOfUser(int user);
	
	String getPhoneNumberOfUser(int user);
	
	String getEmailOfUser(int user);
	
	String getPasswordsOfUser(int user);
	
	String getImagesOfUser(int user);
	
	int checkAnotherPhone(String phone, int user);
	
	boolean updateInfoOfUser(UserDTO userDTO);
	
	int checkLoginShipper(String phone, String passwords);
	
	List<ShipperDTO> getAll();
	
	String getAvatar(int user);
}
