package br.com.qualiti.delivery.negocio;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import br.com.qualiti.delivery.interfaces.CadastroHibernate;
import br.com.qualiti.delivery.interfaces.EntidadeBasica;
import br.com.qualiti.delivery.interfaces.RepositorioHibernate;
import br.com.qualiti.delivery.negocio.excecoes.RegistroJaCadastradoException;
import br.com.qualiti.delivery.negocio.excecoes.RegistroNaoCadastradoException;
import br.com.qualiti.delivery.util.Util;

public abstract class CadastroGenerico<T extends EntidadeBasica> implements CadastroHibernate<T> {

	private RepositorioHibernate<T> repositorio;

	public CadastroGenerico(RepositorioHibernate<T> repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public boolean existe(Serializable chave) throws Exception {
		return procurar(chave) != null;
	}

	@Override
	public void inserir(T entidade) throws Exception {
		if (entidade.validar()) {
                    Util.toUpperCaseAllStrings(entidade);
                    repositorio.inserir(entidade);
		} else {
			throw new RegistroJaCadastradoException();
		}
	}

	@Override
	public void atualizar(T entidade) throws Exception {
		if (entidade.validar() && existe(entidade.getId())){
                    Util.toUpperCaseAllStrings(entidade);
                    repositorio.atualizar(entidade);
		} else {
			throw new RegistroNaoCadastradoException();
		}
	}

	@Override
	public void remover(Serializable chave) throws Exception {
		if (existe(chave)){
			repositorio.remover(chave);
		} else {
			throw new RegistroNaoCadastradoException();
		}
	}

	@Override
	public T procurar(Serializable chave) throws Exception {
		return repositorio.procurar(chave);
	}

	@Override
	public T[] buscarTodos() throws Exception {
		return repositorio.buscarTodos();
	}
	
	public Collection<T> filtrar(T entidade) {
		return repositorio.filtrar(entidade);
	}

	@Override
	public Collection<T> findCollectionByHQL(String hql,
			Map<String, Object> parameters) {
		return repositorio.findCollectionByHQL(hql, parameters);
	}

	@Override
	public T findUniqueByHQL(String hql, Map<String, Object> parameters) {
		return repositorio.findUniqueByHQL(hql, parameters);
	}
}
