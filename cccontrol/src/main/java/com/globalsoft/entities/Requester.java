package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column(name="CentroCusto")
	private String centroCusto;
	
	@Column(name="Funcao")
	private String funcao;

	@Column(name = "Tel1")
	private String telefone1;

	@Column(name = "Tel2")
	private String telefone2;

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
	
	public String getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(String centroCusto) {
		this.centroCusto = centroCusto;
	}


	public Boolean validate() throws Exception {
		
		if (nome == null || nome.isEmpty()){ 
			throw new Exception(Messages.INVALID_NAME);
		}
		if (cpf == null || cpf.isEmpty() || cpf.length() != 11 || !cpf.matches(Constants.ONLY_NUMBERS_REGEX)){ 
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (rg == null || rg.isEmpty()||!rg.matches(Constants.ONLY_NUMBERS_REGEX)){
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (matricula==null||matricula.isEmpty()||!matricula.matches(Constants.ONLY_NUMBERS_REGEX)){
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (centroCusto==null || centroCusto.isEmpty() || !centroCusto.matches(Constants.ONLY_NUMBERS_REGEX)){
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (setor==null|| setor.isEmpty()){
			throw new Exception(Messages.INVALID_FIELD);
		}
		if(funcao==null|| funcao.isEmpty()){
			throw new Exception(Messages.INVALID_FIELD);
		}
		if(telefone1==null || telefone1.isEmpty()|| !telefone1.matches(Constants.ONLY_NUMBERS_REGEX)){
			throw new Exception(Messages.INVALID_FIELD);
		}
		
		return Boolean.TRUE;
	}

}
