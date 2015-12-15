package com.globalsoft.business;

import com.globalsoft.dao.DAO;
import com.globalsoft.entities.Supplier;

public class SupplierBO extends AbstractBO<Supplier> {

	public SupplierBO(DAO<Supplier> repository) {
		super(repository);
	}

}
