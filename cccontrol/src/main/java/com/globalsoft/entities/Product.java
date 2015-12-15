package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.globalsoft.util.Constants;
import com.globalsoft.util.Messages;

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
	
	@OneToOne
	@JoinColumn(name="supplier")
	private Supplier supplier;
	
	@Column(name="ObsComments")
	private String obsComments;
	
	@OneToOne
	@JoinColumn(name="sub_category")
	private Subcategory subCategory;
	
	
	public String getObsComments() {
		return obsComments;
	}


	public void setObsComments(String obsComments) {
		this.obsComments = obsComments;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setFornecedor(Supplier supplier) {
		this.supplier = supplier;
	}


	public Subcategory getSubCategory() {
		return subCategory;
	}


	public void setSubCategory(Subcategory subCategory) {
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
	
		//Funciona tanto na tela de cadastro quanto na atualização dos dados.
		if(nome == null || nome.isEmpty()){
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (fabricante == null || fabricante.isEmpty()){
			throw new Exception(Messages.INVALID_FIELD);
		}
		if(notaFiscal == null || notaFiscal.isEmpty() || !notaFiscal.matches(Constants.ONLY_NUMBERS_REGEX)){
			throw new Exception(Messages.INVALID_FIELD);
		}
		if(marca == null || marca.isEmpty()){
			throw new Exception(Messages.INVALID_FIELD);
		}
		if(unidadeMedida == null || unidadeMedida.isEmpty()){
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (localEstoque == null || localEstoque.isEmpty()){
			throw new Exception(Messages.INVALID_FIELD);
		}
		if (estoqueMax == null || estoqueMax.isEmpty() || !estoqueMax.matches(Constants.ONLY_NUMBERS_REGEX)){
			throw new Exception(Messages.INVALID_FIELD);
		}
		
		
		if(getId()==null){ // Só Funciona na Tela de Cadastro de Produtos. 
			
		}
		return Boolean.TRUE;
	}

	
}
