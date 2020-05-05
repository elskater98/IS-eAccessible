<%@ page import="servlets.GetLocalsByNameServlet" %>
<%@ page import="backendservlet.Local" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="/shared/head.jsp"/>
    <title>GET LOCALS BY NOM LOCAL</title>
</head>
<body>
<jsp:include page="/shared/navbar.jsp"/>

<div class="card" style="margin: auto auto 1.25rem; padding: 1.25rem; width: 80vw;">
    <form method="GET">
        <div class="form-group">
            <label for="name">Nom Local</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Nom" required>
        </div>
        <div class="form-group">
        	<label for="name">Tipo Local</label>
        	<select class="form-control" id="tipoLocal" name="tipoLocal">
			  <option value="empty"> </option>
			  <option value="1">BARS I RESTAURANTS</option>
			  <option value="2">COMERÇOS</option>
			  <option value="3">ENTITATS BÀNCARIES</option>
			  <option value="4">FARMÀCIES</option>
			  <option value="5">HOTELS</option>
			  <option value="6">LOCALS PÚBLICS</option>
			</select>
        </div>
        <button type="submit" class="btn btn-primary">GET</button>
    </form>
</div>

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
        for (final Local local : (List<Local>) session.getAttribute(GetLocalsByNameServlet.LOCAL_LIST_SESSION_ID)) {
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
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>
