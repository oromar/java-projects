package com.globalsoft.business;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import com.globalsoft.dao.DAO;
import com.globalsoft.entities.Entity;
import com.globalsoft.util.Util;

public class AbstractBO<T extends Entity> implements BusinessObject<T> {

	private DAO<T> repository;
	
	public AbstractBO(DAO<T> repository) {
		this.repository = repository;
	}
	
	@Override
	public boolean exists(Serializable key) throws Exception {
		return repository.exists(key);
	}

	@Override
	public void create(T entity) throws Exception {
		handleEntityToCreateOrUpdate(entity);
		repository.create(entity);
	}

	@Override
	public void update(T entity) throws Exception {
		handleEntityToCreateOrUpdate(entity);
		repository.update(entity);
	}

	@Override
	public void remove(Serializable key) throws Exception {
		repository.remove(key);		
	}

	@Override
	public T find(Serializable key) throws Exception {
		return repository.find(key);
	}

	@Override
	public T[] findAll() throws Exception {
		return repository.findAll();
	}

	@Override
	public Collection<T> filter(T entity) {
		return repository.filter(entity);
	}

	@Override
	public Collection<T> findCollectionByHQL(String hql, Map<String, Object> parameters) {
		return repository.findCollectionByHQL(hql, parameters);
	}

	@Override
	public T findUniqueByHQL(String hql, Map<String, Object> parameters) {
		return repository.findUniqueByHQL(hql, parameters);
	}
	
	private void handleEntityToCreateOrUpdate(T entity) throws Exception {
		entity.validate();
		Util.toUpperCaseAllStrings(entity);
	}
}
