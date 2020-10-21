<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보</title>
<style type="text/css">
body, h1, h4 {
	text-align: center;
}

#bookTable {
	margin: auto auto;
}

p {
	text-align: center;
}

#bookTable td {
	border: 1px solid black;
	padding: 10px 0px;
}

#bookTable td:first-child {
	text-align: center;
	background-color: lightgray;
}

#bookTable td:nth-child(2) {
	width: 500px;
}
</style>
</head>
<body>
	<h1>입력된 도서 정보</h1>
	<table id="bookTable">
		<tr>
			<td colspan="2">도서 정보</td>
		</tr>
		<tr>
			<td>도서명</td>
			<td>${book.title }</td>
		</tr>
		<tr>
			<td>도서번호</td>
			<td>${book.isbn }</td>
		</tr>
		<tr>
			<td>도서분류</td>
			<td>${book.catalogue }</td>
		</tr>
		<tr>
			<td>도서국가</td>
			<td>${book.nation }</td>
		</tr>
		<tr>
			<td>출판일</td>
			<td>${book.publishDate }</td>
		</tr>
		<tr>
			<td>출판사</td>
			<td>${book.publisher }</td>
		</tr>
		<tr>
			<td>저자</td>
			<td>${book.author }</td>
		</tr>
		<tr>
			<td>도서가격</td>
			<td>${book.price }${book.currency }</td>
		</tr>
		<tr>
			<td>도서설명</td>
			<td>${book.description }</td>
		</tr>
	</table>
	<p>
		<a href="${root}/list">도서목록으로 돌아가기</a>
		<a href="${root}/delete?isbn=${book.isbn}">도서 삭제</a>
	</p>
</body>
</html>

