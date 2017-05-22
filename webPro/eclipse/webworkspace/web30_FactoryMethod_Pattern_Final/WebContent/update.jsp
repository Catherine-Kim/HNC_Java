<%@page import="model.MemberVO"%>
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
<h2 align="center">MEMBER UPDATE FORM...</h2><p>

<c:choose>
	<c:when test="${mvo !=null}">
	<form action="front.do" method="post">
	<input type="hidden" name="command" value="update">
		아이디 : <input type="text" name="id" value="${mvo.id}" readonly="readonly"><br><br>
		패스워드 : <input type="password" name="password" value="${mvo.password}" ><br><br>
		이 름 : <input type="text" name="name" value="${mvo.name}" ><br><br>
		주 소 : <input type="text" name="address" value="${mvo.address}" ><br><br>
		<input type="submit" value="회원정보수정">
	</form>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("회원에 대한 정보가 없어서 수정할수 없습니다.");
			location.href="inxdex.jsp";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>



























