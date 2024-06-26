<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
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
<title>Product</title>
</head>

<body>
	<%@include file="header.jsp"%>
	<div class="pd-top">
		<div class="container">
			<p>
				<span class="border-end pe-3">Trang chủ</span><span
					class="ps-3 fw-medium">${categoryName}</span>
			</p>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-2 col-lg-2 col-sm-12 mb-3">
				<div class="card">
					<div class="accordion accordion-flush" id="accordionFlushExample">
						<div class="accordion-item">
							<h2 class="accordion-header">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
									aria-expanded="false" aria-controls="flush-collapseOne">
									Loại sản phẩm</button>
							</h2>
							<div id="flush-collapseOne" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value="" id="">
										<label class="form-check-label" for=""> Túi xách </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value="" id="">
										<label class="form-check-label" for=""> Giày dép </label>
									</div>
								</div>
							</div>
						</div>
						<div class="accordion-item">
							<h2 class="accordion-header">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo"
									aria-expanded="false" aria-controls="flush-collapseTwo">
									Giá cả</button>
							</h2>
							<div id="flush-collapseTwo" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value="" id="">
										<label class="form-check-label" for=""> Mặc định </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value="" id="">
										<label class="form-check-label" for=""> Dưới 5 triệu </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value="" id="">
										<label class="form-check-label" for=""> Từ 5 đến 10
											triệu </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value="" id="">
										<label class="form-check-label" for=""> Từ 10 đến 30
											triệu </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value="" id="">
										<label class="form-check-label" for=""> Trên 30 triệu
										</label>
									</div>
								</div>
							</div>
						</div>
						<div class="accordion-item">
							<h2 class="accordion-header">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#flush-collapseThree"
									aria-expanded="false" aria-controls="flush-collapseThree">
									Size</button>
							</h2>
							<div id="flush-collapseThree" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value="" id="">
										<label class="form-check-label" for=""> S </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value="" id="">
										<label class="form-check-label" for=""> M </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value="" id="">
										<label class="form-check-label" for=""> L </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value="" id="">
										<label class="form-check-label" for=""> XL </label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-10 col-lg-10 col-sm-12 mb-3">
				<div class="d-flex justify-content-end mb-3">
					<select class="form-select" aria-label="Default select example"
						style="width: 150px;">
						<option selected>Mặc định</option>
						<option value="1">Giá tăng dần</option>
						<option value="2">Giá giảm dần</option>
						<option value="3">Sale</option>
					</select>
				</div>
				<div class="row">

					<c:forEach var="product" items="${product}">
						<div class="col-lg-4 col-md-6 col-sm-12 mb-3">
							<div class="card slide-top">
								<div>
									<a href="Servlet_Detail?productId=${product.productID}"> <img
										src="${product.imageURL}" class="card-img-top" alt="...">
									</a>
								</div>
								<div class="text-center mt-2">
									<a href="Servlet_Detail?productId=${product.productID}"
										class="text-decoration-none text-black fw-light text-shadow-pop-bottom">
										${product.productName} </a>
								</div>
								<div class="d-flex justify-content-around align-items-center">
									<div>
										<a href="#"
											class="icon_hover text-secondary btn btn-link px-2 py-3"><i
											class="bi bi-heart"></i></a> <a href="#"
											class="icon_hover text-secondary btn btn-link px-2 py-3"><i
											class="bi bi-cart-plus"></i></a> <a href="#"
											class="icon_hover text-secondary btn btn-link px-2 py-3"><i
											class="bi bi-share"></i></a>
									</div>
									<div>
										<c:choose>
											<c:when test="${product.sale > 0}">
												<span class="text-decoration-line-through"> <fmt:formatNumber
														type="number" value="${product.price}" pattern="#,##0" />đ
												</span>
												<span style="color: #a71d1d;"> <fmt:formatNumber
														type="number"
														value="${product.price - (product.price * product.sale / 100)}"
														pattern="#,##0" />đ
												</span>
											</c:when>
											<c:otherwise>
												<fmt:formatNumber type="number" value="${product.price}"
													pattern="#,##0" />đ
        </c:otherwise>
										</c:choose>
									</div>

								</div>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>
		</div>
		<div class="mb-3 d-flex justify-content-center">
			<nav aria-label="Page navigation example" style="margin: 0 auto;">
				<ul class="pagination">
					<li class="page-item"><c:choose>
							<c:when test="${currentPage == 0}">
								<span class="page-link">Đầu tiên</span>
							</c:when>
							<c:otherwise>
								<a class="page-link"
									href="Servlet_Product?page=${currentPage - 1}&amp;categoryId=${id}">Lùi</a>
							</c:otherwise>
						</c:choose></li>

					<c:forEach var="pageNumber" begin="1" end="${totalPages}">
						<li class="page-item"><c:choose>
								<c:when test="${pageNumber == currentPage}">
									<span class="page-link">${pageNumber}</span>
								</c:when>
								<c:otherwise>
									<a class="page-link"
										href="Servlet_Product?page=${pageNumber}&amp;categoryId=${id}">${pageNumber}</a>
								</c:otherwise>
							</c:choose></li>
					</c:forEach>

					<li class="page-item"><c:choose>
							<c:when test="${currentPage == totalPages}">
								<span class="page-link">Cuối cùng</span>
							</c:when>
							<c:otherwise>
								<a class="page-link"
									href="Servlet_Product?page=${currentPage + 1}&amp;categoryId=${id}">Kế
									tiếp</a>
							</c:otherwise>
						</c:choose></li>
				</ul>
			</nav>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>

</html>