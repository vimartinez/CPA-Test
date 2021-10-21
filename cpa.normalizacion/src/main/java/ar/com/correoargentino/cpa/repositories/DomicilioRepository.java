package ar.com.correoargentino.cpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.com.correoargentino.cpa.model.DomicilioBaseCPA;


public interface DomicilioRepository extends JpaRepository<DomicilioBaseCPA, Integer>,DomicilioRepositoryCustom {
	
	@Query(value = "SELECT * FROM domicilio_basecpa WHERE provincia = ?1 AND departamento = ?2 AND calle_largo = ?3", nativeQuery = true)
	Iterable<DomicilioBaseCPA> getAllPosiblesDomicilios(String prov, String depto, String calle);

		
}
