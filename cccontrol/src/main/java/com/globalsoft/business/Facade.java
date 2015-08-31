package com.globalsoft.business;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import com.globalsoft.dao.UserDAO;
import com.globalsoft.entities.User;

public class Facade {
	
	private static Facade instance;
	private UserBO userBO; 
	
	private Facade(){
		init();
	}

	public static Facade getInstance() {
		if (instance == null) {
			instance = new Facade();			
		}
		return instance;
	}
	
	private void init() {
		userBO = new UserBO(new UserDAO());
	}

	public boolean exists(Serializable key) throws Exception {
		return userBO.exists(key);
	}

	public void create(User entity) throws Exception {
		userBO.create(entity);
	}

	public void update(User entity) throws Exception {
		userBO.update(entity);
	}

	public void remove(Serializable key) throws Exception {
		userBO.remove(key);
	}

	public User find(Serializable key) throws Exception {
		return userBO.find(key);
	}

	public User[] findAll() throws Exception {
		return userBO.findAll();
	}

	public Collection<User> filter(User entity) {
		return userBO.filter(entity);
	}

	public Collection<User> findCollectionByHQL(String hql,
			Map<String, Object> parameters) {
		return userBO.findCollectionByHQL(hql, parameters);
	}

	public User findUniqueByHQL(String hql, Map<String, Object> parameters) {
		return userBO.findUniqueByHQL(hql, parameters);
	}
}
