package com.tfood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tfood.model.CartDTO;
import com.tfood.model.OrderDetailDTO;
import com.tfood.service.CartService;
import com.tfood.service.CategoryService;
import com.tfood.service.CommentService;
import com.tfood.service.OrderDetailService;

@RestController
public class CartRestController {
	@Autowired
	CartService cartService;
	@Autowired
	OrderDetailService orderDetailService;
	@Autowired
	CommentService commentService;
	
//	@RequestMapping(value = "/ws-listCart", method = RequestMethod.GET)
//	public String listCart(@RequestParam(name = "id") int id) {
//		List<CartDTO> list = cartService.getAll(id);
//		Gson gson = new Gson();
//		return gson.toJson(list);
//	}
//	
//	@RequestMapping(value = "/ws-OrderDetail", method = RequestMethod.GET)
//	public String listOrderDetail() {
//		List<OrderDetailDTO> list = orderDetailService.waitForShip();
//		Gson gson = new Gson();
//		return gson.toJson(list);
//	}
//	
//	@RequestMapping(value = "/orderOK" , method = RequestMethod.GET)
//	public String listok(@RequestParam(name = "id") int id) {
//		List<OrderDetailDTO> list = orderDetailService.orderSuccess(id);
//		Gson gson = new Gson();
//		return gson.toJson(list);
//	}
	
	@GetMapping(value = "/apiCartService")
	public String cartService() {
		Gson gson = new Gson();
		List<CartDTO> list = cartService.getAllByUser(1);
		return gson.toJson(list);
	}
}
