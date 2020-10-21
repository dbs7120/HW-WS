<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 전자</title>
</head>
<body>

	<div class="col-lg-8" align="center">
		<h2>제품목록</h2>
		<c:if test="${products.size()!=0}">
			<table border="1" width="500px">
				<caption style="font-size: 50px">상품 리스트</caption>
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
		</c:if>
		<c:if test="${products.size() == 0}">
			<table class="table table-active">
				<tbody>
					<tr class="table-info" align="center">
						<td>제품목록이 없습니다.</td>
					</tr>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>
