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
	<h2 align="center">글 목록</h2><p>
	<table border="2">
		<tr>
			<td>글 번호</td>
			<td>글 제목</td>
			<td>작성자</td>
			<td>조회수</td>
			<td>작성일시</td>
		</tr>
		<c:forEach items="${list}" var="board">
			<tr>
				<td>${board.no}</td>
				<td><a href="${initParam.root}showBoard.do?no=${board.no}">${board.title}</a></td>
				<td>${board.memberVO.name}</td>
				<td>${board.count}</td>
				<td>${board.writeDate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>