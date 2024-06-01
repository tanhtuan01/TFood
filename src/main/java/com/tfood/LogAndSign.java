//package com.tfood;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.tfood.model.UserDTO;
//import com.tfood.service.UserService;
//
//@Controller
//public class LogAndSign {
//	@Autowired
//	UserService userService;
//	
//	String message ="";
//	@RequestMapping(value = "/loginToCart")
//	public String login(Model model) {
//		model.addAttribute("message",message);
//		model.addAttribute("cart", "none;");
//		return "login";
//	}
//	
//	@RequestMapping(value = "/web-login")
//	public String weblogin(Model model) {
//		
//		model.addAttribute("message",message);
//		model.addAttribute("login", "none;");
//		return "login";
//	}
//	
//
//	
//	@RequestMapping(value = "/login-Cart")
//	public String formLogin(@RequestParam(name = "username")String username,
//			@RequestParam(name = "passwords") String passwords,
//			Model model, HttpServletRequest request) {
//		int level = 0;
//		int id = 0;
//		try {
//			level = userService.login(username, passwords);
//			id = userService.getIdUser(username, passwords);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		if(level == -1) {
//		
//			message = "Đăng nhập thất bại";
//			model.addAttribute("message",message);
//			model.addAttribute("username",username);
//			model.addAttribute("passwords",passwords);
//			System.out.println("LEVEl: " + level);
//			return "redirect:/loginToCart";
//		}
//		else {
//				
//			HttpSession session = request.getSession();
//			session.setAttribute("username",username);
//			session.setAttribute("passwords", passwords);
//			session.setAttribute("levelUser", level);
//			session.setAttribute("userId", id);
//			return "redirect:/myCart";
//		}
//	}
//	
//	
//	@RequestMapping(value = "/login")
//	public String formLoginProfile(@RequestParam(name = "username")String username,
//			@RequestParam(name = "passwords") String passwords,
//			Model model, HttpServletRequest request) {
//		int level = 0;
//		int id = 0;
//		try {
//			level = userService.login(username, passwords);
//			id = userService.getIdUser(username, passwords);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		if(level == -1) {
//		
//			message = "Đăng nhập thất bại";
//			model.addAttribute("message",message);
//			model.addAttribute("username",username);
//			model.addAttribute("passwords",passwords);
//			System.out.println("LEVEl: " + level);
//			return "redirect:/web-login";
//		}
//		else {
//				
//			HttpSession session = request.getSession();
//			session.setAttribute("username",username);
//			session.setAttribute("passwords", passwords);
//			session.setAttribute("levelUser", level);
//			session.setAttribute("userId", id);
//			message = "";
//			
//			return "redirect:/home";
//		}
//	}
//	
//	//Đăng ký
//	
//	@RequestMapping(value = "/web-signup")
//	public String signUp(Model model, HttpServletRequest request) {
//		return "signup";
//	}
//	
//	
//	@RequestMapping(value = "/signup", method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
//	public String formsignupString(Model model,
//			@RequestParam(name = "name") String name, 
//			@RequestParam(name = "username") String username, 
//			@RequestParam(name = "address") String address,
//			@RequestParam(name = "passwords")String passwords,
//			@RequestParam(name = "passwords2") String repasswords) {
//		
//		model.addAttribute("message", message);
//		model.addAttribute("name", name);
//		model.addAttribute("phone", username);
//		model.addAttribute("pass1", passwords);
//		model.addAttribute("address", address);
//		int phone=0;
//		if(!passwords.equals(repasswords)) {
//			message = "Mật khẩu không khớp";
//		}else {
//			System.out.println(name);
//			System.out.println(username);
//			System.out.println(address);
//			System.out.println(passwords);
//			System.out.println(repasswords);
//			
//			phone = Integer.valueOf(username);
//			int checkphone = userService.checkPhoneExists(phone);
//			if(checkphone == 0) {
//				System.out.println("sdt chua dang ky");
//				UserDTO userDTO = new UserDTO();
//				userDTO.setU_name(name);
//				userDTO.setU_username(username);
//				userDTO.setU_passwords(passwords);
//				userDTO.setU_address(address);
//				userDTO.setU_status(1);
//				try {
//					userService.addUser(userDTO);
//					message = "Đăng ký thành công";
//					return "redirect:/web-login";
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}else {
//				message = "Vui lòng chọn số điện thoại khác!";
//			}
//
//		}
//		model.addAttribute("message", message);
//		return "signup";
//	}
//	
//}
