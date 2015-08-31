package br.com.qualiti.delivery.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.qualiti.delivery.interfaces.EntidadeBasica;
import br.com.qualiti.delivery.negocio.excecoes.CampoObrigatorioNaoPreenchidoException;
import br.com.qualiti.delivery.util.Util;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "forma_pagamento")
public class FormaPagamento implements Serializable, EntidadeBasica {

    private static final long serialVersionUID = -6209397538530667592L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "nome")
    private String nome;

    public FormaPagamento() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public Serializable getId() {
        return codigo;
    }

    @Override
    public boolean validar() throws Exception {
        if (Util.isNullOrEmpty(nome)) {
            throw new CampoObrigatorioNaoPreenchidoException("Favor informar o nome da forma de pagamento");
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EntidadeBasica) {
            return getId().equals(((EntidadeBasica) obj).getId());
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
        return nome;
    }
}
