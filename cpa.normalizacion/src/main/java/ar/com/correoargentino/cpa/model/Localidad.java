package ar.com.correoargentino.cpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Localidad {
	
	private String departamento;
	@Id
	private String localidad;
	
	public Localidad() {
		
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
