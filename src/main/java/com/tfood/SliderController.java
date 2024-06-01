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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tfood.model.SliderDTO;
import com.tfood.service.SliderService;

@RequestMapping(value = "/admin")
@Controller
public class SliderController {

	@Autowired
	SliderService sliderService;
	
	String nd = "";
	String img = "";
	int stt;
	int id;
	String title = "Thêm Slider";
	String actionTitle = "Thêm";
	String action = "addSlider";
	String notify = "";
	String required = "required";
	
	@GetMapping(value = "/slider")
	public String slider(Model model) {
		List<SliderDTO> list = sliderService.getAll();
		model.addAttribute("list", list);
		model.addAttribute("title", title);
		model.addAttribute("action", action);
		model.addAttribute("actionTitle", actionTitle);
		model.addAttribute("notify", notify);
		model.addAttribute("stt", stt);
		model.addAttribute("nd", nd);
		model.addAttribute("required", required);
		return "admin/slider";
	}
	
	@PostMapping(value = "/addSlider")
	public String addSlider(@RequestParam(name = "nd")String nd,
							@RequestParam(name = "img")MultipartFile img,
							@RequestParam(name = "stt")int stt,
							HttpServletRequest request) {
		int check = sliderService.checkSttExistsBeforeAdd(stt);
		if(check > 0) {
			this.nd = nd;
			notify = "Hãy chọn số thứ tự khác!!";
			return "redirect:/admin/slider#slider";
		}
		SliderDTO sliderDTO = new SliderDTO();
		sliderDTO.setStt(stt);
		sliderDTO.setImg(img.getOriginalFilename());
		sliderDTO.setNoiDung(nd);
		try {
			sliderService.addSlider(sliderDTO);
			notify = "Thêm slider thành công!!";
			String path = request.getSession().getServletContext().getRealPath("/") + "resources/images/slider/";
		    FileUtils.forceMkdir(new File(path));
		    File upload = new File (path + img.getOriginalFilename());
		    img.transferTo(upload);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("addSlider");
		return "redirect:/admin/slider";
	}
	//editSlider?id=${slider.id}&nd=${slider.noiDung}&img=${slider.img}&stt=${slider.stt}
	@GetMapping(value = "/editSlider")
	public String editSlider(@RequestParam(name = "id")int id,
							@RequestParam(name = "nd")String nd,
							@RequestParam(name = "img")String img,
							@RequestParam(name = "stt")int stt) {
		this.id = id;
		this.nd = nd;
		this.img = img;
		this.stt = stt;
		this.action = "editSlider";
		this.actionTitle = "Cập nhật";
		this.title = "Cập Nhật Slider";
		this.required = "";
		System.out.println("Get: editSlider");
		this.notify = "";
		return "redirect:/admin/slider#slider";
	}
	
	@PostMapping(value = "/editSlider")
	public String editSliders(@RequestParam(name = "nd")String nd,
							@RequestParam(name = "img")MultipartFile img,
							@RequestParam(name = "stt")int stt,
			HttpServletRequest request) {
		int check = sliderService.checkSttExists(stt,this.id);
		if(check > 0) {
			this.nd = nd;
			notify = "Hãy chọn số thứ tự khác!!";
			return "redirect:/admin/slider#slider";
		}
		String im = img.getOriginalFilename();
		if(im.equals("")) {
			im = this.img;
		}
		SliderDTO sliderDTO = new SliderDTO();
		sliderDTO.setNoiDung(nd);
		sliderDTO.setStt(stt);
		sliderDTO.setImg(im);
		sliderDTO.setId(this.id);
		try {
			sliderService.updateSlider(sliderDTO);
			notify = "Cập nhật slider thành công!!";
			reset();
			if(!img.equals("")) {
				try {
					String path = request.getSession().getServletContext().getRealPath("/") + "resources/images/slider/";
				    FileUtils.forceMkdir(new File(path));
				    File upload = new File (path + img.getOriginalFilename());
				    img.transferTo(upload);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/admin/slider";
	}
	
	@GetMapping(value = "/deleteSlider")
	public String deleteSlider(@RequestParam(name = "id")int id) {
		try {
			this.required = "";
			sliderService.deleteSlider(id);
			reset();
			notify = "Xóa slider thành công!!";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/admin/slider";
	}
	
	public void reset() {
		this.nd = "";
		this.img = "";
		this.stt = 0;
		this.id = 0;
		this.title = "Thêm Slider";
		this.actionTitle = "Thêm";
		this.action = "addSlider";
	}
}
