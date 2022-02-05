<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax addList - guestbook</title>
<!-- 부트스트랩 맨 위에 두고 내가 정의한건 밑에 둔다 -->
<link href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.12.4.js"> </script>
<!-- 부트스트랩 제이쿼리 아래 위치한다 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.js"> </script>

</head>

<body>
	<div id="wrap">

		<!-- //header -->

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		<!-- //nav -->

		<c:import url="/WEB-INF/views/include/asideGuestbook.jsp"></c:import>
		<!-- //aside -->

			<div id="content">

				<div id="content-head" class="clearfix">
					<h3>ajax방명록</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>방명록</li>
							<li class="last">ajax방명록</li>
						</ul>
					</div>
				</div>
				<!-- //content-head -->

				<div id="guestbook">
					<%-- <form action="${pageContext.request.contextPath}/guestbook/write" method="get"> --%>
					<table id="guestAdd">
						<colgroup>
							<col style="width: 70px;">
							<col>
							<col style="width: 70px;">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th><label class="form-text" for="input-uname">이름</label>
								</td>
								<td><input id="input-uname" type="text" name="name" autofocus></td>
								<th><label class="form-text" for="input-pass">패스워드</label>
								</td>
								<td><input id="input-pass" type="password" name="password"></td>
							</tr>
							<tr>
								<td colspan="4"><textarea name="content" cols="72" rows="5"></textarea></td>
							</tr>
							<tr class="button-area">
								<td colspan="4" class="text-center"><button id="btnSubmit" type="submit">등록(para)</button>
								<button id="btnSubmit2" type="submit">등록(json)</button>
							</tr>
						</tbody>

					</table>
					<!-- //guestWrite -->
					<!-- <input type="hidden" name="action" value="add"> -->
					<!-- </form> -->

					<div id="listArea">
						<!-- 리스트 출력할 곳 -->
					</div>

					<%-- <c:forEach items="${requestScope.guestbookList}" var="guestbookList">
					<table class="guestRead">
						<colgroup>
							<col style="width: 10%;">
							<col style="width: 40%;">
							<col style="width: 40%;">
							<col style="width: 10%;">
						</colgroup>
						<tr>
							<td>No:${guestbookList.no }</td>
							<td>Name:${guestbookList.name }</td>
							<td>time:${guestbookList.regDate }</td>
							<td><a href="${pageContext.request.contextPath}/guestbook/deleteForm?no=${guestbookList.no }">[삭제]</a></td>
						</tr>
						<tr>
							<td colspan=4 class="text-left">${guestbookList.content }</td>
						</tr>
					</table>
					
					</c:forEach> --%>

					<!-- //guestRead -->

				</div>
				<!-- //guestbook -->

			</div>
			<!-- //content  -->
		</div>

		<!-- //container  -->

		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

		<!-- //footer -->

	</div>
	<!-- //wrap -->




<!-- --------------------------------------------------------------------------------------------------- -->
<!-- 삭제 모달창 시작 -->

<div id="delModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">비밀번호 입력 모달창</h4>
			</div>
			<div class="modal-body">

				비밀번호: <input id="modalPassword" type="password" name="password" value=""> 
				<br> 
				<input id="modalNo" type="text" name="no" value="no">

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				<button id="modalBtnDel" type="button" class="btn btn-danger">삭제</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- 삭제 모달창 종료 -->

</body>






<script type="text/javascript">
//로딩 전에 요청하기
$(document).ready(function() {
	console.log("리스트 요청");
	fetchList();

}); // document . ready

// 저장버튼 클릭할때 - 파라미터 방식
$("#btnSubmit").on("click", function() {
	console.log("저장버튼 클릭 액션(파라미터 방식)");

	//폼에 데이터를 모은다
	var name = $("#input-uname").val(); // 이름
	var password = $("#input-pass").val(); // 비번
	var content = $("[name='content']").val(); //컨텐츠

	//위에서 모은 데이터를 객체로 만들기
	var guestbookVo = {
		name : name,
		password : password,
		content : content
	}; // var guestbookVo

	console.log(guestbookVo); //콘솔에 입력한 정보 제대로 뜨는지 확인

	$(document).ready(function() { // 리스트 요청하기
		console.log("리스트 요청");

		$.ajax({

			// 복잡한 방식 url : "${pageContext.request.contextPath}/api/guestbook/write?name="+name+"&password="+password+"",      
			url : "${pageContext.request.contextPath}/api/guestbook/write",
			type : "post",
			//contentType : "application/json",
			data : guestbookVo, // 위에서 만든 객체를 그대로 이어 쓴다
			//data : {name:name, password:password, content:content]}, // 위 코드와 같은 기능

			//dataType : "json",
			success : function(result) {
				/*성공시 처리해야될 코드 작성*/
				console.log("guestbookVo 출력확인 " + guestbookVo);
				render(result, "up"); // result 대신 render(guestbookVo, "up"); 했더니 실시간 반영안됨

				//입력버튼 초기화 
				$("#input-uname").val("");
				$("#input-pass").val("");
				$("[name='content']").val("");

			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		}); // ajax

	}); // document . ready

}); // #btnSubmit function




//저장버튼 클릭할때 - json 방식 요청
$("#btnSubmit2").on("click", function() {
	console.log("저장버튼 클릭 액션(json 방식)");

	//폼에 데이터를 모은다
	var name = $("#input-uname").val(); // 이름
	var password = $("#input-pass").val(); // 비번
	var content = $("[name='content']").val(); //컨텐츠

	//위에서 모은 데이터를 객체로 만들기
	var guestbookVo = {
		name : name,
		password : password,
		content : content
	}; // var guestbookVo

	console.log(guestbookVo); //콘솔에 입력한 정보 제대로 뜨는지 확인

	$(document).ready(function() { // 리스트 요청하기
		console.log("btnSubmit2 - 리스트 요청");

		$.ajax({

			url : "${pageContext.request.contextPath}/api/guestbook/write2",
			type : "post",
			contentType : "application/json",
			data : JSON.stringify(guestbookVo), // 자바스크립트 객체를 json 형식으로 변경 

			dataType : "json",
			success : function(result) {
				/*성공시 처리해야될 코드 작성*/
				console.log("guestbookVo 출력확인 " + guestbookVo);
				render(result, "up"); 

				$("#input-uname").val("");
				$("#input-pass").val("");
				$("[name='content']").val("");

			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		}); // ajax

	}); // document . ready
	
}); // 저장버튼 클릭할때 - json 방식 요청 btnSubmit2 click function




// #btnDelPop function 삭제 버튼 눌러서 팝업 호출
$("#listArea").on("click", ".btnDelPop", function() { // 부모(listArea)에게 지정 하고 자식(btnDelPop)에게 위임
	var $this = $(this);
	var no = $this.data("no"); // data-no 소문자만 인식 에러 조심 

	console.log("no 출력" + no);
	$("#modalPasswrod").val(""); // 초기화 - 비번 입력 전 입력폼 입력값을 지운다
	$("#modalNo").val(no);
	
	$('#delModal').modal('show');

}); // #btnDelPop function 삭제 버튼 눌러서 팝업 호출  

// 모달 창에서 삭제버튼을 클릭했을때 
$("#modalBtnDel").on("click", function() {
	console.log("모달창 삭제 버튼 클릭");

	// 데이터 수집
	var no = $("#modalNo").val();
	var pw = $("#modalPassword").val();

	var delInfoVo = {
		no : no,
		password : pw
	}

	console.log("delInfoVo 출력 " + delInfoVo);

	//ajax 요청 no password
	$.ajax({
		url : "${pageContext.request.contextPath}/api/guestbook/remove",
		type : "post",
		// contentType : "application/json",
		data : delInfoVo,

		dataType : "json",
		success : function(state) {
			console.log("state 출력 " + state);

			if (state === 'success') {
				/*성공시 처리해야될 코드 작성*/

				//화면에서 변경하는 부분 반영
				$("#t"+no).remove(); //해당 테이블html 삭제 
				$('#delModal').modal('hide'); // 모달 창 닫기
			} else { 
				$('#delModal').modal('hide'); // 모달 창 닫기
				alert("비밀번호를 확인하세요");
			} // if else 
				
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	}); // ajax

}); // modalBtnDel click function


	
	
	
function fetchList() { // 리스트 가져오기 (그리기를 시키는 기능)

$.ajax({
	//요청항목 보낼떄
	url : "${pageContext.request.contextPath}/api/guestbook/list",
	type : "post", // get으로 해도 안보이니까 post 방식
	//contentType : "application/json",
	//data : {name: "홍길동"},

	//응답항목 받을때
	dataType : "json",
	success : function(guestbookList) { // json -> js 로 변환
		/*성공시 처리해야될 코드 작성*/
		console.log(guestbookList);
		// console.log(guestbookList[0].name); // 데이터 잘 오는지 확인

		for (var i = 0; i < guestbookList.length; i++) {
			render(guestbookList[i], "down"); // 방명록 리스트 출력
		}

	},
	error : function(XHR, status, error) {
		console.error(status + " : " + error);
	}
}); // ajax

}; // function fetchList


function render(guestbookVo, updown) { // 1명씩 정보를 받아 처리 button의 data-no 소문자만 인식 대문자넣으면 에러 
	console.log("테이블 출력");
	var str = '';
	str += ' <table id="t'+guestbookVo.no+'" class="guestRead"> ';
	str += ' 	<colgroup> ';
	str += ' 		<col style="width: 10%;"> ';
	str += ' 		<col style="width: 40%;"> ';
	str += ' 		<col style="width: 40%;"> ';
	str += ' 		<col style="width: 10%;"> ';
	str += ' 	</colgroup> ';
	str += ' 	<tr> ';
	str += ' 		<td>No: ' + guestbookVo.no + '</td> ';
	str += ' 		<td>Name: ' + guestbookVo.name + '</td> ';
	str += ' 		<td>time: ' + guestbookVo.regDate + '</td> ';
	str += ' 		<td> <button class= "btnDelPop" type="button" data-no="'+guestbookVo.no+'" >삭제</button> </td> ';
	str += '	 </tr> ';
	str += ' 	 <tr> ';
	str += ' 	<td colspan=4 class="text-left">' + guestbookVo.content
			+ '</td> ';
	str += ' 	</tr> ';
	str += ' </table> ';
	str += ' ';

	if (updown == 'down') {
		$("#listArea").append(str); // .html 을 쓰면 바꿔치는 기능때문에 마지막글 만 출력 
	} else if (updown == 'up') {
		$("#listArea").prepend(str);
	} else {
		console.log("방향오류");
	};

}; // function render
/* str += ' 		<td><a href="${pageContext.request.contextPath}/api/guestbook/deleteForm?no='+guestbookVo.no+'">[삭제]</a></td> '; */
</script>


</html>