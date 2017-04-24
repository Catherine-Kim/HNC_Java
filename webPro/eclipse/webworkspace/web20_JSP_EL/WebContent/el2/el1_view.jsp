<%@page import="vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">상품 정보를 출력합니다아아아아 :: EL로 출력</h2><p>
상품명 : 	${requestScope.product.name} <p>	
상품 가격 : 	${requestScope.product.price} <p>
상품의 모든 정보 : ${requestScope.product}	 <p>
<hr>
<h2 align="center">상품 정보를 출력합니다아아아아 :: JSP Element로 출력</h2><p>
상품명 : 	<%= ((Product)request.getAttribute("product")).getName() %> <p>	
상품 가격 : 	<%= ((Product)request.getAttribute("product")).getPrice()%> <p>
상품의 모든 정보 : <%= (Product)request.getAttribute("product") %>	 <p>
</body>
</html>