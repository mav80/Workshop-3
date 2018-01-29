<%@ page language="java" contentType="text/html; charset=8859_2"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2">


<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css">

<style>
table {
  border-collapse: collapse;
}
th, td {
  border: 1px solid black;
  padding: 10px 15px;
}
th {
  font-weight: bold;
}

table > tbody > tr:nth-of-type(odd) {
  background-color: #c9c9c9;
</style>

<script src="https://code.jquery.com/jquery-1.12.3.min.js"	integrity="sha256-aaODHAgvwQW1bFOGXMeX+pC4PZIPsvn2h1sArYOhgXQ="	crossorigin="anonymous"></script>
</head>
<body>
<menu>
<list class="list-inline">
<li><a href="<%out.print(request.getContextPath());%>">Strona główna</a></li>
<li><a href="<%out.print(request.getContextPath());%>/groups">Grupy</a></li>
<li><a href="<%out.print(request.getContextPath());%>/adminPanel">Panel administratora</a></li>
</list>
</menu>

</body>
</html>