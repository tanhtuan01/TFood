package com.tfood;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tfood.model.AnotherAdsDTO;
import com.tfood.service.AnotherService;

@Controller
public class ImgAdsController {

	@Autowired
	AnotherService anotherService;
	
	String content = "";
	String img = "";
	String title = "Thêm Ads";
	String actionTitle = "Thêm";
	String action = "addAds";
	String notify = "";
	String required = "required";
	String link = "";
	int id = 0;
	
	@GetMapping(value = "/admin/img-ads")
	public String img_ads(Model model) {
		List<AnotherAdsDTO> list = anotherService.getAll();
		model.addAttribute("list", list);
		model.addAttribute("title", title);
		model.addAttribute("action", action);
		model.addAttribute("actionTitle", actionTitle);
		model.addAttribute("notify", notify);
		model.addAttribute("content", content);
		model.addAttribute("required", required);
		model.addAttribute("link", link);
		return "admin/img_ads";
	}
	
	@PostMapping(value = "/admin/addAds")
	public String addAds(@RequestParam(name = "link")String link,
						 @RequestParam(name = "img")MultipartFile img,
						 @RequestParam(name = "content")String content,
						 HttpServletRequest request) {
		
		AnotherAdsDTO adsDTO = new AnotherAdsDTO();
		adsDTO.setContent(content);
		adsDTO.setImg(img.getOriginalFilename());
		adsDTO.setLink(link);
		try {
			anotherService.addAds(adsDTO);
			String path = request.getSession().getServletContext().getRealPath("/") + "resources/images/";
		    FileUtils.forceMkdir(new File(path));
		    File upload = new File (path + img.getOriginalFilename());
		    img.transferTo(upload);
		    notify = "Thêm thành công!!";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/admin/img-ads";
	}
	
	@GetMapping(value = "/admin/deleteAds")
	public String deleteAds(@RequestParam(name = "id")int id) {
		try {
			anotherService.deleteAds(id);
			notify = "Xóa thành công!!";
		} catch (Exception e) {
			notify = "Xóa thất bại!!";
		}
		return "redirect:/admin/img-ads";
	}
	
	@GetMapping(value = "/admin/editAds")
	public String editAds(@RequestParam(name = "content")String content,
						 @RequestParam(name = "link")String link,
						 @RequestParam(name = "img")String img,
						 @RequestParam(name = "id")int id) {
		title = "Sửa";
		notify = "";
		this.content = content;
		this.link = link;
		this.img = img;
		this.action = "editAds";
		this.actionTitle = "Cập nhật";
		this.required = "";
		this.id = id;
		return "redirect:/admin/img-ads";
	}
	
	@PostMapping(value = "/admin/editAds")
	public String EditAds(@RequestParam(name = "link")String link,
			 @RequestParam(name = "img")MultipartFile img,
			 @RequestParam(name = "content")String content,
			 HttpServletRequest request) {
		
		AnotherAdsDTO adsDTO = new AnotherAdsDTO();
		adsDTO.setContent(content);
		adsDTO.setLink(link);
		adsDTO.setId(this.id);
		if(img.getOriginalFilename().equals("")) {
			adsDTO.setImg(this.img);
		}else {
			adsDTO.setImg(img.getOriginalFilename());
		}
		try {
			anotherService.updateAds(adsDTO);
			if(!img.getOriginalFilename().equals("")) {
				String path = request.getSession().getServletContext().getRealPath("/") + "resources/images/";
			    FileUtils.forceMkdir(new File(path));
			    File upload = new File (path + img.getOriginalFilename());
			    img.transferTo(upload);
			    notify = "Cập nhật thành công!!";
			}
		} catch (Exception e) {
			notify = "Cập nhật thất bại!!";
		}
		reset();
		return "redirect:/admin/img-ads";
	}
	
	public void reset() {
		this.content = "";
		this.img = "";
		this.title = "Thêm Ads";
		this.actionTitle = "Thêm";
		this.action = "addAds";
		this.required = "required";
		this.link = "";
	}
}
