<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Hồ Sơ</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home_style.css"/>">
	<script src="https://kit.fontawesome.com/6426e3ba61.js" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<link rel="icon" type="image/x-icon" href="<c:url value="/resources/images/favicon/favicon_1.ico"/>" >

</head>
<body>
	
	<!-- Top -->
	<div class="main container-fluid top-bar">
		<div class="container ">
			<div class="row">
				<div class="col-md-8">
					<a href="/T-Food/"><h1 class="txt-tfood2">TFOOD</h1></a>
					<i class="fab fa-viber">&nbsp;</i><a class="phone" href="tel:">0963 97 65 65</a>
				</div>
				<div class="col-md-4 p-sign">
					<div class="row">
						<div class="col-md-6"></div>
						<div class="col-md-6">
							<a href="sign-out" style="color:white;text-align: right;">
								Đăng Xuất
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Body -->
	<div class="container-fluid body">
		<!-- <div class="container input-group">
			<div class="form-outline">
				<input type="search" id="form1" class="form-control" />
				<label class="form-label" for="form1">Search</label>
		  	</div>
		  	<button type="submit" class="btn btn-primary">
		    	<i class="fas fa-search"></i>
		  	</button>
		</div> -->

		<div class="container form-cart">
			<div class="row">

				<div class="col-md-10"></div>
				<div class="col-md-2 cart">
					<a href="myCart">
						<button class="btn btn-info">
							<i class="fas fa-dolly">&nbsp;&nbsp;(${cartQuantity}) Giỏ hàng</i>
						</button>
					</a>
				</div>
			</div>
		</div>
		<div class="container first-category">
			<div class="row">
				<div class="col-md-2" style="text-align: center;color: white;">
					
				</div>
				<div class="col-md-8 menu1">
					<ul>
						<a href="/T-Food/"><li style="margin-left: -30px;">Trang Chủ</li></a>
						<a href="/T-Food/blog"><li>Bài Viết</li></a>
						<a href="/T-Food/about-us"><li>Giới Thiệu</li></a>
						<a href="/T-Food/contact-us"><li>Liên Hệ</li></a>
					</ul>
				</div>
			</div>
		</div>
		<hr style="margin: 0px 0px 10px 0px; background: #17a2c6;height: 5px;">
	

		<div class="container">
			<div class="row">
				<div class="col-md-10">
					<h5 class="title">Thông Tin Cá Nhân</h5>
					<hr style="background: #17a2c6;height: 5px;">
				</div>
				<div class="col-md-2">
					<div class="top-self">
						<h5>Bán Chạy</h5>
						<div class="top-self-2"><h5>Bán Chạy</h5></div>
					</div>

				</div>
			</div>
			<div class="row ">
				<div class="col-md-10 profile">
					<div class="row">
						<div class="col-md-3">
							<ul>
								<a href="/T-Food/profile/"><li>Thông tin</li></a>
							
								<li style="list-style:none;border-top:1px solid #17e6;color:#17a2c6">Đơn của bạn</li>
								<a href="/T-Food/profile/myOrderSuccess"><li><b>Đơn đã nhận</b></li></a>
								<a href="/T-Food/profile/myOrderCancel"><li>Đơn đã hủy</li></a>
								<a href="/T-Food/profile/myComment"><li>Bình luận của bạn</li></a>
							</ul>
						</div>	
						<div class="col-md-9" style="border-left: 1px solid black;height: 200px">
							
							<div class="row">
								<h6>Đã mua gần đây</h6>
							
								<div class="col-md-5">
									<b>Mã đơn hàng</b>
								</div>
								<div class="col-md-2">
									<b>Ngày đặt</b>
								</div>
								<div class="col-md-3" style="text-align:center;">
									<b>Trạng thái</b>
								</div>
								<div class="col-md-2">
									<b>Tổng tiền</b>
								</div>

							</div>
							<c:forEach items="${list}" var="list">
							<div class="row" style="padding:5px">
							
								<div class="col-md-5">
									${list.orderCode}
								</div>
								<div class="col-md-2">
									<p>${list.date}</p>
								</div>
								<div class="col-md-3">
									<p style="text-align:center;">
										<button class="${list.setStyle()}">${list.Status()}</button>
									</p>
								</div>
								<div class="col-md-2">
									<p><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${list.totalPrice}"/>đ</p>
								</div>
							<a style="text-align:right" href="/T-Food/viewMyOrderSuccess/${list.orderCode}">Xem</a>
							</div>
							<hr style="margin:0px;padding:0px">
							</c:forEach>
							
						</div>
					
						
					</div>
				</div>
				<div class="col-md-2">
					<marquee direction="up" scrollamount="3" style="height: 300px;" behavior="alternate" >
						
						<a href="#">
							<div  style="margin-bottom: 10px;">
								<img class="avt" src="_t.anh.tuan_.jpg">
							</div>
						</a>
						<a href="#">
							<div  style="margin-bottom: 10px;">
								<img class="avt" src="_t.anh.tuan_.jpg">
							</div>
						</a>
						<a href="#">
							<div  style="margin-bottom: 10px;">
								<img class="avt" src="_t.anh.tuan_.jpg">
							</div>
						</a>
						
					</marquee>
				</div>
			</div>
			
		</div>


	</div>
	<!-- Footer -->
	<div class="container-fluid footer">
		<div class="container">
			<div class="row">
				<h1 class="txt-tfood">TFOOD</h1>
				<hr class="hr-footer">
			</div>
			<div class="row before-last">
				<div class="col-md-3">
					<p>
						<a href="">Giới thiệu Tfood</a>
					</p>
					<p>
						<a href="">Blog</a>
					</p>
					<p>
						<a href="">Trung tâm hỗ trợ</a>
					</p>
					<p>
						<a href="">Câu hỏi thường gặp</a>
					</p>
				</div>
				<div class="col-md-3">
					<p>
						Mạng xã hội
					</p>
					<p>
						<a href="https://www.instagram.com/_t.anh.tuan_/">
							<i class="fab fa-instagram"></i>
						</a> &nbsp;
						<a href="https://www.facebook.com/t.a.t.14.08/">
							<i class="fab fa-facebook-f"></i>
						</a>&nbsp;
						<a href="#!">
							<i class="fab fa-pinterest"></i>
						</a>&nbsp; <br>
						<a href="">
							<i class="fab fa-twitter"></i>
						</a>&nbsp;
						<a href="">
							<i class="fab fa-youtube"></i>
						</a>
					</p>
				</div>
		
				<div class="col-md-6">
					<p>
						Địa chỉ cửa hàng
					</p>
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.676989822024!2d105.80168511485398!3d21.00558128601094!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135aca1f608e5d5%3A0x1a8159d717fd1eff!2zMSBIb8OgbmcgxJDhuqFvIFRow7p5LCBOaMOibiBDaMOtbmgsIFRoYW5oIFh1w6JuLCBIw6AgTuG7mWkgMTIwNjM4LCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1652553975884!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
				</div>
				<hr class="hr-footer">
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="row">
						<div class="col-md-4">
							<img src="<c:url value="/resources/images/AppStore-vn.png"/>" class="app-download" style="height: 65px;">
						</div>
						<div class="col-md-4">
							<img src="<c:url value="/resources/images/PlayStore-vn.png"/>" class="app-download">
						</div>
						<div class="col-md-4"></div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="row last-right">
						<div class="col-md-1"></div>
						<div class="col-md-3">@2022Tfood</div>
						<div class="col-md-4"><a href="#!">Câu hỏi thường gặp</a></div>
						<div class="col-md-4"><a href="#!">Chính sách bảo mật</a></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="social">
		<div class="instagram icon">
			<a href="https://www.instagram.com/_t.anh.tuan_/"><i class="fab fa-instagram"></i></a>
		</div>
		<div class="facebook icon">
			<a href="https://www.facebook.com/t.a.t.14.08/"><i class="fab fa-facebook-f"></i></a>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

</body>
</html>