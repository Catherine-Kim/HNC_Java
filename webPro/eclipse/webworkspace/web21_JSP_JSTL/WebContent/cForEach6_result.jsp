<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><!-- ----------------------------------------------------------- body-->
<h2><c:out value="<forEach>태그의 사용법"/></h2><p>
<h4>1. 1~ 100 까지 홀수의 합 :: set/ forEach 사용</h4><p>
	<c:forEach begin="1" end="100" step="2" var="num">
		<c:set var="sum" value="${sum+num}"></c:set>
	</c:forEach>
<b>결과 : ${sum}</b><br/>

<br/><hr><br/><!-- ----------------------------------------------------------- -->

<h4>2. 구구단 7단 출력</h4><p>
<c:forEach begin="1" end="9" var="num">
	<c:set var="mul" value="${num * 7}"></c:set>
	7 * ${num} = ${mul} <br/>
</c:forEach>

<br/><hr><br/><!-- ----------------------------------------------------------- -->

<h4>2-1. 구구단 7단 출력 ver. 2</h4><p>
<c:forEach begin="7" end="7" var="i">
	<c:forEach begin="1" end="9" var="j">
		${i} * ${j} = ${i * j} <br/>
	</c:forEach>
</c:forEach>

<br/><hr><br/><!-- ----------------------------------------------------------- -->

<h4>3. MENU라는 배열 객체를 받아와서 그 안의 내용을 출력 :: EL</h4><p>
${MENU[0]}<br/>
${MENU[1]}<br/>
${MENU[2]}<br/>
${MENU[3]}<br/>
${MENU[4]}<br/>

<br/><hr><br/><!-- ----------------------------------------------------------- -->

<h4>3-1. MENU라는 배열 객체를 받아와서 그 안의 내용을 출력 :: JSTL</h4><p>
<c:forEach items="${MENU}" var="item">
	${item}<br/>
</c:forEach>

<br/><hr><br/><!-- ----------------------------------------------------------- -->

<h4>4. INFO라는 Map 객체를 받아와서 그 안의 내용을 출력(key, value 따로따로)</h4><p>
<c:forEach items="${INFO}" var="map">
	${map.key} :: ${map.value}<br/>
</c:forEach>
</body><!-- ----------------------------------------------------------- body-->
</html>
</html>
