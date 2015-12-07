package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="supplier")
public class Supplier extends BasicEntity {

	private static final long serialVersionUID = 2448802904563157889L;

	@Column(name="Nome")
	private String nome;
	
	@Column(name="RazaoSocial")
	private String razaoSocial;
	
	@Column(name="Endereco")
	private String endereco;
	
	@Column(name="Numero")
	private String numero;
	
	@Column(name="Complemento")
	private String complemento;
	
	@Column(name="Bairro")
	private String bairro;
	
	@Column(name="Cidade")
	private String cidade;
	
	@Column(name="Uf")
	private String uf;
	
	@Column(name="Cep")
	private String cep;
	
	@Column(name="Doc1")
	private String doc1; // Cpf ou Cnpj
	
	@Column(name="Doc2")
	private String doc2; // Inscricao Estadual/RG
	
	@Column(name="Contato")
	private String contato;
	
	@Column(name="Tel1")
	private String tel1;
	
	@Column(name="Tel2")
	private String tel2;
	
	@Column(name="Tel3")
	private String tel3;
	
	@Column(name="Fax")
	private String fax;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Site")
	private String site;
	
	@Column(name="Banco")
	private String banco;
	
	@Column(name="AgencNumber")
	private String agenciaNumber;
	
	@Column(name="ContaNumber")
	private String contaNumber;
	
	@Column(name="ObsComments")
	private String obsComments;
	
	
	
	
	
	
	public String getNome() {
		return nome;
	}






	public void setNome(String nome) {
		this.nome = nome;
	}






	public String getRazaoSocial() {
		return razaoSocial;
	}






	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}






	public String getEndereco() {
		return endereco;
	}






	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}






	public String getNumero() {
		return numero;
	}






	public void setNumero(String numero) {
		this.numero = numero;
	}






	public String getComplemento() {
		return complemento;
	}






	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}






	public String getBairro() {
		return bairro;
	}






	public void setBairro(String bairro) {
		this.bairro = bairro;
	}






	public String getCidade() {
		return cidade;
	}






	public void setCidade(String cidade) {
		this.cidade = cidade;
	}






	public String getUf() {
		return uf;
	}






	public void setUf(String uf) {
		this.uf = uf;
	}






	public String getCep() {
		return cep;
	}






	public void setCep(String cep) {
		this.cep = cep;
	}






	public String getDoc1() {
		return doc1;
	}






	public void setDoc1(String doc1) {
		this.doc1 = doc1;
	}






	public String getDoc2() {
		return doc2;
	}






	public void setDoc2(String doc2) {
		this.doc2 = doc2;
	}






	public String getContato() {
		return contato;
	}






	public void setContato(String contato) {
		this.contato = contato;
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






	public String getTel3() {
		return tel3;
	}






	public void setTel3(String tel3) {
		this.tel3 = tel3;
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






	public String getSite() {
		return site;
	}






	public void setSite(String site) {
		this.site = site;
	}






	public String getBanco() {
		return banco;
	}






	public void setBanco(String banco) {
		this.banco = banco;
	}






	public String getAgenciaNumber() {
		return agenciaNumber;
	}






	public void setAgenciaNumber(String agenciaNumber) {
		this.agenciaNumber = agenciaNumber;
	}






	public String getContaNumber() {
		return contaNumber;
	}






	public void setContaNumber(String contaNumber) {
		this.contaNumber = contaNumber;
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
