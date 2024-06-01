// Add to cart from index
package com.tfood;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tfood.model.CartDTO;
import com.tfood.service.CartService;
import com.tfood.service.CartSubFoodService;
import com.tfood.service.CategoryService;
import com.tfood.service.FoodService;

@Controller
public class AddToCartController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	CartService cartService;
	@Autowired
	FoodService foodService;
	@Autowired
	CartSubFoodService cartSubFoodService;
	
	@GetMapping(value = "/addToCarts/{id}")
	public String addToCart(@PathVariable("id")int id, HttpServletRequest request) {
		
		String titleFood = "";
		String redirect = "";
		int discount = 0;

		HttpSession session = request.getSession();
		Object idUser = session.getAttribute("idUser");
		
		//idUser.equals("") || idUser.equals(null) || idUser == null
		if(idUser== null || idUser=="") {
			System.out.println("Nguoi dung chua login");
			SignInController.notify = "Bạn cần đăng nhập trước!!";
			redirect = "redirect:/sign-in";
		}else {
			int iduser = (int) idUser;
			
			// Người dùng đã đăng nhập
			titleFood = categoryService.getTitleWithFoodId(id);
			discount = foodService.checkDiscount(id);
			
//			if(discount == 0) {
//				redirect  = "redirect:/" + titleFood+"#product-"+id;
//			}else {
//				redirect  = "redirect:/dang-giam-gia#product-"+id;
//			}
			
			redirect  = "redirect:/" + titleFood+"#product-"+id;
			
			int user = (Integer) idUser;
			int gia = foodService.getPriceFood(id);
			
			int idCart = cartService.checkExistsFood(user, id);
			
			CartDTO cartDTO = new CartDTO();
			
			cartDTO.setUser(user);
			cartDTO.setFood(id);
			cartDTO.setGia(gia);
			if(idCart > 0) {
				// Sản phẩm đã tồn tại -> cập nhật số lượng và tiền
				int soLuong = cartService.getQuantifyOfFood(user, id);
				soLuong = soLuong + 1;
				int tongTien = soLuong * gia;
				cartDTO.setSoLuong(soLuong);
				cartDTO.setTongTien(tongTien);
				try {
					cartService.updateCart(cartDTO);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				// Sản phẩm chưa tồn tại -> thêm mới
				cartDTO.setSoLuong(1);	
				cartDTO.setTongTien(gia);
				
				try {
					cartService.addtoCart(cartDTO);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
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
		
		return redirect;
	}	
	
}
