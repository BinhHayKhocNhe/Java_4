<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài 1</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary container">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
				aria-controls="navbarNavDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">Trang chủ</a></li>
					<li class="nav-item"><a class="nav-link" href="bai1">Bài 1</a></li>
					<li class="nav-item"><a class="nav-link" href="bai2">Bài 2</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="bai3">Bài 3</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<form action="bai1" method="post"
		class="container d-flex align-items-center justify-content-center mt-3">
		<div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Nhập
					cạnh a</label> <input type="number" class="form-control"
					placeholder="*number" name="canhA" required="required" min="0"
					value="${canha }">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">Nhập
					cạnh b</label> <input type="number" class="form-control"
					placeholder="*number" name="canhB" required="required" min="0"
					value="${canhb}">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">Nhập
					cạnh c</label> <input type="number" class="form-control"
					placeholder="*number" name="canhC" required="required" min="0"
					value="${canhc}">
			</div>
			<button formaction="chuViTamGiac" type="submit"
				class="btn btn-primary mb-3">Tính chu vi</button>
			<button formaction="dienTichTamGiac" type="submit"
				class="btn btn-primary mb-3">Tính diện tích</button>
			<div class="">
				<label for="exampleInputEmail1" class="form-label">Kết quả</label> <input
					type="text" class="form-control"
					value="${message}${chuvi}${dientich}" id="exampleInputEmail1"
					aria-describedby="emailHelp" disabled="disabled">
			</div>
		</div>
	</form>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>