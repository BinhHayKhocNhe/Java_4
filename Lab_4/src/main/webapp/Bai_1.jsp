<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
<link rel="stylesheet" href="css/layout.css">
</head>

<body>

	<%@include file="views/menu.jsp"%>
	
	<div class="container mb-4 text-size">
		<div class="row">
			<article class="col-md-9">
				<div class="row text-center">
				
					<jsp:include page="views/item.jsp">
						<jsp:param value="Sản phẩm 1" name="name" />
						<jsp:param value="product-1.jpeg" name="img" />
						<jsp:param value="500" name="price" />
					</jsp:include>
					
					<jsp:include page="views/item.jsp">
						<jsp:param value="Sản phẩm 2" name="name" />
						<jsp:param value="product-2.jpeg" name="img" />
						<jsp:param value="740" name="price" />
					</jsp:include>
					
					<jsp:include page="views/item.jsp">
						<jsp:param value="Sản phẩm 3" name="name" />
						<jsp:param value="product-3.jpeg" name="img" />
						<jsp:param value="300" name="price" />
					</jsp:include>
					
					<jsp:include page="views/item.jsp">
						<jsp:param value="Sản phẩm 4" name="name" />
						<jsp:param value="product-4.jpeg" name="img" />
						<jsp:param value="870" name="price" />
					</jsp:include>
					
					<jsp:include page="views/item.jsp">
						<jsp:param value="Sản phẩm 5" name="name" />
						<jsp:param value="product-1.jpeg" name="img" />
						<jsp:param value="1200" name="price" />
					</jsp:include>
					
					<jsp:include page="views/item.jsp">
						<jsp:param value="Sản phẩm 6" name="name" />
						<jsp:param value="product-2.jpeg" name="img" />
						<jsp:param value="845" name="price" />
					</jsp:include>
				</div>
			</article>
			
			<aside class="col-md-3 col-12">
				<%@include file="views/login.jsp"%>
				<%@include file="views/category.jsp"%>
			</aside>
		</div>
	</div>
	
	<%@include file="views/footer.jsp"%>

</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>

</html>