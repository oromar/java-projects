package com.globalsoft.dao;

import java.util.HashMap;
import java.util.Map;

import com.globalsoft.entities.User;

public class UserDAO extends AbstractDAO<User> {
	
	public User login(String login, String password) {
		String hql = "From User user where user.login = :login and user.password = :password";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("login", login);
		parameters.put("password", password); 
		return findUniqueByHQL(hql, parameters);
	}
}
