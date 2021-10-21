package ar.com.correoargentino.cpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class DomicilioBaseCPA {
	private String provincia;
	private String departamento;
	private String localidad;
	private String calleLargo;
	private String calleApellido;
	private String calleNombre;
	private String calleAntepone;
	private String puntoCardinal;
	private String calleNormalizada;
	private String tipo;
	@Id
	private String cpa8;
	private Integer desde;
	private Integer hasta;
	private String tipo2;
	private String cp4;
	
	
	public DomicilioBaseCPA() {
		
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getCalleLargo() {
		return calleLargo;
	}


	public void setCalleLargo(String calleLargo) {
		this.calleLargo = calleLargo;
	}


	public String getCalleApellido() {
		return calleApellido;
	}


	public void setCalleApellido(String calleApellido) {
		this.calleApellido = calleApellido;
	}


	public String getCalleNombre() {
		return calleNombre;
	}


	public void setCalleNombre(String calleNombre) {
		this.calleNombre = calleNombre;
	}


	public String getCalleAntepone() {
		return calleAntepone;
	}


	public void setCalleAntepone(String calleAntepone) {
		this.calleAntepone = calleAntepone;
	}


	public String getPuntoCardinal() {
		return puntoCardinal;
	}


	public void setPuntoCardinal(String puntoCardinal) {
		this.puntoCardinal = puntoCardinal;
	}


	public String getCalleNormalizada() {
		return calleNormalizada;
	}


	public void setCalleNormalizada(String calleNormalizada) {
		this.calleNormalizada = calleNormalizada;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getCpa8() {
		return cpa8;
	}


	public void setCpa8(String cpa8) {
		this.cpa8 = cpa8;
	}


	public Integer getDesde() {
		return desde;
	}


	public void setDesde(Integer desde) {
		this.desde = desde;
	}


	public Integer getHasta() {
		return hasta;
	}


	public void setHasta(Integer hasta) {
		this.hasta = hasta;
	}


	public String getTipo2() {
		return tipo2;
	}


	public void setTipo2(String tipo2) {
		this.tipo2 = tipo2;
	}


	public String getCp4() {
		return cp4;
	}


	public void setCp4(String cp4) {
		this.cp4 = cp4;
	}
	
	

}
