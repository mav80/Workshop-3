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
<h1>Panel administratora - edycja zadania</h1>
<h3>${message}</h3>

<form method="post">
Tytuł zadania: <input type="text" name ="title" value="${exercise.title}"><br><br>
Opis zadania: <input type="text" name ="description" value="${exercise.description}"><br><br>
<input type="hidden" name="id" value="${exercise.id}">
<input type="submit" value="${buttonMessage}">

</form>

</body>
</html>
<%@ include file="fragments/footer.jsp"%>