<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài 4</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<form class="container mt-5 d-flex align-items-center flex-column"
		action="Servlet_Bai_4" method="post">
		<div class="mb-3 w-25">
			<label for="exampleFormControlInput1" class="form-label">Tài
				khoản: </label> <input type="text" class="form-control"
				placeholder="*Username" required="required" name="username"
				value="${username}">
		</div>
		<div class="mb-3 w-25">
			<label for="exampleFormControlTextarea1" class="form-label">Mật
				khẩu: </label> <input type="password" class="form-control"
				placeholder="*Password" required="required" name="password"
				value="${password}">
		</div>
		<div class="form-check form-switch mb-3 w-25">
			<input class="form-check-input" type="checkbox" role="switch" id=""
				checked name="remember"> <label class="form-check-label"
				for="flexSwitchCheckChecked">Lưu thông tin?</label>
		</div>
		<button type="submit" class="btn btn-primary">Đăng nhập</button>
	</form>
	<div class="container mt-5">
		<h5>${message}</h5>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>