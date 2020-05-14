<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Verificar Local</title>
</head>
<body>
<form method="post" action="sVerificarLocal">
 
 <%
backend.Local local = null;

 try {
	 	 backend.BackendServiceLocator serviceLocator = new backend.BackendServiceLocator();
         backend.Backend port = serviceLocator.getBackendPort();
         local=port.getLocal(Integer.parseInt(request.getParameter("codiLocal")));
         
    }catch(Exception ex) {
        ex.printStackTrace();
    }
%>

<div>
<h1>Estas segur que vol verificar el local "<%=local.getNomLocal()%>" ?</h1>
 
 <select hidden="true" name="codiLocal"> 
    <option value="<%=local.getCodiLocal()%>"> <%=local.getNomLocal()%> -- <%=local.getNomVia()%> <%=local.getNomCarrer()%></option>
</select>
</div>
 
 <div>
 <label><b>Verificat:</b></label>
 <select name="verificat"> 
    <option value="S">Si</option>
    <option value="N">No</option>
</select>
<button type="submit">Verificar</button>
 </div>
 
 <div style="margin-top: 1%">
 	<a  href="jGetLocal?codiLocal=<%=local.getCodiLocal()%>">Detall del local</a>
 </div>

 
 
</form>
</body>
</html>