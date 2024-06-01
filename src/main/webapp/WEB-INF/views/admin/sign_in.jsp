<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Đăng nhập - Admin login</title>
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
				<h4 style="text-align:center;color: white;padding: 10px;">LOGIN FOR ADMIN</h4>
			</div>
		</div>
	</div>
	<!-- Body -->
	<div class="container-fluid body" style="margin-top: 20px;height: 500px;max-height: 500px;">
		<div class="container">
			
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					
					<!-- Pills content -->
			<div class="tab-content">
			  <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
			    <form method="post" action="/T-Food/admin/sign-in">
			      <div class="text-center mb-3">
			        <p><h5>Sign in with</h5></p>
			        <button type="button" class="btn btn-link btn-floating mx-1">
			          <i class="fab fa-facebook-f"></i>
			        </button>

			        <button type="button" class="btn btn-link btn-floating mx-1">
			          <i class="fab fa-google"></i>
			        </button>

			        <button type="button" class="btn btn-link btn-floating mx-1">
			          <i class="fab fa-twitter"></i>
			        </button>

			        <button type="button" class="btn btn-link btn-floating mx-1">
			          <i class="fab fa-github"></i>
			        </button>
			      </div>

			      <p class="text-center">Or:</p>
					
					<p>
						<h5  class="text-danger" style="text-align: center;font-weight: bold;" >${notify}</h5>
					</p>
					
			      <!-- Email input -->
			      <div class="form-outline mb-4">
			      	<label class="form-label" for="loginName">Email or username</label>
			        <input type="text" name="username" id="loginName" class="form-control" />
			        
			      </div>

			      <!-- Password input -->
			      <div class="form-outline mb-4">
			      	<label class="form-label" for="loginPassword">Password</label>
			        <input type="password" name="password" id="loginPassword" class="form-control" />
			        
			      </div>

			      <!-- 2 column grid layout -->
			      <div class="row mb-4">
			        <div class="col-md-6 d-flex justify-content-center">
			          <!-- Checkbox -->
			          <div class="form-check mb-3 mb-md-0">
			            <input class="form-check-input" type="checkbox" value="" id="loginCheck" checked />
			            <label class="form-check-label" for="loginCheck"> Remember me </label>
			          </div>
			        </div>

			        <div class="col-md-6 d-flex justify-content-center">
			          <!-- Simple link -->
			          <a href="#!">Forgot password?</a>
			        </div>
			      </div>

			      <!-- Submit button -->
			      <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>

			      <!-- Register buttons -->
			      <div class="text-center">
			        <!-- <p>Not a member? <a href="#!">Register</a></p> -->
			      </div>
			    </form>
			  </div>
			
			</div>
			<!-- Pills content -->

				</div>
				<div class="col-md-3"></div>
			</div>

			
			

		</div>


	</div>
	<!-- Footer -->
	<div class="container-fluid footer">
		<div class="container">
			<div class="row">
				<h1 class="txt-tfood">TFOOD</h1>
				<p style="text-align:right"><a target="_blank" class="btn btn-dark" href="http://fb.com/t.a.t.14.08">@2022 by T.A.T</a></p>
				<hr class="hr-footer">
				
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