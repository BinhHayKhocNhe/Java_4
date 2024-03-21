<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<h4 class="text-center mt-4">USER LIST</h4>
<div class="container d-flex">
	<table class="table w-50" style="margin: 0 auto;">
		<thead>
			<tr>
				<th scope="col">Username</th>
				<th scope="col">Password</th>
				<th scope="col">Remember</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${items}">
				<tr>
					<td>${item.username}</td>
					<td>${item.password}</td>
					<td>${item.remember ? 'Yes' : 'No'}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>