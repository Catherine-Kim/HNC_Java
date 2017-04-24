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
command : ${param.command}<br/>
id : ${param.id}<br/>
age :  ${param.age}<br/>

1. 전달된 값 :: ${param.command }<p>
<hr>
<c:if test="${param.id=='jstl' && param.age=='66' }">
2. ID : ${param.id }, AGE : ${param.age }<p>
</c:if>
<hr>
3. 
</body>
</html>
