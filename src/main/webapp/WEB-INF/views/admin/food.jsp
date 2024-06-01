<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Món chính</title>
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
						<a href="/T-Food/admin"><li><i class="fas fa-home"></i>&nbsp;Home</li></a>
						<a href="/T-Food/admin/order-list"><li><i class="fas fa-clipboard"></i>&nbsp;Đơn Hàng</li></a>
						<a href="/T-Food/admin/category"><li><i class="fa fa-th-list"></i>&nbsp;Danh Mục</li></a>
						<a href="#!"><li class="active"><i class="fas fa-hotdog"></i>&nbsp;Món Chính</li></a>
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
					<div class="col-md-4">
						<h5>Thực Đơn</h5>
					</div>
					<div class="col-md-8">
						<form action="searchFood" class="form-outline" method="post" style="padding:15px">
							<span>
								<input name="tenmon" type="search" placeholder="Nhập tên món..." id="form1" class="form-control" autocomplete="off" />
							<!-- <label class="form-label" for="form1">Search</label> -->
							</span>
							<button type="submit" class="btn btn-primary" style="height: 40px;">
			    				<i class="fas fa-search"></i>
			  				</button>
						</form>	
					</div>
				</div>
				<div class="row">
					<hr>		
					<div class="col-md-3">
						<h6 style="margin-top: 8px;">Thêm Mới Thực Đơn: Món Chính</h6>	
					
					</div>
					<div class="col-md-3">
						<button type="button" class="btn btn-primary" id="btn-up">
							<i class="fas fa-angle-up"></i>
						</button>
						<button type="button" class="btn btn-primary" id="btn-down">
							<i class="fas fa-angle-down"></i>
						</button>
					</div>
					<div class="col-md-6 text-danger">${notify}</div>
				</div>
				<div class="row">

					<form method="post" action="${action}" enctype="multipart/form-data">
					<input type="hidden" value="${id}" name="id">
						<table class="table table-category" id="table">
							<tr>
								<th>Tên Món <b style="color: red">(*)</b></th>
								<th>
									<input type="text" name="tenmon" required value="${tenmon}">
								</th>
							</tr>
							<tr>
								<th>Title <b style="color: red">(*)</b></th>
								<th>
									<input type="text" name="title" required value="${title2}">
								</th>
							</tr>
							<tr>
								<th>Danh Mục <b style="color: red">(*)</b></th>
								<th>
									<select name="category">
									<c:forEach items="${listCategories}" var="list">
										
											<option value="${list.id}">${list.tenDanhMuc}</option>
										
									</c:forEach>
									</select>
								</th>
							</tr>
							<tr>
								<th>Giá <b style="color: red">(*)</b></th>
								<th>
									<input type="number" min="0" name="gia" required value="${gia}">
								</th>
							</tr>
							<tr>
								<th>Giảm Giá <!-- <b style="color: red">(*)</b> --></th>
								<th>
									<input min="0" type="number" name="giamgia" value="${giamgia}">
								</th>
							</tr>
							<tr>
								<th>Trạng Thái<b style="color: red">(*)</b></th>
								<th>
									<select name="trangthai">
										<option value="0">Không Giảm Giá</option>
										<option value="1">Mở Giảm Giá</option>
									</select>
								</th>
							</tr>
							<tr>
								<th>Hình Ảnh <b style="color: red">(*)</b></th>
								<th>
									<input type="file" name="img" accept="image/png, image/jpeg">
								</th>
							</tr>
							<tr>
								<th>Mô Tả </th>
								<th>
									<textarea name="description" style="padding: 5px;" cols="87" rows="3">${mota}</textarea>
								</th>
							</tr>
							<tr>
								<td style="text-align: right;">
									<button type="submit" class="btn btn-primary">${title}</button>
								</td>
								<td>
									<a href="/T-Food/admin/cancelUpdateFood" type="reset" class="btn btn-warning">Hủy</a>
								</td>
							</tr>
						</table>
					</form>
					<h6>Danh Sách</h6>
					<table class="table">
						<tr>
							<th class="mon-ten">Tên</th>
							<th class="mon-title">Title</th>
							<!-- <th class="mon-danh-muc">Tên Danh Mục</th> -->
							<th class="mon-hinh-anh">Hình Ảnh</th>
							<th class="mon-gia">Giá</th>
							<th class="mon-phan-tram">%</th>
							<th class="mon-gia-moi">Giá Mới</th>
							<th class="mon-ngay-tao">Ngày Tạo</th>
							<th class="mon-thao-tac" colspan="2">Thao Tác</th>
						</tr>
						<c:forEach items="${listFoods}" var="list">
							<tr>
								<td class="mon-ten">${list.tenMon}</td>
								<td class="mon-title">${list.title}</td>
								<!-- <th class="mon-danh-muc">Cơm Trưa Văn Phòng</th> -->
								<td class="mon-hinh-anh"><img src="<c:url value="/resources/images/${list.img}"/>"></td>
								<td class="mon-gia">${list.gia}</td>
								<td class="mon-phan-tram">${list.giamGia}</td>
								<td class="mon-gia-moi">${list.giaMoi}</td>
								<td class="mon-ngay-tao">${list.thoiGianTao}</td>
								<td>
									<a href="editMainFood?id=${list.id}&tenmon=${list.tenMon}&title=${list.title}&img=${list.img}&gia=${list.gia}&giamgia=${list.giamGia}&mota=${list.moTa}" class="btn btn-primary">
										<i class="far fa-edit"></i>
									</a>
								</td>
								<td>
									<a href="deleteMainFood?id=${list.id}" class="btn btn-primary">
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
	<script  type="text/javascript">
		${script}
	</script>
</body>
</html>