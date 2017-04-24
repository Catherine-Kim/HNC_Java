<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Include JSP File using Directive Element</h2><p>
<h1>Today's Menu</h1>
<ul>
	<li>Hamburger</li>
	<li>Taco</li>
	<li>Risotto</li>
</ul>
<p>
<p>
<!-- 오늘의 날짜를 출력하는 JSP file을 추가해서 include -->
<%@ include file="directive1_include.jsp" %>
</body>
</html>
