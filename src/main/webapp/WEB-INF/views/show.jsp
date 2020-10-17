<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form action="show" modelAttribute="invo" method="post">
   <form:input path="addr"/><br>
    <c:forEach items="${invo.userInfoList}" var="user" varStatus="i">
       ${user.name }<br>
      <form:input path="userInfoList[${i.index}].name"/><br>
      <form:select path="userInfoList[${i.index}].opt1" items="${list1}"/><br>
   </c:forEach>
   <input type="submit" value="send">
</form:form>

</body>
</html>