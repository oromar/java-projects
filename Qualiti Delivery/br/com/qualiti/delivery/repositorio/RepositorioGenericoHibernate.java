package br.com.qualiti.delivery.repositorio;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import br.com.qualiti.delivery.interfaces.EntidadeBasica;
import br.com.qualiti.delivery.interfaces.RepositorioHibernate;
import org.hibernate.criterion.Restrictions;

public abstract class RepositorioGenericoHibernate<T extends EntidadeBasica> implements RepositorioHibernate<T>{

	protected EntityManager manager;
	protected Class<T> clazz;

	public RepositorioGenericoHibernate() {            
		manager = Persistence.createEntityManagerFactory("Qualiti_Delivery").createEntityManager();
		this.clazz =  (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];;
	}

	@Override
	public boolean existe(Serializable chave) throws Exception {
		return procurar(chave) != null;
	}

	@Override
	public void inserir(T entidade) throws Exception {
		try{
			manager.getTransaction().begin();
			manager.persist(entidade);
			manager.getTransaction().commit();
		}catch(HibernateException e ){
			manager.getTransaction().rollback();
		}
	}

	@Override
	public void atualizar(T entidade) throws Exception {
		try{
			manager.getTransaction().begin();
			manager.merge(entidade);
			manager.getTransaction().commit();
		}catch(HibernateException e ){
			manager.getTransaction().rollback();
		}
	}

	@Override
	public void remover(Serializable chave) throws Exception {
		try {
			manager.getTransaction().begin();
			manager.remove(procurar(chave));
			manager.getTransaction().commit();
		} catch(HibernateException e ){
			manager.getTransaction().rollback();
		}
	}

	@Override
	public T procurar(Serializable chave) throws Exception {
		return (T) manager.find(clazz, chave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] buscarTodos() throws Exception {
		T[] result = null;
		Session session = (Session) manager.getDelegate();
		Criteria c = session.createCriteria(clazz);
		List<T> list = c.list();
		result = list.toArray((T[]) Array.newInstance(clazz, list.size()));
		return result;
	}

	@Override
	public Collection<T> filtrar(T t) {
		Session session = (Session) manager.getDelegate();
		Criteria criteria = session.createCriteria(clazz);
		Example example = Example.create(t)
				.enableLike(MatchMode.ANYWHERE)
				.ignoreCase();
                criteria.add(example);
                return criteria.list();
	}

	@Override
	public Collection<T> findCollectionByHQL(String hql,
			Map<String, Object> parameters) {

		Query query = manager.createQuery(hql, clazz);

		for (Map.Entry<String, Object> map : parameters.entrySet()) {
			query.setParameter(map.getKey(), map.getValue());
		}

		return query.getResultList();
	}

	@Override
	public T findUniqueByHQL(String hql, Map<String, Object> parameters) {
		
		Query query = manager.createQuery(hql, clazz);

		for (Map.Entry<String, Object> map : parameters.entrySet()) {
			query.setParameter(map.getKey(), map.getValue());
		}

		return (T) query.getSingleResult();
	}

}
