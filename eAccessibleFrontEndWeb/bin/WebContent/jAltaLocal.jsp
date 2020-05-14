<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Local</title>
</head>
<body>

<form method="post" action="sAltaLocal">
<div>
<label>nomLocal</label>
<input type="text" name="nomLocal">
</div>
 <div>
 <label>nomVia</label>
<select type="text" name="nomVia">
    <option value="AV">AV</option>
    <option value="CA">CA</option>
    <option value="PL">PL</option>
    <option value="PS">PS</option>
    <option value="RA">RA</option>
    <option value="TR">TR</option>
</select>
 </div>
 
 <div>
 <label>nomCarrer</label>
 <input type="text" name="nomCarrer">
 </div>
 

 
 <%
 backend.TipoLocal[] tipoLocal = null;
 try {
         backend.BackendServiceLocator serviceLocator = new backend.BackendServiceLocator();
         backend.Backend port = serviceLocator.getBackendPort();
        tipoLocal=port.getAllTipusLocal();

    }catch(Exception ex) {
        ex.printStackTrace();
    }
%>

 
 <div>
 <label>Tipus de local</label>
 <select name="codiTipoLocal"> 
<%for (int i=0; i<tipoLocal.length; i++){%>
    <option value="<%=tipoLocal[i].getCodiTipoLocal()%>"> <%=tipoLocal[i].getNomTipoLocalCA()%> </option>
<%} %>
</select>
 </div>
 
 <div>
 <label>codiCarrer</label>
  <input type="number" min=1 name="codiCarrer">
 </div>
 
  <div>
  <label>numero</label>
  <input type="number" min=1 name="numero">
 </div>
 
 <div>
 <label>observacions</label>
  <textarea type="text" maxLength=300 name="observacions"></textarea>
 </div>

<button type="submit">Submit</button>
</form>

</body>
</html>