package com.tfood;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfood.model.OrderSuccessDTO;
import com.tfood.service.AdminService;
import com.tfood.service.FoodService;
import com.tfood.service.OrderSuccessService;
import com.tfood.service.SubFoodService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	@Autowired
	OrderSuccessService orderSuccessService;
	@Autowired
	FoodService foodService;
	@Autowired
	SubFoodService subFoodService;
	
	static String notify = "";
	public static int adminId = -1;
	static String passLockScreen = "";
	String mess= "";
	String action = "";
	String btn = "";
	
	@GetMapping(value = "/admin")
	public String admin() {
		return "redirect:/admin/";
	}
	@GetMapping(value = {"/admin/","/admin/index"})
	public String _admin(Model model) {
		if(AdminController.adminId < 0) {
			notify = "Bạn cần đăng nhập trước!!";
			return "admin/sign_in";
		}else {
			
			if(!passLockScreen.equals("")) {
				return "redirect:/admin/ScreenLocked";
			}
			List<OrderSuccessDTO> list = orderSuccessService.getAll();
			model.addAttribute("list", list);
			int revenue = orderSuccessService.revenue();
			model.addAttribute("revenue", revenue);
			//get current time
			Calendar instance = Calendar.getInstance();
	        int month = instance.get(Calendar.MONTH);
	        int day = instance.get(Calendar.DAY_OF_MONTH);
	        int year = instance.get(Calendar.YEAR);
	        month = month + 1;
	       
	        int revenueToday = orderSuccessService.revenueToDay(day, month, year);
	        model.addAttribute("revenueToday", revenueToday);
			
	        int foodQuantity = foodService.foodQuantity();
	        model.addAttribute("foodQuantity", foodQuantity);
	        
	        int subFoodQuantity = subFoodService.subFoodQuantity();
	        model.addAttribute("subFoodQuantity", subFoodQuantity);
	        
	        int quantityOfSuccessOrder = orderSuccessService.quantityOfSuccessOrder();
	        int quantityOfCancelOrder  = orderSuccessService.quantityOfCancelOrder();
	        int quantityOfOrder		   = orderSuccessService.quantityOfOrder();
	        int quantityOfAnotherOrder = orderSuccessService.quantityOfAnotherOrder();
	        model.addAttribute("quantityOfSuccessOrder", quantityOfSuccessOrder);
	        model.addAttribute("quantityOfCancelOrder", quantityOfCancelOrder);
	        model.addAttribute("quantityOfOrder", quantityOfOrder);
	        model.addAttribute("quantityOfAnotherOrder", quantityOfAnotherOrder);
			return "admin/index";
		}			
	}
	
	@GetMapping(value = "/admin/sign-in")
	public String adminLogin(Model model, HttpServletRequest request){
		
		if(AdminController.adminId < 0) {
			return "admin/sign_in";
		}else {
			notify = "logged";model.addAttribute("notify", AdminController.notify);
			return "redirect:/admin/";
		}	
	}
	
	@PostMapping(value = "/admin/sign-in")
	public String checkLogin(@RequestParam(name = "username", required = false) String username,
			@RequestParam(name = "password", required = false)String password,
			Model model) {
		//checkAdminSession(request);
		int checkLogin = adminService.checkLogin(username, password);
		if(checkLogin > 0) {
			adminId = checkLogin;
			return "redirect:/admin/";
		}else {
			if(AdminController.adminId < 0) {
				notify = "Sai thông tin đăng nhập!!";
			}
			model.addAttribute("notify", AdminController.notify);
			return "/admin/sign_in";
		}
	}
	
	
	@GetMapping(value = "/admin/logout")
	public String logOut(HttpServletRequest request) {
		AdminController.adminId = -1;
		return "admin/sign_in";
		
	}
	
	@GetMapping(value = "/admin/lockScreen")
	public String setPass(Model model) {
		if(!passLockScreen.equals("")) {
			return "redirect:/admin/ScreenLocked";
		}
		model.addAttribute("display", "none");
		model.addAttribute("display2", "block");
		model.addAttribute("mess", "Đặt mã khóa");
		model.addAttribute("btn", "Khóa");
		model.addAttribute("title", "Khóa Màn Hình");
		return "admin/lock_screen";
	}
	
	@PostMapping(value = "/admin/lockScreen")
	public String lock(Model model, @RequestParam(name = "pass")String pass) {
		passLockScreen = pass;
		System.out.println("Pass Lock Screen: " + passLockScreen);
		model.addAttribute("display", "block");
		model.addAttribute("display2", "none");
		model.addAttribute("action", "lockScreen");
		return "admin/lock_screen";
	}
	
	@GetMapping(value = "/admin/ScreenLocked")
	public String locked(Model model) {
		if(passLockScreen.equals("")) {
			return "redirect:/admin/lockScreen";
		}
		model.addAttribute("display", "block");
		model.addAttribute("display2", "none");
	
		return "admin/lock_screen";
	}
	
	@GetMapping(value = "/admin/openScreen")
	public String openScreen(Model model) {
		model.addAttribute("display", "none");
		model.addAttribute("display2", "block");
		model.addAttribute("mess", "Mã mở khóa");
		model.addAttribute("btn", "Mở Khóa");
		model.addAttribute("action", "openScreen");
		model.addAttribute("title", "Mở Khóa");
		return "admin/lock_screen";
	}
	
	@PostMapping(value = "/admin/openScreen")
	public String open(@RequestParam(name = "pass")String pass) {
		if(this.passLockScreen.equals(pass)) {
			passLockScreen = "";
			System.out.println("pass:" + pass);
			System.out.println("Mat khau khop");
			return "redirect:/admin/index";
		}else {
			return "redirect:/admin/ScreenLocked";
		}
	}
	
	@GetMapping(value = "/admin/order-list")
	public String orderList(Model model) {
		List<OrderSuccessDTO> list = orderSuccessService.getAll();
		model.addAttribute("list", list);
		return "admin/order_list";
	}
}
