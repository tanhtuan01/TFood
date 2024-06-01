<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>TFood - Món ngon mỗi ngày</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home_style.css"/>">
	<script src="https://kit.fontawesome.com/6426e3ba61.js" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<link rel="icon" type="image/x-icon" href="<c:url value="/resources/images/favicon/favicon_1.ico"/>" >
	<style>
		/* view food */
		.img_user{
			width: 55%;display: block;margin: auto;height: 70px;margin-top: 10px;border-radius: 50%;
		}
		textarea{
			border:0px solid white;
			outline: none;
		}
	
	</style>
</head>
<body>

	<!-- Top -->
	<div class="main container-fluid top-bar">
		<div class="container ">
			<div class="row">
				<div class="col-md-8">	<!-- fas fa-phone -->
					<a href="/T-Food/"><h1 class="txt-tfood2">TFOOD</h1></a>
					<i class="fab fa-viber">&nbsp;</i><a class="phone" href="tel:">0963 97 65 65</a>
				</div>
				<div class="col-md-4 p-sign">
					<p  style="${style}">
							<a href="/T-Food/sign-in" class="sign">Đăng Nhập</a>&nbsp;<b style="color: silver">|</b>&nbsp;
							<a href="/T-Food/sign-up" class="sign">Đăng Ký</a>&nbsp;<b style="color: silver">|</b>&nbsp;
					</p>
					<div class="row">
						<div class="col-md-6">
							
						</div>
						<div class="col-md-6 tk-users" style="${style2}">
							<a href="profile" style="color:white;text-align: right;">
								Tài Khoản Của Tôi
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

				<div class="col-md-10">
					<form class="form-outline" method="post" action="/T-Food/tim-kiem">	
						<span>
							<input name="txt-search" type="search" placeholder="Nhập tên món..." id="form1" class="form-control" autocomplete="off" />
						<!-- <label class="form-label" for="form1">Search</label> -->
						</span>
						<button type="submit" class="btn btn-primary" style="height: 40px;">
		    				<i class="fas fa-search"></i>
		  				</button>
					</form>

				</div>
				<div class="col-md-2 cart">
					<a href="/T-Food/myCart">
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
					<i style="margin-left: -50px" class="fas fa-stream"></i>&nbsp;Danh Mục
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
			<div class="row view-info">
				<div class="col-md-6">
					<img src="<c:url value="/resources/images/${img}"/>" class="avt" style="height:400px">
				</div>
				
				<div class="col-md-6" style="max-height:100%">
					
					<p><h5>${tenMon}</h5></p>
					<p>&nbsp;<b>- Giá: </b><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${gia}"/>đ</p>
					
					<textarea id="textarea" cols="66" readonly="readonly">&nbsp;${moTa}.</textarea>
					<p>Đã bán ${daBan}</p>
			
					<p>Điểm số: ${avgScore} dựa trên lượt trung bình đánh giá</p>
					<a href="addToCart" class="btn btn-primary" style="position:absolute;bottom:0"><i class="fas fa-shopping-basket"></i>&nbsp;Thêm Vào Giỏ Hàng</a>
				</div>
				
			</div>
			<div class="row view-menu">
				<ul>
					<a href="#comment"><li><i class="fas fa-pen-nib"></i>&nbsp;Viết Bình Luận</li></a>
					<a href=""><li><i class="fas fa-heart"></i>&nbsp;Thêm Vào Yêu Thích</li></a>
				</ul>
			</div>
			<h5 style="${dp}">Mua Thêm</h5> <%-- : ${size} --%>
		<div class="sub-food" id="sub-food">
			<div class="row">
				<c:forEach items="${list}" var="list">
				<div class="col-md-3">
					 <p style="margin:0px">
					 	<img src="<c:url value="/resources/images/${list.img}"/>" class="avt" style="height:100px">
				 	<p style="margin-bottom:0px">${list.tenMon}<br> Giá: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${list.gia}"/>đ</p>
					 	<a class="" href="addSubFood/${list.id}/${list.gia}">Thêm</a>
					 </p>
				</div>
				</c:forEach>
			</div>
			

		</div>
		
			<div class="row">
				<h5>Các bình luận</h5>
				<div class="col-md-9 comment" id="comment" style="height:100vh">
					<c:forEach items="${cmt}" var="cmt">
					<div class="row" style="box-shadow: 2px 2px 8px silver;margin-bottom: 10px;">
						<div class="col-md-3">
							<img class="img_user" src="<c:url value="/resources/images/${cmt.img}"/>" >
							<p style="text-align: center;">${cmt.name}</p>
							<p><h3 style="text-align:center;">${cmt.score}</h3></p>
						</div>
						<div class="col-md-9">
							<p rows="4" style="width: 100%;margin-top: 7px;">${cmt.content}</p>
							<p>${cmt.date}</p>
							<i class="fas fa-user-shield" style="color:green">&nbsp;Chứng nhận đã mua</i>
						</div>
						
					</div>
					</c:forEach>


				</div>
				<div class="col-md-3">
					<h5>Khác</h5>
					<marquee direction="up" scrollamount="3" style="height: 100vh;" behavior="alternate" >
						<c:forEach items="${list2}" var="list">
						<a href="/T-Food/${list.id}/${list.title}">
							<p class="btn btn-primary" style="width: 100%;position: absolute;top: 5;">
								${list.tenMon}
							</p>
							<div  style="margin-bottom: 10px;">			
								<img class="avt" src="<c:url value="/resources/images/${list.img}"/>" >					
							</div>
							
						</a>
						</c:forEach>
						
					</marquee>
				
				</div>
					
			</div>
			
			<%--  <div class="row" style="${dp2}">
				
				<marquee direction="right" scrollamount="3" style="width: 100vw;" behavior="alternate" >
					
					<c:forEach items="${list2}" var="list">
					<span style="display:inline-block">
						<a href="/T-Food/${list.id}/${list.title}">
							<p class="btn btn-primary" style="width: 20%;position: absolute;top: 5;">
								${list.tenMon}
							</p>
							<div  style="margin-bottom: 10px;margin-right:10px;">			
								<img class="avt" style="height:222px;" src="<c:url value="/resources/images/${list.img}"/>" >					
							</div>
							
						</a>
						</span>
					</c:forEach>
					
				</marquee>
				
			</div>  --%>
			
			<div class="row" style="${stylec}">
				<div class="col-md-10 writeComment">
					<form method="POST" action="writeComment">
						<h5>
							Viết bình luận của bạn
						</h5>
						<div class="slidecontainer">
						   <input type="range" name="score" min="1" max="10" class="slider" id="myRange" value="10">
						   <p>Điểm Đánh Giá: <span id="demo"></span></p>
						</div>
						<div class="row">
							<div class="col-md-3">
								<img src="<c:url value="/resources/images/${avt}"/>" style="width: 100%;display: block;margin: auto;height: 70px;margin-top: 10px;border-radius: 50%;">
							</div>
							<div class="col-md-9">
								<textarea name="content" rows="4" cols="77" style="width: 100%;padding: 5px;border:1px solid black"></textarea>
							</div>
							<button style="width: 80%;display: block;margin:auto;" class="btn btn-primary">Bình Luận</button>
						</div>
					</form> 
				</div>
			</div>
			<hr>
		</div>
		<div class="container" style="margin-top: 20px;">
			<div class="row">
				<div class="policy">
					<i class="fas fa-heartbeat" style="color:red">&nbsp;</i>An toàn vệ sinh
					<!-- <a href="" style="float:right;position: absolute;color: white;">Xem</a> -->
				</div>
				
				<div class="policy">
					<i class="fas fa-heart" style="color:red">&nbsp;</i>Món ăn đa dạng
					<!-- <a href="" style="float:right;position: absolute;color: white;">Xem</a> -->
				</div>
				<div class="policy">
					<i class="fas fa-heart" style="color:red">&nbsp;</i>Giao hàng tận nơi
				</div>
				<div class="policy">
					<i class="fas fa-heart" style="color:red">&nbsp;</i>Tốt cho sức khỏe
					<!-- <a href="" style="float:right;position: absolute;color: white;">Xem</a> -->
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
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.6676702537075!2d105.80011782424698!3d21.005954641265788!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x313454b5534fb3bf%3A0x3af152649f6b709a!2zVmnhu4duIEPDtG5nIE5naOG7hyBUaMO0bmcgVGluIElUUGx1cw!5e0!3m2!1svi!2sus!4v1655978738226!5m2!1svi!2sus" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>				</div>
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
						<div class="col-md-3">@2024Tfood</div>
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

	<script type="text/javascript">
		var slider = document.getElementById("myRange");
		var output = document.getElementById("demo");
		/* Hiển thị giá trị mặc định 50 cho thẻ span với id là demo*/
			output.innerHTML = slider.value; 
		/* cập nhật giá trị hiện tại của ranger slider*/
			slider.oninput = function() {
			output.innerHTML = this.value;
		}
		// Auto resize textarea
		const tx = document.getElementsByTagName("textarea");
		for (let i = 0; i < tx.length; i++) {
		  tx[i].setAttribute("style", "height:" + (tx[i].scrollHeight) + "px;overflow-y:hidden;border:0px solid white;");
		  tx[i].addEventListener("input", OnInput, false);
		}

		function OnInput() {
		  this.style.height = "auto";
		  this.style.height = (this.scrollHeight) + "px";
		}
	</script>
</body>
</html>