<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<c:if test="${!empty id }">
			<p><spring:message code="register.login" arguments="${member.name }"/></p>
			${member.email } : ${member.name }<br/>
			<button onclick="location.href='home.do'">홈으로</button>
		</c:if>
		<c:if test="${empty id }">
			<spring:message code="register.loginFail" /><br />
			<button onclick="location.href='memberLoginForm'">홈으로</button>
		</c:if>
		
	</div>
</body>
</html>