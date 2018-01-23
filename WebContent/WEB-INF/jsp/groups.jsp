<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="fragments/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Widok grup</title>
</head>
<body>
<h1>Oto wszystkie znajdujące się w bazie grupy:</h1>

<table>
<tr>
<td>Nazwa grupy</td>
<td>Akcje</td>
</tr>

<c:forEach items="${groups}" var="group">
<tr>
<td>${group.groupName}</td>
<td><a href="groupUsers?id=${group.id}">Użytkownicy</a></td>
</tr>
</c:forEach>

</table>

</body>
</html>
<%@ include file="fragments/footer.jsp"%>