//package com.tfood.controller;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.http.HttpRequest;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.google.gson.Gson;
//import com.tfood.model.FoodDTO;
//import com.tfood.service.FoodService;
//
//@RestController
//public class FoodRestController {
//	@Autowired
//	FoodService foodService;
//	HttpRequest request;
//	@RequestMapping(value = "/ws-listFood", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
//	public String getFoodList() {
//
//		List<FoodDTO> list = foodService.getAll();
//		for (FoodDTO userDTO : list) {
//			System.out.println(userDTO);
//		}
//		// gửi list ra view
//		Gson gson = new Gson();
//		// return new ResponseEntity<List<CategoryDTO>>(list, HttpStatus.OK);
//		return gson.toJson(list);
//	}
//	
//	@RequestMapping(value = "/add-food", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//	public String addFood(
//		
//			@RequestParam(name = "name") String name, 
//			@RequestParam(name = "avatar") MultipartFile avatar, 
//			@RequestParam(name="cateId") int cateId, 
//			@RequestParam(name="price") int price, 
//			@RequestParam(name="status",required = true, defaultValue = "Open") int status
//			) 
//			throws IllegalStateException, IOException {
//		
//		FoodDTO foodDTO = new FoodDTO();
//		foodDTO.setName(name);
////		String avString = avatar.getOriginalFilename();
//		foodDTO.setAvatar(avatar.getOriginalFilename());
//		foodDTO.setCateId(cateId);
//		foodDTO.setPrice(price);
//		foodDTO.setStatus(status);
//		
//		System.out.println(foodDTO);
//		
//		Path path = Paths.get("C://Users//VINHHOA//Desktop//Work_space//OrderFood//src//main//webapp//resources//images//");
//		InputStream inputStream = avatar.getInputStream();
//		Files.copy(inputStream, path.resolve(avatar.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
//			
//		try {
//			foodService.addFood(foodDTO);
//			return "success";
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//		return "error";
//	}
//	
//	@RequestMapping(value = "/ws-listFoodbycate", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
//	public String getFoodListbycate(@RequestParam(name="id")int id) {
//
//		List<FoodDTO> list = foodService.getAllbyCategory(id);
//		for (FoodDTO foodDTO : list) {
//			System.out.println(foodDTO);
//		}
//		// gửi list ra view
//		Gson gson = new Gson();
//		// return new ResponseEntity<List<CategoryDTO>>(list, HttpStatus.OK);
//		return gson.toJson(list);
//	}
//	
//	@RequestMapping(value = "/ws-updateFood", method = RequestMethod.POST, produces ="text/plain;charset=UTF-8" )
//	public String updateFoodString(@RequestParam(name = "name") String name,
//								   @RequestParam(name = "avatar") String avatar,
//								   @RequestParam(name = "cateid") int cateid,
//								   @RequestParam(name = "price") int price,
//								   @RequestParam(name = "status") int status,
//								   @RequestParam(name = "description") String description,
//								   @RequestParam(name = "id") int id) {
//		FoodDTO foodDTO = new FoodDTO();
//		foodDTO.setName(name);
//		foodDTO.setAvatar(avatar);
//		foodDTO.setCateId(cateid);
//		foodDTO.setPrice(price);
//		foodDTO.setStatus(status);
//		foodDTO.setDescription(description);
//		foodDTO.setId(id);
//		try {
//			foodService.updateFood(foodDTO);
//			return "update ok";
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return "error";
//	}
//	
//	
//	
//	@RequestMapping(value = "/ws-foodbyId", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
//	public String getFoodbyId(@RequestParam(name="id")int id) {
//
//		List<FoodDTO> list = foodService.getFoodbyId(id);
//		for (FoodDTO foodDTO : list) {
//			System.out.println(foodDTO);
//		}
//		// gửi list ra view
//		Gson gson = new Gson();
//		// return new ResponseEntity<List<CategoryDTO>>(list, HttpStatus.OK);
//		return gson.toJson(list);
//	}
//	
//	
//	@RequestMapping(value = "/ws-topSold", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
//	public String gettopSold() {
//
//		List<FoodDTO> list = foodService.getTopSold();
//		for (FoodDTO userDTO : list) {
//			System.out.println(userDTO);
//		}
//		// gửi list ra view
//		Gson gson = new Gson();
//		// return new ResponseEntity<List<CategoryDTO>>(list, HttpStatus.OK);
//		return gson.toJson(list);
//	}
//	
//	
//	@RequestMapping(value = "/ws-listFoodDeal", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
//	public String getFoodDeal(@RequestParam(name="id")int id) {
//
//		List<FoodDTO> list = foodService.getFood9Deal(id);
//		for (FoodDTO foodDTO : list) {
//			System.out.println(foodDTO);
//		}
//		// gửi list ra view
//		Gson gson = new Gson();
//		// return new ResponseEntity<List<CategoryDTO>>(list, HttpStatus.OK);
//		return gson.toJson(list);
//	}
//	
//	
//	@RequestMapping(value = "/ws-listFoodDealbyCategory", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
//	public String getFoodDealbyCategory(@RequestParam(name="id")int id) {
//
//		List<FoodDTO> list = foodService.getFood9Deal(id);
//		for (FoodDTO foodDTO : list) {
//			System.out.println(foodDTO);
//		}
//		// gửi list ra view
//		Gson gson = new Gson();
//		// return new ResponseEntity<List<CategoryDTO>>(list, HttpStatus.OK);
//		return gson.toJson(list);
//	}
//	
//	@RequestMapping(value = "/ws-listFoodbyName", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
//	public String getbyName(@RequestParam(name="name")String name) {
//
//		List<FoodDTO> list = foodService.getByName(name);
//		
//		// gửi list ra view
//		Gson gson = new Gson();
//		// return new ResponseEntity<List<CategoryDTO>>(list, HttpStatus.OK);
//		return gson.toJson(list);
//	}
//}
