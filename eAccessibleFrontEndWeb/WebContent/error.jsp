<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="backend.Local"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
 <%
 Local local = null;
 
 try {
	 	 backend.BackendServiceLocator serviceLocator = new backend.BackendServiceLocator();
         backend.Backend port = serviceLocator.getBackendPort();
         local = port.getLocal(Integer.parseInt(request.getParameter("codiLocal"))); 
         
    }catch(Exception ex) {
        ex.printStackTrace();
    }
%>

<h1 style="color: red"><%=request.getParameter("error")%></h1>
<a href="index.html">Inici</a>
<a style="margin-left: 1%" href="jGetLocal?codiLocal=<%=local.getCodiLocal()%>">Detall del local</a>

</body>
</html>