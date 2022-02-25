package com.dungeos.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

import com.dungeos.entities.Person;
import com.dungeos.entities.User;

@Stateful
public class UserService {

    @PersistenceContext(unitName="LoginDungeos-JPA")
    private EntityManager entityManager;
    
    public void create(User user) {
    	System.out.println("Teste");

    	entityManager.persist(user);
        
    }
    
    public void merge(User user) {
    	
		entityManager.merge(user);

	}
    
    public void remove(User user) {
		User u = new User();
		u = entityManager.find(User.class, user.getIduser());

		entityManager.remove(u);

	}

    public List<User> list() {
        return entityManager
            .createQuery("FROM User u", User.class)
            .getResultList();
    }
}