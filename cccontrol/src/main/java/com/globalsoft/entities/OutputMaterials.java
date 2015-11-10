package com.globalsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="output_materials")
public class OutputMaterials extends BasicEntity {

	private static final long serialVersionUID = 2902806345887997198L;
	
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
