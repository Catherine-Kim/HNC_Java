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
<h4>��ǰ ID : ${item.itemId}</h4><p>
<h4>��ǰ �̸� : ${item.itemName}</h4><p>
<h4>��ǰ ���� : ${item.price}</h4><p>
<h4>��ǰ ���� : ${item.description}</h4><p>
<img src="img/${item.pictureUrl}">
</body>
</html>