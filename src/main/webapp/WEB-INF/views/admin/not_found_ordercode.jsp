<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Error 404 Not Found</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin_style.css"/>">
	<script src="https://kit.fontawesome.com/6426e3ba61.js" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<link rel="icon" type="image/x-icon" href="<c:url value="/resources/images/favicon/favicon_1.ico"/>" >
</head>
<body>

	<div class="container-fluid">
		<div class="row top-bar">
			<div class="col-md-3">
				<b class="txt-tfood">TFood</b>
			</div>
			<div class="col-md-7" style="text-align:right;">
				<div class="dropdown">
					<button class="dropbtn btn btn-primary">Admin</button>
					<div class="dropdown-content">
						<a href="/T-Food/admin/profile"><i class="fas fa-user"></i>&nbsp;Chỉnh sửa thông tin</a> <br>
						<a href="/T-Food/admin/lockScreen"><i class="fas fa-lock"></i>&nbsp;Khóa màn hình</a> <br>
						<a href="/T-Food/admin/logout"><i class="fas fa-sign-out-alt"></i>&nbsp;Đăng xuất</a>
					</div>
				</div>
			</div>
			<div class="col-md-2">
				
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 left">
				<div class="row avatar">
					
					<h5 style="padding: 10px;">Admin</h5>
					<div>
						<img src="<c:url value="/resources/images/_t.anh.tuan_.jpg"/>" style="height:100px; width: 120px;display: block;margin: auto;border-radius: 10px;">
					</div>
					<p style="text-align:center;margin-top: 10px;">Welcome, Admin !!</p>
				
				</div>
				<div class="row menu">
					<h5 class="txt-bang-dieu-khien">Bảng Điều Khiển</h5>
					<ul>
						<a href="/T-Food/admin/"><li><i class="fas fa-home"></i>&nbsp;Home</li></a>
						<a href=""><li><i class="fas fa-clipboard"></i>&nbsp;Đơn Hàng</li></a>
						<a href="/T-Food/admin/category"><li><i class="fa fa-th-list"></i>&nbsp;Danh Mục</li></a>
						<a href="/T-Food/admin/food"><li><i class="fas fa-hotdog"></i>&nbsp;Món Chính</li></a>
						<a href="/T-Food/admin/subFood"><li><i class="fas fa-hotdog"></i>&nbsp;Món Phụ</li></a>
						<a href=""><li><i class="fas fa-user-cog"></i>&nbsp;Thông Tin Tài Khoản</li></a>
						<a href=""><li><i class="fas fa-pen-nib"></i>&nbsp;Viết Bài</li></a>
						<hr>
						<a href=""><li><i class="fa fa-group"></i>&nbsp;Quản Lý Tài Khoản</li></a>
						<a href=""><li><i class="fas fa-pen-nib"></i>&nbsp;Hoạt Động Gần Đây</li></a>
					</ul>
				</div>
			</div>
			<div class="col-md-10 right">
				
				<div class="container not-found" style="text-align:center;height: 450px;margin-top: 50px;">
						<h3>Xin Lỗi!!!</h3>
						<p>
							Đơn Hàng Không Tồn Tại!!
						</p>
						<img src="https://www.callkirana.in/bootstrp/images/no-product.png">
						<br>
						<a href="/T-Food/admin/" class="btn btn-primary" style="background-color:white;color:#17a2c6">Quay lại trang chủ</a>
					</div>
				
			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>