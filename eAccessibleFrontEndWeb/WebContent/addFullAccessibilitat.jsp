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
<h1>Incloure noves caracteristiques a "<%=local.getNomLocal()%>"</h1>
<select hidden="true" name="codiLocal">
<option value="<%=local.getCodiLocal()%>"><%=local.getNomLocal()%></option>
</select>
 
  <div>
 <label><b>Caracterisitca</b> </label>

<%for (int i=0; i<ca.length; i++){%>
<div>
<input name="caracterisitca_<%=i%>" type="checkbox" id="cbox" value="<%=ca[i].getCodiCaracteristica()%>"><%=ca[i].getNomCaracteristicaCA()%>
 <label><b>Valor:</b> </label>
<input type="number" value=0 min=0 max=5 name="valor_<%=i%>">

 <label><b>Verficat:</b> </label>
<select name="verificat_<%=i%>">
<option value="N">NO</option>
<option value="S">SI</option>
</select>
</div>

<%} %>

 </div>
 

<div style="margin-top:1%">
<a href="jGetLocal?codiLocal=<%=local.getCodiLocal()%>">Detall del local</a>
	<button style="margin-left: 1%" button type="submit">Incloure caracteristica</button>
</div>
	
</form>
</body>
</html>