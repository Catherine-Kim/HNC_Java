<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	${param.userName} 님의 정보임<p>
	<ul>
		<li>아이디 : ${param.userId}</li>
		<li>주소 : ${param.userAddr}</li>
	</ul>
</body>
</html>