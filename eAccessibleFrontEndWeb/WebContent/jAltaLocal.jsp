<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Local</title>
</head>
<body>

<form method=post action="sAltaLocal">
<h3>Afegir un nou local</h1>
<div>
<label><b>Nom Local</b></label>
<input type="text" value="" name="nomLocal">
</div>
 <div>
 <label><b>Nom Via</b></label>
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
 <label><b>Nom Carrer</b></label>
 <input type="text" value="" name="nomCarrer">
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
 <label><b>Tipus de Local</b></label>
 <select name="codiTipoLocal"> 
<%for (int i=0; i<tipoLocal.length; i++){%>
    <option value="<%=tipoLocal[i].getCodiTipoLocal()%>"> <%=tipoLocal[i].getNomTipoLocalCA()%> </option>
<%} %>
</select>
 </div>
 
 <div>
 <label><b>Codi Carrer</b></label>
  <input type="number" value="1" min=1 name="codiCarrer">
 </div>
 
  <div>
  <label><b>Numero del local</b></label>
  <input type="number" value="1" min=1 name="numero">
 </div>
 
 <div>
 <label><b>Observacions</b></label>
  <textarea type="text" value="" maxLength=300 name="observacions"></textarea>
 </div>
 <div style="margin-top:1%;">
 <a style="margin-right:1%" href="index.html"> Inici</a>
<button  type="submit">Enviar formulari</button>
 </div>

</form>

</body>
</html>