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
<h2 align="center">Book Register...</h2><p>
<form action="DispatcherServlet" method="post">
<input type="hidden" name="command" value="register">
Book Title :: <input type="text" name="title"><br><br>
Book Price :: <input type="text" name="price"><br><br>
<input type="submit" value="Book Register">
</form>
</body>
</html>


















