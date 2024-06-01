<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Khóa màn hình</title>
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
		body{
			background-color: #17a2c6;
			color:  white;
		}
		.font-size100{
			font-size: 100px;
		}
		.body{
			width: 100vw;height: 100vh;max-height: 100vh;max-width: 100vw;
		}
	</style>

</head>
<body>

	
	
	<!-- Top -->
	
	<div class="container-fluid body" style="display:${display}">
		<div class="row">
			<i class="fa fa-lock font-size100" style="text-align: center;margin-top: 10vh;"></i>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-3">
				<p class="font-size100" style="text-align: right;margin-top: 5vh;"><i class="far fa-clock"></i></p>
			</div>
			<div class="col-md-6" style="text-align:left;">
				<p id="time_span" class="font-size100" style="margin-top: 5vh;"></p>
			</div>
			<div class="col-md-2"></div>
		</div>
		<div class="row">
			<p id="currentDate" style="font-size: 50px;margin-top: 3vh;text-align: center;"></p>
		</div>
		<div class="row">
			<div class="col-md-5"></div>
			<div class="col-md-2">
				<a class="btn btn-primary" style="text-align: center;color:white;width: 100%;" href="openScreen">Mở Khóa</a>
			</div>
			<div class="col-md-5"></div>
		</div>
		<script type="text/javascript">

			function updateTime(){
			 	var currentTime = new Date()
			    var hours = currentTime.getHours()
			    var minutes = currentTime.getMinutes()
			    var seconds = currentTime.getSeconds()

			    if (minutes < 10){
			        minutes = "0" + minutes
			    }
			 	if(seconds < 10){
			 		seconds = "0" + seconds
			 	}
			    var t_str = hours + ":" + minutes + ":" + seconds;
			    if(hours > 14){
			        
			        if(hours > 18){
			        	t_str += " Tối";
			        }else{
			        	t_str += " Chiều";
			        }
			    } else {
			    	if(hours > 12){
			    		t_str += " Trưa";
			    	}
			        else{
			        	t_str += " Sáng";
			        }
			    }
			    document.getElementById('time_span').innerHTML = t_str;
			}
			setInterval(updateTime, 1000);
				
				// curDate sẽ lưu trữ thời gian hiện tại
				var curDate = new Date();
				 
				// Lấy ngày hiện tại
				var curDay = curDate.getDate();
				console.log(curDay);
				 
				// Lấy tháng hiện tại
				var curMonth = curDate.getMonth() + 1;
				console.log(curMonth);
				 
				// Lấy năm hiện tại
				var curYear = curDate.getFullYear();
				console.log(curYear);

				var dayInWeek = "";
			
					var day = curDate.getDay();
					switch(day){
						case 0:
							dayInWeek = "Chủ Nhật";
							break;
						case 1:
							dayInWeek = "Thứ Hai";
							break;
						case 2:
							dayInWeek = "Thứ Ba";
							break;
						case 3:
							dayInWeek = "Thứ Tư";
							break;
						case 4:
							dayInWeek = "Thứ Năm";
							break;
						case 5:
							dayInWeek = "Thứ Sáu";
							break;
						case 6: 
							dayInWeek = "Thứ Bảy";
							break;
					}

	document.getElementById("currentDate").innerHTML = dayInWeek+ ", ngày " + curDay + " tháng " + curMonth + " năm " + curYear+".";

		</script>
	</div>


	<div class="container-fluid" style="width: 100vw;height: 66vh;display:${display2}">
		 <form method="post" action="${action}" style="margin-top: 30vh;">
		 	
		 	<div class="row">
		 		<h3 style="text-align:center;">${title}</h3>
			 	<div class="col-md-4"></div>
			 	<div class="col-md-4">
			 		<input type="password" style="width: 100%;padding: 10px;border-radius: 10px;outline: none;" name="pass" placeholder="${mess}" required>
			 	</div>
			 	<div class="col-md-4"></div>
			 </div>

			 <div class="row" style="margin-top: 20px;">
			 	<div class="col-md-5"></div>
			 	<div class="col-md-2">
			 		<button type="submit" style="width: 100%;" class="btn btn-primary">${btn}</button>
			 	</div>
			 	<div class="col-md-5"></div>
			 </div>

		 </form>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

</body>
</html>