<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Sign in</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<link rel="stylesheet" href="css/base.css">
</head>

<body>
	<%@include file="header.jsp"%>
	<h4 class="pd-top mb-3 text-center text-uppercase">Đăng nhập</h4>
	<div class="d-flex">
		<form class="w-25" style="margin: 0 auto;" action="Servlet_SignIn"
			method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Tài khoản</label>
				<input type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" required autofocus="autofocus"
					name="Username" value="${username}">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Mật
					khẩu</label> <input type="password" class="form-control"
					id="exampleInputPassword1" required name="Password"
					value="${password}">
			</div>
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1"
					name="remember">
				<div class="d-flex justify-content-between align-items-center">
					<label class="form-check-label" for="exampleCheck1">Ghi nhớ
						đăng nhập</label>
					<div>
						<a href="#">Quên mật khẩu</a>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary w-100 mb-3"
				formaction="sign-in">Đăng nhập</button>
			<div class="text-center">
				Chưa có tài khoản? <a href="Servlet_SignUp">Tạo tài khoản?</a>
			</div>
		</form>
	</div>
	<c:if test="${not empty message}">
		<div class="alert alert-danger container mt-3 w-25 text-center"
			role="alert">${message}</div>
	</c:if>
	<c:if test="${not empty SignUpSuccess}">
		<div class="alert alert-primary container mt-3 w-25 text-center"
			role="alert">${SignUpSuccess}</div>
	</c:if>
	<%@include file="footer.jsp"%>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>

</html>