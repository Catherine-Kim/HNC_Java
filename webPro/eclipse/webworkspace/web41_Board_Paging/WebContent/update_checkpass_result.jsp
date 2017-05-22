<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	<c:choose>	
		<c:when test="${flag == true}">			
			if (confirm("정말로 수정하겠습니까?"))
				window.opener.location.href = "DispatcherServlet?command=updateView&&no=${param.no}";
		</c:when>
		<c:otherwise>
				alert("비밀번호가 일치하지 않습니다.");
		</c:otherwise>
	</c:choose>
	window.close();
</script>
