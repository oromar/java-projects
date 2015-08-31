package br.com.qualiti.delivery.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.com.qualiti.delivery.entidades.Cliente;
import br.com.qualiti.delivery.util.Util;

public class FileMain {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("oromar");
		cliente.setCelular("86796294");
		cliente.setCpf("123");
		salvarCliente(cliente, "object.dat");
		cliente = recuperarCliente("object.dat");
	}
	
	public static void salvarCliente(Cliente cliente, String arquivo){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(arquivo)));
			oos.writeObject(cliente);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			Util.log(e.getMessage(), Util.LOG_TYPE_ERROR);
			e.printStackTrace();
		}
	}

	public static Cliente recuperarCliente(String arquivo){
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(arquivo)));
			Cliente cliente = (Cliente) ois.readObject();
			System.out.println(cliente);
			ois.close();
			return cliente;
		} catch (Exception e) {
			Util.log(e.getMessage(), Util.LOG_TYPE_ERROR);
			e.printStackTrace();
		}
		return null;
	}
	
}
