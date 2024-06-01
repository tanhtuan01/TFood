//package com.tfood;
//
//import java.util.List;
//import java.util.Random;
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
//import com.tfood.model.CartDTO;
//import com.tfood.model.CategoryDTO;
//import com.tfood.model.OrderDetailDTO;
//import com.tfood.model.TmpOrdersDTO;
//import com.tfood.service.CartService;
//import com.tfood.service.CategoryService;
//import com.tfood.service.FoodService;
//import com.tfood.service.OrderDetailService;
//import com.tfood.service.TmpOrdersService;
//import com.tfood.service.UserService;
//
//@Controller
//public class CartControl {
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
//	@Autowired
//	TmpOrdersService tmpOrdersService;
//	
//	String message = "";
//	
//	@RequestMapping(value = "/addToCart/{id}")
//	public String addToCart(@PathVariable("id") int id,
//			HttpServletRequest request, Model model) {
//		HttpSession session = request.getSession();
//		Object user = session.getAttribute("userId");
//		if(user == null) {
//			return "redirect:/loginToCart";
//		}
//		int userId = (Integer) user;
//		
//		System.out.println("----Food id: " + id);
//		System.out.println("----User id: " + userId);
//		int getPriceFood = foodService.getPriceFood(id);
//		System.out.println("price food: "+getPriceFood);
//		int checkFood = foodService.checkFoodInOrder(id,userId);
//		
//		if(checkFood > 0) {
//			System.out.println("In order");
//			int checkQuantity = cartService.checkQuantity(userId, id);
//			if (checkQuantity >= 10) {
//				System.out.println("Max quantity");
//				message = "Bạn đã đạt giới hạn 10 món!!!";
//				model.addAttribute("message", message);
//				model.addAttribute("padding", "10px;");
//			}else {
//				checkQuantity = checkQuantity + 1;
//				System.out.println("New quantity: "+checkQuantity);
//				getPriceFood = getPriceFood*checkQuantity;
//				System.out.println("New price: "+getPriceFood);
//				
//				CartDTO cartDTOupdate = new CartDTO();
//				cartDTOupdate.setQuantity(checkQuantity);
//				cartDTOupdate.setPrice(getPriceFood);
//				cartDTOupdate.setUser_id(userId);
//				cartDTOupdate.setFood_id(id);
//				
//				try {
//					cartService.updateCart(cartDTOupdate);
//					message = "Thêm vào giỏ hàng thành công!!!";
//					model.addAttribute("message", message);
//					model.addAttribute("padding", "10px;");
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//			}
//		}else {
//			CartDTO cartDTO = new CartDTO();
//			cartDTO.setUser_id(userId);
//			cartDTO.setFood_id(id);
//			cartDTO.setQuantity(1);
//			cartDTO.setPrice(getPriceFood);
//			try {
//				cartService.addtoCart(cartDTO);
//				message = "Thêm vào giỏ hàng thành công!!!";
//				model.addAttribute("message", message);
//				model.addAttribute("padding", "10px;");
//			}catch (Exception e) {
//				// TODO: handle exception
//			}
//			System.out.println("Not in order");
//		}
//		List<CategoryDTO> list2 = categoryService.get6ItemsMenu();
//		model.addAttribute("ItemsMenu", list2);
//		List<CartDTO> list = cartService.getAll(userId);
//		model.addAttribute("cart", list);
//	
//		Object userlv = session.getAttribute("levelUser");
//		if(userlv == null || (Integer) userlv == -1) {
//			model.addAttribute("cssLogin", "none");
//		}else {
//			model.addAttribute("login", "none");
//		}
//		return "card";
//	}
//	
//	@RequestMapping(value = "/myCart")
//	public String myCart(HttpServletRequest request, Model model) {
//		HttpSession session = request.getSession();
//		Object user = session.getAttribute("userId");
//		message = "";
//		if (user == null) {
//			return "redirect:/loginToCart";
//		}
//		int userId = (Integer)user;
//		int countCart = cartService.countCart(userId);
//		if (countCart == 0) {
//			message = "Giỏ hàng của bạn trống!";
//			model.addAttribute("padding", "10px;");
//		}
//		System.out.println("User id (cart): " + userId);
//		model.addAttribute("message", message);
//		List<CartDTO> list = cartService.getAll(userId);
//		model.addAttribute("cart", list);
//		int countQuantity = tmpOrdersService.countQuantity(userId);
//		model.addAttribute("quantity", countQuantity);
//		int totalprice = tmpOrdersService.totalPrice(userId);
//		model.addAttribute("totalprice", totalprice);
//		List<CategoryDTO> list2 = categoryService.get6ItemsMenu();
//		model.addAttribute("ItemsMenu", list2);
//		String address = userService.getAddress(userId);
//		model.addAttribute("address",address);
//		Object user2 = session.getAttribute("levelUser");
//		if(user2 == null || (Integer) user2 == -1) {
//			model.addAttribute("cssLogin", "none");
//		}else {
//			model.addAttribute("login", "none");
//		}
//		return "card";
//	}
//	
//	
//	@RequestMapping(value = "/deleteCardItem/{cardid}/{userid}")
//	public String deleteCartItem(Model model,
//			@PathVariable("cardid") int cardid,
//			@PathVariable("userid") int userid) {
//		try {
//			message = "Xóa thành công!";
//			cartService.deleteCartItem(cardid, userid);
//			//orderDetailService.deleteItemOrderDetail(cardid, userid);
//			tmpOrdersService.deleteItemTmpOrder(cardid, userid);
//			return "/move/myCart";
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return "/move/myCart";
//	}
//	
//	@RequestMapping(value = "/updateQuantity/{id}", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//	public String updateQuantity(@RequestParam(name = "quantity") int quantity,
//			@PathVariable("id") int id_cart,
//			@RequestParam(name = "id_food") int id_food) {
////		System.out.println("id cart : " + id_cart);
////		System.out.println("Quantity: " + quantity);
////		System.out.println("id_food: " + id_food);
//		int getPriceFood = foodService.getPriceFood(id_food);
////		System.out.println("getPriceFood: " + getPriceFood);
//		int new_price = quantity * getPriceFood;
////		System.out.println("new Price: " + new_price);
//		CartDTO cartDTO = new CartDTO();
//		cartDTO.setId(id_cart);
//		cartDTO.setQuantity(quantity);
//		cartDTO.setPrice(new_price);
//		
//		try {
//			cartService.updateQuantity(cartDTO);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return "/move/myCart";
//	}
//
//
////	@RequestMapping(value = "/selectToOrder/{userid}/{cardid}/{quantity}/{price}")
////	public String selectToOrder(@PathVariable("cardid") int cardid,
////								@PathVariable("quantity") int quantity,
////								@PathVariable("price") int price,
////								@PathVariable("userid") int userid,
////								Model model,HttpServletRequest request) {
////		System.out.println("Card id:" + cardid);
////		model.addAttribute("cardid", cardid);
////		model.addAttribute("userid", userid);
////		String nameString = userService.getNameUser(userid);
////		model.addAttribute("name", nameString);
////		System.out.println("User Name: " + nameString);
////		
////		String emailString = userService.getEmailUser(userid);
////		model.addAttribute("email", emailString);
////		System.out.println("Email: " + emailString);
////		
////		String address = userService.getAddress(userid);
////		System.out.println("address: " + address);
////		model.addAttribute("address", address);
////		
////		System.out.println("quantity:" + quantity);
////		System.out.println("price:" + price);
////		
////		String phoneString = userService.getPhoneNumber(userid);
////		System.out.println("phoneString:" + phoneString);
////		model.addAttribute("phone", phoneString);
////		
////		int checkExist = tmpOrdersService.checkInOrderDetail(cardid);
////		
////		List<TmpOrdersDTO> list = tmpOrdersService.list(userid);
////		
////		if(checkExist > 0) {
////			try {
////				//orderDetailService.deleteItemOrderDetail(cartid, userid);
////				tmpOrdersService.deleteItemTmpOrder(cardid, userid);
////				
////			} catch (Exception e) {
////				// TODO: handle exception
////			}
////		}else {
////		
////			OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
////			orderDetailDTO.setAddress(address);
////			orderDetailDTO.setEmail(emailString);
////			orderDetailDTO.setOrders_id(cardid);
////			orderDetailDTO.setName(nameString);
////			orderDetailDTO.setQuantity(quantity);
////			orderDetailDTO.setPrice(price);
////			orderDetailDTO.setPhone_number(phoneString);
////			orderDetailDTO.setUser_id(userid);
////			orderDetailDTO.setPayment(3);
////
////			
////			TmpOrdersDTO tmpOrdersDTO = new TmpOrdersDTO();
////			tmpOrdersDTO.setOrder_id(cardid);
////			tmpOrdersDTO.setUser_id(userid);
////			tmpOrdersDTO.setQuantity(quantity);
////			tmpOrdersDTO.setPrice(price);
////			
////			try {
////				//orderDetailService.addToCheckOut(orderDetailDTO);
////				tmpOrdersService.addTmpOrder(tmpOrdersDTO);
////			} catch (Exception e) {
////				// TODO: handle exception
////			}
////			
////		}
////		
////		List<CategoryDTO> list2 = categoryService.get6ItemsMenu();
////		model.addAttribute("ItemsMenu", list2);
////	
////		
////		HttpSession session = request.getSession();
////		Object user = session.getAttribute("levelUser");
////		if(user == null || (Integer) user == -1) {
////			model.addAttribute("cssLogin", "none");
////		}else {
////			model.addAttribute("login", "none");
////		}
////		
////		int countQuantity = tmpOrdersService.countQuantity(userid);
////		model.addAttribute("quantity", countQuantity);
////		int totalprice = tmpOrdersService.totalPrice(userid);
////		model.addAttribute("totalprice", totalprice);
////		model.addAttribute("selected", list);
////		List<CartDTO> list3 = cartService.getAll(userid);
////		model.addAttribute("cart", list3);
////		return "card";
////	}
//	
//	@RequestMapping(value = "/selectToOrder/{userid}/{cartid}/{quantity}/{price}")
//	public String selectToOrder(@PathVariable("cartid") int cartid,
//								@PathVariable("quantity") int quantity,
//								@PathVariable("price") int price,
//								@PathVariable("userid") int userid,
//								Model model, HttpServletRequest request) {
//		System.out.println("Cart id:" + cartid);
//		String nameString = userService.getNameUser(userid);
//		System.out.println("User Name: " + nameString);
//		String emailString = userService.getEmailUser(userid);
//		System.out.println("Email: " + emailString);
//		String address = userService.getAddress(userid);
//		System.out.println("address: " + address);
//		System.out.println("quantity:" + quantity);
//		System.out.println("price:" + price);
//		String phoneString = userService.getPhoneNumber(userid);
//		System.out.println("phoneString:" + phoneString);
//		model.addAttribute("address", address);
//		int checkExist = orderDetailService.checkInOrderDetail(cartid);
//		
//		List<OrderDetailDTO> list = orderDetailService.list(userid);
//		
//		if(checkExist > 0) {
//			try {
//				orderDetailService.deleteItemOrderDetail(cartid, userid);
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}else {
//			
//			OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
//			orderDetailDTO.setAddress(address);
//			orderDetailDTO.setEmail(emailString);
//			orderDetailDTO.setOrders_id(cartid);
//			orderDetailDTO.setName(nameString);
//			orderDetailDTO.setQuantity(quantity);
//			orderDetailDTO.setPrice(price);
//			orderDetailDTO.setPhone_number(phoneString);
//			orderDetailDTO.setUser_id(userid);
//			orderDetailDTO.setPayment(3);
//			try {
//				orderDetailService.addToCheckOut(orderDetailDTO);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			
//		}
//		HttpSession session = request.getSession();
//		Object user = session.getAttribute("levelUser");
//		if(user == null || (Integer) user == -1) {
//			model.addAttribute("cssLogin", "none");
//		}else {
//			model.addAttribute("login", "none");
//		}
//		List<CategoryDTO> list22 = categoryService.get6ItemsMenu();
//		model.addAttribute("ItemsMenu", list22);
//		int countQuantity = orderDetailService.countQuantity(userid);
//		model.addAttribute("quantity", countQuantity);
//		int totalprice = orderDetailService.totalPrice(userid);
//		model.addAttribute("totalprice", totalprice);
//		model.addAttribute("selected", list);
//		List<CartDTO> list2 = cartService.getAll(userid);
//		model.addAttribute("cart", list2);
//		return "card";
//	}
//	
//	
////	
////	@RequestMapping(value = "/confirmOrder", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
////	public String confirmOrder(@RequestParam(name = "method") int method,
////			HttpServletRequest request,Model model,
////			@RequestParam(name = "name")String name,
////			@RequestParam(name = "address") String address,
////			@RequestParam(name = "totalprice") int price,
////			@RequestParam(name = "phone") String phone,
////			@RequestParam(name = "quantity") int quantity,
////			@RequestParam(name = "userid") int userid,
////			@RequestParam(name = "email") String email,
////			@RequestParam(name = "cardid") int cardid
////			) {
////	
////		
////		OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
////		orderDetailDTO.setAddress(address);
////		orderDetailDTO.setEmail(email);
////		orderDetailDTO.setOrders_id(cardid);
////		orderDetailDTO.setName(name);
////		orderDetailDTO.setQuantity(quantity);
////		orderDetailDTO.setPrice(price);
////		orderDetailDTO.setPhone_number(phone);
////		orderDetailDTO.setUser_id(userid);
////		orderDetailDTO.setPayment(method);
////		
////		try {
////			//orderDetailService.updatePayment(orderDetailDTO);
////			orderDetailService.addToCheckOut(orderDetailDTO);
////			tmpOrdersService.deleteItemTmpOrder(cardid, userid);
////		} catch (Exception e) {// TODO: handle exception
////			e.printStackTrace();
////		}
////		
////		List<CategoryDTO> list2 = categoryService.get6ItemsMenu();
////		model.addAttribute("ItemsMenu", list2);
////		HttpSession session = request.getSession();
////		Object user2 = session.getAttribute("levelUser");
////		if(user2 == null || (Integer) user2 == -1) {
////			model.addAttribute("cssLogin", "none");
////		}else {
////			model.addAttribute("login", "none");
////		}
////		
////		List<CartDTO> list = cartService.getAll(userid);
////		model.addAttribute("cart", list);
////		message = "Đặt hàng thành công";
////		model.addAttribute("message", "Đặt hàng thành công");
////		return "card";
////	}
//	
//	@RequestMapping(value = "/confirmOrder", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//	public String confirmOrder(@RequestParam(name = "method") int method,
//			HttpServletRequest request,Model model,@RequestParam(name = "address") String address) {
//		HttpSession session = request.getSession();
//		Object user = session.getAttribute("userId");
//		int userId = (Integer) user;
//		Random random = new Random();
//		int a = random.nextInt();
//		System.out.println("method: " + method);
//		System.out.println("user: " + userId);
//		OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
//		orderDetailDTO.setUser_id(userId);
//		orderDetailDTO.setPayment(method);
//		orderDetailDTO.setAddress(address);
//		System.err.println(address);
//		orderDetailDTO.setCode(a);
//		System.err.println(a);
//		try {
//			orderDetailService.updatePayment(orderDetailDTO);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		List<CategoryDTO> list2 = categoryService.get6ItemsMenu();
//		model.addAttribute("ItemsMenu", list2);
//		Object user2 = session.getAttribute("levelUser");
//		if(user2 == null || (Integer) user2 == -1) {
//			model.addAttribute("cssLogin", "none");
//		}else {
//			model.addAttribute("login", "none");
//		}
//		List<CartDTO> list = cartService.getAll(userId);
//		model.addAttribute("cart", list);
//		model.addAttribute("message", "Đặt hàng thành công");
//		return "card";
//	}
//
//}
