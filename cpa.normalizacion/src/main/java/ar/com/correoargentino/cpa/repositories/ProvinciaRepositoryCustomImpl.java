package ar.com.correoargentino.cpa.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ar.com.correoargentino.cpa.model.Provincia;


public class ProvinciaRepositoryCustomImpl implements ProvinciaRepositoryCustom {

	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public Iterable<Provincia> getProvinciasPorNombre(String nombre) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Provincia> query = cb.createQuery(Provincia.class);
        Root<Provincia> root = query.from(Provincia.class);
 
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.and(cb.like(root.get("provNombre"), "%"+nombre+"%")));
        query.select(root)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        
        return entityManager.createQuery(query).getResultList();
	}

}
