<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gallery list</title>

<link href="${pageContext.request.contextPath }/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/gallery.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.12.4.js"> </script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.js"> </script>

</head>


<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->
		<!-- //nav -->

		<c:import url="/WEB-INF/views/include/asideGallery.jsp"></c:import>
		<!-- //aside -->


		<div id="content">

			<div id="content-head">
				<h3>갤러리</h3>
				<div id="location">
					<ul>
						<li>홈</li>
						<li>갤러리</li>
						<li class="last">갤러리</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!-- //content-head -->


			<div id="gallery">
				<div id="list">
			
					
						<button id="btnImgUpload">이미지올리기</button>
						<div class="clear"></div>

			
					<ul id="viewArea">
					
						<c:forEach items="${galleryList}" var="galleryList">
						<!-- 이미지반복영역 -->
							<li>
								<div class="view" >
									<img class="imgItem" src="${galleryList.filePath}${galleryList.saveName}">
									<div class="imgWriter">작성자id: <strong>${galleryList.id}</strong></div>
								</div>
							</li>
						<!-- 이미지반복영역 -->
						</c:forEach>
						
					</ul>
				</div>
				<!-- //list -->
			</div>
			<!-- //board -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

	
		
	<!-- 이미지등록 팝업(모달)창 -->
	<div class="modal fade" id="addModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title">이미지등록</h4>
				</div>
				
				<form method="" action="" >
					<div class="modal-body">
						<div class="form-group">
							<label class="form-text">글작성</label>
							<input id="addModalContent" type="text" name="" value="" >
						</div>
						<div class="form-group">
							<label class="form-text">이미지선택</label>
							<input id="file" type="file" name="" value="" >
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn" id="btnUpload">등록</button>
					</div>
				</form>
				
				
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	


	<!-- 이미지보기 팝업(모달)창 -->
	<div class="modal fade" id="viewModal">
		<div class="modal-dialog" >
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title">이미지보기</h4>
				</div>
				<div class="modal-body">
					
					<div class="formgroup" >
						<img id="viewModelImg" src =""> <!-- ajax로 처리 : 이미지출력 위치-->
					</div>
					
					<div class="formgroup">
						<p id="viewModelContent"></p>
					</div>
					
				</div>
				<form method="post" action="">
					<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-danger" id="btnDel">삭제</button>
				</div>
				
				
				</form>
				
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->	


</body>

<script type="text/javascript">
//로딩 전에 요청하기 document . ready
$(document).ready(function() {
	console.log("리스트 요청");
	fetchList();
}); // 로딩 전에 요청하기 document . ready

//이미지올리기 버튼 클릭할때 팝업 호출
$("#btnImgUpload").on("click", function(){
	console.log("이미지올리기 버튼눌림");
	var $this = $(this);
	//var uno = $this.data("uno"); // 이미지 업로더 번호 
	
	$('#addModal').modal('show');
	
}); // 이미지올리기 버튼 클릭 팝업 호출


// 이미지올리기 속 등록 버튼 클릭할때
$("#btnUpload").on("click", function(){
	console.log("등록 버튼눌림");
	

}); // 이미지올리기 속 등록 버튼 클릭할때


// 이미지 클릭할때 이미지보기 팝업 호출
$("#viewModal").on("click", function(){
	console.log("이미지 누름");
	var $this = $(this);
	//var uno = $this.data("uno"); // 이미지 업로더 번호 
	
	$('#viewModal').modal('show');
	
}); // 이미지올리기 버튼 클릭 팝업 호출


// 이미지 리스트 출력 viewArea
$("viewArea").on("click", function() {
	var $this = $(this);
	var bno = $this.data("bno");
	
	console.log("bno 출력 "+bno);
	
	$('#viewModal').modal('show');
	
}); // 이미지 리스트 출력 viewArea






function fetchList() {

$.ajax({
	// 요청항목 보내기
	url : "${pageContext.request.contextPath}/gallery/list",
	type : "post",
	
	// 요청항목 받기 -리스트 valid denied 조건없이 출력 
	dataType : "json",
	// console.log("galleryList 출력 "+galleryList);
	
	function(galleryList) {
		for (var i=0; i<galleryList.length; i++) {
			render(galleryList[i], "downside");
		}
	}
}); // $.ajax
	
}; // function fetchList


function render(galleryVo, updown) {
	console.log("테이블 출력");
	var str = '';
	str += ' <li id="pic'+galleryVo.bno+'"> ';
	str += ' 	<div class="view" > ';
	str += ' 			<img class="imgItem" src="'+galleryVo.filePath+galleryVo.saveName+'"> ';
	str += ' 			<div class="imgWriter">작성자id: <strong>'+galleryVo.id+'</strong></div> ';
	str += ' 	</div> ';
	str += ' </li> ';
	str += ' ';
	
	if (updown == 'downside') {
		$("#viewArea").append(str); // .html 을 쓰면 바꿔치는 기능때문에 마지막글 만 출력 
	} else if (updown == 'upside') {
		$("#viewArea").prepend(str);
	} else {
		console.log("방향오류");
	};
	
};


</script>


</html>

