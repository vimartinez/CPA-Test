package ar.com.correoargentino.cpa.model;

public class Domicilio {
	private String provincia;
	private String departamento;
	private String localidad;
	private String barrio;
	private String direccion;
	private String calle;
	private Integer numero;
	
	public Domicilio(String provincia, String departamento, String localidad, String barrio, String direccion,
			String calle, Integer numero) {
		super();
		this.provincia = provincia;
		this.departamento = departamento;
		this.localidad = localidad;
		this.barrio = barrio;
		this.direccion = direccion;
		this.calle = calle;
		this.numero = numero;
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

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	

}
