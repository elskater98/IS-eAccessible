<%@ page import="servlets.GetAllLocalsServlet" %>
<%@ page import="backendservlet.Local" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="/shared/head.jsp"/>
    <title>GET ALL LOCALS</title>
</head>
<body>
<jsp:include page="/shared/navbar.jsp"/>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Codi Local</th>
        <th scope="col">Codi Carrer</th>
        <th scope="col">Codi Tipo Local</th>
        <th scope="col">Nom Via</th>
        <th scope="col">Nom Carrer</th>
        <th scope="col">Numero</th>
        <th scope="col">Nom Local</th>
        <th scope="col">Observacions</th>
        <th scope="col">Verificat</th>
        <th scope="col">Url CA</th>
        <th scope="col">Url ES</th>
        <th scope="col">Url EN</th>
        <th scope="col">Url Google Maps CA</th>
        <th scope="col">Url Google Maps ES</th>
        <th scope="col">Url Google Maps EN</th>
        <th scope="col">Coor X</th>
        <th scope="col">Coor Y</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (final Local local : (List<Local>) session.getAttribute(GetAllLocalsServlet.GET_ALL_LOCALS_SESSION_ID)) {
    %>
    <tr>
        <th scope="row">
            <%=local.getId()%>
        </th>
        <th>
            <%=local.getIdStreet()%>
        </th>
        <th>
            <%=local.getLocalType().getId()%>
        </th>
        <th>
            <%=local.getStreetType()%>
        </th>
        <th>
            <%=local.getStreet()%>
        </th>
        <th>
            <%=local.getNumber()%>
        </th>
        <th>
            <a href="getLocal?id=<%=local.getId()%>">
                <%=local.getName()%>
            </a>
        </th>
        
        <%
        	if (local.getObservations() == null){
        %>
        <th>
            <a>-</a>
        </th>
        <%
        	}else{
        %>
        <th>
            <%=local.getObservations()%>
        </th>
        <%
        	}
        %>
        <%
        	if (local.getVerified() == '1'){
        %>
        <th>
            <a>Si</a>
        </th>
        <%
        	}else{
        %>
        <th>
            <a>No</a>
        </th>
        <%
        	}
        %>
        <th>
        	<a href="<%=local.getUrlCA()%>">
            <%=local.getUrlCA()%>
        </th>
        <th>
        	<a href="<%=local.getUrlES()%>">
            <%=local.getUrlES()%>
        </th>
        <th>
        	<a href="<%=local.getUrlEN()%>">
            <%=local.getUrlEN()%>
        </th>
        <th>
        	<a href="<%=local.getUrlGoogleMapsCA()%>">
            <%=local.getUrlGoogleMapsCA()%>
        </th>
        <th>
        	<a href="<%=local.getUrlGoogleMapsES()%>">
            <%=local.getUrlGoogleMapsES()%>
        </th>
        <th>
        	<a href="<%=local.getUrlGoogleMapsEN()%>">
            <%=local.getUrlGoogleMapsEN()%>
        </th>
        <th>
            <%=local.getCoorX()%>
        </th>
        <th>
            <%=local.getCoorY()%>
        </th>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
