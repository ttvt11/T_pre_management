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

<form:form modelAttribute="Wbs" action="updatewbs">
<table border=1>
	<tr style="background-color: lightblue">
		<th>日付<th>開始時間</th><th>終了時間</th><th>合計時間</th><th>休日区分</th><th>メモ</th>
	<c:forEach var="wbs" items="${wbsinfo.wbslist }">
	<tr>
		<td style="color:${wbs.dayColor }">${wbs.date }${wbs.day }</td>
		<%-- <td>
			<form:select path="start_h" value="${wbs.start_h}">
				<c:forEach begin="0" end="23" varStatus="i">
					<c:choose>
					<c:when test="${i.index == wbs.start_h}">
						<option selected="selected"><fmt:formatNumber value="${i.index }" pattern="00"></fmt:formatNumber></option>
					</c:when>
					<c:otherwise>
						<option><fmt:formatNumber value="${i.index }" pattern="00"></fmt:formatNumber></option>
					</c:otherwise>
			${wbs.start_h }시 ${wbs.start_m }분
					</c:choose>
				</c:forEach>
			</form:select>시
			<form:select path="start_m" value="${wbs.start_m}">
				<c:forEach begin="0" end="59" step="15" varStatus="i">
					<c:choose>
					<c:when test="${i.index == wbs.start_m}">
						<option selected="selected"><fmt:formatNumber value="${i.index }" pattern="00"></fmt:formatNumber></option>
					</c:when>
					<c:otherwise>
						<option><fmt:formatNumber value="${i.index }" pattern="00"></fmt:formatNumber></option>
					</c:otherwise>
					${wbs.start_h }시 ${wbs.start_m }분
					</c:choose>
				</c:forEach>
			</form:select>분
		</td>
		<td>
			<form:select path="end_h" value="${wbs.end_h}">
				<c:forEach begin="0" end="23" varStatus="i">
					<c:choose>
					<c:when test="${i.index == wbs.end_h}">
						<option selected="selected"><fmt:formatNumber value="${i.index }" pattern="00"></fmt:formatNumber></option>
					</c:when>
					<c:otherwise>
						<option><fmt:formatNumber value="${i.index }" pattern="00"></fmt:formatNumber></option>
					</c:otherwise>
					</c:choose>
				</c:forEach>
			</form:select>시
			<form:select path="end_m" value="${wbs.end_m}">
				<c:forEach begin="0" end="59" step="15" varStatus="i">
					<c:choose>
					<c:when test="${i.index == wbs.end_m}">
						<option selected="selected"><fmt:formatNumber value="${i.index }" pattern="00"></fmt:formatNumber></option>
					</c:when>
					<c:otherwise>
						<option><fmt:formatNumber value="${i.index }" pattern="00"></fmt:formatNumber></option>
					</c:otherwise>
					${wbs.start_h }시 ${wbs.start_m }분
					</c:choose>x`
				</c:forEach>
			</form:select>분
		</td>
		<td>
			${wbs.total_h }시간
		</td>
        <td>
			<form:select path="vacation_type" value="${wbs.vacation_type}">
     	        <c:forEach begin="0" end="4" varStatus="i">
	               <c:choose>
		               <c:when test="${i.index == wbs.vacation_type }">
							<option selected="selected">${i.index}</option>
		               </c:when>
		               <c:otherwise>
							<option>${i.index}</option>
		               </c:otherwise>
	               </c:choose>
	         	</c:forEach>
           	</form:select>
        </td> 
      <td>
			<select>
               <option value="0" <c:if test="${wbs.vacation_type == 0}"> selected="selected"</c:if>></option>
               <option value="1" <c:if test="${wbs.vacation_type == 1}"> selected="selected"</c:if>>오전휴가</option>
               <option value="2" <c:if test="${wbs.vacation_type == 2}"> selected="selected"</c:if>>오후휴가</option>
               <option value="3" <c:if test="${wbs.vacation_type == 3}"> selected="selected"</c:if>>종일휴가</option>
               <option value="4" <c:if test="${wbs.vacation_type == 4}"> selected="selected"</c:if>>조퇴휴가</option>
            </select>
      </td>

		<td>
			<form:input path="memo" value="${wbs.memo }"></form:input>
		</td>
		
		<form:hidden path="process" value="${wbs.process }"></form:hidden> --%>
	</tr>
	</c:forEach>

</table>
<br>

<input type = "button" value = "등록">
</form:form>



</body>
</html>