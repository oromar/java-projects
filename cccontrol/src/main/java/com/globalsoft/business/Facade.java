package com.globalsoft.business;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import com.globalsoft.dao.CategoryDAO;
import com.globalsoft.dao.ClientDAO;
import com.globalsoft.dao.InputMaterialsDAO;
import com.globalsoft.dao.OutputMaterialsDAO;
import com.globalsoft.dao.ProductDAO;
import com.globalsoft.dao.RequesterDAO;
import com.globalsoft.dao.RoleDAO;
import com.globalsoft.dao.SubCategoryDAO;
import com.globalsoft.dao.SupplierDAO;
import com.globalsoft.dao.UserDAO;
import com.globalsoft.entities.Category;
import com.globalsoft.entities.Client;
import com.globalsoft.entities.InputMaterials;
import com.globalsoft.entities.OutputMaterials;
import com.globalsoft.entities.Product;
import com.globalsoft.entities.Requester;
import com.globalsoft.entities.Role;
import com.globalsoft.entities.SubCategory;
import com.globalsoft.entities.Supplier;
import com.globalsoft.entities.User;

public class Facade {

	private static Facade instance;
	private UserBO userBO;
	private ClientBO clientBO;
	private ProductBO productBO;
	private RoleBO roleBO;
	private SupplierBO supplierBO;
	private RequesterBO requesterBO;
	private InputMaterialsBO inputBO;
	private OutputMaterialsBO outputBO;
	private CategoryBO categoryBO;
	private SubCategoryBO subCategoryBO;

	private Facade() {
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
		roleBO = new RoleBO(new RoleDAO());
		supplierBO = new SupplierBO(new SupplierDAO());
		requesterBO = new RequesterBO(new RequesterDAO());
		inputBO = new InputMaterialsBO(new InputMaterialsDAO());
		inputBO = new InputMaterialsBO(new InputMaterialsDAO());
		outputBO = new OutputMaterialsBO(new OutputMaterialsDAO());
		categoryBO = new CategoryBO(new CategoryBO(new CategoryDAO()));
		subCategoryBO = new SubCategoryBO(new SubCategoryDAO());
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

	public Client findClientUniqueByHQL(String hql,
			Map<String, Object> parameters) {
		return clientBO.findUniqueByHQL(hql, parameters);
	}

	public Collection<Client> findClientCollectionByHQL(String hql,
			Map<String, Object> parameters) {
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

	public Product findProductUniqueByHQL(String hql,
			Map<String, Object> parameters) {
		return productBO.findUniqueByHQL(hql, parameters);
	}

	public Collection<Product> findProductCollectionByHQL(String hql,
			Map<String, Object> parameters) {
		return productBO.findCollectionByHQL(hql, parameters);
	}

	public void create(Role entity) throws Exception {
		roleBO.create(entity);
	}

	public void update(Role entity) throws Exception {
		roleBO.update(entity);
	}

	public void removeRole(Serializable key) throws Exception {
		roleBO.remove(key);
	}

	public Role findRole(Serializable key) throws Exception {
		return roleBO.find(key);
	}

	public Role[] findAllRoles() throws Exception {
		return roleBO.findAll();
	}

	public Collection<Role> filter(Role entity) {
		return roleBO.filter(entity);
	}

	public Collection<Role> findRoleCollectionByHQL(String hql,
			Map<String, Object> parameters) {
		return roleBO.findCollectionByHQL(hql, parameters);
	}

	public Role findRoleUniqueByHQL(String hql, Map<String, Object> parameters) {
		return roleBO.findUniqueByHQL(hql, parameters);
	}

	public void create(Supplier entity) throws Exception {
		supplierBO.create(entity);
	}

	public void update(Supplier entity) throws Exception {
		supplierBO.update(entity);
	}

	public void removeSupplier(Serializable key) throws Exception {
		supplierBO.remove(key);
	}

	public Supplier findSupplier(Serializable key) throws Exception {
		return supplierBO.find(key);
	}

	public Supplier[] findAllSuppliers() throws Exception {
		return supplierBO.findAll();
	}

	public Collection<Supplier> filter(Supplier entity) {
		return supplierBO.filter(entity);
	}

	public Collection<Supplier> findSupplierCollectionByHQL(String hql,
			Map<String, Object> parameters) {
		return supplierBO.findCollectionByHQL(hql, parameters);
	}

	public Supplier findSupplierUniqueByHQL(String hql,
			Map<String, Object> parameters) {
		return supplierBO.findUniqueByHQL(hql, parameters);
	}

	public void create(Requester entity) throws Exception {
		requesterBO.create(entity);
	}

	public void update(Requester entity) throws Exception {
		requesterBO.update(entity);
	}

	public void removeRequester(Serializable key) throws Exception {
		requesterBO.remove(key);
	}

	public Requester findRequester(Serializable key) throws Exception {
		return requesterBO.find(key);
	}

	public Requester[] findAllRequesters() throws Exception {
		return requesterBO.findAll();
	}

	public Collection<Requester> filter(Requester entity) {
		return requesterBO.filter(entity);
	}

	public Collection<Requester> findRequesterCollectionByHQL(String hql,
			Map<String, Object> parameters) {
		return requesterBO.findCollectionByHQL(hql, parameters);
	}

	public Requester findRequesterUniqueByHQL(String hql,
			Map<String, Object> parameters) {
		return requesterBO.findUniqueByHQL(hql, parameters);
	}

	public void create(InputMaterials entity) throws Exception {
		inputBO.create(entity);
	}

	public void update(InputMaterials entity) throws Exception {
		inputBO.update(entity);
	}

	public void removeInputMaterials(Serializable key) throws Exception {
		inputBO.remove(key);
	}

	public InputMaterials findInputMaterials(Serializable key) throws Exception {
		return inputBO.find(key);
	}

	public InputMaterials[] findAllInputMaterials() throws Exception {
		return inputBO.findAll();
	}

	public Collection<InputMaterials> filter(InputMaterials entity) {
		return inputBO.filter(entity);
	}

	public Collection<InputMaterials> findInputMaterialsCollectionByHQL(
			String hql, Map<String, Object> parameters) {
		return inputBO.findCollectionByHQL(hql, parameters);
	}

	public InputMaterials findInputMaterialsUniqueByHQL(String hql,
			Map<String, Object> parameters) {
		return inputBO.findUniqueByHQL(hql, parameters);
	}

	public void create(OutputMaterials entity) throws Exception {
		outputBO.create(entity);
	}

	public void update(OutputMaterials entity) throws Exception {
		outputBO.update(entity);
	}

	public void removeOutputMaterials(Serializable key) throws Exception {
		outputBO.remove(key);
	}

	public OutputMaterials findOutputMaterials(Serializable key)
			throws Exception {
		return outputBO.find(key);
	}

	public OutputMaterials[] findAllOutputMaterials() throws Exception {
		return outputBO.findAll();
	}

	public Collection<OutputMaterials> filter(OutputMaterials entity) {
		return outputBO.filter(entity);
	}

	public Collection<OutputMaterials> findOutputMaterialsCollectionByHQL(
			String hql, Map<String, Object> parameters) {
		return outputBO.findCollectionByHQL(hql, parameters);
	}

	public OutputMaterials findOutputMaterialsUniqueByHQL(String hql,
			Map<String, Object> parameters) {
		return outputBO.findUniqueByHQL(hql, parameters);
	}

	public void create(Category entity) throws Exception {
		categoryBO.create(entity);
	}

	public void update(Category entity) throws Exception {
		categoryBO.update(entity);
	}

	public void removeCategory(Serializable key) throws Exception {
		categoryBO.remove(key);
	}

	public Category findCategory(Serializable key) throws Exception {
		return categoryBO.find(key);
	}

	public Category[] findAllCategory() throws Exception {
		return categoryBO.findAll();
	}

	public Collection<Category> filter(Category entity) {
		return categoryBO.filter(entity);
	}

	public Collection<Category> findCategoryCollectionByHQL(String hql,
			Map<String, Object> parameters) {
		return categoryBO.findCollectionByHQL(hql, parameters);
	}

	public Category findCategoryUniqueByHQL(String hql,
			Map<String, Object> parameters) {
		return categoryBO.findUniqueByHQL(hql, parameters);
	}

	public void create(SubCategory entity) throws Exception {
		subCategoryBO.create(entity);
	}

	public void update(SubCategory entity) throws Exception {
		subCategoryBO.update(entity);
	}

	public void removeSubCategory(Serializable key) throws Exception {
		subCategoryBO.remove(key);
	}

	public SubCategory findSubCategory(Serializable key) throws Exception {
		return subCategoryBO.find(key);
	}

	public SubCategory[] findAllSubCategory() throws Exception {
		return subCategoryBO.findAll();
	}

	public Collection<SubCategory> filter(SubCategory entity) {
		return subCategoryBO.filter(entity);
	}

	public Collection<SubCategory> findSubCategoryCollectionByHQL(String hql,
			Map<String, Object> parameters) {
		return subCategoryBO.findCollectionByHQL(hql, parameters);
	}

	public SubCategory findSubCategoryUniqueByHQL(String hql,
			Map<String, Object> parameters) {
		return subCategoryBO.findUniqueByHQL(hql, parameters);
	}

}
