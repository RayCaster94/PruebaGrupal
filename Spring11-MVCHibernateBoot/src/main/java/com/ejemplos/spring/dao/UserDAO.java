package com.ejemplos.spring.dao;

import java.util.List;

import com.ejemplos.spring.model.User;

public interface UserDAO {
	public List<User> list();
	
	public User get(int id);
	
	public void update(User user);
	public void add(User user);
	
	public void delete(int id);
}