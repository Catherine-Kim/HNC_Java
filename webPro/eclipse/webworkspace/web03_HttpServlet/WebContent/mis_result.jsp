<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel = "stylesheet" type = "text/css" href = "css/style.css">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<div class = "page-header">
		<p style = "font-size:100px; font-family:Fantasy">Your Information</p>
	</div>
</center>
<%
	String name = (String)request.getAttribute("name");
	String tel = (String)request.getAttribute("tel");
	String address = (String)request.getAttribute("address");
%>
<div class = "container">
	<div class = "row">
		<div class = "col-md-3"></div>
		<div class = "col-md-5"  align="center">
			<div class="panel panel-danger">
				<div class="panel-heading">
					<h3 class="panel-title">Name</h3>
  				</div>
  				<div class="panel-body">
    				 <%= name %>
  				</div>
			</div>
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">Telephone</h3>
  				</div>
  				<div class="panel-body">
    				<%= tel %>
  				</div>
			</div>
			<div class="panel panel-warning">
				<div class="panel-heading">
					<h3 class="panel-title">Address</h3>
  				</div>
  				<div class="panel-body">
    				<%= address %>
  				</div>
			</div>
		</div>
		<div class = "col-md-4"></div>
	</div>
</div>
</body>
</html>