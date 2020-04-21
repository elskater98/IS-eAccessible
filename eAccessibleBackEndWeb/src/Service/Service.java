package Service;

import models.Accessibilitat;
import models.Local;

import java.util.List;
import java.util.Objects;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.BasicException;

@WebService
public class Service {
	
	@WebMethod
	public void altaLocal(Local local) throws Exception,BasicException {
		Connection connection = null;
		
		checkLocalValues(local);
		
		try {
			InitialContext context = new InitialContext();
			if(context !=null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					Integer codiLocal = local.getCodiLocal();
					Integer coditipoLocal= local.getCoditipoLocal();
					Integer codicarrer=local.getCodiCarrer();
					String nomCarrer= local.getNomCarrer().toUpperCase();
					String nomVia= local.getNomVia().toUpperCase();
					Integer numero = local.getNumero();
					String nomLocal= local.getNomLocal().toUpperCase();
					String observacions = local.getObservacions();
					String verificat = local.getVerificat();
					
					String query = "insert into eaccessible.local (codilocal,coditipolocal,codicarrer,nomcarrer,nomvia,numero,nomlocal,observacions,verificat) values"
							+ "('"+codiLocal+"','"+coditipoLocal+"','"+codicarrer+"','"+nomCarrer+"','"+nomVia+"','"+numero+"','"+nomLocal+"','"+observacions+"','"+verificat+"')";
					try {
						Statement state = connection.createStatement();
						state.executeUpdate(query);	
						state.close();
					}catch(Exception ex) {
						throw new BasicException(500,"No s'ha pogut crear un Statement.");
					}
					connection.close();
				}
			}
			
		}catch(Exception exception) {
			throw new BasicException(500, "S'ha produit un error en la Base de dades.");
		}
		finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				throw new BasicException(500,ex.toString());
			}
		}
	}
	
	public void checkLocalValues(Local local) throws BasicException {
		if(local.getNomCarrer().isEmpty()) {
			throw new BasicException(400, "Nom Carrer: no pot estar buit.");
		}
		
		if(local.getNomCarrer().length() > 50) {
			throw new BasicException(400, "Nom Carrer: no pot tenir una longitud superior a 50.");
		}
		
		if(local.getNomVia().isEmpty()) {
			throw new BasicException(400, "Nom Via: no pot estar buit.");
		}
		if(local.getNomVia().length() > 2) {
			throw new BasicException(400, "Nom Via: no pot tenir una longitud superior a 2");
		}
		
		if(local.getNomLocal().isEmpty()) {
			throw new BasicException(400, "Nom Local: no pot estar buit.");
		}
		
		if(local.getNomLocal().length()>250) {
			throw new BasicException(400, "Nom Local: no pot tenir una longitud superior a 250");
		}
		
		if(local.getObservacions().length()>300) {
			throw new BasicException(400, "Observacions: no pot tenir una longitud superior a 300");
		}
		
		/*if(!Objects.equals("Y", local.getVerificat()) || !Objects.equals("N", local.getVerificat())) {
			throw new BasicException(400, "Verificat: valor invalid.");
		}
		if(local.getVerificat().length()>1) {
			throw new BasicException(400, "Verificat: no pot tenir una longitud superior a 1");
		}*/
		
	}

}
