<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
<title>KIMSCHOOL ||  WBS</title>
</head>
<body>


<fieldset style="width: 300px;">
	<legend>
		KIMSCHOOL 勤怠管理
	</legend>

	<table border=1>
		<tr>
			<th style="background-color: lightblue;">社員名</th><td>${wbsinfo.u_name}</td>
		</tr>
		<tr>
			<th style="background-color: lightblue;">社員番号</th><td>${wbsinfo.u_no}</td>
		</tr>
	</table>

	<br>

	<table border=1>
		<tr>
			<th style="background-color: lightblue;">勤務日合計</th><td>17日</td>
		</tr>
		<tr>
			<th style="background-color: lightblue;">勤務時間合計</th><td>134時間</td>
		</tr>
	</table>

	<br>

	<table border=1>
		<tr>
			<th style="background-color: lightblue;">最低勤務時間</th><td>${wbsinfo.min_time}</td>
		</tr>
		<tr>
			<th style="background-color: lightblue;">最大勤務時間</th><td>${wbsinfo.max_time}</td>
		</tr>
	</table>
</fieldset>

<br>

<table border=1>
	    <h1>
	    <a href="getwbsinfo?date=${date }&u_no=${wbsinfo.u_no }&mod=pre">&lt;</a> ${date }
	    <a href="getwbsinfo?date=${date }&u_no=${wbsinfo.u_no }&mod=next">&gt;</a>
	    </h1>

		<tr style="background-color: lightblue">
			<th>日付<th>開始時間</th><th>終了時間</th><th>合計時間</th><th>休日区分</th><th>メモ</th>
		</tr>
		<form:form modelAttribute="wbsinfo" action="updatewbs">
			<input type="hidden" name="u_no" value="${wbsinfo.u_no }">
			<%-- <form:hidden path="${wbsinfo.u_no }"/> --%>
		<c:forEach var="wbs" items="${wbsinfo.wbslist }" varStatus="i">
			<tr>
				<td style="color:${wbs.dayColor }">${wbs.date }${wbs.day }</td>
				<form:hidden path="wbslist[${i.index}].date"/>
				<td><form:select path="wbslist[${i.index}].start_h">
					<form:options items="${hours }"/>
					</form:select>
					:
					<form:select path="wbslist[${i.index}].start_m">
					<form:options items="${minutes }"/>
					</form:select>
				</td>
				<td><form:select path="wbslist[${i.index}].end_h">
					<form:options items="${hours }"/>
					</form:select>
					:
					<form:select path="wbslist[${i.index}].end_m">
					<form:options items="${minutes }"/>
					</form:select>
				</td>
				<td>${wbs.total_h }</td>
				<td><form:select path="wbslist[${i.index}].vacation_type">
					<form:options items="${vacationCode }"/>
					</form:select>
				</td>
				<td><form:input size="20px" path="wbslist[${i.index}].memo"/></td>
				<td>${wbs.process }</td>
			</tr>
		</c:forEach>
		<input type="submit" value="등록"/>
	</form:form>
	</table>
<br>
</body>
</html>