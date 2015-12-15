package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "input_materials")
public class InputMaterials extends BasicEntity {

	private static final long serialVersionUID = -6338033207049989141L;

	@Column(name = "name")
	private String nome;

	@Column(name = "person")
	private Person usuario;

	@Column(name = "UnidadeMed")
	private String undMedida;

	@Column(name = "NotaFiscal")
	private String notaFiscal; // falta o centro de custo

	@Column(name = "Contrato")
	private String contrato;

	@Column(name = "QtdAtual")
	private String qtdAtual;

	@Column(name = "Qtd")
	private String qtd;

	@Column(name = "Ipi")
	private String ipi;

	@Column(name = "ValorUnit")
	private String valorUnit;

	@Column(name = "ValorTotal")
	private String valorTotal;

	@Column(name = "Fornecedor")
	private String fornecedor;

	@Column(name = "Contato")
	private String contato;

	@Column(name = "Tel")
	private String tel;

	@Column(name = "Fax")
	private String fax;

	@Column(name = "Email")
	private String email;

	@Column(name = "ObsComments")
	private String obsComments;

	public String getUndMedida() {
		return undMedida;
	}

	public void setUndMedida(String undMedida) {
		this.undMedida = undMedida;
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

	public String getQtdAtual() {
		return qtdAtual;
	}

	public void setQtdAtual(String qtdAtual) {
		this.qtdAtual = qtdAtual;
	}

	public String getQtd() {
		return qtd;
	}

	public void setQtd(String qtd) {
		this.qtd = qtd;
	}

	public String getIpi() {
		return ipi;
	}

	public void setIpi(String ipi) {
		this.ipi = ipi;
	}

	public String getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(String valorUnit) {
		this.valorUnit = valorUnit;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Boolean validate() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
