<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${mvo == null}">
			<h2 align="center">LOGIN</h2><p>
			<form action="login.do" method="post">
				ID : <input type="text" name="id"><p>
				PASSWORD : <input type="password" name="password"><p>
				<input type="submit" value="로그인">
			</form>
		</c:when>
		<c:otherwise>
			<a href="${initParam.root}board/write.jsp">글쓰기 ㄱ</a><p>
			<a href="showList.do">글 목록보기 ㄱ</a><p>
			<a href="logout.do">로그아웃</a>
		</c:otherwise>
	</c:choose>
</body>
</html>