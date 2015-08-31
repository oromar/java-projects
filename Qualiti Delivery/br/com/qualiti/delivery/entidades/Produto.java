package br.com.qualiti.delivery.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.qualiti.delivery.interfaces.EntidadeBasica;
import br.com.qualiti.delivery.negocio.excecoes.CampoInvalidoException;
import br.com.qualiti.delivery.negocio.excecoes.CampoObrigatorioNaoPreenchidoException;
import br.com.qualiti.delivery.util.Util;
import java.text.ParseException;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

@Entity
@Table(name = "produto")
public class Produto implements Serializable, EntidadeBasica {

    private static final long serialVersionUID = 9110188556640729642L;
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "preco_unitario")
    private Double precoUnitario;
    @Column(name = "data_validade")
    @Temporal(TemporalType.DATE)
    private Date dataValidade;
    @Transient
    private String dateString;

    public Produto() {
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

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    @Override
    public Serializable getId() {
        return codigo;
    }

    @Override
    public boolean validar() throws Exception {

        if (Util.isNullOrEmpty(nome)) {
            throw new CampoObrigatorioNaoPreenchidoException("Favor informar o nome !");
        }

        if (!Util.isNullOrEmpty(dateString)) {
            try {
                this.dataValidade = Util.getStringAsDate(dateString);
            } catch (ParseException pex) {
                throw new CampoInvalidoException("Data de validade do produto inválida !");
            }
        }

        if (Objects.isNull(precoUnitario)) {
            throw new CampoObrigatorioNaoPreenchidoException("Favor informar o preço unitário !");
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return getId().equals(((EntidadeBasica) obj).getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
