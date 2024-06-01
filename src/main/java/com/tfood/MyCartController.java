package com.tfood;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tfood.model.CartDTO;
import com.tfood.model.CartSubDTO;
import com.tfood.model.FoodDTO;
import com.tfood.service.CartService;
import com.tfood.service.CartSubFoodService;
import com.tfood.service.FoodService;

@Controller
public class MyCartController {
	
	@Autowired
	CartSubFoodService cartSubFoodService;
	@Autowired
	CartService cartService;
	@Autowired
	FoodService foodService;
	static String notify = "";

	@GetMapping(value = {"/myCart","/gio-hang","/gio-hang-cua-toi"})
	public String myCart(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Object idUser = session.getAttribute("idUser");
		if(idUser == null || idUser == "") {
			SignInController.notify = "Bạn cần đăng nhập trước!!";
			SignInController.redirect = "/myCart";
			return "redirect:/sign-in";
		}
		int user = (int) idUser;
		List<CartDTO> list = cartService.getAllByUser(user);
		model.addAttribute("food", list);
		List<CartSubDTO> list2 = cartSubFoodService.getAllByUser(user);
		model.addAttribute("subfood", list2);
		int totalQuantityFood = cartService.totalQuantity(user);
		int totalQuantitySubFood = cartSubFoodService.totalQuantity(user);
		model.addAttribute("totalQuantityFood", totalQuantityFood);
		model.addAttribute("totalQuantitySubFood", totalQuantitySubFood);
		int totalPriceFood = cartService.totalPrice(user);
		int totalPriceSubFood = cartSubFoodService.totalPrice(user);
		int totalPrice = totalPriceFood + totalPriceSubFood;
		model.addAttribute("totalPrice", totalPrice);
		List<FoodDTO> topFoodSold = foodService.getTop5Sold();
		model.addAttribute("topFoodSold", topFoodSold);
		if(totalQuantityFood <= 0 && totalQuantitySubFood <= 0) {
			model.addAttribute("noQuantity", "display:none");
		}
		return "my_cart";
	}
	String back = "";
	@GetMapping(value = "/lowQuantity/{id}")
	public String lowQuantity(@PathVariable("id")int id,HttpServletRequest request) {
		back = "redirect:/myCart#"+id;
		HttpSession session = request.getSession();
		Object idUser = session.getAttribute("idUser");
		int user = (int) idUser;
		int quantity = cartService.getQuantityInCart(id);
		if(quantity > 1) {
			try {
				cartService.lowQuantity(id);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		setSessionQuantity(request);
		return back;
	}
	
	@GetMapping(value = "/upQuantity/{id}")
	public String upQuantity(@PathVariable("id")int id, HttpServletRequest request) {
		back = "redirect:/myCart#cart";
		
		try {
			cartService.upQuantity(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		setSessionQuantity(request);
		return back;
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteItems(@PathVariable("id")int id,HttpServletRequest request) {
		try {
			cartService.deleteItems(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		setSessionQuantity(request);
		return "redirect:/myCart#cart";
	}
	
	@GetMapping(value = "/upQuantity-sub/{id}")
	public String upQuantity_sub(@PathVariable("id")int id, HttpServletRequest request) {
		back = "redirect:/myCart#cart";
		try {
			cartSubFoodService.upQuantity(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		setSessionQuantity(request);
		return back;
	}
	
	@GetMapping(value = "/lowQuantity-sub/{id}")
	public String lowQuantity_sub(@PathVariable("id")int id,HttpServletRequest request) {
		back = "redirect:/myCart#"+id;
		HttpSession session = request.getSession();
		Object idUser = session.getAttribute("idUser");
		int user = (int) idUser;
		int quantity = cartSubFoodService.getQuantityInCart(id);
		if(quantity > 1) {
			try {
				cartSubFoodService.lowQuantity(id);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		setSessionQuantity(request);
		return back;
	}
	
	public void setSessionQuantity(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object idUser = session.getAttribute("idUser");
		int iduser = (int) idUser;
		Object cartQuantity = cartService.createSessionCart(iduser);
		Object cartSubQuantity = cartSubFoodService.createSessionSubCart(iduser);
		int cartQ = (int) cartQuantity;
		int cartS = (int) cartSubQuantity;
		int countCart = cartQ + cartS;
		if(countCart > 99) {
			session.setAttribute("cartQuantity", "99+");
		}else {
			session.setAttribute("cartQuantity", countCart);
		}	
	}
	
	
	@GetMapping(value = "/delete-sub/{id}")
	public String delete_sub(@PathVariable("id")int id, HttpServletRequest request) {
		try {
			cartSubFoodService.deleteItems(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		setSessionQuantity(request);
		return "redirect:/myCart#cart";
	}
}
