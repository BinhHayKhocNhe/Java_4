<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phân trang</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
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
	<div class="d-flex">
		<nav aria-label="Page navigation example" style="margin: 0 auto;">
			<ul class="pagination">
				<li class="page-item"><c:choose>
						<c:when test="${currentPage == 0}">
							<span class="page-link">Đầu tiên</span>
						</c:when>
						<c:otherwise>
							<a class="page-link" href="Servlet_Bai_5?page=${currentPage - 1}">Lùi</a>
						</c:otherwise>
					</c:choose></li>

				<c:forEach var="pageNumber" begin="1" end="${totalPages}">
					<li class="page-item"><c:choose>
							<c:when test="${pageNumber == currentPage}">
								<span class="page-link">${pageNumber}</span>
							</c:when>
							<c:otherwise>
								<a class="page-link" href="Servlet_Bai_5?page=${pageNumber}">${pageNumber}</a>
							</c:otherwise>
						</c:choose></li>
				</c:forEach>

				<li class="page-item"><c:choose>
						<c:when test="${currentPage == totalPages}">
							<span class="page-link">Cuối cùng</span>
						</c:when>
						<c:otherwise>
							<a class="page-link"
								href="Servlet_Bai_5?page=${currentPage + 1}">Kế tiếp</a>
						</c:otherwise>
					</c:choose></li>
			</ul>
		</nav>
	</div>

</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>