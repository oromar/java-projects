package br.com.qualiti.delivery.repositorio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.qualiti.delivery.entidades.FormaPagamento;
import br.com.qualiti.delivery.interfaces.Repositorio;

public class RepositorioFormaPagamentoColecaoSet implements
		Repositorio<FormaPagamento> {
	
	private Set<FormaPagamento> repositorio;
	
	public RepositorioFormaPagamentoColecaoSet() {
		this.repositorio = new HashSet<>();
	}

	@Override
	public boolean existe(Serializable codigo) throws Exception {
		return procurar(codigo) != null;
	}

	@Override
	public void inserir(FormaPagamento formaPagamento) throws Exception {
		this.repositorio.add(formaPagamento);

	}

	@Override
	public void atualizar(FormaPagamento formaPagamento) throws Exception {
		FormaPagamento aux = procurar(formaPagamento.getCodigo());
		this.repositorio.remove(aux);
		this.repositorio.add(formaPagamento);

	}

	@Override
	public void remover(Serializable codigo) throws Exception {
		this.repositorio.remove(procurar(codigo));
	}

	@Override
	public FormaPagamento procurar(Serializable codigo) throws Exception {
		for (FormaPagamento obj : this.repositorio) {
			if (obj.getCodigo().equals(codigo)) {
				return obj;
			}
		}
		return null;
	}

	@Override
	public FormaPagamento[] buscarTodos() throws Exception {
		return this.repositorio.toArray(new FormaPagamento[this.repositorio.size()]);
	}

}
