package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Table;

import com.globalsoft.util.Constants;
import com.globalsoft.util.Messages;

@javax.persistence.Entity
@Table(name = "supplier")
public class Supplier extends BasicEntity {

	private static final long serialVersionUID = 2448802904563157889L;

	@Column(name = "Nome")
	private String nome;

	@Column(name = "RazaoSocial")
	private String razaoSocial;

	@Column(name = "Endereco")
	private String endereco;

	@Column(name = "Numero")
	private String numero;

	@Column(name = "Complemento")
	private String complemento;

	@Column(name = "Bairro")
	private String bairro;

	@Column(name = "Cidade")
	private String cidade;

	@Column(name = "Uf")
	private String estado;

	@Column(name = "Cep")
	private String cep;

	@Column(name = "Doc1")
	private String documento1; // Cpf ou Cnpj

	@Column(name = "Doc2")
	private String documento2; // Inscricao Estadual/RG

	@Column(name = "Contato")
	private String contato;

	@Column(name = "Tel1")
	private String telefone1;

	@Column(name = "Tel2")
	private String telefone2;

	@Column(name = "Tel3")
	private String telefone3;

	@Column(name = "Fax")
	private String fax;

	@Column(name = "Email")
	private String email;

	@Column(name = "Site")
	private String site;

	@Column(name = "Banco")
	private String banco;

	@Column(name = "AgencNumber")
	private String agencia;

	@Column(name = "ContaNumber")
	private String conta;

	@Column(name = "ObsComments")
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
		return estado;
	}

	public void setUf(String uf) {
		this.estado = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDoc1() {
		return documento1;
	}

	public void setDoc1(String doc1) {
		this.documento1 = doc1;
	}

	public String getDoc2() {
		return documento2;
	}

	public void setDoc2(String doc2) {
		this.documento2 = doc2;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
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

	public String getTel3() {
		return telefone3;
	}

	public void setTel3(String tel3) {
		this.telefone3 = tel3;
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
		return agencia;
	}

	public void setAgenciaNumber(String agenciaNumber) {
		this.agencia = agenciaNumber;
	}

	public String getContaNumber() {
		return conta;
	}

	public void setContaNumber(String contaNumber) {
		this.conta = contaNumber;
	}

	public String getObsComments() {
		return obsComments;
	}

	public void setObsComments(String obsComments) {
		this.obsComments = obsComments;
	}

	public Boolean validate() throws Exception {
		
		if (razaoSocial == null || razaoSocial.isEmpty()){ 
			throw new Exception(Messages.INVALID_FIELD + "Razão Social");
		}
		if (nome == null || nome.isEmpty()){ 
			throw new Exception(Messages.INVALID_NAME);
		}
		if (endereco == null || endereco.isEmpty()){ 
			throw new Exception(Messages.INVALID_FIELD + "Endereço");
		}
		if (numero == null || numero.isEmpty() || !numero.matches(Constants.ONLY_NUMBERS_REGEX)){ 
			throw new Exception(Messages.INVALID_FIELD + "Número");
		}
		if (bairro == null || bairro.isEmpty()){ 
			throw new Exception(Messages.INVALID_FIELD + "Bairro");
		}
		if (cidade == null || cidade.isEmpty()){ 
			throw new Exception(Messages.INVALID_FIELD + "Cidade");
		}
		if (estado == null || estado.isEmpty()){ 
			throw new Exception(Messages.INVALID_FIELD + "UF");
		}
		if (cep == null || cep.isEmpty() || cep.length() != 8 || !cep.matches(Constants.ONLY_NUMBERS_REGEX)){ 
			throw new Exception(Messages.INVALID_CEP);
		}
		/*if (nome == null || nome.isEmpty()){ 
			throw new Exception(Messages.INVALID_NAME);
		}*/
		if (documento1 == null || documento1.isEmpty()||!documento1.matches(Constants.ONLY_NUMBERS_REGEX)){
			throw new Exception(Messages.INVALID_FIELD + "CNPJ/CPF");
		}
		if (documento2==null||documento2.isEmpty()||!documento2.matches(Constants.ONLY_NUMBERS_REGEX)){
			throw new Exception(Messages.INVALID_FIELD + "Inscrição Estadual/RG");
		}
		if (banco==null || banco.isEmpty()){
			throw new Exception(Messages.INVALID_FIELD + "Banco");
		}
		if (conta==null|| conta.isEmpty() || !conta.matches(Constants.ONLY_NUMBERS_REGEX)){
			throw new Exception(Messages.INVALID_FIELD + "Conta");
		}
		if (agencia==null|| agencia.isEmpty()){
			throw new Exception(Messages.INVALID_FIELD + "Agência");
		}
		if(telefone1==null || telefone1.isEmpty()|| !telefone1.matches(Constants.ONLY_NUMBERS_REGEX)){
			throw new Exception(Messages.INVALID_FIELD + "Telefone");
		}
		if(fax==null || fax.isEmpty()|| !fax.matches(Constants.ONLY_NUMBERS_REGEX)){
			throw new Exception(Messages.INVALID_FIELD + "Fax");
		}
		if(email==null || email.isEmpty()){
			throw new Exception(Messages.INVALID_FIELD + "Email");
		}
		if(contato==null || contato.isEmpty()){
			throw new Exception(Messages.INVALID_FIELD + "Contato");
		}
		
		return Boolean.TRUE;
	}

}
