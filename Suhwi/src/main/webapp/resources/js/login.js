$(document).ready(function(){
	$("#btn-login").click(function(){
		
		var query = {
				id : $("#id").val(),
				password : $("#password").val()
		}
		
		$.ajax({
			url : "/login",
			type : "POST",
			dataType : "json",
			data : query,
			success : function(data){
				if(data.result == 0){
					$(location).attr("href", "/bsh/boardMain");
				}else if(data.result == 1){
					alert("아이디 불일치");
				}else{
					alert("비밀번호 불일치");
				}
			}, error : function(data){
				console.log(data);
			}
		}); // end of ajax

	});
});