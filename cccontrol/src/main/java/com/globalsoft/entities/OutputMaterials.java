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

	@Column(name = "name") //Descricao do produto
	private String nome;

	@OneToOne
	@JoinColumn(name = "person")
	private Person usuario;

	@Column(name = "ObsComments")
	private String obsComments;

	@Column(name = "unidade_medida")
	private String unidade;

	@Column(name = "QtdAtual")
	private String qtdAtual;

	@Column(name = "QTD")
	private String qtd;

	@Column(name = "Departamento")
	private String departamento;

	@Column(name = "Contrato")
	private String contrato;

	@Column(name = "Requisitante")
	private String requisitanteName;

	@Column(name = "Cpf")
	private String cpf;

	@Column(name = "Rg")
	private String rg;

	@Column(name = "Matricula")
	private String matricula;

	@Column(name = "Autorizacao")
	private String autorizacao;

	@Column(name = "Email")
	private String email;

	@Column(name = "Tel")
	private String tel1;

	public String getObsComments() {
		return obsComments;
	}

	public void setObsComments(String obsComments) {
		this.obsComments = obsComments;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
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

	public String getRequisitanteName() {
		return requisitanteName;
	}

	public void setRequisitanteName(String requisitanteName) {
		this.requisitanteName = requisitanteName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
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
		
		if (requisitanteName == null || requisitanteName.isEmpty()){ 
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (nome == null || nome.isEmpty()){ // descricao produto
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (qtd == null || qtd.isEmpty() || !qtd.matches(Constants.ONLY_NUMBERS_REGEX)){ 
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (departamento == null || departamento.isEmpty()){ 
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (contrato == null || contrato.isEmpty()){ 
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (autorizacao == null || autorizacao.isEmpty()){ 
			throw new Exception(Messages.INVALID_FIELD);
		}
		return Boolean.TRUE;
	}
}
