<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteForm</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">

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
					<li>일반방명록</li>
					<li>ajax방명록</li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">
			
				<div id="content-head">
					<h3>일반방명록</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>방명록</li>
							<li class="last">일반방명록</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->
	
				<div id="guestbook">
					<form action="/mysite4/guestbook/delete" method="get">
						<table id="guestDelete">
							<colgroup>
								<col style="width: 10%;">
								<col style="width: 40%;">
								<col style="width: 25%;">
								<col style="width: 25%;">
							</colgroup>
							<tr>
								<td>${param.no}번 비밀번호 <input type="hidden" name=no value="${param.no}"></td>
								<td><input type="password" name="password"></td>
								<td class="text-left"><button type="submit">삭제</button></td>
								<td><a href="${pageContext.request.contextPath}/guestbook/addList">[목록으로 돌아가기]</a></td>
							</tr>
						</table>
						<!-- <input type='hidden' name="" value="">
						<input type='hidden' name="" value=""> -->
					</form>
					
				</div>
				<!-- //guestbook -->
			</div>
			<!-- //content  -->

		</div>
		<!-- //header -->

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		<!-- //nav -->

	</div>
	<!-- //wrap -->

</body>

</html>
