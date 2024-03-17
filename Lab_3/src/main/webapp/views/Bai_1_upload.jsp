<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<form action="Servlet_Bai_1" method="post" enctype="multipart/form-data">
			<div class="input-group mb-3 w-25">
				<input type="file" class="form-control"
					placeholder="Recipient's username"
					aria-label="Recipient's username" aria-describedby="basic-addon2"
					name="photoFile">
			</div>
			<div class="input-group mb-3 w-25">
				<input type="file" class="form-control"
					placeholder="Recipient's username"
					aria-label="Recipient's username" aria-describedby="basic-addon2"
					name="allFile">
			</div>
			<button type="submit" class="btn btn-primary">Upload</button>
		</form>
	</div>

</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>