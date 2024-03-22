<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Detail</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
		<link rel="stylesheet" href="css/base.css">
	</head>

	<body>
		<%@include file="header.jsp" %>

			<div class="pd-top mb-3">
				<div class="container">
					<p>
						<span class="border-end pe-3">Trang chủ</span><span class="ps-3 fw-medium">Chi tiết sản
							phẩm</span>
					</p>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-sm-12 col-md-6 col-lg-6 mb-3">
						<img src="https://pos.nvncdn.com/a6f18e-116325/ps/20220303_Ts1kuHIfU3N8x4NljWhNnjmy.jpg"
							class="rounded mx-auto d-block" alt="...">
					</div>
					<div class="col-sm-12 col-md-6 col-lg-6 mb-3">
						<div class="mb-3">
							<a href="https://maps.app.goo.gl/GJem7CyuJ2bentpF6"
								class="btn btn-secondary text-decoration-none w-100"><i
									class="bi bi-search me-2"></i>Xem vị
								trí cửa hàng</a>
						</div>

						<div class=" mb-3 d-flex align-items-stretch justify-content-start flex-column">
							<p class="text-black" style="font-weight: 700">Túi Mini Basic 2</p>
							<p style="color: #999;
							font-weight: 300;">MN06</p>
							<p style="color: #c00;">375,000đ</p>
							<div class="input-group w-25">
								<button class="btn btn-outline-secondary" type="button" id="button-addon1">-</button>
								<input type="number" value="1" min="1" class="form-control" placeholder=""
									aria-label="Example text with button addon" aria-describedby="button-addon1">
								<button class="btn btn-outline-secondary" type="button" id="button-addon1">+</button>
							</div>
						</div>
						<button type="button" class="btn btn-danger text-uppercase w-100 mb-3">Mua ngay</button>

						<div class="d-flex align-items-center justify-content-around mb-3">
							<div>
								<img src="https://web.nvnstatic.net/tp/T0410/img/svg/noun_return.svg?v=3" alt="">
								<div style="font-size: 16px; font-weight: 700;" >Đổi trả 90 ngày</div>
								<div>(lỗi nhà sản xuất)</div>
							</div>
							<div>
								<img src="https://web.nvnstatic.net/tp/T0410/img/svg/noun_Shipping.svg?v=3" alt="">
								<div style="font-size: 16px; font-weight: 700;" >Miễn phí giao hàng</div>
								<div>(hóa đơn trên 300k)</div>
							</div>
							<div>
								<img src="https://web.nvnstatic.net/tp/T0410/img/svg/noun_call.svg?v=3" alt="">
								<div style="font-size: 16px; font-weight: 700;" >Tổng đài 038.519.3525</div>
								<div>(9.00-21.00)</div>
							</div>
						</div>

						<ul class="nav nav-tabs mb-3">
							<li class="nav-item">
								<a class="nav-link active text-black text-uppercase fw-normal" aria-current="page"
									data-bs-toggle="tab" href="#product-info">Thông tin sản phẩm</a>
							</li>
							<li class="nav-item">
								<a class="nav-link text-black text-uppercase fw-normal" data-bs-toggle="tab"
									href="#details">Chi
									tiết</a>
							</li>
						</ul>

						<div class="tab-content mb-3">
							<div class="tab-pane fade show active" id="product-info">
								<div class="container text-black fs-6 fst-normal" style="text-align: justify;">- Túi
									mini basic 2 là
									một chiếc túi năng động, mang đến
									điểm nhấn riêng cho outfit
									của bạn, đặc biệt đang là HOT TREND năm nay.</div>
							</div>
							<div class="tab-pane fade" id="details">
								<div class="container text-black fs-6 fst-normal" style="text-align: justify;">
									<p>- Kích thước: 20 x 15x 5cm.</p>
									<p>- Màu sắc:đen,trắng.</p>
									<p>- Chất liệu: Da Pu dập vân rắn cao cấp.</p>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>


			<%@include file="footer.jsp" %>
	</body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

	</html>