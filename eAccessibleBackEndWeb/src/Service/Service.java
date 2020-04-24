package Service;

import models.Accessibilitat;
import models.Local;
import models.TipoLocal;
import utils.UtilService;

import java.util.ArrayList;
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
					//String verificat = local.getVerificat();
					String verificat = "N";
					
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
	public void UpdateLocal(Local local) throws Exception,BasicException {
		
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
				
					Integer codiLocal = local.getCodiLocal();
					Integer coditipoLocal= local.getCoditipoLocal();
					Integer codicarrer=local.getCodiCarrer();
					String nomCarrer= local.getNomCarrer().toUpperCase();
					String nomVia= local.getNomVia().toUpperCase();
					Integer numero = local.getNumero();
					String nomLocal= local.getNomLocal().toUpperCase();
					String observacions = local.getObservacions();
					String verificat = local.getVerificat();
					
					String query = "UPDATE eaccessible.local SET coditipolocal='"+coditipoLocal+"',codicarrer='"+codicarrer+"',nomcarrer='"+nomCarrer+"',"
							+ "nomvia='"+nomVia+"',numero='"+numero+"' ,nomlocal='"+nomLocal+"' ,observacions='"+observacions+"',verificat='"+verificat+"'  where codilocal="+codiLocal;	
					
					
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
	
	
	@WebMethod
	public List<Local> getLocalsByName(String nomLocal) throws Exception, BasicException {
		
		List<Local> locals = new ArrayList<Local>();
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
					
					String query = "select coditipolocal,codicarrer,nomcarrer,nomvia,codilocal,nomlocal,numero,observacions,verificat from eAccessible.local where nomlocal LIKE UPPER('%"+nomLocal+"%')";
					
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
						while(rs.next()) {
							Local local = new Local();
							local.setCoditipoLocal(rs.getInt("coditipoLocal"));
							local.setCodiCarrer(rs.getInt("codicarrer"));
							local.setNomCarrer(rs.getString("nomcarrer"));
							local.setNomVia(rs.getString("nomvia"));
							local.setCodiLocal(rs.getInt("codilocal"));
							local.setNomLocal(rs.getString("nomlocal"));
							local.setNumero(rs.getInt("numero"));
							local.setObservacions(rs.getString("observacions"));
							local.setVerificat(rs.getString("verificat"));
							locals.add(local);
						}
						state.close();
					}catch(Exception ex) {
						throw new BasicException(500,"No s'ha pogut crear un Statement o error en la query. SQL exception");
					}
					connection.close();
				}
			}
			
		} catch(Exception exception) {
			throw new BasicException(500, "No s'ha pogut trobar locals amb el nom de local introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				throw new BasicException(500,ex.toString());
			}
		}
		
		return locals;
	}
	
	
	@WebMethod
	public TipoLocal getTipusLocalByCodiLocal(Integer codiLocal) throws Exception, BasicException {
		
		Connection connection = null;
		TipoLocal tl = new TipoLocal();
		
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
					
					
					String query = "select tl.* from eaccessible.local as l, eaccessible.tipolocal as tl "
							+ "where l.coditipolocal = tl.coditipolocal and l.codilocal="+codiLocal;
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
						while(rs.next()) {
							tl.setCodiTipoLocal(rs.getInt("coditipolocal"));
							tl.setNomTipoLocalCA(rs.getString("nomtipolocalca"));
							tl.setNomTipoLocalES(rs.getString("nomtipolocales"));
							tl.setNomTipoLocalEN(rs.getString("nomtipolocalen"));
						}
						state.close();
					}catch(Exception ex) {
						throw new BasicException(500,"No s'ha pogut crear un Statement o error en la query. SQL exception");
					}
					connection.close();
				}
			}
			
		} catch(Exception exception) {
			throw new BasicException(500, "No s'ha pogut trobar el tipus de local amb el nom de local introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				throw new BasicException(500,ex.toString());
			}
		}
		
		return tl;
	}
	
	
	@WebMethod
	public List<Local> getLocalsByCodiTipusLocal(Integer codiTipusLocal) throws Exception, BasicException {
		
		List<Local> locals = new ArrayList<Local>();
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

					String query = "select l.* "
							+ "from eaccessible.local as l, eaccessible.tipolocal as tl where l.coditipolocal= tl.coditipolocal and l.coditipolocal=" + codiTipusLocal;
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
						while(rs.next()) {
							Local local = new Local();
							local.setCoditipoLocal(rs.getInt("coditipolocal"));
							local.setCodiCarrer(rs.getInt("codicarrer"));
							local.setNomCarrer(rs.getString("nomcarrer"));
							local.setNomVia(rs.getString("nomvia"));
							local.setCodiLocal(rs.getInt("codilocal"));
							local.setNomLocal(rs.getString("nomlocal"));
							local.setNumero(rs.getInt("numero"));
							local.setObservacions(rs.getString("observacions"));
							local.setVerificat(rs.getString("verificat"));
							locals.add(local);
						}
						state.close();
					}catch(Exception ex) {
						throw new BasicException(500,"No s'ha pogut crear un Statement o error en la query. SQL exception");
					}
					connection.close();
				}
			}

		} catch(Exception exception) {
			throw new BasicException(500, "No s'ha pogut trobar locals amb el tipus de local introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				throw new BasicException(500,ex.toString());
			}
		}

		return locals;
	}

}
