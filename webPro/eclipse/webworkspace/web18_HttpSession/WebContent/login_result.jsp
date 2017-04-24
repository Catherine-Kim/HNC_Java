<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO vo = (MemberVO)session.getAttribute("vo");
	if(vo == null){	// 만약 로그인 되어 있지 않다면..
		out.println("다시 로그인부터 하세오...");
		out.println("<a href=login.html>Login page gogo</a>");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">LOGIN INFORMATION</h2><p>
User ID: <%= vo.getId() %> <br/>
User NAME: <%= vo.getName() %> <br/>
User ADDRESS: <%= vo.getAddress() %> <br/>
JSESSION ID : <%= session.getId() %> <br/>
<hr>
<a href="logout.jsp">Log out page</a>
<a href="login.html">Log in page</a>
</body>
</html>
