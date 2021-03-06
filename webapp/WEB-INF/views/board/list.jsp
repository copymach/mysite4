<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list casual board</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">

</head>


<body>
	<div id="wrap">

		<!-- //header -->

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //nav -->
		
		<!-- 게시판 aside -->
		<c:import url="/WEB-INF/views/include/asideBoard.jsp"></c:import>
		<!-- //게시판 aside -->
			
			<div id="content">

				<div id="content-head">
					<h3>일반게시판 list2</h3>
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
					<div id="list">
						<form action="" method="get">
							<div class="form-group text-right">
								<input type="text">
								<button type="submit" id=btn_search>검색</button>
							</div>
						</form>
						<table >
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>글쓴이id (uno:userName)</th>
									<th>조회수</th>
									<th>작성일</th>
									<th>관리</th>
								</tr>
							</thead>

							<c:forEach items="${requestScope.pMap.boardList}" var="boardList">
							
							<tbody>
							
								<tr>
									<td>${boardList.bno}</td>
									<td class="text-left"><a href="/mysite4/board/read?bno=${boardList.bno }">${boardList.title }</a></td>
									<td>${boardList.id } (${boardList.uno}:${boardList.user_name })</td>
									<td>${boardList.hit }</td>
									<td>${boardList.reg_date}</td>
									
									<!-- 로그인한 사람의 no와 글쓴이의 uno가 일치하면 삭제버튼 출력 -->
									<c:if test="${authUser.no == boardList.uno}">
										<td><a href="${pageContext.request.contextPath}/board/delete?bno=${boardList.bno}&uno=${authUser.no}">[삭제]</a></td>
									</c:if>

								</tr>
							
							</tbody>
							
							</c:forEach>
							
						</table>
			
						<div id="paging">
							<ul>
								
								<c:if test="${requestScope.pMap.prev eq true}">
									<li><a href="${pageContext.request.contextPath}/board/list2?crtPage=${requestScope.pMap.startPageBtnNo-1}">◀</a></li>
								</c:if>
								
								<!-- 현제 페이지 볼드처리 -->
							<c:forEach begin="${requestScope.pMap.startPageBtnNo}" end="${requestScope.pMap.endPageBtnNo}" step="1" var="page">
							
									<li class= ${pMap.crtPageNo eq page ? "active" : ""}>
										<a href="${pageContext.request.contextPath}/board/list?crtPage=${page}">${page}</a>
									</li>
														
							</c:forEach>
								
								<c:if test="${requestScope.pMap.next eq true}">
								<li><a href="${pageContext.request.contextPath}/board/list2?crtPage=${requestScope.pMap.endPageBtnNo+1}">▶</a></li>
								</c:if>
								
							</ul>
							
							
							<div class="clear"></div>
						</div>
						<c:choose>
							<c:when test="${empty sessionScope.authUser}">
								<td>글쓰기 하려면 로그인하세요</td>
							</c:when>
							<c:otherwise>
								<a id="btn_write" href="${pageContext.request.contextPath}/board/writeForm">글쓰기</a>
							</c:otherwise>
						</c:choose>
					</div>
					<!-- //list -->
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
