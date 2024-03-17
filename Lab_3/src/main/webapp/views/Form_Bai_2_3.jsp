<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-3 mt-5">
				<div class="card">
					<img src="files/${bean.photoFile}" class="card-img-top" alt="...">
				</div>
			</div>
			<div class="col-9 mt-5">
				<table class="table table-hover table-bordered ">
					<thead>
						<tr>
							<th scope="col">Fullname</th>
							<th scope="col">Birthday</th>
							<th scope="col">Gender</th>
							<th scope="col">Country</th>
							<th scope="col">Married</th>
							<th scope="col">Hobbies</th>
							<th scope="col">Notes</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${bean.fullName}</td>
							<td>${bean.birthday}</td>
							<td>${bean.gender ? 'Nam' : 'Nữ'}</td>
							<td>${bean.country}</td>
							<td>${bean.married? 'Đã có' : 'Không có người yêu !'}</td>
							<td>${soThich}</td>
							<td>${bean.note}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>


</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>