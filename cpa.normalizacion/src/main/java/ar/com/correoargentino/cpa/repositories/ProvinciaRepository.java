package ar.com.correoargentino.cpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.com.correoargentino.cpa.model.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer>, ProvinciaRepositoryCustom {

}
