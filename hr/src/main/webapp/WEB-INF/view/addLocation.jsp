<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Location</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#regionId').change(function() {
		// alert('regionId change');
		// ajax호출 -> 값 -> countryId select append
		if($('#regionId').val() == '') {
			alert('region을 선택하세요');
		} else {
			$('#countryId').empty();
			$('#countryId').append('<option value="">::: Country 선택 :::</option>')
			
			$.ajax({
				url : '/rest/getCountryList',
				type : 'get',
				data : {regionId : $('#regionId').val()},
				success : function(json) {
					//let arr = [];
					$(json).each(function(index, item){
						//arr.push(item);
						$('#countryId').append('<option value="'+item.countryId+'">'+item.countryName+'</option>')
					});
					//console.log(arr);
				}
			});
		}
	});
});
</script>


</head>
<body>
<!-- menu.jsp include   /  include : 서버에서 합쳐서 보여주는 것 (forward와 동일한 기술) --> 
<div>
	<c:import url="/WEB-INF/view/Inc/menu.jsp"></c:import>	<!-- jsp : include  -->
</div>

	<form method="post" action="${pageContext.request.contextPath}/addLocation">
	<div>
		Region Id / Name : 
		<select id="regionId">
			<option value="">::: Region 선택 :::</option>
			<c:forEach var="region" items="${regionList}">
				<option value="${region.regionId}">${region.regionId} ) ${region.regionName}</option>
			</c:forEach>
		</select>
	
		CountryId :
			<select name="countryId" id="countryId">
			</select>
	</div>
		<div>
			Location Id : 
			<input type="text" name="locationId">
		</div>
		<div>
			Street Address : 
			<input type="text" name="streetAddress">
		</div>
		<div>
			Postal Code : 
			<input type="text" name="postalCode">
		</div>
		<div>
			City : 
			<input type="text" name="city">
		</div>
		<div>
			State Province : 
			<input type="text" name="stateProvince">
		</div>

			<button type="submit" class="btn btn-info">Country 추가</button>

	</form>
	
		<!-- footer include -->
	<hr>
	
	<div>
		<c:import url="/WEB-INF/view/Inc/footer.jsp"></c:import>
	</div>
	
</body>
</html>