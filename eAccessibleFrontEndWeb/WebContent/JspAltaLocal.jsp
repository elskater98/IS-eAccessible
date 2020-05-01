<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alta Local</title>
</head>
<body>


<% String codiTipoLocal = (String) session.getAttribute("codiTipoLocal");
%>

<h1>Alta Local</h1>
<form method="post" action="SvlaltaLocal">
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
service2.TipoLocal[] tipoLocal = null;
 try {
		service2.ServiceServiceLocator serviceLocator = new service2.ServiceServiceLocator();
		service2.Service port = serviceLocator.getServicePort();
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
 
 <input type="submit" value="Donar alta local">
</form>

</body>
</html>