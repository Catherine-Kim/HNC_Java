<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MultiFile Uplaod Result</title>
<script type="text/javascript">
	function downloadFile(filename){
		if(confirm("파일(" + filename + ")을 다운로드 하시겠습니까?")){
			location.href="download.do?filename=" + filename;
		}
	}
</script>
</head>
<body>
	<h2 align="center">MultiFile Uplaod Result</h2><p>
	<ul>
		<c:forEach items="${fileNames}" var="fileName">
			<li><a href="javascript:downloadFile('${fileName};)">${fileName}</a></li><p>
			<%-- <img src="upload/${fileName}" width="200px"> --%>
		</c:forEach>
	</ul>
</body>
</html>