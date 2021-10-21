package ar.com.correoargentino.cpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.correoargentino.cpa.model.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>, DepartamentoRepositoryCustom {

	

}
