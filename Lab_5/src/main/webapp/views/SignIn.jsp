<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<%@include file="Bai_4.jsp"%>
	<div class="container mt-3 d-flex">
		<form class="w-25" style="margin: 0 auto;" action="sign-in"
			method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Tài khoản
				</label> <input type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="id">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Mật
					khẩu</label> <input type="password" class="form-control"
					id="exampleInputPassword1" name="password">
			</div>
			<button formaction="sign-in" type="submit" class="btn btn-primary">Đăng
				nhập</button>
		</form>
	</div>
	<div class="mt-3">
		<c:if test="${not empty message}">
			<div class="alert alert-primary" role="alert">${message}</div>
		</c:if>
		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>