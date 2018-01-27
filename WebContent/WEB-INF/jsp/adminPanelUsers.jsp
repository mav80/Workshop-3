<%@ page language="java" contentType="text/html; charset=8859_2"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="fragments/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2">
<title>Panel administratora - u�ytkownicy</title>
</head>
<body>
<h1>Panel administratora - u�ytkownicy</h1>
<table>
<tr>
<td>Nazwa u�ytkownika</td>
<td>Email</td>
<td>Numer grupy do kt�rej nale�y</td>
<td>Akcje</td>
</tr>

<c:forEach items="${users}" var="user">
<tr>
<td>${user.username}</td>
<td>${user.email}</td>
<td>${user.person_group_id}</td>
<td><a href="usersEdit?id=${user.id}">Edytuj</a></td>
<td><a href="usersDelete?id=${user.id}">Usu�</a></td>
</tr>
</c:forEach>

</table>

<br><a href="usersEdit?id=-1">Utw�rz nowego u�ytkownika</a>
</body>
</html>
<%@ include file="fragments/footer.jsp"%>