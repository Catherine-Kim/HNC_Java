<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function closeWindow(result) {
		/* result 값에 따라서 현재 창이 아닌 원래 창을 제어해야 한다. */
		var of = window.opener.document.registerFrm; /* 원래 창으로 돌아가는 메소드 */
		
		if(result=='true'){ /* true가 String인 것 주의 */
			of.id.value="";
			of.id.focus();
		}else{
			of.flag.value = true;
			of.password.focus();
		}
		
		/* 창 닫기 */
		self.close();		/* window.self를 생략한 것 */
	}
</script>
</head>
<%
	String id = request.getParameter("id");
	boolean found = (Boolean)request.getAttribute("found");
	String msg = "This ID is not usable";
	if(found==false){
		msg = "This ID is usable";
	}
%>
<body bgcolor="orange">
	<%= id %>, <%=msg %>
	<input type="button" value="confirm" onclick="closeWindow('<%= found %>')">
</body>
</html>
