<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript">
	$(function(){
		$('#addrSel').change(function(){
			//alert($(this).val());
			var addr = $(this).val();
			if($(this).val() == ''){
				alert('하나는 선택하시지');
				return;
			}
			
			$.ajax({
				type: "post",
				url: "member.do",
				data: "command=getMemberCountByAddress&&address=" + $(this).val(),
				
				success: function(data){
					$('#countView').html(data.count);
				} // success
			}); // ajax() 
			
			$('#showBtn').click(function(){
				$.ajax({
					type: "post",
					url: "member.do",
					data: "command=getMemberListByAddress&&address=" + addr,
					
					success: function(data){
						$.each(data.memList, function(index){
							$('#showAll').append('<tr><td>'+data.memList[index].id+'</td><td>'+ data.memList[index].name +'</td><td>'+ data.memList[index].address +'</td></tr>');
						});
					} // success
				});
			}); // cilck()
		}); // change();
	});//ready
</script>
</head>
<body>
<h2>member table의 Address List</h2><p>
<select id="addrSel">
	<option value="">======</option>
	<c:forEach items="${requestScope.addressList}" var="address">
		<option value="${address}">${address}</option>
	</c:forEach>
</select>
<span id="countView"></span>
<input type="button" value="회원보기" id="showBtn">
<hr>
<table border="2" bgcolor="yellow">
	<thead>
		<tr><td>ID</td><td>NAME</td><td>ADDRESS</td></tr>
	</thead>
	<tbody id="showAll">
	<!-- 이안에 붙는다...내용이.. -->
	</tbody>
</table>
</body>
</html>





























