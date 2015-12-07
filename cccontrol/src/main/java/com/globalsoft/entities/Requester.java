package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="requester")
public class Requester extends BasicEntity {

	
	private static final long serialVersionUID = 1809071967450079811L;

	@Column(name="Nome")
	private String nome;
	
	@Column(name="Cpf")
	private String cpf;
	
	@Column(name="Rg")
	private String rg;
	
	@Column(name="Matricula")
	private String matricula;
	
	@Column(name="Setor")
	private String setor;
	
	@Column(name="Funcao")
	private String funcao;
	
	@Column(name="Tel1")
	private String tel1;
	
	@Column(name="Tel2")
	private String tel2;
	
	@Column(name="ObsComments")
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
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getObsComments() {
		return obsComments;
	}

	public void setObsComments(String obsComments) {
		this.obsComments = obsComments;
	}

	public Boolean validate() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
