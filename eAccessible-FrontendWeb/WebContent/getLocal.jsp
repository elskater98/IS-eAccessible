<%@ page import="servlets.GetLocalServlet" %>
<%@ page import="backendservlet.Accessibility" %>
<%@ page import="backendservlet.Local" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="/shared/head.jsp"/>
    <title>GET LOCAL</title>
</head>
<body>
<jsp:include page="/shared/navbar.jsp"/>
<%
    final Local local = (Local) session.getAttribute(GetLocalServlet.GET_LOCAL_SESSION_ID);
	if (local.getName() != null) {
%>
<div class="card" style="margin: auto; width: 80vw;">
    <div class="card-body">
        <h2 class="card-title"><%= local.getId() %> - <%= local.getName()%></h2>
        <p class="card-text">Codi Carrer: <%= local.getIdStreet() %></p>
        <p class="card-text">Codi Tipus Local: <%= local.getLocalType().getId() %></p>
        <p class="card-text">Nom Via: <%= local.getStreetType() %></p>
        <p class="card-text">Nom Carrer: <%= local.getStreet() %></p>
        <p class="card-text">Numero: <%= local.getNumber() %></p>
        <p class="card-text">Nom Local: <%= local.getName() %></p>
        <p class="card-text">Observacions: <%= local.getObservations() %></p>
        <p class="card-text">Verificat: <% if (local.getVerified() == '1'){ %><a>Si</a> <% }else{ %> <a>No</a> <% } %></p>
        <p class="card-text">Url CA: <%= local.getUrlCA() %></p>
        <p class="card-text">Url ES: <%= local.getUrlES() %></p>
        <p class="card-text">Url EN: <%= local.getUrlEN() %></p>
        <p class="card-text">Url Google Maps CA: <%= local.getUrlGoogleMapsCA() %></p>
        <p class="card-text">Url Google Maps ES: <%= local.getUrlGoogleMapsES() %></p>
        <p class="card-text">Url Google Maps EN: <%= local.getUrlGoogleMapsEN() %></p>
        <%
            if ((char) local.getVerified() != '1') {
        %>
        <a href="validateLocal?id=<%=local.getId()%>" class="btn btn-primary">Validate</a>
        <%
            }
        %>
        <a href="deleteLocal?id=<%=local.getId()%>" class="btn btn-primary">Delete</a>
    </div>
</div>
<div class="card" style="margin: auto; width: 80vw;">
    <div class="card-body">
        <h2 class="card-title">Characteristics:</h2>
        <%
            for (final Accessibility accessibility : (List<Accessibility>) session.getAttribute(GetLocalServlet.GET_ACCESSIBLILITY_LIST_SESSION_ID)) {
        %>
        <p class="card-text">Nom: <%= accessibility.getCharacteristic().getNameES() %> -
            Valor: <%= accessibility.getValue() %>
        </p>
        <%
            }
        %>
    </div>
</div>
<%
	}else{
%>
<div class="card" style="margin: auto auto 1.25rem; padding: 1.25rem; width: 80vw;">
    <a>Id is not correct</a>
</div>
<%
	}
%>
</body>
</html>
