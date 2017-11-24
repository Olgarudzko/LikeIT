<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>List of Users</title>
</head>
<body>
<c:if test="${requestScope.users != null}">
<table border='1'>
<tr>
<td><c:out value="Login"/></td>
<td><c:out value="Role"/></td>
<td><c:out value="Rating"/></td>
</tr>
<c:forEach items="${requestScope.users}" var="user">
  <tr>
  <td><c:out value="${user.login}"/></td>
  <td><c:out value="${user.roleValue}"/></td>
  <td><c:out value="${user.rating}"/></td>
  </tr>
</c:forEach>
</table>
</c:if>
</body>
</html>