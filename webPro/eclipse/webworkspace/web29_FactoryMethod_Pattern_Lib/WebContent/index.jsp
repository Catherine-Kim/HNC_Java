
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>LoginMember MODEL2 회원관리</h1><p>
<%--
	로그인하지 않은 사용자는 단순한 회원검색, 로그인, 회원 가입 기능만 할수 있도록 한다
	로그인 한 사용자는 단순한 회원검색, 전체회원보기,회원정보수정, 로그아웃 기능을 할수 있도록 한다
	서블릿으로 오늘 모든 요청은 하나의 Front Controller(DispatcherServlet)로 일단 들어간다
 --%>
 <a href="find.jsp" >회원 검색</a><br>
<%--  <%
 	MemberVO vo=(MemberVO)session.getAttribute("mvo");
 	if(vo !=null){ //로그인한 상태
 %> --%>
 
 <c:choose>
 	<c:when test="${sessionScope.mvo != null}">
 		<a href="front.do?command=logout" >로그 아웃</a><br>
 		<a href="front.do?command=allView" >전체 회원 보기</a><br>
 		<a href="update.jsp" >회원 정보 수정</a><br>
 		<a href="selectAddress.jsp" >주소별 검색</a><br>
 	</c:when>
 	<c:otherwise>
 		 <a href="login.jsp" >로그인 </a><br>
 		<a href="register.jsp" >회원 가입</a><br> 	
 	</c:otherwise> 
 </c:choose>
</body>
</html>















