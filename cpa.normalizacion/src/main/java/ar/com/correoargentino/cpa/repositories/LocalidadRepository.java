package ar.com.correoargentino.cpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.correoargentino.cpa.model.Localidad;

public interface LocalidadRepository extends JpaRepository<Localidad, Integer>, LocalidadRepositoryCustom {

}
