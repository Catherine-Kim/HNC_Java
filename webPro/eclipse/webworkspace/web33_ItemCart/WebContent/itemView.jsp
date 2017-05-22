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
<div>
	<p> 조회수 : ${item.count} </p>
	<a href="itemCartAdd.do?item_id=${item.itemnumber}">장바구니 담기</a>
</div>
<div>
	<img src="${item.url}">
	<div>
		종류 : ${item.name} <p>
		가격 : ${item.price} <p>
		설명 : ${item.description} <p>
	</div>
</div>
</body>
</html>
