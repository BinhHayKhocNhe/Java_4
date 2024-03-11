<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài 2</title>
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
	<form action="bai2" method="post"
		class="container d-flex align-items-center justify-content-center mt-3">
		<div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Nhập
					chiều dài</label> <input type="number" class="form-control"
					placeholder="*number" name="chieuDai" required="required" min="0">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">Nhập
					chiều rộng</label> <input type="number" class="form-control"
					placeholder="*number" name="chieuRong" required="required" min="0">
			</div>
			<button type="submit" class="btn btn-primary mb-3">Tính toán</button>
			<div class="">
				<label for="exampleInputEmail1" class="form-label">Kết quả </label>
				<input type="text" class="form-control"
					value="Chu vi là: ${truyenChuVi}, diện tích là: ${truyenDienTich}"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					disabled="disabled">
			</div>
		</div>
	</form>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>