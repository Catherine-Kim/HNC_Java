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
	<h2 align="center">File Upload Test</h2><p>
	
	<!-- 이 부분을 왜 달았는지 쫌따 알게 될거임 -->
	<a href="upload.do?command=FileUpload">파일 업로드 Controller로 ㄱㄱ</a><p>
	<hr>
	<form action="upload.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="command" value="FileUpload">
		사용자명 : <input type="text" name="userName"><p>
		<input type="file" name="uploadFile"><p>
		<input type="submit" value="FILE UPLOAD!">
	</form>
</body>
</html>