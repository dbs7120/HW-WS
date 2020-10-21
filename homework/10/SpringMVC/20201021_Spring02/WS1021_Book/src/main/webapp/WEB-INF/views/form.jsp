<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>도서 등록</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<style>
	.container {
		width: 700px;
	}
	.h40 { height: 40px; }
	.h50 { height: 50px; }
	.bottom__content {
		font-family: 굴림체;
		font-size: small;
		color: rgb(0, 0, 128);
	}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>

</head>
<body>
<div class="container mx-auto">
	<h2 class="text-center bg-light mt-5 mb-2 p-2">도서 등록 화면</h2>

	<div class="text-right">
		<span class="text-warning">*</span> 표시가 된 항목은 필수 입력 항목입니다.
	</div>
	<div class="h40 bg-light mt-3 mb-3"></div>

	<!--도서정보입력 FORM 테이블시작//-->
	<form method="post" action="${root}/insert" id="bookForm">
		<input type="hidden" name="isbn">
		<!--도서번호 입력-->
		<div class="row form-group">
			<label for="isbn1" class="col-3 pl-5"><span class="text-warning">*</span> 도서번호</label>
			<div id="isbnDiv" class="col-9">
				<input type="text" name="isbn1" id="isbn1" size="6" maxlength="4">
				<input type="text" name="isbn2" id="isbn2" size="6" maxlength="3">
				<input type="text" name="isbn3" id="isbn3" size="6" maxlength="3">
			</div>
		</div>
		<!--도서제목-->
		<div class="row form-group">
			<label for="title" class="col-3 pl-5"><span class="text-warning">*</span> 도서제목</label>
			<div class="col-9">
				<input type="text" name="title" id="title" size="50">
			</div>
		</div>
		<!--도서종류-->
		<div class="row form-group">
			<label for="catalogue" class="col-3 pl-5"><span class="text-warning">*</span> 도서종류</label>
			<div class="col-9">
				<select name="catalogue" id="catalogue">
					<option value="">해당 항목을 선택하세요</option>
					<option value="PRO">프로그래밍</option>
					<option value="OS">운영체제</option>
					<option value="DB">데이터베이스</option>
					<option value="NET">네트워크</option>
				</select>
			</div>
		</div>
		<!--출판국가-->
		<div class="row form-group">
			<label class="col-3 pl-5"><span>*</span> 출판국가</label>
			<div class="col-9">
				<input type="radio" name="nation" id="nation1" value="국내" checked>국내도서
				<input type="radio" name="nation" id="nation2" value="외국">외국도서
			</div>
		</div>
		<!--출판일-->
		<div class="row form-group">
			<label for="publishDate" class="col-3 pl-5"><span>*</span> 출 판 일</label>
			<div class="col-9">
				<input type="text" name="publishDate" id="publishDate" size='15'>
			</div>
		</div>
		<!--출판사-->
		<div class="row form-group">
			<label for="publisher" class="col-3 pl-5"><span>*</span> 출 판 사</label>
			<div class="col-9">
				<select name='publisher' id="publisher">
					<option value="">해당 항목을 선택하세요</option>
					<option value='영진출판사'>영진출판사</option>
					<option value='한빛미디어'>한빛미디어</option>
					<option value='자앤미디어'>자앤미디어</option>
					<option value='멀티캠퍼스'>멀티캠퍼스</option>
				</select>
			</div>
		</div>
		<!--저자-->
		<div class="row form-group">
			<label for="author" class="col-3 pl-5"><span class="text-warning">*</span> 저 자</label>
			<div class="col-9">
				<input type="text" name="author" id="author" size="10">
			</div>
		</div>
		<!--도서가격-->
		<div class="row form-group">
			<label for="price" class="col-3 pl-5"><span>*</span> 도서가격</label>
			<div class="col-9">
				<input type="text" name="price" id="price" size="10" maxlength="6">
				<select name="currency" id="currency" tabindex="13">
					<option value="원" selected>원</option>
					<option value="달러">달러</option>
				</select>
			</div>
		</div>
		<!--요약내용-->
		<div class="row form-group">
			<label for="description" class="col-3 pl-5"><span>*</span> 요약내용</label>
			<div class="col-9">
				<textarea name="description" id="description" rows="3" cols="50"></textarea>
			</div>
		</div>

		<div class="row bg-light mb-3 h50 align-items-center justify-content-center">
			<div class="col-4 text-center">
				<a href="#1" id="btnOk">
					<img src="${root }/resources/images/ok.gif" width="64" height="29">
				</a>
				<a href="#1" id="btnReset">
					<img src="${root }/resources/images/cancel.gif" width="64" height="29">
				</a>
			</div>
		</div>
	</form>
	<!--정보입력 테이블끝//-->

	<div class="text-center bottom__content">
		사전 도움말 - 이용약관 - 개인정보취급방침 - 책임의 한계와 법적고지 - 고객센터<BR>
		Copyright ⓒ 2020. SCSA. All Rights Reserved.
	</div>
</div>
<script>
	$("#btnOk").click(function() {
		if (formChk(['isbn1', 'isbn2', 'isbn3', 'title', 'catalogue', 'author']) == false) {
			return false;
		}
		$('input[name="isbn"]').val($('#isbn1').val() + '-' + $('#isbn2').val() + '-' + $('#isbn3').val());
		$('#bookForm').submit();
	});

	$('#btnReset').click(function() {
		$('#bookForm')[0].reset();
	});

	// 폼내부 값이 채워졌는지 확인
	function formChk(elements) {
		let result = true;
		$.each(elements, function(index, element) {
			let $ele = $(`#\${element}`);
			let msg = '필수 입력항목입니다. 내용을 입력하세요';
			if ($ele.prop('tagName') == 'SELECT') {
				msg = '항목을 선택하세요';
			}
			if ($ele.val().trim() == '') {
				alert(msg);
				$ele.focus();
				result = false;
				return result;
			}
		});
		return result;
	}

</script>
</body>
</html>