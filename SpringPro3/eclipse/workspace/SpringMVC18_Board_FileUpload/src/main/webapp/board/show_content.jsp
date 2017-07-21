<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function deleteBoard() {
		alert('${bvo.no}');
		if (confirm('진짜 삭제할꺼징?'))
			location.href = 'deleteBoard.do?no=${bvo.no}&&newfilename=${newfilename}';
	}
</script>
</head>
<body>
	<h2 align="center">게시글</h2><p>
	<table border="2">
		<tr>
			<td>글 번호</td>
			<td>${bvo.no}</td>
			<td>글 제목</td>
			<td colspan="3">${bvo.title}</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${bvo.count}</td>
			<td>작성자</td>
			<td>${bvo.memberVO.name}</td>
			<td>작성일</td>
			<td>${bvo.writeDate}</td>
		</tr>
		<c:if test="${bvo.orgfilename != null}">
			<tr>
				<td>파일</td>
				<td colspan="5">
					<a href="boardDownload.do?orgfilename=${bvo.orgfilename}&&newfilename=${bvo.newfilename}">
						${bvo.orgfilename}
					</a>
				</td>
			</tr>
		</c:if>
		<tr>
			<td colspan="6">${bvo.content}</td>
		</tr>
	</table>
	<br/>
	<a href="${initParam.root}showList.do">글 목록가기</a>&nbsp;
	<!-- 현재 로그인한 사람이 글 작성자와 동일한 사람일 때는 삭제, 수정 버튼이 목록 버튼과
	함께 보이도록 해야함. (현재 로그인한 사람의 아이디와 게시글 작성자의 아이디와 동일한 경우)-->
	<!-- 삭제, 수정 등의 로직은 되도록 popup 창을 띄워 의사를 재확인 후 처리하는 것이 친절한 매너 -->
	<c:if test="${sessionScope.mvo.id == requestScope.bvo.memberVO.id}">
		<a href="javascript:deleteBoard()">글 삭제하기</a>&nbsp;		
		<a href="">글 수정하기</a>
	</c:if>

</body>
</html>