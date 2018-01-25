<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="fragments/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Panel administratora - użytkownicy</title>
</head>
<body>
<h1>Panel administratora - edycja użytkownika</h1>
<h3>${message}</h3>

<form method="post">
Nazwa: 	  <input type="text" name ="username" value="${user.username}"><br>
Email: 	  <input type="text" name ="email" value="${user.email}"><br>
Hasło: 	  <input type="text" name ="password" value="${user.password}"><br>
Id grupy: <input type="number" name ="person_group_id" value="${user.person_group_id}"><br><br>
<input type="hidden" name="id" value="${user.id}">
<input type="submit" value="${buttonMessage}">

</form>

</body>
</html>
<%@ include file="fragments/footer.jsp"%>