<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>rboard.read</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
</head>

<body>
	<div id="wrap">

		<!-- //header -->

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		<!-- //nav -->

		<div id="container" class="clearfix">
			<div id="aside">
				<h2>게시판</h2>
				<ul>
					<li><a href="">일반게시판</a></li>
					<li><a href="">댓글게시판</a></li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">

				<div id="content-head">
					<h3>게시판</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>게시판</li>
							<li class="last">일반게시판</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->
	
				<div id="board">
					<div id="read">
						<form action="#" method="get">
							<!-- 작성자 -->
							<div class="form-group">
								<span class="form-text">작성자id (uno:name)</span>
								<span class="form-value">${rboardList.id } (${rboardList.uno}:${rboardList.user_name})</span>
							</div>
							
							<!-- 조회수 -->
							<div class="form-group">
								<span class="form-text">조회수</span>
								<span class="form-value">${rboardList.hit }</span>
							</div>
							
							<!-- 작성일 -->
							<div class="form-group">
								<span class="form-text">작성일</span>
								<span class="form-value">${rboardList.reg_date }</span>
							</div>
							
							<!-- 제목 -->
							<div class="form-group">
								<span class="form-text">제 목</span>
								<span class="form-value">${rboardList.title }</span>
							</div>
						
							<!-- 내용 -->
							<div id="txt-content">
								<span class="form-value" >
									${rboardList.content }
								</span>
							</div>
							
							<!-- 로그인한 사람의 no와 글쓴이의 uno가 일치하면 댓글 달기 수정 버튼 출력 -->
							<c:if test="${authUser.no == rboardList.uno}">
								<a href="${pageContext.request.contextPath}/rboard/delete?bno=${rboardList.bno}&uno=${authUser.no}">삭제</a>
								
							</c:if>
									
							<a id="btn_modify" href="${pageContext.request.contextPath}/rboard/modifyForm?bno=${rboardList.bno}&uno=${authUser.no}">수정</a>
							<a id="btn_modify" href="${pageContext.request.contextPath}/rboard/replyWriteForm?bno=${rboardList.bno}&uno=${authUser.no}&group_no=${rboardList.group_no}&order_no=${rboardList.order_no}&depth=${rboardList.depth}">댓글달기</a>
							<a id="btn_modify" href="${pageContext.request.contextPath}/rboard/list">목록</a>
							
							bno<input type="text" name="bno" value="${rboardList.bno}">
							no<input type="text" name="no" value="${authUser.no}">
							group_no<input type="text" name="group_no" value="${rboardList.group_no}">
							order_no<input type="text" name="order_no" value="${rboardList.order_no}">
							depth<input type="text" name="depth" value="${rboardList.depth}">
							
						</form>
						<!-- //form -->
					</div>
					<!-- //read -->
				</div>
				<!-- //board -->
			</div>
			<!-- //content  -->

		</div>
		<!-- //container  -->

		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

</html>

