package backend;

import models.Accessibilitat;
import models.Caracteristica;
import models.CaracteristicaTipoLocal;
import models.Incidencia;
import models.Local;
import models.TipoLocal;
import models.TipusIncidencia;
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
public class Backend {
	
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
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					Integer codiLocal = us.generateIdLocal();
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
						us.generateIncidencia(200);
						us.generateIncidencia(201);
						state.close();
					}catch(Exception ex) {
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement.");
					}
					connection.close();
				}
			}
			
		}catch(Exception exception) {
			us.generateIncidencia(500);
			exception.printStackTrace();
			throw new BasicException(500, "S'ha produit un error en la Base de dades.");
		}
		finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
	}
	
	@WebMethod
	public Local getLocal(Integer id) throws BasicException{
		
		
		Connection connection = null;
		Local local = new Local();
		UtilService us = new UtilService();
	
		try {
			InitialContext context = new InitialContext();
			if(context !=null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					
					String query = "select * from eaccessible.local where codilocal="+id;
					try {
						Statement state = connection.createStatement();
						ResultSet res = state.executeQuery(query);
						us.generateIncidencia(200);
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
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement.");
					}
					connection.close();
				}
			}
			
		}catch(Exception exception) {
			us.generateIncidencia(404);
			exception.printStackTrace();
			throw new BasicException(404, "El local amb identificador "+id+" no existeix.");
		}
		finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
		
		return local;
	}
	
	
	@WebMethod
	public void baixaLocal(Integer codiLocal) throws Exception, BasicException {
		Connection connection = null;
		UtilService us = new UtilService();
		
		try {
			InitialContext context = new InitialContext();
			if(context != null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					String query = "delete from eaccessible.local where codilocal=" + codiLocal;
					String query2="DELETE FROM eaccessible.accessibilitat WHERE codiLocal="+ codiLocal;
					try {
						Statement state = connection.createStatement();
						state.executeUpdate(query2); // Elimina el full d'accessibilitat, ja que conte una clau forana, per tal de poder eliminar el local correctament.	
						us.generateIncidencia(200);
						state.executeUpdate(query);
						us.generateIncidencia(200);
						state.close();
					}catch(Exception ex) {
						ex.printStackTrace();
						us.generateIncidencia(500);
						throw new BasicException(500,"No s'ha pogut crear un Statement.");
					}
					connection.close();
				}
			}
			
		} catch(Exception exception) {
			us.generateIncidencia(500);
			exception.printStackTrace();
			throw new BasicException(500, "No s'ha pogut eliminar el local amb el seu codi introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
				us.generateIncidencia(500);
				throw new BasicException(500,ex.toString());
			}
		}
	}
	
	//Sense us
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
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
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
						us.generateIncidencia(200);
						state.close();
					}catch(Exception ex) {
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement.");
					}
					connection.close();
				}
			}
			
		}catch(Exception exception) {
			us.generateIncidencia(500);
			exception.printStackTrace();
			throw new BasicException(500, "S'ha produit un error en la Base de dades.");
		}
		finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
	}
	
	@WebMethod
	public void validarLocal(Integer codiLocal, String s) throws Exception, BasicException {
		Connection connection = null;
		UtilService us = new UtilService();
		try {
			InitialContext context = new InitialContext();
			if(context != null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					String query = "update eAccessible.local set verificat='"+s+"' where codilocal="+codiLocal;
					
					try {
						Statement state = connection.createStatement();
						state.executeUpdate(query);	
						us.generateIncidencia(200);
						state.close();
					}catch(Exception ex) {
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement.");
					}
					connection.close();
				}
			}
			
		} catch(Exception exception) {
			us.generateIncidencia(500);
			exception.printStackTrace();
			throw new BasicException(500, "No s'ha pogut validar el local amb el seu codi introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
	}
	
	@WebMethod
	public void addAccessibilitat(Accessibilitat accessibilitat) throws Exception, BasicException {
		Connection connection = null;
		
		UtilService us = new UtilService();
		us.checkValor(accessibilitat.getValor());
		
		try {
			InitialContext context = new InitialContext();
			if(context !=null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					Integer codiAccessibilitat =us.generateIdAccessibilitat();
					Integer codiLocal = accessibilitat.getCodiLocal();
					Integer codiCaracteristica = accessibilitat.getCodiCaracterisitca();
					Integer valor = accessibilitat.getValor();
					String verificat = accessibilitat.getVerificat();

					
					String query="INSERT INTO eaccessible.accessibilitat (codiaccessibilitat, codilocal, codicaracteristica, valor, verificat) VALUES ("+codiAccessibilitat+","+codiLocal+","+codiCaracteristica+","+valor+",'"+verificat+"');";
					try {
						Statement state = connection.createStatement();
						state.executeUpdate(query);
						us.generateIncidencia(200);
						us.generateIncidencia(201);
						state.close();
					}catch(Exception ex) {
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement.");
					}
					connection.close();
				}
			}
			
		}catch(Exception exception) {
			us.generateIncidencia(500);
			exception.printStackTrace();
			throw new BasicException(500, "S'ha produit un error en la Base de dades. Accessibilitat");
		}
		finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
	}
	
	@WebMethod
	public void deleteFullAccessibilitat(Integer codiLocal) throws Exception, BasicException {
		Connection connection = null;
		
		UtilService us = new UtilService();
		
		try {
			InitialContext context = new InitialContext();
			if(context !=null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					String query="DELETE FROM eaccessible.accessibilitat WHERE codiLocal="+ codiLocal;
					try {
						Statement state = connection.createStatement();
						state.executeUpdate(query);
						us.generateIncidencia(200);
						state.close();
					}catch(Exception ex) {
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement.");
					}
					connection.close();
				}
			}
			
		}catch(Exception exception) {
			us.generateIncidencia(500);
			exception.printStackTrace();
			throw new BasicException(500, "S'ha produit un error en la Base de dades. Accessibilitat");
		}
		finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
	}
	
	@WebMethod
	public ArrayList<Accessibilitat> getAccessibilitatByLocalId(Integer id) throws BasicException,Exception{
		
		Connection connection = null;
		ArrayList<Accessibilitat> fullAccessibilitat = new ArrayList<>();
		UtilService us = new UtilService();
		
	
		try {
			InitialContext context = new InitialContext();
			if(context !=null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					
					String query = "SELECT * FROM eaccessible.accessibilitat where codilocal="+id;
					try {
						Statement state = connection.createStatement();
						ResultSet res = state.executeQuery(query);
						us.generateIncidencia(200);
						while(res.next()) {
							Accessibilitat accessibilitat = new Accessibilitat();
							accessibilitat.setCodiAccessibilitat(res.getInt("codiaccessibilitat"));
							accessibilitat.setCodiLocal(res.getInt("codilocal"));
							accessibilitat.setCodiCaracterisitca(res.getInt("codicaracteristica"));
							accessibilitat.setValor(res.getInt("valor"));
							accessibilitat.setVerificat(res.getString("verificat"));
							fullAccessibilitat.add(accessibilitat);
						}
						
						state.close();
					}catch(Exception ex) {
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement.");
					}
					connection.close();
				}
			}
			
		}catch(Exception exception) {
			us.generateIncidencia(404);
			exception.printStackTrace();
			throw new BasicException(404, "El full d'accessibilitat amb identificador "+id+" no existeix.");
		}
		finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
		
		return fullAccessibilitat;
		
	}
	
	@WebMethod
	public List<Local> getAllLocals() throws BasicException{
		List<Local> locals = new ArrayList<Local>();
		Connection connection = null;
		UtilService us = new UtilService();
		
		try {
			InitialContext context = new InitialContext();
			if(context != null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					String query = "select * from eAccessible.local";
					
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
						us.generateIncidencia(200);
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
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement o error en la query. SQL exception");
					}
					connection.close();
				}
			}
			
		} catch(Exception exception) {
			us.generateIncidencia(500);
			exception.printStackTrace();
			throw new BasicException(500, "No s'ha pogut trobar locals amb el nom de local introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
		
		return locals;
	}
	
	
	@WebMethod
	public Caracteristica getCharacteristic(Integer codiCaracteristica) throws BasicException{
		
		Connection connection = null;
		UtilService us = new UtilService();
		Caracteristica caracteristica = new Caracteristica();
		
		try {
			InitialContext context = new InitialContext();
			if(context != null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					String query = "select * from eaccessible.caracteristica where codicaracteristica="+codiCaracteristica;
					
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
						us.generateIncidencia(200);
						rs.next();
						caracteristica.setCodiCaracteristica(rs.getInt("codicaracteristica"));;
						caracteristica.setNomCaracteristicaCA(rs.getString("nomcaracteristicaca"));
						caracteristica.setNomCaracteristicaES(rs.getString("nomcaracteristicaes"));
						caracteristica.setNomCaracteristicaES(rs.getString("nomcaracteristicaes"));
						caracteristica.setTipo(rs.getInt("tipo"));
						caracteristica.setCodinivell(rs.getInt("codinivell"));
						
						state.close();
					}catch(Exception ex) {
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement o error en la query. SQL exception");
					}
					connection.close();
				}
			}
			
		} catch(Exception exception) {
			us.generateIncidencia(500);
			exception.printStackTrace();
			throw new BasicException(500, "No s'ha pogut trobar locals amb el nom de local introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
		
		return caracteristica;
	}
	
	//Sense us
	@WebMethod
	public List<Caracteristica> getAllCharacteristic() throws BasicException{
		List<Caracteristica> characteristics = new ArrayList<Caracteristica>();
		Connection connection = null;
		UtilService us = new UtilService();
		
		try {
			InitialContext context = new InitialContext();
			if(context != null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					String query = "select * from eaccessible.caracteristica;";
					
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
						us.generateIncidencia(200);
						while(rs.next()) {
							Caracteristica caracteristica = new Caracteristica();
							caracteristica.setCodiCaracteristica(rs.getInt("codicaracteristica"));;
							caracteristica.setNomCaracteristicaCA(rs.getString("nomcaracteristicaca"));
							caracteristica.setNomCaracteristicaES(rs.getString("nomcaracteristicaes"));
							caracteristica.setNomCaracteristicaES(rs.getString("nomcaracteristicaes"));
							caracteristica.setTipo(rs.getInt("tipo"));
							caracteristica.setCodinivell(rs.getInt("codinivell"));
							characteristics.add(caracteristica);
						}
						state.close();
					}catch(Exception ex) {
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement o error en la query. SQL exception");
					}
					connection.close();
				}
			}
			
		} catch(Exception exception) {
			us.generateIncidencia(500);
			exception.printStackTrace();
			throw new BasicException(500, "No s'ha pogut trobar locals amb el nom de local introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
		
		return characteristics;
	}

	//Sense us
	public List<Local> getLocalsbyTipusAndName(Integer codiTipoLocal, String nomLocal) throws BasicException{
		List<Local> local = new ArrayList<Local>();
		Connection connection = null;
		UtilService us = new UtilService();
		
		
		try {
			InitialContext context = new InitialContext();
			if(context != null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					String query = "select * from eaccessible.local where nomlocal LIKE UPPER('%"+nomLocal+"%') and coditipolocal="+codiTipoLocal;
					
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
						us.generateIncidencia(200);
						while(rs.next()) {
							Local l = new Local();
							l.setCoditipoLocal(rs.getInt("coditipolocal"));
							l.setCodiCarrer(rs.getInt("codicarrer"));
							l.setNomCarrer(rs.getString("nomcarrer"));
							l.setNomVia(rs.getString("nomvia"));
							l.setCodiLocal(rs.getInt("codilocal"));
							l.setNomLocal(rs.getString("nomlocal"));
							l.setNumero(rs.getInt("numero"));
							l.setObservacions(rs.getString("observacions"));
							l.setVerificat(rs.getString("verificat"));
							local.add(l);
						}
						state.close();
					}catch(Exception ex) {
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement o error en la query. SQL exception");
					}
					connection.close();
				}
			}
			
		} catch(Exception exception) {
			us.generateIncidencia(500);
			exception.printStackTrace();
			throw new BasicException(500, "No s'ha pogut trobar locals amb el nom de local introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
		
		return local;
	}
	
	
	@WebMethod
	public TipoLocal getTipusLocalById(Integer codiTipoLocal) throws BasicException{
		TipoLocal tl = new TipoLocal();
		
		Connection connection = null;
		UtilService us = new UtilService();
		
		
		try {
			InitialContext context = new InitialContext();
			if(context != null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					String query = "select * from eaccessible.tipolocal where coditipolocal="+codiTipoLocal;
					
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
						us.generateIncidencia(200);
						while(rs.next()) {
							
							tl.setCodiTipoLocal(rs.getInt("coditipolocal"));
							tl.setNomTipoLocalCA(rs.getString("nomtipolocalca"));
							tl.setNomTipoLocalES(rs.getString("nomtipolocales"));
							tl.setNomTipoLocalEN(rs.getString("nomtipolocalen"));
							
						}
						state.close();
					}catch(Exception ex) {
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement o error en la query. SQL exception");
					}
					connection.close();
				}
			}
			
		} catch(Exception exception) {
			us.generateIncidencia(500);
			exception.printStackTrace();
			throw new BasicException(500, "No s'ha pogut trobar locals amb el nom de local introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
		
		return tl;
	}
	
	//Sense us
	@WebMethod
	public List<Local> getLocalsByName(String nomLocal) throws Exception, BasicException {
		
		List<Local> locals = new ArrayList<Local>();
		Connection connection = null;
		UtilService us = new UtilService();
		
		try {
			InitialContext context = new InitialContext();
			if(context != null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					String query = "select coditipolocal,codicarrer,nomcarrer,nomvia,codilocal,nomlocal,numero,observacions,verificat from eAccessible.local where nomlocal LIKE UPPER('%"+nomLocal+"%')";
					
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
						us.generateIncidencia(200);
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
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement o error en la query. SQL exception");
					}
					connection.close();
				}
			}
			
		} catch(Exception exception) {
			us.generateIncidencia(500);
			exception.printStackTrace();
			throw new BasicException(500, "No s'ha pogut trobar locals amb el nom de local introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
		
		return locals;
	}
	
	//Sense us
	@WebMethod
	public TipoLocal getTipusLocalByCodiLocal(Integer codiLocal) throws Exception, BasicException {
		
		Connection connection = null;
		TipoLocal tl = new TipoLocal();
		UtilService us = new UtilService();
		
		try {
			InitialContext context = new InitialContext();
			if(context != null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					
					String query = "select tl.* from eaccessible.local as l, eaccessible.tipolocal as tl "
							+ "where l.coditipolocal = tl.coditipolocal and l.codilocal="+codiLocal;
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
						us.generateIncidencia(200);
						while(rs.next()) {
							tl.setCodiTipoLocal(rs.getInt("coditipolocal"));
							tl.setNomTipoLocalCA(rs.getString("nomtipolocalca"));
							tl.setNomTipoLocalES(rs.getString("nomtipolocales"));
							tl.setNomTipoLocalEN(rs.getString("nomtipolocalen"));
						}
						state.close();
					}catch(Exception ex) {
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement o error en la query. SQL exception");
					}
					connection.close();
				}
			}
			
		} catch(Exception exception) {
			us.generateIncidencia(500);
			exception.printStackTrace();
			throw new BasicException(500, "No s'ha pogut trobar el tipus de local amb el nom de local introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
		
		return tl;
	}
	
	//Sense us
	@WebMethod
	public List<Local> getLocalsByCodiTipusLocal(Integer codiTipusLocal) throws Exception, BasicException {
		
		List<Local> locals = new ArrayList<Local>();
		Connection connection = null;
		UtilService us = new UtilService();
		
		try {
			InitialContext context = new InitialContext();
			if(context != null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}

					String query = "select * "
							+ "from eaccessible.local where coditipolocal=" + codiTipusLocal;
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
						us.generateIncidencia(200);
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
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement o error en la query. SQL exception");
					}
					connection.close();
				}
			}

		} catch(Exception exception) {
			us.generateIncidencia(500);
			exception.printStackTrace();
			throw new BasicException(500, "No s'ha pogut trobar locals amb el tipus de local introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}

		return locals;
	}

	//Sense us
	@WebMethod
	public List<TipoLocal> getAllTipusLocal() throws Exception, BasicException {
		
		List<TipoLocal> tipusLocals = new ArrayList<TipoLocal>();
		Connection connection = null;
		UtilService us = new UtilService();

		try {
			InitialContext context = new InitialContext();
			if(context != null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}

					String query = "select * "
							+ "from eaccessible.tipolocal";
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
						us.generateIncidencia(200);
						while(rs.next()) {
							TipoLocal tipusLocal = new TipoLocal();
							tipusLocal.setCodiTipoLocal(rs.getInt("coditipolocal"));
							tipusLocal.setNomTipoLocalCA(rs.getString("nomtipolocalca"));
							tipusLocal.setNomTipoLocalES(rs.getString("nomtipolocales"));
							tipusLocal.setNomTipoLocalEN(rs.getString("nomtipolocalen"));
							tipusLocals.add(tipusLocal);							
						}
						state.close();
					}catch(Exception ex) {
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement o error en la query. SQL exception");
					}
					connection.close();
				}
			}

		} catch(Exception exception) {
			us.generateIncidencia(500);
			exception.printStackTrace();
			throw new BasicException(500, "No s'ha pogut els tipus de locals de la base de dades.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
		
		return tipusLocals;
	}
	
	//Sense us
	@WebMethod
	public List<Local> getAllLocalsNonVerificated() throws BasicException{
		List<Local> locals = new ArrayList<Local>();
		Connection connection = null;
		UtilService us = new UtilService();
		
		try {
			InitialContext context = new InitialContext();
			if(context != null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					String query = "SELECT * FROM eaccessible.local WHERE verificat='N';";
					
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
						us.generateIncidencia(200);
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
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement o error en la query. SQL exception");
					}
					connection.close();
				}
			}
			
		} catch(Exception exception) {
			us.generateIncidencia(500);
			exception.printStackTrace();
			throw new BasicException(500, "No s'ha pogut trobar locals amb el nom de local introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
		
		return locals;
	}
	
	@WebMethod
	public List<Caracteristica> getCaracterisitcaTipus(Integer codiTipusLocal) throws Exception, BasicException {
		
		List<Caracteristica> caracteristicaList = new ArrayList<Caracteristica>();
		Connection connection = null;
		UtilService us = new UtilService();
		
		try {
			InitialContext context = new InitialContext();
			if(context != null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/eAccessible");
				if(datasource == null) {
					us.generateIncidencia(500);
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						us.generateIncidencia(444);
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}

					String query = "SELECT cr.* FROM eaccessible.caracteristicatipolocal ca, eaccessible.caracteristica cr WHERE ca.codiTipoLocal="+codiTipusLocal+" and ca.codicaracteristica=cr.codicaracteristica";
					
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
						us.generateIncidencia(200);
						while(rs.next()) {
							Caracteristica caracteristica = new Caracteristica();
							caracteristica.setCodiCaracteristica(rs.getInt("codicaracteristica"));;
							caracteristica.setNomCaracteristicaCA(rs.getString("nomcaracteristicaca"));
							caracteristica.setNomCaracteristicaES(rs.getString("nomcaracteristicaes"));
							caracteristica.setNomCaracteristicaES(rs.getString("nomcaracteristicaes"));
							caracteristica.setTipo(rs.getInt("tipo"));
							caracteristica.setCodinivell(rs.getInt("codinivell"));
							caracteristicaList.add(caracteristica);
						}
						state.close();
					}catch(Exception ex) {
						us.generateIncidencia(500);
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement o error en la query. SQL exception");
					}
					connection.close();
				}
			}

		} catch(Exception exception) {
			us.generateIncidencia(500);
			exception.printStackTrace();
			throw new BasicException(500, "No s'ha pogut trobar locals amb el tipus de local introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				us.generateIncidencia(500);
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}

		return caracteristicaList;
	}
	
	@WebMethod
	public List<Incidencia> getAllIncidencia() throws BasicException{
		List<Incidencia> incidencia = new ArrayList<Incidencia>();
		Connection connection = null;
		
		try {
			InitialContext context = new InitialContext();
			if(context != null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/incidencia");
				if(datasource == null) {
					
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					String query = "SELECT * FROM log.incidencia";
					
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
						while(rs.next()) {
							Incidencia in = new Incidencia();
							in.setCodiIncidencia(rs.getInt("idIncidencia"));
							in.setCodiTipusIncidencia(rs.getInt("codiTipusIncidencia"));
							in.setData(rs.getString("data"));
							in.setDataHora(rs.getString("dataHora"));
							incidencia.add(in);
						}
						state.close();
					}catch(Exception ex) {
						
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement o error en la query. SQL exception");
					}
					connection.close();
				}
			}
			
		} catch(Exception exception) {
			
			exception.printStackTrace();
			throw new BasicException(500, "No s'ha pogut trobar locals amb el nom de local introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
		
		return incidencia;
	}
	
	@WebMethod
	public TipusIncidencia getTipusIncidencia(Integer codi) throws BasicException{
		TipusIncidencia incidencia = new TipusIncidencia();
		Connection connection = null;
		
		try {
			InitialContext context = new InitialContext();
			if(context != null) {
				DataSource datasource = (DataSource) context.lookup( "java:jboss/PostgreSQL/incidencia");
				if(datasource == null) {
					
					throw new BasicException(500,"No s'ha pogut establir un DataSource/Lookup.");
				}else {
					try {
						connection = datasource.getConnection();
					}catch(Exception ex) {
						
						ex.printStackTrace();
						throw new BasicException(444,"No s'ha pogut establir connexio amb la base de dades.");
					}
					
					String query = "SELECT \"codiTipusIncidencia\", descripcio FROM log.\"tipusIncidencia\" where \"codiTipusIncidencia\"="+codi;
					
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
						rs.next();
						incidencia.setCodiTipusIncidencia(rs.getInt("codiTipusIncidencia"));
						incidencia.setDescripcio(rs.getString("descripcio"));
						
						state.close();
					}catch(Exception ex) {
						
						ex.printStackTrace();
						throw new BasicException(500,"No s'ha pogut crear un Statement o error en la query. SQL exception");
					}
					connection.close();
				}
			}
			
		} catch(Exception exception) {
			
			exception.printStackTrace();
			throw new BasicException(500, "No s'ha pogut trobar locals amb el nom de local introduit.");
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				
				ex.printStackTrace();
				throw new BasicException(500,ex.toString());
			}
		}
		
		return incidencia;
	}
	
	
}
