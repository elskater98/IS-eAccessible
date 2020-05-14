<%@page import="backend.Local"%>
<%@page import="backend.Caracteristica"%>
<%@page import="backend.Accessibilitat"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Full Accessibilitat</title>
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
 Local local = null;
 Accessibilitat [] ac = null;
 try {
	 	 backend.BackendServiceLocator serviceLocator = new backend.BackendServiceLocator();
         backend.Backend port = serviceLocator.getBackendPort();
         local = port.getLocal(Integer.parseInt(request.getParameter("codiLocal")));
         ac = port.getAccessibilitatByLocalId(Integer.parseInt(request.getParameter("codiLocal")));
         String codiLocal =request.getParameter("codiLocal");
         if(ac==null){
        	 response.sendRedirect("/eAccessibleFrontEndWeb/error.jsp?error=El local no disposa de full d'accessibilitat.&codiLocal="+codiLocal);
        	 
        	 
         }
    }catch(Exception ex) {
        ex.printStackTrace();
    }
%>
 <div style="font-size:20px; margin-bottom: 1%;margin-top: 1%">
 	<a style="font-size:20px;" href="jGetLocal?codiLocal=<%=local.getCodiLocal()%>">Detall del local</a>
 </div>
 
<table>
  <tr>
    <th>Caracteristica</th>
    <th>Valor</th>
    <th>Verificat</th>

  </tr>
  
  <%for (int i=0; i<ac.length; i++){%>
  <%
 Caracteristica ca =  null;
 try {
         backend.BackendServiceLocator serviceLocator = new backend.BackendServiceLocator();
         backend.Backend port = serviceLocator.getBackendPort();
         
         if(port.getCharacteristic(ac[i].getCodiCaracterisitca())!=null){
        	 ca = port.getCharacteristic(ac[i].getCodiCaracterisitca());
         }else{
        	 ca.setNomCaracteristicaCA("null");
         }

    }catch(Exception ex) {
        ex.printStackTrace();
    }
%>
  <tr>
    <td><%=ca.getNomCaracteristicaCA()%></td>
     <td><%=ac[i].getValor()%></td>
     <td><%=ac[i].getVerificat()%></td>
  </tr>
  <%} %>
</table>



</body>
</html>