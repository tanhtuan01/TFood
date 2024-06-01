package com.tfood.controller;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.google.gson.Gson;
import com.tfood.model.CategoryDTO;
import com.tfood.service.CategoryService;

@RestController
public class CategoryRestController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ServletContext context;
	@RequestMapping(value = "/ws-listCategory", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String getCategoryList() {
		// Gọi service để lấy danh sách danh mục
		List<CategoryDTO> list = categoryService.getAll();
		for (CategoryDTO userDTO : list) {
			System.out.println(userDTO);
		}
		// gửi list ra view
		Gson gson = new Gson();
		// return new ResponseEntity<List<CategoryDTO>>(list, HttpStatus.OK);
		return gson.toJson(list);
	}

	@RequestMapping(value = "/ws-searchCategory", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String getCategoryList2(@RequestParam(name = "name")String name) {
		// Gọi service để lấy danh sách danh mục
		List<CategoryDTO> list = categoryService.searchCategory(name);
		for (CategoryDTO userDTO : list) {
			System.out.println(userDTO);
		}
		// gửi list ra view
		Gson gson = new Gson();
		// return new ResponseEntity<List<CategoryDTO>>(list, HttpStatus.OK);
		return gson.toJson(list);
	}

	
//	@RequestMapping(value = "/add-category", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//	public String addCategory(@RequestParam(name = "name") String name, 
//							  @RequestParam(name = "avatar") MultipartFile avatar) throws IllegalStateException, IOException {
//		CategoryDTO categoryDTO = new CategoryDTO();
//		categoryDTO.setName(name);
//		String avString = avatar.getOriginalFilename();
//		categoryDTO.setAvatar(avString);
//		//categoryDTO.setAvatar(new UploadFile().UploadFile(context, "/resources/images", avatar));
//															
//		//
//		Path path = Paths.get("C://Users//VINHHOA//Desktop//Work_space//OrderFood//src//main//webapp//resources//images//");
//		InputStream inputStream = avatar.getInputStream();
//		Files.copy(inputStream, path.resolve(avatar.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
//		
//		System.out.println("Name: " + categoryDTO.getName());
//		try {
//			categoryService.addCategory(categoryDTO);
//			return "success";
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//		return "error";
//	}
//
//	@RequestMapping(value = "/update-category", method = RequestMethod.POST)
//	public String addCategory(@RequestParam(name = "id") int id, @RequestParam(name = "name") String name,
//			@RequestParam(name = "avatar") String avatar) {
//		CategoryDTO categoryDTO = new CategoryDTO();
//		categoryDTO.setId(id);
//		categoryDTO.setName(name);
//		categoryDTO.setAvatar(avatar);
//		try {
//			categoryService.update(categoryDTO);
//			return "success";
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//		return "error";
//	}
//
//	@RequestMapping(value = "/update-category-param", method = RequestMethod.POST)
//	public String addCategory3Param(@RequestParam(name = "id") int id, @RequestParam(name = "name") String name,
//			@RequestParam(name = "avatar") String avatar) {
//		try {
//			categoryService.update(id, name, avatar);
//			return "success";
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return "error";
//	}
//
//	@RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
//	public String addCategory3Param(@RequestParam(name = "id") int id) {
//		try {
//			categoryService.delete(id);
//			return "success";
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return "error";
//	}
//
//	@RequestMapping(value = "/find-category", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
//	public String getUserListLikeName(@RequestParam(name = "name") String name) {
//		// Gọi service để lấy danh sách người dùng
//		List<CategoryDTO> list = categoryService.findByName(name);
//		for (CategoryDTO userDTO : list) {
//			System.out.println(userDTO);
//		}
//		// gửi list ra view
//		Gson gson = new Gson();
//		return gson.toJson(list);
//	}
//	
//	@RequestMapping(value = "/update-categoryInfo", method = RequestMethod.GET)
//	public String updateString(@RequestParam(name="name") String name, @RequestParam(name="avatar")String avatar,
//			@RequestParam(name="id")int id) {
//		CategoryDTO categoryDTO = new CategoryDTO();
//		categoryDTO.setName(name);
//		categoryDTO.setAvatar(avatar);
//		categoryDTO.setId(id);
//		try {
//			categoryService.updateCategory(categoryDTO);
//			return "success";
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//				return "error";
//		
//	}
	
}
