<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function(){
	   $('#addFile').click(function(){
	      let isFileEmpty = false;
	      
	      let html = '<div><input type="file" name="multiList" class="multiList"></div>'
	      
	      $('.multiList').each(function(index, item){	// each 반복시킴 / . (클래스)
	         // $(this) --> item
	         if($(item).val() == ''){					// 한번이라도 공백이 되면 true
	            isFileEmpty = true;
	         }
	      });
	      if(isFileEmpty == false){
	         $('#fileSection').append(html);
	      }
	   });
	   
	   $('#addBtn').click(function(){
	      let isFileEmpty = false;
	      // board 유효성 검사 후
	      $('.multiList').each(function(index, item){	// each 반복시킴 / . (클래스)
	         // $(this) --> item
	         if($(item).val() == ''){					// 한번이라도 공백이 되면 true
	            isFileEmpty = true;
	         }
	      });
	      
	      
	      if($('#boardTitle').val() == ''){
	         alert('제목을 입력하세요!');
	      } else if($('#boardContent').val() == ''){
	         alert('내용을 입력하세요!');
	      } else if(isFileEmpty){
	         alert('파일을 추가하세요!');
	      } else{
	    	  addBoardForm.submit();
	      }
	      
	   });
	   
	   $('#removeFile').click(function(){
	      $('#fileSection').empty();
	   });
	});
</script>
</head>
<body>
<div>
	<c:import url="/WEB-INF/view/Inc/menu.jsp"></c:import>	<!-- jsp : include  -->
</div>
	<form enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/addBoard" id="addBoardForm">
		<!-- 보드 내용들 -->
		<div>
			Board Title
			<input type="text" name="board.boardTitle" id="boardTitle">
		</div>
		<div>
			Board Content
			<input type="text" name="board.boardContent" id="boardContent">
		</div>
		
		
		<!-- 버튼을 눌러서 파일 업로드를 생기게 -->
		<button type="button" id="addFile">파일추가</button>		<!-- input type="file" -->
		<button type="button" id="removeFile">파일삭제</button>	<!-- input type="file" -->
		<div id="fileSection"></div>
		
		<button type="button" id="addBtn">Board 추가하기</button>
	</form>
	
	<div>
		<c:import url="/WEB-INF/view/Inc/footer.jsp"></c:import>
	</div>
</body>
</html>