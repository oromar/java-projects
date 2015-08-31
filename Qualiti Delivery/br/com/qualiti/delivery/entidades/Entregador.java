package br.com.qualiti.delivery.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.qualiti.delivery.interfaces.EntidadeBasica;
import br.com.qualiti.delivery.negocio.excecoes.CampoNumericoPreenchidoComLetrasException;
import br.com.qualiti.delivery.negocio.excecoes.CampoObrigatorioNaoPreenchidoException;
import br.com.qualiti.delivery.util.Util;
@Entity
@DiscriminatorValue("2")
public class Entregador extends Pessoa implements Serializable, EntidadeBasica {
	
	private static final long serialVersionUID = -2695997554929323635L;
	@Column(name="matricula", unique=true)
	private String matricula;
	@Column(name="placa_moto", unique=true)
	private String placaMoto;
	@Column(name="modelo_moto")
	private String modelo;
	@Column(name="telefone_entregador")
	private String telefone;
	
	public Entregador() {
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getPlacaMoto() {
		return placaMoto;
	}

	public void setPlacaMoto(String placaMoto) {
		this.placaMoto = placaMoto;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public Serializable getId() {
		return getCpf();
	}
	
	@Override
	public boolean validar() throws Exception {
                
                super.validar();
		if (Util.isNullOrEmpty(matricula)) {
			throw new CampoObrigatorioNaoPreenchidoException("Favor informar matrícula do entregador !");
		}
		if (!Util.onlyNumbers(matricula)){
			throw new CampoNumericoPreenchidoComLetrasException("Matricula do entregador não pode conter letras !");
		}
		if (Util.isNullOrEmpty(getNome())) {
			throw new CampoObrigatorioNaoPreenchidoException("Favor informar nome do entregador !");
		}
		if (Util.isNullOrEmpty(telefone)){
			throw new CampoObrigatorioNaoPreenchidoException("Favor informar telefone do entregador !");
		}
		if (Util.isNullOrEmpty(modelo)){
			throw new CampoObrigatorioNaoPreenchidoException("Favor informar modelo da moto do entregador !");
		}
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
            if (obj instanceof EntidadeBasica) {
		return getId().equals(((EntidadeBasica)obj).getId());
            } else {
                return false;
            }
	}
	
	@Override
	public int hashCode() {
		return getId().hashCode();
	}

    @Override
    public String toString() {
        return getMatricula() + " - " + getNome();
    }
        
        
}
