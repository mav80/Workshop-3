<%@ page language="java" contentType="text/html; charset=8859_2"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="fragments/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2">
<title>Panel administratora - grupy</title>
</head>
<body>
<h1>Panel administratora - grupy</h1>
<table>
<tr>
<th>Nazwa grupy</th>
<th colspan="2">Akcje</th>
</tr>

<c:forEach items="${groups}" var="group">
<tr>
<td>${group.groupName}</td>
<td><a href="groupsEdit?id=${group.id}">Edytuj</a></td>
<td><a href="groupsDelete?id=${group.id}">Usuń</a></td>
</tr>
</c:forEach>

</table>

<br><a href="groupsEdit?id=-1">Utwórz nową grupę</a>
</body>
</html>
<%@ include file="fragments/footer.jsp"%>