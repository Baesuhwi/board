<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/postList.js"></script>
</head>
<body>
	<h1>Board Main</h1>
	
	<table>
		<thead id="thead">
			<tr>			
				<th>post_code</th>
				<th>ID</th>
				<th>post_title</th>
				<th>post_content</th>
				<th>post_date</th>
			</tr>
		</thead>
		<tbody id="tbody"></tbody>
	</table>
	
	<button id="btn-write">글쓰기</button>
</body>
</html>