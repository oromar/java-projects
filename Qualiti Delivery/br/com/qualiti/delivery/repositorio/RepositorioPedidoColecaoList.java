package br.com.qualiti.delivery.repositorio;

import java.io.Serializable;

import br.com.qualiti.delivery.entidades.Pedido;
import br.com.qualiti.delivery.interfaces.Repositorio;

public class RepositorioPedidoColecaoList implements Repositorio<Pedido> {

	@Override
	public boolean existe(Serializable chave) throws Exception{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pedido procurar(Serializable chave) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Pedido pedido) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Pedido pedido) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Serializable chave) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Pedido[] buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
