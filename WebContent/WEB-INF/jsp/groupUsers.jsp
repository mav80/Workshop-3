<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="fragments/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Użytkownicy w grupie</title>
</head>
<body>
<h1>Oto wszyscy użytkownicy w grupie</h1>

<table>
<tr>
<td>Imię</td>
<td>Akcje</td>
</tr>

<c:forEach items="${users}" var="user">
<tr>
<td>${user.username}</td>
<td><a href="userDetails?id=${solution.id}">Szczegóły</a></td>
</tr>
</c:forEach>

</table>



</body>
</html>
<%@ include file="fragments/footer.jsp"%>
