package com.globalsoft.business;

import com.globalsoft.dao.DAO;
import com.globalsoft.entities.Role;

public class RoleBO extends AbstractBO<Role> {

	public RoleBO(DAO<Role> repository) {
		super(repository);
	}

}
