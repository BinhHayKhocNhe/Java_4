<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bai3-months</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
</head>
<body>
	<div class="container mt-4">
		<form class="w-25" style="margin: 0 auto;" action="bai3-months"
			method="post">
			<div class="d-flex">
				<c:forEach begin="1" end="12" var="i" varStatus="loop">
					<div class="form-check ms-2">
						<input class="form-check-input" type="checkbox"
							id="flexCheck${loop.count}" name="month" value="${loop.count}">
						<label class="form-check-label" for="flexCheck${loop.count}">${loop.count}</label>
					</div>
				</c:forEach>
			</div>
			<button type="submit" class="btn btn-primary">Search</button>
		</form>
	</div>

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
				<c:forEach items="${videos}" var="video" varStatus="loop">
					<tr>
						<th scope="row">${loop.index + 1}</th>
						<td>${video.id}</td>
						<td>${video.title}</td>
						<td>${video.views}</td>
						<td>${video.active}</td>
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