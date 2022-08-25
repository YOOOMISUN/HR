<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Country</title>

</head>
<body>
	<!-- menu.jsp include   /  include : 서버에서 합쳐서 보여주는 것 (forward와 동일한 기술) --> 
<div>
	<c:import url="/WEB-INF/view/Inc/menu.jsp"></c:import>	<!-- jsp : include  -->
</div>
	<form method="post" action="${pageContext.request.contextPath}/modifyCountry">	<!-- modifyCountryController 수정 form -->
		<div>
		Region Id / Name : 
		<select name="regionId">
			<c:forEach var="region" items="${regionList}">
				<option value="${region.regionId}">${region.regionId} ) ${region.regionName}</option>
			</c:forEach>
		</select>
		</div>
		
		<div>
			Country Id : 
			<input type="text" name="countryId" value="${country.countryId}" readonly="readonly">
		</div>
		<div>
			Country Name : 
			<input type="text" name="countryName" value="${country.countryName}">
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