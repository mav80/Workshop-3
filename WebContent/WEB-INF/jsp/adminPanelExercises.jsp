<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="fragments/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Panel administratora - zadania</title>
</head>
<body>
<h1>Panel administratora - zadania</h1>
<table>
<tr>
<td>Nazwa zadania</td>
<td>Opis zadania</td>
<td>Akcje</td>
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