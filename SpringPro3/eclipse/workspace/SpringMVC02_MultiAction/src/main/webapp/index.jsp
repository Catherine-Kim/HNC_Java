<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">MultiActionController Test2</h2><p>
	<form action="test.do">
		<input type="hidden" name="mode" value="update">
		UPDATE :: <input type="submit" value="Update 요청">
	</form><p>
	<form action="test.do">
		<input type="hidden" name="mode" value="delete">
		DELETE :: <input type="submit" value="Delete 요청">
	</form><p>
	<hr><p>
	<h2 align="center">AbstractCommandController</h2><p>
	<form action="car.do" method="post">
		Model : <input type="text" name="model"><p>
		Price : <input type="text" name="price"><p>
		<input type="submit" value="상품등록">
	</form><p>
	<hr><p>
	<form action="test.do" method="post">
		<input type="hidden" name="mode" value="registerCar">
		Model : <input type="text" name="model"><p>
		Price : <input type="text" name="price"><p>
		<input type="submit" value="상품등록">
	</form>
</body>
</html>