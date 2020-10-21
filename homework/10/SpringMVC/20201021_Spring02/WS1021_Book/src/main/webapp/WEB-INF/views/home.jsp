<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<div align="center">
		<h1>도서관리 프로그램</h1>
		<a href="${root}/mvadd">1.도서추가</a><br /> 
		<a href="${root}/list">2.도서목록</a><br />
	</div>
</body>
</html>
