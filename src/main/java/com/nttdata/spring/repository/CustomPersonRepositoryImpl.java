package com.nttdata.spring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * 
 * @author Jose
 *
 * Repositorio personalizado
 */
public class CustomPersonRepositoryImpl implements CustomPersonRepository {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List <Person> getResidentByNameAndSurnames(final String name, final String surnames) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Person> cq = cb.createQuery(Person.class);
		
		Root<Person> person = cq.from(Person.class);
		
		final Predicate p1 = cb.like(person.<String> get("name"), name);
		final Predicate p2 = cb.like(person.<String> get("surnames"),surnames);
		
		cq.select(person).where(cb.and(p1,p2));
		
		return em.createQuery(cq).getResultList();
	}

	

}
