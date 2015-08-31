package br.com.qualiti.delivery.repositorio;

import java.io.Serializable;

import br.com.qualiti.delivery.entidades.Entregador;
import br.com.qualiti.delivery.interfaces.Repositorio;

public class RepositorioEntregadorColecaoList implements Repositorio<Entregador> {

	@Override
	public boolean existe(Serializable matricula) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void inserir(Entregador entregador) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Entregador entregador) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Serializable matricula) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entregador procurar(Serializable matricula) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entregador[] buscarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
