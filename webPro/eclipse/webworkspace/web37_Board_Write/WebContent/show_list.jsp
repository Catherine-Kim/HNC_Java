<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">게시글 목록</h2>
<br/>
<br/>
<table border="2" align="center">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>글쓴이</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
	<c:forEach items="${list}" var="posting">
		<tr>
			<td>${posting.no}</td>
			<td><a href="DispatcherServlet?command=showContent&&no=${posting.no}">
			${posting.title}</a></td>                                                         
			<td>${posting.writer}</td>
			<td>${posting.timePosted}</td>
			<td>${posting.hits}</td>
		</tr>
	</c:forEach>
</table>
<br/>
<br/>
<div align="center">
	<a href="write.jsp"><img src="img/write_btn.jpg"></a>
</div>
</body>
</html>
