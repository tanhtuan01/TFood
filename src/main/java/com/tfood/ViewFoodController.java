package com.tfood;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfood.entity.Food;
import com.tfood.model.CartDTO;
import com.tfood.model.CartSubDTO;
import com.tfood.model.CommentDTO;
import com.tfood.model.FoodDTO;
import com.tfood.model.SubFoodDTO;
import com.tfood.service.CartService;
import com.tfood.service.CartSubFoodService;
import com.tfood.service.CategoryService;
import com.tfood.service.CommentService;
import com.tfood.service.FoodService;
import com.tfood.service.SubFoodService;
import com.tfood.service.UserService;

@Controller
public class ViewFoodController {

	@Autowired
	FoodService foodService;
	@Autowired
	CartService cartService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	SubFoodService subFoodService;
	@Autowired
	CartSubFoodService cartSubFoodService;
	@Autowired
	CommentService commentService;
	@Autowired
	UserService userService;
	
	String title_redirect = "";
	String style = "";
	String style2 = "";
	String stylec = "";
	int user = 0;
	
	@GetMapping("/{id}/{title}")
	public String viewTitle(@PathVariable("id")int id,
							@PathVariable("title")String title, Model model,
							HttpServletRequest request) {
		int exists = foodService.checkFoodExists(id);
		if(exists < 0) {
			model.addAttribute("mess", "Chúng tôi không tìm thấy món mà bạn tìm");
			model.addAttribute("href", "/T-Food/");
			return "not_found";
		}
		title_redirect = title;
		List<FoodDTO> food = foodService.getFoodById(id);
		String tenMon = food.get(0).getTenMon();
		String img 	  = food.get(0).getImg();
		int daBan 	  = food.get(0).getDaBan();
		String moTa	  = food.get(0).getMoTa();
		int gia 	  = food.get(0).getGiaMoi();
		model.addAttribute("tenMon", tenMon);
		model.addAttribute("img", img);
		model.addAttribute("id", id);
		model.addAttribute("daBan", daBan);
		model.addAttribute("moTa", moTa);
		model.addAttribute("gia", gia);
		int category = foodService.getCategory(id);
		List<SubFoodDTO> list = subFoodService.getAllByCategory(category);
		int size = list.size();
		model.addAttribute("list", list);
		model.addAttribute("size", size);
		//int countCmtNotNull = commentService.countCommentNotNull(id);
		if(size <=0 ) {
			model.addAttribute("dp", "display:none");
			//model.addAttribute("dp2", "display:block");
		}else {
			model.addAttribute("dp", "display:block");
		}
		HttpSession session = request.getSession();
		Object idUser = session.getAttribute("idUser");
		
		if(idUser== null || idUser== "") {
			style = "display:block";
			style2 = "display:none";
			stylec = "display:none";
		}else {
			style = "display:none";
			style2= "display:block";
			this.user = (int) idUser;
			String avt = userService.getAvatar(this.user);
			model.addAttribute("avt", avt);
		}
		int checkBought = commentService.checkBought(this.user, id);
//		System.out.println("check bought"+checkBought);
		int checkCommentExists = commentService.checkExistsComment(this.user, id);
		if(checkBought <= 0 || checkCommentExists > 0) {
			// chưa mua        // đã mua đã cmt
			stylec = "display:none";
		}else {
//			model.addAttribute("dp", "display:block");
//			model.addAttribute("dp2", "display:none");
			stylec = "display:block";
		}
		List<CommentDTO> commentDTOs = commentService.getAllByFood(id);
		model.addAttribute("cmt", commentDTOs);
		List<FoodDTO> list2 = foodService.getAnotherFoodByCategory(category, id);
		model.addAttribute("list2", list2);
		double avgScore = commentService.avgScore(id);
		model.addAttribute("avgScore", avgScore);
		model.addAttribute("style", style);
		model.addAttribute("style2", style2);
		model.addAttribute("stylec", stylec);
		
		return "view_food";
	}
	
	@GetMapping(value = "/{id}/addToCart")
	public String addToCart(@PathVariable("id")int id, HttpServletRequest request,
			Model model){
		String titleFood = "";
		String redirect = "";
		int discount = 0;

		HttpSession session = request.getSession();
		Object idUser = session.getAttribute("idUser");
		
		//idUser.equals("") || idUser.equals(null) || idUser == null
		if(idUser== null || idUser=="") {
			
			System.out.println("Nguoi dung chua login");
			SignInController.notify = "Bạn cần đăng nhập trước!!";
			SignInController.redirect = "/"+id+"/"+title_redirect;
			return "redirect:/sign-in";
		}else {
			
			
			int iduser = (int) idUser;
			
			// Người dùng đã đăng nhập
			titleFood = categoryService.getTitleWithFoodId(id);
			discount = foodService.checkDiscount(id);
			
			if(discount == 0) {
				redirect  = "redirect:/" + titleFood;
			}else {
				redirect  = "redirect:/dang-giam-gia";
			}
			
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
			redirect = "redirect:/"+id+"/"+title_redirect;
		
			return redirect;
		}	
	}
	
	@GetMapping(value = "/{id}/profile")
	public String profile() {
		return "redirect:/profile";
	}
	
	@GetMapping(value = "/{id}/addSubFood/{subfood}/{gia}")
	public String addSubFood(@PathVariable("id")int id,Model model, HttpServletRequest request,
			@PathVariable("subfood")int subfood,@PathVariable("gia")int gia) {
		HttpSession session = request.getSession();
		Object idUser = session.getAttribute("idUser");
		
		String titleFood = "";
		String redirect = "";
		int discount = 0;
		
		//idUser.equals("") || idUser.equals(null) || idUser == null
		if(idUser== null || idUser=="") {
			
			System.out.println("Nguoi dung chua login");
			SignInController.notify = "Bạn cần đăng nhập trước!!";
			SignInController.redirect = "/"+id+"/"+title_redirect;
			return "redirect:/sign-in";
		}
		redirect = id + "/" + title_redirect;
		
		//idUser.equals("") || idUser.equals(null) || idUser == null
		if(idUser== null || idUser=="") {
			
			System.out.println("Nguoi dung chua login");
			SignInController.notify = "Bạn cần đăng nhập trước!!";
			SignInController.redirect = "/"+id+"/"+title_redirect;
			return "redirect:/sign-in";
		}else {	
			int iduser = (int) idUser;	
			// Người dùng đã đăng nhập
			int user = (Integer) idUser;
			
			int idCart = cartSubFoodService.checkExistsSubFood(user, subfood);
			
			CartSubDTO cartSubDTO = new CartSubDTO();
			
			cartSubDTO.setUser(user);
			cartSubDTO.setFood(subfood);
			cartSubDTO.setGia(gia);
			if(idCart > 0) {
				// Sản phẩm đã tồn tại -> cập nhật số lượng và tiền
				int soLuong = cartSubFoodService.getQuantifyOfFood(user, subfood);
				soLuong = soLuong + 1;
				int tongTien = soLuong * gia;
				cartSubDTO.setSoLuong(soLuong);
				cartSubDTO.setTongTien(tongTien);
				try {
					cartSubFoodService.updateCart(cartSubDTO);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				// Sản phẩm chưa tồn tại -> thêm mới
				cartSubDTO.setSoLuong(1);	
				cartSubDTO.setTongTien(gia);
				try {
					cartSubFoodService.addToCartSub(cartSubDTO);
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
			redirect = "redirect:/"+id+"/"+title_redirect+"#sub-food";
			return redirect;
		}	
	}
	
	@PostMapping(value = "/{id}/writeComment")
	public String writeComment(@PathVariable("id")int id,
							   @RequestParam(name = "score")int score,
							   @RequestParam(name = "content")String content) {
		
		try {
			commentService.updateComment(content, score, this.user, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String back = "redirect:/"+id +"/" + title_redirect;
		return back;
	}
	
	
}
