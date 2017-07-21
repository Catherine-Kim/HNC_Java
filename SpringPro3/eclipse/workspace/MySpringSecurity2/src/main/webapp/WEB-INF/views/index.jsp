<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>               
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.js"></script>
	<meta charset="UTF-8">
	<style>
	
	</style>
	<script type="text/javascript">	
		$(function(){
		
		});
	</script>
	<title>Insert title here</title>
</head>
<body>
	<h1>Spring Security 요청 2.</h1>
	<h2>
		<!-- Spring 보안을 이용해서 인증이 된 경우 -->
		<security:authorize access="isAuthenticated()"> 
			<security:authentication property="name"/> 환영합니다아~ <!-- 권한 이름 출력-->
		</security:authorize>
	</h2>
	<h4>
		<a href="${pageContext.request.contextPath}/home/main">home/main</a>
		<a href="${pageContext.request.contextPath}/member/main">member/main</a>
		<a href="${pageContext.request.contextPath}/manager/main">manager/main</a>
		<a href="${pageContext.request.contextPath}/admin/main">admin/main</a>
	</h4>
</body>
</html>