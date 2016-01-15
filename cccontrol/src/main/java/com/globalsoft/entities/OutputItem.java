package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="output_item")
public class OutputItem extends BasicEntity {

	private static final long serialVersionUID = -8808266514982783703L;

	@OneToOne
	private Product product;
	@ManyToOne
	private OutputMaterials output;
	@Column(name="Quantity")
	private Integer quantity;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OutputMaterials getOutput() {
		return output;
	}

	public void setOutput(OutputMaterials output) {
		this.output = output;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean validate() throws Exception {

		if (product == null) {
			throw new Exception("Produto n�o informado!");
		}
		if (output == null) {
			throw new Exception("Sa�da n�o informada!");
		}
		if (quantity == null) {
			throw new Exception("Quantidade n�o informada!");
		}
		product.validate();
		output.validate();
		return Boolean.TRUE;
	}
}
