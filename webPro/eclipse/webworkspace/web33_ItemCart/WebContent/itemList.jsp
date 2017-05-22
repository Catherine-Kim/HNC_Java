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
<h2 align="center">Fruit Total List2</h2>
<table align="center">
	<tr>
		<c:forEach items="${list}" var="fruit" varStatus="i">			
				<td>
					<a href="itemView.do?itemnumber=${fruit.itemnumber}">
					<img src="${fruit.url}" width="100" height="100">
					</a><br />
					상품명 : ${fruit.name}<br /> 가격 : ${fruit.price}<br />
				</td>
			
			<c:if test="${i.count%5 == 0}">
				<tr></tr>
			</c:if>
		</c:forEach>
	</tr>
</table>
</body>
</html>
