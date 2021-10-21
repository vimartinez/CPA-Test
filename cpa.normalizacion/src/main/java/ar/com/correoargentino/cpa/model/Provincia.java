package ar.com.correoargentino.cpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="PROV_SEQ", sequenceName="seq_provincia")
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PROV_SEQ")
	private Integer provId;
	private String provNombre;
	
	public Provincia() {
		
	}

	public Provincia(Integer provId, String provNombre) {
		super();
		this.provId = provId;
		this.provNombre = provNombre;
	}

	public Integer getProvId() {
		return provId;
	}

	public void setProvId(Integer provId) {
		this.provId = provId;
	}

	public String getProvNombre() {
		return provNombre;
	}

	public void setProvNombre(String provNombre) {
		this.provNombre = provNombre;
	}
	

}
