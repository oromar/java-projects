package com.globalsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue(value="product")
public abstract class Product implements com.globalsoft.entities.Entity, Serializable {

	private static final long serialVersionUID = 870276501623387372L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="NotaFiscal")
	private String NotaFiscal;
	
	@Column(name="CentroDeCusto")
	private Long CentroDeCusto;
	
	
	
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


	public String getNotaFiscal() {
		return NotaFiscal;
	}


	public void setNotaFiscal(String notaFiscal) {
		NotaFiscal = notaFiscal;
	}


	public Long getCentroDeCusto() {
		return CentroDeCusto;
	}


	public void setCentroDeCusto(Long centroDeCusto) {
		CentroDeCusto = centroDeCusto;
	}
	
}
