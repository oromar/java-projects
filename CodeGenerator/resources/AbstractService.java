package resources;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import BASE_PACKAGE.data.AbstractDAO;
import BASE_PACKAGE.entidades.EntidadeBasica;


/*
 *
 * Em : DATA_CRIACAO_ARQUIVO
 * 
 * */


public abstract class AbstractService<T extends EntidadeBasica> {

	private AbstractDAO<T> dao;
	
	public abstract void preSave(T t)throws Exception;
	public abstract void preRemove(T t)throws Exception;
	public abstract void preUpdate(T t)throws Exception;
	public abstract void posSave(T t)throws Exception;
	public abstract void posRemove(T t)throws Exception;
	public abstract void posUpdate(T t)throws Exception;
	
	public T save(T t) throws Exception{
		T result = null;
		t.setDataInsercao(new Date());
		t.setRemovido(false);
		preSave(t);
		result = dao.save(t);
		posSave(t);
		return result;
	}
	
	
	public T remove(T t) throws Exception{
		T result = null;
		t.setDataRemocao(new Date());
		t.setRemovido(true);
		preRemove(t);
		result = dao.update(t);
		posRemove(t);
		return result;
	}
	
	public T update(T t) throws Exception{
		T result = null;
		t.setDataAlteracao(new Date());
		preUpdate(t);
		result = dao.update(t);
		posUpdate(t);
		return result;
	}
	
	public T findById(Serializable id, Class<?> clazz){
		return dao.findById(id, clazz);
	}

	public List<? extends EntidadeBasica> list(Class<? extends EntidadeBasica> clazz){
		return (List<T>) dao.list(clazz);
	}
	
	public List<? extends EntidadeBasica> listByFilter(Map<String, Object> map, Class<? extends EntidadeBasica> clazz) {
		return dao.listByFilter(map, clazz);
	}
	
	public List<? extends EntidadeBasica> listByGeneralFilter(Map<String, String> map, Class<? extends EntidadeBasica> clazz) {
		return dao.listByGeneralFilter(map, clazz);
	}
	
	/**
	 * @return the dao
	 */
	public AbstractDAO<T> getDao() {
		return dao;
	}
	/**
	 * @param dao the dao to set
	 */
	public void setDao(AbstractDAO<T> dao) {
		this.dao = dao;
	}
}


