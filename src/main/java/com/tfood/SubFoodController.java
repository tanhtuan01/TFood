package com.tfood;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tfood.model.CategoryDTO;
import com.tfood.model.SubFoodDTO;
import com.tfood.service.CategoryService;
import com.tfood.service.SubFoodService;

@Controller
@RequestMapping(value = "/admin")
public class SubFoodController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	SubFoodService subFoodService;
	
	String notify = "";
	String script = "";
	String action = "addSubFood";
	String title  = "Thêm Mới";
	String required = "required";
	
	String tenMon = "";
	int gia	  = 0;
	String img	  = "";
	String moTa	  = "";
	int id = 0;
	
	@GetMapping(value = "/subFood")
	public String subFood(Model model) {
		if(AdminController.adminId < 0) {
			model.addAttribute("notify", "Bạn cần đăng nhập trước!!");
			return "admin/sign_in";
		}
		List<CategoryDTO> listCategories = categoryService.getAll();
		model.addAttribute("list", listCategories);
		model.addAttribute("notify", notify);
		model.addAttribute("script", script);
		List<SubFoodDTO> listSubFoodDTOs = subFoodService.getAll();
		model.addAttribute("subfood", listSubFoodDTOs);
		model.addAttribute("action", action);
		model.addAttribute("title", title);
		model.addAttribute("required", required);
		// 
		model.addAttribute("tenMon", tenMon);
		model.addAttribute("gia", gia);
		model.addAttribute("moTa", moTa);
		return "admin/sub_food";
	}
	
	@PostMapping(value = "/addSubFood")
	public String addSubFood(@RequestParam(name = "tenmon")String tenMon,
							 @RequestParam(name = "category")int category,
							 @RequestParam(name = "gia")int gia,
							 @RequestParam(name = "img")MultipartFile img,
							 @RequestParam(name = "mota")String moTa,
							 HttpServletRequest request) {
		SubFoodDTO subFoodDTO = new SubFoodDTO();
		subFoodDTO.setCategory(category);
		subFoodDTO.setTenMon(tenMon);
		subFoodDTO.setGia(gia);
		subFoodDTO.setImg(img.getOriginalFilename());
		subFoodDTO.setMoTa(moTa);
		try {
			subFoodService.addSubFood(subFoodDTO);
			notify = "Thêm Thành Công!!";
			String path = request.getSession().getServletContext().getRealPath("/") + "resources/images/";
		    FileUtils.forceMkdir(new File(path));
		    File upload = new File (path + img.getOriginalFilename());
		    img.transferTo(upload);
		    script = "document.getElementById(\"table\").style.display = 'none';\r\n"
					+ "			document.getElementById(\"btn-down\").style.display = '';\r\n"
					+ "			document.getElementById(\"btn-up\").style.display = 'none';";
		} catch (Exception e) {
			e.printStackTrace();
			notify = "Thêm Thất Bại!!";
		}
		return "redirect:/admin/subFood";
	}
	
	@GetMapping(value = "/deleteSubFood")
	public String deleteSubFood(@RequestParam(name = "id")int id) {
		try {
			subFoodService.deleteSubFood(id);
			notify = "Xóa Thành Công!!";
		} catch (Exception e) {
			e.printStackTrace();
			notify = "Xóa Thất Bại!!";
		}
		return "redirect:/admin/subFood";
	}
	
	@GetMapping(value = "/editSubFood")
	public String editSubFood(@RequestParam(name = "id")int id,
							  @RequestParam(name = "img")String img,
							  @RequestParam(name = "gia")int gia,
							  @RequestParam(name = "tenmon")String tenMon,
							  @RequestParam(name = "mota")String moTa) {
		this.gia = gia;
		this.tenMon = tenMon;
		this.id = id;
		this.moTa = moTa;
		this.img = img;
		this.action = "editSubFood";
		this.title = "Cập Nhật";
		this.required = "";
		this.script = "";
		return "redirect:/admin/subFood";
	}
	
	@PostMapping(value = "/editSubFood")
	public String _editSubFood(@RequestParam(name = "tenmon")String tenMon,
			 @RequestParam(name = "category")int category,
			 @RequestParam(name = "gia")int gia,
			 @RequestParam(name = "img")MultipartFile img,
			 @RequestParam(name = "mota")String moTa,
			 HttpServletRequest request) throws IOException {
		script = "document.getElementById(\"table\").style.display = 'none';\r\n"
				+ "			document.getElementById(\"btn-down\").style.display = '';\r\n"
				+ "			document.getElementById(\"btn-up\").style.display = 'none';";
		String img2= img.getOriginalFilename();
		
		if(img2.equals("") || img2.equals(null)) {

		}else {
			this.img = img2;
			try {
				String path = request.getSession().getServletContext().getRealPath("/") + "resources/images/";
			    FileUtils.forceMkdir(new File(path));
			    File upload = new File (path + img.getOriginalFilename());
			    img.transferTo(upload);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		SubFoodDTO subFoodDTO = new SubFoodDTO();
		subFoodDTO.setCategory(category);
		subFoodDTO.setGia(gia);
		subFoodDTO.setMoTa(moTa);
		subFoodDTO.setTenMon(tenMon);
		subFoodDTO.setImg(this.img);
		subFoodDTO.setId(this.id);
		try {
			
		    notify = "Cập Nhật Thành Công!!";
		    subFoodService.updateSubFood(subFoodDTO);
		} catch (Exception e) {
			e.printStackTrace();
			notify = "Cập Nhật Thất Bại!!";
		}
		reset();
		return "redirect:/admin/subFood";
	}
	
	public void reset() {
		this.gia = 0;
		this.tenMon = "";
		this.id = 0;
		this.moTa = "";
		this.img = "";
		this.action = "addSubFood";
		this.title = "Thêm Mới";
	}
	
	@PostMapping(value = "/searchSubFood")
	public String searchSubFood(@RequestParam(name = "name")String name,Model model) {
		List<SubFoodDTO> listSubFoodDTOs = subFoodService.getByName(name);
		model.addAttribute("subfood", listSubFoodDTOs);
		script = "document.getElementById(\"table\").style.display = 'none';\r\n"
				+ "			document.getElementById(\"btn-down\").style.display = '';\r\n"
				+ "			document.getElementById(\"btn-up\").style.display = 'none';";
		model.addAttribute("script", script);
		model.addAttribute("action", action);
		model.addAttribute("title", title);
		model.addAttribute("required", required);
		List<CategoryDTO> listCategories = categoryService.getAll();
		model.addAttribute("list", listCategories);
		return "admin/sub_food";
	}
	
	@GetMapping(value = "/list-sub-food")
	public String listSubFood(Model model) {
		if(AdminController.adminId < 0) {
			SignInController.notify = "Bạn cần đăng nhập trước!!";
			return "admin/sign_in";
		}
		List<CategoryDTO> listCategories = categoryService.getAll();
		model.addAttribute("listCategories", listCategories);
		List<SubFoodDTO> listSubFoodDTOs = subFoodService.getAll();
		model.addAttribute("subfood", listSubFoodDTOs);
		model.addAttribute("name", "Toàn bộ");
		return "admin/list_sub_food_by_category";
	}
	
	@GetMapping(value = "/listSubFoodByCategory/{id}/{name}")
	public String listSubFoodByCategory(@PathVariable("id")int id,
									    @PathVariable("name")String name,Model model) {
		List<CategoryDTO> listCategories = categoryService.getAll();
		model.addAttribute("listCategories", listCategories);
		List<SubFoodDTO> listSubFoodDTOs = subFoodService.getAllByCategory(id);
		model.addAttribute("subfood", listSubFoodDTOs);
		model.addAttribute("name", name);
		return "admin/list_sub_food_by_category";
	}
}
