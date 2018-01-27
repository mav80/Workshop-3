<%@ page language="java" contentType="text/html; charset=8859_2"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="fragments/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2">
<title>Strona główna</title>
</head>
<body>
<h1>To jest widok strony głównej - pokazuje 5 najnowszych rozwiązań</h1>

<table>
<tr>
<td>id</td>
<td>created</td>
<td>updated</td>
<td>description</td>
<td>exercise_id</td>
<td>users_id</td>
</tr>

<c:forEach items="${solutions}" var="solution">
<tr>
<td>${solution.id}</td>
<td>${solution.created}</td>
<td>${solution.updated}</td>
<td>${solution.description}</td>
<td>${solution.exercise_id}</td>
<td>${solution.users_id}</td>
<td><a href="solutionDetails?id=${solution.id}">Szczegóły rozwiązania</a></td>
</tr>
</c:forEach>

</table>



</body>
</html>
<%@ include file="fragments/footer.jsp"%>
