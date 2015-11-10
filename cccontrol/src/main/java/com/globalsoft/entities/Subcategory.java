package com.globalsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue(value="subcategory")
public abstract class Subcategory implements com.globalsoft.entities.Entity, Serializable {

	private static final long serialVersionUID = 5402872208728797030L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name= "nome")
	private String nome;
	
	@Column(name = "category")
	private Category category;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
