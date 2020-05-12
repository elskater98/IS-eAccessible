<%@page import="backend.Caracteristica"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add full accessibilitat</title>
</head>
<body>

<form method="post" action="sAddFullAccessibilitat">
 
 <%
backend.Local local = null;
 Caracteristica[] ca = null;
 try {
         backend.BackendServiceLocator serviceLocator = new backend.BackendServiceLocator();
         backend.Backend port = serviceLocator.getBackendPort();
         local=port.getLocal(Integer.parseInt(request.getParameter("codiLocal")));
         ca = port.getCaracterisitcaTipus(local.getCoditipoLocal());
         

    }catch(Exception ex) {
        ex.printStackTrace();
    }
%>
<select name="codiLocal">
<option value="<%=local.getCodiLocal()%>"><%=local.getNomLocal()%></option>
</select>
 
  <div>
 <label>Caracterisitca</label>
 <select name="codiCaracteristica">
<%for (int i=0; i<ca.length; i++){%>
    <option value="<%=ca[i].getCodiCaracteristica()%>"> <%=ca[i].getNomCaracteristicaCA()%></option>
<%} %>
</select>
 </div>
 
<div>
<input type="number" min=0 max=5 name="valor">
</div>

<div>
<select name="verificat">
<option value="N">NO</option>
<option value="S">SI</option>
</select>

</div>
	<a href="jGetLocal?codiLocal=<%=local.getCodiLocal()%>">Detail</a>
	<button type="submit">Add Caracteristica</button>
</form>
</body>
</html>