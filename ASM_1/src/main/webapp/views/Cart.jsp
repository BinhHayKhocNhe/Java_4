<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Cart</title>
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
</head>

<body>
	<%@include file="header.jsp"%>
	<div class="pd-top">
		<div class="container">
			<p>
				<span class="border-end pe-3">Trang chủ</span><span
					class="ps-3 fw-medium">Giỏ hàng</span>
			</p>
			<p class="text-black ">GIỎ HÀNG CỦA BẠN</p>
		</div>
	</div>
	<div class="container mb-3">
		<table class="table table-hover table-bordered table-sm">
			<thead>
				<tr class="text-center align-middle">
					<th scope="col">STT</th>
					<th scope="col">Mã sản phẩm</th>
					<th scope="col">Tên sản phẩm</th>
					<th scope="col">Đơn giá</th>
					<th scope="col">Số lượng</th>
					<th scope="col">Thành tiền</th>
					<th scope="col">Hành động</th>
				</tr>
			</thead>
			<tbody class="text-center align-middle">
				<tr>
					<td>1</td>
					<td>SP001</td>
					<td>Túi đeo chéo</td>
					<td>245,000 VND</td>
					<td class="d-flex justify-content-center align-items-center">
						<div class="input-group mb-3 w-75 w-sm-100 mt-2">
							<button class="btn btn-outline-secondary " type="submit"
								id="button-addon1" name="action" value="Tru">-</button>
							<input type="number" class="form-control" placeholder=""
								aria-label="Example text with button addon"
								aria-describedby="button-addon1" value="1" min="1"
								name="countProduct" disabled>
							<button class="btn btn-outline-secondary " type="submit"
								id="button-addon1" name="action" value="Cong">+</button>
						</div>
					</td>
					<td>245,000 VND</td>
					<td><span><a href="" class="text-decoration-none me-2"
							style="color: red;">Đặt mua</a></span> <span><a href=""
							class="text-decoration-none text-secondary">Xóa</a></span></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="container mb-3">
		<div class="d-flex justify-content-end align-items-center">
			<h6 class="me-3 fw-normal text-secondary mb-0">Tổng tiền:
				245,000VND</h6>
			<button type="button" class="btn btn-warning me-3">Đặt mua
				tất cả</button>
			<a href="Servlet_index" class="btn btn-secondary">Quay lại</a>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>

</html>