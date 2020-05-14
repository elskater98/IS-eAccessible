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

<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<div style="margin-bottom: 1%">
<a style="font-size:20px" href="index.html">Inici</a>
</div>


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

<table>
  <tr>
    <th>Local</th>
    <th>Carrer</th>
    <th>Numero</th>
    <th>Detall Local</th>
  </tr>
  
  <%for (int i=0; i<local.length; i++){%>
  <tr>
    <td><%=local[i].getNomLocal()%></td>
    <td><%=local[i].getNomVia()%> <%=local[i].getNomCarrer()%> </td>
    <td><%=local[i].getNumero()%></td>
    <td><a href="jGetLocal?codiLocal=<%=local[i].getCodiLocal()%>">Detail</a></td>
  </tr>
  <%} %>
</table>


</body>
</html>