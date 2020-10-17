<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>KIMSCHOOL WBSTEST</title>
</head>
<body>

<h1>KIMSCHOOL 근태관리 </h1><br>

	<div>
		<c:forEach items="${userInfos}" var = "u">
		<span>이름 : ${u.name}</span><br>
		<span>사원번호 : ${u.u_no}</span><br>
		</c:forEach>
	</div>
<br>
	<div>
		<c:forEach items="${workplaceInfo}" var = "u">
		<span>근무장소 : ${u.wp_name}</span><br>
		<span>최소 : ${u.min_time}시간 </span><br>
		<span>최대 : ${u.max_time}시간 </span><br>
		</c:forEach>
	</div>
<br>
	<div>
		<table border="1" >
			<tr style="background-color: lightblue">
				<th colspan="1">날짜</th>
				<th colspan="1">시작시간</th>
				<th colspan="1">종료시간</th>
				<th colspan="1">휴계시간</th>
				<th colspan="1">휴일구분</th>
				<th colspan="3">메모</th>
			</tr>
			<c:forEach items="${wbsInfo2020}" var = "w">
			<tr>
				<td>${w.date}</td><td>${w.start_time}</td><td>${w.end_time}</td><td>${w.rest_time}</td><td>${w.vacation_type}</td><td>${w.memo}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<div>
	<input type="button" value="돌아가기" onclick="location.href='/manage'">
	<input type="button" value="수정"> 
	</div>
</body>
</html>