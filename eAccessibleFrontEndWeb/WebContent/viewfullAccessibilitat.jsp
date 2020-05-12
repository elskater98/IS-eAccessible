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
 <%
 Local local = null;
 Accessibilitat [] ac = null;
 try {
	 	 backend.BackendServiceLocator serviceLocator = new backend.BackendServiceLocator();
         backend.Backend port = serviceLocator.getBackendPort();
         local = port.getLocal(Integer.parseInt(request.getParameter("codiLocal")));
         ac = port.getAccessibilitatByLocalId(Integer.parseInt(request.getParameter("codiLocal")));
         if(ac==null){
        	 response.sendRedirect("/eAccessibleFrontEndWeb/error.jsp?error=El local no disposa de full d'accessibilitat.");
        	 
        	 
         }
    }catch(Exception ex) {
        ex.printStackTrace();
    }
%>

<ul>
<%for (int i=0; i<ac.length; i++){%>
<hr>
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
<li><%=ca.getNomCaracteristicaCA()%></li>
</hr>

<%} %>
</ul>

</body>
</html>