package com.tfood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tfood.model.ShipperDTO;
import com.tfood.service.UserService;

@RestController
public class ShipperRestController {

	@Autowired
	UserService userService;
	
	@GetMapping(value = "/json/shipper/{phone}/{passwords}")
	public String shipperLogin(@PathVariable("phone")String phone, 
							   @PathVariable("passwords")String passwords) {
		int check= userService.checkLoginShipper(phone, passwords);
		String result = String.valueOf(check);
		return result;	
	}
	
	@GetMapping(value = "/json/shipper/getall", produces = "text/plain;charset=UTF-8")
	public String getAll() {
		Gson gson = new Gson();
		List<ShipperDTO> list = userService.getAll();
		return gson.toJson(list);
	}
	
}
