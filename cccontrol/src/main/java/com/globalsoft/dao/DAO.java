package com.globalsoft.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import com.globalsoft.entities.Entity;

public interface DAO <T extends Entity> {

	boolean exists(Serializable key)throws Exception;
	void create(T entity) throws Exception;
	void update(T entity) throws Exception;
	void remove(Serializable key) throws Exception;
	T find(Serializable key) throws Exception;
	T[] findAll()throws Exception;
	Collection<T> filter(T entity);
	Collection<T> findCollectionByHQL(String hql, Map<String, Object> parameters);
	T findUniqueByHQL(String hql, Map<String, Object> parameters);
}
