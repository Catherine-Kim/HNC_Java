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
<c:forEach begin="1" end="7" var="cnt" step="5">
	<font size="${cnt}">아이씐나</font><br/>
</c:forEach>
</body>
</html>
</html>
