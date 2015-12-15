package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="centro_custo")
public class CentroCusto extends BasicEntity {

	private static final long serialVersionUID = 3549618891169879753L;

	@Column(name="nome")
	private String nome;
	
	public String getCentroCustoNumber() {
		return nome;
	}

	public void setCentroCustoNumber(String nome) {
		this.nome = nome;
	}

	public Boolean validate() throws Exception {
		return null;
	}
	
	
}
