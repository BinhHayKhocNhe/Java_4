<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<title>Quên mật khẩu</title>
</head>
<body>
	<div class="container mt-5">
		<form class="w-25" action="Servlet_Bai_5" method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Nhập
					email đăng kí với tài khoản</label> <input type="email"
					class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="to" value="${toEmail}">
			</div>
			<button type="submit" class="btn btn-primary" formaction="Servlet_Bai_5">Gửi mã về
				Email</button>
		</form>
	</div>
	<h2>${ message}</h2>
	
	<div class="container mt-5" style="display: ${display}">
		<form class="w-25" action="ForgetPassword" method="post" >
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Nhập
					mã xác nhận</label> <input type="number"
					class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="forget">
			</div>
			<button type="submit" class="btn btn-primary" formaction="ForgetPassword">OK</button>
		</form>
	</div>

</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>