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
		��й�ȣ : <input type="password" name="password" placeholder="${user.password}">
		<br/>
		�̸� : <input type="text" name="name" placeholder="${user.userName}" > 
		<br/>
		���� : <input type="text" name="age" placeholder="${user.age}" >
		<br/>
		���� ��¥ : <input type="text" name="age" placeholder="${user.regDate}" readonly="readonly">
		<input type="submit" value="Update!">  
	</form>
	
	<a href="index.html">Ȩ����</a>
</body>
</html>