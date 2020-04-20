package models;

public class Local {
	private Integer codiLocal;
    private Integer coditipoLocal;
    private Integer codiCarrer;
    private String nomCarrer;
    private String nomVia;
    private Integer numero;
    private String nomLocal;
    private String observacions;
    private String verificat;
    
    public Integer getCodiLocal() {
		return codiLocal;
	}
    
	public void setCodiLocal(Integer codiLocal) {
		this.codiLocal = codiLocal;
	}
	
	public Integer getCoditipoLocal() {
		return coditipoLocal;
	}
	
	public void setCoditipoLocal(Integer coditipoLocal) {
		this.coditipoLocal = coditipoLocal;
	}
	
	public Integer getCodiCarrer() {
		return codiCarrer;
	}
	
	public void setCodiCarrer(Integer codiCarrer) {
		this.codiCarrer = codiCarrer;
	}
	
	public String getNomCarrer() {
		return nomCarrer;
	}
	
	public void setNomCarrer(String nomCarrer) {
		this.nomCarrer = nomCarrer;
	}
	
	public String getNomVia() {
		return nomVia;
	}
	
	public void setNomVia(String nomVia) {
		this.nomVia = nomVia;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getNomLocal() {
		return nomLocal;
	}
	
	public void setNomLocal(String nomLocal) {
		this.nomLocal = nomLocal;
	}
	
	public String getObservacions() {
		return observacions;
	}
	
	public void setObservacions(String observacions) {
		this.observacions = observacions;
	}
	
	public String getVerificat() {
		return verificat;
	}
	
	public void setVerificat(String verificat) {
		this.verificat = verificat;
	}
}
