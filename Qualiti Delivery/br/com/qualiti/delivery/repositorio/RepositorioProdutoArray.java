package br.com.qualiti.delivery.repositorio;
import java.io.Serializable;

import br.com.qualiti.delivery.entidades.Produto;
import br.com.qualiti.delivery.interfaces.Repositorio;


public class RepositorioProdutoArray implements Repositorio<Produto> {

	private static final int MAX_TAM_CACHE = 1000000;
	private int indice;
	private Produto[] repositorio;

	public RepositorioProdutoArray() {
		repositorio = new Produto[MAX_TAM_CACHE];
	}

	private int procurarIndice(Serializable codigo){
		int retorno = -1;
		for(int i=0; i < indice; i++){
			if (repositorio[i].getCodigo() == codigo){
				retorno = i;
				break;
			}
		}
		return retorno;
	}

	/* (non-Javadoc)
	 * @see br.com.qualiti.delivery.repositorio.RepositorioProduto#existe(int)
	 */
	@Override
	public boolean existe(Serializable chave) throws Exception{
		return procurarIndice(chave)!= -1;
	}

	/* (non-Javadoc)
	 * @see br.com.qualiti.delivery.repositorio.RepositorioProduto#procurar(int)
	 */
	@Override
	public Produto procurar(Serializable chave) throws Exception{
		Produto produto = null;
		if (existe(chave)){
			produto = repositorio[procurarIndice(chave)];
		}
		return produto;
	}

	/* (non-Javadoc)
	 * @see br.com.qualiti.delivery.repositorio.RepositorioProduto#inserir(br.com.qualiti.delivery.entidades.Produto)
	 */
	@Override
	public void inserir(Produto produto){
		repositorio[indice++] = produto;
	}

	/* (non-Javadoc)
	 * @see br.com.qualiti.delivery.repositorio.RepositorioProduto#atualizar(br.com.qualiti.delivery.entidades.Produto)
	 */
	@Override
	public void atualizar(Produto produto) throws Exception{
		if (existe(produto.getCodigo())){
			repositorio[procurarIndice(produto.getCodigo())] = produto;
		}
	}

	/* (non-Javadoc)
	 * @see br.com.qualiti.delivery.repositorio.RepositorioProduto#remover(int)
	 */
	@Override
	public void remover(Serializable chave) throws Exception{
		int i = 0;
		if (existe(chave)){
			i = procurarIndice(chave);
			repositorio[i] = repositorio[indice-1];
			repositorio[indice-1] = null;
			indice--;
		}
	}

	@Override
	public Produto[] buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}
