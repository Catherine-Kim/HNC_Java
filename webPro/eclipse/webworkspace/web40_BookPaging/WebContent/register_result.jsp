<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>책 등록에 성공했습니다...</h2><p>
책 번호 :: ${book.bookNo}<p>
책 제목 :: ${book.title}<p>
책 가격 :: ${book.price}<p>
<a href="DispatcherServlet?command=list">페이지별 책 목록보러가기</a>
</body>
</html>

















