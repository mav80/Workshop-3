<%@ page language="java" contentType="text/html; charset=8859_2"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="fragments/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2">
<title>Szczegóły rozwiązania</title>
</head>
<body>
<h1>Szczegóły rozwiązania wybranego zadania:</h1>
${solution.description}<br><br>

<a href="solutionEdit?id=${solution.id}">Edytuj to rozwiązanie</a>

</body>
</html>
<%@ include file="fragments/footer.jsp"%>