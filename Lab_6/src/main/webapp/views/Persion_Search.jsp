<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Persion Search</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
</head>
<body>
	<div class="container mt-3 d-flex">
		<form class="w-25" style="margin: 0 auto;"
			action="Servlet_Persion_Search" method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Video ID </label>
				<input type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="id">
			</div>
			<button type="submit" class="btn btn-primary"
				formaction="Servlet_Persion_Search">Search</button>
		</form>
	</div>
	<div class="container mt-3">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Username</th>
					<th scope="col">Fullname</th>
					<th scope="col">Email</th>
					<th scope="col">Role</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}" varStatus="loop">
					<tr>
						<td>${loop.index + 1}</td>
						<td>${user.id}</td>
						<td>${user.fullname}</td>
						<td>${user.email}</td>
						<td>${user.admin?'Admin':'User'}</td>
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