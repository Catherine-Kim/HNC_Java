<%@page import="vo.MemberVO"%>
<%@page import="org.eclipse.jdt.internal.compiler.ast.MemberValuePair"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>choose, when, otherwise의 사용법을 익히자.</title>
</head>
<body>
<%
	MemberVO vo = new MemberVO("jstl","1234","제임스","뉴욕");
	request.setAttribute("vo", vo);
%>
1. EL TEST....<br>
<ul>
	<li>NAME :: ${vo.name}</li>
	<li>ADDR :: ${requestScope.vo.address}</li>
</ul><P><HR>
2. JSTL TEST.....choose, when, otherwise<p>
<c:set var="name" value="${requestScope.vo.name }"/>
<c:set var="addr" value="${requestScope.vo.address }"/>
<c:choose>
	<c:when test="${addr='뉴욕' }">
		${name }님은 뉴욕에 살고 있구나
	</c:when>
	<c:otherwise>
		${name }님은 뉴욕에 안 살고 있구나
	</c:otherwise>
</c:choose>
</body>
</html>


















