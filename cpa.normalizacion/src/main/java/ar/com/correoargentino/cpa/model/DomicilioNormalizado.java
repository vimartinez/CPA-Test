package ar.com.correoargentino.cpa.model;

public class DomicilioNormalizado {
	private String provincia;
	private String departamento;
	private String localidad;
	private String direccion;
	private String cp4;
	private String cp8;
	
	public DomicilioNormalizado(String direccion, String cp4, String cp8) {
		super();
		this.direccion = direccion;
		this.cp4 = cp4;
		this.cp8 = cp8;
	}

	public DomicilioNormalizado() {
		
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCp4() {
		return cp4;
	}

	public void setCp4(String cp4) {
		this.cp4 = cp4;
	}

	public String getCp8() {
		return cp8;
	}

	public void setCp8(String cp8) {
		this.cp8 = cp8;
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
	

}
