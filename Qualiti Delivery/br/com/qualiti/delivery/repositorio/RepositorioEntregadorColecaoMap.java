package br.com.qualiti.delivery.repositorio;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.com.qualiti.delivery.entidades.Entregador;
import br.com.qualiti.delivery.interfaces.Repositorio;

public class RepositorioEntregadorColecaoMap implements Repositorio<Entregador> {

	private Map repositorio;
	
	public RepositorioEntregadorColecaoMap() {
		this.repositorio = new HashMap();
	}
	
	@Override
	public boolean existe(Serializable matricula) throws Exception {
		return this.repositorio.containsKey(matricula);
	}

	@Override
	public void inserir(Entregador entregador) throws Exception {
		this.repositorio.put(entregador.getMatricula(), entregador);

	}

	@Override
	public void atualizar(Entregador entregador) throws Exception {
		this.repositorio.put(entregador.getMatricula(), entregador);
	}

	@Override
	public void remover(Serializable matricula) throws Exception {
		this.repositorio.remove(matricula);
	}

	@Override
	public Entregador procurar(Serializable matricula) throws Exception {
		return (Entregador) this.repositorio.get(matricula);
	}

	@Override
	public Entregador[] buscarTodos() throws Exception {
		return (Entregador[]) this.repositorio.values().toArray(new Entregador[this.repositorio.size()]);
	}

}
