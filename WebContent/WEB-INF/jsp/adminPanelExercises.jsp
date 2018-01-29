<%@ page language="java" contentType="text/html; charset=8859_2"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="fragments/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2">
<title>Panel administratora - zadania</title>
</head>
<body>
<h1>Panel administratora - zadania</h1>
<table>
<tr>
<th>Nazwa zadania</th>
<th>Opis zadania</th>
<th colspan="2">Akcje</th>
</tr>

<c:forEach items="${exercises}" var="exercise">
<tr>
<td>${exercise.title}</td>
<td>${exercise.description}</td>
<td><a href="exercisesEdit?id=${exercise.id}">Edytuj</a></td>
<td><a href="exercisesDelete?id=${exercise.id}">Usuń</a></td>
</tr>
</c:forEach>

</table>

<br><a href="exercisesEdit?id=-1">Utwórz nowe zadanie</a>
</body>
</html>
<%@ include file="fragments/footer.jsp"%>