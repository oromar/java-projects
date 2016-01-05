package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sub_category")
public class SubCategory extends BasicEntity {

	private static final long serialVersionUID = 5402872208728797030L;

	@Column(name = "nome", unique = true)
	private String nome;
	@ManyToOne
	private Category categoria;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Category getCategoria() {
		return categoria;
	}

	public void setCategoria(Category categoria) {
		this.categoria = categoria;
	}

	public Boolean validate() throws Exception {
		return null;
	}
}
