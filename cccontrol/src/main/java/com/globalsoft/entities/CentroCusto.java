package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "centro_custo")
public class CentroCusto extends BasicEntity {

	private static final long serialVersionUID = 3549618891169879753L;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "contrato")
	private String contrato;

	@Column(name = "gestor_contrato")
	private String gestorContrato;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getGestorContrato() {
		return gestorContrato;
	}

	public void setGestorContrato(String gestorContrato) {
		this.gestorContrato = gestorContrato;
	}

	public Boolean validate() throws Exception {
		return null;
	}

}
