package br.com.qualiti.delivery.entidades;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.qualiti.delivery.interfaces.EntidadeBasica;
import br.com.qualiti.delivery.negocio.excecoes.CampoInvalidoException;
import br.com.qualiti.delivery.negocio.excecoes.CampoObrigatorioNaoPreenchidoException;
import br.com.qualiti.delivery.util.StatusPedido;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

@Entity
@Table(name="pedido")
public class Pedido implements Serializable, EntidadeBasica {
	
	private static final long serialVersionUID = 7582869021826874115L;
	@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	@Column(name="data_pedido")
	@Temporal(TemporalType.DATE)
	private Date dataPedido;
	@OneToOne
	@JoinColumn(name="cpf_cliente")
	private Cliente cliente;
        @OneToOne
	@JoinColumn(name="matricula_entregador")
	private Entregador entregador;
	@OneToOne
	@JoinColumn(name="codigo_forma_pagamento")
	private FormaPagamento formaPagamento;
	@OneToMany(mappedBy="pedido", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<ItemVenda> itens;
        @Column(name = "status_pedido")
        private StatusPedido status;
	@OneToOne
        @Transient
        private int sequencial;
	
	public Pedido() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	
	@Override
	public Serializable getId() {
		return codigo;
	}

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }
        
        
	
	@Override
	public boolean validar() throws Exception {
		if (Objects.isNull(cliente)) {
			throw new CampoObrigatorioNaoPreenchidoException("Favor selecionar o Cliente !");
		}
		if (!cliente.validar()) {
			throw new CampoInvalidoException("Favor verificar os dados do cliente !");
		}
		if (Objects.isNull(dataPedido)) {
			throw new CampoObrigatorioNaoPreenchidoException("Favor informar a Data do Pedido !");
		}
		if (dataPedido.after(new Date())){
			throw new CampoInvalidoException("Data do pedido maior que a data de hoje !");
		}
		if (Objects.isNull(entregador)) {
			throw new CampoObrigatorioNaoPreenchidoException("Favor selecionar o Entregador !");
		}
		if (!entregador.validar()) {
			throw new CampoInvalidoException("Favor verificar os dados do entregador !");
		}
		if (Objects.isNull(formaPagamento)) {
			throw new CampoObrigatorioNaoPreenchidoException("Favor selecionar a Forma de Pagamento");
		}
		if (!formaPagamento.validar()) {
			throw new CampoInvalidoException("Favor verificar os dados da forma de pagamento !");
		}
		if (Objects.isNull(itens)) {
			throw new CampoObrigatorioNaoPreenchidoException("Favor informar ao menos um item de venda !");
		}
		if (Objects.isNull(status)){
			throw new CampoObrigatorioNaoPreenchidoException("Favor informar o status do pedido !");
		}
		for (ItemVenda item : itens) {
			item.validar();
		}
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		return getId().equals(((EntidadeBasica)obj).getClass());
	}
	
	@Override
	public int hashCode() {
		return getId().hashCode();
	}
}
