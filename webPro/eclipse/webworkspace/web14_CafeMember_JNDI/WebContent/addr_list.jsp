<%@page import="java.io.PrintWriter"%>
<%@page import="model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% ArrayList<MemberVO> foundPeople = 
			(ArrayList<MemberVO>)(getServletContext().getAttribute("foundPeople")); %>
<table border="2" align="center" width="60%">

<% 	for(int i = 0; i < foundPeople.size(); i++){	%>
	<tr>
		<td> <%= foundPeople.get(i).getId() %> </td>
		<td> <%= foundPeople.get(i).getName() %> </td>
		<td> <%= foundPeople.get(i).getAddress() %> </td>
	</tr>		
<%	} %>

</table>
</body>
</html>
