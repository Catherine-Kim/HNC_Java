<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Multi File Upload Test</title>
</head>
<body>
	<h2 align="center">Multi File Upload Test</h2><p>
	<form action="multifile.do" method="post" enctype="multipart/form-data">
		User Name : <input type="text" name="userName"><p>
		<input type="file" name="file[0]"><p>
		<input type="file" name="file[1]"><p>
		<input type="file" name="file[2]"><p>
		<input type="submit" value="transferTo">
	</form>
</body>
</html>