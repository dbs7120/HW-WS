<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<body>
<div class="container mx-auto">
	<c:import url="/include/loginStatus.jsp" />

	<h1 class="text-center">결과 페이지</h1>

	<h3 class="text-center">정상적으로 저장 되었습니다.</h3>

	<p class="text-center">
		<a href="main.do?action=SAVE_FORM">추가등록</a>
		<a href="main.do?action=BOOK_LIST">도서목록</a>
	</p>
</div>
</body>
</html>