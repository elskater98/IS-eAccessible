<%@ page import="servlets.AddLocalServlet" %>
<%@ page import="backendservlet.LocalType" %>
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
        <div class="form-group">
            <label for="tipusLocal">Tipus de Local</label>
            <select class="form-control" id="tipusLocal" name="tipusLocal" required>
                <%
                    for (final LocalType localType : (List<LocalType>) session.getAttribute(AddLocalServlet.LOCAL_TYPES_SESSION_ID)) {
                %>
                <option value="<%=localType.getId()%>"><%=localType.getNameES()%>
                </option>
                <%
                    }
                %>
            </select>
        </div>
        <div class="form-group">
            <label for="nom">Nom Local</label>
            <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom Local" required/>
        </div>
        <div class="form-group">
            <label for="carrer">Carrer</label>
            <input type="text" class="form-control" id="carrer" name="carrer" placeholder="Carrer" required/>
        </div>
        <div class="form-group">
            <label for="tipusCarrer">Tipus Carrer</label>
            <input type="tipusCarrer" class="form-control" id="tipusCarrer" name="tipusCarrer" placeholder="Tipus Carrer" required/>
        </div>
        <div class="form-group">
            <label for="numero">Numero</label>
            <input type="number" class="form-control" id="numero" name="numero" placeholder="Numero" required/>
        </div>
        <div class="form-group">
            <label for="observacions">Observacions</label>
            <textarea cols="37" rows="6" class="form-control" id="observacions" name="observacions"
                      placeholder="Observacions" required></textarea>
        </div>
        <div class="form-group">
            <label for="urlCA">Url CA</label>
            <input type="text" class="form-control" id="urlCA" name="urlCA" placeholder="UrlCA" required/>
        </div>
        <div class="form-group">
            <label for="urlES">Url ES</label>
            <input type="text" class="form-control" id="urlES" name="urlES" placeholder="UrlES" required/>
        </div>
        <div class="form-group">
            <label for="urlEN">Url CA</label>
            <input type="text" class="form-control" id="urlEN" name="urlEN" placeholder="UrlEN" required/>
        </div>
        <div class="form-group">
            <label for="urlGoogleMapsCA">Url Google Maps CA</label>
            <input type="text" class="form-control" id="urlGoogleMapsCA" name="urlGoogleMapsCA" placeholder="Url Google Maps CA" required/>
        </div>
        <div class="form-group">
            <label for="urlGoogleMapsES">Url Google Maps ES</label>
            <input type="text" class="form-control" id="urlGoogleMapsES" name="urlGoogleMapsES" placeholder="Url Google Maps ES" required/>
        </div>
        <div class="form-group">
            <label for="urlGoogleMapsEN">Url Google Maps EN</label>
            <input type="text" class="form-control" id="urlGoogleMapsEN" name="urlGoogleMapsEN" placeholder="Url Google Maps EN" required/>
        </div>
        <div class="form-group">
            <label for="coorX">Coor X</label>
            <input type="number" step="0.01" class="form-control" id="coorX" name="coorX" placeholder="coorX" required/>
        </div>
        <div class="form-group">
            <label for="coorY">Coor Y</label>
            <input type="number" step="0.01" class="form-control" id="coorY" name="coorY" placeholder="coorY" required/>
        </div>
        <button type="submit" class="btn btn-primary">ADD</button>
    </form>
</div>
</body>
</html>

