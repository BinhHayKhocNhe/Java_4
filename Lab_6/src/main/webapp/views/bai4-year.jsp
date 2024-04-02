<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bai4-year</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
</head>
<body>
	<div class="container mt-3 d-flex">
		<select onChange="changeAction()" id="select_box" name="year"
			class="form-select w-25" aria-label="Default select example" style="margin: 0 auto;">
			<c:forEach var="year" items="${years}">
				<c:if test="${year[1]==index}">
					<option selected>${year[0]}</option>
				</c:if>

				<c:if test="${year[1]!=index}">
					<option>${year[0]}</option>
				</c:if>
			</c:forEach>
		</select>
	</div>
	<div class="container mt-3">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Title</th>
					<th scope="col">Favorite Count</th>
					<th scope="col">Newest Date</th>
					<th scope="col">Oldest Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${reports}" var="report" varStatus="loop">
					<tr>
						<th scope="row">${loop.index + 1}</th>
						<td>${report[0]}</td>
						<td>${report[1]}</td>
						<td>${report[2]}</td>
						<td>${report[3]}</td>
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
<script type="text/javascript">
	var x = document.getElementById("select_box");
	x.addEventListener("change", function() {
		window.location = "/Lab_6_Java4/bai4-year?year=" + x.value + "&index="
				+ x.selectedIndex;
	});
</script>
</html>