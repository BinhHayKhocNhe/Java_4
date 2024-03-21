<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="col-lg-4 col-md-6 col-12 mb-4">
	<div class="card">
		<div class="card-header">
			<span class="underline">${param.name}</span>
		</div>
		<div class="card-body">
			<img src="img/${param.img}" alt="" class="img-fluid">
		</div>
		<div class="card-footer">
			<span>${param.price}$</span>
		</div>
	</div>
</div>