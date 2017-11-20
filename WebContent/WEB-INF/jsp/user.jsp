<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Profile</title>
</head>
<body>
<c:if test="${requestScope.user != null}">
<c:set var="person" scope="request" value="${requestScope.user}"/>
<table border='1'>
<tr>
<td><c:out value="Login"/></td>
<td><c:out value="Password"/></td>
<td><c:out value="Rating"/></td>
</tr>
<tr>
<td><c:out value="${person.login}"/></td>
<td><c:out value="${person.password}"/></td>
<td><c:out value="${person.rating}"/></td>
</tr>
</table>
</c:if>
<c:if test="${requestScope.user == null}">
<h2>No such user</h2>
</c:if>
</body>
</html>