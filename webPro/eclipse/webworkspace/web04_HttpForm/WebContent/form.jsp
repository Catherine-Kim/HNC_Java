<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String kisu = request.getParameter("kisu");
	%>
	
	<h2>당신의 정보입니다.</h2>
	<h3>당신의 이름 : <%= name %></h3><br/><br/>
	<h3>당신의 주소 : <%= addr %></h3><br/><br/>
	<h3>당신의 기수 : <%= kisu %></h3><br/><br/>
</body>
</html>
