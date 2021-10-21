package ar.com.correoargentino.cpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name="DEPTO_SEQ", sequenceName="seq_departamento")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DEPTO_SEQ")
	private Integer deptoId;
	private String provNombre;
	private String deptoNombre;
	/*@ManyToOne(fetch = FetchType.EAGER,cascade={CascadeType.ALL})
	private Provincia provincia;*/
	
	public Departamento() {
		
	}

	public Departamento(Integer deptoId, String provNombre, String deptoNombre) {
		super();
		this.deptoId = deptoId;
		this.provNombre = provNombre;
		this.deptoNombre = deptoNombre;
	}

	public Integer getDeptoId() {
		return deptoId;
	}

	public void setDeptoId(Integer deptoId) {
		this.deptoId = deptoId;
	}

	public String getProvNombre() {
		return provNombre;
	}

	public void setProvNombre(String provNombre) {
		this.provNombre = provNombre;
	}

	public String getDeptoNombre() {
		return deptoNombre;
	}

	public void setDeptoNombre(String deptoNombre) {
		this.deptoNombre = deptoNombre;
	}
	
}
