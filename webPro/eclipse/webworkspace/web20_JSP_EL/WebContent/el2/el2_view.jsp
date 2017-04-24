<%@page import="java.util.ArrayList"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">1. EL로 정보 출력하기</h2><p>
<h3>1. JSP Element로 출력하기</h3><p>
<% MemberVO vo = (MemberVO)session.getAttribute("vo"); %>
<h4>MemberVO의 정보 출력하기 ::</h4><p>
<%= vo.getName() %><p><br/>

<h3>2. JSP Element로 출력하기</h3><p>
<h4>MemberVO의 정보 출력하기 ::</h4><p>
<h4>${sessionScope.vo.name}</h4><p>

<br/><hr><br/>

<h3>1. ArrayList의 내용을 JSP Element로 출력하기</h3><p>
<% ArrayList list = (ArrayList)session.getAttribute("list"); %>
<h4>list에 담긴 내용들 : <%= list %></h4><p>
<h4>박보영만 출력 : <%= list.get(1) %></h4><p><br/>

<h3>2. ArrayList의 내용을 EL로 출력하기</h3><p>
<h4>list에 담긴 내용들 : ${list}</h4><p>
<h4>박보영만 출력 : ${list[0]}</h4><p>

<br/><hr><br/>

<h3>1. map에 담긴 내용을 JSP로 출력하기</h3><p>
<h4><%= session.getAttribute("map") %></h4><p><br/>

<h3>2. map에 담긴 내용을 JSP로 출력하</h3><p>
<h4>${map}</h4><p>
</body>
</html>