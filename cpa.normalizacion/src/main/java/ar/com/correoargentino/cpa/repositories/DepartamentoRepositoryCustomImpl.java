package ar.com.correoargentino.cpa.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ar.com.correoargentino.cpa.model.Departamento;

public class DepartamentoRepositoryCustomImpl implements DepartamentoRepositoryCustom{
	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public Iterable<Departamento> getDepartamentosPorNombre(String nombre) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Departamento> query = cb.createQuery(Departamento.class);
        Root<Departamento> root = query.from(Departamento.class);
 
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.and(cb.like(root.get("deptoNombre"), "%"+nombre+"%")));
        query.select(root)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        
        return entityManager.createQuery(query).getResultList();
	}

	@Override
	public Iterable<Departamento> getDepartamentosPorNombreYProvincia(String nombreDepto, String nombreProv) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Departamento> query = cb.createQuery(Departamento.class);
        Root<Departamento> root = query.from(Departamento.class);
 
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.and(cb.like(root.get("deptoNombre"), "%"+nombreDepto+"%")));
        predicates.add(cb.and(cb.like(root.get("provNombre"), "%"+nombreProv+"%")));
        query.select(root)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        
        return entityManager.createQuery(query).getResultList();
	}

	@Override
	public Iterable<Departamento> getDepartamentosPorProvincia(String nombre) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Departamento> query = cb.createQuery(Departamento.class);
        Root<Departamento> root = query.from(Departamento.class);
 
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.and(cb.like(root.get("provNombre"), "%"+nombre+"%")));
        query.select(root)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        
        return entityManager.createQuery(query).getResultList();
	}

}
