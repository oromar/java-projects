
package br.com.qualiti.delivery.entidades;

import java.io.Serializable;
import java.util.Objects;

import br.com.qualiti.delivery.interfaces.EntidadeBasica;
import br.com.qualiti.delivery.negocio.excecoes.CampoInvalidoException;
import br.com.qualiti.delivery.negocio.excecoes.CampoObrigatorioNaoPreenchidoException;
import br.com.qualiti.delivery.util.Util;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("1")
public class Cliente extends Pessoa implements Serializable,EntidadeBasica {

	private static final long serialVersionUID = 2851378664195085275L;
	
        @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Endereco endereco;
	@Column(name="telefone")
	private String telefone;
        @Column(name="celular")
	private String celular;
        @Column(name="email")
	private String email;
        @Column(name="email2")
	private String email2;
        

	public Cliente(){
		super();
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public boolean validar() throws Exception {
		
		super.validar();
		
		if (Util.isNullOrEmpty(telefone)){
			throw new CampoObrigatorioNaoPreenchidoException("Favor informar o telefone !");
		}
		if (!Util.onlyNumbers(telefone)) {
			throw new CampoInvalidoException("Telefone só deve conter números !");
		}
		if (Util.isNullOrEmpty(celular)){
			throw new CampoObrigatorioNaoPreenchidoException("Favor informar o celular !");
		}
		if (!Util.onlyNumbers(celular)){
			throw new CampoInvalidoException("Celular só deve conter números !");
		}
		if (Util.isNullOrEmpty(email)){
			throw new CampoObrigatorioNaoPreenchidoException("Favor preencher o email !");
		}
		if (Objects.isNull(endereco)) {
			throw new CampoObrigatorioNaoPreenchidoException("Favor preencher o endereço !");
		}
		if (!endereco.validar()) {
			throw new CampoInvalidoException("Favor verificar os dados do endereço !");
		}
		
                return true;
	}
	
	public boolean equals(Object obj) {
		return getId().equals(((EntidadeBasica)obj).getClass());
	}

	public int hashCode() {
		return getId().hashCode();
	}

	public String toString() {

		return super.toString() + "\nCliente [endereco=" + endereco + ", telefone=" + telefone
				+ ", celular=" + celular + ", email=" + email + "]";
	}

}
