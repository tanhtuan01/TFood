package com.tfood;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import com.tfood.entity.OrderDetailFood;
import com.tfood.model.OrderDetailFoodDTO;
import com.tfood.model.OrderDetailSubFoodDTO;
import com.tfood.model.OrderSuccessDTO;
import com.tfood.model.UserDTO;
import com.tfood.service.AddressService;
import com.tfood.service.OrderDetailFoodService;
import com.tfood.service.OrderDetailSubFoodService;
import com.tfood.service.OrderSuccessService;
import com.tfood.service.UserService;

@Controller
public class ProfileController {

	@Autowired
	UserService userService;
	@Autowired
	OrderSuccessService orderSuccessService;
	@Autowired
	OrderDetailFoodService orderDetailFoodService;
	@Autowired
	OrderDetailSubFoodService orderDetailSubFoodService;
	@Autowired
	AddressService addressService;
	
	String style = "";
	String style2 = "";
	String name = "";
	String phone = "";
	String email = "";
	String pass = "";
	String avatar = "";
	int user;
	String notify = "";
	
	@GetMapping(value = {"/profile","/ho-so","/ca-nhan"})
	public String profile(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object idUser = session.getAttribute("idUser");
		if(idUser == null || idUser == "") {
			SignInController.redirect = "/profile";
			return "redirect:/sign-in";
		}
		this.user = (int) idUser;
		String userName = userService.getNameOfUser(user);
		this.name = userName;
		model.addAttribute("userName", userName);
		String phone = userService.getPhoneNumberOfUser(user);
		this.phone = phone;
		model.addAttribute("phone", phone);
		String email = userService.getEmailOfUser(user);
		if(email == "" || email==null) {
			email = "Bạn chưa cập nhật email!";
		}
		this.email = email;
		model.addAttribute("email", email);
		String pass = userService.getPasswordsOfUser(user);
		this.pass = pass;
		String avatar = userService.getImagesOfUser(user);
		model.addAttribute("avatar", avatar);
		this.avatar = avatar;
		List<OrderSuccessDTO> list = orderSuccessService.getAllMyOrder(this.user);
		model.addAttribute("list", list);
		return "custommer/index";
	}
	
	@GetMapping(value = "/edit-info")
	public String editInfo(Model model) {
		this.name = userService.getNameOfUser(user);
		this.phone = userService.getPhoneNumberOfUser(user);
		this.email = userService.getEmailOfUser(user);
		this.pass = userService.getPasswordsOfUser(user);
		this.avatar = userService.getImagesOfUser(user);
		
		if(email == "" || email==null) {
			this.email = "";
		}
		model.addAttribute("name", this.name);
		model.addAttribute("phone", this.phone);
		model.addAttribute("email", this.email);
		model.addAttribute("pass", this.pass);
		model.addAttribute("avatar", this.avatar);
		model.addAttribute("notify", this.notify);
		return "custommer/edit_info";
	}
	
	@GetMapping(value = "/sign-out")
	public String signOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("idUser", "");
		session.setAttribute("cartQuantity", "");
//		session.removeAttribute("idUser");
//		session.invalidate();idUser
		
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/updateInfo", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String updateInfo(@RequestParam(name = "name")String name,
							 @RequestParam(name = "pass")String pass,
							 @RequestParam(name = "email")String email,
							 @RequestParam(name = "img")MultipartFile img,
							 @RequestParam(name = "phone")String phone,
							 HttpServletRequest request) throws MultipartException{
		String avt = img.getOriginalFilename();
		int checkPhone = userService.checkAnotherPhone(phone, user);
		
		if(avt == null || avt == "") {
			avt = this.avatar;
		}
		
		if(checkPhone < 0) {
			//System.out.println("Số điện thoại chưa tồn tại");
			UserDTO userDTO = new UserDTO();
			userDTO.setTenNguoiDung(name);
			userDTO.setEmail(email);
			userDTO.setMatKhau(pass);
			userDTO.setAvatar(avt);
			userDTO.setSoDienThoai(phone);
			userDTO.setId(this.user);
			try {
				this.notify = "Cập nhật thành công!!";
				userService.updateInfoOfUser(userDTO);
			} catch (Exception e) {
				e.printStackTrace();
				this.notify = "Cập nhật thất bại!!";
			}
			if(img.getOriginalFilename() != null || img.getOriginalFilename() != "") {
				try {
					String path = request.getSession().getServletContext().getRealPath("/") + "resources/images/";
				    FileUtils.forceMkdir(new File(path));
				    File upload = new File (path + img.getOriginalFilename());
				    img.transferTo(upload);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}else {
			this.notify = "Số điện thoại đã tồn tại!!";
		}
		
		//System.out.println("Info for Update: " + name + "/" + email + "/" + pass + "/" + phone + "/" +avt + "|");
		return "redirect:/edit-info";
	}
	
	@GetMapping(value = "/viewMyOrderSuccess/{orderCode}")
	public String viewMyOrderSuccess(@PathVariable("orderCode")String orderCode,
			Model model) {
		
		int checkOrderCodeExists = orderSuccessService.checkOrderCodeExists(orderCode);
		if(checkOrderCodeExists < 0) {
			model.addAttribute("mess", "Chúng tôi không tìm thấy đơn hàng này: <br>"+orderCode);
			model.addAttribute("href", "/T-Food/profile");
			return "not_found";
		}
		
		List<OrderDetailFoodDTO> list = orderDetailFoodService.getAll(orderCode);
		List<OrderDetailSubFoodDTO> list2 = orderDetailSubFoodService.getAll(orderCode);
		model.addAttribute("orderCode", orderCode);
		model.addAttribute("list", list);
		model.addAttribute("list2", list2);
		String note = orderSuccessService.getNote(orderCode);
		model.addAttribute("note", note);
		int shipPrice = orderSuccessService.getPriceShip(orderCode);
		model.addAttribute("shipPrice", shipPrice);
		int totalPriceFood = orderSuccessService.getTotalPriceFood(orderCode);
		model.addAttribute("totalPriceFood", totalPriceFood);
		int totalPrice = orderSuccessService.getTotalPrice(orderCode);
		model.addAttribute("totalPrice", totalPrice);
		//System.out.println("Order code: " + orderCode);
		String districtValue = addressService.getDistrictValue(orderCode);
		//System.out.println("District Value: " + districtValue);
		String wardValue = addressService.getWardValue(orderCode);
		//System.out.println("Ward Value: " + wardValue);
		String districtName = addressService.getDistrictName(districtValue);
		//System.out.println("District Name: " + districtName);
		String wardName = addressService.getWardName(districtValue, wardValue);
		//System.out.println("Ward Name: " + wardName);
		String address = addressService.getAddress(orderCode);
		String fullAddress = address + " - " + wardName + " - " + districtName + " - " + " Hà Nội.";
		model.addAttribute("fullAddress", fullAddress);
		//System.out.println("full address: "+fullAddress);
		String date = orderSuccessService.getOrderDate(orderCode);
		model.addAttribute("date", date);
		int status = orderSuccessService.getStatus(orderCode);
		String Status = OrderSuccessDTO.SetStatus(status);
		String StatusStyle = OrderSuccessDTO.setStyle(status);
		model.addAttribute("Status", Status);
		model.addAttribute("StatusStyle", StatusStyle);
		return "custommer/view_my_order_success";
	}
	
	@GetMapping(value = "/profile/myOrderSuccess")
	public String myOrderSuccess(Model model) {
		List<OrderSuccessDTO> list = orderSuccessService.getMyOrderSuccess(this.user);
		model.addAttribute("list", list);
		return "custommer/myOrderSuccess";
	}
	
	@GetMapping(value = "/profile/myOrderCancel")
	public String myOrderCancel(Model model) {
		List<OrderSuccessDTO> list = orderSuccessService.getMyOrderCancel(this.user);
		model.addAttribute("list", list);
		return "custommer/myOrderCancel";
	}
}
