package com.tfood;

import java.io.File;
import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tfood.model.CategoryDTO;
import com.tfood.service.CategoryService;

@Controller
@RequestMapping(value = "/admin")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	ServletContext servletContext;
	
	int id = 0;
	String action = "addCategory";
	String title = "Thêm Mới";
	String img = "";
	String tenDanhMuc = "";
	String titleCategory = "";
	int thuTuHienThi = 0;
	String messages = "";
	
	@RequestMapping(value = "/category")
	public String category(Model model) {
		if(AdminController.adminId < 0) {
			model.addAttribute("notify", "Bạn cần đăng nhập trước!!");
			return "admin/sign_in";
		}
		List<CategoryDTO> list = categoryService.getAll();
		model.addAttribute("list", list);
		model.addAttribute("action", action);
		model.addAttribute("title", title);
		model.addAttribute("tenDanhMuc", tenDanhMuc);
		model.addAttribute("titleCategory", titleCategory);
		model.addAttribute("thuTuHienThi", thuTuHienThi);
		model.addAttribute("messages", messages);
		return "admin/category";
	}
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String addCategory(@RequestParam(name = "tendanhmuc")String tenDanhMuc,
							  @RequestParam(name = "title")String title,
							  @RequestParam(name = "thutuhienthi")int thuTuHienThi,
							  @RequestParam(name = "img")MultipartFile img,
							  HttpServletRequest request) throws IOException {
		
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setImg(img.getOriginalFilename());
		categoryDTO.setTenDanhMuc(tenDanhMuc);
		categoryDTO.setThuTuHienThi(thuTuHienThi);
		categoryDTO.setTitle(title);
		
//		String path = request.getSession().getServletContext().getRealPath("/") + "resources/images/";
//	    FileUtils.forceMkdir(new File(path));
//	    File upload = new File (path + img.getOriginalFilename());
//	    img.transferTo(upload);
//	    System.out.println("upload: "+upload);
//	    System.out.println("path: " + path);
	    try {
//	    	String imagePath = request.getContextPath() + "/resources/images/";
//			File uFile = new File(imagePath + img.getOriginalFilename());
//			img.transferTo(uFile);
//			System.out.println("image path: " + imagePath);
//			System.out.println("file: " + uFile);
//			Path path2 = Paths.get("C:\\Users\\VINHHOA\\Desktop\\Work_space\\T-Food\\src\\main\\webapp\\resources\\images\\");
//			InputStream inputStream = img.getInputStream();
//			Files.copy(inputStream, path2.resolve(img.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		
	    	String path = request.getSession().getServletContext().getRealPath("/") + "resources/images/";
		    FileUtils.forceMkdir(new File(path));
		    File upload = new File (path + img.getOriginalFilename());
		    img.transferTo(upload);
//		    System.out.println("upload: "+upload);
//		    System.out.println("path: " + path);
	    	
	    } catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			messages = "Thêm Thành Công!!";
			categoryService.addCategory(categoryDTO);
		} catch (Exception e) {
			messages = "Thêm Thất Bại!!";
		}	
		return "redirect:/admin/category";
	}
	
	
	@RequestMapping(value = "/deleteCategory",method = RequestMethod.GET)
	public String deleteCategory(@RequestParam(name = "id")int id) {
		try {
			messages = "Xóa Thành Công!!";
			categoryService.delete(id);
		} catch (Exception e) {
			messages = "Xóa Thất Bại!!";
		}
		return "redirect:/admin/category";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(name = "id")int id,
			@RequestParam(name = "img")String img,
			@RequestParam(name = "tenDanhMuc")String tenDanhMuc,
			@RequestParam(name = "title")String titleCategory,
			@RequestParam(name = "thuTuHienThi")int thuTuHienThi) {
		this.id = id;
		this.img = img;
		this.tenDanhMuc = tenDanhMuc;
		this.thuTuHienThi = thuTuHienThi;
		this.titleCategory = titleCategory;
//		System.out.println(titleCategory);
		action = "editCategory";
		this.title = "Cập Nhật";
		messages = "";
		return "redirect:/admin/category";
	}
	
	@RequestMapping(value = "/editCategory", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String editCategory(@RequestParam(name = "tendanhmuc")String tenDanhMuc,
							  @RequestParam(name = "title")String title,
							  @RequestParam(name = "thutuhienthi")int thuTuHienThi,
							  @RequestParam(name = "img")MultipartFile img,
							  HttpServletRequest request) {
		String img2=img.getOriginalFilename();
		
		if(img2.equals("")||img2.equals(null)) {
			img2 = this.img;
		}
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(this.id);
		categoryDTO.setImg(img2);
		categoryDTO.setTenDanhMuc(tenDanhMuc);
		categoryDTO.setTitle(title);
		categoryDTO.setThuTuHienThi(thuTuHienThi);
		//System.out.println("UPDATE: " +categoryDTO);
		try {
			messages = "Cập Nhật Thành Công!!";
			categoryService.update(categoryDTO);
			reset();
			if(!img2.equals("")) {
				try {
					String path = request.getSession().getServletContext().getRealPath("/") + "resources/images/";
				    FileUtils.forceMkdir(new File(path));
				    File upload = new File (path + img.getOriginalFilename());
				    img.transferTo(upload);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			messages = "Cập Nhật Thất Bại!!";
			e.printStackTrace();
		}
		return "redirect:/admin/category";
	}
	
	public void reset() {
		this.id = 0;
		this.action = "addCategory";
		this.title = "Thêm Mới";
		this.img = "";
		this.tenDanhMuc = "";
		this.titleCategory = "";
		this.thuTuHienThi = 0;
	}
	
	@RequestMapping(value = "/searchCategory", method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
	public String search(@RequestParam(name = "name")String name, Model model) {
		List<CategoryDTO> list = categoryService.searchCategory(name);
		model.addAttribute("list", list);
		model.addAttribute("name", name);
		return "admin/search_category";
	}
}
