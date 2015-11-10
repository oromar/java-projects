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
	
	@Column(name = "nome")
	private String nome;
	
	@OneToMany()
	private List<Subcategory> subcategories;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Subcategory> getSubcategory() {
		return subcategories;
	}
	public void setSubcategory(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}
	public Boolean validate() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}		
}
