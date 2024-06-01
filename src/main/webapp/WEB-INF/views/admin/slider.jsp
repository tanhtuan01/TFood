<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Slider</title>
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
						<a href="/T-Food/admin/order-list"><li><i class="fas fa-clipboard"></i>&nbsp;Đơn Hàng</li></a>
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
						<a href="#!"><li class="active"><i class="fab fa-trello" style="color:black"></i>&nbsp;Slider</li></a>
						<a href="/T-Food/admin/img-ads"><li><i class="fas fa-retweet" style="color:black"></i>&nbsp;Img-Ads</li></a>
						<a href=""><li><i class="fa fa-group"></i>&nbsp;Quản Lý Tài Khoản</li></a>
						<a href=""><li><i class="fas fa-pen-nib"></i>&nbsp;Hoạt Động Gần Đây</li></a>
					</ul>
				</div>
			</div>
			<div class="col-md-10 right">
				<div class="row">
					<h5>Slider Hiện tại <b class="text-danger">: ${notify}</b></h5>		
					<hr>			
				</div>
				<div class="row thong-ke">
					<c:forEach items="${list}" var="slider">
					<div class="col-md-3" id="row-slide">
						<h6>${slider.noiDung} (${slider.stt})</h6>
						<hr>
						<div class="row giao-dich">
							<img src="<c:url value="/resources/images/slider/${slider.img}"/>" id="avt">
						</div>
						<a class="xem" href="editSlider?id=${slider.id}&nd=${slider.noiDung}&img=${slider.img}&stt=${slider.stt}" style="float: right;">
							Sửa
						</a>
						<a class="xoa" href="deleteSlider?id=${slider.id}" style="float: left;">
							Xóa
						</a>
					</div>
					</c:forEach>
					
				</div>
				<div class="row danh-sach" id="slider">
					<h5 style="text-align: center;">${title}</h5>
					<div class="col-md-2"></div>
					<div class="col-md-8" style="margin-bottom: 20px;">
						<form method="post" enctype="multipart/form-data" action="${action}">
						<table class="table">
							<tr>
								<th>Nội dung slider</th>
								<th>
									<input value="${nd}" type="text" name="nd" style="width: 100%;padding: 5px;" required>
								</th>
							</tr>
							<tr>
								<th>Hình ảnh</th>
								<th>
									<input type="file" name="img" ${required}>
								</th>
							</tr>
							<tr>
								<th>Thứ tự hiển thị</th>
								<td>
									<input value="${stt}" min="1" type="number" name="stt" style="width: 100%;padding: 5px;" required title="Chọn thứ tự >= 1">
								</td>
							</tr>
							<tr>
								<th>
									<button type="submit" class="btn btn-success">${actionTitle}</button>
								</th>
								<th>
									<input class="btn btn-danger" type="reset" name="">
								</th>
							</tr>
						</table>
						</form>
					</div>
					<div class="col-md-2"></div>
				</div>
			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>