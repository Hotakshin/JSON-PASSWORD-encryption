<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><h1>로 그 인</h1></div>
		<c:if test="${!empty id }">
			<h3>${id }님은 이미 로그인 되어있습니다.</h3>
			<button type="button" onclick="location.href='home.do'">홈으로</button>
		</c:if>
		<c:if test="${empty id }">
			<form:form modelAttribute="member" action="memberLogin" method="post">
				<label>이 메 일 : </label>
				<form:input path="email"/><br />
				<label>패 스 워 드</label>
				<form:password path="password"/><br />
				<input type="submit" value="로그인">
			</form:form>
		</c:if>
	</div>
</body>
</html>