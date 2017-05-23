<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h2 align="center">Detail Page</h2><p>
<h4>상품 ID : ${item.itemId}</h4><p>
<h4>상품 이름 : ${item.itemName}</h4><p>
<h4>상품 가격 : ${item.price}</h4><p>
<h4>상품 설명 : ${item.description}</h4><p>
<img src="img/${item.pictureUrl}">
</body>
</html>