package Service;

import models.Accessibilitat;
import models.Local;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

import exceptions.BasicException;

@WebService
public class Service {
	
	@WebMethod
	public void altaLocal(Local local) throws Exception {
		Connection connection = null;
		
		try {
			InitialContext context = new InitialContext();
			if(context !=null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					System.out.print("Error");
				}else {
					connection = datasource.getConnection();
					Integer codiLocal = local.getCodiLocal();
					Integer CoditipoLocal= local.getCoditipoLocal();
					Integer codicarrer=local.getCodiCarrer();
					String nomCarrer= local.getNomCarrer().toUpperCase();
					String nomVia= local.getNomVia().toUpperCase();
					Integer numero = local.getNumero();
					String nomLocal= local.getNomLocal().toUpperCase();
					String observacions = local.getObservacions();
					String verificat = local.getVerificat();
					
					String query = "insert into eAccessible.local (codilocal,coditipolocal,codicarrer,nomcarrer,nomvia,numero,nomlocal,observacions,verificat) values"
							+ "('"+codiLocal+"','"+CoditipoLocal+"','"+codicarrer+"','"+nomCarrer+"','"+nomVia+"','"+numero+"','"+nomLocal+"','"+observacions+"','"+verificat+"')";
					
					Statement state = connection.createStatement();
					state.executeUpdate(query);
					
					connection.close();
					state.close();
				}
			}
			
		}catch(Exception exception) {
			throw(exception);	
		}
	}

}
