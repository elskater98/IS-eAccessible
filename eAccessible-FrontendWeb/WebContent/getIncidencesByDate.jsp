<%@ page import="servlets.GetIncidencesByDateServlet" %>
<%@ page import="backendservlet.Incidence" %>
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
	<span>Date format must be: YYYY-MM-dd HH:mm:ss</span>
    <form method="POST">
        <div class="form-group">
            <label for="startDate">Data inici:</label>
            <input type="datetime" class="form-control" id="startDate" name="startDate" placeholder="Data Inici" required>
        </div>
        <div class="form-group">
            <label for="endDate">Data inici:</label>
            <input type="datetime" class="form-control" id="endDate" name="endDate" placeholder="Data Final" required>
        </div>
        <button type="submit" class="btn btn-primary">GET</button>
    </form>
</div>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Date</th>
        <th scope="col">Timestamp</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (final Incidence incidence : (List<Incidence>) session.getAttribute(GetIncidencesByDateServlet.INCIDENCE_LIST_SESSION_ID)) {
    %>
    <tr>
        <th scope="row">
            <%=incidence.getId()%>
        </th>
        <th>
            <%=incidence.getDate().toString()%>
        </th>
        <th>
            <%=incidence.getTimestamp().getNanos()%>
        </th>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>