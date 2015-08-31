package br.com.qualiti.delivery.repositorio;
import java.io.Serializable;

import br.com.qualiti.delivery.entidades.Pedido;
import br.com.qualiti.delivery.interfaces.Repositorio;


public class RepositorioPedidoArray implements Repositorio<Pedido> {
	
	private static final int MAX_TAM_CACHE = 10000;
	private int indice = 0;
	private Pedido[] repositorio;
	
	public RepositorioPedidoArray() {
		repositorio = new Pedido[MAX_TAM_CACHE];
	}
	
	private int procurarIndice(Serializable codigo){
		int retorno = -1;
		for(int i =0; i < indice; i++){
			if (repositorio[i].getCodigo().equals(codigo)){
				retorno = i;
				break;
			}
		}
		return retorno;
	}
	
	/* (non-Javadoc)
	 * @see br.com.qualiti.delivery.repositorio.RepositorioPedido#existe(int)
	 */
	@Override
	public boolean existe(Serializable codigo){
		return procurarIndice(codigo) != -1;
	}
	
	/* (non-Javadoc)
	 * @see br.com.qualiti.delivery.repositorio.RepositorioPedido#procurar(int)
	 */
	@Override
	public Pedido procurar(Serializable codigo){
		Pedido retorno = null;
		if (existe(codigo)){
			retorno = repositorio[procurarIndice(codigo)];
		}
		return retorno;
	}
	
	/* (non-Javadoc)
	 * @see br.com.qualiti.delivery.repositorio.RepositorioPedido#inserir(br.com.qualiti.delivery.entidades.Pedido)
	 */
	@Override
	public void inserir(Pedido pedido){
		repositorio[indice++] = pedido;
	}
	
	/* (non-Javadoc)
	 * @see br.com.qualiti.delivery.repositorio.RepositorioPedido#atualizar(br.com.qualiti.delivery.entidades.Pedido)
	 */
	@Override
	public void atualizar(Pedido pedido){
		int i = 0;
		if (existe(pedido.getCodigo())){
			i = procurarIndice(pedido.getCodigo());
			repositorio[i] = pedido;
		}
	}
	
	/* (non-Javadoc)
	 * @see br.com.qualiti.delivery.repositorio.RepositorioPedido#remover(int)
	 */
	@Override
	public void remover(Serializable codigo){
		int i =0;
		if (existe(codigo)){
			i = procurarIndice(codigo);
			repositorio[i] = repositorio[indice-1];
			repositorio[indice-1] = null;
			indice--;
		}
	}

	@Override
	public Pedido[] buscarTodos() {
		return repositorio.clone();
	}
}
