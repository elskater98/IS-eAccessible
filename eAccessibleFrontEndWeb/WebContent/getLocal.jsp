<%@page import="backend.Local"%>
<%@page import="backend.TipoLocal"%>
<%@page import="backend.Caracteristica"%>
<%@page import="backend.Accessibilitat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Local</title>
</head>
<body>
 <%
 Local local = null;
 TipoLocal tl=null;
 try {
	 	 backend.BackendServiceLocator serviceLocator = new backend.BackendServiceLocator();
         backend.Backend port = serviceLocator.getBackendPort();
         local = port.getLocal(Integer.parseInt(request.getParameter("codiLocal")));
         tl= port.getTipusLocalByCodiLocal(Integer.parseInt(request.getParameter("codiLocal")));
    }catch(Exception ex) {
        ex.printStackTrace();
    }
%>
<div style="margin-bottom:1%">
<lu>
<li><b>Codi del local: </b><%=local.getCodiLocal()%></li>
<li><b>Nom Local: </b><%=local.getNomLocal()%></li>
<li><b>Adreça: </b><%=local.getNomVia()%> <%=local.getNomCarrer()%> (Codi carrer <%=local.getCodiCarrer()%>) nº <%=local.getNumero()%></li>
<li><b>Tipus de Local:</b>  <b>CA:</b><%=tl.getNomTipoLocalCA()%> | <b>ES:</b><%=tl.getNomTipoLocalES()%> | <b>EN:</b><%=tl.getNomTipoLocalEN()%></li>
<li><b>Verificat: </b><%=local.getVerificat()%></li>
<li><b>Observacions: </b><%=local.getObservacions()%></li>
</lu>
</div>




<div>
<a style="margin-right: 1%" href="/eAccessibleFrontEndWeb/getAllLocals.jsp">Tots els locals</a>
<a style="margin-right: 1%" href="/eAccessibleFrontEndWeb/jAddFullAccessibilitat?codiLocal=<%=local.getCodiLocal()%>">Incloure Caracterisitques</a>
<a style="margin-right: 1%" href="/eAccessibleFrontEndWeb/jBaixaLocal?codiLocal=<%=local.getCodiLocal()%>">Donar de baixa al local</a>
<a style="margin-right: 1%" href="/eAccessibleFrontEndWeb/jVerificarLocal?codiLocal=<%=local.getCodiLocal()%>">Verificar Local</a>
<a style="margin-right: 1%" href="/eAccessibleFrontEndWeb/jviewfullAccessibilitat?codiLocal=<%=local.getCodiLocal()%>">Full d'accessibilitat</a>
</div>



</body>
</html>