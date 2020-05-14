<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>

<h1 style="color: red"><%=request.getParameter("error")%></h1>
<a href="index.html">Inici</a>
</body>
</html>