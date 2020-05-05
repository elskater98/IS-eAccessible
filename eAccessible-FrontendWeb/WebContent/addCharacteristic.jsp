<%@ page import="servlets.AddCharacteristicServlet" %>
<%@ page import="backendservlet.Characteristic" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="/shared/head.jsp"/>
    <title>ADD LOCAL</title>
</head>
<body>
<jsp:include page="/shared/navbar.jsp"/>
<div class="card" style="margin: auto auto 1.25rem; padding: 1.25rem; width: 80vw;">
    <form method="POST">
        <%
            for (final Characteristic characteristic : (List<Characteristic>) session.getAttribute(AddCharacteristicServlet.CHARACTERISTIC_LIST_SESSION)) {
        %>
        <div class="checkbox">
            <label>
                <input id="<%=characteristic.getId()%>" name="<%=characteristic.getId()%>" type="checkbox"
                       value="true"><%=characteristic.getNameES()%>
                </input>
            </label>
        </div>
        <%
            }
        %>
        <button type="submit" class="btn btn-primary">ADD</button>
    </form>
</div>
</body>
</html>


