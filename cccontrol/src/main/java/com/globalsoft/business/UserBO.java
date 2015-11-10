package com.globalsoft.business;

import com.globalsoft.dao.DAO;
import com.globalsoft.dao.UserDAO;
import com.globalsoft.entities.User;
import com.globalsoft.util.Util;

public class UserBO extends AbstractBO<User> {

	public UserBO(DAO<User> repository) {
		super(repository);
	}
	
	@Override
	public void create(User entity) throws Exception {
		String pass = entity.getPassword();
		entity.setPassword(Util.hashPassword(pass));
		super.create(entity);
	}
	
	public User login(String login, String password){
		String pass = Util.hashPassword(password);
		return ((UserDAO) getRepository()).login(login, pass);
	}
}
