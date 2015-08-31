package com.globalsoft.dao;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.globalsoft.entities.Entity;
import com.globalsoft.util.Constants;

public class AbstractDAO<T extends Entity> implements DAO<T>{

	protected EntityManager manager;
	protected Class<T> clazz;
	
	
	@SuppressWarnings("unchecked")
	public AbstractDAO() {            
		manager = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_XML_NAME).createEntityManager();
		this.clazz =  (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];;
	}

	public boolean exists(Serializable key) throws Exception {
		return find(key) != null;
	}

	public void create(T entity) throws Exception {
		try{
			entity.setRemoved(Boolean.FALSE);
			entity.setCreateDate(new Date());
			manager.getTransaction().begin();
			manager.persist(entity);
			manager.getTransaction().commit();
		}catch(Exception e ){
			manager.getTransaction().rollback();
		}
	}

	public void update(T entity) throws Exception {
		try{
			entity.setUpdateDate(new Date());
			manager.getTransaction().begin();
			manager.merge(entity);
			manager.getTransaction().commit();
		}catch(Exception e ){
			manager.getTransaction().rollback();
		}
	}

	public void remove(Serializable key) throws Exception {
		try {
			T entity = find(key);
			entity.setRemoved(Boolean.TRUE);
			entity.setRemoveDate(new Date());
			manager.getTransaction().begin();
			manager.merge(entity);
			manager.getTransaction().commit();
		} catch(Exception e ){
			manager.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public T find(Serializable key) throws Exception {
		Session session = (Session) manager.getDelegate();
		Criteria c = session.createCriteria(clazz)
				.add(Restrictions.eq(Constants.REMOVED_FIELD_NAME, Boolean.FALSE))
				.add(Restrictions.eq(Constants.ID_FIELD_NAME, key));
		return (T) c.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public T[] findAll() throws Exception {
		T[] result = null;
		Session session = (Session) manager.getDelegate();
		Criteria c = session.createCriteria(clazz)
				.add(Restrictions.eq(Constants.REMOVED_FIELD_NAME, Boolean.FALSE));
		List<T> list = c.list();
		result = list.toArray((T[]) Array.newInstance(clazz, list.size()));
		return result;
	}

	@SuppressWarnings("unchecked")
	public Collection<T> filter(T t) {
		Session session = (Session) manager.getDelegate();
		Criteria criteria = session.createCriteria(clazz)
				.add(Restrictions.eq(Constants.REMOVED_FIELD_NAME, Boolean.FALSE));
		Example example = Example.create(t)
				.enableLike(MatchMode.ANYWHERE)
				.ignoreCase();
                criteria.add(example);
                return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public Collection<T> findCollectionByHQL(String hql, Map<String, Object> parameters) {
		Query query = manager.createQuery(hql, clazz);
		for (Map.Entry<String, Object> map : parameters.entrySet()) {
			query.setParameter(map.getKey(), map.getValue());
		}
		query.setParameter(Constants.REMOVED_FIELD_NAME, Boolean.FALSE);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public T findUniqueByHQL(String hql, Map<String, Object> parameters) {
		Query query = manager.createQuery(hql, clazz);
		for (Map.Entry<String, Object> map : parameters.entrySet()) {
			query.setParameter(map.getKey(), map.getValue());
		}
		query.setParameter(Constants.REMOVED_FIELD_NAME, Boolean.FALSE);
		return (T) query.getSingleResult();
	}
}
