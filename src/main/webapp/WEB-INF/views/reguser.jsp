<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <!-- 부트스트랩 CSS 추가하기 -->
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <!-- 커스텀 CSS 추가하기 -->
    <link rel="stylesheet" href="./css/custom.css">

	<title>KIMSCHOOL | 팀프로젝트원</title>

	<!-- 자바스크립트 -->
	<script type="text/javascript">
	</script>

	<!-- css -->
	<style type="text/css">
	#head2 a:link {text-decoration:none; color :Blue}
	#head2 a:visited {text-decoration:none; color :Blue}

	.btn{
	}
	</style>

</head>
<body>
	<div id="head1" style="height: 100px; width: 100%; text-align: left; ">
		<h1>회원등록 페이지</h1>
		<hr>
	</div>

   	<div id="head2" style="height: 100px; width: 100%; text-align: left; ">
   		<span>근태관리 웹 사이트</span><br><br>
			<form action="reguser" method="post">
				아이디 :
				<input type="text" name="id" required="required" placeholder="아이디를 입력해주세요" maxlength="10"><br>
				패스워드 :
				<input type="password" name="password1" required="required" placeholder="비밀번호를 입력해주세요" maxlength="20"><br>
				패스워드 확인 :
				<input type="password" name="password2" required="required" placeholder="비밀번호를 입력해주세요" maxlength="20"><br>
				이름 :
				<input type="text" name="name" required="required" placeholder="성함를 입력해주세요" maxlength="20"><br>
				성별 :
				남<input type="radio" name="gender" value="1" checked="checked">
				여<input type="radio" name="gender" value="2" ><br>
				EMAIl :
				<input type="text" name="email" placeholder="이메일를 입력해주세요"><br>
				주소 :
				<input type="text" name="address"  placeholder="주소를 입력해주세요" maxlength="100" size="100"><br>
				전화번호 :
				<input type="text" name="number"  placeholder="전화번호를 입력해주세요"><br>
				입사날짜 :
				<input type="text" name="joindate"  placeholder="yyyymmdd형식으로 입력해주세요" maxlength="8"><br>

				<input type="submit" value="회원가입">
				<br>
				<input type="button" value="메인페이지로 돌아가기" onclick="location.href='/manage'">
			</form>
	</div>
</body>
</html>