<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/postWrite.js"></script>
</head>
<body>
	<h1>postWriteMain</h1>
	<!-- 수정하기로 들어왔을 때 -->
	<input id="post_code" type="hidden" value="${param.post_code }" />
	
	<div class="WriterDiv">
		작성자: ${sessionScope.id } <br/>
	</div>
	
	<div class="categoryDiv">
		<select id="board_code">
			<option value="1">자유게시판</option>
			<option value="2">Q&A게시판</option>
		</select>
	</div>
	
	<div class="titleDiv">
		제목: <input id="post_title" type="text" />
	</div>
	
	<div class="contentDiv">
		내용: <textarea id="post_content"></textarea>
	</div>
	
	<div class="Btn-Div">
		<button id="btn-Reg">등록하기</button>
		<button id="btn-Can">취소하기</button>
	</div>
</body>
</html>