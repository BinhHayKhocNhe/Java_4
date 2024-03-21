<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h4 class="text-center mt-4">USER MANAGEMENT</h4>
<div class="container d-flex">
	<form class="w-25 mt-4" style="margin: 0 auto;" action="Bai_2"
		method="post">
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Username:</label>
			<input type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" value="${form.username}"
				name="username">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Password:</label>
			<input type="password" class="form-control"
				id="exampleInputPassword1" value="${form.password}" name="password">
		</div>
		<div class="mb-3 form-check">
			<input type="checkbox" class="form-check-input" id="exampleCheck1"
				name="remember" ${form.remember ? 'checked' : ''}> <label
				class="form-check-label" for="exampleCheck1">Remember me ?</label>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<hr>