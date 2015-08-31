package resources;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import br.com.oromar.teste.services.AbstractService;
import br.com.oromar.teste.entidades.EntidadeBasica;

/*
 *
 * Em : 04/07/2015 - 00:59:56
 * 
 * */

@ManagedBean(name="abstractManagedBean")
@ViewScoped
public abstract class AbstractManagedBean<T extends EntidadeBasica> {

	private static final int MIN_LENGTH_TO_GENERAL_FILTER = 3;

	private List<T> listaBeans;
	private T beanSelecionado;
	private T beanFiltro;
	private String filterValue;
	protected AbstractService<T> service;
	private Class<? extends EntidadeBasica> clazz;


	public AbstractManagedBean(Class<? extends EntidadeBasica> clazz) {
		super();
		this.clazz = clazz;
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		init();
	}

	@PostConstruct
	public void init(){
		try{
			this.beanSelecionado = (T) clazz.newInstance();
			this.beanFiltro = (T) clazz.newInstance();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public T save(T t) {
		T retorno = null;
		try {
			if (t.getId() != null){
				return update(t);
			}
			retorno = service.save(t);
			init();
			list();			
		} catch (Exception e) {
			showFacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar " + t.getNome() + ": " + e.getMessage(), "");
		}
		showFacesMessage(FacesMessage.SEVERITY_INFO, t.getNome() + " salvo com sucesso ", "");
		return retorno;
	}

	public T remove(T t){
		T retorno = null;
		try {
			retorno = service.remove(t);
			list();
		} catch (Exception e) {
			showFacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao remover " + t.getNome() + ": " + e.getMessage(), "");
		}
		showFacesMessage(FacesMessage.SEVERITY_INFO, t.getNome() + " removido com sucesso ", "");
		return retorno;
	}

	public T update(T t){
		T retorno = null;
		try {
			retorno = service.update(t);
			init();
			list();
		} catch (Exception e) {
			showFacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao alterar " + t.getNome() + ": " + e.getMessage(), "");
		}
		showFacesMessage(FacesMessage.SEVERITY_INFO, t.getNome() + " alterado com sucesso ", "");
		return retorno;
	}

	public T findById(Serializable id){
		return service.findById(id, clazz);
	}

	public void list(){
		this.listaBeans = (List<T>) service.list(clazz);
	}

	public void listByFilter(T filter){
		Map<String, Object> map = getBeanAsMap(filter); 					
		this.listaBeans = (List<T>) service.listByFilter(map, clazz);
	}

	public void listByGeneralFilter() {
		if (filterValue.length() % MIN_LENGTH_TO_GENERAL_FILTER != 0) {
			return;
		}
		Map<String, String> map = getMapToGeneralFilter(filterValue); 					
		this.listaBeans = (List<T>) service.listByGeneralFilter(map, clazz);
		this.filterValue = "";
	}

	public void prepareUpdate(T t) {
		setBeanSelecionado(t);
	}

	public void clear() {
		try {
			this.beanFiltro = (T) clazz.newInstance();
			this.filterValue = "";
			list();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeListener(AjaxBehaviorEvent event){
		T object = (T) event.getComponent().getAttributes().get("beanToRemove");
		remove(object);		
	}

	public void saveListener(AjaxBehaviorEvent event){
		T object = (T) event.getComponent().getAttributes().get("beanToSave");
		save(object);
	}

	public void updateListener(AjaxBehaviorEvent event){
		T object = (T) event.getComponent().getAttributes().get("beanToUpdate");
		prepareUpdate(object);
	}

	public void novoListener(AjaxBehaviorEvent event){
		init();
	}

	public void redirectListener(AjaxBehaviorEvent event){
		String to = (String) event.getComponent().getAttributes().get("toView");
		redirect(to);
	}

	public void limparListener(AjaxBehaviorEvent event){
		try {
			this.beanSelecionado = (T) clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public void clearFilterListener(AjaxBehaviorEvent event) {
		clear();
	}

	public void filterDataTable(AjaxBehaviorEvent event){
		if (filterValue != null && !filterValue.isEmpty()){
			listByGeneralFilter();
		} else {
			listByFilter(beanFiltro);
		}
	}

	private void redirect(String to){
		FacesContext
		.getCurrentInstance()
		.getApplication()
		.getNavigationHandler()
		.handleNavigation(FacesContext.getCurrentInstance(), null, to);
	}

	private Map<String, Object> getBeanAsMap(Object bean) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			Method[] methods = bean.getClass().getMethods();
			Object result = null;
			String nomeAtributo = null;
			for (Method m : methods) {
				if (m.getName().startsWith("get") && m.getParameterTypes().length == 0 ) {
					result = m.invoke(bean, new Object[]{});
					if (result != null && !result.toString().isEmpty()) {
						if (result instanceof String || result instanceof Date || result instanceof Number) {
							nomeAtributo = m.getName().substring(3, 4).toLowerCase() + m.getName().substring(4); 
							retorno.put(nomeAtributo, result);
						} else if (result instanceof EntidadeBasica) {
							Map<String, Object> mapa = getBeanAsMap(result);
							for (String s : mapa.keySet()){
								retorno.put(result.getClass().getSimpleName().toLowerCase() + "." + s, mapa.get(s));
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	private Map<String, String> getMapToGeneralFilter(String value) {
		Map<String, String> retorno = new HashMap<String, String>();
		try {
			Method[] methods = clazz.getMethods();
			for (Method m : methods) {
				if (m.getName().startsWith("get") && m.getParameterTypes().length == 0 ) {
					if (String.class.equals(m.getReturnType())) {
						retorno.put(m.getName().substring(3).toLowerCase(), value);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}


	private void showFacesMessage(FacesMessage.Severity severity, String message, String detail){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, message, detail));

	}

	/**
	 * @return the listaBeans
	 */
	public List<T> getListaBeans() {
		return listaBeans;
	}
	/**
	 * @return the beanSelecionado
	 */
	public T getBeanSelecionado() {
		return beanSelecionado;
	}
	/**
	 * @param listaBeans the listaBeans to set
	 */
	public void setListaBeans(List<T> listaBeans) {
		this.listaBeans = listaBeans;
	}
	/**
	 * @param beanSelecionado the beanSelecionado to set
	 */
	public void setBeanSelecionado(T beanSelecionado) {
		this.beanSelecionado = beanSelecionado;
	}

	/**
	 * @return the beanFiltro
	 */
	public T getBeanFiltro() {
		return beanFiltro;
	}

	/**
	 * @param beanFiltro the beanFiltro to set
	 */
	public void setBeanFiltro(T beanFiltro) {
		this.beanFiltro = beanFiltro;
	}

	/**
	 * @return the service
	 */
	public AbstractService<T> getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(AbstractService<T> service) {
		this.service = service;
	}

	/**
	 * @return the filterValue
	 */
	public String getFilterValue() {
		return filterValue;
	}

	/**
	 * @param filterValue the filterValue to set
	 */
	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}
}
