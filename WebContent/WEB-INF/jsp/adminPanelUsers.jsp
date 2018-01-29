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
<thead>
<tr>
<th>Nazwa u�ytkownika</th>
<th>Email</th>
<th>Grupa kt�rej nale�y</th>
<th colspan="2">Akcje</th>
</tr>
</thead>
<c:forEach items="${users}" var="user">
<tr>
<td>${user.username}</td>
<td>${user.email}</td>


<c:forEach items="${groups}" var="group">
	<c:if test="${group.id == user.person_group_id}">
		<td>${group.groupName}</td>
	</c:if>
</c:forEach>

<td><a href="usersEdit?id=${user.id}">Edytuj</a></td>
<td><a href="usersDelete?id=${user.id}">Usu�</a></td>
</tr>
</c:forEach>

</table>

<br><a href="usersEdit?id=-1">Utw�rz nowego u�ytkownika</a>
</body>
</html>
<%@ include file="fragments/footer.jsp"%>