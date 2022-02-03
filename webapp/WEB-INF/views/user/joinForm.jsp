<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.12.4.js"> </script>
<!-- 부트스트랩 제이쿼리 아래 위치한다 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.js"> </script>

</head>

<body>
	<div id="wrap">

		<!-- //header -->

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		<!-- //nav -->

		<div id="container" class="clearfix">
			<div id="aside">
				<h2>회원</h2>
				<ul>
					<li>회원정보</li>
					<li>로그인</li>
					<li>회원가입</li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">
			
				<div id="content-head">
					<h3>회원가입</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>회원</li>
							<li class="last">회원가입</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				
				
				<%-- <div id="user2">
					<div id="joinForm2">
						<form action="joinIdCheck" method="get">
	
							<!-- 아이디 -->
							<!-- http://localhost:8088/mysite4/user/joinIdCheck?idCheck=ddd -->
							<div class="form-group">
								<label class="form-text" for="input-uid">아이디</label> 
								<input type="text" id="input-uid" name="idCheck" value="" placeholder="아이디를 입력하세요" autofocus>
								<!-- input 태그 쓰기 금지 readonly disabled - disabled 는 데이터전송안됨 --> 
								<button type="submit" id="idDuplication">중복체크</button>
								<!-- <button type="button" id="idDuplication">중복체크</button> -->
								<input type="text" name="idcheckresult" value="id: ${idCheck.id }">
							</div>
							
							<!-- 버튼영역 -->
							<div class="button-area">
								<button type="submit" id="btn-submit">아이디 체크</button>
							</div>
							
						</form>
					</div>
				</div> --%>
				
										
				<!-- //content-head -->
	
				<div id="user">
					<div id="joinForm">
						<form action="join" method="get">
	
							<!-- 아이디 -->
							<div class="form-group">
								<label class="form-text" for="input-uid">아이디</label> 
								<input type="text" id="input-uid" name="id" value="" placeholder="아이디를 입력하세요" autofocus>
								<!-- input 태그 쓰기 금지 readonly disabled - disabled 는 데이터전송안됨 --> 
								<button type="button" id="idDuplication">중복체크</button>
							</div>
							
							<!-- 비밀번호 -->
							<div class="form-group">
								<label class="form-text" for="input-pass">패스워드</label> 
								<input type="text" id="input-pass" name="password" value="" placeholder="비밀번호를 입력하세요"	>
							</div>
	
							<!-- 이메일 -->
							<div class="form-group">
								<label class="form-text" for="input-name">이름</label> 
								<input type="text" id="input-name" name="name" value="" placeholder="이름을 입력하세요">
							</div>
	
							<!-- //나이 -->
							<div class="form-group">
								<span class="form-text">성별</span> 
								
								<label for="rdo-male">남</label> 
								<input type="radio" id="rdo-male" name="gender" value="male" checked> 
								
								<label for="rdo-female">여</label> 
								<input type="radio" id="rdo-female" name="gender" value="female" > 
	
							</div>
	
							<!-- 약관동의 -->
							<div class="form-group">
								<span class="form-text">약관동의</span> 
								
								<input type="checkbox" id="chk-agree" value="" name="agree">
								<label for="chk-agree">서비스 약관에 동의합니다.</label> 
							</div>
							
							<!-- 버튼영역 -->
							<div class="button-area">
								<button type="button" id="btn-submit">회원가입</button>
								<!-- <button type="submit" id="btn-submit">회원가입</button> -->
							</div>
							
						</form>
					</div>
					<!-- //joinForm -->
				</div>
				<!-- //user -->
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

$("#btn-submit").on("click", function() {
	console.log("회원가입 버튼 클릭 ");
	
	var id = $("#input-uid").val();
	var pw = $("#input-pass").val();
	
	if (id == "" ) {
		alert("아이디를 입력해주세요.");
		$().submit(); 
		// return false; // 하던일 멈춰 stop 
	} 
	if (pw == "" ) {
		alert("비밀번호를 입력해주세요.");
		$().submit(); 
		// return false; // 하던일 멈춰 stop
	}
	
}); // btn-submit click function

</script>


</html>