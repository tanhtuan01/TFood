package com.tfood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tfood.model.CommentDTO;
import com.tfood.service.CommentService;

@RestController
public class CommentRestController {
	@Autowired
	CommentService commentService;
	
//	@RequestMapping(value = "/ws-listComment", method = RequestMethod.GET)
//	public String listOrderDetail(@RequestParam(name = "id") int id) {
//		List<CommentDTO> list = commentService.getByFood(id);
//		Gson gson = new Gson();
//		return gson.toJson(list);
//	}
	
}
