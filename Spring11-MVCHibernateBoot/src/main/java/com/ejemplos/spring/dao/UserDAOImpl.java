package com.ejemplos.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplos.spring.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;	

	public UserDAOImpl() {
		
	}
	
	public User getUserById(int id) {
		return entityManager.find(User.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> list() {	
		
		String hql = "FROM User ORDER BY USER_ID";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}
	
	//SaveOrUpdate es solo de Hibernate
	//El problema es que si uso  entityManager.persist(user)   fallaria el EDIT
	@Override
	public void add(User user) {
		entityManager.merge(user);
	}
	
	
	//A priori no empleo este metodo. EDIT y SAVE usan el anterior
	@Override
	public void update(User user) {
		User usuario = getUserById(user.getId());

		usuario.setUsername(user.getUsername());
		usuario.setEmail(user.getEmail());
		usuario.setPassword(user.getPassword());

		entityManager.flush();
	}


	@Override
	@Transactional
	public void delete(int id) {
		entityManager.remove(getUserById(id));
	}

	@Override
	@Transactional
	public User get(int id) {
		return entityManager.find(User.class, id);
	}
}