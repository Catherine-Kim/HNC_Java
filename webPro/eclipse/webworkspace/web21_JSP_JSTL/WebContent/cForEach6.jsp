<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[ ] arr = {"삼계탕","클럽 샌드위치","홍짜장","짬봉밥","미정국수"};
	request.setAttribute("MENU", arr);
	
	HashMap<String, String> mapData = new HashMap<String, String>();
	mapData.put("name", "Woojeong");
	mapData.put("age", "19");
	request.setAttribute("INFO", mapData);
%>
	<jsp:forward page="cForEach6_result.jsp" />
</body>
</html>



















