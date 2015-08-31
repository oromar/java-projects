package br.com.qualiti.delivery.negocio;

import java.io.Serializable;

import br.com.qualiti.delivery.entidades.Cliente;
import br.com.qualiti.delivery.interfaces.RepositorioHibernate;

public class CadastroCliente extends CadastroGenerico<Cliente> {

	public CadastroCliente(RepositorioHibernate<Cliente> repositorio) {
		super(repositorio);
	}
}
