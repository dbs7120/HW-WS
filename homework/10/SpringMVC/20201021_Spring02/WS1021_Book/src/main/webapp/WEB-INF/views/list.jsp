<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>도서 목록</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<style>
	.container {
		width: 700px;
	}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>

</head>
<body>
<div class="container mx-auto">
	<h2 class="text-center bg-light mt-5 mb-2 p-2">도서 목록 화면</h2>

	<div class="text-right mb-3">
		<form id="searchform" method="GET" action="${root}/list">
			<select name="searchType">
				<option value="">전체</option>
				<option value="title">도서명</option>
				<option value="publisher">출판사</option>
				<option value="price">가격</option>
			</select>
			<input type="text" name="searchWord">
			<button>검색</button>
		</form>
	</div>
	<table class="table table-bordered">
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>도서분류</th>
			<th>저자</th>
		</tr>
		<c:forEach var="book" items="${list}">
			<tr>
				<td>${book.isbn}</td>
				<td><a href="${root}/bookView?isbn=${book.isbn}">${book.title}</a></td>
				<td>${book.catalogue}</td>
				<td>${book.author}</td>
			</tr>
		</c:forEach>
	</table>
	<p class="text-center">
		<a href="${root}/mvadd">도서 등록</a>
		<a href="${root}/">메인페이지</a>
	</p>
</div>
</body>
</html>