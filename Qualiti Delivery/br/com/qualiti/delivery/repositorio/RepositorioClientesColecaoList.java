package br.com.qualiti.delivery.repositorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.qualiti.delivery.entidades.Cliente;
import br.com.qualiti.delivery.interfaces.Repositorio;

public class RepositorioClientesColecaoList implements Repositorio<Cliente>{

	private List<Cliente> repositorio;
	
	public RepositorioClientesColecaoList() {
		this.repositorio = new ArrayList<>();
	}
	
	@Override
	public boolean existe(Serializable cpf) throws Exception {
		return procurar(cpf) != null;
	}

	@Override
	public void inserir(Cliente cliente) throws Exception {
		this.repositorio.add(cliente);
	}

	@Override
	public void atualizar(Cliente cliente) throws Exception {
		Cliente aux = procurar(cliente.getCpf());
		int index = this.repositorio.indexOf(aux);
		this.repositorio.set(index, cliente);
		//this.repositorio.remove(aux);
		//this.repositorio.add(cliente);
	}

	@Override
	public void remover(Serializable cpf) throws Exception {
		Cliente aux = procurar(cpf);
		this.repositorio.remove(aux);
	}

	@Override
	public Cliente procurar(Serializable cpf) throws Exception {
		for (Cliente aux : this.repositorio) {
			if (aux.getCpf().equals(cpf)){
				return aux;
			}
		}
		return null;
	}

	@Override
	public Cliente[] buscarTodos() throws Exception {
		Cliente[] result = new Cliente[this.repositorio.size()];
		result = this.repositorio.toArray(result);
		return result;
	}

}
