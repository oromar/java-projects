package com.globalsoft.business;

import com.globalsoft.dao.DAO;
import com.globalsoft.entities.Category;

public class CategoryBO extends AbstractBO<Category> {

	public CategoryBO(DAO<Category> repository) {
		super(repository);
	}
}
