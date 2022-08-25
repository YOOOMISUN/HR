<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Country List</title>
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
	<a href="${pageContext.request.contextPath}/addCountry" style="text-align:center; float:right;">Country 추가</a>
</div>
	<table style=" margin-left:auto; margin-right:auto; text-align:center;" class="table table-bordered">
		<tr>
			<th>Region Id</th>
			<th>Region Name</th>
			<th>Country Id</th>
			<th>Country Name</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
			<c:forEach var="country" items="${countryList}">
		<tr>
			<td>${country.REGIONID}</td>
			<td>${country.REGIONNAME}</td>		
			<td>${country.COUNTRYID}</td>		
			<td>${country.COUNTRYNAME}</td>		
			<td><a href="${pageContext.request.contextPath}/modifyCountry?countryId=${country.COUNTRYID}&countryName=${country.COUNTRYNAME}&regionId=${country.REGIONID}">수정</a></td>
			<td><a href="${pageContext.request.contextPath}/removeCountry?countryId=${country.COUNTRYID}">삭제</a></td>
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