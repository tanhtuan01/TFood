//package com.tfood;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.tfood.model.CommentDTO;
//import com.tfood.service.CartService;
//import com.tfood.service.CategoryService;
//import com.tfood.service.CommentService;
//import com.tfood.service.FoodService;
//import com.tfood.service.OrderDetailService;
//import com.tfood.service.UserService;
//
//@Controller
//public class Comment {
//
//	@Autowired
//	CategoryService categoryService;
//	@Autowired
//	FoodService foodService;
//	@Autowired
//	CartService cartService;
//	@Autowired
//	UserService userService;
//	@Autowired
//	OrderDetailService orderDetailService;
//	@Autowired
//	CommentService commentService;
//	
//	
//	@RequestMapping(value = "/comment/{id}")
//	public String comment(@RequestParam(name = "content") String content,
//			@RequestParam(name = "score") int score,
//			HttpServletRequest request,
//			@PathVariable("id")int id
//			) {
//		int user_id = 0;
//		HttpSession session = request.getSession();
//		Object userid = session.getAttribute("userId");
//		if(userid == null) {
//			return "redirect:/web-login";
//		}
//		user_id = (Integer) userid;
//		
//		CommentDTO commentDTO = new CommentDTO();
//		commentDTO.setContent(content);
//		commentDTO.setScore(score);
//		commentDTO.setId_food(id);
//		commentDTO.setId_user(user_id);
//		
//		try {
//			commentService.addCommnet(commentDTO);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
////		
//		return "redirect:/view/{id}";
//	}
//}
