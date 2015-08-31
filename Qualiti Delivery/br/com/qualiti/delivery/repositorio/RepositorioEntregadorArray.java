package br.com.qualiti.delivery.repositorio;
import java.io.Serializable;

import br.com.qualiti.delivery.entidades.Entregador;
import br.com.qualiti.delivery.interfaces.Repositorio;


public class RepositorioEntregadorArray implements Repositorio<Entregador> {

	private static final int MAX_TAM_CACHE = 1000;	
	private Entregador[] repositorio;
	private int indice = 0;

	
	public RepositorioEntregadorArray() {
		repositorio = new Entregador[MAX_TAM_CACHE];
	}
	
	private int procurarIndice(Serializable matricula){
		int retorno = -1;
		for(int i =0; i < indice; i++){
			if (repositorio[i].getMatricula().equals(matricula)){
				retorno = i;
				break;
			}
		}
		return retorno;
	}
	
	public boolean existe(Serializable matricula){
		return procurarIndice(matricula) != -1;
	}
	
	public Entregador procurar(Serializable matricula){
		Entregador retorno = null;
		if (existe(matricula)){
			retorno = repositorio[procurarIndice(matricula)];
		}
		return retorno;
	}
	
	public void inserir(Entregador entregador){
		repositorio[indice++] = entregador;
	}
	
	public void atualizar(Entregador entregador){
		int indice = 0;
		if (existe(entregador.getMatricula())){
			indice = procurarIndice(entregador.getMatricula());
			repositorio[indice] = entregador;
		}
	}
	
	public void remover(Serializable matricula) {
		if (existe(matricula)){
			int i = procurarIndice(matricula);
			repositorio[i] = repositorio[indice-1];
			repositorio[indice-1] = null;
			indice--;
		}
	}

	@Override
	public Entregador[] buscarTodos() throws Exception {
		return repositorio.clone();
	}
	
}
