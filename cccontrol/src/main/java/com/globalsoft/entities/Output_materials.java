package com.globalsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue(value="Output")
public abstract class Output_materials implements com.globalsoft.entities.Entity, Serializable {

	private static final long serialVersionUID = 2902806345887997198L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="name")
	private String nome;
	
	@Column(name="person")
	private Person usuario;

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

	public Person getUsuario() {
		return usuario;
	}

	public void setUsuario(Person usuario) {
		this.usuario = usuario;
	}
}
