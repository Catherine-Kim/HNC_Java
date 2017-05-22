<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function idCheck() {
		var str = document.registerFrm.id.value;
		window.open("front.do?command=idcheck&&id="+str, "ID Usability Check", 
										"width=300, height=200, top=100, left=400");
	}
	
	function doubleCheck() {
		// 중복확인을 누르지 않고 Register 버튼을 누르면 넘어가지 못하게 해야함
		var f = document.registerFrm;
		if(f.flag.value == 'false'){
			alert("ID 중복 확인하고 오시지");
			return false;
		}
	}
</script>
</head>
<body>
<h2 align="center">MEMBER REGISTER FORM</h2>
<form action="front.do" method="POST" name="registerFrm" 
	  onsubmit="return doubleCheck()">
	<input type="hidden" name="command" value="register">
	ID : <input type="text" name="id" required="required">
	<input type="button" value="Check ID" onclick="return idCheck()"><br/>
	PASSWORD : <input type="password" name="password" required="required"><br/>
	NAME : <input type="text" name="name" required="required"><br/>
	ADDRESS : <input type="text" name="address" required="required"><br/>
	<input type="hidden" name="flag" value="false">
	<input type="submit" value="Register">
</form>
</body>
</html>
