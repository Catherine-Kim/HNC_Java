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
<h1 align="center">Fruit Total List5(Using Cookie). </h1>
<table style="margin: auto">
	<tr>
		<c:forEach items="${list}" var="item" varStatus="i">
			<td>
				<a href="itemView.do?itemnumber=${item.itemnumber}">
				<img src="${item.url}" height="150" width="150" border="2">
				</a><br>
				상품명 : ${item.name}<br>
				가  격 : ${item.price}
			</td>
			<c:if test="${i.count%5==0}">
				<tr></tr>
			</c:if>
		</c:forEach>
	</tr>
</table><br><br>


<h2 align="center"><font color="orange">오늘 본 상품</font></h2>
<table align="center" bgcolor="Lightgray">
	<tr>
		<c:forEach items="${fruits}" var="fruit">
			<td>
				<img src="${fruit}" width="100" height="100">
			</td>
		</c:forEach>
	</tr>
</table>



</body>
</html>












