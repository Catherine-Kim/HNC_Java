<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center"><%= request.getParameter("name") %>님, Cafe에 가입하신걸 환영~</h2>
<br/>
<br/>
<a href="ShowAll">전체 회원 명단 보기</a>
<a href="index.html">Home으로</a>
</body>
</html>