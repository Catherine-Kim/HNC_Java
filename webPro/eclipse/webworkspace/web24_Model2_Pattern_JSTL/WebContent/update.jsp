<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">MEMBER UPDATE FORM</h2>
<c:choose>
	<c:when test="${mvo != null}">
		<form action="UpdateServlet" method="POST">
			ID : <input type="text" name="id" value="${mvo.id}"
				readonly="readonly"> NAME : <input type="text" name="name"
				value="${mvo.name}"> PASSWORD : <input type="password"
				name="password" value="${mvo.password}"> ADDRESS : <input
				type="text" name="address" value="${mvo.address}"> <input
				type="submit" value="Update Member Info">
		</form>
	</c:when>
	<c:otherwise>
		<!-- 로그인 페이지로 -->
		<script type="text/javascript">
			alert("로그인 하고 오시지");
			location.herf = "login.jsp";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>
