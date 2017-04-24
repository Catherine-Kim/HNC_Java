<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.num1 == '00'}">
		아침 드셨어요?
	</c:when>
	<c:when test="${param.num1 == '11'}">
		점심 드셨어요?
	</c:when>
	<c:when test="${param.num1 == '22'}">
		저녁 드셨어요?
	</c:when>
	<c:otherwise>
		술먹장
	</c:otherwise>
</c:choose>
</body>
</html>
