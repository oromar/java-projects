package com.globalsoft.business;

import com.globalsoft.dao.DAO;
import com.globalsoft.entities.Client;

public class ClientBO extends AbstractBO<Client>{

	public ClientBO(DAO<Client> repository) {
		super(repository);
	}
}
