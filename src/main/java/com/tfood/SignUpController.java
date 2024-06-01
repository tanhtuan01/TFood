package com.tfood;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tfood.model.UserDTO;
import com.tfood.service.UserService;

@Controller
public class SignUpController {

	@Autowired
	UserService userService;
	
	String notify = "";
	
	@GetMapping(value = "/sign-up")
	public String signUp() {
		return "sign_up";
	}
	
	@PostMapping(value = "/sign-up")
	public String _signUp(@RequestParam(name = "hovaten")String hoVaTen,
						  @RequestParam(name = "sodienthoai")String soDienThoai,
						  @RequestParam(name = "matkhau")String matKhau,
//						  @RequestParam(name = "diachi")String diaChi,
						  @RequestParam(name = "avatar")MultipartFile avatar,
						  Model model, HttpServletRequest request) throws Exception, NumberFormatException{
		String img = avatar.getOriginalFilename();
		if(img.equals(null)||img.equals("")) {
			img = "user.png";
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setTenNguoiDung(hoVaTen);
		userDTO.setSoDienThoai(soDienThoai);
		userDTO.setMatKhau(matKhau);
//		userDTO.setDiaChi(diaChi);
		userDTO.setAvatar(img);
		
		if(userService.checkPhoneExists(soDienThoai) > 0) {
			notify = "Số Điện Thoại Đã Tồn Tại!!";
			model.addAttribute("hovaten", hoVaTen);
//			model.addAttribute("diachi", diaChi);
			model.addAttribute("notify", notify);
			return "sign_up";
		}else {
			try {
				SignInController.notify = "Tạo Tài Khoản Thành Công!!";
				userService.addUser(userDTO);
				model.addAttribute("hovaten", "");
				model.addAttribute("diachi", "");
				if(avatar.getOriginalFilename().equals("")) {
					System.out.println("Don't choose image");
				}else {
					String path = request.getSession().getServletContext().getRealPath("/") + "resources/images/";
				    FileUtils.forceMkdir(new File(path));
				    File upload = new File (path + avatar.getOriginalFilename());
				    avatar.transferTo(upload);
				}
				return "redirect:/sign-in";
			} catch (Exception e) {
				e.printStackTrace();
				
				notify = "Tạo Tài Khoản Thất Bại!!";
				
				model.addAttribute("hovaten", hoVaTen);
//				model.addAttribute("diachi", diaChi);
	
			}
		}
		
		model.addAttribute("notify", notify);
		return "sign_up";
	}
	
	@GetMapping(value = "/view/sign-up")
	public String view_signin() {
		return "redirect:/sign-up";
	}
	
}
