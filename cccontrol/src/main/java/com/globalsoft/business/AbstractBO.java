package com.globalsoft.business;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import com.globalsoft.dao.DAO;
import com.globalsoft.entities.Entity;
import com.globalsoft.util.Util;

public abstract class AbstractBO<T extends Entity> implements BusinessObject<T> {

	private DAO<T> repository;
	
	public AbstractBO(DAO<T> repository) {
		this.repository = repository;
	}
	
	public boolean exists(Serializable key) throws Exception {
		return repository.exists(key);
	}

	public void create(T entity) throws Exception {
		handleEntityToCreateOrUpdate(entity);
		repository.create(entity);
	}

	public void update(T entity) throws Exception {
		handleEntityToCreateOrUpdate(entity);
		repository.update(entity);
	}

	public void remove(Serializable key) throws Exception {
		repository.remove(key);		
	}

	public T find(Serializable key) throws Exception {
		return repository.find(key);
	}

	public T[] findAll() throws Exception {
		return repository.findAll();
	}

	public Collection<T> filter(T entity) {
		return repository.filter(entity);
	}

	public Collection<T> findCollectionByHQL(String hql, Map<String, Object> parameters) {
		return repository.findCollectionByHQL(hql, parameters);
	}

	public T findUniqueByHQL(String hql, Map<String, Object> parameters) {
		return repository.findUniqueByHQL(hql, parameters);
	}
	
	private void handleEntityToCreateOrUpdate(T entity) throws Exception {
		entity.validate();
		Util.toUpperCaseAllStrings(entity);
	}

	public DAO<T> getRepository() {
		return repository;
	}

	public void setRepository(DAO<T> repository) {
		this.repository = repository;
	}
}
