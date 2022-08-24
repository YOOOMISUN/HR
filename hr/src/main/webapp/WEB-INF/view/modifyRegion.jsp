<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<!-- menu.jsp include   /  include : 서버에서 합쳐서 보여주는 것 (forward와 동일한 기술) --> 
<div>
	<c:import url="/WEB-INF/view/Inc/menu.jsp"></c:import>	<!-- jsp : include  -->
</div>
	<form method="post" action="${pageContext.request.contextPath}/modifyRegion">
		<div>
			region Id : 
			<input type="text" name="regionId" value="${region.regionId}" readonly>
		</div>
		<div>
			region Name : 
			<input type="text" name="regionName" value="${region.regionName}" >
		</div>
		<div>
			<button type="submit" class="btn btn-info">수정하기</button>
		</div>
	</form>
	
		<!-- footer include -->
	<hr>
	
	<div>
		<c:import url="/WEB-INF/view/Inc/footer.jsp"></c:import>
	</div>
	
</body>
</html>