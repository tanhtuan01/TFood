<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Xem chi tiết đơn hàng</title>
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
						<a href="/T-Food/admin/order-list"><li class="active"><i class="fas fa-clipboard"></i>&nbsp;Đơn Hàng</li></a>
						<a href="/T-Food/admin/category"><li><i class="fa fa-th-list"></i>&nbsp;Danh Mục</li></a>
						<a href="/T-Food/admin/food"><li><i class="fas fa-hotdog"></i>&nbsp;Món Chính</li></a>
						<ul>
							<a href="/T-Food/admin/list-food"><li><i class="fa fa-list"></i>&nbsp;Danh sách</li></a>
						</ul>
						<a href="/T-Food/admin/subFood"><li><i class="fas fa-hotdog"></i>&nbsp;Món Phụ</li></a>
						<ul>
							<a href="/T-Food/admin/list-sub-food"><li><i class="fa fa-list"></i>&nbsp;Danh sách</li></a>
						</ul>
						<a href=""><li><i class="fas fa-user-cog"></i>&nbsp;Thông Tin Tài Khoản</li></a>
						<a href=""><li><i class="fas fa-pen-nib"></i>&nbsp;Viết Bài</li></a>
						<hr>
						<a href="/T-Food/admin/slider"><li><i class="fab fa-trello"></i>&nbsp;Slider</li></a>
						<a href="/T-Food/admin/img-ads"><li><i class="fas fa-retweet" style="color:black"></i>&nbsp;Img-Ads</li></a>		
						<a href=""><li><i class="fa fa-group"></i>&nbsp;Quản Lý Tài Khoản</li></a>
						<a href=""><li><i class="fas fa-pen-nib"></i>&nbsp;Hoạt Động Gần Đây</li></a>
					</ul>
				</div>
			</div>
			<div class="col-md-10 right">
				<div class="row">
					<h5>Chi tiết đơn hàng</h5>	
					<p class="text-danger" style="text-align:center;">${notify}</p>	
					<hr>			
				</div>
				<div class="row thong-ke">
					
				
					<div class="col-md-12">
						<h6>Mã đơn hàng: ${orderCode}</h6>
						<div class="row giao-dich">
						
							<div class="col-md-8">
								<table class="table" style="width: 100%;">
									<tr>
										<td colspan="3">Món</td>
									</tr>
									<tr>
										<th class="s-ten">Tên món</th>
										<th class="s-img"></th>
										<th class="s-quantity">Số lượng</th>
									</tr>
									<c:forEach items="${list}" var="list">
									<tr>
										<th class="s-ten">${list.foodName}</th>
										<th class="s-img"><img src="<c:url value="/resources/images/${list.img}"/>" alt="May this is img of food"></th>
										<th class="s-quantity">${list.quantity}</th>
									</tr>
									</c:forEach>
								</table>
							</div>
						
							<div class="col-md-4" style="height:100%">
								<table class="table" style="width: 100%;">
									<tr>
										<td colspan="3">Mua kèm theo</td>
									</tr>
									<tr>
										<th class="s-ten">Tên món</th>
										<th class="s-img"></th>
										<th class="s-quantity">Số lượng</th>
									</tr>
									<c:forEach items="${list2}" var="list">
									<tr>
										<th class="s-ten">${list.foodName}</th>
										<th class="s-img"><img src="<c:url value="/resources/images/${list.img}"/>" alt="May this is img of food"></th>
										<th class="s-quantity">${list.quantity}</th>
									</tr>
									</c:forEach>
								</table>
							</div>
							<div class="row">
								<b>Ghi chú cho đơn hàng</b>
								<p style="font-size:22px;">${note}</p>
							</div>
							<div class="row" style="margin-top: 10px;">
								<div class="col-md-3">
									<a href="cancel" class="btn btn-danger" style="width: 100%;color: white;${style4}">Hủy đơn</a>
								</div>
								<div class="col-md-3">
									<a href="confirmOrder" class="btn btn-primary" style="width: 100%;color: white;${style2}">Xác nhận</a>
								</div>
								<div class="col-md-3">
									<a href="orderSuccess" class="btn btn-success" style="width: 100%;color: white;${style3}">Giao Thành Công</a>
								</div>		
								<div class="col-md-3"></div>							
							</div>
						</div>
						
					</div>
				</div>
			
			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>