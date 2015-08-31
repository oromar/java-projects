package br.com.qualiti.delivery.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.qualiti.delivery.interfaces.EntidadeBasica;
import br.com.qualiti.delivery.negocio.excecoes.CampoInvalidoException;
import br.com.qualiti.delivery.negocio.excecoes.CampoObrigatorioNaoPreenchidoException;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "item_venda")
public class ItemVenda implements Serializable, EntidadeBasica {

    private static final long serialVersionUID = 6168948130772368011L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    @Column(name = "sequencial")
    private Integer sequencial;
    @OneToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "valor")
    private Double valor;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    public ItemVenda() {
    }

    public Integer getSequencial() {
        return sequencial;
    }

    public void setSequencial(Integer sequencial) {
        this.sequencial = sequencial;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public Serializable getId() {
        return codigo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean validar() throws Exception {
        if (Objects.isNull(sequencial)) {
            throw new CampoObrigatorioNaoPreenchidoException("Sequencial não preenchido !");
        }
        if (Objects.isNull(produto)) {
            throw new CampoObrigatorioNaoPreenchidoException("Produto não informado !");
        }
        if (Objects.isNull(quantidade)) {
            throw new CampoObrigatorioNaoPreenchidoException("Quantidade não informada !");
        }
        if (quantidade == 0) {
            throw new CampoInvalidoException("Quantidade não pode ser zero (0) !");
        }
        if (pedido == null) {
            throw new CampoObrigatorioNaoPreenchidoException("Pedido não informado !");
        }
        produto.validar();
        return true;
    }
}
