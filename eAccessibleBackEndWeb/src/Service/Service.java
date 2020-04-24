package Service;

import models.Accessibilitat;
import models.CaracteristicaTipoLocal;
import models.Local;
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
	public void addAccessibilitat(Accessibilitat accessibilitat) throws Exception, BasicException {
		Connection connection = null;
		
		UtilService us = new UtilService();
		us.checkValor(accessibilitat.getValor());
		
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
					
					Integer codiAccessibilitat =us.generateIdAccessibilitat();
					Integer codiLocal = accessibilitat.getCodiLocal();
					Integer codiCaracteristica = accessibilitat.getCodiCaracterisitca();
					Integer valor = accessibilitat.getValor();
					String verificat = accessibilitat.getVerificat();

					
					String query="INSERT INTO eaccessible.accessibilitat (codiaccessibilitat, codilocal, codicaracteristica, valor, verificat) VALUES ("+codiAccessibilitat+","+codiLocal+","+codiCaracteristica+","+valor+",'"+verificat+"');";
					
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
			throw new BasicException(500, "S'ha produit un error en la Base de dades. Accessibilitat");
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
	public ArrayList<Accessibilitat> getAccessibilitatByLocalId(Integer id) throws BasicException,Exception{
		
		Connection connection = null;
		ArrayList<Accessibilitat> fullAccessibilitat = new ArrayList<>();
		
	
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
					
					
					String query = "SELECT * FROM eaccessible.accessibilitat where codilocal="+id;
					try {
						Statement state = connection.createStatement();
						ResultSet res = state.executeQuery(query);
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
						throw new BasicException(500,"No s'ha pogut crear un Statement.");
					}
					connection.close();
				}
			}
			
		}catch(Exception exception) {
			throw new BasicException(404, "El full d'accessibilitat amb identificador "+id+" no existeix.");
		}
		finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				throw new BasicException(500,ex.toString());
			}
		}
		
		return fullAccessibilitat;
		
	}
	@WebMethod
	public List<Local> getAllLocals() throws BasicException{
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
					
					String query = "select * from eAccessible.local";
					
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
	public List<CaracteristicaTipoLocal> getCharacteristics(Integer codiTipoLocal) throws BasicException{
		List<CaracteristicaTipoLocal> characteristics = new ArrayList<CaracteristicaTipoLocal>();
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
					
					String query = "select * from eAccessible.caracteristicatipolocal where coditipolocal="+codiTipoLocal;
					
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
						while(rs.next()) {
							CaracteristicaTipoLocal caracteristicaTipoLocal = new CaracteristicaTipoLocal();
							caracteristicaTipoLocal.setCodiCaracteristicaTipoLocal(rs.getInt("codicaracteristicatipolocal"));;
							caracteristicaTipoLocal.setCodiCaracteristica(rs.getInt("codicaracteristica"));
							caracteristicaTipoLocal.setCodiTipoLocal(rs.getInt("coditipolocal"));
							characteristics.add(caracteristicaTipoLocal);
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
		
		return characteristics;
	}


	public List<Local> getLocalsbyTipusAndName(Integer codiTipoLocal, String nomLocal) throws BasicException{
		List<Local> local = new ArrayList<Local>();
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
					
					String query = "select * from eAccessible.local where nomlocal LIKE UPPER('%"+nomLocal+"%') and coditipolocal="+codiTipoLocal;
					
					try {
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(query);
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
		
		return local;
	}
	
}
