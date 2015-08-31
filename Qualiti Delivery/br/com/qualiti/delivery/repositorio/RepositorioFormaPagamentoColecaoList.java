package br.com.qualiti.delivery.repositorio;

import java.io.Serializable;

import br.com.qualiti.delivery.entidades.FormaPagamento;
import br.com.qualiti.delivery.interfaces.Repositorio;

public class RepositorioFormaPagamentoColecaoList implements
Repositorio<FormaPagamento> {

	@Override
	public boolean existe(Serializable chave) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void inserir(FormaPagamento formaPagamento) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(FormaPagamento formaPagamento) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Serializable chave) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public FormaPagamento procurar(Serializable chave) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormaPagamento[] buscarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
