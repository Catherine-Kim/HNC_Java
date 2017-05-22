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
		window.open("DispatcherServlet?command=idcheck&&id="+str, "","width=300, height=200, top=100, left=400");
	}
	function doubleCheck() {
		//중복확인 버튼을 누르지 않고 회원가입이 될수 없도록 체킹
		var f = document.registerFrm;
		if(f.flag.value=='false'){//중복확인 버튼 안눌렀다
			alert("아이디 중복확인을 해주세요!!");
			return false;
		}
	}
</script>
</head>
<body>
<h2 align="center">MEMBER REGISTER</h2><p>
<form action="front.do" method="post" name="registerFrm" 
		onsubmit="return doubleCheck()">
	<input type="hidden" name="command" value="register">
	아이디 : <input type="text" name="id" required="required">
	<input type="button" value="중복확인" onclick="return idCheck()"><br>
	패스워드 : <input type="password" name="password" required="required"><BR>
	이 름 : <input type="text" name="name" required="required"><BR>
	주 소 : <input type="text" name="address" required="required"><BR>
	<input type="hidden" name="flag" value="false">
	<input type="submit" value="회원가입">
</form>
</body>
</html>

















