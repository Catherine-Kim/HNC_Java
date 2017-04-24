<%@page import="model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body > table{
		margin: auto;
		width: 50%;
		border: 2 solid blue;
	}
	table > td{
		text-align: center;
	}
	table > tr:HOVER{
		background: #c8cace;
	}
</style>
</head>
<body>
<h2 align="center">전체 멤버 명단</h2>
<br/>
<%
	ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
%>
<table border="2">
	<tr>
		<td>ID</td>
		<td>NAME</td>
		<td>ADDRESS</td>
	</tr>
	<% for(int i = 0; i < list.size(); i++){ %>
		<tr>
			<td><%= list.get(i).getId() %></td>
			<td><%= list.get(i).getName() %></td>
			<td><%= list.get(i).getAddress() %></td>
		</tr>		
	<% } %>
</table>
</body>
</html>