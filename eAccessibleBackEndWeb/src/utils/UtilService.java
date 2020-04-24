package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import exceptions.BasicException;
import models.Local;

public class UtilService {
	
	public UtilService() {
		
	}
	
	public Integer generateIdLocal() throws BasicException {
			
			Connection connection = null;
			Integer i=0;
		
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
						
						
						String query = "select max(codilocal) AS codilocal from eaccessible.local;";
						try {
							Statement state = connection.createStatement();
							ResultSet res = state.executeQuery(query);
							res.next();
							i=res.getInt("codilocal");
							
							state.close();
						}catch(Exception ex) {
							throw new BasicException(500,"No s'ha pogut crear un Statement.");
						}
						connection.close();
					}
				}
				
			}catch(Exception exception) {
				throw new BasicException(500, "Error intern - No s'ha pogut generar un identificador");
			}
			finally {
				try {
					connection.close();
				} catch (SQLException ex) {
					throw new BasicException(500,ex.toString());
				}
			}
			
			return i+1;
		}
	
	public Integer generateIdAccessibilitat()throws BasicException{
		Connection connection = null;
		Integer i=0;
	
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
					
					
					String query = "select max(codiaccessibilitat) AS codiaccessibilitat from eaccessible.accessibilitat;";
					try {
						Statement state = connection.createStatement();
						ResultSet res = state.executeQuery(query);
						res.next();
						i=res.getInt("codilocal");
						
						state.close();
					}catch(Exception ex) {
						throw new BasicException(500,"No s'ha pogut crear un Statement.");
					}
					connection.close();
				}
			}
			
		}catch(Exception exception) {
			throw new BasicException(500, "Error intern - No s'ha pogut generar un identificador");
		}
		finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				throw new BasicException(500,ex.toString());
			}
		}
		
		return i+1;
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
	
	public void checkValor(Integer valor) throws BasicException {
		if(valor<0 && valor>5) {
			throw new BasicException(404,"Valor accessibilitat invalid, ha de ser de 0 a 5.");
		}
	}

}
