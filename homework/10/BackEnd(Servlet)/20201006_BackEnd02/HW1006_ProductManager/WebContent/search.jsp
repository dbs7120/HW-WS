<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#searchBtn").click(function() {
			if ($("#product_id").val() == "") {
				alert("제품번호 입력!!!");
				return;
			}
			$("#productform").attr("action", "${root}/main.do").submit();

		});
	});
</script>
<title>SSAFY 전자</title>
</head>
<body>
	<div style="text-align: right; padding-right: 450px">
		<a href="${root}">메인화면으로</a>
	</div>
	<div class="container" align="center">
		<div class="col-lg-6" align="center">
			<form id="productform" method="post" action="">
				<input type="hidden" name="act" id="act" value="search">
				<div class="form-group" align="left">
					<label for="">제품번호</label> <input type="text" class="form-control" id="product_id" name="product_id" placeholder="">
				</div>

				<div class="form-group" align="center">
					<button type="button" class="btn btn-primary" id="searchBtn">제품검색</button>
					<button type="reset" class="btn btn-warning">초기화</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>