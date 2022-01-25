<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- el jstl 구동하기 위한 코드 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="header" class="clearfix">
	<h1>
		<a href="http://localhost:8088/mysite4/">MySite4</a>
	</h1>

	<!-- choose 사이에 주석 달면 에러 주의. -->

	<c:choose>
		<c:when test="${empty sessionScope.authUser}">
			<!-- 세션 영역에 값이 없으면 로그인 실패, 로그인 전에 사용 -->
			<ul>
				<li><a href="${pageContext.request.contextPath}/user/loginForm" class="btn_s">로그인</a></li>
				<li><a href="${pageContext.request.contextPath}/user/joinForm" class="btn_s">회원가입</a></li>
			</ul>
		</c:when>

		<c:otherwise>
			<!-- 로그인 성공시 출력 -->
			<ul>
				<!-- 세션에서 갱신한 이름을 가져와보자 -->
				<li>${sessionScope.authUser.name}님 로그인했습니다 (ID:${sessionScope.authUser.id})</li>
				<!-- sessionScope.authUser.name 에서 sessionScope 생략가능 -->
				<li><a href="${pageContext.request.contextPath}/user/logout" class="btn_s">로그아웃</a></li>
				<li><a href="${pageContext.request.contextPath}/user/modifyForm?no=${authUser.no}" class="btn_s">회원정보수정</a></li>
			</ul>
		</c:otherwise>
	</c:choose>

</div>

<div id="nav">
	<ul class="clearfix">
		<li><a href="">입사지원서</a></li>
		<li><a href="${pageContext.request.contextPath}/board/list">게시판</a></li>
		<li><a href="">갤러리</a></li>
		<li><a href="${pageContext.request.contextPath}/guestbook/addList">방명록</a></li>
	</ul>
</div>


