package br.com.qualiti.delivery.entidades;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import br.com.qualiti.delivery.interfaces.EntidadeBasica;
import br.com.qualiti.delivery.negocio.excecoes.CampoInvalidoException;
import br.com.qualiti.delivery.negocio.excecoes.CampoNumericoPreenchidoComLetrasException;
import br.com.qualiti.delivery.negocio.excecoes.CampoObrigatorioNaoPreenchidoException;
import br.com.qualiti.delivery.util.Util;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pessoa")
public class Pessoa implements Serializable, EntidadeBasica {

    private static final long serialVersionUID = -6273468341893764166L;

    @Column(name = "nome")
    private String nome;
    @Id
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    private String dateString;

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public Serializable getId() {
        return cpf;
    }

    public boolean validar() throws Exception {

        if (Util.isNullOrEmpty(nome)) {
            throw new CampoObrigatorioNaoPreenchidoException("Nome não preenchido !");
        }
        if (Util.isNullOrEmpty(cpf)) {
            throw new CampoObrigatorioNaoPreenchidoException("CPF não preenchido !");
        }
        if (!Util.onlyNumbers(cpf)) {
            throw new CampoNumericoPreenchidoComLetrasException("CPF só deve conter números !");
        }
        if (!Util.hasLenght(cpf, 11)) {
            throw new CampoInvalidoException("CPF deve conter 11 dígitos !");
        }
        if (Util.isNullOrEmpty(dateString)) {
            throw new CampoObrigatorioNaoPreenchidoException("Data de nascimento não preenchida !");
        }
        try {
            this.dataNascimento = Util.getStringAsDate(dateString);
        } catch (ParseException pex) {
            throw new CampoInvalidoException("Data de nascimento inválida !");
        }
        return true;
    }

    public boolean equals(Object obj
    ) {
        return getId().equals(((EntidadeBasica) obj).getClass());
    }

    public int hashCode() {
        return getId().hashCode();
    }

    public String toString() {
        return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", dataNascimento="
                + dataNascimento + "]";
    }
}
