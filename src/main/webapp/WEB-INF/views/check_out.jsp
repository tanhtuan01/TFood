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

	<script type= "text/javascript">
	var coun_arr = new Array(
		"Quận Ba Đình","Quận Bắc Từ Liêm","Quận Cầu Giấy","Quận Đống Đa","Quận Hà Đông",
		"Quận Hai Bà Trưng","Quận Hoàn Kiếm","Quận Hoàng Mai","Quận Long Biên","Quận Nam Từ Liêm",
		"Quận Tây Hồ","Quận Thanh Xuân","Thị xã Sơn Tây","Huyện Ba Vì","Huyện Chương Mỹ",
		"Huyện Đan Phượng","Huyện Đông Anh","Huyện Gia Lâm","Huyện Hoài Đức","Huyện Mê Linh",
		"Huyện Mỹ Đức","Huyện Phú Xuyên","Huyện Phúc Thọ","Huyện Quốc Oai","Huyện Sóc Sơn",
		"Huyện Thạch Thất","Huyện Thanh Oai","Huyện Thanh Trì","Huyện Thường Tín","Huyện Ứng Hòa"
								);
	var QUANHUYEN = new Array();
		QUANHUYEN[0] ="";
		// QUẬN
		// Ba Đình
		QUANHUYEN[1] ="Phường Ngọc Hà|Phường Đội Cấn|Phường Cống Vị|Phường Quán Thánh|Phường Phúc Xá|Phường Nguyễn Trung Trực|Phường Trúc Bạch|Phường Điện Biên|Phường Thành Công|Phường Giảng Võ|Phường Kim Mã|Phường Ngọc Khánh|Phường Liễu Giai|Phường Vĩnh Phúc";
		// Bắc Từ Liêm
		QUANHUYEN[2] ="Phường Cổ Nhuế 1|Phường Cổ Nhuế 2|Phường Đông Ngạc|Phường Đức Thắng|Phường Liên Mạc|Phường Minh Khai|Phường Phú Diễn|Phường Phúc Diễn|Phường Tây Tựu|Phường Thượng Cát|Phường Thụy Phương|Phường Xuân Đỉnh|Phường Xuân Tảo";
		// Cầu Giấy
		QUANHUYEN[3] = "Phường Dịch Vọng|Phường Dịch Vọng Hậu|Phường Mai Dịch|Phường Nghĩa Đô|Phường Nghĩa Tân|Phường Quan Hoa|Phường Trung Hòa|Phường Yên Hòa";
		// Đống Đa
		QUANHUYEN[4] = "Phường Cát Linh|Phường Hàng Bột|Phường Láng Hạ|Phường Láng Thượng|Phường Kim Liên|Phường Khâm Thiên|Phường Khương Thượng|Phường Nam Đồng|Phường Ngã Tư Sở|Phường Ô Chợ Dừa|Phường Phương Liên|Phường Phương Mai|Phường Quang Trung|Phường Quốc Tử Giám|Phường Thịnh Quang|Phường Thổ Quan|Phường Trung Liệt|Phường Trung Phụng|Phường Trung Tự|Phường Văn Chương|Phường Văn Miếu"; 
		// Hà Đông
		QUANHUYEN[5] = "Phường Quang Trung|Phường Yết Kiêu|Phường Nguyễn Trãi|Phường Văn Mỗ|Phường Phúc La|Phường Vạn Phúc|Phường Hà Cầu|Xã Kiến Hưng|Xã Văn Khê|Xã Yên Nghĩa|Xã Phú Lương|Xã Phú Lãm|Xã Biên Giang|Xã Đồng Mai|Xã Dương Nội"; 
		// Hai Bà Trưng
		QUANHUYEN[6] = "Phường Nguyễn Du|Phường Lê Đại Hành|Phường Bùi Thị Xuân|Phường Phố Huế|Phường Ngô Thì Nhậm|Phường Phạm Đình Hổ|Phường Đồng Nhân|Phường Đống Mác|Phường Bạch Đằng|Phường Thanh Lương|Phường Thanh Nhàn|Phường Cầu Dền|Phường Bách Khoa|Phường Quỳnh Lôi|Phường Bạch Mai|Phường Quỳnh Mai|Phường Vĩnh Tuy|Phường Minh Khai|Phường Trương Định|Phường Đồng Tâm"; 
		// Hoàn Kiếm
		QUANHUYEN[7] = "Phường Cửa Đông|Phường Cửa Nam|Phường Chương Dương|Phường Đồng Xuân|Phường Hàng Bài|Phường Hàng Bạc|Phường Hàng Bồ|Phường Hàng Bông|Phường Hàng Buồm|Phường Hàng Đào|Phường Hàng Gai|Phường Hàng Mã|Phường Hàng Trống|Phường Lý Thái Tổ|Phường Phan Chu Trinh|Phường Phúc Tân|Phường Tràng Tiền|Phường Trần Hưng Đạo"; 
		// Hoàng Mai
		QUANHUYEN[8] = "Phường Hoàng Liệt|Phường Yên Sở|Phường Vĩnh Hưng|Phường Định Công|Phường Đại Kim|Phường Thịnh Liệt|Phường Thanh Trì|Phường Lĩnh Nam|Phường Trần Phú|Phường Mai Động|Phường Tương Mai|Phường Tân Mai|Phường Giáp Bát|Phường Hoàng Văn Thụ";
		// Long Biên
		QUANHUYEN[9] = "Phường Bồ Đề|Phường Cự Khối|Phường Đức Giang|Phường Gia Thụy|Phường Giang Biên|Phường Long Biên|Phường Ngọc Lâm|Phường Ngọc Thụy|Phường Phúc Đồng|Phường Phúc Lợi|Phường Sài Đồng|Phường Thạch Bàn|Phường Thượng Thanh|Phường Việt Hưng";
		// Nam Từ Liêm
		QUANHUYEN[10] = "Phường Cầu Diễn|Phường Mỹ Đình 1|Phường Mỹ Đình 2|Phường Phú Đô|Phường Mễ Trì|Phường Trung Văn|Phường Đại Mỗ|Phường Tây Mỗ|Phường Phương Canh|Phường Xuân Phương";
		// Tây Hồ
		QUANHUYEN[11] = "Phường Bưởi|Phường Thuỵ Khê|Phường Yên Phụ|Phường Tứ Liên|Phường Nhật Tân|Phường Quảng An|Phường Xuân La|Phường Phú Thượng";
		// Thanh Xuân
		QUANHUYEN[12] = "Phường Hạ Đình|Phường Kim Giang|Phường Khương Đình|Phường Khương Mai|Phường Khương Trung|Phường Nhân Chính|Phường Phương Liệt|Phường Thanh Xuân Bắc|Phường Thanh Xuân Nam|Phường Thanh Xuân Trung|Phường Thượng Đình";
		// Thị xã Sơn Tây
		QUANHUYEN[13] = "Phường Lê Lợi|Phường Quang Trung|Phường Phú Thịnh|Phường Ngô Quyền|Phường Sơn Lộc|Phường Xuân Khanh|Phường Trung Hưng|Phường Viên Sơn|Phường Trung Sơn Trầm|Xã Đường Lâm|Xã Thanh Mỹ|Xã Xuân Sơn|Xã Kim Sơn|Xã Sơn Đông|Xã Cổ Đông";
		// HUYỆN
		// Ba Vì
		QUANHUYEN[14] = "Xã Ba Trại|Xã Ba Vì|Xã Cam Thượng|Xã Cẩm Lĩnh|Xã Cổ Đô|Xã Châu Sơn|Xã Chu Minh|Xã Đông Quang|Xã Đồng Thái|Xã Khánh Thượng|Xã Minh Châu|Xã Minh Quang|Xã Phong Vân|Xã Phú Cường|Xã Phú Châu|Xã Phú Đông|Xã Phú Phương|Xã Phú Sơn|Xã Sơn Đà|Xã Tản Hồng|Xã Tản Lĩnh|Xã Tiên Phong|Xã Tòng Bạt|Xã Thái Hòa|Xã Thuần Mỹ|Xã Thụy An|Xã Vạn Thắng|Xã Vân Hòa|Xã Vật Lại|Xã Yên Bài";
		// Chương Mỹ
		QUANHUYEN[15] = "Thị trấn Chúc Sơn|Thị trấn Xuân Mai|Xã Đại Yên|Xã Đông Phương Yên|Xã Đông Sơn|Xã Đồng Lạc|Xã Đồng Phú|Xã Hòa Chính|Xã Hoàng Diệu|Xã Hoàng Văn Thụ|Xã Hồng Phong|Xã Hợp Đồng|Xã Hữu Văn|Xã Lam Điền|Xã Mỹ Lương|Xã Nam Phương Tiến|Xã Ngọc Hòa|Xã Phú Nam An|Xã Phú Nghĩa|Xã Phụng Châu|Xã Quảng Bị|Xã Tân Tiến|Xã Tiên Phương|Xã Tốt Động|Xã Thanh Bình|Xã Thủy Xuân Tiên|Xã Thụy Hương|Xã Thượng Vực|Xã Trần Phú|Xã Trung Hòa|Xã Trường Yên|Xã Văn Võ";
		// Đan Phượng
	 	QUANHUYEN[16] = "Thị trấn Phùng|Xã Đan Phượng|Xã Đồng Tháp|Xã Hạ Mỗ|Xã Hồng Hà|Xã Liên Hà|Xã Liên Hồng|Xã Liên Trung|Xã Phương Đình|Xã Song Phượng|Xã Tân Hội|Xã Tân Lập|Xã Thọ An|Xã Thọ Xuân|Xã Thượng Mỗ|Xã Trung Châu";
		// Đông Anh
		QUANHUYEN[17] = "Thị trấn Đông Anh|Xã Võng La|Xã Tầm Xá|Xã Mai Lâm|Xã Đông Hội|Xã Xuân Nộn|Xã Thụy Lâm|Xã Bắc Hồng|Xã Nguyên Khê|Xã Nam Hồng|Xã Tiên Dương|Xã Vân Hà|Xã Uy Nỗ|Xã Vân Nội|Xã Liên Hà|Xã Việt Hùng|Xã Kim Nỗ|Xã Kim Chung|Xã Dục Tú|Xã Đại Mạch|Xã Vĩnh Ngọc|Xã Cổ Loa|Xã Hải Bối|Xã Xuân Canh";
		// Gia Lâm
		QUANHUYEN[18] = "Thị trấn Yên Viên|Thị trấn Trâu Quỳ|Xã Lệ Chi|Xã Đình Xuyên|Xã Ninh Hiệp|Xã Phù Đổng|Xã Trung Màu|Xã Dương Hà|Xã Yên Thường|Xã Yên Viên|Xã Kim Lan|Xã Cổ Bi|Xã Bát Tràng|Xã Đa Tốn|Xã Dương Xá|Xã Kiêu Kỵ|Xã Văn Đức|Xã Đông Dư|Xã Dương Quang|Xã Phú Thị|Xã Đặng Xá|Xã Kim Sơn";
		// Hoài Đức
		QUANHUYEN[19] = "Xã Minh Khai|Xã Dương Liễu|Xã Cát Quế|Xã Yên Sở|Xã Tiền Yên|Xã Song Phương|Xã An Thượng|Xã Đông Lam La Phù|Xã Dương Nội|Xã Vân Canh|Xã Di Trạch|Xã Kim Chung|Xã Sơn Đồng|Xã Lại Yên|Xã Đức Giang|Xã Đức Thượng|Xã Vân Côn|Xã Đắc Sở|Xã An Khánh|Xã Yên Nghĩa|Thị trấn Trạm Trôi";
		// Mê Linh
		QUANHUYEN[20] = "Thị trấn Chi Đông|Thị trấn Quang Minh|Xã Chu Phan|Xã Đại Thịnh|Xã Hoàng Kim|Xã Kim Hoa|Xã Liên Mạc|Xã Tam Đồng|Xã Tiến Thịnh|Xã Tiến Thắng|Xã Mê Linh|Xã Tiền Phong|Xã Tự Lập|Xã Thạch Đà|Xã Thanh Lâm|Xã Tráng Việt|Xã Vạn Yên|Xã Văn Khê";
		// Mỹ Đức
		QUANHUYEN[21] = "Thị trấn Đại Nghĩa|Xã An Mỹ|Xã An Phú|Xã An Tiến|Xã Bột Xuyên|Xã Đại Hưng|Xã Đốc Tín|Xã Đồng Tâm|Xã Hồng Sơn|Xã Hợp Tiến|Xã Hợp Thanh|Xã Hùng Tiến|Xã Hương Sơn|Xã Lê Thanh|Xã Mỹ Thành|Xã Phù Lưu Tế|Xã Phúc Lâm|Xã Phùng Xá|Xã Tuy Lai|Xã Thượng Lâm|Xã Vạn Kim|Xã Xuy Xá";
		// Phú Xuyên
		QUANHUYEN[22] = "Thị trấn Phú Xuyên|Thị trấn Phú Minh|Xã Bạch Hạ|Xã Châu Can|Xã Chuyên Mỹ|Xã Đại Thắng|Xã Đại Xuyên|Xã Hoàng Long|Xã Hồng Minh|Xã Hồng Thái|Xã Khai Thái|Xã Minh Tân|Xã Nam Phong|Xã Văn Nhân(Nam Tiến)|Xã Nam Triều|Xã Phú Túc|Xã Phú Yên|Xã Phúc Tiến|Xã Phượng Dực|Xã Quang Lãng|Xã Quang Trung|Xã Sơn Hà|Xã Tân Dân|Xã Tri Thủy|Xã Tri Trung|Xã Văn Hoàng|Xã Vân Từ";
		// Phúc Thọ
		QUANHUYEN[23] = "Thị trấn Phúc Thọ|Xã Vân Phúc|Xã Tích Giang|Xã Thượng Cốc|Xã Tam Hiệp|Xã Phương Độ|Xã Long Xuyên|Xã Hiệp Thuận|Xã Xuân Phú|Xã Vân Nam|Xã Trạch Mỹ Lộc|Xã Thanh Đa|Xã Sen Chiểu|Xã Phúc Hòa|Xã Liên Hiệp|Xã Cẩm Đình|Xã Võng Xuyên|Xã Văn Hà|Xã Thọ Lộc|Xã Tam Thuấn|Xã Phụng Thượng|Xã Ngọc Tảo|Xã Hát Môn";
		// Quốc Oai
		QUANHUYEN[24] = "Thị trấn Quốc Oai|Xã Phú Mãn|Xã Phú Cát|Xã Hòa Thạch|Xã Tuyết Nghĩa|Xã Đông Yên|Xã Liệp Tuyết|Xã Ngọc Liệp|Xã Ngọc Mỹ|Xã Cấn Hữu|Xã Nghĩa Hương|Xã Thạch Thán|Xã Đồng Quang|Xã Sài Sơn|Xã Yên Sơn|Xã Phượng Cách|Xã Tân Hòa|Xã Tân Phú|Xã Đại Thành|Xã Cộng Hòa|Xã Đông Xuân";
		// Sóc Sơn
		QUANHUYEN[25] = "Thị trấn Sóc Sơn|Xã Bắc Phú|Xã Bắc Sơn|Xã Đông Xuân|Xã Đức Hòa|Xã Hiền Ninh|Xã Hồng Kỳ|Xã Kim Lũ|Xã Mai Đình|Xã Minh Phú|Xã Minh Trí|Xã Nam Sơn|Xã Phú Cường|Xã Phù Linh|Xã Phù Lỗ|Xã Phú Minh|Xã Quang Tiến|Xã Tân Dân|Xã Tân Hưng|Xã Tân Minh|Xã Thanh Xuân|Xã Tiên Dược|Xã Trung Giã|Xã Việt Long|Xã Xuân Giang|Xã Xuân Thu";
		// Thạch Thất
		QUANHUYEN[26] = "Thị trấn Liên Quan|Xã Bình Phú|Xã Bình Yên|Xã Canh Nậu|Xã Cẩm Yên|Xã Cần Kiệm|Xã Chàng Sơn|Xã Dị Nậu|Xã Đại Đồng|Xã Đồng Trúc|Xã Hạ Bằng|Xã Hương Ngải|Xã Hữu Bằng|Xã Kim Quan|Xã Lại Thượng|Xã Phú Kim|Xã Phùng Xá|Xã Tân Xã|Xã Tiến Xuân|Xã Thạch Hòa|Xã Thạch Xá|Xã Yên Bình|Xã Yên Trung";
		// Thanh Oai
		QUANHUYEN[27] = "Xã Kim An|Xã Cao Viên|Xã Thanh Cao|Xã Thanh Mai|Xã Xuân Dương|Xã Bích Hòa|Xã Phương Trung|Xã Cao Dương|Xã Bình Minh|Xã Kim Thư|Xã Tam Hưng|Xã Đỗ Động|Xã Hồng Dương|Xã Dân Hòa|Xã Thanh Văn|Xã Tân Ước|Xã Thanh Thùy|Xã Liên Châu|Xã Mỹ Hưng|Xã Cự Khê|Xã Kiến Hưng|Xã Hữu Hòa|Xã Phú Lương|Xã Phú Lãm|Xã Biên Giang|Xã Đồng Mai";
		// Thanh Trì
		QUANHUYEN[28] = "Thị trấn Văn Điển|Xã Duyên Hà|Xã Đại Áng|Xã Đông Mỹ|Xã Hữu Hòa|Xã Liên Ninh|Xã Ngọc Hồi|Xã Ngũ Hiệp|Xã Tả Thanh Oai|Xã Tam Hiệp|Xã Tân Triều|Xã Tứ Hiệp|Xã Thanh Liệt|Xã Vạn Phúc|Xã Vĩnh Quỳnh|Xã Yên Mỹ";
		// Thường Tín
		QUANHUYEN[29] = "Thị trấn Thường Tín|Xã Chương Dương|Xã Dũng Tiến|Xã Duyên Thái|Xã Hà Hồi|Xã Hiền Giang|Xã Hòa Bình|Xã Khánh Hà|Xã Hồng Vân|Xã Lê Lợi|Xã Liên Phương|Xã Minh Cường|Xã Nghiêm Xuyên|Xã Nguyễn Trãi|Xã Nhị Khê|Xã Ninh Sở|Xã Quất Động|Xã Tân Minh|Xã Thắng Lợi|Xã Thống Nhất|Xã Thư Phú|Xã Tiền Phong|Xã Tô Hiệu|Xã Tự Nhiên|Xã Vạn Điểm|Xã Văn Bình|Xã Văn Phú|Xã Văn Tự|Xã Vân Tảo";
		// Ứng Hòa 
		QUANHUYEN[30] = "Thị trấn Vân Đình|Xã Cao Thành|Xã Đại Cường|Xã Đại Hùng|Xã Đội Bình|Xã Đông Lỗ|Xã Đồng Tân|Xã Đồng Tiến|Xã Hoa Sơn|Xã Hòa Lâm|Xã Hòa Nam|Xã Hòa Phú|Xã Hòa Xá|Xã Hồng Quang|Xã Kim Đường|Xã Liên Bạt|Xã Lưu Hoàng|Xã Minh Đức|Xã Phù Lưu|Xã Phương Tú|Xã Quảng Phú Cầu|Xã Sơn Công|Xã Tảo Dương Văn|Xã Trầm Lộng|Xã Trung Tú|Xã Trường Thịnh|Xã Vạn Thái|Xã Viên An|Xã Viên Nội";
	function print_wards(coun_id){
	    // given the id of the <select> tag as function argument, it inserts <option> tags
	    var option_str = document.getElementById(coun_id);
	    option_str.length=0;
	    option_str.options[0] = new Option('Chọn Quận/Huyện','');
	    option_str.selectedIndex = 0;
	    for (var i=0; i<coun_arr.length; i++) {
	        option_str.options[option_str.length] = new Option(coun_arr[i],"D"+(i+1));
	    }
	}

	function print_state(state_id, state_index){
	    var option_str = document.getElementById(state_id);
	    option_str.length=0;
	    option_str.options[0] = new Option('Chọn Phường/Xã','');
	    option_str.selectedIndex = 0;
	    var state_arr = QUANHUYEN[state_index].split("|");
	    for (var i=0; i<state_arr.length; i++) {
	        option_str.options[option_str.length] = new Option(state_arr[i],"W"+(i+1));
	    }
	}


	</script>

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
					<div class="row">
						<div class="col-md-6"></div>
						<div class="col-md-6">
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
		
		<div class="container first-category" style="margin-top: 20px;">
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
		

		<div class="container pay">

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
						<tr><td colspan="7" ${displaym}>Món chính: ${cartQuantity}</td></tr>
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
										<div class="col-md-4">
											<a href="/T-Food/low/m/${cart.id}">-</a>
										</div>
										<div class="col-md-4">
											<b>${cart.soLuong}</b>
										</div>
										<div class="col-md-4">
											<a href="/T-Food/up/m/${cart.id}">+</a>
										</div>
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
							<tr><td colspan="7" ${displays}>Món thêm: ${cartSubQuantity}</td></tr>
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
										<div class="col-md-4">
											<a href="/T-Food/low/s/${cart.id}">-</a>
										</div>
										<div class="col-md-4">
											<b>${cart.soLuong}</b>
										</div>
										<div class="col-md-4">
											<a href="/T-Food/up/s/${cart.id}">+</a>
										</div>
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
									<b>Tổng tiền(tạm tính): <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${totalPriceFood}"/>đ</b>
								</td>
							</tr>

							<tr>
								<td colspan="7">
									Mã giảm giá: 
									<input type="text" name="">
									<input class="btn btn-primary" type="submit" name="" value="Áp dụng">
								</td>
							</tr>

						</table>

					</div>
				</div>
			</div>
			<div id="address"></div>
			<h3>Thông tin nhận hàng</h3>
			<form action="check-address" method="post">
			<div class="row" style="margin-top: 20px;">
				<div class="col-md-6">
					<div class="row">
						<div class="col-md-4">
							<h5>Tên người nhận</h5>
						</div>
						<div class="col-md-8">
							<input  value="${name}" style="width: 100%;padding: 7px;" type="text" name="name" title="Họ tên người nhận" readonly>
						</div>
					</div>
				</div>
			
				<div class="col-md-6">
					<div class="row">
						<div class="col-md-3">
							<h5>Số điện thoại</h5>
						</div>
						<div class="col-md-9">
							<input value="${phone}" style="width: 100%;padding: 7px;" type="number" name="phone" title="Họ tên người nhận" readonly>
						</div>
					</div>
				</div>
			</div>
			<div class="row" style="margin-top: 20px;">
				<div class="col-md-6 district">
					<div class="row">
						<div class="col-md-4">
							<h5>Quận / huyện</h5>
						</div>
						<div class="col-md-8">
							<select onchange="print_state('wards',this.selectedIndex);" id="coun" name ="district"></select>
						</div>
					</div>
				</div>
				<div class="col-md-6 district" style="text-align:right;">
					<div class="row">
						<div class="col-md-3">
							
							<h5>Phường / xã</h5>
						</div>
						<div class="col-md-9">
							<select name ="wards" id ="wards">
								<option>Bạn chưa chọn Quận / Huyện</option>
							</select>
						</div>
					</div>
				</div>
				<script language="javascript">print_wards("coun");</script>
			</div>
			<div class="row" style="margin-top: 20px;">
				<div class="col-md-3">
					<h5>Số nhà / tổ dân phố / thôn:</h5>	
				</div>
				<div class="col-md-9" style="text-align:right">
					<input type="text" value="${village}" name="village" style="width: 100%;padding: 7px;">
				</div>
			</div>
			<div class="row" style="margin-top: 20px;">
				<div class="col-md-2" style="margin-top: 20px;">
					Ghi chú cho đơn hàng
				</div>
				<div class="col-md-10" style="text-align:right;">
					<textarea name="note" cols="98" rows="3" style="padding:10px">${note}</textarea>
				</div>				
			</div>
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<button type="submit" class="btn btn-info">Xác nhận địa chỉ</button>
					</div>
				</div>
			</div>
			<p class="text-danger" style="text-align:center">
				<b>${notify}</b>
			</p>
			</form>
			<div class="container" style="padding:5px;margin-top: 10px;">
				=> Giao hàng tới: ${address} <%-- <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${priceShip}"/>đ --%>
			</div>

			<div class="container" style="margin-top: 20px;">
				<table class="table" style="width: 100%;">
					<tr>
						<td>
							<!-- <b style="color:red">Phí giảm giá: -100000</b> <br> -->
							<b>Phí giao hàng: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${priceShip}"/>đ</b>
						</td>
					</tr>
					<tr>
						<td>
							<b>Tổng tiền thanh toán: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${totalPrice}"/>đ</b>
						</td>
					</tr>
				</table>
			</div>

			<div class="row" style="margin-top: 20px;">
				<div class="col-md-12">
					<a href="confirm" class="btn btn-danger">Hoàn Tất</a>
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
							<img src="AppStore-vn.png" class="app-download" style="height: 65px;">
						</div>
						<div class="col-md-4">
							<img src="PlayStore-vn.png" class="app-download">
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