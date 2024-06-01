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

</head>
<body>

	
	
	<!-- Top -->
	<div class="main container-fluid top-bar">
		<div class="container ">
			<div class="row">
				<div class="col-md-8">	<!-- fas fa-phone -->
				<a href="/T-Food/"><h1 class="txt-tfood2">TFOOD</h1></a>
					<i class="fab fa-viber">&nbsp;</i><a class="phone" href="tel:">0123456789</a>
				</div>
				<div class="col-md-4 p-sign">
					<!-- <a href="" class="sign">Đăng Nhập</a>&nbsp;<b style="color: silver">|</b>&nbsp;
					<a href="" class="sign">Đăng Ký</a>&nbsp;<b style="color: silver">|</b>&nbsp; -->
					<div class="row">
						<div class="col-md-6"></div>
						<div class="col-md-6">
							<a href="profile" style="color:white;text-align: right;">
								Tài Khoản: Users
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Body -->
	<div class="container-fluid body">
		
		<div class="container first-category" style="margin-top: 20px;">
			<div class="row">
				<div class="col-md-2" style="text-align: center;color: white;">
					<i style="margin-left: -50px" class="fas fa-stream"></i>&nbsp;Danh Mục
				</div>
				<div class="col-md-8 menu1">
					<ul>
						<a href=""><li style="margin-left: -30px;">Trang Chủ</li></a>
						<a href=""><li>Bài Viết</li></a>
						<a href=""><li>Giới Thiệu</li></a>
						<a href=""><li>Liên Hệ</li></a>
					</ul>
				</div>
			</div>	
		
		</div>
		<hr style="margin: 0px 0px 10px 0px; background: #17a2c6;height: 5px;">
		
		<div class="container pay">
			<h4>Tiến hành thanh toán</h4>
			<form method="post" action="confirm-cart">
			<div class="row">
				<div class="col-md-6">
					<p>Tên người nhận</p>
					<input style="width: 80%;padding:10px" type="text" value="${name}" name="name" title="Họ tên người nhận">
				</div>
				<div class="col-md-1"></div>
				<div class="col-md-5">
					<p>Số điện thoại</p>
					<input style="width: 80%;padding:10px" type="number" value="${phone}" name="phone" title="Họ tên người nhận">
				</div>
			</div>
			<div class="row">
				<p>Địa chỉ nhận: </p>
				<div class="col-md-12">
					<input type="text" value="${address}" name="address" style="width: 80%;padding:10px">
					<a href="">Xác nhận địa chỉ hiện tại này?</a>
				</div>
			</div>
			<div class="row">
				<p>Ghi chú cho đơn hàng: </p>
				<div class="col-md-12">
					<textarea cols="130" rows="3" style="padding:10px"></textarea>
				</div>				
			</div>

			

			<div class="row" id="tt">
				<h4>Thông tin đơn hàng</h4>
				<div class="col-md-12" class="table">
					<div class="row table-responsive-md">
						<table class="table">
							<tr class="top-bar">
								<th class="img"></th>
								<th class="food-name">Tên món</th>
								<th class="food-quantity">Số lượng</th>
								<th class="food-total-price">Tổng tiền</th>
								<th class="action" colspan="2">Thao tác</th>	
							</tr>
							<tr><td colspan="7">Món chính</td></tr>
							<c:forEach items="${cart}" var="cart">
							<tr>
								<td class="img">
									<img src="<c:url value="/resources/images/${cart.img}"/>">
								</td>
								<td class="food-name">
									${cart.tenMon}
								</td>
								<td class="food-quantity">
									<div class="row">
										<!-- <div class="col-md-4">
											<a href="">-</a>
										</div> -->
										<div class="col-md-12">
											<b>${cart.soLuong}</b>
										</div>
										<!-- <div class="col-md-4">
											<a href="">+</a>
										</div> -->
									</div>
								</td>
								<td class="food-total-price"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${cart.tongTien}"/>đ</td>
								<td>
								  	<a href="/T-Food/${cart.food}/${cart.title}" class="btn btn-primary">
										<i class="far fa-eye"></i>
									</a>
								</td>
								<td>
									<a href="/T-Food/del/${cart.id}" class="btn btn-primary">
										<i class="fas fa-trash"></i>
									</a>
								</td>
							</tr>
							</c:forEach>
							<tr><td colspan="7">Món thêm</td></tr>
							<c:forEach items="${cartSub}" var="cart">
							<tr>
								<td class="img">
									<img src="<c:url value="/resources/images/${cart.img}"/>">
								</td>
								<td class="food-name">
									${cart.tenMon}
								</td>
								<td class="food-quantity">
									<div class="row">
										<!-- <div class="col-md-4">
											<a href="">-</a>
										</div> -->
										<div class="col-md-12">
											<b>${cart.soLuong}</b>
										</div>
										<!-- <div class="col-md-4">
											<a href="">+</a>
										</div> -->
									</div>
								</td>
								<td class="food-total-price"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${cart.tongTien}"/>đ</td>
								
								<td colspan="2" align="right">
									<a href="/T-Food/dels/${cart.id}" class="btn btn-primary">
										<i class="fas fa-trash"></i>
									</a>
								</td>
							</tr>
							</c:forEach>
							<tr>
								<td colspan="7" align="right">
									<b>Tổng tiền: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${totalPrice}"/>đ</b>
								</td>
							</tr>

							<tr>
								<td colspan="7">
									Mã giảm giá: 
									<input type="text" name="">
									<a class="btn btn-primary" href="addVoucher">Áp dụng</a>
								</td>
							</tr>

							<tr>
								<td colspan="7">
									<b>Phí giao hàng: 15.000đ</b>
								</td>
							</tr>
							<tr>
								<td colspan="7" style="color: red">
									Mã giảm giá : -15.000đ
								</td>
							</tr>
							<tr>
								<td colspan="7">
									<b>Tổng tiền thanh toán: 9.999.999đ</b>
								</td>
							</tr>
						</table>

					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-danger">Hoàn Tất</button>
				</div>
			</div>
			</form>
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

</body>
</html>