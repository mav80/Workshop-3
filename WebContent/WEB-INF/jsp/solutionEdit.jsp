<%@ page language="java" contentType="text/html; charset=8859_2"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="fragments/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2">
<title>Edycja rozwiązania</title>
</head>
<body>
<h1>Szczegóły rozwiązania wybranego zadania:</h1>
${solution.description}<br><br>


<h3>Zmień to rozwiązanie</h3><br>

<form method="post">
Teść rozwiązania: <input type="textarea" name ="description" value="${solution.description}"><br><br>
<input type="hidden" name ="users_id" value="${solution.users_id}">
<input type="hidden" name="id" value="${solution.id}">
<input type="hidden" name ="created" value="${solution.created}">
<input type="hidden" name="updated" value="${solution.updated}">
<input type="hidden" name="exercise_id" value="${solution.exercise_id}">
<input type="submit" value="Zapisz">
</form>

</body>
</html>
<%@ include file="fragments/footer.jsp"%>