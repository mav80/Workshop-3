<%@ page language="java" contentType="text/html; charset=8859_2"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="fragments/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2">
<title>Strona g��wna</title>
</head>
<body>

<h2>Strona g��wna - 5 najnowszych rozwi�za�</h2>

<table>
<thead>
<tr>
<th>Tytu� zadania</th>
<th>Autor rozwi�zania</th>
<th>Data dodania</th>
<th>Akcje</th>
</tr>
</thead>

<c:forEach items="${solutions}" var="solution">
<tr>

<c:forEach items="${exercises}" var="exercise">
	<c:if test="${solution.exercise_id == exercise.id}">
		<td>${exercise.title}</td>
	</c:if>

</c:forEach>



<c:forEach items="${users}" var="user">
	<c:if test="${solution.users_id == user.id}">
		<td>${user.username}</td>
	</c:if>
</c:forEach>

<td>${solution.created}</td>
<td><a href="solutionDetails?id=${solution.id}">Szczeg�y rozwi�zania</a></td>
</tr>
</c:forEach>

</table>


</body>
</html>
<%@ include file="fragments/footer.jsp"%>
