<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department List</title>
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
	<a href="${pageContext.request.contextPath}/addDepartment" style="text-align:center; float:right;">Department 추가</a>
</div>
	<table style=" margin-left:auto; margin-right:auto; text-align:center;" class="table table-bordered">
		<tr>
			<th>Location Id</th>
			<th>Region Name</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="r" items="${list}">
			<tr>
				<td>${r.regionId}</td>
				<td>${r.regionName}</td>
				<td><a href="${pageContext.request.contextPath}/modifyDepartment?regionId=${r.regionId}&regionName=${r.regionName}">수정</a></td>
				<td><a href="${pageContext.request.contextPath}/removeDepartment?regionId=${r.regionId}">삭제</a></td>
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