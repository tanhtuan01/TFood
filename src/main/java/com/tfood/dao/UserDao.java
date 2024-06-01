package com.tfood.dao;

import java.util.List;

import com.tfood.entity.Shipper;
import com.tfood.entity.User;

public interface UserDao {

//	List<User> getAll();
//
//	boolean Login(String username, String passwords);
//
	int login(String username, String password);
//	
	void addUser(User user);
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
//	List<User> getInfo(int user);
//	
//	void updateUser(User user);
	
	String getNameOfUser(int user);
	
	String getPhoneNumberOfUser(int user);
	
	String getEmailOfUser(int user);
	
	String getPasswordsOfUser(int user);
	
	String getImagesOfUser(int user);
	
	int checkAnotherPhone(String phone, int user);
	
	boolean updateInfoOfUser(User user);
	
	int checkLoginShipper(String phone, String passwords);
	
	List<Shipper> getAll();
	
	String getAvatar(int user);
}
