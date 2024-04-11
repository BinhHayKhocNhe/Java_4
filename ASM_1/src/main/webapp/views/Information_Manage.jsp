<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lí thông tin</title>
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
	<div class="pd-top mb-3">
		<div class="container text-center">
			<h4 class="text-uppercase">Quản lí người dùng</h4>
		</div>
	</div>
	<form method="post" action="Servlet_Information_Manage">
		<div class="container mb-3 d-flex justify-content-center">
			<div class="input-group w-25">
				<input type="text" class="form-control"
					placeholder="Tìm kiếm người dùng?"
					aria-label="Recipient's username" aria-describedby="button-addon2"
					name="keyword">
				<button class="btn btn-outline-secondary" type="submit"
					id="button-addon2" formaction="find">Tìm kiếm</button>
			</div>
		</div>
	</form>

	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-md-12 col-sm-12 mb-3">
				<div class="card">
					<form class="p-3" action=Servlet_Information_Manage method="post">
						<div class="mb-2">
							<label for="exampleInputEmail1" class="form-label"> ID:</label> <input
								type="text" class="form-control" aria-describedby="emailHelp"
								name="ID_User" readonly="readonly" value="${user.getID_User()}">
						</div>
						<div class="mb-2">
							<label for="exampleInputPassword1" class="form-label">Tài
								khoản:</label> <input type="text" class="form-control" name="Username"
								required="required" value="${user.getUsername()}">
						</div>
						<div class="mb-2">
							<label for="exampleInputEmail1" class="form-label">Mật
								khẩu:</label> <input type="password" class="form-control"
								aria-describedby="emailHelp" name="Password" required="required"
								value="${user.getPassword()}">
						</div>
						<div class="mb-2">
							<label for="exampleInputPassword1" class="form-label">Họ
								tên:</label> <input type="text" class="form-control" name="Fullname"
								required="required" value="${user.getFullname()}">
						</div>
						<div class="mb-2">
							<label for="exampleInputEmail1" class="form-label">Email:</label>
							<input type="email" class="form-control"
								aria-describedby="emailHelp" name="Email" required="required"
								value="${user.getEmail()}">
						</div>
						<div class="mb-2">
							<label for="exampleInputPassword1" class="form-label">Số
								điện thoại:</label> <input type="text" class="form-control" name="Phone"
								required="required" value="${user.getPhone()}">
						</div>
						<div class="mb-2 d-flex">
							<div class="me-2">Giới tính:</div>
							<div class="form-check me-2">
								<input class="form-check-input" type="radio" name="Gender"
									id="genderMale"
									<c:if test="${user.isGender() == true or user.isGender() == null}">checked</c:if>>
								<label class="form-check-label" for="genderMale"> Nam </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" name="Gender"
									id="genderFemale"
									<c:if test="${user.isGender() == false}">checked</c:if>>
								<label class="form-check-label" for="genderFemale"> Nữ </label>
							</div>
						</div>
						<div class="mb-2">
							<label for="exampleInputPassword1" class="form-label">Ngày
								sinh:</label> <input type="date" class="form-control" name="Birthday"
								required="required" value="${user.getBirthday()}">
						</div>
						<div class="mb-2 d-flex">
							<div class="me-2">Vai trò:</div>
							<div class="form-check me-2">
								<input class="form-check-input" type="radio" name="Role"
									id="adminRole" value="true"
									<c:if test="${user.getRole() eq 'Admin'}">checked</c:if>>
								<label class="form-check-label" for="adminRole"> Admin </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" name="Role"
									id="userRole" value="false"
									<c:if test="${empty user.getRole() or user.getRole() eq 'User'}">checked</c:if>>
								<label class="form-check-label" for="userRole"> User </label>
							</div>
						</div>
						<button type="submit" class="btn btn-primary" formaction="create">Thêm</button>
						<button type="submit" class="btn btn-warning" formaction="update">Sửa</button>
						<button type="submit" class="btn btn-danger" formaction="delete">Xóa</button>
						<button type="submit" class="btn btn-info" formaction="reset">Mới</button>
						<!-- Button trigger modal -->
						<button type="submit" class="btn btn-secondary"
							data-bs-toggle="modal" data-bs-target="#exampleModal"
							formaction="QRCode">QR Code</button>

						<!-- Modal -->
						<div class="modal fade" id="exampleModal" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h1 class="modal-title fs-5" id="exampleModalLabel">QR Code
											title</h1>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body d-flex justify-content-center">
										<img alt="" src="img/qr_code.png">
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>
						<c:if test="${not empty message}">
							<div class="mt-3 w-100">
								<div class="alert alert-primary" role="alert">${message}</div>
							</div>
						</c:if>
						<c:if test="${not empty error}">
							<div class="mt-3 w-100">
								<div class="alert alert-danger">${error}</div>
							</div>
						</c:if>
					</form>
				</div>
			</div>
			<div class="col-lg-8 col-md-12 col-sm-12 mb-3">
				<table class="table table-bordered table-hover mb-3">
					<thead>
						<tr class="text-center align-middle">
							<th scope="col">STT</th>
							<th scope="col">ID</th>
							<th scope="col">Tài khoản</th>
							<th scope="col">Mật khẩu</th>
							<th scope="col">Họ tên</th>
							<th scope="col">Email</th>
							<th scope="col">SĐT</th>
							<th scope="col">Giới tính</th>
							<th scope="col">Ngày sinh</th>
							<th scope="col">Vai trò</th>
							<th scope="col">Xem thông tin</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${users}" varStatus="loop">
							<tr class="text-center align-middle">
								<td><c:out value="${loop.index + 1}" /></td>
								<td><c:out value="${user.getID_User()}" /></td>
								<td><c:out value="${user.getUsername()}" /></td>
								<td><c:out value="${user.getPassword()}" /></td>
								<td><c:out value="${user.getFullname()}" /></td>
								<td><c:out value="${user.getEmail()}" /></td>
								<td><c:out value="${user.getPhone()}" /></td>
								<td><c:out value="${user.isGender()? 'Nam' : 'Nữ'}" /></td>
								<td><c:out value="${user.getBirthday()}" /></td>
								<td><c:out value="${user.getRole()}" /></td>
								<td><a href="/ASM_1_Java4/edit?id=${user.getID_User()}">Xem</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<nav aria-label="Page navigation example"
					class="d-flex align-items-center justify-content-center mb-2">
					<ul class="pagination mb-0">
						<li class="page-item"><c:choose>
								<c:when test="${currentPage == 0}">
									<span class="page-link">Đầu tiên</span>
								</c:when>
								<c:otherwise>
									<a class="page-link"
										href="Servlet_Information_Manage?page=${currentPage - 1}">Lùi</a>
								</c:otherwise>
							</c:choose></li>

						<c:forEach var="pageNumber" begin="1" end="${totalPages}">
							<li class="page-item"><c:choose>
									<c:when test="${pageNumber == currentPage}">
										<span class="page-link">${pageNumber}</span>
									</c:when>
									<c:otherwise>
										<a class="page-link"
											href="Servlet_Information_Manage?page=${pageNumber}">${pageNumber}</a>
									</c:otherwise>
								</c:choose></li>
						</c:forEach>

						<li class="page-item"><c:choose>
								<c:when test="${currentPage == totalPages}">
									<span class="page-link">Cuối cùng</span>
								</c:when>
								<c:otherwise>
									<a class="page-link"
										href="Servlet_Information_Manage?page=${currentPage + 1}">Kế
										tiếp</a>
								</c:otherwise>
							</c:choose></li>
					</ul>
				</nav>
				<div class="d-flex justify-content-center">
					<div class="me-3">
						<a href="#">Import Excel</a>
					</div>
					<div>
						<a href="#">Export Excel</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>