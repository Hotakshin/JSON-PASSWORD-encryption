<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#btn').click(function (){
			$.ajax({
				type : 'POST',
				url : 'ajax/memberList',
				data : 'abcdefgagagaredgarehraeh',
				dataType : 'json',
				success : function(result){
					var table = $("<table border='1' />");
					$.each(result, function(index, value) {
						var tr = $("<tr />").append(
							$("<td width='150' align='center' / >").text(value.email),
							$("<td width='150' align='center' />").text(value.name),
							$("<td width='150' align='center' />").text(value.state)
						);
						table.append(tr);
					})
					$('#List').append(table);
				},
				error : function(err){
					console.log(err);
				}
			})
		})
	})
</script>
</head>
<body>
<div align="center">
	<div>
		<h3><a href="memberInsertForm">회원가입</a></h3>
		<button type="button" id="btn">JSON 회원목록</button>
		<h3><a href="memberLoginForm">로그인</a></h3>
		<h3><a href="api/members">Json Data</a></h3>
	</div>
	
	<div id="List"></div>
</div>
</body>
</html>