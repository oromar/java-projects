package com.globalsoft.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category extends BasicEntity {

	private static final long serialVersionUID = 167222140605537025L;
	
	@Column(name = "nome", unique = true)
	private String nome;
	
	@OneToMany
	private List<SubCategory> subcategories;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<SubCategory> getSubcategory() {
		return subcategories;
	}
	public void setSubcategory(List<SubCategory> subcategories) {
		this.subcategories = subcategories;
	}
	public Boolean validate() throws Exception {
		if (nome == null) {
			throw new Exception("Nome não informado!");
		}		
		return Boolean.TRUE;
	}		
	
	@Override
	public String toString() {
		return nome;
	}
}
