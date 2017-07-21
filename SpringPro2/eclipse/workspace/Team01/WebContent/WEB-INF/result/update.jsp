<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">Update User</h2><p>
	<br/>
	<form action="update.do?id=${user.userId}" name="regForm" method="POST">
		ID : <input type="text" name="id" placeholder="${user.userId}" readonly="readonly">
		<br/>
		비밀번호 : <input type="password" name="password" placeholder="${user.password}">
		<br/>
		이름 : <input type="text" name="name" placeholder="${user.userName}" > 
		<br/>
		나이 : <input type="text" name="age" placeholder="${user.age}" >
		<br/>
		가입 날짜 : <input type="text" name="age" placeholder="${user.regDate}" readonly="readonly">
		<input type="submit" value="Update!">  
	</form>
	
	<a href="index.html">홈으로</a>
</body>
</html>