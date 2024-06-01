<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>TFood - Đăng Ký</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home_style.css"/>">
	<script src="https://kit.fontawesome.com/6426e3ba61.js" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<link rel="icon" type="image/x-icon" href="<c:url value="/resources/images/favicon/favicon_1.ico"/>" >
	<style type="text/css">
		.mb-4, .my-4 {
    		margin-bottom: 0.5rem!important;
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
						
						<a href="sign-in" class="sign">Đăng Nhập</a>&nbsp;<b style="color: silver"></b>&nbsp;
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- Body -->
	<div class="container-fluid body">
		
		</div>
		<hr style="margin: 0px 0px 10px 0px; background: #17a2c6;height: 5px;">
		
		<div class="container">
			
			<h3>Đăng Ký</h3>

			<section class="h-100 h-custom" style="background-color: #17a2c6;">
			  <div class="container py-5 h-100">
			    <div class="row d-flex justify-content-center align-items-center h-100">
			      <div class="col-lg-8 col-xl-6">
			        <div class="card rounded-3">
			         <!--  <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
			            class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
			            alt="Sample photo"> -->
			          <div class="card-body p-4 p-md-5">
			            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Thông Tin Đăng Ký</h3>
						<p class="text-danger" style="text-align:center;">${notify}</p>
			            <form class="px-md-2" method="post" enctype="multipart/form-data">

							<div class="form-outline mb-4">
								<label class="form-label" for="form3Example1q" >Họ và Tên</label>
								<input type="text" value="${hovaten}" name="hovaten" id="form3Example1q" class="form-control" pattern="[A-Z a-zảàáăạẢÀÁÃẠĂẮẪẶẰăắằẵặÊẾỀỄỆêếềễệƯỨỪỮỰưứừữựƠỚỜỠỢơớờỡợÔỐỒỖỘôốồỗộÍÌĨỊíìĩịĐđÂẤẦẪẬâấầẫậÒÓuùúũụÙÚŨỤ]{2,40}" title="Nhập Đúng Họ Và Tên Của Bạn" required />
							</div>

							<div class="form-outline mb-4">
								<label class="form-label" for="form3Example1q">Số Điện Thoại</label>
								<input type="text" name="sodienthoai" id="form3Example1q" class="form-control" pattern="[+0-9]{10,11}" title="Nhập Số Điện Thoại Mà Bạn Đã Đăng Ký" required/>
							</div>

							<div class="form-outline mb-4">
								<label class="form-label" for="form3Example1q">Mật Khẩu</label>
								<input type="password" name="matkhau" id="form3Example1q" class="form-control" pattern="[a-zA-Z0-9 ]{3,30}" title="Mật Khẩu Không Chứa Ký Tự Đặc Biệt" required/>
							</div>

							<%-- <div class="form-outline mb-4">
								<label class="form-label" for="form3Example1q">Địa Chỉ</label>
								<input type="text" value="${diachi}" name="diachi" id="form3Example1q" class="form-control" />
							</div> --%>

							<div class="form-outline mb-4">
								<label class="form-label" for="form3Example1q">Chọn Ảnh</label>
								<input type="file" name="avatar" id="form3Example1q" class="form-control" />
							</div>
			              <button type="submit" style="margin-top: 20px;" class="btn btn-primary btn-lg mb-1">Đăng Ký</button>
							<br><a href="sign-in">Bạn có tài khoản? Đăng nhập</a>
			            </form>

			          </div>
			        </div>
			      </div>
			    </div>
			  </div>
			</section>

		</div>
		<hr>
		

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


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

</body>
</html>