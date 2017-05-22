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
		/*  다시 원래창을 제어해야 한다..result값에 따라서 다른 제어..*/
		var of =window.opener.document.registerFrm;
		if(result=='true'){ //주의
			of.id.value="";		
			of.id.focus();
		}else{ //아이디를 사용할 수있다.
			of.flag.value = of.id.value;
			of.password.focus();
		}
		self.close(); //window.self.close();
	}
</script>
</head>

<c:set var="msg" value="사용할 수 없는 아이디"/>
<c:if test="${found==false}">
	<c:set var="msg" value="사용할 수 있는 아이디"/>
</c:if>
<body bgcolor="orange">
	${param.id},${msg}<br><br>
	<input type="button" value="확인" onclick="closeWindow('${found}')">
</body>
</html>







































