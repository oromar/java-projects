package br.com.qualiti.delivery.negocio;

import br.com.qualiti.delivery.entidades.Pedido;
import br.com.qualiti.delivery.interfaces.RepositorioHibernate;

public class CadastroPedido extends CadastroGenerico<Pedido> {

	public CadastroPedido(RepositorioHibernate<Pedido> repositorio) {
		super(repositorio);
	}
}
