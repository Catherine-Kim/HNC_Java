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
<h2 align="center">최댓값 구하기</h2><p>
최대값 ::
<c:if test="${param.num1 > param.num2}">
	${param.num1}
</c:if>
<c:if test="${param.num1 < param.num2}">
	${param.num2}
</c:if>
</body>
</html>
