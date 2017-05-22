<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function updateAction() {
		//location.href="DispatcherServlet?command=deleteCheckPassword&&no=${param.no}";
		document.upCheckFrm.submit();
	}
</script>
</head>
<body>
	<form action="DispatcherServlet" name="upCheckFrm" method="POST">
		PASSWORD : <input type="password" name="password" required="required">
		<input type="hidden" name="no" value="${param.no}">
		<input type="hidden" name="command" value="updateCheckPassword">
		<br/><br/>
		<input type="button" value="수정" onclick="updateAction()">
		<input type="button" value="창 닫기" onclick="javascript:self.close()">
	</form>
</body>
</html>
