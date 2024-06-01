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
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.tfood.model.CategoryDTO;
//import com.tfood.model.OrderDetailDTO;
//import com.tfood.model.UserDTO;
//import com.tfood.service.CartService;
//import com.tfood.service.CategoryService;
//import com.tfood.service.FoodService;
//import com.tfood.service.OrderDetailService;
//import com.tfood.service.UserService;
//
//@Controller
//public class Customer {
//	@Autowired
//	CategoryService categoryService;
//	@Autowired
//	FoodService foodService;
//	@Autowired
//	CartService cartService;
//	@Autowired
//	UserService userService;
//	@Autowired
//	OrderDetailService orderDetailService;
//	
//	String messageString= "";
//	
//	@RequestMapping(value = "/myProfile")
//	public String Profile(HttpServletRequest request, Model model) {
//		List<CategoryDTO> list = categoryService.get6ItemsMenu();
//		model.addAttribute("ItemsMenu", list);
//		HttpSession session = request.getSession();
//		Object user = session.getAttribute("levelUser");
//		
//		Object userid = session.getAttribute("userId");
//		int UserId = (Integer) userid;
//		System.out.println("user id profile: " + UserId );
//		
//		String nameString= userService.getNameUser(UserId);
//		//System.out.println("Name: " + nameString);
//		String addressString= userService.getAddress(UserId);
//		//System.out.println("addressString: " + addressString);
//		String phoneString = userService.getPhoneNumber(UserId);
//		//System.out.println("phoneString: " + phoneString);
//		String emailString = userService.getEmailUser(UserId);
//		//System.out.println("emailString: " + emailString);
//		model.addAttribute("name", nameString);
//		model.addAttribute("phone", phoneString);
//		model.addAttribute("email",emailString);
//		model.addAttribute("address", addressString);
//		if(user == null || (Integer) user == -1) {
//			model.addAttribute("cssLogin", "none");
//		}else {
//			model.addAttribute("login", "none");
//		}
//		model.addAttribute("message", messageString);
//		return "/customer/profile";
//	}
//	
//	@RequestMapping(value = "/userUpdate",method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//	public String userUpdate(@RequestParam(name = "name")String name,
//							@RequestParam(name = "address")String address,
//							
//							@RequestParam(name = "email")String email,
//							HttpServletRequest request) {
//		
//		HttpSession session = request.getSession();
//		Object userid = session.getAttribute("userId");
//		int UserId = (Integer) userid;
//		
//		UserDTO userDTO = new UserDTO();
//		userDTO.setId(UserId);
//		userDTO.setU_name(name);
//		userDTO.setU_address(address);
////		userDTO.setU_username(phone);
//		userDTO.setEmail(email);
////		int phonee = 0;
////		phonee = Integer.valueOf(phone.trim());
////		int checkPhone = userService.checkPhoneExists(phonee);
////		if(checkPhone == 0) {
//			messageString = "Cập nhật thành công!";
//			try {
//				userService.updateUser(userDTO);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
////		}else {
////			messageString = "Số điện thoại đã được dùng!";
////		}
//		
//		
//		
//		return "redirect:/myProfile";
//	}
//	
//	@RequestMapping(value = "/successfulOrder")
//	public String successfulOrder(Model model, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		Object userid = session.getAttribute("userId");
//		System.out.println(userid);
//		int id  = 0;
//		id = (Integer) userid;
//		List<OrderDetailDTO> list = orderDetailService.orderSuccess(id);
//		model.addAttribute("list", list);
//		List<CategoryDTO> list2 = categoryService.get6ItemsMenu();
//		model.addAttribute("ItemsMenu", list2);
//		Object user = session.getAttribute("levelUser");
//		if(user == null || (Integer) user == -1) {
//			model.addAttribute("cssLogin", "none");
//		}else {
//			model.addAttribute("login", "none");
//		}
//		return "/customer/successful-order";
//	}
//}
