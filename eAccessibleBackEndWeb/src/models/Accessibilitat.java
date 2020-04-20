package models;

public class Accessibilitat {
	private Integer codiAccessibilitat;
	private Integer codiLocal;
	private Integer codiCaracterisitca;
	private Integer valor;
	private String verificat;
	
	public Integer getCodiAccessibilitat() {
		return codiAccessibilitat;
	}
	
	public void setCodiAccessibilitat(Integer codiAccessibilitat) {
		this.codiAccessibilitat = codiAccessibilitat;
	}
	
	public Integer getCodiLocal() {
		return codiLocal;
	}
	
	public void setCodiLocal(Integer codiLocal) {
		this.codiLocal = codiLocal;
	}
	
	public Integer getCodiCaracterisitca() {
		return codiCaracterisitca;
	}
	
	public void setCodiCaracterisitca(Integer codiCaracterisitca) {
		this.codiCaracterisitca = codiCaracterisitca;
	}
	
	public Integer getValor() {
		return valor;
	}
	
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	public String getVerificat() {
		return verificat;
	}
	
	public void setVerificat(String verificat) {
		this.verificat = verificat;
	}
}
