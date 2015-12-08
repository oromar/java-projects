package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BuyOrder")
public class OrderBuy extends BasicEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8492843224827165182L;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="Cnpj")
	private String cnpj;
	
	@Column(name="IE")
	private String ie;
	
	@Column(name="Endereco")
	private String endereco;
	
	@Column(name="Numero")
	private String numero;
	
	@Column(name="Bairro")
	private String bairro;
	
	@Column(name="Cidade")
	private String cidade;
	
	@Column(name="Telefone")
	private String tel;
	
	@Column(name="Fax")
	private String fax;
	
	@Column(name="Site")
	private String site;
	
	@Column(name="LocalEntrega")
	private String localEntrega;
	
	@Column(name="Nome_Soicitante")
	private String nomeSoli;
	
	@Column(name="Cpf_Solicitante")
	private String cpfSoli;
	
	@Column(name="nome")
	private String rgSoli;
	
	@Column(name="Matricula_Solicitante")
	private String matriSoli;
	
	@Column(name="CentroCusto_Solicitante")
	private String centroCustoSoli;
	
	@Column(name="Contrato_Solicitante")
	private String contratoSoli;
	
	@Column(name="Cod_Fornecedor")
	private String codForn;
	
	@Column(name="Nome_Fornecedor")
	private String nomeForn;
	
	@Column(name="Contato_Fornecedor")
	private String contatoForn;
	
	@Column(name="Telefone_Fornecedor")
	private String telForn;
	
	@Column(name="Fax_Fornecedor")
	private String faxForn;
	
	@Column(name="Email_Fornecedor")
	private String emailForn;
	
	@Column(name="Comments")
	private String comments;
	
	@Column(name="Cod_Product")
	private String codProd;
	
	@Column(name="Nome_Product")
	private String nomeProd;
	
	@Column(name="UnidMed_Product")
	private String unidMedProd;
	
	@Column(name="CentroCusto_Product")
	private String centroCustoProd;
	
	@Column(name="QtdAtual_Product")
	private String qtdAtProd;
	
	@Column(name="Qtd_Product")
	private String qtdProd;
	
	@Column(name="Ipi_Product")
	private String ipiProd;
	
	@Column(name="ValorUnit_Product")
	private String valorUnitProd;
	
	@Column(name="ValorTotal_Product")
	private String valorTotProd;
	
	@Column(name="SubTotal")
	private String subTotal;
	
	@Column(name="Desconto")
	private String desconto;
	
	@Column(name="Iss")
	private String iss;
	
	@Column(name="Frete")
	private String frete;
	
	@Column(name="Frete_1")
	private String frete1;
	
	@Column(name="Total_Geral")
	private String totalGeral;
	
	@Column(name="Prazo_Entrega")
	private String prazoEntrega;
	
	@Column(name="Cond_Pagamento")
	private String condPag;
	
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
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

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getLocalEntrega() {
		return localEntrega;
	}

	public void setLocalEntrega(String localEntrega) {
		this.localEntrega = localEntrega;
	}

	public String getNomeSoli() {
		return nomeSoli;
	}

	public void setNomeSoli(String nomeSoli) {
		this.nomeSoli = nomeSoli;
	}

	public String getCpfSoli() {
		return cpfSoli;
	}

	public void setCpfSoli(String cpfSoli) {
		this.cpfSoli = cpfSoli;
	}

	public String getRgSoli() {
		return rgSoli;
	}

	public void setRgSoli(String rgSoli) {
		this.rgSoli = rgSoli;
	}

	public String getMatriSoli() {
		return matriSoli;
	}

	public void setMatriSoli(String matriSoli) {
		this.matriSoli = matriSoli;
	}

	public String getCentroCustoSoli() {
		return centroCustoSoli;
	}

	public void setCentroCustoSoli(String centroCustoSoli) {
		this.centroCustoSoli = centroCustoSoli;
	}

	public String getContratoSoli() {
		return contratoSoli;
	}

	public void setContratoSoli(String contratoSoli) {
		this.contratoSoli = contratoSoli;
	}

	public String getCodForn() {
		return codForn;
	}

	public void setCodForn(String codForn) {
		this.codForn = codForn;
	}

	public String getNomeForn() {
		return nomeForn;
	}

	public void setNomeForn(String nomeForn) {
		this.nomeForn = nomeForn;
	}

	public String getContatoForn() {
		return contatoForn;
	}

	public void setContatoForn(String contatoForn) {
		this.contatoForn = contatoForn;
	}

	public String getTelForn() {
		return telForn;
	}

	public void setTelForn(String telForn) {
		this.telForn = telForn;
	}

	public String getFaxForn() {
		return faxForn;
	}

	public void setFaxForn(String faxForn) {
		this.faxForn = faxForn;
	}

	public String getEmailForn() {
		return emailForn;
	}

	public void setEmailForn(String emailForn) {
		this.emailForn = emailForn;
	}



	public String getCodProd() {
		return codProd;
	}

	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}

	public String getUnidMedProd() {
		return unidMedProd;
	}

	public void setUnidMedProd(String unidMedProd) {
		this.unidMedProd = unidMedProd;
	}

	public String getCentroCustoProd() {
		return centroCustoProd;
	}

	public void setCentroCustoProd(String centroCustoProd) {
		this.centroCustoProd = centroCustoProd;
	}

	public String getQtdAtProd() {
		return qtdAtProd;
	}

	public void setQtdAtProd(String qtdAtProd) {
		this.qtdAtProd = qtdAtProd;
	}

	public String getQtdProd() {
		return qtdProd;
	}

	public void setQtdProd(String qtdProd) {
		this.qtdProd = qtdProd;
	}

	public String getIpiProd() {
		return ipiProd;
	}

	public void setIpiProd(String ipiProd) {
		this.ipiProd = ipiProd;
	}

	public String getValorUnitProd() {
		return valorUnitProd;
	}

	public void setValorUnitProd(String valorUnitProd) {
		this.valorUnitProd = valorUnitProd;
	}

	public String getValorTotProd() {
		return valorTotProd;
	}

	public void setValorTotProd(String valorTotProd) {
		this.valorTotProd = valorTotProd;
	}

	public String getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}

	public String getDesconto() {
		return desconto;
	}

	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}

	public String getIss() {
		return iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	public String getFrete() {
		return frete;
	}

	public void setFrete(String frete) {
		this.frete = frete;
	}

	public String getFrete1() {
		return frete1;
	}

	public void setFrete1(String frete1) {
		this.frete1 = frete1;
	}

	public String getTotalGeral() {
		return totalGeral;
	}

	public void setTotalGeral(String totalGeral) {
		this.totalGeral = totalGeral;
	}

	public String getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(String prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public String getCondPag() {
		return condPag;
	}

	public void setCondPag(String condPag) {
		this.condPag = condPag;
	}

	public Boolean validate() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
