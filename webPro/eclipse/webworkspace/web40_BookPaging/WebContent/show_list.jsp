<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">	
	<tr>
		<td>번호</td><td>책이름</td><td>가격</td>
	</tr>
	<c:forEach var="bvo" items="${requestScope.lvo.list}">		
			<tr>
			    <td>${bvo.bookNo }</td>				
				<td>${bvo.title }</td>
				<td>${bvo.price }</td>				
			</tr>		
	</c:forEach>
</table>
	<br><br>	
	<a href="index.jsp">홈으로</a> <a href="register.jsp">책등록</a>
	<br><br>	
	
	<%--step1
	1)코드를 줄이기위해 pb라는 변수 선언을 했다.
	  앞으로 pb는 requestScope.lvo.pb를 의미한다.
	2)이전의 페이지 그룹이 있으면 이미지를 보여준다
	3)이미지에 이전 그룹의 마지막 페이지 번호를 링크한다.
	  (startPageOfPageGroup-1)
	 --%>	
	<c:set var="pb" value="${requestScope.lvo.pb}"></c:set>

	<c:if test="${pb.previousPageGroup}">
	<a href="DispatcherServlet?command=list&pageNo=${pb.startPageOfPageGroup-1}">
	<img src="img/left_arrow_btn.gif"></a>	
	</c:if>
	
	
	<%--step2
		1) 현 페이지 그룹의 startPage부터 endPage까지 forEach를 이용해서 출력한다.
	 --%>		
	<c:forEach var="i" begin="${pb.startPageOfPageGroup}" 
	end="${pb.endPageOfPageGroup}">
	
	<%--step3
		1) 현재 페이지가 아니면 해당하는 페이지의 링크를 걸어서 출력할수 있다.
		2) 그렇지 않으면 현재 페이지를 그대로 출력한다.
	 --%>
	<c:choose>
	<c:when test="${pb.nowPage!=i}">
	<a href="DispatcherServlet?command=list&pageNo=${i}">${i}</a> 
	</c:when>
	<c:otherwise>
	${i}
	</c:otherwise>
	</c:choose>
	&nbsp;
	</c:forEach>	 


	<%--step4
		1)다음 페이지 그룹이 있으면 이미지를 보여준다(img/right_arrow_btn.gif)
		2)이미지에 이전 그룹의 마지막 페이지 번호를 링크한다(endPageOfPageGroup+1)
	 --%>
	<c:if test="${requestScope.lvo.pb.nextPageGroup}">
	<a href="DispatcherServlet?command=list&pageNo=${requestScope.lvo.pb.endPageOfPageGroup+1}">
	<img src="img/right_arrow_btn.gif"></a>
	</c:if>	
</body>
</html>











