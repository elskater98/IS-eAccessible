package models;

public class Incidencia {

	Integer codiIncidencia;
	String data;
	String dataHora;
	
	public Integer getCodiIncidencia() {
		return codiIncidencia;
	}
	public void setCodiIncidencia(Integer codiIncidencia) {
		this.codiIncidencia = codiIncidencia;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	public Integer getCodiTipusIncidencia() {
		return codiTipusIncidencia;
	}
	public void setCodiTipusIncidencia(Integer codiTipusIncidencia) {
		this.codiTipusIncidencia = codiTipusIncidencia;
	}
	Integer codiTipusIncidencia;
}
