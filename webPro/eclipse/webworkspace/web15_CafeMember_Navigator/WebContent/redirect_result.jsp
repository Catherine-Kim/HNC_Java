<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center"><b>forward로 넘어온 페이지데쓰</b></h2><p>
<h3>너가 선택한 상품은 <strong><%= request.getParameter("choice")%></strong>입니당</h3>
</body>
</html>
