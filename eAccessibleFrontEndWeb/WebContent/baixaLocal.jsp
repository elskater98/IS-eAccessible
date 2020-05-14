<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Baixa Local</title>
</head>
<body>
<form method="post" action="sBaixaLocal">
 
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
<h1>Estas segur que vol donar de baixa al local " <%=local.getNomLocal()%>"?</h1>
 <select hidden="true" name="codiLocal"> 
    <option value="<%=local.getCodiLocal()%>"> <%=local.getNomLocal()%> -- <%=local.getNomVia()%> <%=local.getNomCarrer()%></option>
</select>
 </div>
 
 <a style="margin-right: 1%" href="jGetLocal?codiLocal=<%=local.getCodiLocal()%>">Detall del local</a>
 <button type="submit">Donar Baixa</button>
 
 
</form>

</body>
</html>