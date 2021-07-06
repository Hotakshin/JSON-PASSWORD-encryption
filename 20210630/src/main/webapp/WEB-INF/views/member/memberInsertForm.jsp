<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div align="center">
	<!-- <input type="text" name="email" id="email"> -->
		<form:form action="memberRegister" modelAttribute="member" enctype="multipart/form-data" >
			<label>email</label>
			<form:input path="email"/><br/>
			
			<label>Password</label>
			<form:password path="password"/><br/>
			
			<label>PasswordCheck</label>
			<input type="password" id="pwdCheck"><br/>
			
			<label>이름</label>
			<form:input path="name"/><br/>
			
			<label>사 진</label>
			<input type="file" id="file" name="file"><br/>
			
			<label>회원구분</label>
			<form:select path="gubun" items="${loginType }"/><br/>
			
			<input type="submit" value="회원가입">
		</form:form>
	</div>
</body>
</html>