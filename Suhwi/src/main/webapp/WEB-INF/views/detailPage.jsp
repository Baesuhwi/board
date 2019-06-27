<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/detailPage.js"></script>
</head>
<body>
	<input id="post_code" type="hidden" value="${param.post_code }" />

	<h3>작성자</h3>
	<span id="id"></span>
	<h3>제목</h3>
	<span id="post_title"></span>
	<h3>내용</h3>
	<span id="post_content"></span>
	<h3>작성일</h3>
	<span id="post_date"></span><br>
	
	<br><br>
	<button id="btn-del">삭제</button>
	<button id="btn-up">수정</button>
	
	<%-- 댓글 --%>
	<h1>===↓↓댓글↓↓===</h1>
	<div class="replyDiv"></div>
</body>
</html>