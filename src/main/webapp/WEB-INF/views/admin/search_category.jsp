<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Danh mục</title>
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
						<a href="/T-Food/admin/category"><li class="active"><i class="fa fa-th-list"></i>&nbsp;Danh Mục</li></a>
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
						<a href="/T-Food/admin/slider"><li><i class="fab fa-trello" style="color:black"></i>&nbsp;Slider</li></a>
						<a href="/T-Food/admin/img-ads"><li><i class="fas fa-retweet" style="color:black"></i>&nbsp;Img-Ads</li></a>
						<a href=""><li><i class="fa fa-group"></i>&nbsp;Quản Lý Tài Khoản</li></a>
						<a href=""><li><i class="fas fa-pen-nib"></i>&nbsp;Hoạt Động Gần Đây</li></a>
					</ul>
				</div>
			</div>
			<div class="col-md-10 right">
				<div class="row">
					<div class="row">
						<div class="col-md-4">
							<h5>Danh Mục</h5>
						</div>
						<div class="col-md-8">
							<form action="searchCategory" class="form-outline" method="post" style="padding:15px">
								<span>
									<input type="search" placeholder="Nhập tên danh mục..." id="form1" name="name" class="form-control" autocomplete="off" />
								<!-- <label class="form-label" for="form1">Search</label> -->
								</span>
								<button type="submit" class="btn btn-primary" style="height: 40px;">
				    				<i class="fas fa-search"></i>
				  				</button>
							</form>	
						</div>
					</div>	
					
				</div>		
					<a href="category">Quay Lại</a>
					<h6>Kết Quả Cho Danh Mục: ${name}</h6>
					<table class="table">
						<tr>
							<th class="ten-danh-muc">Tên Danh Mục</th>
							<th class="title">Title</th>
							<th class="thu-tu">Thứ Tự</th>
							<th class="hinh-anh">Hình Ảnh</th>
							<th class="ngay-tao">Ngày Tạo</th>
							<th class="thao-tac" colspan="2">Thao Tác</th>
						</tr>
						<c:forEach items="${list}" var="list">
						<tr>
							<td class="ten-danh-muc">${list.tenDanhMuc}</td>
							<td class="title">${list.title}</td>
							<th class="thu-tu">${list.thuTuHienThi}</th>
							<td class="hinh-anh"><img src="<c:url value="/resources/images/${list.img}"/>"></td>
							<td class="ngay-tao">${list.thoiGianTao}</td>
							<td>
								<a href="edit?id=${list.id}&tenDanhMuc=${list.tenDanhMuc}&title=${list.title}&thuTuHienThi=${list.thuTuHienThi}&img=${list.img}" class="btn btn-primary">
									<i class="far fa-edit"></i>
								</a>
							</td>
							<td>
								<a href="deleteCategory?id=${list.id}" class="btn btn-primary">
									<i class="fas fa-trash"></i>
								</a>
							</td>
						</tr>
						</c:forEach>
					</table>
				</div>
			
			
			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

	<script type="text/javascript">
		document.getElementById("btn-down").style.display = 'none';
		document.getElementById("btn-up").onclick = function(){
			document.getElementById("table").style.display = 'none';
			document.getElementById("btn-down").style.display = '';
			document.getElementById("btn-up").style.display = 'none';
		}
		document.getElementById("btn-down").onclick = function(){
			document.getElementById("table").style.display = '';
			document.getElementById("btn-down").style.display = 'none';
			document.getElementById("btn-up").style.display = '';
		}

	</script>
</body>
</html>