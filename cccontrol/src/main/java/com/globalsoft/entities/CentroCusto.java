package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="centro_custo")
public class CentroCusto extends BasicEntity {

	private static final long serialVersionUID = 3549618891169879753L;

	@Column(name="CentroCusto")
	private String centroCustoNumber;
	
	public String getCentroCustoNumber() {
		return centroCustoNumber;
	}

	public void setCentroCustoNumber(String centroCustoNumber) {
		this.centroCustoNumber = centroCustoNumber;
	}

	public Boolean validate() throws Exception {
		return null;
	}
	
	
}
