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
		<h1>메인 페이지</h1>
		<hr>
	</div>

   	<div id="head2" style="height: 100px; width: 100%; text-align: right; ">
   	<span>근태관리 웹 사이트</span><br>
           <a class="btn" href="movelogin">로그인</a><br>
           <!-- <a href="wbslogoutcheck">로그아웃</a><br> -->
           <a class="btn" href="movereguser">회원가입</a><br>
           <a class="btn" href="movewbs">나의근태관리</a><br>
   	<hr>
   	</div>
		흠..웹 담당하실분?
	<div>
	</div>
</body>
</html>