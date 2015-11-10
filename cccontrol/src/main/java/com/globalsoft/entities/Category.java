package com.globalsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue(value="category")
public abstract class Category  implements  com.globalsoft.entities.Entity, Serializable {

	private static final long serialVersionUID = 167222140605537025L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
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
}
