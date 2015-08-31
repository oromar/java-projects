package br.com.qualiti.delivery.interfaces;

import java.util.Collection;
import java.util.Map;

public interface RepositorioHibernate<T extends EntidadeBasica> extends Repositorio<T> {

	Collection<T> filtrar(T t);
	Collection<T> findCollectionByHQL(String hql, Map<String, Object> parameters);
	T findUniqueByHQL(String hql, Map<String, Object> parameters);
}
