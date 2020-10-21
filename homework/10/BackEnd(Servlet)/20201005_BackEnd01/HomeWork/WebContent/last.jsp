<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.ssafy.model.*"%>
<%
ProductDto product = (ProductDto)request.getAttribute("product");
%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<title>SSAFY</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
		<script type="text/javascript">

		function searchArticle() {
			if(document.getElementById("word").value == "") {
				alert("마지막값 조회!!");
			}
			document.getElementById("searchform").action = "./main.do";
			document.getElementById("searchform").submit();
		}
		</script>
	</head>
	<body>
	<div class="container" align="center">
	  <div class="col-lg-8" align="center">
	  <h2>제품목록</h2>


	 <table border="1" width="500px">
		<caption style="font-size: 50px">마지막 등록한 상품</caption>
		<thead>
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>상품가격</th>
				<th>상품설명</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=product.getId()%></td>
				<td><%=product.getName()%></td>
				<td><%=product.getPrice()%></td>
				<td><%=product.getDesc()%></td>
			</tr>
		</tbody>
	</table>
	  </div>
	</div>
	</body>
</html>
