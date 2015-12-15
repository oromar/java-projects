package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sub_category")
public class Subcategory extends BasicEntity {

	private static final long serialVersionUID = 5402872208728797030L;

	@Column(name = "nome", unique = true)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean validate() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
