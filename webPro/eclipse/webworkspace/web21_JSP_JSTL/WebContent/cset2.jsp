<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- num1이라는 변수를 선언하고 값 할당하기 -->
<c:set var="num1" value="77"></c:set>
<!-- number1, number2라는 변수 선언하고 각각의 값을 7,9로 할당하기 -->
<c:set var="number1" value="7"></c:set>
<c:set var="number2" value="9"></c:set>
<!-- multiple이란 변수에 number1, number2를 곱한 값을 할당하기 -->
<c:set var="multiple" value="${number1 * number2}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>${number1}과 ${number2}의 곱은 ${multiple}입니다.</b>
</body>
</html>
