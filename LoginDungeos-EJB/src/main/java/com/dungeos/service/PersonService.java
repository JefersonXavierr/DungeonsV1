package com.dungeos.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;

import com.dungeos.entities.Person;
import com.dungeos.entities.User;

@Stateful
public class PersonService {

	@PersistenceContext(unitName = "LoginDungeos-JPA")
	private EntityManager entityManager;

	public void create(Person person) {

		entityManager.persist(person);

	}

	public void merge(Person person) {
		entityManager.merge(person);

	}

	public void remove(Person person) {
		Person p = new Person();
		p = entityManager.find(Person.class, person.getIdperson());

		entityManager.remove(p);

	}

	public List<Person> list() {
		return entityManager.createQuery("FROM Person p", Person.class).getResultList();
	}
}
