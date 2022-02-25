package com.dungeos.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.dungeos.entities.User;

@Stateless
public class LoginService {
	@PersistenceContext(unitName="LoginDungeos-JPA")
	private EntityManager entityManager;
	
	public boolean existe (User user) {
		TypedQuery<User> query = entityManager
				.createQuery(
						"select u from User u where u.email=:pEmail and u.senha=:pSenha",
						User.class);
		query.setParameter("pEmail", user.getEmail());
		query.setParameter("pSenha", user.getSenha());
		
		try {
			User resultado = query.getSingleResult();
		}catch (NoResultException ex) {
			return false;
		}
			return true;
	}
	
}
