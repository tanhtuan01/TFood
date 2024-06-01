package com.tfood;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tfood.entity.Cart;
import com.tfood.model.CartDTO;
import com.tfood.model.OrderDetailFoodDTO;
import com.tfood.model.OrderDetailSubFoodDTO;
import com.tfood.service.CartService;
import com.tfood.service.FoodService;
import com.tfood.service.OrderDetailFoodService;
import com.tfood.service.OrderDetailSubFoodService;
import com.tfood.service.OrderSuccessService;

@RequestMapping(value = "/admin/view-order")
@Controller
public class SeeOrderSuccessDetailsController {

	@Autowired
	OrderSuccessService orderSuccessService;
	@Autowired
	OrderDetailFoodService orderDetailFoodService;
	@Autowired
	OrderDetailSubFoodService orderDetailSubFoodService;
	@Autowired
	CartService cartService;
	@Autowired
	FoodService foodService;
	
	String orderCodeforAction = "";
	String notify = "";
	
	@GetMapping(value = "/{orderCode}")
	public String viewOrder(@PathVariable("orderCode")String orderCode,Model model) {
		int checkOrderCode = orderSuccessService.checkOrderCodeExists(orderCode);	
		if(checkOrderCode < 0) {
			return "admin/not_found_ordercode";
		}
		String note = orderSuccessService.getNote(orderCode);
		model.addAttribute("note", note);
		int status = orderSuccessService.checkStatus(orderCode);
		String style4 = "";
		String style2 = "";
		String style3 = "";
		switch (status) {
		case 1:
		case 2:
			style4 = "display:block";
			style3 = "display:block";
			style2 = "display:none";
			break;
		case 3:
		case 4:
			style4 = "display:none";
			style3 = "display:none";
			style2 = "display:none";
			break;
		default:
			break;
		}
		model.addAttribute("style4", style4);
		model.addAttribute("style2", style2);
		model.addAttribute("style3", style3);
		this.orderCodeforAction = orderCode;
		List<OrderDetailFoodDTO> list = orderDetailFoodService.getAll(orderCode);
		List<OrderDetailSubFoodDTO> list2 = orderDetailSubFoodService.getAll(orderCode);
		model.addAttribute("list", list);
		model.addAttribute("list2", list2);
		model.addAttribute("orderCode", orderCode);
		model.addAttribute("notify", this.notify);
		return "admin/see_orderdetail_success";
	}
	
	@GetMapping(value = "/confirmOrder")
	public String confirm() {
		try {
			orderSuccessService.confirmOrder(this.orderCodeforAction);
			this.notify = "Đã xác nhận đơn hàng!!";
		} catch (Exception e) {
			e.printStackTrace();
			this.notify = "Có lỗi khi xác nhận!!";
		}
		String back = "redirect:/admin/view-order/" + this.orderCodeforAction;
		return back;
	}
	
	@GetMapping(value = "/cancel")
	public String cancel() {
		try {
			orderSuccessService.cancelOrder(this.orderCodeforAction);
			this.notify = "Đã hủy đơn hàng!!";
		} catch (Exception e) {
			e.printStackTrace();
			this.notify = "Có lỗi khi hủy!!";
		}
		List<CartDTO> list = cartService.getAllByOrderCode(this.orderCodeforAction);
		for(CartDTO cartDTO : list) {
			int foodId = cartDTO.getFood();
			int sold  = cartDTO.getSoLuong();
			try {
				foodService.updateLowSold(foodId, sold);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		String back = "redirect:/admin/view-order/" + this.orderCodeforAction;
		return back;
	}
	
	@GetMapping(value = "/orderSuccess")
	public String orderSuccess() {
		try {
			orderSuccessService.orderSuccess(this.orderCodeforAction);
			this.notify = "Đã xác nhận đơn hàng được giao thành công!!";
		} catch (Exception e) {
			e.printStackTrace();
			this.notify = "Có lỗi khi xác nhận!!";
		}
		String back = "redirect:/admin/view-order/" + this.orderCodeforAction;
		return back;
	}
}
