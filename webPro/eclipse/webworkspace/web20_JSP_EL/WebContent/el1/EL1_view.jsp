<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Attribute에 binding된 값 가져오기</h2><p>
<h3>1부터 100까지의 총합을 출력할게요 :: Scriptlet Element</h3><p>
<%=	request.getAttribute("RESULT") %><br/>
<p><hr><p>
<h3>1부터 100까지의 총합을 출력할게요 :: EL</h3><p>
1) ${RESULT}<br/>
2) ${requestScope.RESULT}<br/>			<%-- ServletRequest --%>
3) ${sessionScope.RESULT}<br/>			<%-- HttpSession --%>
4) ${applicationScope.RESULT}<br/>		<%-- ServletContext --%>
5) ${RESULT + 30}
</body>
</html>
