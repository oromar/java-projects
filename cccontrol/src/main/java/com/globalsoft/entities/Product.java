package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product extends BasicEntity {

	private static final long serialVersionUID = 870276501623387372L;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="NotaFiscal")
	private String notaFiscal;
	
	@Column(name="Marca")
	private String marca;
	
	@Column(name="Fabricante")
	private String fabricante;
	
	@Column(name="UnidadeMedida")
	private String unidadeMedida;
	
	@Column(name="Cor")
	private String cor;
	
	@Column(name="Serie")
	private String serie;
	
	@Column(name="Referencia")
	private String referencia;
	
	@Column(name="EstoqueMax")
	private String estoqueMax;
	
	@Column(name="EstoqueMin")
	private String estoqueMin;
	
	@Column(name="ValorUnitario")
	private String valorUnit;
	
	@Column(name="LocalEstoque")
	private String localEstoque;
	
	@Column(name="Fornecedor")
	private String fornecedor;
	
	@Column(name="ObsComments")
	private String obsComments;
	
	@Column(name="SubCategory")
	private String subCategory;
	
	
	public String getObsComments() {
		return obsComments;
	}


	public void setObsComments(String obsComments) {
		this.obsComments = obsComments;
	}


	public String getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}


	public String getSubCategory() {
		return subCategory;
	}


	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getFabricante() {
		return fabricante;
	}


	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}


	public String getUnidadeMedida() {
		return unidadeMedida;
	}


	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public String getSerie() {
		return serie;
	}


	public void setSerie(String serie) {
		this.serie = serie;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}


	public String getEstoqueMax() {
		return estoqueMax;
	}


	public void setEstoqueMax(String estoqueMax) {
		this.estoqueMax = estoqueMax;
	}


	public String getEstoqueMin() {
		return estoqueMin;
	}


	public void setEstoqueMin(String estoqueMin) {
		this.estoqueMin = estoqueMin;
	}


	public String getValorUnit() {
		return valorUnit;
	}


	public void setValorUnit(String valorUnit) {
		this.valorUnit = valorUnit;
	}


	public String getLocalEstoque() {
		return localEstoque;
	}


	public void setLocalEstoque(String localEstoque) {
		this.localEstoque = localEstoque;
	}


	public String getNotaFiscal() {
		return notaFiscal;
	}


	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	
	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public Boolean validate() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
