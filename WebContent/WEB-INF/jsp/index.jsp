<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="fragments/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Strona główna</title>
</head>
<body>
<h1>To jest widok strony głównej</h1>

<table>

<tr>
<td>${solution.id}</td>
<td>${solution.created}</td>
<td>${solution.updated}</td>
<td>${solution.description}</td>
<td>${solution.exercise_id}</td>
<td>${solution.users_id}</td>
</tr>

</table>

${numberSolutions}

</body>
</html>
<%@ include file="fragments/footer.jsp"%>