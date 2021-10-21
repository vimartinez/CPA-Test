package ar.com.correoargentino.cpa.repositories;

import ar.com.correoargentino.cpa.model.Localidad;

public interface LocalidadRepositoryCustom {
	Iterable<Localidad> getLocalidadesPorNombre(String nombre);
	Iterable<Localidad> getLocalidadesPorDepartamento(String nombre);
	

}
