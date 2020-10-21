<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.ssafy.model.*"%>
<%
	//String root = request.getContextPath();

MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
if(memberDto == null)
	response.sendRedirect("./main.do");
else {
	List<ProductDto> list = (List<ProductDto>)request.getAttribute("articles");
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
				alert("모든 목록 조회!!");
			}
			document.getElementById("searchform").action = "./main.do";
			document.getElementById("searchform").submit();
		}
		</script>
	</head>
	<body>
	<div class="container" align="center">
		<div class="col-lg-8" align="right">
		<strong><%=memberDto.getUsername()%></strong>님 환영합니다.
		<a href="./main.do?act=logout">로그아웃</a>
		</div>
	  <div class="col-lg-8" align="center">
	  <h2>제품목록</h2>


	 <table border="1" width="500px">
		<caption style="font-size: 50px">상품 리스트</caption>
		<thead>
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>상품가격</th>
				<th>상품설명</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (ProductDto p : list) {
			%>
			<tr>
				<td><%=p.getId()%></td>
				<td><%=p.getName()%></td>
				<td><%=p.getPrice()%>
				</td>
				<td><%=p.getDesc()%></td>
			</tr>
			<%
				}
			%>

		</tbody>
	</table>
	  </div>
	</div>
	</body>
</html>
<%
}
%>