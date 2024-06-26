<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
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
	<h4 class="pd-top mb-3 text-center text-uppercase">Đăng kí</h4>
	<div class="d-flex">
		<form class="w-25" style="margin: 0 auto;" action="Servlet_SignUp"
			method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Tài khoản</label>
				<input type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" required autofocus="autofocus"
					name="Username" value="${user.username}">
			</div>
			<div class="mb-3">
				<label class="form-label">Mật khẩu</label> <input type="password"
					class="form-control" required name="Password"
					value="${user.password}">
			</div>
			<div class="mb-3">
				<label class="form-label">Họ và tên </label> <input type="text"
					class="form-control" required name="Fullname"
					value="${user.fullname}">
			</div>
			<div class="mb-3">
				<label class="form-label">Email </label> <input type="email"
					class="form-control" required name="Email" value="${user.email}">
			</div>
			<div class="mb-3">
				<label class="form-label">Số điện thoại </label> <input
					type="number" class="form-control" required name="Phone"
					value="${user.phone}">
			</div>
			<div class="mb-3">
				<label for="Birthday" class="form-label">Ngày sinh </label> <input
					type="date" class="form-control" id="Birthday" required
					name="Birthday" value="${formattedBirthday}">
			</div>
			<div class="mb-3 d-flex">
				<div class="me-2">Giới tính:</div>
				<div class="form-check me-2">
					<input class="form-check-input" type="radio" id="flexRadioDefault1"
						name="Gender" value="true"
						<c:if test="${user.gender eq true}">
                checked
            </c:if>
						<c:if test="${user.gender eq null}">
                checked
            </c:if>>
					<label class="form-check-label" for="flexRadioDefault1">
						Nam </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" id="flexRadioDefault2"
						name="Gender" value="false"
						<c:if test="${user.gender eq false}">
                checked
            </c:if>>
					<label class="form-check-label" for="flexRadioDefault2"> Nữ
					</label>
				</div>
			</div>
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1"
					name="agreement">
				<div class="d-flex justify-content-between align-items-center">
					<label class="form-check-label" for="exampleCheck1">Vui
						lòng đồng ý với điều khoản</label>
					<div>
						<a href="#">Quên mật khẩu</a>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary w-100 mb-3"
				formaction="SignUp">Đăng kí</button>
			<div class="text-center">
				Đã có tài khoản? <a href="Servlet_SignIn">Đăng nhập?</a>
			</div>
		</form>
	</div>
	<c:if test="${not empty errorMessage}">
		<div class="alert alert-danger container mt-3 w-25 text-center"
			role="alert">${errorMessage}</div>
	</c:if>
	<%@include file="footer.jsp"%>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>

</html>