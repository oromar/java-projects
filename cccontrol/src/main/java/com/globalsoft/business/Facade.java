package com.globalsoft.business;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import com.globalsoft.dao.ClientDAO;
import com.globalsoft.dao.ProductDAO;
import com.globalsoft.dao.UserDAO;
import com.globalsoft.entities.Client;
import com.globalsoft.entities.Product;
import com.globalsoft.entities.User;

public class Facade {
	
	private static Facade instance;
	private UserBO userBO; 
	private ClientBO clientBO; 
	private ProductBO productBO;
	
	private Facade(){
		init();
	}

	public static Facade getInstance() {
		if (instance == null) {
			instance = new Facade();			
		}
		return instance;
	}
	
	private void init() {
		userBO = new UserBO(new UserDAO());
		clientBO = new ClientBO(new ClientDAO());
		productBO = new ProductBO(new ProductDAO());
	}

	public boolean exists(Serializable key) throws Exception {
		return userBO.exists(key);
	}

	public void create(User entity) throws Exception {
		userBO.create(entity);
	}

	public void update(User entity) throws Exception {
		userBO.update(entity);
	}

	public void removeUser(Serializable key) throws Exception {
		userBO.remove(key);
	}

	public User findUser(Serializable key) throws Exception {
		return userBO.find(key);
	}

	public User[] findAllUsers() throws Exception {
		return userBO.findAll();
	}

	public Collection<User> filter(User entity) {
		return userBO.filter(entity);
	}

	public Collection<User> findUserCollectionByHQL(String hql,
			Map<String, Object> parameters) {
		return userBO.findCollectionByHQL(hql, parameters);
	}

	public User findUserUniqueByHQL(String hql, Map<String, Object> parameters) {
		return userBO.findUniqueByHQL(hql, parameters);
	}

	public void create(Client entity) throws Exception {
		clientBO.create(entity);
	}

	public void update(Client entity) throws Exception {
		clientBO.update(entity);
	}

	public Client findClient(Serializable key) throws Exception {
		return clientBO.find(key);
	}
	
	public void removeClient(Serializable key) throws Exception {
		clientBO.remove(key);
	}

	public Client[] findAllClients() throws Exception {
		return clientBO.findAll();
	}

	public Collection<Client> filter(Client entity) {
		return clientBO.filter(entity);
	}

	public Client findClientUniqueByHQL(String hql, Map<String, Object> parameters) {
		return clientBO.findUniqueByHQL(hql, parameters);
	}
	
	public Collection<Client> findClientCollectionByHQL(String hql, Map<String, Object> parameters) {
		return clientBO.findCollectionByHQL(hql, parameters);
	}

	public void create(Product entity) throws Exception {
		productBO.create(entity);
	}
	
	public void update(Product entity) throws Exception {
		productBO.update(entity);
	}

	public void removeProduct(Serializable key) throws Exception {
		productBO.remove(key);
	}
	
	public Product findProduct(Serializable key) throws Exception {
		return productBO.find(key);
	}

	public Product[] findAllProducts() throws Exception {
		return productBO.findAll();
	}

	public Collection<Product> filter(Product entity) {
		return productBO.filter(entity);
	}

	public Product findProductUniqueByHQL(String hql, Map<String, Object> parameters) {
		return productBO.findUniqueByHQL(hql, parameters);
	}
	
	public Collection<Product> findProductCollectionByHQL(String hql, Map<String, Object> parameters) {
		return productBO.findCollectionByHQL(hql, parameters);
	}
}
