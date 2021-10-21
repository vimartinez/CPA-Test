package ar.com.correoargentino.cpa.repositories;

import ar.com.correoargentino.cpa.model.Departamento;

public interface DepartamentoRepositoryCustom {
	Iterable<Departamento> getDepartamentosPorNombre(String nombre);
	Iterable<Departamento> getDepartamentosPorProvincia(String nombre);
	Iterable<Departamento> getDepartamentosPorNombreYProvincia(String nombreDepto, String nombreProv);

}
