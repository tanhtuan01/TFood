//package com.tfood;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.util.List;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.io.FileUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//
//import com.tfood.model.CategoryDTO;
//import com.tfood.service.CategoryService;
//import com.tfood.service.OrderDetailService;
//import com.tfood.service.RevenuaService;
//
//@Controller
//@RequestMapping("/admin")
//public class ControlCategory {
//	@Autowired
//	CategoryService categoryService;
//	String tmpAvatar = "";
//	String statuString = "";
//	@Autowired
//	OrderDetailService orderDetailService;
//	@Autowired
//	RevenuaService revenuaService;
//	@Autowired
//	ServletContext context;
//	
//	@RequestMapping( value = {"/web-admin","/",""})
//	public String AdminHome(HttpServletRequest request, Model model) {
//		
//		HttpSession session = request.getSession();
//		Object level = session.getAttribute("levelUser");
//		if(level == null) {
//			return "redirect:/web-login";
//		}
//		else if((Integer) level == 3) {
//			int ordersucess = orderDetailService.countOrderSucess();
//			model.addAttribute("orderOK", ordersucess);
//			int price = revenuaService.price();
//			model.addAttribute("price", price);
//			return "/admin/index";
//		}
//		else if((Integer) level == 2) {
//			return "redirect:/staff";
//		}
//		else if((Integer) level == 1) {
//			return "redirect:/shipper";
//		}
//		else if((Integer) level == 0  ) {
//			return "redirect:/myProfile";
//		}else {
//			return "redirect:/web-login";
//		}
//		
//	
//		
//	}
//	
//	@RequestMapping("/web-addCategory")
//	public String addCate(HttpServletRequest request) {
//		statuString = "";
//		return "/admin/add-category";
//	}
//	
//	@RequestMapping("/web-showCategory")
//	public String CategoryHome(Model model) {
//		//CategoryDTO categoryDTO = new CategoryDTO(123,"avt","21");
//		List<CategoryDTO> list = categoryService.getAll();
//		//model.addAttribute("message",categoryDTO);
//		model.addAttribute("Category",list);
//		model.addAttribute("status", statuString);
//		
//		return "/admin/list-category";
//	}
//	
//
//	
//	@RequestMapping(value = "/confirm-delete", method = RequestMethod.GET)
//	public String confirmDelete(Model model, @RequestParam(name = "id") int id, @RequestParam(name="kind") String kind, @RequestParam(name="name") String name, @RequestParam(name="backlink") String backlink, @RequestParam(name="delof") String delof){
//		model.addAttribute("Kind", kind);
//		model.addAttribute("Name", name);
//		model.addAttribute("BackLink",backlink);
//		model.addAttribute("DelOf",delof);
//		model.addAttribute("Id",id);
//		return "/admin/confirm_delete";
//	}
//	@RequestMapping(value = "/web-deleteCategory", method = RequestMethod.GET)
//	public String addCategory3Param(@RequestParam(name = "id") int id) {
//		try {
//			statuString = "Xóa thành công";
//			categoryService.delete(id);
//			return "/move/category";
//		} catch (Exception e) {
//			statuString = "Xóa thất bại";
//		}
//		return "/move/category";
//	}
//	
//	
//	@RequestMapping(value = "/addCategory", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//	public String addCategory(HttpServletRequest request, @RequestParam(name = "name") String name, @RequestParam(name = "avatar") MultipartFile avatar) 
//			throws IllegalStateException, IOException {
//	
//		CategoryDTO categoryDTO = new CategoryDTO();
//		categoryDTO.setName(name);
//		String avString = avatar.getOriginalFilename();
//		categoryDTO.setAvatar(avString);
//		
//		String path = request.getSession().getServletContext().getRealPath("/") + "resources/images/";
//	    FileUtils.forceMkdir(new File(path));
//	    File upload = new File (path + avatar.getOriginalFilename());
//	    avatar.transferTo(upload);
////	    String imagePath = request.getContextPath() + "/resources/images/" + avatar.getOriginalFilename();
//		
////		Path path = Paths.get("C://Users//VINHHOA//Desktop//Work_space//T-Food//src//main//webapp//resources//images//");
////		InputStream inputStream = avatar.getInputStream();
////		Files.copy(inputStream, path.resolve(avatar.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
//		
//		System.out.println("Name: " + categoryDTO.getName());
//		try {
//			categoryService.addCategory(categoryDTO);
//			statuString = "Thêm thành công";
//			return "/move/category";
//		} catch (Exception e) {
//			statuString = "Thêm thất bại";
//		}
//
//		return "/move/category";
//	}
//	
//	@RequestMapping(value = "web-admin-updateCategory")
//	public String updateCategoryString(@RequestParam(name = "id") int id,
//									   @RequestParam(name = "name") String name,
//									   @RequestParam(name = "avatar") String avatar, Model model) {
//		model.addAttribute("id", id);
//		model.addAttribute("name", name);
//		model.addAttribute("avatar", avatar);
//		tmpAvatar = avatar;
//		statuString = "";
//		return "/admin/edit-category";
//	}
//	
//	@RequestMapping(value = "updateCategory", method = RequestMethod.POST)
//	public String updateCategoryForm(@RequestParam(name = "name") String name, 
//			@RequestParam(name = "avatar") MultipartFile avatar,
//			@RequestParam(name="id")int id,
//			@RequestParam(name="lastImg") String lastImg) {
//		String avatarString = avatar.getOriginalFilename();
//		if(avatarString.equals("")) {
//			avatarString = lastImg;
//		}else {
//			
//			try {
//				Path path = Paths.get("C://Users//VINHHOA//Desktop//Work_space//OrderFood//src//main//webapp//resources//images//");
//				InputStream inputStream = avatar.getInputStream();
//				Files.copy(inputStream, path.resolve(avatar.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		CategoryDTO categoryDTO = new CategoryDTO();
//		categoryDTO.setName(name);
//		categoryDTO.setAvatar(avatarString);
//		categoryDTO.setId(id);
//		try {
//			categoryService.updateCategory(categoryDTO);
//			statuString = "Cập nhật thành công";
//			return "/move/category";
//		} catch (Exception e) {
//			statuString = "Cập nhật thất bại";
//			return "/move/category";
//		}
//	}
//	
//}
