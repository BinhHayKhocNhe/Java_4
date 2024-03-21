<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài 3</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
</head>
<body>
	<div class="container mt-3 d-flex">
		<div class="card" style="width: 18rem; margin: 0 auto;">
			<img src="${item.image}" class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">${item.name}</h5>
				<p class="card-text">Giá gốc: <fmt:formatNumber value="${item.price}"/></p>
				<p class="card-text">
					<c:set var="newprice" value="${item.price *(1-item.discount)}" />
					Giá mới: <span class="item"><fmt:formatNumber
							value="${newprice}" /></span>$
				</p>
				<p class="card-text">
					Mức giá:
					<c:choose>
						<c:when test="${newprice < 10}">Giá thấp</c:when>
						<c:when test="${newprice > 100}">Giá cao</c:when>
						<c:otherwise>Bình thường</c:otherwise>
					</c:choose>
				</p>
				<p class="card-text">Ngày: <span class="item"><fmt:formatDate value="${item.date}"/></span></p>
			</div>
		</div>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>