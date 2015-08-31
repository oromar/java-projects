package com.globalsoft.business;

import com.globalsoft.dao.DAO;
import com.globalsoft.entities.User;

public class UserBO extends AbstractBO<User> {

	public UserBO(DAO<User> repository) {
		super(repository);
	}
}
