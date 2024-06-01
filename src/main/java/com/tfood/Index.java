//package com.tfood;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.tfood.service.CartService;
//import com.tfood.service.CategoryService;
//import com.tfood.service.CommentService;
//import com.tfood.service.FoodService;
//
//import com.tfood.model.CategoryDTO;
//import com.tfood.model.CommentDTO;
//import com.tfood.model.FoodDTO;
//
//@Controller
//public class Index {
//	@Autowired
//	CategoryService categoryService;
//	@Autowired
//	FoodService foodService;
//	@Autowired
//	CartService cartService;
//	@Autowired
//	CommentService commentService;
//	
//	@RequestMapping(value = "/home")
//	public String home(Model model, HttpServletRequest request) {
//		List<CategoryDTO> list = categoryService.get6ItemsMenu();
//		model.addAttribute("ItemsMenu", list);
//		int id = categoryService.getFirstCategory();
//		List<FoodDTO> list2 = foodService.getFood9Deal(id);
//		model.addAttribute("list2", list2);
//		String nameString = categoryService.getNameCategory(id);
//		model.addAttribute("categoryName", nameString);
//		List<FoodDTO> listNoDeal = foodService.getFood9NoDeal(id);
//		model.addAttribute("listNoDeal", listNoDeal);
//		model.addAttribute("css", id);
//		model.addAttribute("id", id);
//		model.addAttribute("titleName", "Trang Chủ");
//		
//		List<FoodDTO> topsold = foodService.getTopSoldbyCate(id);
//		model.addAttribute("topsold", topsold);
//		
//		HttpSession session = request.getSession();
//		Object user = session.getAttribute("levelUser");
//		if(user == null || (Integer) user == -1) {
//			model.addAttribute("cssLogin", "none");
//		}else {
//			model.addAttribute("login", "none");
//		}
//		
//		
//		return "index";
//	}
//	
//	@RequestMapping(value = "/menu/{category}")
//	public String itemsMenu(@PathVariable("category") int id, Model model,HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		Object user = session.getAttribute("levelUser");
//		if(user == null || (Integer) user == -1) {
//			model.addAttribute("cssLogin", "none");
//		}else {
//			model.addAttribute("login", "none");
//		}
//		List<FoodDTO> topsold = foodService.getTopSoldbyCate(id);
//		model.addAttribute("topsold", topsold);
//		List<CategoryDTO> list = categoryService.get6ItemsMenu();
//		model.addAttribute("ItemsMenu", list);
//		List<FoodDTO> listDeal = foodService.getFood9Deal(id);
//		model.addAttribute("list2", listDeal);
//		List<FoodDTO> listNoDeal = foodService.getFood9NoDeal(id);
//		model.addAttribute("listNoDeal", listNoDeal);
//		String nameString = categoryService.getNameCategory(id);
//		model.addAttribute("categoryName", nameString);
//		model.addAttribute("css", id);
//		model.addAttribute("id", id);
//		model.addAttribute("titleName", nameString);
//		
//		return "index";
//	}
//	
//	@RequestMapping(value = "/deal/{id}")
//	public String deal(@PathVariable("id")int id,Model model, HttpServletRequest request) {
//		List<CategoryDTO> list = categoryService.get6ItemsMenu();
//		model.addAttribute("ItemsMenu", list);
//		model.addAttribute("title", "Danh sách ưu đãi");
//		model.addAttribute("css", id);
//		List<CategoryDTO> cateList = categoryService.getAll();
//		model.addAttribute("cateList", cateList);
//		model.addAttribute("cssnormal", "none");
//		String nameString = categoryService.getNameCategory(id);
//		model.addAttribute("categoryName", nameString);
//		List<FoodDTO> listFoodDealbyCategory = foodService.getFoodDealByCategory(id);
//		model.addAttribute("fooddeal", listFoodDealbyCategory);
//		HttpSession session = request.getSession();
//		Object user = session.getAttribute("levelUser");
//		if(user == null || (Integer) user == -1) {
//			model.addAttribute("cssLogin", "none");
//		}else {
//			model.addAttribute("login", "none");
//		}
//		return "list";
//	}
//	
//	@RequestMapping(value = "/normal/{id}")
//	public String Normal(@PathVariable("id")int id,Model model,HttpServletRequest request) {
//		List<CategoryDTO> list = categoryService.get6ItemsMenu();
//		model.addAttribute("ItemsMenu", list);
//		model.addAttribute("title", "Danh sách món ăn");
//		model.addAttribute("css", id);
//		List<CategoryDTO> cateList = categoryService.getAll();
//		model.addAttribute("cateList", cateList);
//		model.addAttribute("cssdeal", "none");
//		model.addAttribute("cssnormal", "block");
//		List<FoodDTO> listFoodNoDealbyCategory = foodService.getFoodNoDealByCategory(id);
//		model.addAttribute("fooddeal", listFoodNoDealbyCategory);
//		HttpSession session = request.getSession();
//		Object user = session.getAttribute("levelUser");
//		if(user == null || (Integer) user == -1) {
//			model.addAttribute("cssLogin", "none");
//		}else {
//			model.addAttribute("login", "none");
//		}
//		return "list";
//	}
//	
//	@RequestMapping(value = "/deal-select/")
//	public String selectDeal(@RequestParam(name = "id") int id,Model model, HttpServletRequest request) {
//		List<CategoryDTO> list = categoryService.get6ItemsMenu();
//		model.addAttribute("ItemsMenu", list);
//		model.addAttribute("title", "Danh sách ưu đãi");
//		model.addAttribute("css", id);
//		List<CategoryDTO> cateList = categoryService.getAll();
//		model.addAttribute("cateList", cateList);
//		model.addAttribute("cssnormal", "none");
//		List<FoodDTO> listFoodDealbyCategory = foodService.getFoodDealByCategory(id);
//		model.addAttribute("fooddeal", listFoodDealbyCategory);
//		HttpSession session = request.getSession();
//		Object user = session.getAttribute("levelUser");
//		if(user == null || (Integer) user == -1) {
//			model.addAttribute("cssLogin", "none");
//		}else {
//			model.addAttribute("login", "none");
//		}
//		return "list";
//	}
//	
//	@RequestMapping(value = "/normal-select/")
//	public String selectNormal(@RequestParam(name = "id") int id,Model model) {
//		List<CategoryDTO> list = categoryService.get6ItemsMenu();
//		model.addAttribute("ItemsMenu", list);
//		model.addAttribute("title", "Danh sách món ăn");
//		model.addAttribute("css", id);
//		List<CategoryDTO> cateList = categoryService.getAll();
//		model.addAttribute("cateList", cateList);
//		model.addAttribute("cssdeal", "none");
//		List<FoodDTO> listFoodNoDealbyCategory = foodService.getFoodNoDealByCategory(id);
//		model.addAttribute("fooddeal", listFoodNoDealbyCategory);
//		return "list";
//	}
//	
////	@RequestMapping(value = "/price-normal/")
////	public String priceNormal(@RequestParam(name = "price") String price,Model model) {
////		List<CategoryDTO> list = categoryService.get6ItemsMenu();
////		model.addAttribute("ItemsMenu", list);
////		model.addAttribute("title", "Danh sách món ăn");
////		model.addAttribute("css", price);
////		List<CategoryDTO> cateList = categoryService.getAll();
////		model.addAttribute("cateList", cateList);
////		model.addAttribute("cssdeal", "none");
////		return "list";
////	}
//	
////	@RequestMapping(value = "/view/{id}")
////	public String view(@PathVariable("id")int id,
////						@RequestParam(name = "price") int price,
////						@RequestParam(name = "new_price")int new_price,
////						@RequestParam(name = "avatar")String avatar,
////						Model model,
////						@RequestParam(name = "name")String name,
////						@RequestParam(name = "description") String description,
////						HttpServletRequest request) {
////		model.addAttribute("price", price);
////		model.addAttribute("new_price", new_price);
////		model.addAttribute("avatar", avatar);
////		model.addAttribute("name", name);
////		model.addAttribute("id", id);
////		model.addAttribute("description", description);
////		List<CategoryDTO> list = categoryService.get6ItemsMenu();
////		model.addAttribute("ItemsMenu", list);
////		HttpSession session = request.getSession();
////		Object user = session.getAttribute("levelUser");
////		if(user == null || (Integer) user == -1) {
////			model.addAttribute("cssLogin", "none");
////		}else {
////			model.addAttribute("login", "none");
////		}
////		return "info";
////	}
//	
//	@RequestMapping(value = "/view/{id}")
//	public String view(@PathVariable("id")int id,
//						
//						Model model,
//						HttpServletRequest request) {
//		
//		int new_price = foodService.getNewPrice(id);
//		String avatar = foodService.getAvatar(id);
//		String description = foodService.getDescription(id);
//		String name = foodService.getNameFood(id);
//		int quantityCommnet = commentService.countComment(id);
//		model.addAttribute("slcmt", quantityCommnet);
//		float avg = 0;
//		avg = commentService.avgcommnet(id);
//		model.addAttribute("avg", avg);
//		int ccmt1 = commentService.countScore1(id);
//		int ccmt2 = commentService.countScore2(id);
//		int ccmt3 = commentService.countScore3(id);
//		int ccmt4 = commentService.countScore4(id);
//		int ccmt5 = commentService.countScore5(id);
//		
//		model.addAttribute("ccmt1", ccmt1);
//		model.addAttribute("ccmt2", ccmt2);
//		model.addAttribute("ccmt3", ccmt3);
//		model.addAttribute("ccmt4", ccmt4);
//		model.addAttribute("ccmt5", ccmt5);
//		
//		List<CommentDTO> listCommentDTOs = commentService.getByFood(id);
//		model.addAttribute("comment", listCommentDTOs);
//		//model.addAttribute("price", price);
//		model.addAttribute("new_price", new_price);
//		model.addAttribute("avatar", avatar);
//		model.addAttribute("name", name);
//		model.addAttribute("id", id);
//		model.addAttribute("description", description);
//		List<CategoryDTO> list = categoryService.get6ItemsMenu();
//		model.addAttribute("ItemsMenu", list);
//		HttpSession session = request.getSession();
//		Object user = session.getAttribute("levelUser");
//		if(user == null || (Integer) user == -1) {
//			model.addAttribute("cssLogin", "none");
//		}else {
//			model.addAttribute("login", "none");
//		}
//		return "info";
//	}
//	
//	
//	
//	
//	@RequestMapping(value = "/logout")
//	public String logout(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		session.setAttribute("levelUser", -1);
//		session.setAttribute("userId", -1);
//		return "redirect:/home";
//
//	}
//	@RequestMapping(value = "/profile")
//	public String profile(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		Object level = session.getAttribute("levelUser");
//		if(level == null) {
//			return "redirect:/web-login";
//		}
//		else if((Integer) level == 3) {
//			return "redirect:/admin/";
//		}
//		else if((Integer) level == 2) {
//			return "redirect:/staff";
//		}
//		else if((Integer) level == 1) {
//			return "redirect:/shipper";
//		}
//		else if((Integer) level == 0  ) {
//			return "redirect:/myProfile";
//		}else {
//			return "redirect:/web-login";
//		}
//	}
//	
//	@RequestMapping(value = "/searchFood",method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//	public String searchFood(
//			@RequestParam(name = "food") String food,Model model,HttpServletRequest request) {
//		List<FoodDTO> list = foodService.getByName(food);
//		model.addAttribute("fooddeal", list);
//		model.addAttribute("title", "Danh Sách Món Ăn");
//		model.addAttribute("cssdeal", "none");
//		model.addAttribute("cssnormal", "none");
//		List<CategoryDTO> list2 = categoryService.get6ItemsMenu();
//		
//		model.addAttribute("ItemsMenu", list2);
//		HttpSession session = request.getSession();
//		Object user = session.getAttribute("levelUser");
//		if(user == null || (Integer) user == -1) {
//			model.addAttribute("cssLogin", "none");
//		}else {
//			model.addAttribute("login", "none");
//		}
//		return "list";
//	}
//	
//	
//	@RequestMapping(value = "/searchFoodbyKey",method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
//	public String searchFoodbyKey(
//			@RequestParam(name = "food") String food,Model model,HttpServletRequest request) {
//		List<FoodDTO> list = foodService.getByName(food);
//		model.addAttribute("fooddeal", list);
//		model.addAttribute("title", "Danh Sách Món Ăn");
//		model.addAttribute("cssdeal", "none");
//		model.addAttribute("cssnormal", "none");
//		List<CategoryDTO> list2 = categoryService.get6ItemsMenu();
//		
//		model.addAttribute("ItemsMenu", list2);
//		HttpSession session = request.getSession();
//		Object user = session.getAttribute("levelUser");
//		if(user == null || (Integer) user == -1) {
//			model.addAttribute("cssLogin", "none");
//		}else {
//			model.addAttribute("login", "none");
//		}
//		return "list";
//	}
//	
//}
