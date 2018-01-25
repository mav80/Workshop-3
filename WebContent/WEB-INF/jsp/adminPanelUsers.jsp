<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="fragments/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Panel administratora - użytkownicy</title>
</head>
<body>
<h1>Panel administratora - użytkownicy</h1>
<table>
<tr>
<td>Nazwa użytkownika</td>
<td>Email</td>
<td>Numer grupy do której należy</td>
<td>Akcje</td>
</tr>

<c:forEach items="${users}" var="user">
<tr>
<td>${user.username}</td>
<td>${user.email}</td>
<td>${user.person_group_id}</td>
<td><a href="usersEdit?id=${user.id}">Edytuj</a></td>
<td><a href="usersDelete?id=${user.id}">Usuń</a></td>
</tr>
</c:forEach>

</table>

<br><a href="usersEdit?id=-1">Utwórz nowego użytkownika</a>
</body>
</html>
<%@ include file="fragments/footer.jsp"%>