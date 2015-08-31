package br.com.qualiti.delivery.interfaces;

import java.io.Serializable;


public interface Repositorio<T> {
	
	boolean existe(Serializable chave)throws Exception;
	void inserir(T entidade) throws Exception;
	void atualizar(T entidade) throws Exception;
	void remover(Serializable chave) throws Exception;
	T procurar(Serializable chave) throws Exception;
	T[] buscarTodos()throws Exception;

}
