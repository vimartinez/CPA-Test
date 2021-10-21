package ar.com.correoargentino.cpa.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ar.com.correoargentino.cpa.model.DomicilioBaseCPA;

public class DomicilioRepositoryCustomImpl implements DomicilioRepositoryCustom{
	@PersistenceContext
    EntityManager entityManager;

	@Override
	public Iterable<DomicilioBaseCPA> getAllPosiblesDomiciliosProvDeptoLocalidadCalle(String provincia,	String departamento, String localidad, String calle) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DomicilioBaseCPA> query = cb.createQuery(DomicilioBaseCPA.class);
        Root<DomicilioBaseCPA> root = query.from(DomicilioBaseCPA.class);
 
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.and(cb.like(root.get("provincia"), "%"+provincia+"%")));
        predicates.add(cb.and(cb.like(root.get("departamento"), "%"+departamento+"%")));
        predicates.add(cb.and(cb.like(root.get("localidad"), "%"+localidad+"%")));
        predicates.add(cb.and(cb.like(root.get("calleLargo"), "%"+calle+"%")));
        query.select(root)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        
        return entityManager.createQuery(query).getResultList();
	}

	@Override
	public Iterable<DomicilioBaseCPA> getAllPosiblesDomiciliosProvDeptoCalle(String provincia, String departamento,	String calle) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DomicilioBaseCPA> query = cb.createQuery(DomicilioBaseCPA.class);
        Root<DomicilioBaseCPA> root = query.from(DomicilioBaseCPA.class);
 
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.and(cb.like(root.get("provincia"), "%"+provincia+"%")));
        predicates.add(cb.and(cb.like(root.get("departamento"), "%"+departamento+"%")));
        predicates.add(cb.and(cb.like(root.get("calleLargo"), "%"+calle+"%")));
        query.select(root)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        
        return entityManager.createQuery(query).getResultList();
	}

	@Override
	public Iterable<DomicilioBaseCPA> getAllPosiblesDomiciliosProvCalle(String provincia, String calle) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DomicilioBaseCPA> query = cb.createQuery(DomicilioBaseCPA.class);
        Root<DomicilioBaseCPA> root = query.from(DomicilioBaseCPA.class);
 
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.and(cb.like(root.get("provincia"), "%"+provincia+"%")));
        predicates.add(cb.and(cb.like(root.get("calleLargo"), "%"+calle+"%")));
        query.select(root)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        
        return entityManager.createQuery(query).getResultList();
	}

}
