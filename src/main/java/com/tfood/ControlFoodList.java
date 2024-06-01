//package com.tfood;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//import java.util.List;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.tfood.model.CategoryDTO;
//import com.tfood.model.FoodDTO;
//import com.tfood.service.CategoryService;
//import com.tfood.service.FoodService;
//
//@Controller
//@RequestMapping("/admin")
//public class ControlFoodList {
//	@Autowired
//	FoodService foodService;
//	String statuString = "";
//	String status2 = "";
//	@Autowired
//	CategoryService categoryService;
//	
//	@RequestMapping("/web-foodList")
//	public String GridFoodList(Model model) {
//		List<FoodDTO> list = foodService.getAll();
//		List<CategoryDTO> list2 = categoryService.getAll();
//		model.addAttribute("Food",list);
//		model.addAttribute("Category", list2);
//		model.addAttribute("status", statuString);
//		status2 = "Toàn bộ";
//		model.addAttribute("status2", status2);
//		return "/admin/list-food-grid";
//	}
//	@RequestMapping("/web-foodList-styleList")
//	public String ListFoodList(Model model) {
//		List<FoodDTO> list = foodService.getAll();
//		List<CategoryDTO> list2 = categoryService.getAll();
//		model.addAttribute("Category", list2);
//		model.addAttribute("status", statuString);
//		model.addAttribute("Food",list);
//		status2 = "Toàn bộ";
//		model.addAttribute("status2", status2);
//		return "/admin/list-food-list";
//	}
//	
//	@RequestMapping("/web-addFood")
//	public String ADDFOOD(Model model) {
//		statuString = "";
//		List<CategoryDTO> list = categoryService.getAll();
//		model.addAttribute("Cate",list);
//		return "/admin/add-food";
//	}
//	
//	@RequestMapping(value = "/addFood", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//	public String addFood(
//			@RequestParam(name = "name") String name, 
//			@RequestParam(name = "avatar") MultipartFile avatar, 
//			@RequestParam(name="cateId") int cateId, 
//			@RequestParam(name="price") int price, 
//			@RequestParam(name="status",required = true, defaultValue = "1") int status,
//			@RequestParam(name = "discount") int discount,
//			@RequestParam(name="description") String description) 
//			throws IllegalStateException, IOException {
//		FoodDTO foodDTO = new FoodDTO();
//		foodDTO.setName(name);
//		foodDTO.setAvatar(avatar.getOriginalFilename());
//		foodDTO.setCateId(cateId);
//		foodDTO.setPrice(price);
//		foodDTO.setStatus(status);
//		foodDTO.setDescription(description);
//
//		Path path = Paths.get("C://Users//VINHHOA//Desktop//Work_space//T-Food//src//main//webapp//resources//images//");
//		InputStream inputStream = avatar.getInputStream();
//		Files.copy(inputStream, path.resolve(avatar.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
//
//		System.out.println(price);
//		System.out.println(discount);
//		foodDTO.setDiscount(discount);
//		
//		int new_price = price - discount;
//		
//		foodDTO.setNew_price(new_price);
//		
//		try {
//			
//			foodService.addFood(foodDTO);
//			statuString = "Thêm thành công";
//			return "/move/food";
//		} catch (Exception e) {
//			// TODO: handle exception
//			statuString = "Thêm thất bại";
//		}
//
//		return "/move/food";
//	}
//
//	@RequestMapping(value = "/web-deleteFood", method = RequestMethod.GET)
//	public String addCategory3Param(@RequestParam(name = "id") int id) {
//		try {
//			statuString = "Xóa thành công";
//			foodService.delete(id);
//			return "/move/food";
//		} catch (Exception e) {
//			statuString = "Xóa thất bại";
//		}
//		return "/move/food";
//	}
//	
//	@RequestMapping(value = "/web-deleteFoodList", method = RequestMethod.GET)
//	public String deleteList(@RequestParam(name = "id") int id) {
//		try {
//			statuString = "Xóa thành công";
//			foodService.delete(id);
//			return "/move/foodlist";
//		} catch (Exception e) {
//			statuString = "Xóa thất bại";
//		}
//		return "/move/foodlist";
//	}
//	
//	
//	
//	@RequestMapping(value = "web-foodList-byCategory")
//	public String gridListbyCategory(@RequestParam(name = "id")int id, Model model,
//			@RequestParam(name = "name") String name) {
//		List<FoodDTO> list = foodService.getAllbyCategory(id);
//		model.addAttribute("Food", list);
//		String status2 = name;
//		model.addAttribute("status2", status2);
//		List<CategoryDTO> list2 = categoryService.getAll();
//		model.addAttribute("Category", list2);
//		return "/admin/list-food-grid";
//	}
//	
//	@RequestMapping(value = "/web-update-Food")
//	public String updateFoodString(Model model, @RequestParam(name = "name") String name,
//												@RequestParam(name = "price") String price,
//												@RequestParam(name = "avatar") String avatar,
//												@RequestParam(name = "status") String status,
//												@RequestParam(name = "discount") String discount,
//												//@RequestParam(name = "new_price") String new_price,
//												@RequestParam(name = "description") String description,
//												@RequestParam(name = "id") int id,
//												@RequestParam(name = "cateid") int cateid) {
//		model.addAttribute("name", name);
//		model.addAttribute("price", price);
//		model.addAttribute("avatar", avatar);
//		model.addAttribute("status", status);
//		model.addAttribute("discount", discount);
////		model.addAttribute("new_price", new_price);
//		model.addAttribute("description", description);
//		model.addAttribute("id", id);
//		model.addAttribute("cateid", cateid);
//		List<CategoryDTO> list2 = categoryService.getAll();
//		model.addAttribute("Cate", list2);
//		return "/admin/edit-food";
//	}
//	
//	@RequestMapping(value = "/updateFood", method = RequestMethod.POST, produces ="text/plain;charset=UTF-8" )
//	public String updateFoodString(@RequestParam(name = "name") String name,
//								   @RequestParam(name = "avatar") MultipartFile avatar,
//								   @RequestParam(name = "cateid") int cateid,
//								   @RequestParam(name = "price") int price,
//								   @RequestParam(name = "status") int status,
//								   @RequestParam(name = "discount") int discount,
//								   @RequestParam(name = "description") String description,
//								   @RequestParam(name = "id") int id,
//								   @RequestParam(name = "lastimg") String lastimg) {
//		String avatarString = avatar.getOriginalFilename();
//		if(avatarString.equals("")) {
//			avatarString = lastimg;
//		}else {
//			try {
//				Path path = Paths.get("C://Users//VINHHOA//Desktop//Work_space//OrderFood//src//main//webapp//resources//images//");
//				InputStream inputStream = avatar.getInputStream();
//				Files.copy(inputStream, path.resolve(avatar.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
//		
//		FoodDTO foodDTO = new FoodDTO();
//		foodDTO.setName(name);
//		foodDTO.setAvatar(avatarString);
//		foodDTO.setCateId(cateid);
//		foodDTO.setPrice(price);
//		int new_price = price - discount;
//		foodDTO.setDiscount(discount);
//		foodDTO.setNew_price(new_price);
//		foodDTO.setStatus(status);
//		foodDTO.setDescription(description);
//		foodDTO.setId(id);
//		try {
//			statuString = "Cập nhật thành công";
//			foodService.updateFood(foodDTO);
//			return "/move/foodlist";
//			
//		} catch (Exception e) {
//			statuString = "Cập nhật thất bại";
//		}
//		return "/move/foodlist";
//	}
//	
//	
//	
//}
