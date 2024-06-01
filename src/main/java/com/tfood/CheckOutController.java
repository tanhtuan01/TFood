package com.tfood;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfood.model.CartDTO;
import com.tfood.model.CartSubDTO;
import com.tfood.model.OrderDetailFoodDTO;
import com.tfood.model.OrderDetailSubFoodDTO;
import com.tfood.model.OrderSuccessDTO;
import com.tfood.service.AddressService;
import com.tfood.service.CartService;
import com.tfood.service.CartSubFoodService;
import com.tfood.service.CommentService;
import com.tfood.service.FoodService;
import com.tfood.service.OrderDetailFoodService;
import com.tfood.service.OrderDetailSubFoodService;
import com.tfood.service.OrderSuccessService;
import com.tfood.service.UserService;

@Controller
public class CheckOutController {

	@Autowired
	UserService userService;
	@Autowired
	CartService cartService;
	@Autowired
	CartSubFoodService cartSubFoodService;
	@Autowired
	AddressService addressService;
	@Autowired
	OrderDetailFoodService orderDetailFoodService;
	@Autowired
	OrderDetailSubFoodService orderDetailSubFoodService;
	@Autowired
	OrderSuccessService orderSuccessService;
	@Autowired
	FoodService foodService;
	@Autowired
	CommentService commentService;
	
	String address = "";
	int priceShip = 0;
	int status = 0;
	String notify = "";
	String districtName = "";
	String wardName = "";
	String village = "";
	String note = "";
	int user;
	int cartPrice =0;
	int cartSubPrice =0;
	int totalPriceFood =0;
	int totalPrice =0;
	int myStatus = 1;
	String districtValue = "";
	String wardValue = "";
	
	@GetMapping(value = "/check-out")
	public String checkOut(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		Object idUser = session.getAttribute("idUser");
		if(idUser == null || idUser == "") {
			SignInController.notify = "Hết thời gian đăng nhập, bạn cần đăng nhập lại!!";
			SignInController.redirect = "/check-out";
			return "redirect:/sign-in";
		}else {
			this.user = (int) idUser;
			String name = userService.getNameOfUser(user);
			String phone = userService.getPhoneNumberOfUser(user);
			model.addAttribute("name", name);
			model.addAttribute("phone", phone);
			List<CartDTO> cart = cartService.getAllByUser(user);
			List<CartSubDTO> cartSub = cartSubFoodService.getAllByUser(user);
			model.addAttribute("cart", cart);
			model.addAttribute("cartSub", cartSub);
			this.cartPrice = cartService.totalPrice(user);
			this.cartSubPrice = cartSubFoodService.totalPrice(user);
			this.totalPriceFood = this.cartPrice + this.cartSubPrice;
			model.addAttribute("totalPriceFood", this.totalPriceFood);
			int cartQuantity = cartService.totalQuantity(user);
			model.addAttribute("cartQuantity", cartQuantity);
			model.addAttribute("address", this.address);
			model.addAttribute("priceShip", priceShip);
			model.addAttribute("notify", this.notify);
			model.addAttribute("village", this.village);
			this.totalPrice = this.totalPriceFood + this.priceShip;
			model.addAttribute("totalPrice", this.totalPrice);
			model.addAttribute("note", this.note);
			
			if(cartQuantity <= 0) {
				model.addAttribute("displaym", "style='display:none'");
			}
			int cartSubQuantity = cartSubFoodService.totalQuantity(user);
			model.addAttribute("cartSubQuantity", cartSubQuantity);
			if(cartSubQuantity <= 0) {
				model.addAttribute("displays", "style='display:none'");
			}
			if(cartQuantity <= 0 && cartSubQuantity <= 0) {
				return "redirect:/myCart";
			}	
		}
		return "check_out";
	}
	
	
	@GetMapping(value = "/del/{id}")
	public String delFromCheckOut(@PathVariable("id")int id) {
		try {
			cartService.deleteItems(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/check-out";
	}
	
	@GetMapping(value = "/dels/{id}")
	public String delSub(@PathVariable("id")int id) {
		try {
			cartSubFoodService.deleteItems(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/check-out";
	}
	
	@GetMapping(value = "/low/{kind}/{id}")
	public String lowQuantity(@PathVariable("id")int id, @PathVariable("kind")String kind) {
		int quantity = cartService.getQuantityInCart(id);
		int quantity2 = cartSubFoodService.getQuantityInCart(id);
		System.out.println("Kind : " + kind + " id: " +id);
		if(kind.equals("m")) {
			if(quantity > 1) {
				try {
					System.out.println(" Low - m");
					cartService.lowQuantity(id);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		if(kind.equals("s")) {
			if(quantity2 > 1) {
				try {
					System.out.println(" Low - s");
					cartSubFoodService.lowQuantity(id);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		return "redirect:/check-out";
	}
	
	@GetMapping(value = "/up/{kind}/{id}")
	public String UpQuantity(@PathVariable("id")int id, @PathVariable("kind")String kind) {
		int quantity = cartService.getQuantityInCart(id);
		int quantity2 = cartSubFoodService.getQuantityInCart(id);
		System.out.println("Kind : " + kind + " id: " +id);
		if(kind.equals("m")) {
			if(quantity > 1) {
				try {
					System.out.println(" Up - m");
					cartService.upQuantity(id);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		if(kind.equals("s")) {
			if(quantity2 > 1) {
				try {
					System.out.println(" Up - s");
					cartSubFoodService.upQuantity(id);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		return "redirect:/check-out";
	}
	
	
	@PostMapping(value = "/check-address")
	public String checkAddress(@RequestParam(name = "district")String district,
							   @RequestParam(name = "wards")String wards,
							   @RequestParam(name = "village")String village,
							   @RequestParam(name = "note")String note) {
		status = 1;
		this.districtValue = district;
		this.wardValue     = wards;
		this.districtName = addressService.getDistrictName(district);
		this.wardName = addressService.getWardName(district, wards);
		double distance = addressService.getDistance(district, wards);
		this.village = village;
		this.note = note;
		address = village + ", " + wardName + ", " + districtName;
		this.notify = "";
		if(distance <= 10) {
			priceShip = 0;
		}else if(distance <= 20) {
			priceShip = 15000;
		}else if(distance <= 30) {
			priceShip = 25000;
		}else if(distance <= 40) {
			priceShip = 35000;
		}else if(distance <= 50) {
			priceShip = 45000;
		}else if(distance <= 60) {
			priceShip = 55000;
		}else if(distance <= 70) {
			priceShip = 65000;
		}else if(distance <= 80) {
			priceShip = 80000;
		}
		
		return "redirect:/check-out#address";
	}
	
	@GetMapping(value = "/confirm")
	public String confirm() {
		
		if(this.status == 0) {
			notify = "Bạn chưa xác nhận địa chỉ";
			return "redirect:/check-out#address";
		}else {
			if(this.wardName.equals("") || this.districtName.equals("")) {
				notify = "Bạn chưa chọn địa chỉ nhận hàng";
				return "redirect:/check-out#address";
			}else {
				
				if(myStatus == 1) {
					UUID uuid = UUID.randomUUID();
					String orderCode = String.valueOf(uuid);
					// Thêm món chính vào order detail
					List<CartDTO> list = cartService.getAllByUser(this.user);
					for(CartDTO cartDTO : list) {
						OrderDetailFoodDTO food = new OrderDetailFoodDTO();
						food.setFood(cartDTO.getFood());
						food.setUser(cartDTO.getUser());
						food.setTotalprice(cartDTO.getTongTien());
						food.setQuantity(cartDTO.getSoLuong());
						food.setOrderCode(orderCode);
						try {
							orderDetailFoodService.add(food);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					// Thêm món phụ vào order detail
					List<CartSubDTO> list2 = cartSubFoodService.getAllByUser(this.user);
					for(CartSubDTO cartSubDTO : list2) {
						OrderDetailSubFoodDTO subFoodDTO = new OrderDetailSubFoodDTO();
						subFoodDTO.setFood(cartSubDTO.getFood());
						subFoodDTO.setUser(cartSubDTO.getUser());
						subFoodDTO.setQuantity(cartSubDTO.getSoLuong());
						subFoodDTO.setTotalprice(cartSubDTO.getTongTien());
						subFoodDTO.setOrderCode(orderCode);
						try {
							orderDetailSubFoodService.add(subFoodDTO);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					// thêm tổng tiền sp, phí ship, tổng tiền, order code
					OrderSuccessDTO orderSuccessDTO = new OrderSuccessDTO();
					orderSuccessDTO.setUser(this.user);
					orderSuccessDTO.setOrderCode(orderCode);
					orderSuccessDTO.setPriceShip(priceShip);
					orderSuccessDTO.setTotalPriceFood(this.totalPriceFood);
					orderSuccessDTO.setTotalPrice(this.totalPrice);
					orderSuccessDTO.setNote(this.note);
					orderSuccessDTO.setAddress(this.village);
					orderSuccessDTO.setDistrictValue(this.districtValue);
					orderSuccessDTO.setWardValue(this.wardValue);
					// thêm vào order success
					try {
						orderSuccessService.add(orderSuccessDTO);
					} catch (Exception e) {
						// TODO: handle exception
					}
					// Xóa items trong giỏ hàng
					try {
						cartService.delete(this.user);
						cartSubFoodService.delete(this.user);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// + số lượng đã bán
					for(CartDTO cartDTO : list) {
						int food = cartDTO.getFood();
						int quantity = cartDTO.getSoLuong();
						try {
							foodService.updateSold(food, quantity);
							// thêm vào comment là chưa comment
							commentService.addNewComment(this.user, food);
						}catch (Exception e) {
							e.printStackTrace();
						}
					}
					
					myStatus = 2;
					return "order_success";
				}else {
					return "order_success";
				}
			}
			
		}
		
	}
	

	
}
