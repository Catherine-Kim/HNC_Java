<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr>
		<th>상품 ID</th>
		<th>상품명</th>
		<th>가격</th>
	</tr>
	<c:forEach items="${itemList}" var="item">
		<tr>
			<td>${item.itemId}</td>
			<td>${item.itemName}</td>
			<td>${item.price}원</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>