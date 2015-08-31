package resources;

import br.com.biblia.entidades.Versiculo;

/*
 *
 * Em : 04/07/2015 - 00:59:56
 * 
 * */

public class VersiculoDAO extends AbstractDAO<Versiculo> {

	public VersiculoDAO() {
		super();
		setClazz(Versiculo.class);
	}
}
