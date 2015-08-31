package br.com.qualiti.delivery.repositorio;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.qualiti.delivery.entidades.Cliente;
import br.com.qualiti.delivery.interfaces.Repositorio;

public class RepositorioClienteArquivoBinario implements Repositorio<Cliente> {

	private File repositorio;
	private List<Cliente> lista = new ArrayList<>();

	public RepositorioClienteArquivoBinario() {
		try {
			this.repositorio = new File("cliente.bin");
			escreve();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void ler(){
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(repositorio));
			lista = (List<Cliente>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void escreve() throws IOException, FileNotFoundException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(repositorio));
		oos.writeObject(lista);
	}


	public boolean existe(Serializable chave) throws Exception {
		ler();
		escreve();
		return false;
	}

	public void inserir(Cliente entidade) throws Exception {
		ler();
		lista.add(entidade);
		escreve();
	}

	public void atualizar(Cliente entidade) throws Exception {
		ler();
		int index = lista.indexOf(procurar(entidade.getId()));
		lista.set(index, entidade);
		escreve();
	}

	public void remover(Serializable chave) throws Exception {
		ler();
		lista.remove(procurar(chave));
		escreve();
	}

	public Cliente procurar(Serializable chave) throws Exception {
		ler();
		for (Cliente cliente : lista) {
			if (chave.equals(cliente.getId())){
				return cliente;
			}
		}
		escreve();
		return null;
	}

	public Cliente[] buscarTodos() throws Exception {
		ler();
		Cliente[] retorno = lista.toArray(new Cliente[lista.size()]);
		escreve();
		return retorno;
	}

}
