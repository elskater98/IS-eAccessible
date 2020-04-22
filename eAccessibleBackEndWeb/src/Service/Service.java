package Service;

import models.Accessibilitat;
import models.Local;
import utils.UtilService;


import java.util.List;
import java.util.Objects;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.BasicException;

@WebService
public class Service {
	
	@WebMethod
	public void altaLocal(Local local) throws Exception,BasicException {
		Connection connection = null;
		
		UtilService us = new UtilService();
		us.checkLocalValues(local);
		
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
					
					Integer codiLocal = us.generateId();
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
	
	@WebMethod
	public Local getLocal(Integer id) throws BasicException{
		
		
		Connection connection = null;
		Local local = new Local();
	
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
					
					
					String query = "select * from eaccessible.local where codilocal="+id;
					try {
						Statement state = connection.createStatement();
						ResultSet res = state.executeQuery(query);
						res.next();
						
						local.setCodiLocal(res.getInt("codiLocal"));
						local.setCoditipoLocal(res.getInt("codiTipoLocal"));
						local.setCodiCarrer(res.getInt("codiCarrer"));
						local.setNomCarrer(res.getString("nomCarrer"));
						local.setNomVia(res.getString("nomVia"));
						local.setNumero(res.getInt("numero"));
						local.setNomLocal(res.getString("nomLocal"));
						local.setObservacions(res.getString("observacions"));
						local.setVerificat(res.getString("verificat"));
						
						state.close();
					}catch(Exception ex) {
						throw new BasicException(500,"No s'ha pogut crear un Statement.");
					}
					connection.close();
				}
			}
			
		}catch(Exception exception) {
			throw new BasicException(404, "El local amb identificador "+id+" no existeix.");
		}
		finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				throw new BasicException(500,ex.toString());
			}
		}
		
		return local;
	}
	
	
	@WebMethod
	public void baixaLocal(Integer codiLocal) throws Exception, BasicException {
		Connection connection = null;
		
		try {
			InitialContext context = new InitialContext();
			if(context != null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					String query = "delete from eaccessible.local where codilocal=" + codiLocal;
					
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
			
		} catch(Exception exception) {
			throw new BasicException(500, "No s'ha pogut eliminar el local amb el seu codi introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				throw new BasicException(500,ex.toString());
			}
		}
	}

	@WebMethod
	public void validarLocal(Integer codiLocal) throws Exception, BasicException {
		Connection connection = null;
		
		try {
			InitialContext context = new InitialContext();
			if(context != null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					String query = "update eAccessible.local set verificat='S' where codilocal="+codiLocal;
					
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
			
		} catch(Exception exception) {
			throw new BasicException(500, "No s'ha pogut validar el local amb el seu codi introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				throw new BasicException(500,ex.toString());
			}
		}
	}
	
	
}
