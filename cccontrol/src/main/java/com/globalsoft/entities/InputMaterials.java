package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="input_materials")
public class InputMaterials extends BasicEntity  {

	private static final long serialVersionUID = -6338033207049989141L;
	
	@Column(name="name")
	private String nome;
	
	@Column(name="person")
	private Person usuario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Person getUsuario() {
		return usuario;
	}

	public void setUsuario(Person usuario) {
		this.usuario = usuario;
	}

	public Boolean validate() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
