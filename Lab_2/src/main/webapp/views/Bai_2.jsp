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
				<label for="exampleFormControlInput1" class="form-label">Tên
					đăng nhập:</label> <input type="text" class="form-control"
					placeholder="*Username" name="username" required="required"
					value="">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">Mật
					khẩu:</label> <input type="password" class="form-control"
					placeholder="*Password" name="password" required="required"
					value="">
			</div>
			<div class="mb-3 d-flex justify-content-between">
				<label for="exampleFormControlTextarea1" class="form-label">
					Giới tính:</label>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="gender"
						id="flexRadioDefault1" value="Nam" checked="checked"> <label
						class="form-check-label" for="flexRadioDefault1"> Nam </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="gender"
						id="flexRadioDefault2" value="Nữ"> <label
						class="form-check-label" for="flexRadioDefault2"> Nữ </label>
				</div>
			</div>
			<div class="form-check form-check-inline mb-3">
				<input class="form-check-input" type="checkbox" id="inlineCheckbox1"
					value="Lập gia đình" name="marriage"> <label
					class="form-check-label" for="inlineCheckbox1">Đã có gia
					đình ?</label>
			</div>
			<div class="mb-3">
				<div>Sở thích:</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="Bóng chuyền"
						name="favorite"> <label class="form-check-label"
						for="flexCheckDefault"> Bóng chuyền </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="Chơi game"
						name="favorite"> <label class="form-check-label"
						for="flexCheckChecked"> Chơi game </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="Cầu lông"
						name="favorite"> <label class="form-check-label"
						for="flexCheckDefault"> Cầu lông </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="Xem phim"
						name="favorite"> <label class="form-check-label"
						for="flexCheckChecked"> Xem phim </label>
				</div>
			</div>
			<div class="mb-3">
				<select class="form-select" aria-label="Default select example"
					name="country">
					<option selected>Quốc tịch</option>
					<option value="USA">USA</option>
					<option value="Vietnamese">Vietnamese</option>
					<option value="China">China</option>
					<option value="Japan">Japan</option>
				</select>
			</div>
			<div class="form-floating mb-3">
				<textarea class="form-control" placeholder="Leave a comment here"
					id="floatingTextarea" name="note"></textarea>
				<label for="floatingTextarea">Ghi chú</label>
			</div>
			<button formaction="bai2" type="submit" class="btn btn-primary mb-3">Đăng
				kí</button>
		</div>
	</form>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>