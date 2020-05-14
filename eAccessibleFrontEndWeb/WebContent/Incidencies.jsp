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


<hr>
Codi Incidencia, Data, DataHora, Tipus Incidencia
</hr>
<ul>
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
<hr>
<li><%=in[i].getCodiIncidencia()%> - <%=in[i].getData()%> - <%=in[i].getDataHora()%> - <%=res%></li>
</hr>

<%} %>
</ul>

</body>
</html>