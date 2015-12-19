package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.globalsoft.util.Constants;
import com.globalsoft.util.Messages;

@Entity
@Table(name = "output_materials")
public class OutputMaterials extends BasicEntity {

	private static final long serialVersionUID = 2902806345887997198L;

	@Column(name = "ObsComments")
	private String obsComments;

	@Column(name = "QTD")
	private String quantidade;

	@Column(name = "Departamento")
	private String departamento;

	@Column(name = "Contrato")
	private String contrato;

	@Column(name = "Autorizacao")
	private String autorizacao;

	@Column(name = "Tel")
	private String telefone;

	@OneToOne
	@JoinColumn(name = "requester")
	private Requester requester;

	@OneToOne
	@JoinColumn(name = "product")
	private Product product;

	public String getObsComments() {
		return obsComments;
	}

	public void setObsComments(String obsComments) {
		this.obsComments = obsComments;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Requester getRequester() {
		return requester;
	}

	public void setRequester(Requester requester) {
		this.requester = requester;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Boolean validate() throws Exception {

		if (requester == null) {
			throw new Exception(Messages.INVALID_FIELD);
		} else {
			requester.validate();
		}
		if (quantidade == null || quantidade.isEmpty()
				|| !quantidade.matches(Constants.ONLY_NUMBERS_REGEX)) {
			throw new Exception(Messages.INVALID_FIELD + "Campo Quantidade");
		}
		if (departamento == null || departamento.isEmpty()) {
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (contrato == null || contrato.isEmpty()) {
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (autorizacao == null || autorizacao.isEmpty()) {
			throw new Exception(Messages.INVALID_FIELD);
		}
		return Boolean.TRUE;
	}
}
