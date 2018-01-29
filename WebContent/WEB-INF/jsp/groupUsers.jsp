<%@ page language="java" contentType="text/html; charset=8859_2"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="fragments/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2">
<title>Użytkownicy w grupie</title>
</head>
<body>
<h1>Oto wszyscy użytkownicy grupy ${groupName}</h1>

<table>
<tr>
<th>Imię</th>
<th>Akcje</th>
</tr>

<c:forEach items="${users}" var="user">
<tr>
<td>${user.username}</td>
<td><a href="userSolutions?id=${user.id}">Pokaż dane tego użytkownika i jego rozwiązania</a></td>
</tr>
</c:forEach>

</table>



</body>
</html>
<%@ include file="fragments/footer.jsp"%>
