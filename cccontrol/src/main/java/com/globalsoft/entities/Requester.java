package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.globalsoft.util.Constants;
import com.globalsoft.util.Messages;

@Entity
@Table(name = "requester")
public class Requester extends BasicEntity {

	private static final long serialVersionUID = 1809071967450079811L;

	@Column(name = "Nome")
	private String nome;

	@Column(name = "Cpf")
	private String cpf;

	@Column(name = "Rg")
	private String rg;

	@Column(name = "Matricula")
	private String matricula;

	@Column(name = "Setor")
	private String setor;

	@OneToOne
	@JoinColumn(name = "centro_custo")
	private CentroCusto centrocusto;

	@Column(name = "Funcao")
	private String funcao;

	@Column(name = "Tel1")
	private String telefone1;

	@Column(name = "Tel2")
	private String telefone2;

	@Column(name = "email")
	private String email;

	@Column(name = "ObsComments")
	private String obsComments;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getTel1() {
		return telefone1;
	}

	public void setTel1(String tel1) {
		this.telefone1 = tel1;
	}

	public String getTel2() {
		return telefone2;
	}

	public void setTel2(String tel2) {
		this.telefone2 = tel2;
	}

	public String getObsComments() {
		return obsComments;
	}

	public void setObsComments(String obsComments) {
		this.obsComments = obsComments;
	}

	public CentroCusto getCentrocusto() {
		return centrocusto;
	}

	public void setCentrocusto(CentroCusto centrocusto) {
		this.centrocusto = centrocusto;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean validate() throws Exception {

		if (nome == null || nome.isEmpty()) {
			throw new Exception(Messages.INVALID_NAME);
		}
		if (cpf == null || cpf.isEmpty() || cpf.length() != 11
				|| !cpf.matches(Constants.ONLY_NUMBERS_REGEX)) {
			throw new Exception(Messages.INVALID_CPF);
		}
		if (rg == null || rg.isEmpty()
				|| !rg.matches(Constants.ONLY_NUMBERS_REGEX)) {
			throw new Exception(Messages.INVALID_FIELD + "RG");
		}
		if (matricula == null || matricula.isEmpty()
				|| !matricula.matches(Constants.ONLY_NUMBERS_REGEX)) {
			throw new Exception(Messages.INVALID_FIELD + "Matrícula");
		}
		if (centrocusto == null) {
			throw new Exception(Messages.INVALID_CENTERCOST);
		}else{
			centrocusto.validate();
		}
		if (setor == null || setor.isEmpty()) {
			throw new Exception(Messages.INVALID_FIELD + "Setor");
		}
		if (funcao == null || funcao.isEmpty()) {
			throw new Exception(Messages.INVALID_FIELD + "Função");
		}
		if (telefone1 == null || telefone1.isEmpty()
				|| !telefone1.matches(Constants.ONLY_NUMBERS_REGEX)) {
			throw new Exception(Messages.INVALID_FIELD + "Telefone");
		}

		return Boolean.TRUE;
	}

}
