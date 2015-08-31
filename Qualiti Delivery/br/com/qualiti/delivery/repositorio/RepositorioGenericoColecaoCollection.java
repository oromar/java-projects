package br.com.qualiti.delivery.repositorio;

import java.io.Serializable;
import java.util.Collection;

import br.com.qualiti.delivery.interfaces.EntidadeBasica;
import br.com.qualiti.delivery.interfaces.Repositorio;

public class RepositorioGenericoColecaoCollection<T extends EntidadeBasica> implements Repositorio<T>{

	private Collection<T> repositorio;
	
	public RepositorioGenericoColecaoCollection(Collection<T> collection) {
		repositorio = collection;
	}
	
	@Override
	public boolean existe(Serializable chave) throws Exception {
		return procurar(chave) != null;
	}

	@Override
	public void inserir(T entidade) throws Exception {
		repositorio.add(entidade);
		
	}

	@Override
	public void atualizar(T entidade) throws Exception {
		T aux = procurar(entidade.getId());
		repositorio.remove(aux);
		repositorio.add(entidade);
	}

	@Override
	public void remover(Serializable chave) throws Exception {
		repositorio.remove(procurar(chave));
	}

	@Override
	public T procurar(Serializable chave) throws Exception {
		for (T t : repositorio) {
			if (t.getId().equals(chave)){
				return t;
			}
		}
		return null;
	}

	@Override
	public T[] buscarTodos() throws Exception {
		return (T[]) repositorio.toArray();
	}

}
