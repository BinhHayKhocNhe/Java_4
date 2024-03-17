<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài 2 - 3</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5 d-flex justify-content-center">
		<form class="w-25" action="Servlet_Bai_3" method="post"
			enctype="multipart/form-data">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Họ và tên
				</label> <input type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="fullName">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Hình
					ảnh</label> <input type="file" class="form-control"
					id="exampleInputPassword1" name="photoFile">
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Ngày sinh
				</label> <input type="date" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="birthday">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Quốc
					tịch </label> <select class="form-select"
					aria-label="Default select example" name="country">
					<option selected value="VietNamese">VN</option>
					<option value="USA">USA</option>
					<option value="China">China</option>
					<option value="Order">Order</option>
				</select>
			</div>
			<div class="mb-3 d-flex">
				<div class="me-3">Giới tính:</div>
				<div class="form-check me-3">
					<input class="form-check-input" type="radio" name="gender"
						id="flexRadioDefault1" checked="checked" value="true"> <label
						class="form-check-label" for="flexRadioDefault1"> Nam </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="gender"
						id="flexRadioDefault2" value="false"> <label
						class="form-check-label" for="flexRadioDefault2"> Nữ </label>
				</div>
			</div>
			<div class="mb-3 d-flex">
				<div class="me-3">Tình trạng hôn nhân?</div>
				<input class="form-check-input me-2" type="checkbox" value="true"
					id="" name="married"> <label
					class="form-check-label" for="flexCheckDefault">Đã có gia
					đình? </label>
			</div>
			<div class="mb-3 d-flex flex-column">
				<div class="me-3">Sở thích</div>
				<div>
					<input class="form-check-input" type="checkbox" value="Đá bóng"
						id="" name="hobbies"> <label
						class="form-check-label" for="flexCheckDefault">Đá bóng </label>
				</div>
				<div>
					<input class="form-check-input" type="checkbox" value="Nhảy dây"
						id="" name="hobbies"> <label
						class="form-check-label" for="flexCheckDefault">Nhảy dây </label>
				</div>
				<div>
					<input class="form-check-input" type="checkbox" value="Code"
						id="" name="hobbies"> <label
						class="form-check-label" for="flexCheckDefault">Code</label>
				</div>
				<div>
					<input class="form-check-input" type="checkbox" value="Khác"
						id="" name="hobbies" checked="checked"> <label
						class="form-check-label" for="flexCheckDefault">Khác</label>
				</div>
			</div>
			<div class="form-floating mb-3">
				<textarea class="form-control" placeholder="Leave a comment here"
					id="floatingTextarea2" name="note"></textarea>
				<label for="floatingTextarea2">Ghi chú:</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<div class="mt-3">
				<h4 style="color: red;">${error}</h4>
			</div>
		</form>

	</div>
	
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>