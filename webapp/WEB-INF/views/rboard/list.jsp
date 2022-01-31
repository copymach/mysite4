<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>rboard.list</title>
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
					<li><a href="${pageContext.request.contextPath}/board/list">일반게시판</a></li>
					<li><a href="${pageContext.request.contextPath}/rboard/list">댓글게시판</a></li>
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
									<th>제목 (gn그룹넘버 on오더넘버 de깊이)</th>
									<th>글쓴이id (uno:userName)</th>
									<th>조회수</th>
									<th>작성일</th>
									<th>관리</th>
								</tr>
							</thead>

							<c:forEach items="${requestScope.rboardList}" var="rboardList">
							
							<tbody>
							
								<tr>
									<td>${rboardList.bno}</td>
									<td class="text-left"><a href="${pageContext.request.contextPath}/rboard/read?bno=${rboardList.bno }">${rboardList.title }</a> ( gn:${rboardList.group_no} / on:${rboardList.order_no} / dp:${rboardList.depth} )</td>
									<td>${rboardList.id } (${rboardList.uno}:${rboardList.user_name })</td>
									<td>${rboardList.hit }</td>
									<td>${rboardList.reg_date}</td>
									
									<!-- 로그인한 사람의 no와 글쓴이의 uno가 일치하면 삭제버튼 출력 -->
									<c:if test="${authUser.no == rboardList.uno}">
										<td><a href="${pageContext.request.contextPath}/rboard/delete?bno=${rboardList.bno}&uno=${authUser.no}">[삭제]</a></td>
									</c:if>

								</tr>
							
							</tbody>
							
							</c:forEach>
							
						</table>
			
						<div id="paging">
							<ul>
								<li><a href="">◀</a></li>
								<li><a href="">1</a></li>
								<li><a href="">2</a></li>
								<li><a href="">3</a></li>
								<li><a href="">4</a></li>
								<li class="active"><a href="">5</a></li>
								<li><a href="">6</a></li>
								<li><a href="">7</a></li>
								<li><a href="">8</a></li>
								<li><a href="">9</a></li>
								<li><a href="">10</a></li>
								<li><a href="">▶</a></li>
							</ul>
							
							
							<div class="clear"></div>
						</div>
						<c:choose>
							<c:when test="${empty sessionScope.authUser}">
								<td>글쓰기 하려면 로그인하세요</td>
							</c:when>
							<c:otherwise>
								<a id="btn_write" href="${pageContext.request.contextPath}/rboard/writeForm">글쓰기</a>
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