<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	MemberVO vo = (MemberVO)session.getAttribute("vo");
	if(vo == null){
%>
		<a href="login.html">로그인 하기</a>
<% }else{
	session.invalidate();
} %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function logoutpopup() {
		alert("Log out!");
	}
</script>
</head>
<body onload="logoutpopup()">
<!-- onload : document가 뜨자마자 실행되어야 하는 일. body 보다 먼저 실행됨 -->
<h2>로그아웃되셨습니다~</h2><br/>
<a href="login.html">다시 홈으로</a>
</body>
</html>
