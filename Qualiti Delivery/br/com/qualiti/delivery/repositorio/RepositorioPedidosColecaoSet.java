package br.com.qualiti.delivery.repositorio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.qualiti.delivery.entidades.Pedido;
import br.com.qualiti.delivery.interfaces.Repositorio;

public class RepositorioPedidosColecaoSet implements Repositorio<Pedido> {

	private Set repositorio;

	public RepositorioPedidosColecaoSet() {
		repositorio = new HashSet();
	}

	@Override
	public boolean existe(Serializable chave) throws Exception {
		return procurar(chave) != null;
	}

	@Override
	public Pedido procurar(Serializable chave) throws Exception {
		Pedido aux = null;
		for (Object p : repositorio){
			aux = (Pedido) p;
			if (aux.getCodigo() == chave){
				return aux;
			}
		}
		return null;
	}

	@Override
	public void inserir(Pedido pedido) throws Exception{
		repositorio.add(pedido);
	}

	@Override
	public void atualizar(Pedido pedido) throws Exception{
		if (repositorio.contains(pedido)){
			Pedido p = procurar(pedido.getCodigo());
			repositorio.remove(p);
			repositorio.add(pedido);
		} 
	}

	@Override
	public void remover(Serializable chave) throws Exception {
		repositorio.remove(procurar(chave));

	}

	@Override
	public Pedido[] buscarTodos() {
		return (Pedido[]) repositorio.toArray(new Pedido[repositorio.size()]);
	}

}
