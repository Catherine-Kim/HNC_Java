<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="member.do">
ID : <input type="text" name="id">
<input type="hidden" name="command" value="findMemberById">
<input type="submit" value="id로 회원검색(동기방식)">
</form><br><br><hr>

<h3>============JQuery+Ajax+SpringMVC+Ibatis===================</h3><p><br>
<a href="member.do?command=getAddressList">주소로 회원 검색하기(비동기통신)</a>
</body>
</html>















