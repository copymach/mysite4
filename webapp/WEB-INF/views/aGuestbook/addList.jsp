<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax addList</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.12.4.js">
</script>

</head>

<body>
	<div id="wrap">

		<!-- //header -->

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		<!-- //nav -->
			
		<div id="container" class="clearfix">
			<div id="aside">
				<h2>방명록</h2>
				<ul>
					<li><a href="${pageContext.request.contextPath}/guestbook/addList">일반방명록</a></li>
					<li><a href="${pageContext.request.contextPath}/api/guestbook/addList">ajax방명록</a></li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">
				
				<div id="content-head" class="clearfix">
					<h3>일반방명록</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>방명록</li>
							<li class="last">일반방명록</li>
						</ul>
					</div>
				</div>
				<!-- //content-head -->

				<div id="guestbook">
					<form action="${pageContext.request.contextPath}/guestbook/write" method="get">
						<table id="guestAdd">
							<colgroup>
								<col style="width: 70px;">
								<col>
								<col style="width: 70px;">
								<col>
							</colgroup>
							<tbody>
								<tr>
									<th><label class="form-text" for="input-uname">이름</label></td>
									<td><input id="input-uname" type="text" name="name" autofocus></td>
									<th><label class="form-text" for="input-pass">패스워드</label></td>
									<td><input id="input-pass"type="password" name="password"></td>
								</tr>
								<tr>
									<td colspan="4"><textarea name="content" cols="72" rows="5"></textarea></td>
								</tr>
								<tr class="button-area">
									<td colspan="4" class="text-center"><button type="submit">등록</button></td>
								</tr>
							</tbody>
							
						</table>
						<!-- //guestWrite -->
						<!-- <input type="hidden" name="action" value="add"> -->
						
					</form>	
					
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

</body>

<script type="text/javascript">
//로딩 전에 요청하기
$(document).ready(function(){
	console.log("리스트 요청");
	
	$.ajax({
	      //요청항목
	      url : "${pageContext.request.contextPath}/api/guestbook/list",      
	      type : "post", // get으로 해도 안보이니까 post 방식
	      //contentType : "application/json",
	      //data : {name: "홍길동"},
		
	      //응답항목
	      // dataType : "json",
	      success : function(guestbookList){
	         /*성공시 처리해야될 코드 작성*/
	         console.log(guestbookList);
	      },
	      error : function(XHR, status, error) {
	         console.error(status + " : " + error);
	      }
	   }); // ajax
	
}); // document . ready

</script>

</html>