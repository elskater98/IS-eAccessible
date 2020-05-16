<%@page import="backend.Incidencia"%>
<%@page import="backend.TipusIncidencia"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Incidencies</title>
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

 <%
Incidencia [] in = null;
 try {
         backend.BackendServiceLocator serviceLocator = new backend.BackendServiceLocator();
         backend.Backend port = serviceLocator.getBackendPort();
         in=port.getAllIncidencia();

    }catch(Exception ex) {
        ex.printStackTrace();
    }
%>
<div style="margin-bottom: 1%">
<a style="font-size:20px" href="index.html">Inici</a>
</div>

<table>
  <tr>
    <th>Codi Incidencia</th>
    <th>Data</th>
    <th>Data i Hora</th>
    <th>Descripcio Incidencia</th>

  </tr>

<%for (int i=0; i<in.length; i++){
    String res="";
      try {
              backend.BackendServiceLocator serviceLocator = new backend.BackendServiceLocator();
              backend.Backend port = serviceLocator.getBackendPort();
              res=port.getTipusIncidencia(in[i].getCodiTipusIncidencia()).getDescripcio();

         }catch(Exception ex) {
             ex.printStackTrace();
         }
%>
<tr>
<td><%=in[i].getCodiIncidencia()%></td> 
<td><%=in[i].getData()%></td> 
<td><%=in[i].getDataHora()%></td>
<td> <%=res%></td>
</tr>

<%} %>
</table>

</body>
</html>