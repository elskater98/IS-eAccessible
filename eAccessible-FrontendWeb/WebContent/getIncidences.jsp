<%@ page import="servlets.GetIncidencesServlet" %>
<%@ page import="backendservlet.Incidence" %>
<%@ page import="backendservlet.IncidenceType" %>
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
    <form method="POST">
        <div class="form-group">
            <label for="incidenceType">Incidence Type:</label>
            <select class="form-control" id="incidenceType" name="incidenceType" required>
                <%
                    for (final IncidenceType incidenceType : (List<IncidenceType>) session.getAttribute(GetIncidencesServlet.INCIDENCE_TYPE_LIST_SESSION_ID)) {
                %>
                <option value="<%=incidenceType.getId()%>"><%=incidenceType.getDescription()%>
                </option>
                <%
                    }
                %>
            </select>
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
        for (final Incidence incidence : (List<Incidence>) session.getAttribute(GetIncidencesServlet.INCIDENCE_LIST_SESSION_ID)) {
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
