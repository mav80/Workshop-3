<%@ page language="java" contentType="text/html; charset=8859_2"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="fragments/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2">
<title>Rozwi�zania u�ytkownika</title>
</head>
<body>
<h1>To jest widok rozwi�za� u�ytkownika</h1>

<h3>Dane u�ytkownika:</h3>
<h4>Nazwa: ${user.username}</h4>
<h4>Email: ${user.email}</h4>

<h3>Wszystkie rozwi�zania dodane przez u�ytkownika:</h3>

<table>
<c:forEach items="${solutions}" var="solution">
<tr>
<td>Numer zadania: ${solution.exercise_id}</td>
<td>Data dodania: ${solution.created}</td>
<td><a href="solutionDetails?id=${solution.id}">Szczeg�y rozwi�zania</a></td>
</tr>
</c:forEach>

</table>

</body>
</html>
<%@ include file="fragments/footer.jsp"%>