<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">HTML form에 입력된 값을 받아옵니당</h2><p>
<h3>1. 기존의 JSP Element를 사용 :: Scriptlet, Expression Element</h3><p>
<%
	String id = request.getParameter("id");
	String[] pets = request.getParameterValues("pet");
%>
<h4>ID : <%= id %></h4><p>
<h4>Pets : 
	<% for(String p : pets){
		out.println(p + "<p>");
	} %>
</h4>
<hr>
<h3>2. EL 사용 :: param, paramValues</h3><p>
<h4>ID : ${param.id}</h4>
<h4>Pets : </h4><p>
${paramValues.pet[0]}
${paramValues.pet[1]}
${paramValues.pet[2]}
${paramValues.pet[3]}
${paramValues.pet[4]}
</body>
</html>
