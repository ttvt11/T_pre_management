<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>회원등록</title>
</head>
<body>
<h1>
	회원가입
</h1>
	<form action="reguser">
		아이디 :
		<input type="text" name="id" required="required"><br>
		패스워드 :
		<input type="password" name="password" required="required"><br>
		EMAIl : 
		<input type="text" name="email1" required="required"> @ <input type="text" name="email2" required="required"><br>
		
	
		<input type="submit" value="회원가입">
		<br>
		<input type="button" value="홈" onclick="location.href='/manage'">
	</form>


</body>
</html>