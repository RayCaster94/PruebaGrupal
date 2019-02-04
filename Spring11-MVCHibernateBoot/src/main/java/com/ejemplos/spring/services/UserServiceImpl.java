package com.ejemplos.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.dao.UserDAO;
import com.ejemplos.spring.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	/*
	 * public UserServiceImpl(){
	 * 
	 * }
	 * 
	 * public UserServiceImpl(UserDAO userDAO) { super(); this.userDAO =
	 * userDAO; }
	 */

	@Override
	public List<User> list() {
		return userDAO.list();
	}

	@Override
	public User get(int id) {
		return userDAO.get(id);
	}

	@Override
	public void update(User user) {
		userDAO.update(user);
	}

	@Override
	public void add(User user) {
		userDAO.add(user);
	}

	@Override
	public void delete(int id) {
		userDAO.delete(id);
	}

}
