package com.tfood;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tfood.model.CategoryDTO;
import com.tfood.model.FoodDTO;
import com.tfood.service.CategoryService;
import com.tfood.service.FoodService;

@Controller
@RequestMapping(value = "/admin")
public class FoodController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	FoodService foodService;
	
	String notify = "";
	String action = "addMainFood";
	String title = "Thêm Mới";
	int id = 0;
	String tenmon = "";
	String title2  = "";
	int gia	  = 0;
	int giamgia = 0;
	String img	= "";
	String mota = "";
	String script = "";
	
	@GetMapping(value = {"food","/food"})
	public String food(Model model) {
		if(AdminController.adminId < 0) {
			model.addAttribute("notify", "Bạn cần đăng nhập trước!!");
			return "admin/sign_in";
		}
		List<CategoryDTO> listCategories = categoryService.getAll();
		List<FoodDTO> listFoods = foodService.getAll();
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("listFoods", listFoods);
		model.addAttribute("notify", notify);
		model.addAttribute("action", action);
		model.addAttribute("title", title);
		// form
		model.addAttribute("gia", gia);
		model.addAttribute("giamgia", giamgia);
		model.addAttribute("tenmon", tenmon);
		model.addAttribute("id", id);
		model.addAttribute("mota", mota);
		model.addAttribute("title2", title2);
//		model.addAttribute("script", script);
		return "admin/food";
	}
	
	@RequestMapping(value = "/addMainFood", method = RequestMethod.POST,  produces = "text/plain;charset=UTF-8")
	public String addMainFood(@RequestParam(name = "tenmon")String tenMon,
							  @RequestParam(name = "title")String title,
							  @RequestParam(name = "category")String category,
							  @RequestParam(name = "gia")String gia,
							  @RequestParam(name = "giamgia")String giamGia,
							  @RequestParam(name = "img")MultipartFile img,
							  @RequestParam(name = "description")String moTa,
							  @RequestParam(name = "trangthai")int trangThai,
							  HttpServletRequest request) {
		Integer giaMoi = (int) (Integer.parseInt(gia) - (Integer.parseInt(gia) * Double.parseDouble(giamGia)/100 ));
		FoodDTO foodDTO = new FoodDTO();
		foodDTO.setCategory(Integer.parseInt(category));
		foodDTO.setTitle(title);
		foodDTO.setTenMon(tenMon);
		foodDTO.setGia(Integer.parseInt(gia));
		foodDTO.setGiamGia(Integer.parseInt(giamGia));
		foodDTO.setGiaMoi(giaMoi);
		foodDTO.setImg(img.getOriginalFilename());
		foodDTO.setMoTa(moTa);
		foodDTO.setTrangThai(trangThai);
		foodDTO.setDaBan(0);
//		System.out.println(foodDTO);
//		System.out.println("Gia moi: " + giaMoi);
		try {
			foodService.addFood(foodDTO);
			notify = "Thêm Thành Công!!";
	    	String path = request.getSession().getServletContext().getRealPath("/") + "resources/images/";
		    FileUtils.forceMkdir(new File(path));
		    File upload = new File (path + img.getOriginalFilename());
		    img.transferTo(upload);
//		    System.out.println("upload: "+upload);
//		    System.out.println("path: " + path);
	    	
	    } catch (Exception e) {
			e.printStackTrace();
			notify = "Thêm Thất Bại!!";
		}
		return "redirect:/admin/food";
	}
	
	
	@RequestMapping(value = "/deleteMainFood", method = RequestMethod.GET)
	public String deleteMainFood(@RequestParam(name = "id")int id) {
		System.out.println(id);
		try {
			foodService.delete(id);
			notify = "Xóa Thành Công!!";
		} catch (Exception e) {
			notify = "Xóa Thất Bại!!";
		}
		reset();
		return "redirect:/admin/food";
	}
	
	@RequestMapping(value = "/deleteMainFoods", method = RequestMethod.GET)
	public String deleteMainFoods(@RequestParam(name = "id")int id) {
		System.out.println(id);
		try {
			foodService.delete(id);
			notify = "Xóa Thành Công!!";
		} catch (Exception e) {
			notify = "Xóa Thất Bại!!";
		}
		reset();
		return "redirect:/admin/list-food";
	}
	
//	editMainFood?id=${list.id}&tenMon=${list.tenMon}&title=${list.title}&img=${list.img}&gia=${list.gia}&giamgia=${list.giamGia}&mota=${list.moTa}
	@GetMapping(value = "/editMainFood")
	public String editMainFood(@RequestParam(name = "id")int id,
							   @RequestParam(name = "tenmon")String tenmon,
							   @RequestParam(name = "title")String title,
							   @RequestParam(name = "img")String img,
							   @RequestParam(name = "gia")int gia,
							   @RequestParam(name = "giamgia")int giamgia,
							   @RequestParam(name = "mota")String mota
							   ) {
//		System.out.println(id);
//		System.out.println(tenmon + " " + title + " " + img + " " + gia + " " + giamgia + " " + mota);
		this.tenmon = tenmon;
		this.title2 = title;
		this.gia = gia;
		this.giamgia = giamgia;
		this.mota = mota;
		this.img = img;
		this.id = id;
		this.action = "editMainFood";
		this.title = "Cập Nhật";
		return "redirect:/admin/food";
	}
	
	
	@PostMapping(value = "/editMainFood")
	public String _editMainFood(@RequestParam(name = "id")int id,
							   @RequestParam(name = "tenmon")String tenmon,
							   @RequestParam(name = "title")String title,
							   @RequestParam(name = "img")MultipartFile img,
							   @RequestParam(name = "gia")String gia,
							   @RequestParam(name = "giamgia")String giamgia,
							   @RequestParam(name = "description")String mota,
							   HttpServletRequest request,
							   @RequestParam(name = "category")int category,
							   @RequestParam(name = "trangthai")int trangthai) {
		if (img.getOriginalFilename().equals(null) || img.getOriginalFilename().equals("")) {
			
		}else {
			this.img = img.getOriginalFilename();
			try {
				String path = request.getSession().getServletContext().getRealPath("/") + "resources/images/";
			    FileUtils.forceMkdir(new File(path));
			    File upload = new File (path + img.getOriginalFilename());
			    img.transferTo(upload);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		Integer giaMoi = (int) (Integer.parseInt(gia) - (Integer.parseInt(gia) * Double.parseDouble(giamgia)/100 ));
		FoodDTO foodDTO = new FoodDTO();
		foodDTO.setCategory(category);
		foodDTO.setId(this.id);
		foodDTO.setMoTa(mota);
		foodDTO.setImg(this.img);
		foodDTO.setGia(Integer.parseInt(gia));
		foodDTO.setGiamGia(Integer.parseInt(giamgia));
		foodDTO.setGiaMoi(giaMoi);
		foodDTO.setTitle(title);
		foodDTO.setTenMon(tenmon);
		foodDTO.setTrangThai(trangthai);
		System.out.println(foodDTO);
		try {
			foodService.updateFood(foodDTO);
			notify = "Cập Nhật Thành Công!!";
			reset();
		} catch (Exception e) {
			e.printStackTrace();
			notify = "Cập Nhật Thất Bại!!";
			reset();
		}
		return "redirect:/admin/food";
	}
	
	public void reset() {
		this.tenmon = "";
		this.title2 = "";
		this.gia = 0;
		this.giamgia = 0;
		this.mota = "";
		this.img = "";
		this.id = 0;
		this.action = "addMainFood";
		this.title = "Thêm Mới";
		this.script = "";
	}
	
	@RequestMapping(value = "/searchFood", method = RequestMethod.POST)
	public String searchFood(@RequestParam(name = "tenmon")String tenmon, Model model) {
		System.out.println(tenmon);
		script = "document.getElementById(\"table\").style.display = 'none';\r\n"
				+ "			document.getElementById(\"btn-down\").style.display = '';\r\n"
				+ "			document.getElementById(\"btn-up\").style.display = 'none';";
		
		List<FoodDTO> listFoods = foodService.getByName(tenmon);
		model.addAttribute("listFoods", listFoods);
		model.addAttribute("script", script);
		return "admin/food";
	}
	
	///T-Food/admin/cancelUpdateFood
	
	@GetMapping(value = "/cancelUpdateFood")
	public String cancelUpdateFood() {
		reset();
		return "redirect:/admin/food";
	}

	@GetMapping(value = "/list-food")
	public String foodByCategory(Model model) {
		List<FoodDTO> listFoods = foodService.getAll();
		List<CategoryDTO> listCategories = categoryService.getAll();
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("listFoods", listFoods);
		model.addAttribute("notify", notify);
		return "admin/food_by_category";
	}
	
	@GetMapping(value = "/listByCategory/{id}/{name}")
	public String listByCategory(Model model, @PathVariable("id")int id,
										@PathVariable("name")String name) {
		List<FoodDTO> listFoods = foodService.getAllByCategory(id);
		List<CategoryDTO> listCategories = categoryService.getAll();
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("listFoods", listFoods);
		model.addAttribute("name", "Danh Mục: " + name);
		return "admin/food_by_category";
	}
}
