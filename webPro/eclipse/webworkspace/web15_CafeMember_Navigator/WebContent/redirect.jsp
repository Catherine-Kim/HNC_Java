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
	String url ="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8";
	String word = request.getParameter("word");
	
	url += "&query=" + word;
	
	response.sendRedirect(url);
%>
</body>
</html>
