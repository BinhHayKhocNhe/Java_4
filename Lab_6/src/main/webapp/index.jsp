<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
					aria-controls="navbarNavDropdown" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavDropdown">
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Bài 2 </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="Servlet_ID_Search">Search
										by user ID</a></li>
								<li><a class="dropdown-item" href="Servlet_Title_Search">Search
										by video</a></li>
								<li><a class="dropdown-item" href="Servlet_Persion_Search">User
										Search</a></li>
								<li><a class="dropdown-item" href="Servlet_Favorite_Search">Search
										by favorite</a></li>
								<li><a class="dropdown-item" href="Servlet_Group_Video">Report</a></li>
							</ul></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Bài 3 </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="bai3-title"> Title
										Search</a></li>
								<li><a class="dropdown-item" href="bai3-id"> ID Search</a></li>
								<li><a class="dropdown-item" href="bai3-range">Range
										Search </a></li>
								<li><a class="dropdown-item" href="bai3-months"> Months
										Search</a></li>
							</ul></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Bài 4 </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="bai4-ran"> Random </a></li>
								<li><a class="dropdown-item" href="bai4-year">Year
										Search</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>