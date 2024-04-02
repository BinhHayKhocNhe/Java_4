<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bai3-id</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
</head>
<body>
	<div class="container mt-3 d-flex">
		<form class="w-25" style="margin: 0 auto;" action="bai3-id"
			method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Username </label>
				<input type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="id"">
			</div>
			<button type="submit" class="btn btn-primary">Search</button>
		</form>
	</div>
	<c:if test="${not empty error_id}">
		<div class="d-flex justify-content-center align-items-center">
			<div class="alert alert-danger mt-3 w-25 text-center" role="alert">${error_id}</div>
		</div>

	</c:if>
	<c:if test="${not empty user}">
		<div class="d-flex justify-content-center align-items-center">
			<div class="alert alert-primary mt-3 w-25 text-center" role="alert">
				<ul>
					<li>${user.fullname}</li>
					<li>${user.email}</li>
				</ul>
			</div>
		</div>
	</c:if>


	<div class="container mt-3">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">ID</th>
					<th scope="col">Title</th>
					<th scope="col">Views</th>
					<th scope="col">Active</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${favorite}" var="favorite" varStatus="loop">
					<tr>
						<th scope="row">${loop.index + 1}</th>
						<td>${favorite.id}</td>
						<td>${favorite.title}</td>
						<td>${favorite.views}</td>
						<td>${favorite.active}</td>
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