package com.tfood;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfood.service.CartService;
import com.tfood.service.CartSubFoodService;
import com.tfood.service.UserService;

@Controller
public class SignInController {

	@Autowired
	UserService userService;
	@Autowired
	CartService cartService;
	@Autowired
	CartSubFoodService cartSubFoodService;
	
	public static String notify = "";
	public static String redirect = "";
	public static int cartQuantity = 0;
	String redirect2 = "";
	
	@GetMapping(value = "/sign-in")
	public String signIn(Model model) {
		model.addAttribute("notify", notify);
		return "sign_in";
	}
	
	@PostMapping(value = "/sign-in")
	public String _signIn(@RequestParam(name = "phone")String phone,
						  @RequestParam(name = "passwords")String passwords,
						  HttpServletRequest request) {
		
		if(userService.checkPhoneExists(phone) > 0) {
			int login = userService.login(phone, passwords);
			if(login > 0) {
				int id = userService.checkPhoneExists(phone);
				HttpSession session = request.getSession();
				session.setAttribute("idUser",id);
				
				Object idUser = session.getAttribute("idUser");
				int user = (Integer) idUser;
				cartQuantity = cartService.createSessionCart(user);
				Object cartSubQuantity = cartSubFoodService.createSessionSubCart(user);
				int cartQ = (int) cartQuantity;
				int cartS = (int) cartSubQuantity;
				int countCart = cartQ + cartS;
				session.setAttribute("cartQuantity", countCart);
				System.out.println("id user: " + user + " " + countCart);
				if(redirect.equals("")) {
					return "redirect:/home";
				}else {
					return "redirect:"+redirect; 
				}
				
			}
			else {
				notify = "Đăng Nhập Thất Bại!!";
				return "redirect:/sign-in";
			}
//			Object object = session.getAttribute("idUser");
//			System.out.println("idUser: " + object);
			
		}else {
			
			notify = "Đăng Nhập Thất Bại!!";
			return "redirect:/sign-in";
		}
	}
	
	@GetMapping(value = "/view/sign-in")
	public String view_signin() {
		return "redirect:/sign-in";
	}
}
