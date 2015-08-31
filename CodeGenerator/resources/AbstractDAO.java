package resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import BASE_PACKAGE.entidades.EntidadeBasica;

/*
 * Em : DATA_CRIACAO_ARQUIVO
 * 
 * */

@SuppressWarnings("unchecked")
public class AbstractDAO<T extends EntidadeBasica> {

	private EntityManager manager;
	private Class<?> clazz;
	private Map<Integer, T> entityCache;
	private Map<Map<String, Object>, List<T>> queryCache;
	private Map<Map<String, String>, List<T>> generalFilterQueryCache;

	public AbstractDAO() {
		manager = Persistence.createEntityManagerFactory("NOME_UNIDADE_PERSISTENCIA").createEntityManager();
		entityCache = new HashMap<Integer, T>();
		queryCache = new HashMap<Map<String,Object>, List<T>>();
		generalFilterQueryCache = new HashMap<Map<String,String>, List<T>>();
	}

	public T save(T t) {
		T retorno = null;
		try{
			manager.getTransaction().begin();
			retorno = manager.merge(t);
			entityCache.put(retorno.getId(), retorno);
		} finally {
			manager.getTransaction().commit();
		}
		return retorno;
	}

	public T remove(T t){
		try{
			manager.getTransaction().begin();
			manager.remove(t);
			entityCache.remove(t.getId());
			return t;
		} finally {
			manager.getTransaction().commit();
		}
	}

	public T update(T t){
		return save(t);
	}


	public T findById(Serializable id, Class<?> clazz){
		T retorno = entityCache.get(id);
		if (retorno == null) {
			Class<?> entityClass = clazz != null ? clazz : this.clazz;
			retorno = (T) manager.find(entityClass, id);
			entityCache.put(retorno.getId(), retorno);
		}
		return retorno;
	}

	public List<? extends EntidadeBasica> list(Class<? extends EntidadeBasica> clazz) {
		Class<?> entityClass;
		entityClass = (Class<?>) clazz != null ? clazz : this.clazz;
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<T> query = (CriteriaQuery<T>) criteriaBuilder.createQuery(entityClass);
		Root<T> root = (Root<T>) query.from(entityClass);
		query.select(root);
		query.where(criteriaBuilder.equal(root.get("removido"), false));
		List<T> retorno = manager.createQuery(query).getResultList();
		return retorno;
	}

	public List<? extends EntidadeBasica> listByFilter(Map<String, Object> filter, Class<? extends EntidadeBasica> clazz) {
		List<T> retorno = queryCache.get(filter);
		if (retorno == null) {
			Class<?> entityClass = clazz != null ? clazz : this.clazz;
			CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
			CriteriaQuery<T> query = (CriteriaQuery<T>) criteriaBuilder.createQuery(entityClass);
			Root<T> root = (Root<T>) query.from(entityClass);
			query.select(root);
			List<Predicate> predicates = new ArrayList<Predicate>();
			predicates.add(criteriaBuilder.equal(root.get("removido"), false));
			for (String s : filter.keySet()) {
				if (filter.get(s) instanceof String) {
					Path<String> colunas = (Path<String>) separatePath(root, s);
					predicates.add(criteriaBuilder.like(criteriaBuilder.upper(colunas), "%" + filter.get(s).toString().toUpperCase() + "%"));
				} else if (filter.get(s) instanceof Date || filter.get(s) instanceof Number) {
					predicates.add(criteriaBuilder.equal(root.get(s), filter.get(s)));
				} 
			}
			query.where(predicates.toArray(new Predicate[]{}));
			retorno = manager.createQuery(query).getResultList();
			queryCache.put(filter, retorno);
		}
		return retorno;
	}

	public List<? extends EntidadeBasica> listByGeneralFilter(Map<String, String> filter, Class<? extends EntidadeBasica> clazz) {
		List<T> retorno = generalFilterQueryCache.get(filter);
		if (retorno == null) {
			Class<?> entityClass = clazz != null ? clazz : this.clazz;
			CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
			CriteriaQuery<T> query = (CriteriaQuery<T>) criteriaBuilder.createQuery(entityClass);
			Root<T> root = (Root<T>) query.from(entityClass);
			query.select(root);
			List<Predicate> predicates = new ArrayList<Predicate>();
			Predicate predicateRemovido = criteriaBuilder.equal(root.get("removido"), false);
			for (String s : filter.keySet()) {
				if (root.get(s) != null) {
					if (filter.get(s) instanceof String) {
						predicates.add(criteriaBuilder.like(criteriaBuilder.upper((Expression) root.get(s)), "%" + filter.get(s).toString().toUpperCase() + "%"));
					}
				}
			}
			query.where(criteriaBuilder.and(criteriaBuilder.or(predicates.toArray(new Predicate[]{})), predicateRemovido));
			retorno = manager.createQuery(query).getResultList();
			generalFilterQueryCache.put(filter, retorno);
		}
		return retorno;
	}

	private Path<?> separatePath(Root<T> root, String field) {
		Path<?> path = root;
		try {
			String[] sortCols = field.split("\\.");
			for (String sc : sortCols) {
				path = path.get(sc);
			}
		} catch (Exception e) {

		}
		return path;
	}

	/**
	 * @return the clazz
	 */
	public Class<?> getClazz() {
		return clazz;
	}

	/**
	 * @param clazz the clazz to set
	 */
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	/**
	 * @return the manager
	 */
	public EntityManager getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
}
