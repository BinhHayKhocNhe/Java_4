<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Favorite Search</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
</head>
<body>
	<form id="form-1" action="Servlet_Favorite_Search" method="post">
		<div class="d-flex justify-content-center align-items-center mt-3">
			<div class="form-check me-3">
				<input ${favorite == 'true' ? 'checked' : '${favorite}'} class="form-check-input"
					type="radio" name="favorite" id="flexRadioDefault1"
					onClick="fvAction(true)"> <label class="form-check-label"
					for="flexRadioDefault1"> Favorite </label>
			</div>
			<div class="form-check">
				<input ${favorite == 'false' ? 'checked' : '${favorite}'} class="form-check-input"
					type="radio" name="favorite" id="flexRadioDefault2"
					onClick="fvAction(false)"> <label class="form-check-label"
					for="flexRadioDefault2"> Not Favorite </label>
			</div>
		</div>
	</form>
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
				<c:forEach var="video" items="${Video}" varStatus="loop">
					<tr>
						<td>${loop.index + 1}</td>
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
<script>
	function fvAction(x) {
		window.location.href = "/Lab_6_Java4/Servlet_Favorite_Search?favorite=" + x;
	}
</script>
</html>