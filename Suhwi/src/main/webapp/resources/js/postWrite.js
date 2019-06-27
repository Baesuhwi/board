$(document).ready(function(){
	var query = {
			post_code : $("#post_code").val(),
			id : ""
	}
	
	if(query.post_code != ""){
		// 수정하기로 글 등록
		$.ajax({
			url : "/bsh/getDetailPage",
			type : "POST",
			dataType : "json",
			data : query,
			success : function(data){
				$("#post_title").val(data.result[0].post_title);
				$("#post_content").append(data.result[0].post_content);
				
				query.id = data.result[0].id;
			}, error : function(data){
				console.log(data);
			}
		}); // end of ajax
		

		// 업데이트
		$("#btn-Reg").click(function(){
			query.board_code = $("#board_code").val(),
			query.post_title = $("#post_title").val(),
			query.post_content = $("#post_content").val()
			
			$.ajax({
				url : "/bsh/postUpdate",
				type : "POST",
				dataType : "json",
				data : query,
				success : function(data){
					$(location).attr("href", "/bsh/boardMain");
				}, error : function(data){
					console.log(data);
				}
			});
		});
		
	}else{
		// 글 등록하기
		$("#btn-Reg").click(function(){
			var query = {
					board_code : $("#board_code").val(),
					post_title :  $("#post_title").val(),
					post_content : $("#post_content").val()
			};
			
			$.ajax({
				url : "/bsh/postInsert",
				type : "POST",
				dataType : "json",
				data : query,
				success : function(data){
					$(location).attr("href", "/bsh/boardMain");
				}, error : function(data){
					console.log(data);
				}
			}); // end of ajax
		});
	}
	
	// 취소 버튼 클릭
	$('#btn-Can').click(function() {
		$(location).attr('href', '/bsh/boardMain');
	})
	
});