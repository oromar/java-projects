package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product extends BasicEntity {

	private static final long serialVersionUID = 870276501623387372L;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="NotaFiscal")
	private String notaFiscal;
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNotaFiscal() {
		return notaFiscal;
	}


	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	

	public Boolean validate() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
