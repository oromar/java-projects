package resources;

import br.com.biblia.entidades.Testamento;

/*
 *
 * Em : 04/07/2015 - 00:55:43
 * 
 * */

public class TestamentoDAO extends AbstractDAO<Testamento> {

	public TestamentoDAO() {
		super();
		setClazz(Testamento.class);
	}
}
