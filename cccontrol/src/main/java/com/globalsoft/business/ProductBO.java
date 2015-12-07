package com.globalsoft.business;

import com.globalsoft.dao.DAO;
import com.globalsoft.entities.Product;

public class ProductBO extends AbstractBO<Product> {

	public ProductBO(DAO<Product> repository) {
		super(repository);
	}

}
