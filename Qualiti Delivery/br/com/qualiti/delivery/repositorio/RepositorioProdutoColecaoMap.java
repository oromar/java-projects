package br.com.qualiti.delivery.repositorio;

import java.io.Serializable;

import br.com.qualiti.delivery.entidades.Produto;
import br.com.qualiti.delivery.interfaces.Repositorio;

public class RepositorioProdutoColecaoMap implements Repositorio<Produto> {

	@Override
	public boolean existe(Serializable chave) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void inserir(Produto entidade) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Produto entidade) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Serializable chave) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto procurar(Serializable chave) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto[] buscarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
