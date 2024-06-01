package com.tfood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutTFOODController {

	@GetMapping(value = "/contact-us")
	public String contactUs() {
		return"tfood_intro/contact_us";
	}
	
	@GetMapping(value = "/about-us")
	public String aboutUs() {
		return"tfood_intro/about_us";
	}
	
	@GetMapping(value = "/blog")
	public String blog() {
		return"tfood_intro/blog";
	}
	
}
