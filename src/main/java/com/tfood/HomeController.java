package com.tfood;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tfood.model.AnotherAdsDTO;
import com.tfood.model.CategoryDTO;
import com.tfood.model.CommentDTO;
import com.tfood.model.FoodDTO;
import com.tfood.model.SliderDTO;
import com.tfood.service.AnotherService;
import com.tfood.service.CartService;
import com.tfood.service.CartSubFoodService;
import com.tfood.service.CategoryService;
import com.tfood.service.CommentService;
import com.tfood.service.FoodService;
import com.tfood.service.SliderService;

@Controller
public class HomeController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	FoodService foodService;
	@Autowired
	CartService cartService;
	@Autowired
	CommentService commentService;
	@Autowired
	CartSubFoodService cartSubFoodService;
	@Autowired
	SliderService sliderService;
	@Autowired
	AnotherService anotherService;
	
	
	String titleCategory = "";
	String style = "";
	String style2= "";
	
	@GetMapping(value = {"/home","/dang-giam-gia"})
	public String home(Model model, HttpServletRequest request) {
		SignInController.notify = "";
		List<CategoryDTO> list = categoryService.getAll();
		model.addAttribute("list", list);
		List<FoodDTO> listFoodDTOs = foodService.getDealFood();
		model.addAttribute("listFood", listFoodDTOs);
		HttpSession session = request.getSession();
		Object idUser = session.getAttribute("idUser");
		int user = 0;
		if(idUser == null || idUser == "") {
			style = "display:block";
			style2 = "display:none";
		}else {
			user = (int) idUser;
			style = "display:none";
			style2= "display:block";
		}
		model.addAttribute("style", style);
		model.addAttribute("style2", style2);
		int cartF = cartService.createSessionCart(user);
		int cartS = cartSubFoodService.createSessionSubCart(user);
		int countCart = cartF + cartS;
		if(countCart > 99) {
			session.setAttribute("cartQuantity", "99+");
		}else {
			session.setAttribute("cartQuantity", countCart);
		}
		System.out.println("session user: " + idUser);
		List<FoodDTO> topFoodSold = foodService.getTop5Sold();
		model.addAttribute("topFoodSold", topFoodSold);
		List<CommentDTO> commentDTOs = commentService.getTop3Comment();
		model.addAttribute("cmt", commentDTOs);
		model.addAttribute("h_title", "Đang Giảm Giá");
		List<SliderDTO> slider = sliderService.getAll();
		model.addAttribute("slider", slider);
		List<AnotherAdsDTO> ads = anotherService.getRandom();
		model.addAttribute("ads", ads);
		return "index";
	}
	
//	@GetMapping(value = "/dang-giam-gia")
//	public String home_dang_giam_gia(Model model,HttpServletRequest request) {
//		List<CategoryDTO> list = categoryService.getAll();
//		model.addAttribute("list", list);
//		List<FoodDTO> listFoodDTOs = foodService.getDealFood();
//		model.addAttribute("listFood", listFoodDTOs);
//		HttpSession session = request.getSession();
//		Object idUser = session.getAttribute("idUser");
//		int user = 0;
//		if(idUser == null || idUser == "") {
//			style = "display:block";
//			style2 = "display:none";
//		}else {
//			user = (int) idUser;
//			style = "display:none";
//			style2= "display:block";
//		}
//		int cartF = cartService.createSessionCart(user);
//		int cartS = cartSubFoodService.createSessionSubCart(user);
//		int countCart = cartF + cartS;
//		if(countCart > 99) {
//			session.setAttribute("cartQuantity", "99+");
//		}else {
//			session.setAttribute("cartQuantity", countCart);
//		}
//		model.addAttribute("style", style);
//		model.addAttribute("style2", style2);
//		List<FoodDTO> topFoodSold = foodService.getTop5Sold();
//		model.addAttribute("topFoodSold", topFoodSold);
//		model.addAttribute("h_title", "Đang Giảm Giá");
//		List<CommentDTO> commentDTOs = commentService.getTop3Comment();
//		model.addAttribute("cmt", commentDTOs);
//		List<SliderDTO> slider = sliderService.getAll();
//		model.addAttribute("slider", slider);
//		List<AnotherAdsDTO> ads = anotherService.getRandom();
//		model.addAttribute("ads", ads);
//		return "index";
//	}
	
	@GetMapping(value = {"/{title}","/{title}/"})
	public String home_danh_muc(@PathVariable("title")String title, Model model,
			HttpServletRequest request) {
		int checkExistTitle = categoryService.checkExistsCategoryTitle(title);
		if(checkExistTitle <= 0) {
			return "redirect:/home";
		}
		List<CategoryDTO> list = categoryService.getAll();
		model.addAttribute("list", list);
		List<FoodDTO> list2 = foodService.getFoodByTitleOfCategory(title);
		model.addAttribute("listFood", list2);
		HttpSession session = request.getSession();
		Object idUser = session.getAttribute("idUser");
		int user = 0;
		if(idUser== null || idUser== "") {
			style = "display:block";
			style2 = "display:none";
		}else {
			user = (int) idUser;
			style = "display:none";
			style2= "display:block";
		}
		int cartF = cartService.createSessionCart(user);
		int cartS = cartSubFoodService.createSessionSubCart(user);
		int countCart = cartF + cartS;
		if(countCart > 99) {
			session.setAttribute("cartQuantity", "99+");
		}else {
			session.setAttribute("cartQuantity", countCart);
		}
		model.addAttribute("style", style);
		model.addAttribute("style2", style2);
		List<FoodDTO> topFoodSold = foodService.getTop5Sold();
		model.addAttribute("topFoodSold", topFoodSold);
		String h_title = categoryService.getCategoryNameByTitle(title);
		model.addAttribute("h_title", h_title);
		List<CommentDTO> commentDTOs = commentService.getTop3Comment();
		model.addAttribute("cmt", commentDTOs);
		List<SliderDTO> slider = sliderService.getAll();
		model.addAttribute("slider", slider);
		List<AnotherAdsDTO> ads = anotherService.getRandom();
		model.addAttribute("ads", ads);
		return "index";
	}
	
	@PostMapping(value = "/tim-kiem")
	public String search(@RequestParam(name = "txt-search")String search,
						HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		Object idUser = session.getAttribute("idUser");
		int user = 0;
		if(idUser == null || idUser == "") {
			model.addAttribute("style", "display:block");
			model.addAttribute("style2", "display:none");
		}else {
			user = (int) idUser;
			style = "display:none";
			style2= "display:block";
		}
		int cartF = cartService.createSessionCart(user);
		int cartS = cartSubFoodService.createSessionSubCart(user);
		int countCart = cartF + cartS;
		if(countCart > 99) {
			session.setAttribute("cartQuantity", "99+");
		}else {
			session.setAttribute("cartQuantity", countCart);
		}
		model.addAttribute("style", style);
		model.addAttribute("style2", style2);
		List<CommentDTO> commentDTOs = commentService.getTop3Comment();
		model.addAttribute("cmt", commentDTOs);
		model.addAttribute("h_title", "Kết quả tìm kiếm cho từ khóa: " + search);
		
		List<FoodDTO> topFoodSold = foodService.getTop5Sold();
		model.addAttribute("topFoodSold", topFoodSold);
		List<CategoryDTO> list = categoryService.getAll();
		model.addAttribute("list", list);
		List<FoodDTO> listFoodDTOs = foodService.searchByName(search);
		model.addAttribute("listFood", listFoodDTOs);
		List<SliderDTO> slider = sliderService.getAll();
		model.addAttribute("slider", slider);
		List<AnotherAdsDTO> ads = anotherService.getRandom();
		model.addAttribute("ads", ads);
		return "index";
	}
	
}
