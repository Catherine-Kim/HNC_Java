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
	<b>Upload File(${uploadFile}) Success</b><p>
	<hr>
	<ul>
		<li>파일 다운로드 :: <a href="upload.do?command=fileDown&&filename=${uploadFile}">${uploadFile}</a></li> 
	</ul>
</body>
</html>