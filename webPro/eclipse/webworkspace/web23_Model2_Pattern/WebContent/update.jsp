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
<%
	MemberVO vo = (MemberVO)session.getAttribute("mvo");
	if(vo != null){
%>
<form action="UpdateServlet" method="POST">
	ID : <input type="text" name="id" value="<%= vo.getId() %>" readonly="readonly">
	NAME : <input type="text" name="name" value="<%= vo.getName() %>">
	PASSWORD : <input type="password" name="password" value="<%= vo.getPassword() %>">
	ADDRESS : <input type="text" name="address" value="<%= vo.getAddress() %>">
	<input type="submit" value="Update Member Info">
</form>

<% }else{ %>
<!-- 로그인 페이지로 -->
<script type="text/javascript">
	alert("로그인 하고 오시지");
	location.herf = "login.jsp";
</script>	
<% } %>
</body>
</html>
