<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<!-- menu.jsp include   /  include : 서버에서 합쳐서 보여주는 것 (forward와 동일한 기술) --> 
<div>
	<c:import url="/WEB-INF/view/Inc/menu.jsp"></c:import>	<!-- jsp : include  -->
</div>
<div>
	<a href="${pageContext.request.contextPath}/addBoard" style="text-align:center; float:right;">Board 추가</a>
</div>
	<table style=" margin-left:auto; margin-right:auto; text-align:center;" class="table table-bordered">
		<tr>
			<th>Board No</th>
			<th>Board Title</th>
			<th>Board Content</th>
			<th>Board Date</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
			<c:forEach var="b" items="${BoardList}">
		<tr>
			<td>${b.BOARDNO}</td>
			<td>${b.BOARDTITLE}</td>		
			<td>${b.BOARDCONTENT}</td>		
			<td>${b.BOARDDATE}</td>		
			<td><a href="${pageContext.request.contextPath}/modifyBoard?BoardNo=${b.BOARDNO}&BoardTitle=${b.BOARDTITLE}&BoardContent=${b.BOARDCONTENT}&BoardDate=${b.BOARDDATE}">수정</a></td>
			<td><a href="${pageContext.request.contextPath}/removeBoard?BoardNo=${b.BOARDNO}">삭제</a></td>
		</tr>
			</c:forEach>
	</table>
	
	<!-- footer include -->
	<hr>
	
	<div>
		<c:import url="/WEB-INF/view/Inc/footer.jsp"></c:import>
	</div>
	
	
</body>
</html>