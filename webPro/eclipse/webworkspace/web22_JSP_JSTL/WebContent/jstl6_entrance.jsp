<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
form에서 넘어온 값이 19세 이상이면 "성인이므로 까페 입장 가능" 이란 메세지 띄우고...
jstl6_cafe.jsp로 이동하도록 /

form에서 넘어온 값이 19세 미만이면 "미성인이므로 까페 입장 불가능" 이란 메세지 띄우고...
홈으로 이동
::
c:choose를 사용
 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="name" value="${param.userName }" />
	<c:set var="age" value="${param.userAge}" />
	<c:choose>
		<c:when test="${age >= 19 }">
			<script type="text/javascript">
				alert("${name}님은 성인이므로 까페 입장 가능");
				location.href = "jstl6_cafe.jsp?age=${age}";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("${name}님은 미성년자이므로 까페 입장 불가능");
				location.href = "jstl6_javascript.jsp";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>



















