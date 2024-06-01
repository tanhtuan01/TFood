package com.tfood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tfood.model.UserDTO;
import com.tfood.service.UserService;

@RestController
public class UserRestController {
	@Autowired
	UserService userService;

//	@RequestMapping(value = "/checkLogIn", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
//	public String Login(@RequestParam(name = "username") String username,
//			@RequestParam(name = "passwords") String passwords) {
//		System.out.println("Username: " + username);
//		System.out.println("Passwords: " + passwords);
//
//		try {
//			userService.Login(username, passwords);
//			return "Ok!";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "failed";
//		}
//
//	}
//
//	@RequestMapping(value = "/ws-listUser", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
//	public String getCategoryList() {
//		List<UserDTO> list = userService.getAll();
//
//		for (UserDTO userDTO : list) {
//			System.out.println(userDTO);
//		}
//
//		Gson gson = new Gson();
//		return gson.toJson(list);
//	}
//
//	
//	@RequestMapping(value = "/test-login", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
//	public String testLogin(@RequestParam(name = "username")String username, @RequestParam(name = "passwords") String passwords) {
//		int tes = 0;
//		try {
//			tes = (Integer) userService.login(username, passwords);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if(tes== 1) {
//			return "admin";
//		}else {
//			if(tes == 0) {
//				return "Không tồn tại tài khoản";
//			}else {
//				return "Nhân viên";
//			}
//		}
//
//	}
//	
//	@RequestMapping(value = "/ws-getInfo", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
//	public String getInfo(@RequestParam(name = "id") int id) {
//		List<UserDTO> list = userService.getInfo(id);
//
//		for (UserDTO userDTO : list) {
//			System.out.println(userDTO);
//		}
//
//		Gson gson = new Gson();
//		return gson.toJson(list);
//	}
}
