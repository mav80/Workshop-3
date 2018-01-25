<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="fragments/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Panel administratora - grupy</title>
</head>
<body>
<h1>Panel administratora - edycja grupy</h1>
<h3>${message}</h3>

<form method="post">
<input type="text" name ="groupName" value="${group.groupName}"><br><br>
<input type="hidden" name="id" value="${group.id}">
<input type="submit" value="${buttonMessage}">

</form>

</body>
</html>
<%@ include file="fragments/footer.jsp"%>