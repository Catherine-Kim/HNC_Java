<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/shopping3-1.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>
<body>
<div align="center" class="body">
<h2>회원 정보 리스트</h2>
<table border="1">
	<tr class="header">
		<th align="center" width="80">아이디</th>
		<th align="center" width="320">이름</th>
		<th align="center" width="100">나이</th>
		<th align="center" width="100">가입일</th>
	</tr>
	<c:forEach items="${userList }" var="list">
		<tr class="record">
			<td align="center">${list.userId }</td>
			<td align="center">${list.userName }</td>
			<td align="center">${list.age }</td>
			<td align="center">${list.regDate }</td>
		</tr>
	</c:forEach>
</table>
</div>

<a href="index.html">홈으로</a>
</body>
</html>