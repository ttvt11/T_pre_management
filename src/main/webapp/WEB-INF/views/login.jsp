<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>

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
		<h1>로그인 페이지</h1>
		<hr>
	</div>

   	<div id="head2" style="height: 100px; width: 100%; text-align: right; ">
   		<span>근태관리 웹 사이트</span><br>
			<form action="wbslogincheck">
				사원번호 : <br>
				<input type="text" name="u_no" maxlength="9"><br>
				패스워드 :<br>
				<input type="password" name="u_password" maxlength="20"><br>
				<input type="submit" value="로그인"><br>
			</form>
		<input type="button" value="메인페이지로 돌아가기" onclick="location.href='/manage'"><br>
	</div>
</body>
</html>