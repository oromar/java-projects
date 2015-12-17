package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.globalsoft.util.Constants;
import com.globalsoft.util.Messages;

@Entity
@Table(name = "input_materials")
public class InputMaterials extends BasicEntity {

	private static final long serialVersionUID = -6338033207049989141L;

	@OneToOne
	@JoinColumn(name = "produto")
	private Product produto;

	@OneToOne
	@JoinColumn(name = "user_requester")
	private User usuario;

	@Column(name = "UnidadeMed")
	private String unidadeMedidaProduto;

	@Column(name = "NotaFiscal")
	private String notaFiscal; // falta o centro de custo

	@Column(name = "Contrato")
	private String contrato;

	@Column(name = "QtdAtual")
	private String quantidadeAtual;

	@Column(name = "Qtd")
	private String quantidade;

	@Column(name = "Ipi")
	private String ipi;

	@Column(name = "ValorUnit")
	private String valorUnitario;

	@Column(name = "ValorTotal")
	private String valorTotal;

	@OneToOne
	@JoinColumn(name = "fornecedor")
	private Supplier fornecedor;

	@Column(name = "Contato")
	private String contatoFornecedor;

	@Column(name = "Tel")
	private String telefoneFornecedor;

	@Column(name = "Fax")
	private String faxFornecedor;

	@Column(name = "Email")
	private String emailContatoFornecedor;

	@Column(name = "ObsComments")
	private String obsComments;

	public Product getProduto() {
		return produto;
	}

	public void setProduto(Product produto) {
		this.produto = produto;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public String getUnidadeMedidaProduto() {
		return unidadeMedidaProduto;
	}

	public void setUnidadeMedidaProduto(String unidadeMedidaProduto) {
		this.unidadeMedidaProduto = unidadeMedidaProduto;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getQuantidadeAtual() {
		return quantidadeAtual;
	}

	public void setQuantidadeAtual(String quantidadeAtual) {
		this.quantidadeAtual = quantidadeAtual;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getIpi() {
		return ipi;
	}

	public void setIpi(String ipi) {
		this.ipi = ipi;
	}

	public String getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Supplier getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Supplier fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getContatoFornecedor() {
		return contatoFornecedor;
	}

	public void setContatoFornecedor(String contatoFornecedor) {
		this.contatoFornecedor = contatoFornecedor;
	}

	public String getTelefoneFornecedor() {
		return telefoneFornecedor;
	}

	public void setTelefoneFornecedor(String telefoneFornecedor) {
		this.telefoneFornecedor = telefoneFornecedor;
	}

	public String getFaxFornecedor() {
		return faxFornecedor;
	}

	public void setFaxFornecedor(String faxFornecedor) {
		this.faxFornecedor = faxFornecedor;
	}

	public String getEmailContatoFornecedor() {
		return emailContatoFornecedor;
	}

	public void setEmailContatoFornecedor(String emailContatoFornecedor) {
		this.emailContatoFornecedor = emailContatoFornecedor;
	}

	public String getObsComments() {
		return obsComments;
	}

	public void setObsComments(String obsComments) {
		this.obsComments = obsComments;
	}

	public Boolean validate() throws Exception {
		if (fornecedor == null) {
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (notaFiscal == null || notaFiscal.isEmpty()
				|| !notaFiscal.matches(Constants.ONLY_NUMBERS_REGEX)) {
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (contrato == null || contrato.isEmpty()) {
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (quantidade == null || quantidade.isEmpty()) {
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (ipi == null || ipi.isEmpty()) {
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (valorUnitario == null || valorUnitario.isEmpty()
				|| !valorUnitario.matches(Constants.ONLY_NUMBERS_REGEX)) {
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (valorTotal == null || valorTotal.isEmpty()
				|| !valorTotal.matches(Constants.ONLY_NUMBERS_REGEX)) {
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (contatoFornecedor == null || contatoFornecedor.isEmpty()) {
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (emailContatoFornecedor == null || emailContatoFornecedor.isEmpty()) {
			throw new Exception(Messages.INVALID_FIELD);
		}
		return Boolean.TRUE;
	}
}
