<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>KIMSCHOOL | 사원관리 시스템</title>
	<script type="text/javascript">
		function check1(msg1) {
			alert(msg1 +"+"+ "1")
		}
		
		function check2() {
			alert("check2마우스업")
		}
		
		function check3msginput() {
			var i = document.getElementById('msg2').innerHTML;
					document.getElementById('msg2').innerHTML = i + "메세지를 삽입했습니다." + "<br>"
		}
		
			var no = 0
		function addline() {
				no++
			var tb1 = document.getElementById('tb1').innerHTML;
					document.getElementById('tb1').innerHTML = tb1 + "<tr><td>"+no+"</td><td>KIM</td><td>10</td></tr>"
		}

	</script>
</head>
<body>
	<div>
		<input type="button" value="add" onclick="addline()">
		<table border="1">
			<thead>
				<tr>
					<th>no</th><th>name</th><th>count</th>
				</tr>
			</thead>
				<tbody id="tb1">
				</tbody>
		</table>
	</div>
<br><br>
<div id="msg2"></div>
<br><br>
<input type="button" onclick="check1('hello')" value="check1">
<input type="text" onmouseover="check2()" value="check2">
<input type="button" onclick="check3msginput()" value="check3">
<br>
<h1>사원 로그인</h1>
	
	<form action="wbslogincheck">
		사원번호 : <br>
		<input type="text" name="u_no" maxlength="9"><br>
		패스워드 :<br>
		<input type="password" name="u_password" maxlength="10"><br>
		<input type="submit" value="로그인"><br>
	</form>
		<input type="button" value="회원가입"><br>
	
<!-- 	<form action="logincheck">
		아이디 :
		<input type="text" name="id"><br>
		패스워드 :
		<input type="password" name="password"><br><br>
		<input type="submit" value="로그인">
	</form>

<a href="movereguser">Don't you have Account?</a><br>
<a href="movefindpassword">Forgot your password?</a> -->

</body>
</html>