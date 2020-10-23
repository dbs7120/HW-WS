<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>도서 목록</title>
<meta charset="utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
.container {
	width: 700px;
}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div class="container mx-auto">
		<h2 class="text-center bg-light mt-5 mb-2 p-2">제품목록화면</h2>
		<div class="text-right mb-3">
			<form id="searchform" method="GET" action="${root}/list">
				<select name="searchType">
					<option value="">전체</option>
					<option value="name">제품명</option>
					<option value="type">제품종류</option>
					<option value="price">가격</option>
				</select>
				<input type="text" name="searchWord">
				<button id="searchBtn">검색</button>
			</form>
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>상품번호</th>
					<th>상품명</th>
					<th>상품종류</th>
					<th>상품가격</th>
					<th>상품수량</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<tr>
						<td>${product.product_id}</td>
						<td>${product.name}</td>
						<td>${product.type}</td>
						<td>${product.price}</td>
						<td>${product.amount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p class="text-center">
			<a href="${root}/mvadd">제품 등록</a> <a href="${root}">메인화면</a>
		</p>
	</div>
</body>
</html>