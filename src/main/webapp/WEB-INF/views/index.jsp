<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>TFood - ${h_title}</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/home_style.css"/>">
<script src="https://kit.fontawesome.com/6426e3ba61.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<link rel="icon" type="image/x-icon"
	href="<c:url value="/resources/images/favicon/favicon_1.ico"/>">

</head>
<body>



	<!-- Top -->
	<div class="main container-fluid top-bar">
		<div class="container ">
			<div class="row">
				<div class="col-md-8">
					<!-- fas fa-phone -->
					<a href=""><h1 class="txt-tfood2">TFOOD</h1></a> <i
						class="fab fa-viber">&nbsp;</i><a class="phone" href="tel:">0963
						97 65 65</a>
				</div>
				<div class="col-md-4 p-sign">
					<p style="${style}">
						<a href="sign-in" class="sign">Đăng Nhập</a>&nbsp;<b
							style="color: silver">|</b>&nbsp; <a href="sign-up" class="sign">Đăng
							Ký</a>&nbsp;<b style="color: silver">|</b>&nbsp;
					</p>

					<div class="row">
						<div class="col-md-6"></div>
						<div class="col-md-6 tk-users" style="${style2}">
							<a href="profile" style="color: white; text-align: right;">
								Tài Khoản Của Tôi </a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Body -->
	<div class="container-fluid body">

		<div class="container form-cart">
			<div class="row">

				<div class="col-md-10">
					<form class="form-outline" method="post" action="tim-kiem">
						<span> <input name="txt-search" type="search"
							placeholder="Nhập tên món..." id="form1" class="form-control"
							autocomplete="off" /> <!-- <label class="form-label" for="form1">Search</label> -->
						</span>
						<button type="submit" class="btn btn-primary"
							style="height: 40px;">
							<i class="fas fa-search"></i>
						</button>
					</form>
				</div>

				<div class="col-md-2 cart">
					<a href="myCart">
						<button class="btn btn-info">
							<i class="fas fa-dolly">&nbsp;&nbsp;(${cartQuantity}) Giỏ
								hàng</i>
						</button>
					</a>
				</div>
			</div>
		</div>
		<div class="container first-category">
			<div class="row">
				<div class="col-md-2" style="text-align: center; color: white;">
					<i style="margin-left: -50px" class="fas fa-stream"></i>&nbsp;Danh
					Mục
				</div>
				<div class="col-md-8 menu1">
					<ul>
						<a href="/T-Food/"><li style="margin-left: -30px;">Trang
								Chủ</li></a>
						<a href="/T-Food/blog"><li>Bài Viết</li></a>
						<a href="/T-Food/about-us"><li>Giới Thiệu</li></a>
						<a href="/T-Food/contact-us"><li>Liên Hệ</li></a>
					</ul>
				</div>
			</div>
		</div>
		<hr
			style="margin: 0px 0px 10px 0px; background: #17a2c6; height: 5px;">
		<div class="container ">
			<div class="row">
				<div class="col-md-2 category">
					<ul>
						<a href="dang-giam-gia"><li>Đang Giảm Giá</li></a>

						<c:forEach items="${list}" var="list">
							<a href="${list.title}"><li>${list.tenDanhMuc}</li></a>
						</c:forEach>

					</ul>
				</div>
				<div class="col-md-8 slide">
					<div id="carouselExampleControls" class="carousel slide"
						data-ride="carousel">
						<div class="carousel-inner">
							<c:forEach items="${slider}" var="slider">
								<div class="${slider.setClass()}">
									<img class="d-block w-100"
										src="<c:url value="/resources/images/slider/${slider.img}"/>">
									<h5
										style="position: absolute; bottom: 0; padding: 2px; color: white; font-weight: bold; text-transform: uppercase; width: 100%; background-color: #17a2c6; text-align: center;">
										${slider.noiDung}</h5>
								</div>
							</c:forEach>

							<a class="carousel-control-prev" href="#carouselExampleControls"
								role="button" data-slide="prev"> <span
								class="carousel-control-prev-icon" aria-hidden="true"></span> <span
								class="sr-only">Previous</span>
							</a> <a class="carousel-control-next" href="#carouselExampleControls"
								role="button" data-slide="next"> <span
								class="carousel-control-next-icon" aria-hidden="true"></span> <span
								class="sr-only">Next</span>
							</a>
						</div>
					</div>
				</div>
				<div class="col-md-2 ads">
					<c:forEach items="${ads}" var="ads">
						<a href="${ads.link}"> <img class="avt"
							src="<c:url value="/resources/images/${ads.img}"/>" alt="ads-img">
						</a>
					</c:forEach>
				</div>
			</div>

		</div>

		<div class="container product">
			<div class="row">
				<div class="col-md-10">
					<h5 class="title">${h_title}</h5>
					<hr style="background: #17a2c6; height: 5px;">
				</div>
				<div class="col-md-2">
					<div class="top-self">
						<h5>Bán Chạy</h5>
						<div class="top-self-2">
							<h5>Bán Chạy</h5>
						</div>
					</div>

				</div>
			</div>
			<div class="row ">
				<div class="col-md-10 all-product">
					<div class="row">
						<c:forEach items="${listFood}" var="list">
							<div class="items" id="product-${list.id}">
								<div class="selling" style="${list.setStatus()}">
									<h5>-${list.giamGia}%</h5>
								</div>
								<img class="product-img"
									src="<c:url value="/resources/images/${list.img}"/>">
								<div class="product-name">${list.tenMon}</div>
								<div class="product-price">
									<b class="new-price"><fmt:formatNumber type="number"
											maxFractionDigits="3" value="${list.giaMoi}" />đ</b> &nbsp;
									<del style="${list.setStatus()}" class="old-price">
										<fmt:formatNumber type="number" maxFractionDigits="3"
											value="${list.gia}" />
										đ
									</del>
								</div>
								<a target="_blank" href="${list.id}/${list.title}"
									class="btn btn-info view"
									style="position: absolute; bottom: 0; left: 0"> <i
									class="far fa-eye">&nbsp;</i>
								</a> <a href="addToCarts/${list.id}"
									class="btn btn-info add-to-cart"
									style="position: absolute; bottom: 0; right: 0"> <i
									class="fas fa-cart-plus">&nbsp;</i>
								</a>

							</div>
						</c:forEach>


					</div>
				</div>
				<div class="col-md-2">
					<marquee direction="up" scrollamount="3" style="height: 189vh;"
						behavior="alternate">

						<c:forEach items="${topFoodSold}" var="food">
							<a href="${food.id}/${food.title}">
								<p class="btn btn-primary"
									style="width: 100%; position: absolute; top: 5;">
									${food.tenMon}</p>
								<div style="margin-bottom: 10px;">
									<img class="avt"
										src="<c:url value="/resources/images/${food.img}"/>">
								</div>

							</a>
						</c:forEach>

					</marquee>
				</div>
			</div>
			<hr>
			<div class="container">
				<div class="row">
					<div class="policy">
						<i class="fas fa-heartbeat" style="color: red">&nbsp;</i>An toàn
						vệ sinh
						<!-- <a href="" style="float:right;position: absolute;color: white;">Xem</a> -->
					</div>

					<div class="policy">
						<i class="fas fa-heart" style="color: red">&nbsp;</i>Món ăn đa
						dạng
						<!-- <a href="" style="float:right;position: absolute;color: white;">Xem</a> -->
					</div>
					<div class="policy">
						<i class="fas fa-heart" style="color: red">&nbsp;</i>Giao hàng tận
						nơi
					</div>
					<div class="policy">
						<i class="fas fa-heart" style="color: red">&nbsp;</i>Tốt cho sức
						khỏe
						<!-- <a href="" style="float:right;position: absolute;color: white;">Xem</a> -->
					</div>
				</div>
			</div>
			<hr>

		</div>

		<div class="container">

			<c:forEach items="${cmt}" var="cmt">
				<div class="row quote">
					<div class="col-md-3">
						<img src="<c:url value="/resources/images/${cmt.img}"/>">
					</div>
					<div class="col-md-9">
						<h5>${cmt.name}</h5>
						<p>
							<i>" ${cmt.content} "</i>
						</p>
						<p>
							<small><b>${cmt.date}</b></small>
						</p>
					</div>
				</div>
			</c:forEach>

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
					<p>
						<a href="">Góp ý</a>
					</p>
				</div>
				<div class="col-md-3">
					<p>Mạng xã hội</p>
					<p>
						<a href="https://www.instagram.com/_t.anh.tuan_/"> <i
							class="fab fa-instagram"></i>
						</a> &nbsp; <a href="https://www.facebook.com/t.a.t.14.08/"> <i
							class="fab fa-facebook-f"></i>
						</a>&nbsp; <a href="#!"> <i class="fab fa-pinterest"></i>
						</a>&nbsp; <br> <a href=""> <i class="fab fa-twitter"></i>
						</a>&nbsp; <a href=""> <i class="fab fa-youtube"></i>
						</a>
					</p>
				</div>

				<div class="col-md-6">
					<p>Địa chỉ cửa hàng</p>
					<iframe
						src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.6676702537075!2d105.80011782424698!3d21.005954641265788!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x313454b5534fb3bf%3A0x3af152649f6b709a!2zVmnhu4duIEPDtG5nIE5naOG7hyBUaMO0bmcgVGluIElUUGx1cw!5e0!3m2!1svi!2sus!4v1655978738226!5m2!1svi!2sus"
						width="600" height="450" style="border: 0;" allowfullscreen=""
						loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
				</div>
				<hr class="hr-footer">
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="row">
						<div class="col-md-4">
							<img src="<c:url value="/resources/images/AppStore-vn.png"/>"
								class="app-download" style="height: 65px;">
						</div>
						<div class="col-md-4">
							<img src="<c:url value="/resources/images/PlayStore-vn.png"/>"
								class="app-download">
						</div>
						<div class="col-md-4"></div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="row last-right">
						<div class="col-md-1"></div>
						<div class="col-md-3">@2024Tfood</div>
						<div class="col-md-4">
							<a href="#!">Câu hỏi thường gặp</a>
						</div>
						<div class="col-md-4">
							<a href="#!">Chính sách bảo mật</a>
						</div>
					</div>
				</div>
				<p style="text-align: right">
					<a target="_blank" class="btn btn-dark"
						href="http://fb.com/t.a.t.14.08">@2024 by T.A.T</a>
				</p>

			</div>
		</div>
	</div>



	<div class="social">
		<div class="instagram icon">
			<a href="https://www.instagram.com/_t.anh.tuan_/"><i
				class="fab fa-instagram"></i></a>
		</div>
		<div class="facebook icon">
			<a href="https://www.facebook.com/t.a.t.14.08/"><i
				class="fab fa-facebook-f"></i></a>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

</body>
</html>