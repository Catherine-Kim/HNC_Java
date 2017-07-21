<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">회원가입</h2>
	<form action="add.do" method="post">
	ID : <input type="text" name="id" required="required"><p>
	PASSWORD : <input type="password" name="password" required="required"><p>
	이름 : <input type="text" name="name" required="required"><p>
	나이 : <input type="text" name="age" required="required"><p>
	<input type="submit" value="register" required="required">
	</form>
</body>
</html>