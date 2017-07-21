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
	<h2 align="center">게시글</h2><p>
	<table border="2">
		<tr>
			<td>글 번호</td>
			<td>${bvo.no}</td>
			<td>글 제목</td>
			<td colspan="3">${bvo.title}</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${bvo.count}</td>
			<td>작성자</td>
			<td>${bvo.memberVO.name}</td>
			<td>작성일</td>
			<td>${bvo.writeDate}</td>
		</tr>
		<tr>
			<td colspan="6">${bvo.content}</td>
		</tr>
	</table>
	<br/>
</body>
</html>