<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">비밀번호 입력ㄱ</h2><p>
	<form action="${initParam.root}deleteBoard.do" method="POST">
		PASSWORD : <input type="password" name="password"><p>
		<input type="submit" value="삭제 ㄱ">
	</form>
</body>
</html>