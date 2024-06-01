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
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.tfood.model.CategoryDTO;
//import com.tfood.model.FoodDTO;
//import com.tfood.model.OrderDetailDTO;
//import com.tfood.model.RevenuaDTO;
//import com.tfood.service.CategoryService;
//import com.tfood.service.FoodService;
//import com.tfood.service.OrderDetailService;
//import com.tfood.service.RevenuaService;
//
//@Controller
//public class Shipper {
//	@Autowired
//	OrderDetailService orderDetailService;
//	@Autowired
//	RevenuaService revenuaService;
//	@Autowired
//	CategoryService categoryService;
//	@Autowired
//	FoodService foodService;
//	
//	@RequestMapping(value = "/shipper")
//	public String shipper(Model model, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		Object user = session.getAttribute("levelUser");
//		if(user == null || (Integer) user == -1) {
//			model.addAttribute("cssLogin", "none");
//		}else {
//			model.addAttribute("login", "none");
//		}
//		List<OrderDetailDTO> list = orderDetailService.waitForShip();
//		model.addAttribute("orders", list);
//		List<CategoryDTO> list2 = categoryService.get6ItemsMenu();
//		model.addAttribute("ItemsMenu", list2);
//		return "/shipper/index";
//	}
//	
//	@RequestMapping(value = "/shipperConfirm", method = RequestMethod.POST)
//	public String confirm(@RequestParam(name = "status")int status, @RequestParam(name = "id")int id,
//			Model model, @RequestParam(name = "price")int price, HttpServletRequest request,
//			@RequestParam(name = "quantity")int quantity,
//			@RequestParam(name = "food_id")int food_id
//			) {
//		OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
//		orderDetailDTO.setId(id);
//		orderDetailDTO.setStatus(status);
//		if(status == 4) {
//			RevenuaDTO revenuaDTO = new RevenuaDTO();
//			revenuaDTO.setOrder_detail_id(id);
//			revenuaDTO.setPrice(price);
//			System.out.println(revenuaDTO);
//			
////			FoodDTO foodDTO = new FoodDTO();
////			foodDTO.setId(food_id);
////			foodDTO.setSold(quantity);
//	
//			try {
//				
//				revenuaService.addPrice(revenuaDTO);
//				//foodService.updateSold(foodDTO);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		try {
//			orderDetailService.confirmOrder(orderDetailDTO);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		HttpSession session = request.getSession();
//		Object user = session.getAttribute("levelUser");
//		if(user == null || (Integer) user == -1) {
//			model.addAttribute("cssLogin", "none");
//		}else {
//			model.addAttribute("login", "none");
//		}
//		
//		List<CategoryDTO> list2 = categoryService.get6ItemsMenu();
//		model.addAttribute("ItemsMenu", list2);
//		List<OrderDetailDTO> list = orderDetailService.waitForShip();
//		model.addAttribute("orders", list);
//		model.addAttribute("message", "Đã cập nhật!");
//		return "/shipper/index";
//	}
//}
