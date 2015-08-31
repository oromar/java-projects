package br.com.qualiti.delivery.repositorio;
import java.io.Serializable;

import br.com.qualiti.delivery.entidades.Cliente;
import br.com.qualiti.delivery.interfaces.Repositorio;


public class RepositorioClientesArray implements Repositorio<Cliente> {
	
	private static final int TAMANHO_CACHE = 1000;
	private Cliente[] clientes;
	private int indice;
	
	public RepositorioClientesArray() {
		clientes = new Cliente[TAMANHO_CACHE];
		indice = 0;
	}
	
	//m�todo auxiliar
	private int procurarIndice(Serializable cpf) {
		int posicao = -1;
		for(int i =0; i < indice; i++) {
			if (clientes[i].getCpf().equals(cpf)){
				posicao = i;
				break;
			}
		}
		return posicao;
	}

	public boolean existe(Serializable cpf) throws Exception {
		return procurarIndice(cpf) != -1;
	}
	
	public Cliente procurar(Serializable cpf) throws Exception {
		Cliente retorno = null;
		int indice = 0;
		if (existe(cpf)) {
			indice = procurarIndice(cpf);
			retorno = clientes[indice];
		}
		return retorno;
	}
	
	public void inserir(Cliente cliente) throws Exception {
		clientes[indice++] = cliente;
	}
	
	public void atualizar(Cliente cliente) throws Exception {
		if (existe(cliente.getCpf())){
			int i = procurarIndice(cliente.getCpf());
			clientes[i] = cliente;
		}
	}
	
	public void remover(Serializable cpf) throws Exception{
		int i = 0;
		if (existe(cpf)){
			i = procurarIndice(cpf);
			clientes[i] = clientes[indice - 1];
			clientes[indice -1] = null;
			indice--;
		}
	}

	public Cliente[] buscarTodos() throws Exception{
		return clientes.clone();
	}
}



