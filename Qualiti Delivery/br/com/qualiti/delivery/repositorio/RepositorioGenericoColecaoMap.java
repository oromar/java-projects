package br.com.qualiti.delivery.repositorio;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.com.qualiti.delivery.interfaces.EntidadeBasica;
import br.com.qualiti.delivery.interfaces.Repositorio;

public class RepositorioGenericoColecaoMap<T extends EntidadeBasica> implements Repositorio<T> {

	private Map<Serializable, T> repositorio;
	
	public RepositorioGenericoColecaoMap() {
		repositorio = new HashMap<>();
	}
	
	@Override
	public boolean existe(Serializable chave) throws Exception {
		return repositorio.containsKey(chave);
	}

	@Override
	public void inserir(T entidade) throws Exception {
		repositorio.put(entidade.getId(), entidade);
	}

	@Override
	public void atualizar(T entidade) throws Exception {
		inserir(entidade);
	}

	@Override
	public void remover(Serializable chave) throws Exception {
		repositorio.remove(chave);
	}

	@Override
	public T procurar(Serializable chave) throws Exception {
		return repositorio.get(chave);
	}

	@Override
	public T[] buscarTodos() throws Exception {
		return (T[]) repositorio.values().toArray();
	}

}
