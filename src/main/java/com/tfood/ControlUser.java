package com.tfood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/admin")
public class ControlUser {

	@RequestMapping("/userManager")
	public String user() {
		return "admin/user";
	}
	
	@RequestMapping( value = "/addUser", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String addUser(@RequestParam(name = "name") String name,
							@RequestParam(name = "number") int number,
							@RequestParam(name = "passwords") String passwords,
							@RequestParam(name = "level") int level) {
		
		return "";
	}
	
}
