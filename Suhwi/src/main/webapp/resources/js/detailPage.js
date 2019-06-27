$(document).ready(function(){
	var query = {
			post_code : $("#post_code").val(),
			id : ""
	}
	
	$.ajax({
		url : "/bsh/getDetailPage",
		type : "POST",
		dataType : "json",
		data : query,
		success : function(data){
			console.log(data);
			$("#id").append(data.result[0].id);
			$("#post_title").append(data.result[0].post_title);
			$("#post_content").append(data.result[0].post_content);
			$('#post_date').append(new Date(data.result[0].post_date.time).format("yyyy-MM-dd"));

			query.id = data.result[0].id;
		}
	}); // end of ajax
	
	////////////////////////////////////////////////////////////////////
	
	// 수정하기 클릭
	$("#btn-up").click(function(){
		passwordCheck();	
	});
	
	function passwordCheck(){
		var passCheck = prompt("비밀번호 입력", "");
		var pw = {
				pass : passCheck
		}
		$.ajax({
			url : "/bsh/passCheck",
			type : "POST",
			dataType : "json",
			data : pw,
			success : function(data) {
				if(data.result == "success"){
					$(location).attr("href", "/bsh/postWriteMain?post_code=" + query.post_code);
				}else{
					alert("비밀번호가 일치하지 않습니다.")
				}
			}, error : function(data) {
				console.log(data);
				alert("비밀번호가 틀립니다.");
			}
		});
	}
	
	////////////////////////////////////////////////////////////////////
	
	// 삭제하기 클릭
	$("#btn-del").click(function(){
		DelpasswordCheck();
	}); // end of ajax
	
	function DelpasswordCheck(){
		var passCheck = prompt("비밀번호 입력", "");
		var pw = {
				pass : passCheck,
				post_code : $("#post_code").val()
		}
		$.ajax({
			url : "/bsh/DelpassCheck",
			dataType : "json",
			type : "POST",
			data : pw,
			success : function(data){
				if(data.result == "fail"){
					alert("비밀번호가 틀립니다.")
				}else{
					alert("성공");
					$(location).attr("href", "/bsh/boardMain");
				}
			}, error : function(data){
				consol.log(data);
			}
		});
	}
	
	// 댓글 출력
	$.ajax({
		url : "/bsh/postReply",
		type : "POST",
		dataType : "json",
		data : query,
		success : function(data){
			var replyDiv = $(".replyDiv");
			var list = "";
			
			for(var i = 0; i < data.result.length; i++){
				list += '<div class="reply_cont">' +
							"작성자: " +
							'<span id="id">' + data.result[i].id + "</span>" +
							" | 댓글: " +
							'<span id="reply_content">' + data.result[i].reply_content + "</span>" +
							" | 작성 날짜: " +
							'<span id="reply_date">' + new Date(data.result[i].reply_date.time).format("yyyy-MM-dd") + "</span>" +
						'</div>';
			}
			replyDiv.append(list);
		}, error : function(data){
			console.log(data);
		}
	});
	
	
	////////////////////////////////////////////////////////////////////
	
	
});

/*Date의 format을 변경해주는 메소드*/
Date.prototype.format = function(f) {
    if (!this.valueOf()) return " ";
 
    var weekName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
    var d = this;
     
    return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function($1) {
        switch ($1) {
            case "yyyy": return d.getFullYear();
            case "yy": return (d.getFullYear() % 1000).zf(2);
            case "MM": return (d.getMonth() + 1).zf(2);
            case "dd": return d.getDate().zf(2);
            case "E": return weekName[d.getDay()];
            case "HH": return d.getHours().zf(2);
            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2);
            case "mm": return d.getMinutes().zf(2);
            case "ss": return d.getSeconds().zf(2);
            case "a/p": return d.getHours() < 12 ? "오전" : "오후";
            default: return $1;
        }
    });
};

String.prototype.string = function(len){var s = '', i = 0; while (i++ < len) { s += this; } return s;};
String.prototype.zf = function(len){return "0".string(len - this.length) + this;};
Number.prototype.zf = function(len){return this.toString().zf(len);};
/*Date format 변경 메소드 end*/