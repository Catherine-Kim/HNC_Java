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
<table border="2">
	<tr>
		<td>번호</td>
		<td>이미지</td>
		<td>이름</td>
		<td>가격</td>
		<td>수량</td>
	</tr>
	
	<c:forEach items="${cartlist}" var="cart" varStatus="i">
		<tr>
			<td>${i.count}</td>
			<td><img src="${cart.image}" width="100" height="100"></td>
			<td>${cart.name}</td>
			<td>${cart.price}</td>
			<td>${cart.quantity}</td>
		</tr>
	</c:forEach>
	
	<tr>
		<td>총 금액 : ${totalPrice}</td>
	</tr>
</table>
<a href="index.jsp">홈으로 ㄱㄱ</a>
</body>
</html>
