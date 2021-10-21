package ar.com.correoargentino.cpa.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ar.com.correoargentino.cpa.model.Localidad;

public class LocalidadRepositoryCustomImpl implements LocalidadRepositoryCustom {
	@PersistenceContext
    EntityManager entityManager;

	@Override
	public Iterable<Localidad> getLocalidadesPorNombre(String nombre) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Localidad> query = cb.createQuery(Localidad.class);
        Root<Localidad> root = query.from(Localidad.class);
 
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.and(cb.like(root.get("localidad"), "%"+nombre+"%")));
        query.select(root)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        
        return entityManager.createQuery(query).getResultList();
	}

	@Override
	public Iterable<Localidad> getLocalidadesPorDepartamento(String nombre) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Localidad> query = cb.createQuery(Localidad.class);
        Root<Localidad> root = query.from(Localidad.class);
 
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.and(cb.like(root.get("departamento"), "%"+nombre+"%")));
        query.select(root)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        
        return entityManager.createQuery(query).getResultList();
	}

}
