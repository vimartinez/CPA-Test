package ar.com.correoargentino.cpa.repositories;

import ar.com.correoargentino.cpa.model.Provincia;

public interface ProvinciaRepositoryCustom {
	Iterable<Provincia> getProvinciasPorNombre(String nombre);

}
