<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="fragments/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin panel main</title>
</head>
<body>
<h1>Strona główna panelu admina</h1>
<a href="adminPanel/exercises">Lista zadań</a><br><br>
<a href="adminPanel/groups">Lista grup</a><br><br>
<a href="adminPanel/users">Lista użytkowników</a><br><br>
</body>
</html>
<%@ include file="fragments/footer.jsp"%>