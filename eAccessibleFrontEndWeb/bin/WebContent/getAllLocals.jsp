<%@page import="backend.Local"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Locals</title>
</head>
<body>

 <%
Local [] local = null;
 try {
         backend.BackendServiceLocator serviceLocator = new backend.BackendServiceLocator();
         backend.Backend port = serviceLocator.getBackendPort();
         local=port.getAllLocals();

    }catch(Exception ex) {
        ex.printStackTrace();
    }
%>
<hr>
Nom Local, Via, Carrer, Nº
</hr>
<ul>
<%for (int i=0; i<local.length; i++){%>
<hr>
<li><%=local[i].getNomLocal()%> - <%=local[i].getNomVia()%> - <%=local[i].getNomCarrer()%> - <%=local[i].getNumero()%> <a href="jGetLocal?codiLocal=<%=local[i].getCodiLocal()%>">Detail</a></li>
</hr>

<%} %>
</ul>


</body>
</html>