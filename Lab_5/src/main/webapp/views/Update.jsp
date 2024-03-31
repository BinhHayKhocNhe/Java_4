<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update profile</title>
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
		<form class="w-25" style="margin: 0 auto;" action="edit-profile"
			method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Tài khoản
				</label> <input type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="id" value="${user.id}">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Mật
					khẩu</label> <input type="password" class="form-control"
					id="exampleInputPassword1" name="password" value="${user.password}">
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Họ và tên
				</label> <input type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="fullname"
					value="${user.fullname}">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Email
				</label> <input type="email" class="form-control" id="exampleInputPassword1"
					name="email" value="${user.email}">
			</div>
			<div class="d-flex mb-3">
				<div class="form-check me-2">
					<input class="form-check-input" type="radio" name="role"
						id="userRadio" value="false" ${!user.role ? 'checked' : ''}>
					<label class="form-check-label" for="userRadio">User</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="role"
						id="adminRadio" value="true" ${user.role ? 'checked' : ''}>
					<label class="form-check-label" for="adminRadio">Admin</label>
				</div>
			</div>
			<button formaction="edit-profile" type="submit"
				class="btn btn-primary">Chỉnh sửa</button>
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
	<div class="container mt-3 w-50">
		<table class="table table-bordered table-hover">
			<thead>
				<tr class="text-center">
					<th scope="col">Username</th>
					<th scope="col">Password</th>
					<th scope="col">Fullname</th>
					<th scope="col">Email</th>
					<th scope="col">Admin</th>
					<th scope="col">Edit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr class="text-center">
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.password}" /></td>
						<td><c:out value="${user.fullname}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.role ? 'Admin' : 'User'}" /></td>
						<td><a href="/Lab_5_Java4/edit-profile?id=${user.id}">
								Edit </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>